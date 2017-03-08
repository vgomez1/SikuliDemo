package Steelcase.SikuliDemo.Utilities;


import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
 
public class Report {
	
	private static ExtentReports report = null;
	private static ExtentTest logger = null;
	
	public static void createReport(String filePath){
		report = new ExtentReports(filePath, true, NetworkMode.ONLINE);
		report.addSystemInfo("Environment","QA");
	}
	
	
	public static void startTest(String title){
		logger = report.startTest(title);
	}
	
	public static void logInfo(String details){
		logger.log(LogStatus.INFO, details);
	}
	
	public static void logFail(String details){
		logger.log(LogStatus.FAIL, details);
	}
	
	public static void logFatal(String details){
		logger.log(LogStatus.FATAL, details);	
	}
	
	public static void logPass(String details){
		logger.log(LogStatus.PASS, details);
	}
	
	public static void logSkip(String details){
		logger.log(LogStatus.SKIP, details);
	}
	
	public static void logWarning(String details){
		logger.log(LogStatus.WARNING, details);
	}
	
	public static void logUnknown(String details){
		logger.log(LogStatus.UNKNOWN, details);
	}
	
	public static void getScreenshot() throws HeadlessException, AWTException, IOException
	{
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			// Now you can do whatever you need to do with it, for example copy somewhere
//			FileUtils.copyFile(scrFile, new File("C:\\workspaceV\\SikuliDemo\\screnshots\\screenshot.png"));
			
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(Constants.screenshotsPath));
		
			String screenshot = logger.addScreenCapture(Constants.screenshotsPath);
			logger.log(LogStatus.INFO, "screenshot:", screenshot);
	}
	
	public static void endTest(){
		report.endTest(logger);
		report.flush();
		
	}
}
