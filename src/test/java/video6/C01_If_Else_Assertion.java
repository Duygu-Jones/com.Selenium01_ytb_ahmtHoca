package video6;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class C01_If_Else_Assertion {

    WebDriver driver; //WebDriver parent Driver class-Data type'inda driver variable'i; class seviyesinde ortak kullanilir


    @Before
    public void setUp() {  //Her methoddan once setup/ayar yapar

        driver = new ChromeDriver(); //ChromeDriver objesi
        driver.manage().window().maximize(); //obje ile methodlar cagrilir
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() { //Her method dan sonra driver i kapat; tearDown=kapat, ortadan kaldir gibi anlamlari var
        driver.close();
    }

    @Test
    public void test01() {
        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https:www.amazon.com");

        //2- arama cubuguna “Nutella” yazdirin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");

        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin
        aramaKutusu.submit();

        //4- Bulunan sonuc yazisinin "Nutella" icerdigini test edelim
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualYaziStr= sonucYaziElementi.getText();

        // 1-48 of 105 results for "Nutella"
        String expectedBulunacakKelime="Kutella"; //yanlis deger girilir test icin

        if (actualYaziStr.contains(expectedBulunacakKelime)){
            System.out.println("Nutella testi PASSED");
        } else {
            System.out.println("Sonuc yazisi Nutella icermiyor; " +
                    "\nNutella testi FAILED");
        }

    }

}
