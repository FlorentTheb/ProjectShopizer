import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractTest {

	protected EBrowser browser = EBrowser.chrome;// chrome par défaut
	protected WebDriver driver;
	protected String login = "ACID";
	protected String passwd = "ACID";
	
	protected String shopizerURL;
	
//	protected String ChromeURL = "http://localhost:8080/shopizer";
//	protected String FirefoxURL = "http://localhost:8080/shopizer";
//	protected String IEURL = "http://localhost:8080/shopizer";

	public void selectBrowser(EBrowser i) {
		if (i.equals(EBrowser.chrome)) {
			// chemin du driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			// Initialisation du navigateur Chrome
			driver = new ChromeDriver();

		} else if (i.equals(EBrowser.firefox)) {
			// chemin du driver
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			// Initialisation du navigateur Chrome
			driver = new FirefoxDriver();

		} else if (i.equals(EBrowser.edge)) {
			// chemin du driver
			System.setProperty("webdriver.edge.driver", "src/main/resources/driver/msedgedriver.exe");
			// Initialisation du navigateur Chrome
			driver = new EdgeDriver();
		}
	}

	public void getBrowserFromProperty() {
		String BROWSER = System.getProperty("browser");
		shopizerURL = System.getProperty("shopizerURL");
		System.out.println("Browser : " + BROWSER + "\nURL : " + shopizerURL);
		switch (BROWSER) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
//			driver.get(ChromeURL);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
//			driver.get(FirefoxURL);
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "src/main/resources/driver/msedgedriver.exe");
			driver = new EdgeDriver();
//			driver.get(IEURL);
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
	}
}
