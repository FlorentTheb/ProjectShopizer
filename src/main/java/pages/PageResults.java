package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
			itemSelected = itemsResultList.get(i);
			System.out.println("Check item " + i + " ... :");
			check = checkItemProps();
			i++;
		}
		if(check) {
			return true;
		} else return false;
	}
	
	private boolean checkItemProps() {
		int checkPropsNumber = 0;
		System.out.println("checking img ...");
		if(!getImageItemSelected().getAttribute("src").isBlank()) {
			checkPropsNumber++;
		}
		System.out.println("checking title ...");
		if(!getTitleItemSelected().getText().isBlank()) {
			checkPropsNumber++;
		}
		System.out.println("checking price ...");
		if(!getPriceItemSelected().getText().isBlank()) {
			checkPropsNumber++;
		}
		System.out.println("checking button ...");
		if(!getAddToCartButton().getText().isBlank()) {
			checkPropsNumber++;
		}
		
		if(checkPropsNumber == 4) {
			return true;
		} else return false;
		
	}
	
	public void clickOnCollectionItemByName(String collectionName) {
		collection.findElement(By.xpath("//a[contains(text(), '" + collectionName + "')]")).click();
	}
	
	
	public void setItemSelected(int itemIndex) {
		itemSelected = itemsResultList.get(itemIndex);
	}
	
	public void setItemSelected(String itemName) {
		for(int i=0; i<itemsResultList.size(); i++) {
			if(itemsResultList.get(i).findElement(By.xpath("//h3")).getText().equals(itemName)) {
				itemSelected = itemsResultList.get(i);
			}
		}
	}
	
	public PageItem clickOnItemSelected(WebDriver driver) {
		
		itemSelected.findElement(By.xpath("/div[@class='product-content text-center']/a")).click();
		return PageFactory.initElements(driver, PageItem.class);
	}
	
	public WebElement getTitleItemSelected() {
		return itemSelected.findElement(By.xpath("//h3"));
	}
	
	public WebElement getPriceItemSelected() {
		return itemSelected.findElement(By.xpath("//h4/span"));
	}
	
	public WebElement getAddToCartButton() {
		return itemSelected.findElement(By.xpath("//a[@class='addToCart']"));
	}
	
	public void clickAddToCartButton() {
		itemSelected.findElement(By.xpath("//a[@class='addToCart']")).click();
	}
	
	public WebElement getImageItemSelected() {
		return itemSelected.findElement(By.xpath("/div/a/img"));
	}
}
