import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import pages.PageResults;

public class CheckTableCategoryTest extends AbstractTest {
	

	private String URL = "http://localhost:8080/shopizer";

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
	}
}
