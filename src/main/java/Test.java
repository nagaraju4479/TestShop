import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	//Variables
	private static WebDriver driver = new ChromeDriver();
	
	
	//Locators 
	//private static By nameBy = By.id("textbox");
	//private static By nameBy = By.name("textbox");
	
	//Methods
	
	public static void webElement()
	{
		driver.manage().window().maximize();
		driver.get("https://www.softwaretestingonline.com/2024/09/WebElements.html");
		
		
	}

	public static void main(String[] args) {
		
		
		webElement();

	}

}
