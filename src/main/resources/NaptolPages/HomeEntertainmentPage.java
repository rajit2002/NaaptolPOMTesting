package NaptolPages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeEntertainmentPage {
	
	// WebDriver instance to interact with the browser
	private WebDriver driver;

	// Instances of other page objects for accessing their methods
	private ConsumerElectronicsPage page;
	private PortableDevices portable;
	private Accessoriespage acc;

	// Constructor to initialize WebDriver and page elements
	public HomeEntertainmentPage(WebDriver driver) {
		this.driver = driver;
		// Initialize WebElements with PageFactory
		PageFactory.initElements(driver, this);
	}

	// WebElements for the Home Entertainment page
	@FindBy(xpath = "(//a[@title=\"Home Entertainment\"])[1]")
	private WebElement homenetertainment;

	@FindBy(css = "a[title=\"Home Speakers\"]")
	private WebElement homespeakers;

	@FindBy(css = "input[id=\"priceFilterBox1\"]")
	private WebElement rbprice;

	@FindBy(css = "input[id=\"pincode\"]")
	private WebElement pincodeinput;

	@FindBy(css = "input[id=\"discountFilterBox1\"]")
	private WebElement rbdiscount;

	@FindBy(css = "ul[id=\"featureFilterBox1\"]")
	private WebElement rbtype;

	@FindBy(partialLinkText = "Blue")
	private WebElement color;

	@FindBy(xpath = "(//input[@class=\"input_Special_2\"])[1]")
	private WebElement qty;

	// Getter methods for the WebElements
	public WebElement getHomenetertainment() {
		return homenetertainment;
	}

	public WebElement getHomespeakers() {
		return homespeakers;
	}

	public WebElement getRbprice() {
		return rbprice;
	}

	public WebElement getPincodeinput() {
		return pincodeinput;
	}

	public WebElement getRbdiscount() {
		return rbdiscount;
	}

	public WebElement getRbtype() {
		return rbtype;
	}

	public WebElement getQty() {
		return qty;
	}

	// Method to interact with the Home Entertainment page and perform a series of actions
	public void homeentertainment(String pincode, String qty) throws InterruptedException {
		// Initialize instances of other page objects
		page = new ConsumerElectronicsPage(driver);
		acc = new Accessoriespage(driver);
		portable = new PortableDevices(driver);

		// Navigate to Home Entertainment section and select options
		Thread.sleep(700);
		homenetertainment.click();
		Thread.sleep(700);
		homespeakers.click();
		Thread.sleep(700);
		acc.getRbCOD().click();
		Thread.sleep(700);
		acc.getRbexoutofstock().click();
		Thread.sleep(700);
		pincodeinput.sendKeys(pincode);
		Thread.sleep(700);
		acc.getSetbtn().click();

		// Apply filters and selections
		Thread.sleep(2000);
		portable.getrbbranded().click();
		Thread.sleep(2000);
		rbprice.click();
		Thread.sleep(700);
		rbdiscount.click();
		Thread.sleep(700);
		rbtype.click();
		Thread.sleep(700);

		// Handle window switching after clicking on a product
		String parentWindowHandle = driver.getWindowHandle();
		acc.getProduct2().click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}

		// Perform actions in the new window, such as selecting color and adding to cart
		color.click();
		Thread.sleep(700);
		page.getAddtocartbtn().click();
		Thread.sleep(700);

		// Clear and set the quantity, then proceed to checkout
		this.qty.clear();
		Thread.sleep(700);
		this.qty.sendKeys(qty);
		Thread.sleep(700);
		page.getProceedtocheckout().click();

		// Navigate back to the homepage
		Thread.sleep(700);
		page.getBacktohomepage().click();
	}
}

