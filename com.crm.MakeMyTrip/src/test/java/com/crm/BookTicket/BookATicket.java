package com.crm.BookTicket;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.ObjectRepository.HomePage;
import com.crm.genericUtility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookATicket {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		String fromCity = eLib.getDataFromExcel("PlacesName", 1, 0);
		String toCity = eLib.getDataFromExcel("PlacesName", 2, 1);
		String departureDay = eLib.getIntegerValueFromColumn("PlacesName", 20, 2);
		String departureMonth = eLib.getDataFromExcel("PlacesName", 10, 3);
		String departureYear = eLib.getIntegerValueFromColumn("PlacesName", 1, 4);
		String returnDay = eLib.getIntegerValueFromColumn("PlacesName", 20, 2);
		String returnMonth = eLib.getDataFromExcel("PlacesName", 11, 3);
		String returnYear = eLib.getIntegerValueFromColumn("PlacesName", 1, 4);

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		HomePage home=new HomePage(driver);
		home.getNotificationLkp().click();
		driver.switchTo().defaultContent();
		home.getFrom().sendKeys(fromCity);
		List<WebElement> from = home.getFromPlaces();
		for(int i=0;i<from.size();i++) {
			if(from.get(i).getText().equals(fromCity)) {
				from.get(i).click();
				break;
			}
		}
		home.getAd().click();
		home.getTo().sendKeys(toCity);
		List<WebElement> to = home.getToPlaces() ;

		for(int i=0;i<to.size();i++) {
			if(to.get(i).getText().equals(toCity)) {
				to.get(i).click();
				break;
			}
		}
		home.getDepartureDate().click();
		try {
			List<WebElement> departureDate = driver.findElements(By.xpath("//div[text()='"+departureMonth+" "+departureYear+"']/../following-sibling::div[@class='DayPicker-Body']//div[@role='gridcell']"));

			for(int i=0;i<departureDate.size();i++) {
				if(departureDate.get(i).getText().contains(departureDay)) {
					departureDate.get(i).click();
					break;
				}
			}
		}
		catch(Exception e) {
			home.getNextMonthLkp().click();
		}
		home.getReturnText().click();
		try {
			List<WebElement> returnDate = driver.findElements(By.xpath("//div[text()='"+returnMonth+"']//span[text()='"+returnYear+"']/../../following-sibling::div[@class='DayPicker-Body']//div[@role='gridcell']"));
			for(int i=0;i<returnDate.size();i++) {
				if(returnDate.get(i).getText().contains(returnDay)) {
					returnDate.get(i).click();
					break;
				}
			}
		}
		catch(Exception e) {
			home.getNextMonthLkp().click();
		}
		home.getSearch().click();
		//Thread.sleep(1000);
		try {
			home.getPopularFilters().click();
			//Thread.sleep(1000);
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			driver.findElement(By.xpath("//button[text()='Book Now']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Book Now']"))));
			home.getDepartSaver().click();
			home.getReturnSaver().click();
			home.getContinueButton().click();
		}
		catch(Exception e) {
			driver.findElement(By.xpath("//span[@class='multifareCross']")).click();
			home.getPopularFilters().click();
			home.getPopularFilters().click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			driver.findElement(By.xpath("//button[text()='Book Now']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Book Now']"))));
			home.getDepartSaver().click();
			home.getReturnSaver().click();
			home.getContinueButton().click();
		}
		Set<String> wIds = driver.getWindowHandles();
		for(String wid:wIds) {
			driver.switchTo().window(wid);
		}
		//driver.quit();

	}

}
