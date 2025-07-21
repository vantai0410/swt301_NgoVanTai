package tainv.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;



public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout
    }

    protected WebElement waitForVisibility(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for element: " + locator);
            System.err.println("Current URL: " + driver.getCurrentUrl());
            System.err.println("Page source preview: " + driver.getPageSource().substring(0, Math.min(500, driver.getPageSource().length())));
            throw e;
        }
    }

    protected void click(By locator) {
        WebElement element = waitForVisibility(locator);
        // Scroll element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            System.err.println("Element click intercepted, trying JS click: " + locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    protected void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    protected boolean isElementVisible(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
