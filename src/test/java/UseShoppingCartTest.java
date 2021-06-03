import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.PageResults;


public class UseShoppingCartTest extends AbstractTest {
	
	String URL="http://192.168.1.72:8080/shopizer/";
	String itemName[]= {"Compact night table","Edge console"};
	
	
	@Before
	public void setup() {
		getBrowserFromProperty();
	}
	
	@Test
	public void run() {
		
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		PageResults page_results = PageFactory.initElements(driver, PageResults.class);
		for(int i = itemName.length;i!=itemName.length;i++) {
			page_results.setItemSelected(itemName[i]);
		}
		
		
	}
}
