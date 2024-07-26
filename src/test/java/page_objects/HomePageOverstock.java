package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities_qatek.ReadConfigFiles;

public class HomePageOverstock {
    private static final By OverstockLogo = By.xpath("//img[@alt='Overstock Logo']");
    private static final By PopUpCrossOut = By.cssSelector("svg[stroke='#2f3337']");

    private static final Logger LOGGER = LogManager.getLogger(HomePageOverstock.class);
    public WebDriver driver;
    public HomePageOverstock(WebDriver driver)
    {
        this.driver = driver;
    }
    public HomePageOverstock openTheWebsite()
    {
        LOGGER.debug("Opening the url");
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("OverstockUrl"));
        return this;
    }
    public HomePageOverstock clickOnOverstockLogo()
    {
        LOGGER.debug("Clicking on Overstock Logo");
        ActOn.element(driver, PopUpCrossOut).click();
        ActOn.element(driver, OverstockLogo).click();
       return this;
    }
    public HomePageOverstock navigatedToTheHomePage() throws Exception {
        LOGGER.debug("Overstock Logo Validation");
        AssertThat.elementAssertions(driver, OverstockLogo).elementIsDisplayed();
        return this;
    }
}
