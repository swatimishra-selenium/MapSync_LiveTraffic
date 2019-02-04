package pageFactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage_Main {
	
	WebDriver driver;
	private Logger logger = Logger.getLogger("mapSYNK--Live_Traffic_Information_Platform");
	
	// Find Number Of Links
	@FindBy(xpath="//div[@class='account_bar']//a")
	private List<WebElement> header_links;
	
	@FindBy(xpath="//div[@class='links_wrapper']//a")
	private List<WebElement> popup_links;
	
	@FindBy(xpath="//div[@class='footer']//a")
	private List<WebElement> footer_links;
	
	public IndexPage_Main(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
	}*/
	
	public void verifyHeaderLinks() {
		String[] linkTexts1 = new String[header_links.size()];
		String currentWindow = driver.getWindowHandle();
		
		int i=0;
		for(WebElement l1 : header_links){
			linkTexts1[i] = l1.getText();
			i=i+1;
		}
		
		// Click on Each And Every Link
				for(String t : linkTexts1){
					
					if(t.contains("Register")){
						highlightElement(driver.findElement(By.partialLinkText("Register")));
						driver.findElement(By.partialLinkText("Register")).click();
						driver.navigate().back();
					}else if(t.contains("Sign in")){
						highlightElement(driver.findElement(By.partialLinkText("Sign in")));
						driver.findElement(By.partialLinkText("Sign in")).click();
						driver.navigate().back();
					}else{
					highlightElement(driver.findElement(By.linkText(t)));
					driver.findElement(By.linkText(t)).click();
					driver.switchTo().window(currentWindow);
					}
					//driver.navigate().back();
					//driver.switchTo().window(currentWindow);
				}
		
	}
	
	public void verifyPopupLinks() {
		
		String[] linkTexts2 = new String[popup_links.size()];
				
		int i=0;
		for(WebElement l1 : popup_links){
			linkTexts2[i] = l1.getText();
			i=i+1;
		}
		
		// Click on Each And Every Link
				for(String t : linkTexts2){
					
					highlightElement(driver.findElement(By.linkText(t)));
					driver.findElement(By.linkText(t)).click();
					
				}
		
	}
	
	public void verifyFooterLinks() throws Exception {
		String[] linkTexts3 = new String[footer_links.size()];
		String currentWindow = driver.getWindowHandle();
		Actions action = new Actions(driver);
		
		int i=0;
		for(WebElement l1 : footer_links){
			linkTexts3[i] = l1.getText();
			i=i+1;
		}
		
		// Click on Each And Every Link
		for(String t : linkTexts3){
			
			if(t.contains("Feedback")){
				highlightElement(driver.findElement(By.partialLinkText("Feedback")));
				driver.findElement(By.partialLinkText("Feedback")).click();
				action.sendKeys(Keys.ESCAPE).build().perform();
			}else if(t.contains("Terms and conditions")){
				highlightElement(driver.findElement(By.partialLinkText("Terms and conditions")));
				driver.findElement(By.partialLinkText("Terms and conditions")).click();
				action.sendKeys(Keys.ESCAPE).build().perform();
			}else{
			highlightElement(driver.findElement(By.linkText(t)));
			driver.findElement(By.linkText(t)).click();
			Thread.sleep(5000);
			if(driver.getTitle().contains("404")){
				System.out.println(t+" : Link is not working as expected and is under construction");
			}
			driver.switchTo().window(currentWindow);
			}
		}
	}
	
	private void highlightElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('Style','background: yellow; border: 2px solid red;');", element);
	}

}
