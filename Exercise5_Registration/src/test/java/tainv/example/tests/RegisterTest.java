package tainv.example.tests;

import org.junit.jupiter.api.Test;
import tainv.example.pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest {
    // Đã xóa testRegisterSuccess

    @Test
    public void testRegisterFail_EmptyFields() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigate();
        registerPage.fillForm("", "", "", "", "", false);
        assertTrue(registerPage.isEmailErrorVisible());
        assertTrue(registerPage.isPasswordErrorVisible());
        assertTrue(registerPage.isConfirmPasswordErrorVisible());
        assertTrue(registerPage.isFullNameErrorVisible());
        assertTrue(registerPage.isPhoneErrorVisible());
        assertTrue(registerPage.isAgreeTermsErrorVisible());
    }

    @Test
    public void testRegisterWithInvalidEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigate();
        registerPage.fillForm(
            "invalid-email", // Email không hợp lệ
            "Password123!",
            "Password123!",
            "Nguyen Van A",
            "0912345678",
            true
        );
        assertTrue(registerPage.isEmailErrorVisible());
    }

    @Test
    public void testRegisterWithWeakPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigate();
        registerPage.fillForm(
            "test" + System.currentTimeMillis() + "@mail.com",
            "123", // Password yếu
            "123",
            "Nguyen Van A",
            "0912345678",
            true
        );
        assertTrue(registerPage.isPasswordErrorVisible());
    }

    @Test
    public void testRegisterWithMismatchedPasswords() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigate();
        registerPage.fillForm(
            "test" + System.currentTimeMillis() + "@mail.com",
            "Password123!",
            "Password456!", // Không khớp
            "Nguyen Van A",
            "0912345678",
            true
        );
        assertTrue(registerPage.isConfirmPasswordErrorVisible());
    }

    @Test
    public void testRegisterWithInvalidPhone() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigate();
        registerPage.fillForm(
            "test" + System.currentTimeMillis() + "@mail.com",
            "Password123!",
            "Password123!",
            "Nguyen Van A",
            "abc", // Số điện thoại sai
            true
        );
        assertTrue(registerPage.isPhoneErrorVisible());
    }

    @Test
    public void testRegisterWithoutAgreeTerms() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.navigate();
        registerPage.fillForm(
            "test" + System.currentTimeMillis() + "@mail.com",
            "Password123!",
            "Password123!",
            "Nguyen Van A",
            "0912345678",
            false // Không tick điều khoản
        );
        assertTrue(registerPage.isAgreeTermsErrorVisible());
    }
} 