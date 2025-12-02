package Tests;

import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Utilities.DataUtilities;
import Utilities.LogUtilities;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtilities.getPropertyValue;

public class TC11_ProblemLandingPage {


    @BeforeMethod
    public void setup() throws IOException {
        setDriver(getPropertyValue("environment", "browser"));
        LogUtilities.info("chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "Base_Url"));
        LogUtilities.info("page is redirected to url");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    public void verifyErrorUserCartButtonBug() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(DataUtilities.getJsonData("validLogin", "problem_username"))
                .enterPassword(DataUtilities.getJsonData("validLogin", "password"))
                .clickOnLoginButton()
                .addAllProductsToCart();


        Assert.assertTrue(new P02_LandingPage(getDriver()).checkingIfCartHasSixItems());
    }



    @AfterMethod
    public void quit() {
        LogUtilities.info("Bug found!");
        quitDriver();

    }
}
