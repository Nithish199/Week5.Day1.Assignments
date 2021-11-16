package Week5.Day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
@Test
	public void runCreateLead() {
		 driver.findElement(By.linkText("Create Lead")).click();
		 driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		 driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Nithish");
		 driver.findElement(By.id("createLeadForm_lastName")).sendKeys("K");
		 driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
		 driver.findElement(By.name("submitButton")).click();
		 
	}
}
