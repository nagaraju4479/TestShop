package com.testShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testShop.utils.Elements;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
			}
	By mainMenuLink = By.linkText("Men");
			
	By subMenuLink = By.linkText("Men Footwear");
	
	By productLink = By.xpath("//a[text()='Elegant Korai Floor Mats Set']");
	
	public String getProductLinkText()
	{
		return Elements.getWebElement(driver, productLink).getText();
	}
	
	public String getProductPageTile()
	{
		return driver.getTitle();
	}

}
