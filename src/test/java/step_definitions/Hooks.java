package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.CucumberLogUtils;
import utils.WebDriverFactory;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        WebDriverFactory.getDriver().get(ConfigReader.getProperty("url"));
        CucumberLogUtils.initScenario(scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            CucumberLogUtils.logFail(scenario.getName(), true);
        } else {
            CucumberLogUtils.logPass(scenario.getName(), true);
        }
        WebDriverFactory.quitDriver();
    }
}
