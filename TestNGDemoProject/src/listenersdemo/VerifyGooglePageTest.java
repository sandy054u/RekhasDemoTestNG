package listenersdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({listenersdemo.Listenerimplementation.class})
public class VerifyGooglePageTest {
	WebDriver driver;
@BeforeMethod
public void setbrowser()
{
	System.setProperty("webdriver.chrome.driver", "D:\\Seleniumlp10software\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test
public void checkurl(){
	String title=driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title, "google");
}

@Test(priority=1)
public void checklogo(){
	boolean view=driver.findElement(By.id("hplogo")).isDisplayed();
	Assert.assertTrue(view);
}

@AfterMethod
public void closebrowser()
{
	driver.quit();
}
}
