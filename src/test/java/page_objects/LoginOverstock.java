package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginOverstock {
    private static final By LoginPortal = By.linkText("Log in");
    private static final By Email = By.id("email");
    private static final By ContinueButton = By.xpath("//button[normalize-space()='Continue']");
    private static final By Password = By.id("password");
    private static final By SignIn = By.xpath("//button[normalize-space()='Sign In']");
    private static final By ErrorMessageOnLogin = By.xpath("//p[@class='cl-form-message cl-form-message-error passwordForm_ostkError__Ven30']");
    private static final By ContinueAsGuestButton = By.xpath("//a[normalize-space()='Continue as Guest']");
    private static final By PopUpCrossOut = By.cssSelector("svg[stroke='#2f3337']");
    private static final By OverstockLogo = By.xpath("//img[@alt='Overstock Logo']");
    private static final By LoginPortalForLogout = By.xpath("//a[@class='header__icon text-current']");
    private static final By LogOutButton = By.xpath("//a[normalize-space()='Log out']");

    private static final Logger LOGGER = LogManager.getLogger(LoginOverstock.class);
    public WebDriver driver;
    public LoginOverstock(WebDriver driver)
    {
        this.driver = driver;
    }
    public LoginOverstock enterLoginPortal()
    {
        LOGGER.debug("Clicking on Login Portal");
        ActOn.element(driver,PopUpCrossOut).click();
        ActOn.element(driver,LoginPortal).click();
        return this;
    }
    public LoginOverstock clickOnContinueAsGuest()
    {
        LOGGER.debug("Clicking on Continue as Guest");
        ActOn.element(driver,ContinueAsGuestButton).click();
        return this;
    }
    public LoginOverstock enterEmailAndPassword(String email, String password)
    {
        LOGGER.debug("Entering credentials");
        ActOn.element(driver,PopUpCrossOut).click();
        ActOn.element(driver,LoginPortal).click();
        ActOn.element(driver,Email).setValue(email);
        ActOn.element(driver,ContinueButton).click();
        ActOn.element(driver, Password).setValue(password);
        return this;
    }
    public LoginOverstock clickOnSignInButton()
    {
        LOGGER.debug("Clicking on Sign in Button");
        ActOn.element(driver,SignIn).click();
        return this;
    }
    public LoginOverstock failedToLogIn() throws Exception {
        LOGGER.debug("Error Message Validation");
        AssertThat.elementAssertions(driver, ErrorMessageOnLogin).elementIsDisplayed();
        return this;
    }
    public LoginOverstock logOut()
    {
        LOGGER.debug("Clicking on Logout Button");
        ActOn.wait(driver, OverstockLogo).waitForElementToBeVisible();
        ActOn.element(driver, LoginPortalForLogout).click();
        ActOn.element(driver, LogOutButton).click();
        return this;
    }
    public LoginOverstock loginForLogout(String email, String password)
    {
        LOGGER.debug(" Entering Login Credentials for logout");
        ActOn.element(driver,Email).setValue(email);
        ActOn.element(driver, ContinueButton).click();
        ActOn.element(driver, Password).setValue(password);
        ActOn.element(driver,SignIn).click();
        return this;
    }
}
