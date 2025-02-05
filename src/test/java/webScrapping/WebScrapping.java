package webScrapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testShop.driverManager.DriverManager;
import com.testShop.utils.Constants;
import com.testShop.utils.Elements;

public class WebScrapping {
	
	WebDriver driver;
	
	By productList = By.xpath("//div[@class='sc-dkrFOg ProductList__GridCol-sc-8lnc8o-0 cokuZA eCJiSA']"); // XPath for product container
	By productTitle = By.xpath("//*[contains(@class, 'sc-eDvSVe') and contains(@class, 'fhfLdV')]"); // XPath for product title
	By productDescription = By.xpath("//*[contains(@class, 'sc-ftTHYK') and contains(@class, 'jfdUoi') and contains(@class, 'ProductDescription__DetailsCardStyled-sc-1l1jg0i-0') and contains(@class, 'eFKyvM')]\r\n"
			+ ""); // XPath for product description
	By productPrice = By.xpath("//*[contains(@class, 'sc-eDvSVe') and contains(@class, 'biMVPh')]"); // XPath for product price
	By imageElement = By.xpath("//div[contains(@class, 'ProductDesktopImage__ImageWrapperDesktop-sc-8sgxcr-0')]//img");

	
	public WebDriver webScrapping() throws IOException {
		driver = DriverManager.initDriver();
		//driver.get("https://example.com/products"); // Replace with your actual products page URL
		return driver;
	}
	
	public static void main(String args[]) throws IOException, InterruptedException {
		
		WebScrapping scrapping = new WebScrapping();
		WebDriver driver = scrapping.webScrapping();
		
		// Initialize WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Constants.maxWaitTime);
		
		// List to store product information
		List<String> productInfoList = new ArrayList<String>();
		
		// Loop through the first 8 products
		for (int i = 0; i < 8; i++) {
			// Find product elements again due to navigation changes (driver navigates back)
			List<WebElement> products = driver.findElements(scrapping.productList);
			WebElement product = products.get(i);
			//System.out.println(products);
			// Click on the product to navigate to the product details page
			product.click();
			
			// Wait until the product details are loaded
			wait.until(ExpectedConditions.visibilityOfElementLocated(scrapping.productTitle));
			
			// Extract product details from the product details page
			String title = Elements.getText(driver, scrapping.productTitle);
			String description = Elements.getText(driver, scrapping.productDescription);
			String imageUrl = driver.findElement(scrapping.imageElement).getAttribute("src");
			String price = Elements.getText(driver, scrapping.productPrice);
			
			// Add product details to the list
			productInfoList.add( "product Name:"+title + " \n\n "+"Product description"+"\n" + description + "\n\n"+"Image Url:"+imageUrl+"\n\n");
			
			
			// Navigate back to the product listing page
			driver.navigate().back(); // This assumes you can use the browser's back button
			wait.until(ExpectedConditions.visibilityOfElementLocated(scrapping.productList)); // Wait until product list is visible
			
			Thread.sleep(2000); // Add sleep to allow page to fully load, if needed
		}
		
		// Print the product information
		for (String productInfo : productInfoList) {
			System.out.println(productInfo);
		}
		
		// Close the browser
		driver.quit();
	}
}
