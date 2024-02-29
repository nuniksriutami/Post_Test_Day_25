package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RecruitmentTest {
    private static WebDriver driver;
    private static LoginPage loginPage = new LoginPage();
    private static RecruitmentPage recruitmentPage = new RecruitmentPage();

    public RecruitmentTest(){
        driver = Hooks.driver;
        // extent report
    }

    @Given("Admin telah login ke sistem")
    public void admin_telah_login_ke_sistem(){
        loginPage.login("Admin", "admin123");
    }

    @When("Admin masuk ke menu Recruitment")
    public void admin_masuk_ke_menu_Recruitment(){
        // code
    }

    @And("Admin memilih opsi Tambah Kandidat")
    public void admin_memilih_opsi_tambah_kandidat(){
        // code
    }

    @Then("Sistem menampilkan pesan sukses yang mengkonfirmasi penambahan data kandidat")
    public void sistem_menampilkan_pesan_sukses_yang_mengkonfirmasi_penambahan_data_kandidat(){
        // code
    }

    @And("Data kandidat ditambahkan ke sistem dengan informasi yang sesuai")
    public void data_kandidat_ditambahkan_ke_sistem_dengan_informasi_yang_sesuai(){
        // code
    }
}
