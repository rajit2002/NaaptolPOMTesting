package NaptolPages;

import java.time.Duration;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accessoriespage {

    // WebDriver instance to interact with the browser
    private WebDriver driver;
    private ConsumerElectronicsPage page;
    

    // Constructor to initialize WebDriver and page elements
    public Accessoriespage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebElements with PageFactory
        PageFactory.initElements(driver, this);
    }

    // WebElements for the Accessories page
    @FindBy(css = "a[title=\"Electronics Accessories\"]")
    private WebElement clickonelecAccess;

    @FindBy(css = "input[id=\"iscod\"]")
    private WebElement rbCOD;

    @FindBy(css = "input[id=\"isexoutStock\"]")
    private WebElement rbexoutofstock;

    @FindBy(css = "input[id=\"isfreeship\"]")
    private WebElement rbfreeshpping;

    @FindBy(xpath = "(//a[@class=\"button_1\"])[1]")
    private WebElement setbtn;

    @FindBy(css = "input[id=\"brandFilterBox69\"]")
    private WebElement rbcasiobrand;

    @FindBy(css = "input[id=\"priceFilterBox1\"]")
    private WebElement rbprice;

    @FindBy(css = "img[class=\"square\"]")
    private WebElement product2;

    // Getter methods for the WebElements
    public WebElement getClickonelecAccess() {
        return clickonelecAccess;
    }

    public WebElement getRbCOD() {
        return rbCOD;
    }

    public WebElement getRbexoutofstock() {
        return rbexoutofstock;
    }

    public WebElement getRbfreeshpping() {
        return rbfreeshpping;
    }

    public WebElement getSetbtn() {
        return setbtn;
    }

    public WebElement getRbcasiobrand() {
        return rbcasiobrand;
    }

    public WebElement getRbprice() {
        return rbprice;
    }

    public WebElement getProduct2() {
        return product2;
    }

    // Method to interact with the Electronics Accessories section
    public boolean ElectronicsAccessories() throws InterruptedException {

        // Initialize the ConsumerElectronicsPage instance
        page = new ConsumerElectronicsPage(driver);
        
        // Set implicit wait for element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Perform operations on the Accessories page
        Thread.sleep(1000);
        clickonelecAccess.click();
       
        Thread.sleep(1000);
        rbCOD.click();
        Thread.sleep(1000);
        rbexoutofstock.click();
        Thread.sleep(1000);
        rbfreeshpping.click();
        Thread.sleep(1000);
        setbtn.click();
 	
          Thread.sleep(3000);
          rbcasiobrand.click();
   	
        Thread.sleep(1000);
        rbprice.click();
        Thread.sleep(1000);

        // Get the window handle of the parent window
        String parentWindowHandle = driver.getWindowHandle();

        // Click on a product link that opens a new window
        product2.click();

        // Handle multiple windows
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        // Perform actions in the new window
        page.getAddtocartbtn().click();
        page.getProceedtocheckout().click();
        page.getBacktohomepage().click();

        // Return true if actions are successful
        return true;
    }
}

