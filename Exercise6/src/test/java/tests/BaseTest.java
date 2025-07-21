package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import tainv.example.utils.DriverFactory;

public abstract class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUpBase() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDownBase() {
        if (driver != null) {
            driver.quit();
        }
    }
}
