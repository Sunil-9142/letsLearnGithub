package allPagesClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NicheThyselfMyAccountPage {

	WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Sign out']")
	public WebElement signOut;
	@FindBy(xpath = "//div[@id='context']")
	public WebElement mediaBox;
	@FindBy(xpath = "//a[normalize-space()='Explore']")
	public WebElement exploreTab;

	public NicheThyselfMyAccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public NicheThyselfHomePage signOutClick() {
		signOut.click();
		return new NicheThyselfHomePage(driver);
	}

	public String mediaBoxText() {
		System.out.println("actual mediaBox text is: " + mediaBox.getText());
		return mediaBox.getText();

	}
	
	public NicheThyselfExplorePage goToExploreTab() {
		exploreTab.click();
		return new NicheThyselfExplorePage(driver);
	}

}
