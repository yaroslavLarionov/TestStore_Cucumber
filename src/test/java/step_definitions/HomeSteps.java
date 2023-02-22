package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HomePage;
import utils.SeleniumUtils;
import utils.WebDriverFactory;
import utils.WebElementsTemplates;

public class HomeSteps {

    HomePage homePage;

    public HomeSteps() {
        homePage = new HomePage();
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        Assert.assertEquals("Homepage", WebDriverFactory.getDriver().getTitle());
    }
    @When("I click on store link")
    public void i_click_on_store_link() {
        SeleniumUtils.click(homePage.storePageLink);
    }
    @Then("I should see the store page")
    public void i_should_see_the_store_page() {
        Assert.assertEquals("teststore", WebDriverFactory.getDriver().getTitle());
    }

    @Then("I should see {string} displayed")
    public void iShouldSeeDisplayed(String text) {
        Assert.assertTrue(SeleniumUtils.isDisplayed(WebElementsTemplates.linkTextTemplate(text)));
    }

    @And("Store image logo should be loaded")
    public void storeImageLogoShouldBeLoaded() {
        Assert.assertTrue(homePage.verifyImageIsDisplayed(homePage.storeLogoImage));
    }
}
