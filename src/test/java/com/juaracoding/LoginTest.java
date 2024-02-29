package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class LoginTest {
    private static WebDriver driver;
    private static LoginPage loginPage;
    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
    }
    @AfterAll
    private static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
    @Given("User mengakses halaman login")
    public void user_mengakses_halaman_login(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @When("User memasukkan username yang valid")
    public void user_memasukkan_username_yang_valid(){
        loginPage.inputUsername("Admin");
    }
    @And("User memasukkan password yang valid")
    public void user_memasukkan_password_yang_valid(){
        loginPage.inputPassword("admin123");
    }
    @And("User klik tombol login")
    public void user_klik_tombol_login(){
        loginPage.clickBtnLogin();
    }

    @Then("User berhasil login dan diarahkan ke halaman utama atau dashboard setelah login")
    public void user_berhasil_login_dan_diarahkan_ke_halaman_utama(){
        Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
    }
    @Given("User berada di halaman login")
    public void user_di_halaman_login(){ loginPage.clickBtnLogout(); }

    @When("User memasukan username yang salah")
    public void user_memasukan_username_yang_salah() { loginPage.inputUsername("adminn"); }

    @And("User memasukan password yang salah")
    public void user_memasukan_passwrod_yang_invalid(){
        loginPage.inputPassword("admin123");
    }

    @Then("Sistem menampilkan pesan kesalahan Invalid credentials")
    public void sistem_menampilkan_invalid_kredensial(){ loginPage.getInvalidCredentials(); }



}
