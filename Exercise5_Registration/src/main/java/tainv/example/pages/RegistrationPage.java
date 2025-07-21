package tainv.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderMale = By.cssSelector("label[for='gender-radio-1']");
    private By mobileField = By.id("userNumber");
    private By submitButton = By.id("submit");
    private By successModal = By.id("example-modal-sizes-title-lg");
    
    // Error locators
    private By firstNameError = By.cssSelector("#firstName:invalid");
    private By lastNameError = By.cssSelector("#lastName:invalid");
    private By emailError = By.cssSelector("#userEmail:invalid");
    private By mobileError = By.cssSelector("#userNumber:invalid");
    private By generalError = By.cssSelector(".was-validated .form-control:invalid");

    // Actions
    public void navigate() {
        navigateTo("https://demoqa.com/automation-practice-form");
        
        // Wait for page to load completely
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Debug: Print current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    public void fillForm(String firstName, String lastName, String email, String mobile) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(emailField, email);
        click(genderMale);
        type(mobileField, mobile);
        click(submitButton);
    }

    public String getSuccessMessage() {
        return getText(successModal);
    }
    
    public boolean isErrorVisible() {
        try {
            // Check if any validation error is visible
            return isElementVisible(firstNameError) || 
                   isElementVisible(lastNameError) || 
                   isElementVisible(emailError) || 
                   isElementVisible(mobileError) ||
                   isElementVisible(generalError);
        } catch (Exception e) {
            // If we can't find specific errors, check if success modal is NOT visible
            // This indicates form submission failed
            return !isElementVisible(successModal);
        }
    }
    
    public boolean isFormSubmitted() {
        return isElementVisible(successModal);
    }
}
