package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageShoppingCart {
	
	private WebElement itemSelected;

	@FindBy(xpath = "//td[@data-th='Article']//strong")
	private List<WebElement> itemsName;
	
	@FindBy(xpath = "//input[@name='quantity']")
	private List<WebElement> itemsQuantity;

	@FindBy(xpath = "//a[contains(.,'Recalculer')]")
	private WebElement recalculateBt;
	
	@FindBy(xpath = "//a[contains(.,'Effectuer le paiement')]")
	private WebElement makePaymenteBt;
	
	@FindBy(xpath = "//table[@id=\"mainCartTable\"]/tbody/tr")
	List<WebElement> itemsList;
	
	@FindBy(xpath = "//th[contains(.,'Total')]/parent::tr[@class=\"cart-subtotal\"]/descendant::span")
	private WebElement subTotalText;
	
	public void clickOnBtRecalculate() {
		recalculateBt.click();
	}
	
	public Pagecheckout clickOnBtMakePayment(WebDriver driver) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(makePaymenteBt);
		Thread.sleep(3000);
		makePaymenteBt.click();
		return PageFactory.initElements(driver, Pagecheckout.class);
	}

	public List<WebElement> getItemsQuantity() {
		return itemsQuantity;
	}

	public void setItemsQuantity(WebElement itemsQuantity, int nbrQuantity) {
		
		itemsQuantity.clear();
		itemsQuantity.sendKeys(Integer. toString(nbrQuantity));
	}
	
	public void setMultipleQuantityItems(int multiple) {
		int i=0;
		while(i<itemsList.size()) {
			itemSelected = itemsQuantity.get(i);
			int valQuantity = Integer.parseInt(itemSelected.getAttribute("value"));
			int result= valQuantity * multiple;
			setItemsQuantity(itemSelected,result);
			i++;
		}
	}

	public List<WebElement> getItemsList() {
		return itemsList;
	}

	public WebElement getSubTotalText() {
		return subTotalText;
	}
	
	public boolean checkItemsProps() {
		boolean check = true;
		int i=0;
		while(i<itemsList.size() && check) {
			itemSelected = itemsList.get(i);
			check = checkItemProps();
			i++;
		}
		if(check) {
			return true;
		} else return false;
	}
	
	private boolean checkItemProps() {
		int checkPropsNumber = 0;
		if(!getImageItemSelected().getAttribute("src").isEmpty()) {
			checkPropsNumber++;
		}
		if(!getTitleItemSelected().getText().isEmpty()) {
			checkPropsNumber++;
		}
		if(!getQuantityItemSelected().getText().isEmpty()) {
			checkPropsNumber++;
		}
		if(!getPriceItemSelected().getText().isEmpty()) {
			checkPropsNumber++;
		}
		if(!getTotalPriceItemSelected().getText().isEmpty()) {
			checkPropsNumber++;
		}
		
		if(checkPropsNumber == 4) {
			return true;
		} else return false;
		
	}
	
	public WebElement getTitleItemSelected() {
		return itemSelected.findElement(By.xpath("td[@data-th='Article']/descendant::strong"));
	}
	
	public WebElement getQuantityItemSelected() {
		return itemSelected.findElement(By.xpath("td[@data-th='Quantité']/input"));
	}
	
	public WebElement getPriceItemSelected() {
		return itemSelected.findElement(By.xpath("td[@data-th='Prix']/strong"));
	}
	public WebElement getTotalPriceItemSelected() {
		return itemSelected.findElement(By.xpath("td[@data-th='Total']/strong"));
	}
	
	public WebElement getImageItemSelected() {
		return itemSelected.findElement(By.xpath("td[@data-th='Article']/descendant::img"));
	}
}
