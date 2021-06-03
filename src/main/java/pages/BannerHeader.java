package pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
		
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(ShoppingCartBt).build().perform();
	}
	
	public List<WebElement> getMiniCartDetails(WebDriver driver) {
		return miniCartDetails;
	}
	
	public PageShoppingCart clickpaymentBt(WebDriver driver) {
		hoverShoppingCart(driver);
		paymentBt.click();
		return PageFactory.initElements(driver, PageShoppingCart.class);
	}
	
	public void clickOnCategoryByName(String categoryName) {

		for(int i=0; i<categoriesList.size(); i++) {
			if(categoriesList.get(i).getText().equals(categoryName)) {
				categoriesList.get(i).click();
			}
		}
	}
	
	
}
