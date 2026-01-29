package com.mule.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class SeleniumService {

   
    public static String openAndVerify() {
        ChromeOptions options = new ChromeOptions();
   
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        
        try {
            driver.get("https://playground.mailslurp.com");
            
            
            
            boolean isTextPresent = driver.findElement(By.tagName("body"))
                                          .getText()
                                          .contains("Sign in to your account");
            if (isTextPresent) {
            	
            	System.out.println("SUCCESS - Pausing for 3 seconds...");
                
                // --- ADDED WAIT HERE ---
                Thread.sleep(3000);
               return "SUCCESS";
            } else {
                System.out.println("ASSERTION FAILED");
                return "FAILURE";
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return "ERROR";
        } finally {
           
            if (driver != null) {
                driver.quit();
            }
        }
    }
}