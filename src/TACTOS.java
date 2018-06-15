import java.util.ArrayList;

import javax.swing.Spring;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TACTOS {
	
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.cssSelector("a")).click();
		driver.findElement(By.className("greenbox")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("main")));
		String actualAnswer = driver.findElement(By.id("answer")).getAttribute("class");		
		Boolean condition = true;
		while(condition) {
			driver.findElement(By.cssSelector("body > center > a:nth-child(7)")).click();
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("main")));
			WebElement childDiv = driver.findElement(By.id("child"));
			driver.switchTo().frame(childDiv);
			String expectedAnswer = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			if(actualAnswer.equals(expectedAnswer)) {
				condition = false;
			}
		}
		driver.findElement(By.cssSelector("body > center > a:nth-child(9)")).click();
		driver.switchTo().defaultContent();
//		Thread.sleep(5000);
		Actions act=new Actions(driver);
		// find element which we need to drag
		WebElement drag=driver.findElement(By.xpath(".//*[@id='dragbox']"));
		// find element which we need to drop
		WebElement drop=driver.findElement(By.xpath(".//*[@id='dropbox']"));
		act.dragAndDrop(drag, drop).build().perform();
		driver.findElement(By.cssSelector("body > div > div.page > a")).click();
		driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(4)")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.findElement(By.cssSelector("#name")).sendKeys("hello world");
		driver.findElement(By.cssSelector("#submit")).click();
	    driver.switchTo().window(tabs2.get(0));
	    driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(6)")).click();
	    driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(8)")).click();
	    String token = driver.findElement(By.cssSelector("#token")).getText();
	    String[] splited = token.split("\\s+");
	    
	    Cookie name = new Cookie("token", splited[1]);
	    	
	   
	    
//		driver.close();
	}
}
