package Steelcase.SikuliDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import cucumber.api.CucumberOptions;

import Steelcase.SikuliDemo.Utilities.Constants;
import Steelcase.SikuliDemo.Utilities.Report;





@CucumberOptions(features = "Feature")	
public class SikuliDemo_TestNG 
{
	private static WebDriver driver = null;
	
	
	@BeforeTest
	public static void beforeTest(){
		
		Report.createReport(Constants.reportPath);
		Report.startTest("SikuliDemo_TestNG");
		
		System.setProperty("webdriver.chrome.driver", Constants.path_chromedriver);
        driver = new ChromeDriver();
        driver.get(Constants.URL_qa);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Report.logInfo("Opening browser");
		System.out.println("Opening Browser...");
		
		
	}
	
	

	
	@Test
	public static void main() throws Exception, FindFailed, InterruptedException {
		
		Report.logInfo("Start test case");
		Report.logInfo("Scanning screen");
		
//		 We have to create Screen class object to access the methods
		Screen screen = new Screen();
		
		Report.logInfo("Getting patterns");
//		Specify the path 
		Pattern imgCobi = new Pattern("\\image_repository\\cobi.png");
		Pattern imgCobiBlue = new Pattern("\\image_repository\\img_CobiBlue.png");
		Pattern imgCobiRed = new Pattern("\\image_repository\\imgCobiRed.png");
		
    	
    	try {
    		WebElement searchField = driver.findElement(By.id("search-field"));
    		//search cobi 
    		Report.logInfo("Searching for cobi");
    		System.out.println("Searching for cobi...");
    		searchField.sendKeys("Cobi");
    		searchField.submit();
    		
    		//click on Cobi link 
/*
    		System.out.println("Click on cobi link...");    		
    		driver.findElement(By.partialLinkText("cobi")).click();
    		driver.findElement(By.linkText("cobi")).click();
    		driver.findElement(By.xpath("//*[@id=\"collateral-tabs\"]/dd[1]/div/div[2]/ul/li[1]/h2/a")).click();
*/  		
    		//click on Cobi image
    		Report.logInfo("Click on Cobi");
    		System.out.println("Click on Cobi image...");
//    		driver.findElement(By.xpath("//*[@id=\"collateral-tabs\"]/dd[1]/div/div[2]/ul/li[1]/div[1]/a/img")).click();
    		driver.manage().timeouts().wait(3);
    		if(screen.exists(imgCobi) != null){
    			Report.logPass("Cobi image found");
    			System.out.println("Cobi image found...");	
    			screen.click(imgCobi);    		
    		}
    		else{
    			Report.logFail("Cobi image not found");
    			Report.getScreenshot();
    			System.out.println("Cobi image not found");
   		
    			
    		}
    		
    		driver.manage().timeouts().wait(3);
    		WebElement CobiRed_lnk= driver.findElement(By.xpath(Constants.cobiRed_xpath));
    		WebElement CobiBlue_lnk = driver.findElement(By.xpath(Constants.cobiBlue_xpath));
    		
    		
//    		click on mini red cobi image
//    		if the red cobi image exist in the current visible screen 
    		Report.logInfo("Click on red cobi thumbnail");
    		System.out.println("Click on red cobi thumbnail...");
    		CobiRed_lnk.click();
    		driver.manage().timeouts().wait(3);
    		if(screen.exists(imgCobiRed) != null){
    			Report.logPass("Red cobi image found");
    			System.out.println("Red cobi image found...");
    		}
    		else{
    			Report.logFail("ERROR: Red cobi image not found");
    			System.out.println("ERROR: Red cobi image not found...");
    			Report.getScreenshot();
    		}
    		
//    		click on mini blue cobi image
//    		if the blue cobi image exist in the current visible screen 
    		
    		Report.logInfo("Click on blue cobi thumbnail");   
    		System.out.println("Click on blue cobi thumbnail...");
    		CobiBlue_lnk.click();
    		driver.manage().timeouts().wait(3);
    		if(screen.exists(imgCobiBlue) != null){
    			Report.logPass("Blue cobi image found");
    			System.out.println("Blue cobi image found...");
    		}
    		else{
    			Report.logFail("ERROR: blue cobi image not found");
    			System.out.println("ERROR: Blue cobi image not found...");
    			Report.getScreenshot();
    		}
    		
    	
    	}
    	catch (Exception e){
    		Report.logFatal("An unexpected error occurred: " + e.getMessage());
    		Report.getScreenshot();
    		Constants.takeScreenshot();
    		System.out.println("ERROR: " + e.getMessage());
    		
    	}
    	
	}
	
	
	@AfterTest
	public static void afterTest(){
		Report.endTest();
		System.out.println("Test finished...");
//		driver.quit();
	}
	
	
}
