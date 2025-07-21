package tainv.example.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.*;
import tainv.example.pages.RegistrationPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Registration Tests for demoqa.com")
public class RegistrationTest extends BaseTest {
    static RegistrationPage registrationPage;
    static WebDriverWait wait;

    @BeforeAll
    static void initPage() {
        registrationPage = new RegistrationPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @Order(1)
    @DisplayName("Should register successfully with valid data")
    void testRegistrationSuccess() {
        registrationPage.navigate();
        registrationPage.fillForm("John", "Doe", "john.doe@example.com", "1234567890");
        String successMsg = registrationPage.getSuccessMessage();
        assertTrue(successMsg.contains("Thanks for submitting the form"));
    }

    @ParameterizedTest(name = "Test registration with: {0} / {1} / {2} / {3}")
    @Order(2)
    @CsvSource({
            "John, Doe, invalid-email, 1234567890", // Invalid email
            "'', Doe, john.doe@example.com, 1234567890", // Empty first name
            "John, '', john.doe@example.com, 1234567890", // Empty last name
            "John, Doe, john.doe@example.com, 123" // Invalid mobile
    })
    @DisplayName("Should show error for invalid registration data")
    void testRegistrationFail(String firstName, String lastName, String email, String mobile) {
        registrationPage.navigate();
        firstName = (firstName == null) ? "" : firstName.trim();
        lastName = (lastName == null) ? "" : lastName.trim();
        email = (email == null) ? "" : email.trim();
        mobile = (mobile == null) ? "" : mobile.trim();

        registrationPage.fillForm(firstName, lastName, email, mobile);
        
        // Wait a bit for form validation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Check that form was not successfully submitted
        assertTrue(!registrationPage.isFormSubmitted(), "Form should not submit with invalid data");
    }
}