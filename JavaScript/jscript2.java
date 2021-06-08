import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class jscript2 {

    WebDriver driver;
    @BeforeClass
    public void setup (){
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/selenium/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://moneyboats.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void h() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Maximize window
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //Vertical scroll down by 600  pixels
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
        //her ikiside aşağı kaydırıyor sayfayı
        WebElement down=driver.findElement(By.cssSelector(".widgettitle"));
        js.executeScript("arguments[0].scrollIntoView();",down);


    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
