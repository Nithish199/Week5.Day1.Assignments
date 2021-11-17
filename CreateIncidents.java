package Week5.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateIncidents extends IncidentBaseClass {

	@Test
	public void runCreatIncident() throws InterruptedException {

		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		WebElement frame2 = driver.findElement(By.xpath("//div[@class='navpage-main-left ng-isolate-scope']/iframe"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Set<String> win1 = driver.getWindowHandles();
		List<String> setwin1 = new ArrayList<String>(win1);
		driver.switchTo().window(setwin1.get(1));
		driver.findElement(By.xpath("//span[@class='table-btn-lg']/following::a[1]")).click();
		driver.switchTo().window(setwin1.get(0));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("incident.short_description")).sendKeys("Automation Testing");
		String attribute = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(attribute);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		String text = driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
		if(attribute.equals(text)) {
			System.out.println("The incident was created successfully");
		}else
		{
			System.out.println("The incident was not created successfully");
		}

	}
}
