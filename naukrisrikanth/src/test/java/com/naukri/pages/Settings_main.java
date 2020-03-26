package com.naukri.pages;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Settings_main {
	static WebDriver driver;


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
			driver.findElement(By.xpath("//input[@id='eLoginNew']")).sendKeys("tejaswini.m481@gmail.com");
			driver.findElement(By.xpath("//input[@id='pLogin']")).sendKeys("tejaswini@24");
			driver.findElement(By.xpath("//button[@value='Login']")).click();  
			Thread.sleep(4000);


		}
	}
	public void Settings() throws Exception {

		WebElement mynaukri = driver.findElement(By.xpath("//div[contains(text(),'My Naukri')]"));
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.moveToElement(mynaukri).perform();;
		Thread.sleep(3000);
		WebElement setting = driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
		setting.click();
		Thread.sleep(3000);

		//ByVisibleElement1(); // To scroll down to the Itskill element

		WebElement JobPreference = driver.findElement(By.xpath("//li[@id='JobPrefSetting']"));
		JobPreference.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//ByVisibleElement2();
		WebElement addlocation = driver.findElement(By.xpath("//a[contains(text(),'Add Location')]"));
		addlocation.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement clicklocation = driver.findElement(By.xpath("//input[@class='srchTxt']"));
		clicklocation.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement selectlocation = driver.findElement(By.xpath("//a[@data-id='locDroope_259_TopSxPMetropolitonSxPCities']"));
		selectlocation.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement emptylocation = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/span/div/div/div/div/div[2]/div[2]/div[3]/div/div/div"));
		emptylocation.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement saveBtn = driver.findElement(By.xpath("//button[@id='saveLocation']"));
		saveBtn.click();

		Thread.sleep(3000);
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		 // now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("E:\\eclipse-workspace\\GITHUB\\SrikanthKomirelly844863_naukri\\naukrisrikanth\\src\\test\\resources\\Screenshot"));
		}
		 
		catch (IOException e)
		 {
		  System.out.println(e.getMessage());
		 
		 }
		
		driver.close();

	}

	public void ByVisibleElement1() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Itskill = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/span/div/div/div/div/div/div[2]/div[2]/div/div/ul/li[6]/span"));

		//This will scroll the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();",Itskill);
	}


	public void ByVisibleElement2() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Itskilladdproject = driver.findElement(By.xpath("//*[@id=\"lazyITSkills\"]/div/div[1]/div/div[1]/span[3]"));

		//This will scroll the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();",Itskilladdproject);
	}
	

}
