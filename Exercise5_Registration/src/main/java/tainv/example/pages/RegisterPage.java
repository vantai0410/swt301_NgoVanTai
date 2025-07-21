package tainv.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By fullNameField = By.id("fullName");
    private By phoneField = By.id("phone");
    private By agreeTermsCheckbox = By.id("agreeTerms");
    private By submitButton = By.id("submitBtn");

    // Error messages
    private By emailError = By.id("emailError");
    private By passwordError = By.id("passwordError");
    private By confirmPasswordError = By.id("confirmPasswordError");
    private By fullNameError = By.id("fullNameError");
    private By phoneError = By.id("phoneError");
    private By agreeTermsError = By.id("agreeTermsError");

    public void navigate() {
        navigateTo("http://localhost:8080/Register/Student");
    }

    public void fillForm(String email, String password, String confirmPassword, String fullName, String phone, boolean agreeTerms) {
        type(emailField, email);
        type(passwordField, password);
        type(confirmPasswordField, confirmPassword);
        type(fullNameField, fullName);
        type(phoneField, phone);
        if (agreeTerms) {
            if (driver.findElements(agreeTermsCheckbox).size() > 0) {
                WebElement checkbox = driver.findElement(agreeTermsCheckbox);
                if (checkbox.isDisplayed() && !checkbox.isSelected()) {
                    click(agreeTermsCheckbox);
                }
            }
        }
        if (driver.findElements(submitButton).size() > 0) {
            WebElement submit = driver.findElement(submitButton);
            if (submit.isDisplayed() && submit.isEnabled()) {
                click(submitButton);
            }
        }
    }

    public boolean isEmailErrorVisible() {
        return isElementVisible(emailError);
    }
    public boolean isPasswordErrorVisible() {
        return isElementVisible(passwordError);
    }
    public boolean isConfirmPasswordErrorVisible() {
        return isElementVisible(confirmPasswordError);
    }
    public boolean isFullNameErrorVisible() {
        return isElementVisible(fullNameError);
    }
    public boolean isPhoneErrorVisible() {
        return isElementVisible(phoneError);
    }
    public boolean isAgreeTermsErrorVisible() {
        return isElementVisible(agreeTermsError);
    }
} 