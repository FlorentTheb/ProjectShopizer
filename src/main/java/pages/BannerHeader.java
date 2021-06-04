package pages;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BannerHeader {

	@FindBy(xpath = "//a[contains(text(),\"Panier\")]")
	private WebElement ShoppingCartBt;
	
	@FindBy(xpath = "//a[contains(text(),\"Paiement\")]")
	private WebElement paymentBt;
	
	@FindBy(xpath = "//*[@id='miniCartDetails']")
	private List<WebElement> miniCartDetails;
	
	@FindBy(xpath = "//*[@class='mainmenu hidden-xs']/nav/ul/li/a")
	private List<WebElement> categoriesList;
	
	private void hoverShoppingCart(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ShoppingCartBt);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(ShoppingCartBt).build().perform();
	}
	
	public List<WebElement> getMiniCartDetails(WebDriver driver) {
		return miniCartDetails;
	}
	
	public PageShoppingCart clickpaymentBt(WebDriver driver) {
		hoverShoppingCart(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(paymentBt));
		paymentBt.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}
	
	public PageResults clickOnCategoryByName(WebDriver driver, String categoryName) throws InterruptedException {
		Thread.sleep(3000);
		boolean clickOK = true;
		int i = 0;
		while(i<categoriesList.size() && clickOK) {
			if(categoriesList.get(i).getText().equals(categoryName)) {
				categoriesList.get(i).click();
				clickOK = false;
			}
			i++;
		}
		return PageFactory.initElements(driver, PageResults.class);
	}
	
	
}
