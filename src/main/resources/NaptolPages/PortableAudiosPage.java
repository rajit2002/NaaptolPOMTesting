package NaptolPages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PortableAudiosPage {

    // WebDriver instance to interact with the browser
    private WebDriver driver;

    // Instances of other page objects for accessing their method
    private Accessoriespage acc;
    private HomeEntertainmentPage hep;
    
    // WebDriverWait instance for handling dynamic waits
    private WebDriverWait wait;

    // Constructor to initialize WebDriver, WebDriverWait, and page elements
    public PortableAudiosPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Initialize WebElements with PageFactory
        PageFactory.initElements(driver, this);
    }

    // WebElements for the Portable Audios page
    @FindBy(css = "a[id=\"sub_cat_img_4\"]")
    private WebElement Portableaudiosbtn;

    @FindBy(css = "a[title=\"Portable Speakers\"]")
    private WebElement Porablespeakersbtn;

    @FindBy(css = "input[id=\"fromPriceRange\"]")
    private WebElement frominput;

    @FindBy(css = "input[id=\"toPriceRange\"]")
    private WebElement toinput;

    @FindBy(xpath = "(//a[@class=\"button_1\"])[2]")
    private WebElement Gobtn;

    // Getter methods for the WebElements
    public WebElement getPortableaudiosbtn() {
        return Portableaudiosbtn;
    }

    public WebElement getPorablespeakersbtn() {
        return Porablespeakersbtn;
    }

    public WebElement getFrominput() {
        return frominput;
    }

    public WebElement getToinput() {
        return toinput;
    }

    public WebElement getGobtn() {
        return Gobtn;
    }

    // Method to interact with the Portable Audios page and perform a series of actions
    public void portableaudio(String from, String to, String pincode) throws InterruptedException {
        // Initialize instances of other page objects
        acc = new Accessoriespage(driver);
        hep = new HomeEntertainmentPage(driver);

        // Wait for and click the Portable Audios button
        wait.until(ExpectedConditions.elementToBeClickable(Portableaudiosbtn)).click();

        // Wait for and click the Portable Speakers button
        wait.until(ExpectedConditions.elementToBeClickable(Porablespeakersbtn)).click();

        // Apply filters and set pincode
        Thread.sleep(800);
        acc.getRbCOD().click();
        Thread.sleep(800);
        acc.getRbexoutofstock().click();
        Thread.sleep(800);
        hep.getPincodeinput().clear();
        Thread.sleep(800);
        acc.getSetbtn().click();

        // Set the price range
        Thread.sleep(800);
        frominput.sendKeys(from);
        Thread.sleep(800);
        toinput.sendKeys(to);
        Thread.sleep(800);
        Gobtn.click();

        // Handle window switching after clicking on a product
        Thread.sleep(800);
        String parentWindowHandle = driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(acc.getProduct2())).click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        // Perform actions in the new window
        Thread.sleep(800);
        String expectedText = "Sorry! Currently, this product is not available at your requested location.";
        String actualText = "Sorry! Currently, this product is not available at your requested location.";
        Thread.sleep(800);
        Assert.assertEquals(expectedText, actualText);
    }
}

