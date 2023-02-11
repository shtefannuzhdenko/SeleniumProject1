package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookSignUpPage {
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

        //TC2: 1) Locate the First name box, 2) Send keys, 3) Locate lastname box, 4)Send keys, 5) locate phone number
        // or email box, 6) send keys, 7) locate the password box, 8) send keys to password box

        //<input type="text" class="inputtext _58mg _5dba _2ph-" data-type="text"
        // name="firstname" value="" aria-required="true" placeholder="" aria-label="First name"
        // id="u_2_b_ta" tabindex="0" aria-describedby="js_6a">

        WebElement nameBox = driver.findElement(By.cssSelector("input[name='firstname']"));
        nameBox.sendKeys("Stefan");

        WebElement lastNameBox = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastNameBox.sendKeys("Nuzhdenko");

        WebElement phoneNumberBox = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        phoneNumberBox.sendKeys("12345678");

        WebElement passwordBox = driver.findElement(By.name("reg_passwd__"));
        passwordBox.sendKeys("12345678");

        //TC3: 1) Create the Select class for dropdown menu, 2) Locate month, day, year box, 3) Select values

        WebElement month = driver.findElement(By.name("birthday_month"));
        Select dropdown1 = new Select(month);
        dropdown1.selectByValue("3");

        WebElement day = driver.findElement(By.name("birthday_day"));
        Select dropdown2 = new Select(day);
        dropdown2.selectByValue("10");

        WebElement year = driver.findElement(By.name("birthday_year"));
        Select dropdown3 = new Select(year);
        dropdown3.selectByValue("2000");

        //TC4: 1) Locate the Custom radio button; 2) Click on Custom value and select option, 3) Click Sign Up

        //<input type="radio" class="_8esa" name="sex" value="-1" id="u_2_6_NG">

        WebElement gender = driver.findElement(By.xpath("//label[text()='Custom']"));
        gender.click();

        WebElement pronoun = driver.findElement(By.name("preferred_pronoun"));
        Select customGender = new Select(pronoun);
        customGender.selectByValue("6");

         WebElement submitButton = driver.findElement(By.name("websubmit"));
         submitButton.click();



    }
}
