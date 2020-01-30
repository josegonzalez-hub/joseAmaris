package amaris;

//import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.JavascriptExecutor;

public class Test1
{
	private WebDriver driver;
	
	By localizador_Id=By.id("V2020-MUJER-ULTIMA_SEMANA-TEXT");
	By localizador_porXPath=By.xpath("//span[@class='size-name-container'][contains(.,'XS')]");
	By localizador_porXPath2=By.xpath("//button[@class='button button-primaryB button-big _add-to-cart-btn']");
	By localizador_porXPath3=By.xpath("(//span[contains(.,'Eliminar')])[2]");
	
	@Before
	//con Chrome no funciona:
	/*public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe --whitelist-ip 192.168.56.1");
				
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zara.com/es/");
	}*/
	
	//con Edge:
	public void setUp() 
	{
		System.setProperty("webdriver.edge.driver","./src/test/resources/MicrosoftWebDriver.exe");
		driver=new EdgeDriver();
		driver.get("https://www.zara.com/es/");
	}

	//@After

	@Test
	public void accessMenu() throws Exception  
	{
		 driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 driver.findElement(localizador_Id).click();
		 driver.get("https://www.zara.com/es/es/vestido-midi-drapeado-p02392703.html?v1=39378927&v2=1445759");
		 driver.findElement(localizador_porXPath).click();
		 driver.findElement(localizador_porXPath2).click();
		 Thread.sleep(2000);
		 driver.get("https://www.zara.com/es/es/shop/cart-v2");
		 Thread.sleep(1000);
		
		 js.executeScript("window.scrollBy(0,500)"); 
		 		 	 
		 driver.findElement(localizador_porXPath3).click();
		 js.executeScript("window.scrollBy(0,-500)"); 
		 Thread.sleep(1000);
		 driver.navigate().back();
		 driver.navigate().back();
		 driver.navigate().back();
		 Thread.sleep(1000);
		 driver.navigate().back();
	}
	
}
