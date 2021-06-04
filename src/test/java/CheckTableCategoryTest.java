import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.PageItem;
import pages.PageResults;

public class CheckTableCategoryTest extends AbstractTest {
	
	
	private String category1 = "TABLES";
	private String collectionItem1 = "Asian Wood";
	

	private String category2 = "BEDROOM";
	private String item2 = "Compact Night Table";

	@Before
	public void setup() {
		getBrowserFromProperty();
	}
	
	@Test
	public void test() {

		driver.get(shopizerURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		PageResults page_results = PageFactory.initElements(driver, PageResults.class);
		
		
		/* -------- TABLES test --------- */
		page_results = page_results.clickOnCategoryByName(driver, category1);
		assertEquals(true, page_results.checkItemsProps());
		
		page_results.clickOnCollectionItemByName(collectionItem1);
		
		page_results.setItemSelected(0);
		PageItem page_item = page_results.clickOnItemSelected(driver);
		assertEquals(true, page_item.checkItemProps(driver));
		
		

		/* -------- BEDROOM test --------- */
		page_results = page_item.clickOnCategoryByName(driver, category2);
		assertEquals(true, page_results.checkItemsProps());
		
		page_results.setItemSelected(item2);
		page_item = page_results.clickOnItemSelected(driver);
		assertEquals(true, page_item.checkItemProps(driver));
	}
}
