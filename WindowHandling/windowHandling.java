package selenium;

import java.time.Year;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver","C:/Program Files/selenium/chromeDriver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.demo.guru99.com/popup.php");
		
		String firstwindow=driver.getWindowHandle();//first window
		String firstWindowUrl=driver.getCurrentUrl();//first url
		
		System.out.println("My first window:"+firstWindowUrl);
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	
	Set<String> windowAllWindows=driver.getWindowHandles(); 
		for(String windows:windowAllWindows){
			driver.switchTo().window(windows);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name=emailid]")).sendKeys("haluk@gmail.com");	
		
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		System.out.println("My second window url:"+driver.getCurrentUrl());
		
		driver.close(); //close window
		
		driver.switchTo().window(firstwindow);
		
		System.out.println("Actual window url:"+driver.getCurrentUrl());
		
		Thread.sleep(2000);
		driver.quit();//quit from system
		

		
	}

}
