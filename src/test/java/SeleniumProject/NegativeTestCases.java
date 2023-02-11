package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NegativeTestCases {
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

        WebElement signUpButton = driver.findElement(By.cssSelector("button[name='websubmit']"));
        signUpButton.click();
        //
    }
}