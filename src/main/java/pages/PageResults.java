package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageResults extends BannerHeader{

	@FindBy(xpath = "//*[not(@id='hiddenProductsContainer')]/div/div/a/h3[@itemprop='name']/parent::a/parent::div/parent::div")
	private List<WebElement> itemsResultList;

	@FindBy(xpath = "//h3[contains(text(), 'Collection')]/following-sibling::ul")
	private WebElement collection;
	
	private WebElement itemSelected;
	
	
	public boolean checkItemsProps() {
		boolean check = true;
		int i=0;
		while(i<itemsResultList.size() && check) {
			setItemSelected(i);
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
		if(!(itemSelected.findElements(By.xpath("div/h4/*")).size()<1)) {
			checkPropsNumber++;
		}
		if(!getAddToCartButton().getText().isEmpty()) {
			checkPropsNumber++;
		}
		
		if(checkPropsNumber == 4) {
			return true;
		} else return false;
		
	}
	
	public void clickOnCollectionItemByName(WebDriver driver, String collectionName) throws InterruptedException {
		WebElement collectionSelected = collection.findElement(By.xpath("//a[contains(text(), '" + collectionName + "')]"));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		collectionSelected.click();
	}
	
	
	public void setItemSelected(int itemIndex) {
		itemSelected = itemsResultList.get(itemIndex);
	}
	
	public void setItemSelected(String itemName) {
		int i = 0;
		boolean checkOK = true;
		while(i<itemsResultList.size() && checkOK) {
			if(itemsResultList.get(i).findElement(By.xpath("div/a/h3")).getText().equals(itemName)) {
				itemSelected = itemsResultList.get(i);
				checkOK = false;
			}
			i++;
		}
	}
	
	public PageItem clickOnItemSelected(WebDriver driver) throws InterruptedException {
		WebElement itemToClick = itemSelected.findElement(By.xpath("div[@class='product-content text-center']/a/h3"));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		itemToClick.click();
		return PageFactory.initElements(driver, PageItem.class);
	}
	
	public WebElement getTitleItemSelected() {
		return itemSelected.findElement(By.xpath("//h3"));
	}
	
	public WebElement getPriceItemSelected() {
		return itemSelected.findElement(By.xpath("div/h4/span"));
	}
	
	public WebElement getAddToCartButton() {
		return itemSelected.findElement(By.xpath("div/div/div/a[@class='addToCart']"));
	}
	
	public void clickAddToCartButton(WebDriver driver) throws InterruptedException {
		WebElement addToCartButton = itemSelected.findElement(By.xpath("div/div/div/a[@class='addToCart']"));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		addToCartButton.click();
	}
	
	public WebElement getImageItemSelected() {
		WebElement itemToCheck = itemSelected.findElement(By.xpath("div/a/img"));
		return itemToCheck;
	}
}
