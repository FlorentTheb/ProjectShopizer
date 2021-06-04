import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageResults;
import pages.PageShoppingCart;
import pages.Pagecheckout;


public class UseShoppingCartTest extends AbstractTest {
	
	String itemName[]= {"Compact Night Table","Edge Console"};
	
	@Before
	public void setup() {
		getBrowserFromProperty();
	}
	
	@Test
	public void run() throws InterruptedException {
		
		
		driver.get(shopizerURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		PageResults page_results = PageFactory.initElements(driver, PageResults.class);
		for(int i=0;i!=itemName.length;i++) {
			System.out.println(itemName[i]);
			page_results.setItemSelected(itemName[i]);
			page_results.clickAddToCartButton();
		}
		
		PageShoppingCart page_ShoppingCart = page_results.clickpaymentBt(driver);
		page_ShoppingCart.getItemsList();
		
		assertTrue("Image, title, price, or total price not present",page_ShoppingCart.checkItemsProps()); 
		
		page_ShoppingCart.setMultipleQuantityItems(2);
		
		page_ShoppingCart.clickOnBtRecalculate();
		
		Thread.sleep(2000);
		Pagecheckout page_Checkout = page_ShoppingCart.clickOnBtMakePayment(driver);
		
		
	
		
	}
}
