package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.StorePage;
import utils.ConfigReader;
import utils.WebDriverFactory;

public class StoreSteps {

    StorePage storePage;

    public StoreSteps() {
        this.storePage = new StorePage();
    }

    @Given("I am on the store page")
    public void i_am_on_the_store_page() {
        WebDriverFactory.getDriver().get(ConfigReader.getProperty("storeUrl"));
    }

    @When("I search for {string} in the searchbar")
    public void iSearchForInTheSearchbar(String product) {
        storePage.searchProduct(product);
    }

    @Then("I should see {string} displayed in the results")
    public void iShouldSeeDisplayedInTheResults(String searchItem) {
        Assert.assertTrue(storePage.itemResultDisplay(searchItem));
    }

    @And("I click on the {string} item result")
    public void iClickOnTheItemResult(String item) {
        storePage.clickOnResultItem(item);
    }

    @Then("I should be able to select {string} size and add item to the cart")
    public void iShouldBeAbleToSelectSizeAndAddItemToTheCart(String itemSize) {
        storePage.addingItemToCart(itemSize);
        Assert.assertTrue(storePage.checkCartItem());
    }
}
