package com.acti.base;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverScript {


	 public static WebDriver driver;
	 Properties prop;

	 public DriverScript() {
	  try {
	   File src = new File("./atconfig/config.properties");
	   FileInputStream fis = new FileInputStream(src);
	   prop = new Properties();
	   prop.load(fis);
	  } catch (Exception e) {
	   e.printStackTrace();
	   System.out.println("unable to load prop file");
	  }
	 }

	 @Test
	 public void initapp() {
		 
		  String browser = prop.getProperty("browser");

		  if (browser.equalsIgnoreCase("chrome")) {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\majid\\Downloads\\chromedriver_win32\\chromedriver.exe");

		    driver = new ChromeDriver();
		  } else if (browser.equalsIgnoreCase("firefox")) {
		   System.setProperty("webdriver.gecko.driver", "C:\\Users\\majid\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");

		   driver= new FirefoxDriver();
		  } else {
		   System.out.println("provide valid browser name");

		  }

		  driver.manage().window().maximize();
		  launchURL();
		 }

		 public void launchURL() {
		  String url = prop.getProperty("url");
		  driver.get(url);

		 }

		 public void quitDriver() {
		  driver.quit();
		 }

		

	 }


	 
	 
