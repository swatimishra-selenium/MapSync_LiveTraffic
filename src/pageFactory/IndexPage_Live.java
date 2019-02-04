package pageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage_Live {
	
	WebDriver driver;
	private Logger logger = Logger.getLogger("mapSYNK--Live_Traffic_Information_Platform");
	
	@FindBy(xpath="//a[@data-tabid='2']")
	private WebElement live;
	
	@FindBy(xpath="(//div[@class='item_time'])[1]")
	private WebElement time;
	
	@FindBy(xpath="//input[@id='rdIncidents']")
	private WebElement incidents;
	
	@FindBy(xpath="//input[@id='rdCameras']")
	private WebElement cameras;
	
	@FindBy(xpath="//input[@id='rdErp']")
	private WebElement tolls;
	
	@FindBy(linkText="Adam Road (Towards Changi)")
	private WebElement camera_location;
	
	@FindBy(linkText="Anson Road")
	private WebElement gantry_location;
	
	public IndexPage_Live(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
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
	
	public void clickOnTime(){
		try{
		logger.info("Clicking on 'Time'...");
		highlightElement(time);
		time.click();
		logger.info("Clicked on 'Time'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Time': "+ex.getMessage());
		}
}
	
	public void clickOnCameras(){
		try{
		logger.info("Clicking on 'Cameras'...");
		highlightElement(cameras);
		cameras.click();
		logger.info("Clicked on 'Cameras'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Cameras': "+ex.getMessage());
		}
}
	public void clickOnCamerasLink(){
		try{
		logger.info("Clicking on a link under 'Cameras'...");
		highlightElement(camera_location);
		camera_location.click();
		logger.info("Clicked on a link under 'Cameras'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on a link under 'Cameras': "+ex.getMessage());
		}
}
	public void clickOnTolls(){
		try{
		logger.info("Clicking on 'Tolls'...");
		highlightElement(tolls);
		tolls.click();
		logger.info("Clicked on 'Tolls'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Cameras': "+ex.getMessage());
		}
}
	
	public void clickOnTollsLink(){
		try{
		logger.info("Clicking on a link under 'Tolls'...");
		highlightElement(gantry_location);
		gantry_location.click();
		logger.info("Clicked on a link under 'Tolls'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on a link under 'Tolls': "+ex.getMessage());
		}
}
	
	private void highlightElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('Style','background: yellow; border: 2px solid red;');", element);
	}

}
