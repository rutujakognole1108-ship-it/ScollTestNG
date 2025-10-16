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

public class Logo {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://98.80.120.96:3000");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testClickLogo() {
        // Update the XPath as per actual HTML. Example: Use Chrome DevTools to verify.
        WebElement logo = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@alt, 'RED')]"))
        );
        logo.click();
        // Assert home navigation if needed
    }

    @Test
    public void testClickTypeDropdown() {
        // Use the correct locator found by inspecting the dropdown element
        WebElement typeDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@class,'type')]"))
        );
        typeDropdown.click();
        // Assert dropdown options visible if needed
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



