package TestNG_Projects_1;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class US_406  {
    WebDriver driver=new ChromeDriver();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    @Test
    public void Test406_1(){
        driver.get("https://openmrs.org/");
        Tools.Bekle(2);
        WebElement demo1= driver.findElement(By.xpath("//a[@class='zak-button']"));
        demo1.click();
        Tools.Bekle(2);

        WebElement demo2= driver.findElement(By.xpath("//SPAN[@class='elementor-button-text'][text()=\"Keşfet OpenMRS 2\"]"));
        demo2.click();



        WebElement demo3= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='elementor-button-text'])[4]")));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", demo3);

        WebElement email=driver.findElement(By.id("username"));
        email.sendKeys("admin");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement ward=driver.findElement(By.id("Inpatient Ward"));
        ward.click();

        WebElement login=driver.findElement(By.cssSelector("input[id=\"loginButton\"]"));
        login.click();}

    @Test (dependsOnMethods = {"Test406_1"})
    public void Test406_2(){

        WebElement recordButton=driver.findElement(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        recordButton.click();

        WebElement patientSearch=driver.findElement(By.xpath("//input[@id='patient-search']"));
        patientSearch.sendKeys("Rukiye AVAN");

        WebElement anasayfa=driver.findElement(By.xpath("//I[@class='icon-home small']"));
        anasayfa.click();

        WebElement recordButton2=driver.findElement(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        recordButton2.click();

        WebElement patientSearch2=driver.findElement(By.xpath("//input[@id='patient-search']"));
        patientSearch2.sendKeys("111");


        WebElement dogrulama=driver.findElement(By.xpath("//tbody[@aria-live='polite']/tr/td"));
        Assert.assertTrue(dogrulama.getText().contains("No matching"),"Hatalı Sonuç");






    }
}
