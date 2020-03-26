package com.naukri.pages;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.naukri.excel.Excel_utiliy;



public class Login_main {

	static WebDriver driver;
	Excel_utiliy eu = new Excel_utiliy();

	public void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver","E:\\eclipse-workspace\\GITHUB\\SrikanthKomirelly844863_naukri\\naukrisrikanth\\src\\test\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public void url()
	{
		driver.get("https://www.naukri.com/");

		String windowTitle= getCurrentWindowTitle();
		String mainWindow = getMainWindowHandle(driver);
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Assert.assertTrue(windowTitle.contains("Jobs - Recruitment"));

	}
	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	public String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
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
		for(int i=1;i<=1;i++)
		{

			driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
			driver.findElement(By.xpath("//input[@id='eLoginNew']")).sendKeys(eu.excel_email(i));
			driver.findElement(By.xpath("//input[@id='pLogin']")).sendKeys(eu.excel_password(i));
			driver.findElement(By.xpath("//button[@value='Login']")).click();  
			Thread.sleep(4000);


		}
		driver.close();
	}
}





