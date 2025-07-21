package tainv.example.tests;

import org.junit.jupiter.api.Test;
import tainv.example.pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("your_email@example.com", "your_password");
        // TODO: Thêm assert kiểm tra login thành công nếu có locator
    }

    @Test
    public void testLoginFail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("wrong_email@example.com", "wrong_password");
        // TODO: Thêm assert kiểm tra login thất bại nếu có locator
    }

    @Test
    public void testLoginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("your_email@example.com", "wrong_password");
        // TODO: Thêm assert kiểm tra login thất bại nếu có locator
    }

    @Test
    public void testLoginWithWrongEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("wrong_email@example.com", "your_password");
        // TODO: Thêm assert kiểm tra login thất bại nếu có locator
    }

    @Test
    public void testLoginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("your_email@example.com", "");
        // TODO: Thêm assert kiểm tra login thất bại nếu có locator
    }

    @Test
    public void testLoginWithEmptyEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("", "your_password");
        // TODO: Thêm assert kiểm tra login thất bại nếu có locator
    }
} 