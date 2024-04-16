package Test_Cases;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.ArrayList;

public class AddToCartFlowTest {
    WebDriver driver;
    ChromeOptions options;
    HomePage objectHomePage;
    ProductListPage objectProductListPage;
    ProductPage objectProductPage;
    SignUpPage objectSignupPage;
    @BeforeTest
    public void beforeTest(){
        options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }
    @Test(priority = 1)
    public void checkSiteLaunched(){
        objectHomePage = new HomePage(driver);
        String actualTitle = objectHomePage.getTitle();
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test(priority = 2)
    public void checkPageOnSearch() {
        objectHomePage = new HomePage(driver);
        objectHomePage.clickOnSearchBar();
        objectHomePage.enterSearchItem("boat headphone");
        objectHomePage.clickOnSearchButton();
        objectProductListPage = new ProductListPage(driver);
        String actualTitle = objectProductListPage.getTitle();
        String expectedTitle = "Amazon.in : boat headphone";

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        System.out.println("Test TearDown Succesfully");
    }

}
