package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
    public static ExtentTest extentTest;
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
    public void admin_mengakses_halaman_recruitment(){
        recruitmentPage.clickBtnMenu();
        extentTest.log(LogStatus.PASS, "Admin masuk ke menu Recruitment");
    }

    @And("Admin memilih opsi Tambah Kandidat")
    public void admin_tambah_kandidat(){
        recruitmentPage.clickAdd();
        extentTest.log(LogStatus.PASS, "Admin memilih opsi Tambah Kandidat");
    }

    @Then("Sistem menampilkan pesan sukses yang mengkonfirmasi penambahan data kandidat")
    public void admin_sukses_menambah_kandidat(){
        recruitmentPage.inputFirstName("Nunik");
        recruitmentPage.inputMiddleName("Sri");
        recruitmentPage.inputLastName("Utami");
        recruitmentPage.inputEmail("nunik.utami12@gmail.com");
        recruitmentPage.inputContact("085888174889");
        recruitmentPage.inputNotes("test");
        recruitmentPage.clickselectVacancy("4");
        recruitmentPage.clickkeepData();
        recruitmentPage.clickbtnSave();
        Assert.assertEquals(recruitmentPage.getTxtStatus(), "Status: Application Initiated");
        extentTest.log(LogStatus.PASS, "Sistem menampilkan pesan sukses yang mengkonfirmasi penambahan data kandidat");
    }

    @And("Data kandidat ditambahkan ke sistem dengan informasi yang sesuai")
    public void admin_memastikan_data_kandidat_sesuai(){
        Assert.assertEquals(recruitmentPage.getTxtCandidateName(), "kiki bayu destara");
        extentTest.log(LogStatus.PASS, "Data kandidat ditambahkan ke sistem dengan informasi yang sesuai");
    }
}
