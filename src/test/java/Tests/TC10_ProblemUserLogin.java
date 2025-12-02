package Tests;

import Listeners.CustomITestResult;
import Listeners.IInvokedMethod;
import Pages.P01_LoginPage;
import Utilities.DataUtilities;
import Utilities.LogUtilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtilities.getPropertyValue;

@Listeners({IInvokedMethod.class, CustomITestResult.class})
public class TC10_ProblemUserLogin {

    @BeforeMethod
    public void setup() throws IOException {
        setDriver(getPropertyValue("environment", "browser"));
        LogUtilities.info("chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "Base_Url"));
        LogUtilities.info("page is redirected to url");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Reporter.getCurrentTestResult().getTestContext().setAttribute("driver", getDriver());
    }

    @Test
    public void ProblemLoginPageTC() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUsername(DataUtilities.getJsonData("validLogin", "problem_username"))
                .enterPassword(DataUtilities.getJsonData("validLogin", "password"))
                .clickOnLoginButton();
        Assert.assertTrue(new P01_LoginPage(getDriver()).assertLoginTc(getPropertyValue("environment", "Home_Url")));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }

}
