package pageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage_Direction {
	WebDriver driver;
	private Logger logger = Logger.getLogger("mapSYNK--Live_Traffic_Information_Platform");
	
	@FindBy(xpath="//a[@data-tabid='0']")
	private WebElement direction;
	
	@FindBy(xpath="//a[@data-tabid='1']")
	private WebElement personal;
	
	@FindBy(xpath="//a[@data-tabid='2']")
	private WebElement live;
	
	@FindBy(id="poi_from")
	private WebElement poiFrom;
	
	@FindBy(id="poi_to")
	private WebElement poiTo;
	
	@FindBy(id="also_traffic")
	private WebElement also_traffic;
	
	@FindBy(id="also_erp")
	private WebElement also_erp;
	
	@FindBy(id="also_fastest")
	private WebElement also_fastest;
	
	@FindBy(id="also_shortest")
	private WebElement also_shortest;
	
	@FindBy(id="get_direction")
	private WebElement get_direction;
	
	@FindBy(id="traffic_route_ribbon")
	private WebElement trafficRouteRibbon;
	
	//@FindBy(xpath="(//td[@class='turn_by_turn_text'])[1]")
	@FindBy(xpath="(//td[contains(text(),'Left Turn to')])[1]")
	private WebElement leftTurn;
	
	@FindBy(xpath="//div[@id='ad_toggle']")
	private WebElement min_galactico_popup;
	
	public IndexPage_Direction(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void minimizeGalacticoPopup(){
		try{
		logger.info("Minimizing 'Galactico Popup'...");
		//highlightElement(min_galactico_popup);
		min_galactico_popup.click();
		logger.info("Minimized 'Galactico Popup'...");
		}catch(Exception ex){
			logger.error("Exception occurred while minimizing 'Galactico Popup': "+ex.getMessage());
		}	
}
	
	public void clickOnDirections(){
		try{
		logger.info("Clicking on 'Directions tab'...");
		highlightElement(direction);
		direction.click();
		logger.info("Clicked on 'Directions tab'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Directions tab': "+ex.getMessage());
		}
}
	
	public void enterPoiFrom(String poi_from){
		try{
		logger.info("Entering '"+poi_from+"' in the 'PoiFrom' edit field...");
		highlightElement(poiFrom);
		poiFrom.sendKeys(poi_from);
		logger.info("Entered '"+poi_from+"' in the 'PoiFrom' edit field...");
		}catch(Exception ex){
			logger.error("Exception occurred while entering '"+poi_from+"' in the 'PoiFrom' edit field : "+ex.getMessage());
		}
	}
	
	public void enterPoiTo(String poi_to){
		try{
		logger.info("Entering '"+poi_to+"' in the 'PoiTo' edit field...");
		highlightElement(poiTo);
		poiTo.sendKeys(poi_to);
		logger.info("Entered '"+poi_to+"' in the 'PoiTo' edit field...");
		}catch(Exception ex){
			logger.error("Exception occurred while entering '"+poi_to+"' in the 'PoiTo' edit field : "+ex.getMessage());
		}
	}
	
	public void clickTrafficAware(){
		try{
		logger.info("Clicking on 'Traffic aware'...");
		highlightElement(also_traffic);
		also_traffic.click();
		logger.info("Clicked on 'Traffic aware'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Traffic aware' : "+ex.getMessage() );
		}
	}
	
	public void clickTollAware(){
		try{
		logger.info("Clicking on 'Toll Aware'...");
		highlightElement(also_erp);
		also_erp.click();
		logger.info("Clicked on 'Toll Aware'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Toll Aware' : "+ex.getMessage() );
		}
	}
	
	public void clickFastest(){
		try{
		logger.info("Clicking on 'Fastest'...");
		highlightElement(also_fastest);
		also_fastest.click();
		logger.info("Clicked on 'Fastest'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Fastest' : "+ex.getMessage() );
		}
	}
	
	public void clickShortest(){
		try{
		logger.info("Clicking on 'Shortest'...");
		highlightElement(also_shortest);
		also_shortest.click();
		logger.info("Clicked on 'Shortest'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Shortest' : "+ex.getMessage() );
		}
	}
	
	public void clickDirectionButton(){
		try{
		logger.info("Clicking on 'Direction' button...");
		highlightElement(get_direction);
		get_direction.click();
		logger.info("Clicked on 'Direction' button...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Direction' button : "+ex.getMessage() );
		}
	}
	
	public void clickTrafficRouteRibbon(){
		try{
		logger.info("Clicking on 'TrafficRouteRibbon'...");
		highlightElement(trafficRouteRibbon);
		trafficRouteRibbon.click();
		logger.info("Clicked on 'TrafficRouteRibbon'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'TrafficRouteRibbon' : "+ex.getMessage() );
		}
	}
	
	public void clickLeftTurn(){
		try{
		logger.info("Clicking on 'Left Turn'...");
		highlightElement(leftTurn);
		leftTurn.click();
		logger.info("Clicked on 'Left Turn'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Left Turn' : "+ex.getMessage() );
		}
	}
	
	public void clickOnPersonal(){
		try{
		logger.info("Clicking on 'Personal tab'...");
		highlightElement(personal);
		personal.click();
		logger.info("Clicked on 'Personal tab'...");
		}catch(Exception ex){
			logger.error("Exception occurred while clicking on 'Personal tab': "+ex.getMessage());
		}
}
	
	private void highlightElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('Style','background: yellow; border: 2px solid red;');", element);
	}

}