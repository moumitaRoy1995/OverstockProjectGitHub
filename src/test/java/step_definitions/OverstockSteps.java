package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.*;

public class OverstockSteps {
    private static final Logger LOGGER = LogManager.getLogger(OverstockSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^user is on the home page$")
    public void userIsOnTheHomePage() {
       new HomePageOverstock(driver)
               .openTheWebsite();
        LOGGER.info("User is on the Home Page");
    }
    @When("^user enters the login portal$")
    public void userEntersTheLoginPortal()
    {
        new LoginOverstock(driver)
                .enterLoginPortal();
        LOGGER.info("User is in the Login Portal");
    }
    @And("^user click on Continue as Guest button$")
    public void userClickOnContinueAsGuestButton()
    {
        new LoginOverstock(driver)
                .clickOnContinueAsGuest();
        LOGGER.info("Continue as Guest");
    }

    @When("^user enters Email \"(.+?)\" and password \"(.+?)\"$")
    public void userEntersEmailAndPassword(String email, String password) {
       new LoginOverstock(driver)
               .enterEmailAndPassword(email, password);
        LOGGER.info("User has entered Email: " + email + "entered Password: " + password);
    }

    @And("^click on Sign In button$")
    public void clickOnSignInButton() {
       new LoginOverstock(driver)
               .clickOnSignInButton();
        LOGGER.info("User has clicked on Sign In Button");
    }

    @Then("^user is navigated to the home page$")
    public void userIsNavigatedToTheHomePage() throws Exception {
        new HomePageOverstock(driver)
                .navigatedToTheHomePage();
        LOGGER.info("User Has navigated to the Home Page");
    }
    @When("^user click on the overstock Logo$")
    public void userClickOnTheOverstockLogo(){
       new HomePageOverstock(driver)
               .clickOnOverstockLogo();
        LOGGER.info("User Clicked on Overstock Logo");
    }
    @When("^user enters value \"(.+?)\" in the Search Bar$")
    public void userEntersValueInTheSearchBar(String value)
    {
        new SearchBar(driver)
                .enterValueInTheSearchBar(value);
        LOGGER.info("User enter value:" + value + "in the SearchBar");
    }
    @And("^click on the Search Button$")
    public void clickOnTheSearchButton()
    {
       new SearchBar(driver)
               .clickOnTheSearchBar();
        LOGGER.info("User Clicked on search Button");
    }
    @Then("^user is navigated to the Wedding Rings page$")
    public void userIsNavigatedToTheWeddingRingsPage() throws Exception {
       new NavigationBarOverstock(driver)
               .navigateToWeddingRingsPage();
        LOGGER.info("User Navigated to the Wedding Ring Page");
    }
    @Then("^user is failed to login$")
    public void userIsFailedToLogin() throws Exception {
       new LoginOverstock(driver)
               .failedToLogIn();
        LOGGER.info("User failed to login");
    }
    @When("^click on the More button$")
    public void clickOnTheMoreButton()
    {
        new NavigationBarOverstock(driver)
                .clickOnMoreButton();
        LOGGER.info("User clicked on More Button");
    }
    @And("^user is navigated to the More page$")
    public void userIsNavigatedToTheMorePage() throws Exception {
        new NavigationBarOverstock(driver)
                .navigateToMorePage();
        LOGGER.info("User navigated to More page");
    }
    @When("^click on the Top Deals button$")
    public void clickOnTheTopDealsButton()
    {
       new NavigationBarOverstock(driver)
               .clickOnTopDealsButton();
        LOGGER.info("User clicked on TopDeals Button");
    }
    @And("^user is navigated to the Top Deals page$")
    public void userIsNavigatedToTheTopDealsPage() throws Exception {
       new NavigationBarOverstock(driver)
               .navigateToTopDealsPage();
        LOGGER.info("User navigated to TopDeals Page");
    }
    @When("^user navigate to mattresses through Navigation Bar$")
    public void userNavigateToMattressesThroughNavigationBar()
    {
       new NavigationBarOverstock(driver)
               .mouseHoverToFurniture()
               .navigateToMattress();
        LOGGER.info("User navigated Mattress Through Navigation Bar");

    }
    @And("^user can select the item$")
    public void userCanSelectTheItem()
    {
        new NavigationBarOverstock(driver)
                .waitForPageToLoad()
                .mouseHoverToFurnitureLink();
        LOGGER.info("Mouse Hover to Furniture Link");
    }
    @When("^user is Logged In to their account entering Email \"(.+?)\" and password \"(.+?)\"$")
    public void userIsLoggedInToTheirAccountEnteringEmailAndPassword(String email, String password) throws Exception {
        new LoginOverstock(driver)
                .enterLoginPortal();
        new LoginOverstock(driver)
                .loginForLogout(email,password);
        LOGGER.info("User Login With email and password to Logout");
    }
    @Then("^user Logout from their account$")
    public void userLogoutFromTheirAccount()
    {
        new LoginOverstock(driver)
         .logOut();
        LOGGER.info("User Logout from their Account");
    }
    @Then("^user is on the item page$")
    public void userIsOnTheItemPage()
    {
        new NavigationBarOverstock(driver)
                .itemPageValidation();
        LOGGER.info("User navigated to Item Page");
    }
}