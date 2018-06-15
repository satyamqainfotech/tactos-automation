import javax.swing.Spring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TACTOS {
	
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.cssSelector("a")).click();
		driver.findElement(By.className("greenbox")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("main")));
		driver.switchTo().frame("main");
		WebElement parent = driver.findElement(By.id("answer"));
		String mainAnswer = parent.getAttribute("class");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("child");
		WebElement child = driver.findElement(By.id("answer"));
		String expectedAnswer = child.getAttribute("class");
	
//		
		System.out.println(expectedAnswer);
		
//		driver.close();
	}
}
