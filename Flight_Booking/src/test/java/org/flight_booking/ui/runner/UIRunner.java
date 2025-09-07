package org.flight_booking.ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.flight_booking.ui.factory.ConfigReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class UIRunner extends AbstractTestNGCucumberTests {
        @BeforeTest
        @Parameters({"browser"})
        void setBrowser(@Optional("chrome") String browser){
            ConfigReader.getInstance().setBrowser(browser);
        }

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){
            return super.scenarios();
        }
}


