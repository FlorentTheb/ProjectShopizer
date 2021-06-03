package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageShoppingCart {

	@FindBy(xpath = "//td[@data-th='Article']//strong")
	private List<WebElement> itemsName;
	
	@FindBy(xpath = "//input[@name='quantity']")
	private List<WebElement> itemsQuantity;

	@FindBy(xpath = "//a[contains(.,'Recalculer')]")
	private WebElement recalculateBt;
	
	@FindBy(xpath = "//a[contains(.,'Effectuer le paiement')]")
	private WebElement MakePaymenteBt;
	
	@FindBy(xpath = "//table[@id=\"mainCartTable\"]/tbody/tr")
	List<WebElement> itemsList;
	
	@FindBy(xpath = "//th[contains(.,'Total')]/parent::tr[@class=\"cart-subtotal\"]/descendant::span")
	private WebElement subTotalText;
	
	public void clickOnBtRecalculate() {
		recalculateBt.click();
	}
	
	public Pagecheckout clickOnBtMakePayment(WebDriver driver) {
		MakePaymenteBt.click();
		return PageFactory.initElements(driver, Pagecheckout.class);
	}

	public List<WebElement> getItemsQuantity() {
		return itemsQuantity;
	}

	public void setItemsQuantity(WebElement itemsQuantity, int nbrQuantity) {
		
		itemsQuantity.clear();
		itemsQuantity.sendKeys(Integer. toString(nbrQuantity));
	}

	public List<WebElement> getItemsList() {
		return itemsList;
	}

	public WebElement getSubTotalText() {
		return subTotalText;
	}
}
