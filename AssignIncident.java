package Week5.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignIncident extends IncidentBaseClass{

	@Test
	public void runAssignIncident() throws InterruptedException {
		driver.findElement(By.xpath("(//div[text()='open'])[1]")).click();
		WebElement frame2 = driver.findElement(By.xpath("//div[@class='navpage-main-left ng-isolate-scope']/iframe"));
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> win1 = driver.getWindowHandles();
		List<String> setwin1 = new ArrayList<String>(win1);
		driver.switchTo().window(setwin1.get(1));
		driver.findElement(By.xpath("(//td[@class='text-align-right']//button)[3]")).click();
		String text2 = driver.findElement(By.xpath("//a[text()='Software']")).getText();
		driver.switchTo().window(setwin1.get(0));
		Thread.sleep(3000);
		WebElement frame3 = driver.findElement(By.xpath("//div[@class='navpage-main-left ng-isolate-scope']/iframe"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("(//div[@class='col-xs-10 col-lg-8 form-field']//textarea)[3]")).sendKeys("assignmentservicenow");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		String text3 = driver.findElement(By.xpath("(//tbody[@class='list2_body']//td/a)[4]")).getText();
		if(text3.contains("Software")) {
			System.out.println("Assignment group verified successfully");
		}else
		{
			System.out.println("Assignment group was not verified");
		}
	
	
	}
}
