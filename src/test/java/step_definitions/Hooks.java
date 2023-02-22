package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import utils.WebDriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        WebDriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
