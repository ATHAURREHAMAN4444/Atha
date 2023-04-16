package com.crm.BookTicket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("");
		WebElement month = driver.findElement(By.xpath(""));
		Select sel=new Select(month);
		List<WebElement> months = sel.getOptions();
		for(WebElement ele:months) {
			String mon = ele.getText();
			if(mon.equalsIgnoreCase("june")) {
				sel.selectByVisibleText(ele.getText());
				FileInputStream fis=new FileInputStream("");
				Properties pobj=new Properties();
				pobj.load(fis);
				pobj.setProperty("month", mon);

				//				Workbook wb=WorkbookFactory.create(fis);
				//				Sheet sheet = wb.getSheet("");
				//				Row row = sheet.getRow(0);
				//				Cell cel = row.createCell(0);
				//				cel.setCellValue(mon);
				//				FileOutputStream fout=new FileOutputStream("./src/");
				//				wb.write(fout);
				//				wb.close();
				byte[] Month=mon.getBytes();
				FileOutputStream fout=new FileOutputStream("./src/");
				fout.write(Month);
				break;
			}
		}


	}

}
