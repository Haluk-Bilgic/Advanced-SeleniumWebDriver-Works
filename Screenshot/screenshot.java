import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class screenshot {
WebDriver driver;

    @BeforeClass
    public  void setup(){

        System.setProperty("webdriver.chrome.driver", "C:/Program Files/selenium/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/V4/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test() throws IOException {
         takeSnapShot(driver,"C:\\Users\\casper\\IdeaProjects\\calisma\\testim.png");
    }
    public  void takeSnapShot(WebDriver driver,String filePath) throws IOException {

        TakesScreenshot screenshot=((TakesScreenshot)driver);

        File srcfile=screenshot.getScreenshotAs(OutputType.FILE);

        File destFile=new File(filePath);

        FileUtils.copyFile(srcfile,destFile);
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
