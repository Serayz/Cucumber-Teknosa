package Pages;
import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Action;
import utilities.Driver;

import java.io.IOException;

import static utilities.Driver.driver;

public class page {
    public page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public final By kampanyabutonu = By.xpath("//*[@id='ins-editable-button-1580496494']");
    public final By magazabutonu = By.xpath("//div/ul/li/a[contains(@title, 'Mağazalarımız') and contains(@class, 'fmi-menu-link')]");
    public final By scrollbutonu = By.xpath("//div/ul/li/a[contains(@title, 'Pazaryeri Satıcısı Olun') and contains(@class, 'fmi-menu-link')]");
    public final By ilSecmeButonu = By.xpath("//*[@id='cities1']/option[06]");
    public final By ilceSecmeButonu = By.xpath("//*[@id='towns']/option[2]");
    public final By Text = By.xpath("//*[@id='stp-tab-list']/div/div[3]/div");
    public final By il = By.xpath("//*[@id='cities1']");
    public final By AramaSpace = By.xpath("//*[@id='site-header']/div/div[3]/div[2]/div/form/div[1]/div[1]/button");

    public final By searchHeading = By.xpath("//*[@id='search-input']");

    public final By blueet = By.xpath("//*[@id='matching-product']//a[@title='Bluetooth Kulaklık']");
    String key = "Kulaklık";

    String eposta = "ezgiserayb@gmail.com";

    public final By encokSatan = By.xpath("//div[@class='input radio']/label[@for='bestSellerPoint-desc']");

    public final By IlkUrun = By.xpath("//div[@class='products']/div[1]/a");

    public final By SepeteEkle = By.xpath("//button[@id='addToCartButton' and @type='submit']");

    public final By AlisveriseDevamEtButonu = By.xpath("//*[@id=\"mnp-added-to-cart\"]/div[4]/div/a[1]");
    public final By SepeteGit = By.xpath("//*[@id=\"mnp-added-to-cart\"]/div[4]/div/a[2]");

    public final By SonUrun = By.xpath("//div[@class='products']/div[last()]/a");

    public final By Ilkfiyat = By.xpath("//div[@class='cart-row'][1]//span[@class='prc prc-last']//b");
    public final By Sonfiyat = By.xpath("//div[@class='cart-row'][2]//span[@class='prc prc-last']//b");
    public final By Ilkplusbutton = By.xpath("//div[@class='cart-row'][1]//button[@class='plus  quantity-right-plus']");
    public final By Sonplusbutton = By.xpath("//div[@class='cart-row'][2]//button[@class='plus  quantity-right-plus']");
    public final By AlisverisTamamla = By.xpath("//div[@class='cart-sum-cta']/a");
    public final By UyeOlmadanDevamButonu = By.xpath("//*[@id='newLoginStepSecond']");
    public final By EpostaAlanı = By.xpath("//*[@id='j_username1']");
    public void kampanyakabulu(){
        Action.clickElement(kampanyabutonu);
        Shadow shadow = new Shadow(driver);
        shadow.findElementByXPath(("//*[.='Kabul Et']")).click();
    }
    public void magazaAcilir(){
        Action.clickElement(magazabutonu);
    }
    public void ilSecme(){
        Action.clickElement(ilSecmeButonu );
    }
    public void ilceSecme(){
        Action.clickElement(ilceSecmeButonu);
    }
    public void txtyazdırma() throws IOException {
        Action.writetxt(Text);

    }
    public void scroll() throws InterruptedException {
        Action.focusElement(scrollbutonu);
        Thread.sleep(500);
        Action.scrollUntilVisible(scrollbutonu);
        Thread.sleep(1000);
    }

    public void AramaAlani(){
        Action.clickElement(AramaSpace);
    }

       public void KulaklikYazma() throws InterruptedException {
        Thread.sleep(500);
        Action.sendKeysElement(searchHeading,key);
        Thread.sleep(500);
        Action.clickElement(blueet);

    }
    public void EnCokSatanFiltre() throws InterruptedException {
        Thread.sleep(500);
        Action.clickElement(encokSatan);
    }

      public void IlkUrun() throws InterruptedException {
        Action.clickElement(IlkUrun);
        Thread.sleep(200);
        Action.focusElement(SepeteEkle);
        Thread.sleep(500);
        Action.scrollUntilVisible(SepeteEkle);
        Thread.sleep(1000);
        Action.clickElement(SepeteEkle);
        Thread.sleep(1000);
        Action.clickElement(AlisveriseDevamEtButonu);
        driver.navigate().back();

    }
    public void SonUrun() throws InterruptedException {
        Action.focusElement(SonUrun);
        Thread.sleep(500);
        Action.scrollUntilVisible(SonUrun);
        Thread.sleep(500);
        Action.clickElement(SonUrun);
        Thread.sleep(200);
        Action.focusElement(SepeteEkle);
        Thread.sleep(500);
        Action.scrollUntilVisible(SepeteEkle);
        Thread.sleep(1000);
        Action.clickElement(SepeteEkle);
        Thread.sleep(1000);
        Action.clickElement(SepeteGit);

    }
       public void  UrunArttırma() throws InterruptedException {
           String ilkfiyatım = Action.getTextElement(Ilkfiyat).replace(" TL","");
           ilkfiyatım = ilkfiyatım.replace(".","");
           String sonfiyatım = Action.getTextElement(Sonfiyat).replace(" TL","");
           sonfiyatım = sonfiyatım.replace(".","");
           int intilk = Integer.parseInt(ilkfiyatım);
           int intson = Integer.parseInt(sonfiyatım);

           if (intilk<intson){
               Action.clickElement(Ilkplusbutton);
           }
           else{
               Action.clickElement(Sonplusbutton);
           }
           Action.clickElement(AlisverisTamamla);
       }
    public void  UyeOlmadanDevam() throws InterruptedException {
        Action.clickElement(UyeOlmadanDevamButonu);
        Thread.sleep(500);
        Action.clickElement(EpostaAlanı);
        Action.sendKeysElement(EpostaAlanı,eposta);
    }



}
