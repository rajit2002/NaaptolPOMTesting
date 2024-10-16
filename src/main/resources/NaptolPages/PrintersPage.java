package NaptolPages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintersPage {

    // WebDriver and other page objects
    WebDriver driver;
    ConsumerElectronicsPage page;
    PortableDevices portable;
    Accessoriespage acc;
    SecuirityandgadgetPage sgp;
    HomeEntertainmentPage hep;

    // Constructor
    public PrintersPage(WebDriver driver) {
        // Initializing driver using this keyword
        this.driver = driver;
        
        // Use PageFactory to initialize WebElements
        PageFactory.initElements(driver, this);
    }

    // WebElement locators
    @FindBy(css = "a[title=\"Printers\"]")
    private WebElement printers;

    @FindBy(xpath = "(//img[@class=\"square\"])[1]")
    private WebElement product4;

    @FindBy(xpath = "(//img[@title=\"Canon All in One Printer\"])[2]")
    private WebElement img1;

    @FindBy(xpath = "(//img[@title=\"Canon All in One Printer\"])[3]")
    private WebElement img2;

    @FindBy(xpath = "(//img[@title=\"Canon All in One Printer\"])[4]")
    private WebElement img3;


    // Main method for printers workflow
    public void printers() throws InterruptedException {
        PrintersPage pg = new PrintersPage(driver);
        
        // Navigate to printers page
        Thread.sleep(2000);
        pg.printers.click();

        // Handle new window
        String parentWindowHandle = driver.getWindowHandle();
        Thread.sleep(800);
        product4.click();

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Switch to new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        // Perform tasks on new window
        Thread.sleep(800);
        img1.click();
        Thread.sleep(800);
        img2.click();
        Thread.sleep(800);
        img3.click();
    }
}
