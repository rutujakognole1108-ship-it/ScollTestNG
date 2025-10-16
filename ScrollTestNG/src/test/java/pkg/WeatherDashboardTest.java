package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WeatherDashboardTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set path to chromedriver if not in PATH
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000"); // Change to your dashboard URL
    }

    @Test
    public void testScrollAndUIElements() {
        // Wait for page to load
        WebElement heading = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(heading.getText(), "Weather Dashboard");

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Check input box is visible
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        Assert.assertTrue(input.isDisplayed());

        // Type in a city and submit
        input.sendKeys("London");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        // Wait for result (simple sleep, use WebDriverWait in real test)
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // Check result is displayed
        WebElement temp = driver.findElement(By.xpath("//*[contains(text(),'Temperature')]"));
        Assert.assertTrue(temp.isDisplayed());
    }

    @AfterClass
    public void tearDown() {

    }
}

