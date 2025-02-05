package com.testShop.pages;

import org.openqa.selenium.WebDriver;

import com.testShop.utils.Elements;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void getProductDetailsPageTitle()
	{
	    Elements.getPageTitle(driver);
	}

}
