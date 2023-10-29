package video7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JunitAssertion {

    @Test
            public void test01() {
        //1. Launch browser
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        WebElement webLogosu=driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(webLogosu.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement signUpLink= driver.findElement(By.xpath("//a[text()=' Signup / Login'] "));
        signUpLink.click();

        //5. Verify 'Login to your account' is visible
        WebElement logInConfirm=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(logInConfirm.isDisplayed());

        //6. Enter correct email address and password
        WebElement emailBox= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailBox.sendKeys("triton.zarek@free2ducks.com");
        WebElement pwdBox= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        pwdBox.sendKeys("123456lennon.");

        //7. Click 'login' button
        WebElement loginButton=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInText= driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        System.out.println(loggedInText.isDisplayed());

        //9. Click 'Logout' button
        WebElement logOutButton= driver.findElement(By.xpath(" //a[text()=' Logout']"));
        logOutButton.click();

        //10. Verify that user is navigated to login page
        String expectedUlr= "https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUlr,actualUrl);

        //11. Close driver
        driver.close();




    }






}
