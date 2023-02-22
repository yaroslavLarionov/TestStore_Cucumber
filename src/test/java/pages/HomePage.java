package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    @FindBy(linkText = "TEST STORE")
    public WebElement storePageLink;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    public WebElement storeLogoImage;

    public boolean verifyImageIsDisplayed(WebElement image) {
        Object result = ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript(
                "return arguments[0].complete && "+
                        "typeof arguments[0].naturalWidth != \"undefined\" && "+
                        "arguments[0].naturalWidth > 0", image);
        boolean loaded;
        if (result instanceof Boolean) {
            loaded = (Boolean) result;
            return loaded;
        } else {
            return false;
        }
    }



}
