package TestNG1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Dataproviders {
	public WebDriver driver;
	Workbook wb;
	
	@BeforeMethod()
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	@DataProvider(name="getdata")
	public Object[] []  getdata() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Object[][] data=new Object[2][2]; 
		data[0][0]="admin";
		data[0][1]="admin@009";
		data[1][0]="admin";
		data[1][1]="admin009";
//		return data;
//		 String  p="D:\\eclipse\\20190918\\SaralTdsPart2\\DATA\\LOGIN.xlsx";
//		 String s="LOGIN";
//		 String un=Excel.getdata(p,s,0,0);
//		 String pwd=Excel.getdata(p,s,0,1);
//		 String un1=Excel.getdata(p,s,1,0);
//		 String pwd1=Excel.getdata(p,s,1,1);
//		 data[0][0]=un;
//		 data[0][0]=pwd;
//		 data[1][0]=un1;
//		 data[1][1]=pwd1;
		 
		 return data;
		
	}
	
	@Test(dataProvider="getdata",priority=1)
	public void login(String un,String pwd) throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get("http://192.168.2.25/SaralTDSCB/Authentication/Login.aspx");
		driver.findElement(By.xpath("//input[contains(@id,'txtUsername')]")).sendKeys(un);
		driver.findElement(By.xpath("//input[contains(@id,'txtPassword')]")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[contains(@id,'btnLogin')]")).click();
		driver.findElement(By.xpath("//option[contains(text(),'87590 - 87590')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'btnSelect')]")).click();
		String homepage = driver.getTitle();
		System.out.println(homepage);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "http://192.168.2.25/SaralTDSCB/Shared/Home.aspx");
		//Assert.assertEquals(homepage, "SaralTDS Web - Home");
		driver.findElement(By.xpath("(//a[contains(text(),'Show')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(.,'Logout')]\r\n" + 
			"")).click();
		driver.close();
	}
	@Test(dataProvider="getdata",priority=2)
	public void login1(String un,String pwd) throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get("http://192.168.2.25/SaralTDSCB/Authentication/Login.aspx");
		driver.findElement(By.xpath("//input[contains(@id,'txtUsername')]")).sendKeys(un);
		driver.findElement(By.xpath("//input[contains(@id,'txtPassword')]")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[contains(@id,'btnLogin')]")).click();
		driver.findElement(By.xpath("//option[contains(text(),'87590 - 87590')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'btnSelect')]")).click();
		String homepage = driver.getTitle();
		System.out.println(homepage);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "http://192.168.2.25/SaralTDSCB/Shared/Home.aspx");
		//Assert.assertEquals(homepage, "SaralTDS Web - Home");
		driver.findElement(By.xpath("(//a[contains(text(),'Show')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(.,'Logout')]\r\n" + 
			"")).click();
		driver.close();
	}
	

}
