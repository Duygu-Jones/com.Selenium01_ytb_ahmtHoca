package video1;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IlkClass {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.facebook.com");
        System.out.println(driver.getTitle());



    }

}
