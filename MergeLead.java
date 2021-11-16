package Week5.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MergeLead extends BaseClass{
	
	@Test
	public void runMergeLead() throws InterruptedException {
		
		driver.findElement(By.linkText("Merge Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(allWindows.get(1));		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Nithish");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		String text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allWindows.get(0));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> allWindows2= new ArrayList<String>(windowHandles2);
		driver.switchTo().window(allWindows2.get(1));		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allWindows2.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String text2 = driver.findElement(By.className("x-paging-info")).getText();
		
		if(text2.equals("No Records to display")) {
			System.out.println("Text Macthes");
		}else
		{
			System.out.println("Text does't Macthed");
		}
		
	}

}
