package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
    WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String firstName, String lastName, String email, String mobile) throws InterruptedException {
        
    	Actions action = new Actions(driver);
        action.scrollToElement(driver.findElement(By.id("submit"))).perform();
        //1 first name
    	driver.findElement(By.id("firstName")).sendKeys(firstName);
        
    	//2 last name
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        
        //3 emailid
        driver.findElement(By.id("userEmail")).sendKeys(email);
        
        //4 gender
        WebElement genderInput = driver.findElement(By.id("gender-radio-2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderInput);

        
        // 5 mobile number
        driver.findElement(By.id("userNumber")).sendKeys(mobile);
        Thread.sleep(2000);
        
        //6 date of birth
        WebElement dop = driver.findElement(By.id("dateOfBirthInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dop);
        
        WebElement yr=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select s=new Select(yr);
        s.selectByValue("2003");
        WebElement month=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select s1=new Select(month);
        s1.selectByValue("3");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[1]")).click();//20
        
        //7 subject
        WebElement select=driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        select.sendKeys("Computer Science");
        select.sendKeys(Keys.ENTER);
        
        //8 hobies
        WebElement reading = driver.findElement(By.id("hobbies-checkbox-2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reading);
        
        WebElement music = driver.findElement(By.id("hobbies-checkbox-3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", music);
        
        //9 image
        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("C:\\Users\\priya\\OneDrive\\Desktop\\SIGN.jpg");
        
        //10  adress
        driver.findElement(By.id("currentAddress")).sendKeys("123 Main Street, Hyderabad");

        // 11. State (use JS to click from dropdown)
        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        // 12. City
        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));
        cityDropdown.sendKeys("Delhi");
        cityDropdown.sendKeys(Keys.ENTER);
    }

   public void submitForm() {
        WebElement submit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);

  }
}
