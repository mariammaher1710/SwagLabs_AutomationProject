package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_completePage {

    public final By ThanksMessage = By.tagName("h2");
    private final By backHomeButton = By.id("back-to-products");
    private final WebDriver driver;

    public P06_completePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkThanksMessage() {
        return driver.findElement(ThanksMessage).getText().equals("THANK YOU FOR YOUR ORDER");
    }

    public P02_LandingPage clickOnBackHomeButton() {
        Utility.clickOnElement(driver, backHomeButton);
        return new P02_LandingPage(driver);
    }
}
