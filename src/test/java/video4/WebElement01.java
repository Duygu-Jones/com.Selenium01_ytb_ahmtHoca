package video4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElement01 {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup; //Selenium 4.10 surumunden sonra
        // bonigarcia webdrivermanager uzantisina artik ihtiyac duymamaktadir kendi icinfe bulundurmaktadir

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https:www.amazon.com");
        //2- arama cubuguna “Nutella” yazdirin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");
        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin //burada submit()=Enter demek
        aramaKutusu.submit();
        //4- Bulunan sonuc sayisini yazdirin. //kac tane Nutella sonucu ciktigini gosterir
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYaziElementi.getText());

        driver.close();
    }



}
