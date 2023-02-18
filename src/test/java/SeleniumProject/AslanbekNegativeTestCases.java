package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class AslanbekNegativeTestCases {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // TC1: 1) Go to Facebook Page, 2) Click to create new account
        driver.get("https://www.facebook.com/");

        //<a role="button" class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy" href="#"
        // ajaxify="/reg/spotlight/" id="u_0_0_vI" data-testid="open-registration-form-button"
        // rel="async">Create new account</a>

        WebElement createNewAccount = driver.findElement(By.cssSelector("a[class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));

        createNewAccount.click();
        String expectedTitle = "Sign Up";
        String actualTitle = driver.findElement(By.xpath("//div[text()='Sign Up']")).getText();
        /*"sign up" text should be present*/
        if (expectedTitle.equals(actualTitle)){
            System.out.println("precondition is reached successfully");
        }else {
            System.out.println("precondition is not reached");
        }
        System.out.println("-".repeat(50));
        System.out.println("TC 1 execution : Verify if blank field sign up gives popup error message");
        /*I click on "Sign Up" button with blank fields and should see popup error message "What's your name?"*/
        /*<div class="_5633 _5634 _53ij" id="js_c7" style="top: 0px;">What’s your name?</div>*/
        WebElement submitButton = driver.findElement(By.name("websubmit"));
        submitButton.click();
        String expectedPopupMessage = "What’s your name?";
        String actualPopupMessage = driver.findElement(By.xpath("//div[@class='_5633 _5634 _53ij'][text()='What’s your name?']")).getText();
        if (expectedPopupMessage.equals(actualPopupMessage)){
            System.out.println("Negative TC 1 Passed successfully");
        }else {
            System.out.println("TC 1 failed");
        }
        System.out.println("-".repeat(50));
        System.out.println("TC 2 execution : Verify that default date is equal to current date");
        /*facebook date*/
        String facebookDate = driver.findElement(By.cssSelector("#month>option[selected='1']")).getText()+" "+driver.findElement(By.cssSelector("#day>option[selected='1']")).getText()+" "+driver.findElement(By.cssSelector("#year>option[selected='1']")).getText();
        LocalDate today = LocalDate.now();
        DateTimeFormatter berkStyle = DateTimeFormatter.ofPattern("MMM d uuuu");
        /*current date*/
        String currentDate = today.format(berkStyle);
        if (currentDate.equals(facebookDate)){
            System.out.println("TC 2 Passed successfully");
        }else {
            System.out.println("TC 2 failed");
        }
        System.out.println("-".repeat(50));




        driver.quit();
    }
}
