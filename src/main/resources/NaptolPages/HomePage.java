package NaptolPages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
       WebDriver driver;

public HomePage(WebDriver driver) {
		
		//Initializing driver using this keyword
		this.driver=driver;
		
		//use pagefactory to store driver in it.
		PageFactory.initElements(driver, this);
		
		
	}

@FindBy(className = "cate_head")
private WebElement Shoppingcategory;

@FindBy(xpath = "(//span[@class=\"catIconMenu electronics\"])[1]")
private WebElement Consumerslectronics;



public WebElement getShoppingcategory() {
	return Shoppingcategory;
}


public WebElement getConsumerelectronics() {
	return Consumerslectronics;
}


public boolean navigatetoconsumerselectronics() {
	Shoppingcategory.click();
	Consumerslectronics.click();
	return true;	
}
	

}
