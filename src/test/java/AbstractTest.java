import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractTest {

	protected EBrowser browser = EBrowser.chrome;// chrome par défaut
	protected WebDriver driver;
	protected String login = "ACID";
	protected String passwd = "ACID";

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
		switch (BROWSER) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "src/main/resources/driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
//		if(BROWSER == "chrome") {
//			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
//			driver = new ChromeDriver();
//		} else if(BROWSER == "firefox") {
//			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
//			driver = new FirefoxDriver();
//		} else if(BROWSER == "edge") {
//			System.setProperty("webdriver.edge.driver", "src/main/resources/driver/msedgedriver.exe");
//			driver = new EdgeDriver();
//		}
	}
}
