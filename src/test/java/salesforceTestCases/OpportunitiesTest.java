package salesforceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import salesforce.util.BaseClass;


public class OpportunitiesTest extends BaseClass{
	
	@BeforeClass
	public void initialize() {
		init("chrome");
		driver.get("https://ap4.lightning.force.com/lightning/page/home");
	}
	
	@Test(priority=1)
	public void goToOpportunitiesPage() {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("madhav.gaikwad@acc.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("p@sword123");	
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		WebElement Opptylink = driver.findElement(By.xpath("//*[@title='Opportunities']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Opptylink);
	}
	
	@Test(priority=2)
	public void createNewOpportunity() {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		Actions act = new Actions(driver);
		//Click on New Opportunity
		driver.findElement(By.xpath("//*[@id='brandBand_1']/div/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/ul/li/a/div")).click();
		//TYpe Oppty Name
		driver.findElement(By.xpath("//*[@class='slds-form-element__control']//*[text()='Opportunity Name']/..//following::input[1]")).sendKeys("TestOpportunityTO1");
		//Select a Close Date
		driver.findElement(By.xpath("//*[@class='slds-form-element__control']//*[text()='Opportunity Name']/..//following::input[2]")).click();
		driver.findElement(By.xpath("//div/div[2]/table/tbody/tr[5]/td[5]/span")).click();
		//Select a Stage
		driver.findElement(By.xpath("//*[@class='uiInput uiInput--default']/span/span[text()='Stage']/..//following::div[1]")).click();
		driver.findElement(By.xpath("//*[@class='select-options']/ul/li[4]/a")).click();
		//Save Opportunity
		driver.findElement(By.xpath("//div/div/div[2]/div/div/button[3]/span")).click();
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}