package stepsDefinition;
import Pages.page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class Steps {

    page page = new page();

    @Given("Kampanya ve Cerezler  Kabul Edilir")
    public void KampanyaveCerezKabul(){

        page.kampanyakabulu();
    }

    @When("Scroll")
    public void scroll() throws InterruptedException {
        page.scroll();
    }

    @And("Kurumsal Mağazalar acılır")
    public void magazaAc()  {
        page.magazaAcilir();
    }

    @And("Il secimi")
    public void IlSec()  {
        page.ilSecme();
    }

    @And("İlce secimi")
    public void IlceSec()  {
        page.ilceSecme();
    }

    @And("Txt yazdırma")
    public void TxtYazdırma() throws IOException {
        page.txtyazdırma();

    }
    @When("Search")
    public void AramaTıkla() {
        page.AramaAlani();
    }
    @When("Kulaklık yazılır")
    public void KulaklıkYazma() throws InterruptedException {
        page.KulaklikYazma();
    }

    @And("En Çok Satanlar Seçilir")
    public void EnCokSatanFiltre() throws InterruptedException {
        page.EnCokSatanFiltre();
    }

    @And("Ilk urun eklenir")
    public void IlkUrun() throws InterruptedException {
        page.IlkUrun();
    }

    @And("Son urun eklenir")
    public void SonUrun() throws InterruptedException {
        page.SonUrun();
    }

    @And("Urun arttırma")
    public void UrunArttırma() throws InterruptedException {
        page.UrunArttırma();
    }

    @And ("Uye olmadan devam")
    public void UyeOlmadanDevam() throws InterruptedException {
        page.UyeOlmadanDevam();
    }
}
