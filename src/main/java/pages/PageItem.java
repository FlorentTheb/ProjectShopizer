package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageItem extends BannerHeader{
	
	@FindBy(xpath = "//*[@id='view1']/a/img")
	private WebElement itemImage;
	
	@FindBy(tagName = "h3")
	private WebElement itemTitle;
	
	@FindBy(xpath = "//*[@itemprop='price']")
	private WebElement itemPrice;
	
	@FindBy(xpath = "//*[@id='productPrice']/del")
	private WebElement itemPrevPrice;
	
	@FindBy(xpath = "//*[@class='specialPrice']/span")
	private WebElement itemSpecialPrice;
	
	@FindBy(xpath = "//*[@id='review']//*[@name='score']")
	private WebElement itemRating;
	
	@FindBy(xpath = "//button[contains(@class, 'addToCartButton')]")
	private WebElement addToCartButton;
	

	/* --------- Methods ----------- */
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	
	public boolean checkItemProps(WebDriver driver) {
		int checkPropsNumber = 0;
		if(!getItemImage().isEmpty()) {
			checkPropsNumber++;
		}
		if(!getItemTitle().getText().isEmpty()) {
			checkPropsNumber++;
		}
		if(!(driver.findElements(By.xpath("//*[@id='productPrice']/*")).size()<1)) {
			checkPropsNumber++;
		}
		if(!getItemRating().getAttribute("value").isEmpty()) {
			checkPropsNumber++;
		}
		if(!getAddToCartButton().getText().isEmpty()) {
			checkPropsNumber++;
		}
		
		if(checkPropsNumber == 4) {
			return true;
		} else return false;
		
	}
	
	
	/* --------- Getters ----------- */
	public WebElement getItemPrevPrice() {
		return itemPrevPrice;
	}

	public WebElement getItemSpecialPrice() {
		return itemSpecialPrice;
	}

	public WebElement getItemTitle() {
		return itemTitle;
	}

	public WebElement getItemPrice() {
		return itemPrice;
	}

	public WebElement getItemRating() {
		return itemRating;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public String getItemImage() {
		return itemImage.getAttribute("src");
	}
	
}
