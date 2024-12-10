package week5.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Testcase1_TestNGAnnotations extends ProjectSpecificMethod {

	@Test
	public void createName() {
		
		//Click on toggle icon
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		 
		//Click View All and click Legal Entities from App Launcher
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='App Launcher']")));
        WebElement legalEntities = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", legalEntities);
		legalEntities.click();
		
		//Click on the Dropdown icon in the legal Entities tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Legal Entities')]/following::a")));
        WebElement dropDown = driver.findElement(By.xpath("//span[contains(text(),'Legal Entities')]/following::a"));
        WebElement more = driver.findElement(By.xpath("//span[text()='More']"));
        WebElement legalEntity = driver.findElement(By.xpath("//span[text()='More']/following::span[text()='Legal Entities']"));
        
        if(dropDown.isDisplayed()) {
        	
        	dropDown.click();
        }else {
        	more.click();
        	legalEntity.click();
        	dropDown.click();
        }
        
        //Click on New Legal Entity
        WebElement newLegalEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
        js.executeScript("arguments[0].click();",newLegalEntity);
        WebElement name = driver.findElement(By.xpath("//input[@name='Name']"));
        name.sendKeys("Vishali Mahadevan");
        WebElement saveBtn = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
        saveBtn.click();
		
	}

}
