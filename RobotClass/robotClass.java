import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class robotClass {

    static WebDriver driver;

    public static void main(String[] args) throws AWTException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Program Files/selenium/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/V4/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Robot robot=new Robot();
      WebElement userId= driver.findElement(By.name("uid"));
        WebElement password= driver.findElement(By.name("password"));

        Thread.sleep(2000);

        robot.mouseMove(630, 430);  //mouse belirttiğimiz kordinata gidiyor
       robot.delay(1500);            //gecikme saglıyor

         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);  //mouse sol tusuna basıyor
        Thread.sleep(2000);
         robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);   //mouse serbest bırakıyor
        Thread.sleep(2000);
         userId.sendKeys("haluk");
        Thread.sleep(2000);

         robot.keyPress(KeyEvent.VK_TAB);   //tab a basıyor
        Thread.sleep(2000);

         robot.mouseMove(630,465);
       // robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);  mouse sag tusuna basıyor.
        Thread.sleep(2000);
       // robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        Thread.sleep(2000);
         password.sendKeys("123874");
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        driver.close();
    }
}
