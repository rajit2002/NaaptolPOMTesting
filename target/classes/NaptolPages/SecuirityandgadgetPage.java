package NaptolPages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SecuirityandgadgetPage {
    
    WebDriver driver;
    PortableDevices portable;
    Accessoriespage acc;
    ConsumerElectronicsPage cp;
    
    // Constructor
    public SecuirityandgadgetPage(WebDriver driver) {
        // Initializing driver using this keyword
        this.driver = driver;
        
        // Use PageFactory to initialize WebElements
        PageFactory.initElements(driver, this);
    }
    
    // WebElement locators
    @FindBy(css = "a[id=\"sub_cat_img_2\"]")
    private WebElement secuirityandgadgetbtn;
    
    @FindBy(xpath = "(//a[@title=\"Security Devices\"])[1]")
    private WebElement secuirityDevices;
    
    @FindBy(css = "select[id=\"sortByFilter\"]")
    private WebElement sortbybtn;
    
    @FindBy(xpath = "(//img[@class=\"square\"])[1]")
    private WebElement product3;
    
    @FindBy(css = "input[id=\"pincodeDeliveryId_0\"]")
    private WebElement pincode;
    
    @FindBy(xpath = "(//a[@class=\"button_1\"])[1]")
    private WebElement checkbtn;
    
    // Getter methods for WebElements
    public WebElement getSecuirityandgadgetbtn() {
        return secuirityandgadgetbtn;
    }
    
    public WebElement getSecuirityDevices() {
        return secuirityDevices;
    }
    
    public WebElement getSortbybtn() {
        return sortbybtn;
    }
    
    public WebElement getProduct3() {
        return product3;
    }
    
    public WebElement getPincode() {
        return pincode;
    }
    
    public WebElement getCheckbtn() {
        return checkbtn;
    }
    
    // Main method for security devices workflow
    public String secuiritydevices(String pincode) throws InterruptedException {
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Initialize page objects
        portable = new PortableDevices(driver);
        acc = new Accessoriespage(driver);
        cp = new ConsumerElectronicsPage(driver);
        
        // Navigate to security devices page
        Thread.sleep(800);
        secuirityandgadgetbtn.click();
        Thread.sleep(800);
        secuirityDevices.click();
        
        // Sort products
        Thread.sleep(800);
        Select s = new Select(sortbybtn);
        Thread.sleep(800);
        s.selectByVisibleText("Cheapest");
        
        // Apply filters
        Thread.sleep(800);
        acc.getRbCOD().click();
        Thread.sleep(800);
        acc.getRbfreeshpping().click();
        Thread.sleep(1000);
        portable.getrbbranded().click();
        Thread.sleep(1000);
        portable.getrbprice().click();
        Thread.sleep(1000);
        
        // Handle new window
        String parentWindowHandle = driver.getWindowHandle();
        product3.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
        
        // Enter pincode and add to cart
        Thread.sleep(800);
        this.pincode.sendKeys(pincode);
        Thread.sleep(800);
        checkbtn.click();
        Thread.sleep(800);
        cp.getAddtocartbtn().click();
        Thread.sleep(800);
        cp.getProceedtocheckout().click();
        Thread.sleep(800);
        cp.getBacktohomepage().click();
        
        return parentWindowHandle;
    }
}
