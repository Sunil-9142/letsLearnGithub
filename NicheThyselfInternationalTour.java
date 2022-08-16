package allPagesClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NicheThyselfInternationalTour {

	WebDriver driver; 
	@FindBy(xpath = "//a[normalize-space()='Paris']")
	public WebElement paris;
	@FindBy(xpath = "//p[contains(text(),'Paris is the capital and most populous city of Fra')]")
	public WebElement parisText;
	
	public NicheThyselfInternationalTour(WebDriver driver) {
		
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public String validateParizText() throws InterruptedException {
		
		paris.click();
		Thread.sleep(2000);
		String actualText = parisText.getText();
		return actualText;
	}
	
	
	
}
