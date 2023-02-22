package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementsTemplates {

    public static final String XPATH_TEMPLATE_BUTTON = "//button[text()='%s']";
    public static final String XPATH_TEMPLATE_LINKTEXT = "//a[text()='%s']";

    public static final String XPATH_TEMPLATE_TEXT = "//*[text()='%s']";

    public static final String XPATH_TEMPLATE_TEXT_CONTAINS = "//*[contains (text(),'%s']";

    public static final String XPATH_TEMPLATE_INPUT_FIELD = "//input[@placeholder='%s']";


    public static WebElement linkTextTemplate(String text) {
        return WebDriverFactory.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, text)));
    }

    public static WebElement xpathButtonTemplate(String text) {
        return WebDriverFactory.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_BUTTON, text)));
    }

    public static WebElement xpathTextTemplate(String text) {
        return WebDriverFactory.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT, text)));
    }

    public static WebElement xpathTextContainsTemplate(String text) {
        return WebDriverFactory.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT_CONTAINS, text)));
    }


}

