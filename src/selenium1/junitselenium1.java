package selenium1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class junitselenium1 {
	
	WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumJARS/chromedriver.exe"); // change as per source
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
	public void test_1() {

		WebElement overlay = driver.findElement(By.id("spotlight"));
		assertNotNull(overlay);
		overlay.click();
		
		WebElement searchbar = driver.findElement(By.id("search"));
		searchbar.sendKeys("the elder scrolls online tamriel unlimited 1");
		assertEquals("", searchbar.getText());
		

		WebElement searchbtn = driver.findElement(By.xpath("//*[@id='ls-header-search-button']"));
		assertTrue(searchbtn.getText().equals("Search"));
		searchbtn.click();
		
		WebElement selectdeal = driver.findElement(By.cssSelector("div.btn.disabled"));
		assertNotNull(selectdeal);
		selectdeal.click();
		
		WebElement dealoptions = driver.findElement(By.id("trait-0"));
		assertTrue(dealoptions.isDisplayed());
		dealoptions.click();
		
		WebElement suboptions = driver.findElement(By.id("trait-0-1"));
		assertFalse((suboptions.getText().contains("Playstation 4"))!= true);
		suboptions.click();
		
		WebElement buylink = driver.findElement(By.id("buy-link"));
		assertSame(new String("Buy").getClass(), buylink.getText().getClass());
		buylink.click();
		
		WebElement checkout = driver.findElement(By.id("bottom-proceed-to-checkout"));
		assertEquals("Proceed To Checkout", checkout.getText());
		checkout.click();
		
	}
	

}
