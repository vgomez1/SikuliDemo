package Steelcase.SikuliDemo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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






@CucumberOptions(features = "Feature")	
public class SikuliDemo_TestNG 
{
	private static WebDriver driver = null;
	
	
	@BeforeTest
	public static void beforeTest(){
		System.setProperty("webdriver.chrome.driver", Constants.path_chromedriver);
        driver = new ChromeDriver();
        driver.get(Constants.URL_qa);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 
		System.out.println("Opening Browser...");
	}
	
	

	
	@Test
	public static void main() throws Exception, FindFailed, InterruptedException {
		

//		 We have to create Screen class object to access the methods
		Screen screen = new Screen();
		 
//		Specify the path 
		Pattern imgCobi = new Pattern("\\image_repository\\cobi.png");
		Pattern imgCobiBlue = new Pattern("\\image_repository\\img_CobiBlue.png");
		Pattern imgCobiRed = new Pattern("\\image_repository\\imgCobiRed.png");
		
    	
    	try {
    		WebElement searchField = driver.findElement(By.id("search-field"));
    		//search cobi 
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
    		System.out.println("Click on Cobi image...");
//    		driver.findElement(By.xpath("//*[@id=\"collateral-tabs\"]/dd[1]/div/div[2]/ul/li[1]/div[1]/a/img")).click();
    		if(screen.exists(imgCobi) != null){
    			System.out.println("Cobi image found...");	
    			screen.click(imgCobi);    		
    		}
    		else{
    			Constants.takeScreenShot(driver);
    			System.out.println("Cobi image not found");
   		
    			
    		}
    		
    		WebElement CobiRed_lnk= driver.findElement(By.xpath("//*[@id=\"product-image-0\"]/img"));
    		WebElement CobiBlue_lnk = driver.findElement(By.xpath("//*[@id=\"product-image-9999\"]/img"));
    		
    		
//    		click on mini red cobi image
//    		if the red cobi image exist in the current visible screen 
    		System.out.println("Click on mini red cobi image...");
    		CobiRed_lnk.click();

    		
    		if(screen.exists(imgCobiRed) != null){
    			System.out.println("Red cobi image found...");
    		}
    		else{
    			System.out.println("ERROR: Red cobi image not found...");
    			Constants.takeScreenShot(driver);
    		}
    		
//    		click on mini blue cobi image
//    		if the blue cobi image exist in the current visible screen 
    		System.out.println("Click on mini blue cobi image...");
    		CobiBlue_lnk.click();
    		    		
    		if(screen.exists(imgCobiBlue) != null){
    			System.out.println("Blue cobi image found...");
    		}
    		else{
    			System.out.println("ERROR: Blue cobi image not found...");
    			Constants.takeScreenShot(driver);
    		}
    		
    	
    	}
    	catch (Exception e){
    		Constants.takeScreenShot(driver);
    		System.out.println("ERROR: " + e.getMessage());
    		
    	}
    	
	}
	
	
	@AfterTest
	public static void afterTest(){
		System.out.println("Test finished...");
//		driver.quit();
	}
	
	
}
