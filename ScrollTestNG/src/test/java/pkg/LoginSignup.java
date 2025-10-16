package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginSignup {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
       WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://98.80.120.96:3000");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Trigger the modal if necessary, e.g., by clicking "Hello, Sign in Account"
        WebElement signInBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Hello, Sign in') or contains(text(),'Account')]"))
        );
        signInBtn.click();
    }

    @Test
    public void testLoginModalVisible() {
        WebElement modal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Login to continue')]"))
        );
        assert modal.isDisplayed();
    }

    @Test
    public void testEnterMobileNumberAndGetOtpButtonEnabled() {
        WebElement mobileInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' or @placeholder='Enter 10 digit number']"))
        );
        mobileInput.sendKeys("9876543210");
        WebElement getOtpBtn = driver.findElement(By.xpath("//button[contains(text(),'Get OTP')]"));
        assert getOtpBtn.isEnabled();
    }

    @Test
    public void testGetOtpButtonClick() {
        WebElement mobileInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' or @placeholder='Enter 10 digit number']"))
        );
        mobileInput.sendKeys("9876543210");
        WebElement getOtpBtn = driver.findElement(By.xpath("//button[contains(text(),'Get OTP')]"));
        getOtpBtn.click();
        // Add assertions for expected result, e.g., OTP input field appears, or a success message is displayed
    }

    @Test
    public void testPrivacyPolicyLink() {
        WebElement privacyLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Privacy Policy"))
        );
        privacyLink.click();
        // Add assertions to verify navigation or popup for Privacy Policy
    }

    @Test
    public void testTermsAndConditionsLink() {
        WebElement termsLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Terms & Conditions")));
        termsLink.click();
        // Add assertions to verify navigation or popup for Terms & Conditions
    }

    @Test
    public void testCloseLoginModal() {
        WebElement closeBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@aria-label,'Close') or contains(@class,'close')] | //span[text()='×']"))
        );
        closeBtn.click();
        // Assert that the modal is closed
        boolean modalClosed = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Login to continue')]"))
        );
        assert modalClosed;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

