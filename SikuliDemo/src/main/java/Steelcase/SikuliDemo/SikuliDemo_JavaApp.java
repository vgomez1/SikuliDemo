package Steelcase.SikuliDemo;



import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.api.Region;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Pattern;

 
import org.sikuli.script.Screen;

public class SikuliDemo_JavaApp 
{
	public static void main(String[] args) throws FindFailed, InterruptedException {
		 
		// We have to create Screen class object to access method
		 
		Screen screen = new Screen();
		 
		// Create object of Pattern class and specify the images path
		 
		Pattern imgLoginRegister = new Pattern("\\image_repository\\lnk_LoginRegister.PNG");
		Pattern imgRegisterNow = new Pattern("\\image_repository\\lnk_RegisterNow.PNG"); 
		Pattern imgFirstName = new Pattern("\\image_repository\\input_FirstName.PNG"); 
		Pattern imgLastName = new Pattern("\\image_repository\\input_LastName.PNG");
		Pattern imgEmail = new Pattern("\\image_repository\\input_Email.PNG");
		Pattern imgPostalCode = new Pattern("\\image_repository\\input_PostalCode.PNG");
		Pattern imgPassword = new Pattern("\\image_repository\\input_Password.PNG");
		Pattern imgPwdConfirm = new Pattern("\\image_repository\\input_PwdConfirm.PNG");
		Pattern imgSubmit = new Pattern("\\image_repository\\btn_Submit.PNG");
		Pattern imgCreateAccount = new Pattern("\\image_repository\\header_CreateAccount.PNG");
		
		 
		System.setProperty("webdriver.chrome.driver", "C:\\workspaceV\\Libraries\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qastore.steelcase.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 
		System.out.println("Opening Browser...");
        System.out.println("Looking for LOGIN button...");
        
    	screen.wait(imgLoginRegister, 10);
		 
		// using screen object we can call click method which will accept image path and will perform //action
		 
		// This will click on Login/Registration image on home page
		screen.click(imgLoginRegister);
//		driver.findElement(By.partialLinkText("REGISTER")).click();
        System.out.println("Clicking Login/Register...");
        
        screen.click(imgRegisterNow);
//        driver.findElement(By.partialLinkText("Register Now")).click();
        System.out.println("Clicking on Register Now...");
        
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waiting to load registration page...");
       
//        String title = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div[2]/div[4]/div/div/div[2]/div/h1")).getText();
        
        if (screen.exists(imgCreateAccount) != null){
        	System.out.println("\nRegistration page loaded succesfully!!!");
        	
        	System.out.println("Filling down contact details...");
        	//Filling down contact info
        	screen.type(imgFirstName, "Automated");
        	screen.type(imgLastName, "Test");
        	screen.type(imgEmail, "TestID" + DateTime.now().getYear() 
        			+ DateTime.now().getDayOfMonth() + DateTime.now().getDayOfWeek()
        			+ DateTime.now().getHourOfDay() + DateTime.now().getMinuteOfHour()
        			+ "@steelcase.com");
        	screen.type(imgPostalCode, "12345");
        	screen.type(imgPassword.targetOffset(0, 25), "Steelcase1");
        	screen.type(imgPwdConfirm, "Steelcase1");
        	
        	
        	//scrolling down
        	JavascriptExecutor jse = (JavascriptExecutor)driver;
        	jse.executeScript("window.scrollBy(0,250)", "");
        	
        	//click on Submit
        	System.out.println("Clicking submit...");
        	screen.click(imgSubmit);
        	       	
        	
        	
        }
        else{
        	System.out.println("\nCouldn't find registration page :(");
        	driver.quit();
        }
        
		 
		}
}
