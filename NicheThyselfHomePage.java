package allPagesClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NicheThyselfHomePage {

	
	WebDriver driver;
	NicheThyselfMyAccountPage NTMyAccountObj;
	FileInputStream fis;
	Properties prop;
	@FindBy(name = "username")
	public WebElement userName;
	@FindBy(name = "password")
	public WebElement password;
	@FindBy(xpath = "//form[@name='loginform']/button")
	public WebElement submitButton;

	@FindBy(xpath="//button[contains(text(),'Tours')]")
	public WebElement tours;
	@FindBy(xpath="//a[contains(text(),'International Tour')]")
	public WebElement internationalTours;
	
	String url="https://nichethyself.com/tourism/home.html";

	public NicheThyselfHomePage() throws IOException {

		/*
		 * try { fis = new FileInputStream(
		 * "C:\\Users\\User\\eclipse-workspace\\AutomationTraining\\src\\main\\resources\\utilities\\NicheThyselfProperties.properties"
		 * ); } catch (IOException e) { e.printStackTrace(); }
		 * 
		 * prop = new Properties(); prop.load(fis); url = prop.getProperty("URL");
		 */

				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\User\\eclipse-workspace\\AutomationTraining\\src\\main\\resources\\utilities\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}

	public NicheThyselfHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public NicheThyselfMyAccountPage login(String user, String pass) {

		userName.sendKeys(user);
		password.sendKeys(pass);
		submitButton.click();
		return new NicheThyselfMyAccountPage(driver);
	}

	public void alertccept() {
		Alert ac = driver.switchTo().alert();
		ac.accept();
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public NicheThyselfInternationalTour internationalTourSelect() {
		tours.click();
		internationalTours.click();
		
		return new NicheThyselfInternationalTour(driver);
	}
	
	public void tearDown() {
		driver.quit();
	}

}
