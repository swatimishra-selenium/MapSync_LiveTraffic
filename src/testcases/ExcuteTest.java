package testcases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import excelInputAndOutput.ExcelInteraction;
import pageFactory.IndexPage_Direction;
import pageFactory.IndexPage_Personal;
import pageFactory.IndexPage_Live;
import pageFactory.IndexPage_Main;
//import pageFactory.LoginPage;
//import pageFactory.ReserveAFlightPage;
import utility.Constant;

public class ExcuteTest {

	WebDriver driver;
	ExcelInteraction excel;
	Properties allObjects;
	IndexPage_Direction indexpage_direction;
	IndexPage_Personal indexpage_personal;
	IndexPage_Live indexpage_live;
	IndexPage_Main indexpage_main;
	ExtentReports extent;
	ExtentTest logger;
	ExtentHtmlReporter htmlReporter;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browser) throws IOException{
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",Constant.chromeDriverPath);
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", Constant.geckoDriverPath);
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		excel = new ExcelInteraction();
		
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"//Report//TestExecutionReport.html"));
		
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report : Flight Reservation");
		htmlReporter.config().setReportName("E2E Testing Of Flight Reservation");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		  // OR
		
		//htmlReporter.loadConfig(System.getProperty("user.dir")+"//extentreports-java-3.1.5//extent-config.xml");
		extent.attachReporter(htmlReporter);
		
		
		// Provide Some System Information
		extent.setSystemInfo("Project Name", "MapSynk Live Traffic");
		extent.setSystemInfo("Browser", browser);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version",System.getProperty("java.version"));
		extent.setSystemInfo("User", System.getProperty("user.name"));
		InetAddress myHost = InetAddress.getLocalHost();
		extent.setSystemInfo("Host Name", myHost.getHostName());
		
		
		
}
	
	@BeforeMethod
	private void getTestMethodName(Method method){
		logger = extent.createTest(method.getName());
	}
	
	@Test(priority=0)
	private void launchMapSyncApplication() throws IOException{
		// Invoke Application Under Test
		driver.manage().window().maximize();
		String url = excel.getCellData(System.getProperty("user.dir")+"//TestData", "FR.xls", "InvokeApplication", 1, 0);
		driver.get(url);
		String expTitle = 	excel.getCellData(System.getProperty("user.dir")+"//TestData", "FR.xls", "InvokeApplication", 1, 1);	
		Assert.assertEquals(driver.getTitle(),expTitle);
		
	}
	
	@Test(dependsOnMethods="launchMapSyncApplication")
	private void enterDirectionInfo() throws IOException{
		//enter direction from and direction to
		indexpage_direction = new IndexPage_Direction(driver);
		
		indexpage_direction.minimizeGalacticoPopup();
		// Enter Poi from
		String  poi_from = excel.getCellData(System.getProperty("user.dir")+"//TestData", "FR.xls", "Direction Details", 1, 0);
		indexpage_direction.enterPoiFrom(poi_from);
	
		// Enter Poi to
		String poi_to = excel.getCellData(System.getProperty("user.dir")+"//TestData", "FR.xls", "Direction Details", 1, 1);
		indexpage_direction.enterPoiTo(poi_to);
		
		// Click on 'checkboxes'
		indexpage_direction.clickTrafficAware();
		indexpage_direction.clickTollAware();
		indexpage_direction.clickFastest();
		indexpage_direction.clickShortest();
		
		// Click on 'Direction' button
		indexpage_direction.clickDirectionButton();
		
		indexpage_direction.clickTrafficRouteRibbon();
		indexpage_direction.clickLeftTurn();
		
		//click on 'Personal' tab
		indexpage_direction.clickOnPersonal();
		
				
	}
	
	/*
	@Test(dependsOnMethods="enterDirectionInfo")
	private void clickPersonalButtons() throws IOException, Exception {
		
		indexpage_personal = new IndexPage_Personal(driver);
		
		// Click on 'Sign in'
		indexpage_personal.clickOnSignIn();
		Thread.sleep(3000);
		String expTitle = 	excel.getCellData(System.getProperty("user.dir")+"//TestData", "FR.xls", "InvokeApplication", 1, 2);	
		Assert.assertEquals(driver.getTitle(),expTitle);
		
		driver.navigate().back();
		
		// Click on 'Register'
		//indexpage_personal.clickOnRegister();
		//Assert.assertEquals(driver.getTitle(),expTitle);
		//driver.navigate().back();
		
		//click on 'Live' tab
		indexpage_personal.clickOnLive();
		
	}*/
	
	@Test(dependsOnMethods="enterDirectionInfo")
	private void clickLiveInfo() throws IOException {
		
		indexpage_live = new IndexPage_Live(driver);
		
		indexpage_live.clickOnLive();
		
		indexpage_live.clickOnTime();
		
		indexpage_live.clickOnCameras();
		
		indexpage_live.clickOnCamerasLink();
		
		indexpage_live.clickOnTolls();
		
		indexpage_live.clickOnTollsLink();
		
	}
	
	@Test(dependsOnMethods="clickLiveInfo")
	private void verifyNavigationLinks() throws Exception {
		
		indexpage_main = new IndexPage_Main(driver);
		
		indexpage_main.verifyHeaderLinks();
		
		indexpage_main.verifyPopupLinks();
		
		indexpage_main.verifyFooterLinks();
	}
	
	@AfterMethod
	private void getTestStatus(ITestResult result) throws IOException{
		
		if(result.getStatus() == ITestResult.SUCCESS){
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" got Passed", ExtentColor.GREEN));
			String screenShotPath = getScreenShot(result.getName());
			logger.addScreenCaptureFromPath(screenShotPath);
		}else if(result.getStatus() == ITestResult.FAILURE){
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" got failed due to "+result.getThrowable(), ExtentColor.RED));
			String screenShotPath = getScreenShot(result.getName());
			logger.addScreenCaptureFromPath(screenShotPath);
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" got skipped", ExtentColor.CYAN));
		}
		
	}
	
private String getScreenShot(String screenShotName) throws IOException{
		
		TakesScreenshot srcShot = (TakesScreenshot)driver;
		
		File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);
		String dateFormat = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss").format(new Date());
		String destination = System.getProperty("user.dir")+"//screenshots//"+screenShotName+"_"+dateFormat+".png";
		File destFile = new File(destination);
		Files.copy(SrcFile, destFile);
		return destination;
		
	}
	
	@AfterTest
	public void closeDriver(){
		extent.flush();
		driver.quit();
	}
	
}
