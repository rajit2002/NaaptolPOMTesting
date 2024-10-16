package NaptolPages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsumerElectronicsPage {

    // WebDriver instance to interact with the browser
    private WebDriver driver;

    // Constructor to initialize WebDriver and page elements
    public ConsumerElectronicsPage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebElements with PageFactory
        PageFactory.initElements(driver, this);
    }

    // WebElements for the Consumer Electronics page
    @FindBy(css = "input[id=\"header_search_text\"]")
    private WebElement Search;

    @FindBy(xpath = "(//div[@class=\"search\"])[2]")
    private WebElement searchbutton;

    @FindBy(xpath = "(//a[@id=\"cart-panel-link\"])[1]")
    private WebElement AddtoCart;

    @FindBy(css = "a[title=\"Electronics Accessories\"]")
    private WebElement ElectronicsAsccessories;

    @FindBy(css = "a[title=\"Portable Devices\"]")
    private WebElement PortableDevices;

    @FindBy(css = "a[title=\"Security & Gadgets\"]")
    private WebElement SecuirityandGadgets;

    @FindBy(css = "a[title=\"Home Entertainment\"]")
    private WebElement HomeEntertainment;

    @FindBy(css = "a[title=\"Portable Audio\"]")
    private WebElement PortableAudio;

    @FindBy(css = "a[title=\"Printers\"]")
    private WebElement Printers;

    @FindBy(css = "input[placeholder=\"Search Brand\"]")
    private WebElement SearchBrand;

    @FindBy(css = "input[id=\"iscod\"]")
    private WebElement radiobtn1;

    @FindBy(css = "input[id=\"catFilterBox225\"]")
    private WebElement radiobtn2;

    @FindBy(xpath = "(//img[@class=\"square\"])[1]")
    private WebElement product;

    @FindBy(css = "a[id=\"cart-panel-button-0\"]")
    private WebElement addtocartbtn;

    @FindBy(xpath = "(//a[@class=\"red_button2\"])[2]")
    private WebElement proceedtocheckout;

    @FindBy(css = "img[title=\"Online Shopping in India\"]")
    private WebElement backtohomepage;

    // Getter methods for the WebElements
    public WebElement getSearch() {
        return Search;
    }

    public WebElement getSearchbutton() {
        return searchbutton;
    }

    public WebElement getAddtoCart() {
        return AddtoCart;
    }

    public WebElement getElectronicsAsccessories() {
        return ElectronicsAsccessories;
    }

    public WebElement getPortableDevices() {
        return PortableDevices;
    }

    public WebElement getSecuirityandGadgets() {
        return SecuirityandGadgets;
    }

    public WebElement getHomeEntertainment() {
        return HomeEntertainment;
    }

    public WebElement getPortableAudio() {
        return PortableAudio;
    }

    public WebElement getPrinters() {
        return Printers;
    }

    public WebElement getSearchBrand() {
        return SearchBrand;
    }

    public WebElement getRadiobtn1() {
        return radiobtn1;
    }

    public WebElement getRadiobtn2() {
        return radiobtn2;
    }

    public WebElement getProduct() {
        return product;
    }

    public WebElement getAddtocartbtn() {
        return addtocartbtn;
    }

    public WebElement getProceedtocheckout() {
        return proceedtocheckout;
    }

    public WebElement getBacktohomepage() {
        return backtohomepage;
    }

    // Method to search for a product and add it to the cart
    public boolean searchproductandaddtocart(String productName) throws InterruptedException {

        // Set implicit wait for element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Perform search
        Search.sendKeys(productName);
        searchbutton.click();
        Thread.sleep(700);

        // Apply filters
        radiobtn1.click();
        Thread.sleep(700);
        radiobtn2.click();	
        Thread.sleep(700);

        // Get the window handle of the parent window
        String parentWindowHandle = driver.getWindowHandle();

        // Click on a product link that opens a new window
        product.click();

        // Handle multiple windows
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Perform actions in the new window
        addtocartbtn.click();
        proceedtocheckout.click();
        backtohomepage.click();

        // Return true if actions are successful
        return true;
    }
}

