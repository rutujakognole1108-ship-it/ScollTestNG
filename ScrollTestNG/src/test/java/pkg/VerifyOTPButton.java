package pkg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


    public class VerifyOTPButton {
        private WebDriver driver;
        private WebDriverWait wait;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://98.80.120.96:3000");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Open login modal if not shown by default
            WebElement signInBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Hello, Sign in') or contains(text(),'Account')]"))
            );
            signInBtn.click();
        }

        @Test
        public void testMobileNumberFieldDisplayedAndAcceptsInput() {
            // Verify the Mobile Number field is visible
            WebElement mobileInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' or @placeholder='Enter 10 digit number']"))
            );
            Assert.assertTrue(mobileInput.isDisplayed(), "Mobile number field should be displayed.");

            // Enter a valid mobile number and verify it is accepted
            String mobileNum = "9834235030";
            mobileInput.sendKeys(mobileNum);
            Assert.assertEquals(mobileInput.getAttribute("value"), mobileNum, "Mobile number input should match entered value.");
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }


