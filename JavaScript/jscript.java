import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class jscript {

WebDriver driver;
    @BeforeClass
    public void setup () {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/selenium/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/V4/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
@Test(enabled = false)
    public void  test(){
    long start_time = System.currentTimeMillis();
    JavascriptExecutor js=(JavascriptExecutor)driver;

    //Call executeAsyncScript() method to wait for 5 seconds
    js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

    //Get the difference (currentTime - startTime)  of times.
    System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
}
@Test
    public void  test3(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //Fetching the Domain Name of the site. Tostring() change object to name.
        String DomainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain name of the site = "+DomainName);

        //Fetching the URL of the site. Tostring() change object to name
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the site = "+url);

        //Method document.title fetch the Title name of the site. Tostring() change object to name
        String TitleName = js.executeScript("return document.title;").toString();
        System.out.println("Title of the page = "+TitleName);


        //Navigate to new Page i.e to generate access page. (launch new url)
        js.executeScript("window.location = 'http://demo.guru99.com/'");
        driver.findElement(By.name("emailid")).sendKeys("kjhkj");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
}
