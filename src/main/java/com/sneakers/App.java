package com.sneakers;

import java.awt.AWTException;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class App 
{
    
    public static void main( String[] args ) throws InterruptedException, AWTException
    {
    ChromeOptions options = new ChromeOptions();
    RandomUserAgent rand = new RandomUserAgent();
    cookie ck = new cookie();
     options.addArguments("window-size=1280,800");
     options.addArguments("user-agent="+rand.getRandomUserAgent());
     options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
     options.addArguments("--disable-blink-features");
     options.addArguments("--disable-blink-features=AutomationControlled");
     WebDriver driver=new ChromeDriver(options); 
     if(ck.loadCookie()!=null) {
     	Cookie cookie = ck.loadCookie();
     	driver.manage().addCookie(cookie);
     }
     driver.manage().window().maximize(); 
     System.setProperty("webdriver.chrome.driver", "/home/johnathan/Documents/sneakers/sneakers/chromedriver");
     driver.get("https://www.nike.com/login");
   
     WebElement username=driver.findElement(By.name("emailAddress")); 
     WebElement password=driver.findElement(By.name("password")); 
     WebElement login=driver.findElement(By.className("loginSubmit")); 
     username.sendKeys("jchan0867@gmail.com");
     password.sendKeys("Kempas7156h");
     Thread.sleep(5000);
     
     login.click(); 
     
     ck.addCookie(driver.manage().getCookies());
     
     String actualUrl="https://www.nike.com/login"; 
     String expectedUrl= driver.getCurrentUrl(); 
     if(actualUrl.equalsIgnoreCase(expectedUrl)) { 
    	 System.out.println("Test passed"); 
    	 return;
    	 } 
  
     System.out.println("test_failed");
}
}
