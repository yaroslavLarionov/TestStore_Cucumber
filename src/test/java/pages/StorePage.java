package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumUtils;
import utils.WebDriverFactory;

public class StorePage {


    public StorePage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchbar;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(id = "group_1")
    private WebElement sizePickerDropdown;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='modal-body']//p[@class='cart-products-count']")
    private WebElement itemsNumInTheCart;

    public void searchProduct(String product) {
        SeleniumUtils.sendKeys(searchbar, product);
        SeleniumUtils.click(submitBtn);
    }

    public boolean itemResultDisplay(String item) {
        WebElement targetElement = WebDriverFactory.getDriver().findElement(By.xpath("//*[contains(text(),'" + item.toLowerCase() + "')]"));
        return SeleniumUtils.isDisplayed(targetElement);
    }

    public void clickOnResultItem(String item) {
        WebElement targetElement = WebDriverFactory.getDriver().findElement(By.xpath("//a[contains(text(),'" + item.toLowerCase() + "')]"));
        SeleniumUtils.click(targetElement);
    }

    public void addingItemToCart(String size) {
        Select select = new Select(sizePickerDropdown);
        select.selectByVisibleText(size);
        SeleniumUtils.click(addToCartBtn);
    }

    public boolean checkCartItem() {
        SeleniumUtils.waitForElementVisibility(itemsNumInTheCart);
        return itemsNumInTheCart.getText().equals("There is 1 item in your cart.");
    }
}
