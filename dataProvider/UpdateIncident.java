package Week5.Day2.dataProvider;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Week5.Day2.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident{
	
	@Test(dataProvider="readData2")
	public void runUpdateIncident(String u,String p,String f) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev107451.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame1 = driver.findElement(By.xpath("//div[@class='navpage-main-left ng-isolate-scope']/iframe"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("user_name")).sendKeys(u);
		driver.findElement(By.id("user_password")).sendKeys(p);
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("filter")).sendKeys(f);
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		Thread.sleep(2000);
		WebElement frame2 = driver.findElement(By.xpath("//div[@class='navpage-main-left ng-isolate-scope']/iframe"));
		driver.switchTo().frame(frame2);
		String text = driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
		driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
		driver.findElement(By.xpath("(//select[@role='listbox'])[4]")).sendKeys("In Progress");
		driver.findElement(By.xpath("(//select[@role='listbox'])[6]")).sendKeys("1 - High");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text,Keys.ENTER);
		String text2 = driver.findElement(By.xpath("(//tbody[@class='list2_body']//td)[14]")).getText();
		String text3 = driver.findElement(By.xpath("(//td[text()='In Progress'])")).getText();
		if(text2.contains("High") && text3.contains("In Progress")) {
			System.out.println("State and urgency verified");
		}else
		{
			System.out.println("State and urgency not verified");
		}
		driver.close();
		
	}
	@DataProvider
	public String[][] readData2() throws IOException{
		ReadExcel exl2=new ReadExcel();
		String[][] readdata2=exl2.readdata("servicenow2");
		return readdata2;
	}
		
	}


