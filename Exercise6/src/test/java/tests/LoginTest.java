package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tainv.example.pages.LoginPage;

public class LoginTest {
    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Login"); // Sửa lại URL login thực tế
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginSuccess() {
        loginPage.login("testuser", "testpassword");
        // Kiểm tra đăng nhập thành công, ví dụ kiểm tra URL hoặc element xuất hiện
        assertTrue(driver.getCurrentUrl().contains("home")); // Sửa lại theo thực tế
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
