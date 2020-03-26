
package com.naukri.pages;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;




public class EditProfile_main {
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
	public void Editprofile() throws Exception {

		WebElement mynaukri = driver.findElement(By.xpath("//div[contains(text(),'My Naukri')]"));
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.moveToElement(mynaukri).perform();;
		Thread.sleep(3000);
		WebElement editprofile = driver.findElement(By.xpath("//a[@title='Edit Profile']"));
		editprofile.click();
		Thread.sleep(3000);

		ByVisibleElement1(); // To scroll down to the Itskill element

		WebElement Itskill = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/span/div/div/div/div/div/div[2]/div[2]/div/div/ul/li[6]/span"));
		Itskill.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ByVisibleElement2();
		WebElement Itskilladdproject = driver.findElement(By.xpath("//*[@id=\"lazyITSkills\"]/div/div[1]/div/div[1]/span[3]"));
		Itskilladdproject.click();

		EnterDetails();


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

	public void EnterDetails() {
		WebElement enterskill = driver.findElement(By.xpath("//input[@id='itSkillSugg']"));
		WebElement version = driver.findElement(By.xpath("//input[@id='version']"));
		WebElement lastused = driver.findElement(By.xpath("//input[@id='lastUsedDroopeFor']"));
		WebElement lastuseddate = driver.findElement(By.xpath("//*[@id=\"ul_lastUsedDroope\"]/ul/li[2]/a"));	
		WebElement experienceY = driver.findElement(By.xpath("//input[@id='expYearDroopeFor']"));
		WebElement experienceYdate = driver.findElement(By.xpath("//*[@id=\"ul_expYearDroope\"]/ul/li[2]/a"));		
		WebElement experienceM = driver.findElement(By.xpath("//input[@id='expMonthDroopeFor']"));
		WebElement experienceMdate = driver.findElement(By.xpath("//*[@id=\"ul_expMonthDroope\"]/ul/li[2]/a"));
		WebElement saveITSkills = driver.findElement(By.xpath("//button[@id='saveITSkills']"));

		enterskill.sendKeys("C");
		version.sendKeys("1");
		lastused.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		lastuseddate.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		experienceY.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		experienceYdate.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		experienceM.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		experienceMdate.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		saveITSkills.click();

	}

}


