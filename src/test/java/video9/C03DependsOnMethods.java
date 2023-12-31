package video9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

//@Test(dependsOnMethods ="test01")
//bir methodu digerine baglama, calsima sarti olarak bagli oldugu methodun calismasina baglidir kendisinin calismasi)



public class C03DependsOnMethods {
    WebDriver driver;

    @Test
    public void test01(){

        // amazon anasayfaya gidelim
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @Test(dependsOnMethods ="test01" )
    public void test02(){
        // Nutella aratalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }
    @Test(dependsOnMethods ="test02" )
    public void test03(){
        // Sonuc yazisinin Nutella icerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
    }


}
