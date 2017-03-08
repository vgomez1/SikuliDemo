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


public class Constants {
	public static final String path_chromedriver = "C:\\workspaceV\\Libraries\\chromedriver_win32\\chromedriver.exe";
	
	//web page url 	
	public static final String URL = "https://store.steelcase.com";	
	public static final String URL_qa = "https://qastore.steelcase.com";	
	//credentials
	public static final String loginEmail = "sa_testid@steelcase.com";
	public static final String loginPwd = "Steelcase1";
	
	//report path
	public static final String reportPath = "./Reports/report.htm";
	public static final String screenshotsPath = "\\screenshots\\screenshot.png";
	
	//images path 
	public static final String path_imgLoginRegister = "\\image_repository\\lnk_LoginRegister.PNG";
	public static final String path_imgRegsiterNow = "\\image_repository\\lnk_RegisterNow.PNG";
	public static final String path_imgFirstName = "\\image_repository\\input_FirstName.PNG";
	public static final String path_imgLastName = "\\image_repository\\input_LastName.PNG";
	public static final String path_imgEmail = "\\image_repository\\input_Email.PNG";
	public static final String path_imgPostalCode = "\\image_repository\\input_PostalCode.PNG";
	public static final String path_imgPassword = "\\image_repository\\input_Password.PNG";
	public static final String path_imgPwdConfirm = "\\image_repository\\input_PwdConfirm.PNG";
	public static final String path_imgSubmit = "\\image_repository\\btn_Submit.PNG";
	public static final String path_imgCreateAccount = "\\image_repository\\header_CreateAccount.PNG";
	
	
	public static final String path_imgCobiBlue = "\\image_repository\\img_CobiBlue.png";
	public static final String path_imgCobiRed = "\\image_repository\\img_CobiRed.png";
	public static final String path_imgCobi = "\\image_repository\\cobi.png";
	public static final String path_imgCobiWhite = "\\image_repository\\img_CobiWhite.PNG";
	
	public static void takeScreenshot() throws HeadlessException, AWTException, IOException{
		{
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			// Now you can do whatever you need to do with it, for example copy somewhere
//			FileUtils.copyFile(scrFile, new File("C:\\workspaceV\\SikuliDemo\\screnshots\\screenshot.png"));
		
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(screenshotsPath));
		}
	}
	
	
}
