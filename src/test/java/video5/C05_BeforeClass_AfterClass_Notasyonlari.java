package video5;


import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeClass_AfterClass_Notasyonlari {
    // Olusturdugumuz test class'inin icindeki test method'lari
    // hep ayni web sitesi ile ilgili ise her seferinde yeniden driver olusturmaya
    // ve her method icin bu driver'i kapatmaya gerek yoktur
    // Class'in basinda bir kere setup calisip, en sonda kapansa olur
    // dersek BeforeClass ve AfterClass kullaniriz
    //NOTE: @BeforeClass ve @AfterClass methodlari ile calisiliyor ise MUTLAKA METHODLAR STATIC olmalidir.
    //Dolayisiyla static methodlarda kullanilacak varable lar da static olmalidir
    static WebDriver driver; //class seviyesinde variable, tm methodlarda kullanabilmek icindir.

    @BeforeClass //Class in basinca calisir
    public  static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass //Class sonunda calisir
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // amazon ana sayfaya gidelim
        driver.get("https:www.amazon.com");
    }
    @Test @Ignore       //methodda bir aksilik oldugu saptanir, degisiklik calismalari yapilirken
                        // veya kullanilmasini istemiyorak ignore ederiz
    public void test02() {
        // title yazdiralim
        System.out.println(driver.getTitle());
    }
    @Test
    public void test03() {
        // url yazdiralim
        System.out.println(driver.getCurrentUrl());
    }
}