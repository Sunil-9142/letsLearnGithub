package allPagesClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NicheThyselfExplorePage {

	@FindBy(xpath = "//Select[@id='sel']")
	public WebElement selectDropdown;
	@FindBy(xpath = "//input[@value='List']")
	public WebElement listButton;
	@FindBy(xpath = "//p//ul//li[contains(text(),delhi)]")
	public WebElement selectedCity;


	WebDriver driver;

	public NicheThyselfExplorePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectCity(String city) {
		Select select = new Select(selectDropdown);
		select.selectByValue(city);

		System.out.println("Changes Made! ");
	}

	public String verifySelectedCity() {
		listButton.click();
		String actualValue = selectedCity.getText();
		return actualValue;
	}
}
