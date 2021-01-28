package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBox {
    public static void main(String[] args) {
        String[] userNames = {"helpdesk1@cybertekschool.com", "helpdesk2@cybertekschool.com", "marketing1@cybertekschool.com",
       "marketing2@cybertekschool.com","hr1@cybertekschool.com","hr2@cybertekschool.com"};
    String password = "UserUser";
     WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://login2.nextbasecrm.com");
      for (int i = 0; i < userNames.length; i++) {


          driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[1]/input")).sendKeys(userNames[i]);
           driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[2]/input")).sendKeys(password);
           driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]/input")).click();
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-name\"]")));

         driver.findElement(By.xpath("//*[@id=\"user-name\"]")).click();

          wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));

           String actual =driver.findElement(By.xpath("//*[@id=\"user-name\"]")).getText();
           if (userNames[i].equals(actual)) {
              System.out.println("Test case for user " + userNames[i] + " has passed.");
           } else {
               System.out.println("Test case failed");
               System.out.println("Expected username: " + userNames[i]  +
                       "\nActual username: " + actual);
          }

          driver.findElement(By.linkText("Log out")).click();
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[1]/input")));
         driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[1]/input")).clear();
       }

      //inspecting search box
      driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div[2]/div/div[3]/div/div/form/input")).sendKeys("Asya");
      if(driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div[2]/div/div[3]/div/div/form/input")).isDisplayed()){
          System.out.println("Pass");
      }else{
          System.out.println("Fail");
      }

        }
}
