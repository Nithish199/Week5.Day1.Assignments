package Week5.Day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass{

	@Test
	public void runDeleteLead() throws InterruptedException {


	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8");
	driver.findElement(By.linkText("Find Leads")).click();
	Thread.sleep(3000);
	String text = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).getText();
	
	driver.findElement(By.linkText(text)).click();
	driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	String text2 = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
	
	if (text2.contains("No records to display")) {
		System.out.println("Verified");
	}else {
		System.out.println("Not Verified");
	}
	}
}
