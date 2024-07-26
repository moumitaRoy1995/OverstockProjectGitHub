package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBar {
    private static final By PopUpCrossOut = By.cssSelector("svg[stroke='#2f3337']");
    private static final By SearchBar = By.xpath("//input[@placeholder='Search Crazy-Good Deals']");
    private static final By ClickOnSearchButton = By.xpath("//img[@alt='Search']");

    private static final Logger LOGGER = LogManager.getLogger(SearchBar.class);
    public WebDriver driver;
    public SearchBar(WebDriver driver)
    {
        this.driver = driver;
    }
    public SearchBar enterValueInTheSearchBar(String value)
    {
        LOGGER.debug("Entering values in the search bar");
        ActOn.element(driver, PopUpCrossOut).click();
        ActOn.element(driver, SearchBar).setValue(value);
        return this;
    }
    public SearchBar clickOnTheSearchBar()
    {
        LOGGER.debug("Clicking on search Button");
        ActOn.element(driver, ClickOnSearchButton).click();
        return this;
    }
}
