package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Driver;

public class Test01 {

    @Test
    public void Test1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.quit();
    }


    @Test
    public void Test2(){

        WebDriver driver = Driver.getDriver();

        driver.get("http://google.com");

        WebDriver driver1 = Driver.getDriver();
        driver1.get("http://yahoo.com");

        Driver.quitDriver();

    }




}
