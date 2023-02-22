package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class SeleniumUtils {

    public static void click(WebElement element){
        waitForElementClickability(element);
        moveIntoView(element);
        highlightElement(element);
        element.click();
    }

    public static void sendKeys(WebElement element, String inputText){
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        element.sendKeys(inputText);
    }

    public static String getText(WebElement element){
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        return element.getText();
    }

    public static boolean isDisplayed(WebElement element){
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        return element.isDisplayed();
    }

    public static void waitForElementClickability(WebElement element){
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void moveIntoView(WebElement element){
        ((JavascriptExecutor)WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }
    public static void moveToElement(WebElement element) {
        waitForElementVisibility(element);
        Actions actions = new Actions(WebDriverFactory.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();

        for(int i = 0; i < 4; i++){
            try{
                if(i % 2 == 0){
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black;" +
                            "border: 3px solid red; background: yellow");
                }else {
                    sleep(250L);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
