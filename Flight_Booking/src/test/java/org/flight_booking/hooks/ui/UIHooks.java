package org.flight_booking.hooks.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.flight_booking.ui.factory.ConfigReader;
import org.flight_booking.ui.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class UIHooks {
        private WebDriver driver;

        @Before
        public void before_all(){
            String browser = System.getProperty("browser");
            if (browser == null || browser.isEmpty()) {
                browser = ConfigReader.getInstance().getProperty("browser");
            }
            WebDriverFactory.setThreadLocalDriver(browser);
            driver = WebDriverFactory.getThreadLocalDriver();
            driver.manage().window().maximize();
        }

        @After
        public void after_all(){
            if (driver != null) {
                WebDriverFactory.quitDriverAndRemove();
            }
        }
    }
