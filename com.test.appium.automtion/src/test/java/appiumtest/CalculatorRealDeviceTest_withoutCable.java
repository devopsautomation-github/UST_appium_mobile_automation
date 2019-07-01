package appiumtest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorRealDeviceTest_withoutCable {

	public static AppiumDriver driver;
	public WebElement frameLayout;

	public static void main(String[] args) {

		try {
			openCalcualtor();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void openCalcualtor() throws IOException {

		DesiredCapabilities capabilites = new DesiredCapabilities();
		// Phone
		capabilites.setCapability("udid", "192.168.0.100:5555");
		capabilites.setCapability("deviceName", "Mi 4");
		capabilites.setCapability("platformName", "Android");
		capabilites.setCapability("platformVersion", "5.0.2");

		capabilites.setCapability("appPackage", "com.miui.calculator");

		capabilites.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilites);

		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		System.out.println("Application started......");

		WebElement two = driver.findElement(By.id("btn_7_s"));
		two.click();
		WebElement plus = driver.findElement(By.id("btn_plus_s"));
		plus.click();
		WebElement four = driver.findElement(By.id("btn_9_s"));
		four.click();
		WebElement equalTo = driver.findElement(By.id("btn_equal_s"));
		equalTo.click();
		
		System.out.println("Program executed sucessfully......");

	}

}
