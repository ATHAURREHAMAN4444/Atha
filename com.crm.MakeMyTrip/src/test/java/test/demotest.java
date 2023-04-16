package test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demotest {
	@Test
	public  void test() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demoblaze.com/");
		List<WebElement> mobile = driver.findElements(By.xpath("//div[@class='card h-100']/descendant::a[@class='hrefch']"));
		//System.out.println(mobile);
		String text=mobile.get(3).getText();
		mobile.get(3).click();
		WebElement title = driver.findElement(By.xpath("//div[@class='row']/descendant::h2[@class='name']"));
		String eleText = title.getText();
		Assert.assertEquals(text,eleText);
//		if(text.equals(eleText)) {
//			System.out.println("element is matching");
//		}
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		Robot robot=new Robot();	
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//driver.switchTo().alert().accept();
		driver.findElement(By.id("cartur")).click();
		driver.quit();	

	}

}
