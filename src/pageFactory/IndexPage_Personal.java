package pageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage_Personal {
	
	WebDriver driver;
	private Logger logger = Logger.getLogger("mapSYNK--Live_Traffic_Information_Platform");
	
	@FindBy(xpath="//a[@data-tabid='2']")
	private WebElement live;
	
	@FindBy(xpath="//input[@value='Sign in']")
	private WebElement signin;
	
	/*@FindBy(xpath="//input[@value='Register']")
	private WebElement register;*/
	
	public IndexPage_Personal(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignIn(){
		try{
		logger.info("Clicking on 'Sign in'...");
		highlightElement(signin);
		signin.click();
		logger.info("Clicked on 'Sign in'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Sign in': "+ex.getMessage());
		}
}
	/*
	public void clickOnRegister(){
		try{
		logger.info("Clicking on 'Register'...");
		highlightElement(register);
		register.click();
		logger.info("Clicked on 'Register'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Register': "+ex.getMessage());
		}
}*/
	
	public void clickOnLive(){
		try{
		logger.info("Clicking on 'Live tab'...");
		highlightElement(live);
		live.click();
		logger.info("Clicked on 'Live tab'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Live tab': "+ex.getMessage());
		}
}
	
	
	private void highlightElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('Style','background: yellow; border: 2px solid red;');", element);
	}

}
