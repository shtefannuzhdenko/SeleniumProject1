package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FacebookSignUpPage {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // TC1: 1) Go to Facebook Page, 2) Click to create new account
        driver.get("https://www.facebook.com/");

        //<a role="button" class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy" href="#"
        // ajaxify="/reg/spotlight/" id="u_0_0_vI" data-testid="open-registration-form-button"
        // rel="async">Create new account</a>
        Thread.sleep(3000);
        WebElement createNewAccount = driver.findElement(By.className("_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy"));
        createNewAccount.click();


    }
}
