package NaptolTest;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import NaptolPages.*;
import Utils.Screenshot;

/**
 * This class contains test methods for the Consumer Electronics section of the Naaptol website.
 * It extends the Basetest class which provides common setup and teardown operations.
 */
public class ConsumerElectronicsTest extends Basetest {
    // Page objects
    private HomePage home;
    private ConsumerElectronicsPage consumers;
    private Accessoriespage accessories;
    private PortableDevices portable;
    private SecuirityandgadgetPage sgp;
    private HomeEntertainmentPage hep;

    // ExtentReports objects for test reporting
    private ExtentReports extent;
    private ExtentTest test;
    TakesScreenshot ts;
    Screenshot ss = new Screenshot();

    /**
     * Sets up the ExtentReports before the test class is run.
     * @throws IOException 
     */
    @BeforeClass
    public void reportSetup() throws IOException {
        extent = new ExtentReports("C:\\eclipse-workspace\\Assessment\\Report.html", true);
        test = extent.startTest("Consumer Electronics Test Suite");
       // ss.capture(driver, 0);
        
    }

    /**
     * Logs the start of each test method. 
     */
    @BeforeMethod
    public void testSetup() {
        test.log(LogStatus.INFO, "Consumers Accessories Module Testing");
    }

    /**
     * Tests navigation to the consumer electronics page and adding a product to the cart.
     * @throws IOException 
     */
    @Test(priority = 0)
    public void navigationAndSearchingTest() throws InterruptedException, IOException {
        home = new HomePage(driver);
        test.log(LogStatus.PASS, "Navigation test");
        boolean navigationTest = home.navigatetoconsumerselectronics();
        test.log(LogStatus.PASS, "Navigate to consumer electronics");
        Assert.assertTrue(navigationTest, "Successfully navigate to electronics page");
        Reporter.log("Successfully navigate to electronics page", true);
        ss.capture(driver, 0);
        
        consumers = new ConsumerElectronicsPage(driver);
        boolean addToCartTest = consumers.searchproductandaddtocart(productname);
        test.log(LogStatus.PASS, "Searching product and checking results");
        Assert.assertTrue(addToCartTest, "Product is successfully added to the cart");
        Reporter.log("Product is successfully added to the cart", true);
        test.log(LogStatus.PASS, "Add to cart");
        ss.capture(driver, 1);
    }

 

	/**
     * Tests the Electronics and Accessories page functionality.
	 * @throws IOException 
     */
    @Test(priority = 1)
    public void electronicsAndAccessoriesTest() throws InterruptedException, IOException {
        home = new HomePage(driver);
        home.navigatetoconsumerselectronics();
        accessories = new Accessoriespage(driver);
        boolean radioBtnTest = accessories.ElectronicsAccessories();
        ss.capture(driver, 2);
        test.log(LogStatus.PASS, "Testing radio buttons in Electronics Accessories");
        Assert.assertTrue(radioBtnTest, "All radio buttons are working");
        Reporter.log("All radio buttons are working", true);
        ss.capture(driver, 3);
    }

    /**
     * Tests the Portable Devices page functionality.
     * @throws IOException 
     */
    @Test(priority = 2)
    public void portableDevicesTest() throws InterruptedException, IOException {
        home = new HomePage(driver);
        home.navigatetoconsumerselectronics();
        portable = new PortableDevices(driver);
        boolean devicesDisplayed = portable.portabledevices();
        ss.capture(driver, 4);
        test.log(LogStatus.PASS, "Testing portable devices display");
        Assert.assertTrue(devicesDisplayed, "Portable devices displayed correctly");
        test.log(LogStatus.PASS, "Portable devices displayed correctly");
        Reporter.log("Portable devices displayed correctly", true);
    }

    /**
     * Tests the Security and Gadget page functionality.
     * @throws IOException 
     */
    @Test(priority = 3)
    public void securityAndGadgetTest() throws InterruptedException, IOException {
        sgp = new SecuirityandgadgetPage(driver);
        test.log(LogStatus.PASS, "Testing security devices with pincode");
        home = new HomePage(driver);
        home.navigatetoconsumerselectronics();
        ss.capture(driver, 5);
        sgp.secuiritydevices(pincode);
        ss.capture(driver, 6);
        test.log(LogStatus.PASS, "Pincode check successful");
    }

    /**
     * Tests the Home Entertainment page functionality.
     * @throws IOException 
     */
    @Test(priority = 4)
    public void homeEntertainmentPageTest() throws InterruptedException, IOException {
        hep = new HomeEntertainmentPage(driver);
        home = new HomePage(driver);
        test.log(LogStatus.PASS, "Testing home entertainment page");
        home.navigatetoconsumerselectronics();
        ss.capture(driver, 7);
        test.log(LogStatus.PASS, "Switching window and completing the checkout process");
        hep.homeentertainment(pincode, qty);
        ss.capture(driver, 8);
    }

    /**
     * Tests the Portable Audio page functionality.
     * @throws IOException 
     */
    @Test(priority = 5)
    public void portableAudioPageTest() throws InterruptedException, IOException {
        home = new HomePage(driver);
        home.navigatetoconsumerselectronics();
        PortableAudiosPage pop = new PortableAudiosPage(driver);
        pop.portableaudio(from, to, pincode);
        ss.capture(driver, 9);
        test.log(LogStatus.PASS, "Successfully tested the entertainment page");
    }

    /**
     * Tests the Printers page functionality.
     * @throws IOException 
     */
    @Test(priority = 6)
    public void printersPageTest() throws InterruptedException, IOException {
        home = new HomePage(driver);
        home.navigatetoconsumerselectronics();
        PrintersPage pg = new PrintersPage(driver);
        pg.printers();
        ss.capture(driver, 10);
        test.log(LogStatus.PASS, "Clicking on the different images");
        test.log(LogStatus.PASS, "Successfully tested the printing page");
    }

    /**
     * Logs the result of each test method after it's run.
     */
    @AfterMethod
    public void getResult(org.testng.ITestResult result) {
        if (result.getStatus() == org.testng.ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
        } else if (result.getStatus() == org.testng.ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        }
    }

    /**
     * Finalized the ExtentReports after all tests have run.
     */
    @AfterClass
    public void endReport() {
        extent.endTest(test);
        extent.flush();
    }
}
