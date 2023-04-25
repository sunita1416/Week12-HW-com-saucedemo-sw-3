package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }
    public void clickOnElement(By by){
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Navigate to the website
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']"));
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Navigate to the website
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']"));

        // Verify that six products are displayed on the page
        int expectedNumberOfProducts = 6;
        int actualNumberOfProducts = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals("Products not displayed",actualNumberOfProducts, expectedNumberOfProducts);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }



}
