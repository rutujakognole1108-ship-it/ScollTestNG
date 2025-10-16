package pkg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;


public class AllTest {



    public class LogoTest {
        private WebDriver driver;
        private WebDriverWait wait;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://98.80.120.96:3000");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @Test
        public void testClickLogo() {
            // Locate logo using alt or class (adjust XPath if needed after inspecting in DevTools)
            WebElement logo = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@alt, 'RED')]"))
            );
            logo.click();
            // Add assertions here if you want to verify redirection or home navigation
        }

        @Test
        public void testClickTypeDropdown() {
            // Locate dropdown by class or other unique property
            WebElement typeDropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@class,'type')]"))
            );
            typeDropdown.click();
            // Add assertions here if you want to verify dropdown options are visible
        }

        @Test
        public void testClickMakerDropdown() {
            // Locate maker dropdown by class or other unique property
            WebElement makerDropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@class,'maker')]"))
            );
            makerDropdown.click();
            // Add assertions here if you want to verify dropdown options are visible
        }

        @Test
        public void testClickFindMyCarButton() {
            // Locate "Find My Car" button by text or class
            WebElement findMyCarBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'FIND MY CAR')]"))
            );
            findMyCarBtn.click();
            // Add assertions here if you want to verify search results or navigation
        }

        @Test
        public void testClickCallUsButton() {
            // Locate "Call us" button by text
            WebElement callUsBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Call us')]"))
            );
            callUsBtn.click();
            // Add assertions here if you want to verify popup or call action
        }

        @Test
        public void testClickSearchIcon() {
            // Locate search icon (adjust XPath or use CSS selector after inspecting)
            WebElement searchIcon = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'search')]"))
            );
            searchIcon.click();
            // Add assertions here if you want to verify search box or results
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
