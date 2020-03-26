package com.naukri.testbase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.naukri.excel.Excel_utiliy;



public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	Excel_utiliy eu = new Excel_utiliy();

	public Testbase() {

		prop = new Properties();

		try {


			String propertyFilePath="E:\\eclipse-workspace\\GITHUB\\SrikanthKomirelly844863_naukri\\naukrisrikanth\\src\\test\\resources\\testdata\\config.properties";

			BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
			prop.load(reader);

		} catch (Exception e) {

			e.printStackTrace();
		}	
	}

	public static void initialization() {
	
		

		
		//String browserName = prop.getProperty("browser");
		String browserName = "chrome";
		if(browserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\eclipse-workspace\\GITHUB\\SrikanthKomirelly844863_naukri\\naukrisrikanth\\src\\test\\resources\\driver\\chromedriver.exe");

			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){

			System.setProperty("webdriver.gecko.driver", "E:\\eclipse-workspace\\GITHUB\\SrikanthKomirelly844863_naukri\\naukrisrikanth\\src\\test\\resources\\driver\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);

	}

	public void url()
	{

		
		//driver.get(prop.getProperty("url"));
		driver.get("https://www.naukri.com/");


		String windowTitle= getCurrentWindowTitle();
		String mainWindow = getMainWindowHandle(driver);
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Assert.assertTrue(windowTitle.contains("Jobs - Recruitment"));
	}

	public String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}

	//To close all the other windows except the main window.
	public static boolean closeAllOtherWindows(String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}

		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}



	public void login() throws IOException, InterruptedException
	{
		for(int i=1;i<=2;i++)
	
		{

			driver.findElement(By.xpath("//*[@id=\"login_Layer\"]/div")).click();
			driver.findElement(By.id("eLoginNew")).sendKeys(eu.excel_email(i));
			driver.findElement(By.id("pLogin")).sendKeys(eu.excel_password(i));
			driver.findElement(By.xpath("//*[@id=\"lgnFrmNew\"]/div[9]/button")).click();  
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
			String URL = driver.getCurrentUrl();
			System.out.println(URL);
			
			if(URL == "https://www.naukri.com/mnjuser/homepage?id=" ) {
			break;
			}
			
			Thread.sleep(4000);


		}
		driver.close();
	}
}
