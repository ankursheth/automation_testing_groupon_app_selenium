package selenium1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class junitselenium2 {
	
	WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumJARS/chromedriver.exe");  //change as per source
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.groupon.com/");
	    driver.findElement(By.id("nothx")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		
//		WebElement overlay = driver.findElement(By.id("spotlight"));
//		assertNotNull(overlay);
//		overlay.click();
		driver.get("https://www.groupon.com/login");
		
		WebElement emailinput = driver.findElement(By.id("email-input"));
		assertTrue(emailinput.isDisplayed());
		emailinput.sendKeys("razormantis112@gmail.com");
		
		WebElement passwordinput = driver.findElement(By.id("password-input"));
		passwordinput.sendKeys("SpiggyHoles");
		assertNotNull(passwordinput);

		
		WebElement login = driver.findElement(By.id("signin-button"));
		assertTrue(login.isEnabled());
		login.click();
		
		WebElement cartbtn = driver.findElement(By.id("ls-cart-link"));
		assertEquals("5", cartbtn.getText());
		cartbtn.click();
		
//		driver.findElement(By.xpath("//*[@id='ls-header-cart-link']/div/div[3]/div[2]/a")).click();
		WebElement contshopping = driver.findElement(By.linkText("Continue Shopping"));
		assertFalse(contshopping.isSelected());
		contshopping.click();
		
		WebElement searchbar = driver.findElement(By.id("search"));
		searchbar.sendKeys("mortal kombat");
		assertTrue(searchbar.isDisplayed());
		
		WebElement searchbtn = driver.findElement(By.xpath("//*[@id='ls-header-search-button']"));
		assertEquals("Search",searchbtn.getText());
		searchbtn.click();
		
		WebElement selectdeal = driver.findElement(By.cssSelector("div.btn.disabled"));
		assertNotNull(selectdeal);
		selectdeal.click();
		
		WebElement dealoptions = driver.findElement(By.id("trait-0"));
		assertTrue(dealoptions.getText().contains("PS4"));
		dealoptions.click();
		
		WebElement suboptions = driver.findElement(By.id("trait-0-1"));
		assertTrue(suboptions.isEnabled());
		suboptions.click();
		
		WebElement buylink = driver.findElement(By.id("buy-link"));
		assertEquals("Buy!", buylink.getText());
		buylink.click();
		
		WebElement checkout = driver.findElement(By.id("bottom-proceed-to-checkout"));
		assertEquals("Proceed To Checkout", checkout.getText());
		checkout.click();
	}

}
