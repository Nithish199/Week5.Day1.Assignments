package Week5.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncidents extends IncidentBaseClass{

	@Test
	public void runDeleteIncidents() throws InterruptedException {
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		WebElement frame2 = driver.findElement(By.xpath("//div[@class='navpage-main-left ng-isolate-scope']/iframe"));
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.id("ok_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("//tbody[@class='list2_body']//td")).getText();
		
		if(text2.equalsIgnoreCase("No Records To display here")) {
			System.out.println("The delete incident is verified");
		}else
		{
			System.out.println("The incident is not deleted");
		}
		
		
	}
}
