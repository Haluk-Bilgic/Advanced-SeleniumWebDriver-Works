import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFrame {

static WebDriver driver;
@BeforeClass
    public void setup (){
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/selenium/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1() throws InterruptedException {
        driver.switchTo().frame("a077aa5e");
        Thread.sleep(1000);
        driver.findElement(By.xpath("html/body/a/img")).click();
    }
    @Test
    public void test2() {
        int size = driver.findElements(By.tagName("iframe")).size();
        for (int i = 0; i < size; i++) {
            driver.switchTo().frame(i);
            int total = driver.findElements(By.xpath("html/body/a/img")).size();
            System.out.println(size);
            driver.switchTo().parentFrame();

        }
    }
    @AfterClass
    public void tearDown(){
    driver.quit();
    }

}
