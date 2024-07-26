package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationBarOverstock {
    private static final By PopUpCrossOut = By.cssSelector("svg[stroke='#2f3337']");
    private static final By FurnitureButton = By.linkText("Furniture");
    private static final By MattressButton = By.linkText("Mattresses");
    private static final By MoreButton = By.xpath("//a[@class='main-nav__item main-nav__item--primary main-nav__item-content'][normalize-space()='More']");
    private static final By MoreText = By.xpath("//h1[normalize-space()='More']");
    private static final By TopDealsButton = By.xpath("//a[normalize-space()='Top Deals']");
    private static final By TopDealsText = By.xpath("//h1[normalize-space()='Top Deals']");
    private static final By WeddingRingText = By.cssSelector("._title_8hidq_1");
    private static final By FurnitureLink = By.xpath("//span[contains(text(),'Slumber Solutions 14-inch Gel Memory Foam Choose Y')]");
    private static final By MattressPage = By.xpath("//h1[normalize-space()='Mattresses']");
    private static final By ItemPage = By.xpath("//div[@class='_title_8hidq_1']");

    private static final Logger LOGGER = LogManager.getLogger(NavigationBarOverstock.class);
    public WebDriver driver;

    public NavigationBarOverstock(WebDriver driver)
    {
        this.driver = driver;
    }
    public NavigationBarOverstock mouseHoverToFurniture()
    {
        LOGGER.debug("Mouse Hover to Furniture Link");
        ActOn.element(driver,PopUpCrossOut).click();
        ActOn.element(driver, FurnitureButton).mouseHover();
        return this;
    }
    public NavigationBarOverstock navigateToMattress()
    {
        LOGGER.debug("Clicking on the Mattress link from the navigation Bar:");
        ActOn.element(driver,MattressButton).click();
        return this;
    }
    public NavigationBarOverstock clickOnMoreButton()
    {
        LOGGER.debug("Clicking on More Button");
        ActOn.element(driver, PopUpCrossOut).click();
        ActOn.element(driver, MoreButton).click();
        return this;
    }
    public NavigationBarOverstock navigateToMorePage() throws Exception {

        LOGGER.debug("More page validation");
        AssertThat.elementAssertions(driver,MoreText).elementIsDisplayed();
        return this;
    }
    public NavigationBarOverstock clickOnTopDealsButton()
    {
        LOGGER.debug("Clicking on TopDeal Button");
        ActOn.element(driver, PopUpCrossOut).click();
        ActOn.element(driver, TopDealsButton).click();
        return this;
    }
    public NavigationBarOverstock navigateToTopDealsPage() throws Exception {
        LOGGER.debug("TopDeal page validation");
        AssertThat.elementAssertions(driver, TopDealsText).elementIsDisplayed();
        return this;
    }
    public NavigationBarOverstock navigateToWeddingRingsPage() throws Exception {
        LOGGER.debug("Wedding ring page validation");
        AssertThat.elementAssertions(driver, WeddingRingText).elementIsDisplayed();
        return this;
    }
    public NavigationBarOverstock waitForPageToLoad()
    {
        LOGGER.debug("Waiting for Mattress page to load");
        ActOn.wait(driver, MattressPage).waitForElementToBeVisible();
        return this;
    }
    public NavigationBarOverstock mouseHoverToFurnitureLink()
    {
        LOGGER.debug("Mouse Hovering to Furniture Link");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        ActOn.element(driver, FurnitureLink).mouseHover();
        ActOn.element(driver, FurnitureLink).click();
        return this;
    }
    public NavigationBarOverstock itemPageValidation()
    {
        LOGGER.debug("Item page validation");
        ActOn.wait(driver, ItemPage).waitForElementToBeVisible();
        return this;
    }
}
