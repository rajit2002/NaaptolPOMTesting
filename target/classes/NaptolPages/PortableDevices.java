package NaptolPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PortableDevices {
	
	// WebDriver instance to interact with the browser
	private WebDriver driver;

	// Instance of Accessoriespage to access its elements and methods
	private Accessoriespage page;

	// Constructor to initialize WebDriver and page elements
	public PortableDevices(WebDriver driver) {
		this.driver = driver;
		// Initialize WebElements with PageFactory
		PageFactory.initElements(driver, this);
	}
	
	// WebElements for the Portable Devices page
	@FindBy(css = "a[title=\"Portable Devices\"]")
	private WebElement portabledevice;
	
	@FindBy(css = "input[id=\"brandFilterBox8313\"]")
	private WebElement rbbranded;
	
	@FindBy(css = "input[id=\"priceFilterBox4\"]")
	private WebElement rbprice;
	
	@FindBy(css = "input[id=\"cpid12613254\"]")
	private WebElement compare1;
	
	@FindBy(css = "input[id=\"cpid12612483\"]")
	private WebElement compare2;
	
	@FindBy(css = "a[class=\"button_1 compareFancyBox\"]")
	private WebElement comparebtn;
	
	@FindBy(xpath = "(//select[@class=\"dropDownCompare\"])[1]")
	private WebElement dropdown1;
	
	@FindBy(xpath = "(//select[@class=\"dropDownCompare\"])[2]")
	private WebElement dropdown2;
	
	@FindBy(css = "li[id=\"cpid12611909\"]")
	private WebElement clickonresult;
	
	@FindBy(css = "a[title=\"Close\"]")
	private WebElement closebtn;

	// Getter methods for the WebElements
	public WebElement getDropdown1() {
		return dropdown1;
	}

	public WebElement getDropdown2() {
		return dropdown2;
	}

	public WebElement getPortabledevice() {
		return portabledevice;
	}

	public WebElement getCompare1() {
		return compare1;
	}

	public WebElement getCompare2() {
		return compare2;
	}

	public WebElement getComparebtn() {
		return comparebtn;
	}
	
	public WebElement getrbbranded() {
		return rbbranded;
	}
	
	public WebElement getrbprice() {
		return rbprice;
	}
	
	public WebElement getclosebtn() {
		return closebtn;
	}

	// Method to interact with the Portable Devices page and perform a series of actions
	public boolean portabledevices() throws InterruptedException {
		// Initialize the Accessoriespage object
		page = new Accessoriespage(driver);
		
		// Click on the Portable Devices section
		portabledevice.click();
		Thread.sleep(800);
		
		// Interact with various filters and options on the page
		page.getRbCOD().click();
		Thread.sleep(800);
		page.getRbexoutofstock().click();
		Thread.sleep(800);
		page.getRbfreeshpping().click();
		Thread.sleep(800);
		page.getSetbtn().click();
		Thread.sleep(800);
		page.getRbCOD().click();
		Thread.sleep(800);
		page.getRbexoutofstock().click();
		Thread.sleep(800);
		page.getRbfreeshpping().click();
		Thread.sleep(800);
		
		// Apply brand and price filters
		rbbranded.click();
		Thread.sleep(800);
		rbprice.click();
		Thread.sleep(800);
		
		// Select items to compare and click the compare button
		compare1.click();
		Thread.sleep(800);
		compare2.click();
		Thread.sleep(800);
		comparebtn.click();
		Thread.sleep(800);
		
		// Select items from the dropdown for comparison
		Select s = new Select(dropdown1);
		s.selectByVisibleText("Branded");
		
		Select s1 = new Select(dropdown2);
		s1.selectByVisibleText("Royal Home");
		Thread.sleep(800);
		
		// Click on the comparison result and close the comparison window
		clickonresult.click();
		Thread.sleep(1000);
		closebtn.click();
		
		// Return true to indicate the method executed successfully
		return true;
	}
}

