package tests;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import Pages.FormPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormTests {
    WebDriver driver;
    FormPage form;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        form = new FormPage(driver);
    }

    @Test
    public void testValidFormSubmission() throws InterruptedException {
        form.fillForm("Priyanka", "N", "priya@gmail.com", "9876543210");
        form.submitForm();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        String actualText = modalTitle.getText();
        Assert.assertEquals(actualText, "Thanks for submitting the form");

        //WebElement successMsg = driver.findElement(By.id("example-modal-sizes-title-lg"));
        //Assert.assertEquals(successMsg.getText(), "Thanks for submitting the form");
    }

    @Test
    public void testInvalidEmail() throws InterruptedException {
        form.fillForm("Test", "User", "invalidemail", "9876543210");
        form.submitForm();

        // Since invalid email blocks submission, modal should not appear
        Assert.assertTrue(driver.findElements(By.id("example-modal-sizes-title-lg")).isEmpty());
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

