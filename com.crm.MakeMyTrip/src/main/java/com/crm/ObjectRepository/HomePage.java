package com.crm.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public  HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='webklipper-publisher-widget-container-notification-close-div']")
	private WebElement notificationLkp;
	
	@FindBy(id="fromCity")
	private WebElement from;
	
	@FindBy(xpath="//ul[@role='listbox' and @class='react-autosuggest__suggestions-list']/descendant::p[@class='font14 appendBottom5 blackText']")
	private List<WebElement> fromPlaces;
	
	@FindBy(xpath="//div[@class='langCard  fixedCard bounceAni']//span[@class='langCardClose']")
	private WebElement ad;
	
	@FindBy(xpath="//input[@placeholder='To']")
	private WebElement to;
	
	@FindBy(xpath="//ul[@role='listbox' and @class='react-autosuggest__suggestions-list']/descendant::p[@class='font14 appendBottom5 blackText']")
	private List<WebElement> toPlaces;
	
	
	@FindBy(xpath="//p[@data-cy='departureDate']")
	private WebElement departureDate;
	
	@FindBy(xpath="//span[@aria-label='Next Month']")
	private WebElement nextMonthLkp;
	
	@FindBy(xpath="//a[text()='Search']")
	private WebElement search;
	
	@FindBy(xpath="//p[text()='Popular Filters']/../descendant::span[@title='IndiGo']")
	private WebElement popularFilters;
	
	@FindBy(xpath="//button[text()='Book Now']")
	private WebElement bookNow;
	
	@FindBy(xpath="//span[text()='DEPART']/../../following-sibling::div/descendant::p[text()='Saver']")
	private WebElement departSaver;
	
	@FindBy(xpath="//span[text()='RETURN']/../../following-sibling::div/descendant::p[text()='Saver']")
	private WebElement returnSaver;
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//p[@data-cy='returnDefaultText']")
	private WebElement returnText;

	public WebElement getReturnText() {
		return returnText;
	}

	public WebElement getNotificationLkp() {
		return notificationLkp;
	}

	public WebElement getFrom() {
		return from;
	}

	public List<WebElement> getFromPlaces() {
		return fromPlaces;
	}

	public WebElement getAd() {
		return ad;
	}

	public WebElement getTo() {
		return to;
	}

	public List<WebElement> getToPlaces() {
		return toPlaces;
	}

	public WebElement getDepartureDate() {
		return departureDate;
	}

	public WebElement getNextMonthLkp() {
		return nextMonthLkp;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getPopularFilters() {
		return popularFilters;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public WebElement getDepartSaver() {
		return departSaver;
	}

	public WebElement getReturnSaver() {
		return returnSaver;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
	
	 
	

}
