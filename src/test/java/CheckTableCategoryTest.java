import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.PageItem;
import pages.PageResults;

public class CheckTableCategoryTest extends AbstractTest {
	

	private String URL = "http://localhost:8080/shopizer";
	
	
	private String category1 = "Tables";
	private String collectionItem1 = "Asian Wood";

	@Before
	public void setup() {
		getBrowserFromProperty();
	}
	
	@Test
	public void test() {

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		PageResults page_results = PageFactory.initElements(driver, PageResults.class);
		page_results.clickOnCategoryByName(category1);
		
		assertEquals(true, page_results.checkItemsProps());
		
		page_results.clickOnCollectionItemByName(category1);
		
		page_results.setItemSelected(0);
		PageItem page_item = page_results.clickOnItemSelected(driver);
		assertEquals(true, page_item.checkItemProps());
		
	}
}
