package tainv.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    // Nếu có thông báo lỗi/thành công, bổ sung locator ở đây
    // private By errorMessage = By.cssSelector(".error-message");

    public void navigate() {
        navigateTo("http://localhost:8080/Login");
    }

    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
    }

    // public boolean isErrorVisible() {
    //     return isElementVisible(errorMessage);
    // }
} 