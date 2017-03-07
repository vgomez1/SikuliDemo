package Steelcase.SikuliDemo;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Steelcase.SikuliDemo.Utilities.Constants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SikuliDemo_Cucumber {
	
	private static WebDriver driver = null;
	private static Screen screen = new Screen();
	private static Pattern imgCobi = new Pattern(Constants.path_imgCobi);
	private static Pattern imgCobiBlue = new Pattern(Constants.path_imgCobiBlue);
	private static Pattern imgCobiRed = new Pattern(Constants.path_imgCobiRed);
	private static Pattern imgCobiWhite = new Pattern(Constants.path_imgCobiWhite);

	
	@Given("^steelcase store home page$")
	public void steelcase_store_home_page() {
		System.setProperty("webdriver.chrome.driver", Constants.path_chromedriver);
        driver = new ChromeDriver();
        driver.get(Constants.URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Opening Browser...");
	}

	@When("^type cobi on the search field and press Enter$")
	public void type_cobi_on_the_search_field_and_press_Enter() {
	   	
	    	
	    		WebElement searchField = driver.findElement(By.id("search-field"));
	    		System.out.println("Searching for cobi...");
	    		searchField.sendKeys("Cobi");
	    		searchField.submit();
	    	
	    	
	}

	@Then("^the catalog page should appear showing a blue cobi chair in the first option$")
	public void the_catalog_page_should_appear_showing_a_blue_cobi_chair_in_the_first_option() throws IOException, HeadlessException, AWTException {
		if(screen.exists(imgCobi) != null){
			System.out.println("Cobi image found...");
		}
		else{
			System.out.println("ERROR: Cobi image not found...");
			Constants.takeScreenShot(driver);
		}
				
	}

	@Given("^a user in the catalog page after searching for cobi chair$")
	public void a_user_in_the_catalog_page_after_searching_for_cobi_chair() {
		
	}

	@When("^click on cobi link or cobi image \\(if available\\)$")
	public void click_on_cobi_link() throws Throwable {
		System.out.println("Click on Cobi image...");
//		driver.findElement(By.xpath("//*[@id=\"collateral-tabs\"]/dd[1]/div/div[2]/ul/li[1]/div[1]/a/img")).click();
		screen.click(imgCobi);    		
		
	}

	@Then("^the user is redirected to the cobi chair page$")
	public void the_user_is_redirected_to_the_cobi_chair_page() throws Throwable{
		screen.wait(imgCobiWhite, 10);
		if(screen.exists(imgCobiWhite) != null){
			System.out.println("White cobi image found...");
		}
		else{
			System.out.println("ERROR: White cobi image not found...");
			Constants.takeScreenShot(driver);
		}
	}

	@Given("^a user in the cobi chair page$")
	public void a_user_in_the_cobi_chair_page() throws Throwable {
		
	
	}


@When("^clicking on the thumbnail of red cobi$")
public void clicking_on_the_thumbnail_of_red_cobi() throws Throwable {
	WebElement CobiRed_lnk= driver.findElement(By.xpath("//*[@id=\"product-image-0\"]/img"));

//	click on mini red cobi image
//	if the red cobi image exist in the current visible screen 
	System.out.println("Click on mini red cobi image...");
	CobiRed_lnk.click();
	
}


@Then("^a bigger image of a red cobi appears$")
public void a_bigger_image_of_a_red_cobi_appears() throws Throwable {
	if(screen.exists(imgCobiRed) != null){
		System.out.println("Red cobi image found...");
	}
	else{
		System.out.println("ERROR: Red cobi image not found...");
		Constants.takeScreenShot(driver);
	}
}

@When("^clicking on the thumbnail of blue cobi$")
public void clicking_on_the_thumbnail_of_blue_cobi() throws Throwable {
	WebElement CobiBlue_lnk = driver.findElement(By.xpath("//*[@id=\"product-image-9999\"]/img"));
		
//	click on mini blue cobi image
//	if the blue cobi image exist in the current visible screen 
	System.out.println("Click on mini blue cobi image...");
	CobiBlue_lnk.click();

	
}

@Then("^a bigger image of blue cobi appears respectively$")
public void a_bigger_image_of_blue_cobi_appears_respectively() throws Throwable {
	if(screen.exists(imgCobiBlue) != null){
		System.out.println("Blue cobi image found...");
	}
	else{
		System.out.println("ERROR: Blue cobi image not found...");
		Constants.takeScreenShot(driver);
	}
}

}
