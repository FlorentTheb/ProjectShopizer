package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageItem {
	
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
	
	
}
