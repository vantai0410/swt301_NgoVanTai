import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import vantai.example.AccountService;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @Test
    @DisplayName("Đăng ký tài khoản thành công với đầu vào hợp lệ")
    void testRegisterAccountSuccess() {
        boolean result = accountService.registerAccount("john123", "pass123", "john@example.com");
        assertTrue(result, "Đăng ký nên thành công với đầu vào hợp lệ");
    }

    @Test
    @DisplayName("Đăng ký tài khoản thất bại với tên người dùng null")
    void testRegisterAccountNullUsername() {
        boolean result = accountService.registerAccount(null, "pass123", "john@example.com");
        assertFalse(result, "Đăng ký nên thất bại với tên người dùng null");
    }

    @Test
    @DisplayName("Đăng ký tài khoản thất bại với tên người dùng rỗng")
    void testRegisterAccountEmptyUsername() {
        boolean result = accountService.registerAccount("", "pass123", "john@example.com");
        assertFalse(result, "Đăng ký nên thất bại với tên người dùng rỗng");
    }

    @Test
    @DisplayName("Đăng ký tài khoản thất bại với mật khẩu ngắn")
    void testRegisterAccountShortPassword() {
        boolean result = accountService.registerAccount("alice", "short", "alice@mail.com");
        assertFalse(result, "Đăng ký nên thất bại với mật khẩu <= 6 ký tự");
    }

    @Test
    @DisplayName("Đăng ký tài khoản thất bại với email không hợp lệ")
    void testRegisterAccountInvalidEmail() {
        boolean result = accountService.registerAccount("bob123", "password", "bobmail.com");
        assertFalse(result, "Đăng ký nên thất bại với email không hợp lệ");
    }

    @Test
    @DisplayName("Đăng ký tài khoản thất bại với email null")
    void testRegisterAccountNullEmail() {
        boolean result = accountService.registerAccount("bob123", "pass123", null);
        assertFalse(result, "Đăng ký nên thất bại với email null");
    }

    @Test
    @DisplayName("Email hợp lệ trả về true")
    void testValidEmail() {
        boolean result = accountService.isValidEmail("john@example.com");
        assertTrue(result, "Email hợp lệ nên trả về true");
    }

    @Test
    @DisplayName("Email không hợp lệ trả về false")
    void testInvalidEmail() {
        boolean result = accountService.isValidEmail("bobmail.com");
        assertFalse(result, "Email không hợp lệ nên trả về false");
    }

    @Test
    @DisplayName("Email null trả về false")
    void testNullEmail() {
        boolean result = accountService.isValidEmail(null);
        assertFalse(result, "Email null nên trả về false");
    }

    @ParameterizedTest(name = "Kiểm thử {index} => username={0}, password={1}, email={2}, expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    @DisplayName("Kiểm thử tham số hóa cho registerAccount với dữ liệu CSV")
    void testRegisterAccountWithCsvData(String username, String password, String email, boolean expected) {
        boolean result = accountService.registerAccount(username, password, email);
        assertEquals(expected, result, () -> "Đăng ký thất bại cho: " + username + ", " + password + ", " + email);
    }
}