package video5;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Before_After_Notasyonlari {
    WebDriver driver;// class seviyesinde variable olarak olusturuldu ki her method icin calissin tekrar yazmadan

    //Test methodlari calitirilirken ilk olark test i calistirmadan once before ve after methodlarfi var mi diye bakinir varsa bu siraya gore methodlari calistirir

    @Before     //her methoddan once calisir
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After //her methoddan sonra calisir
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https:www.amazon.com");
    }
    @Test
    public void test02() {

        driver.get("https:www.bestbuy.com");
    }
    @Test
    public void test03() {

        driver.get("https:www.facebook.com");
    }

}