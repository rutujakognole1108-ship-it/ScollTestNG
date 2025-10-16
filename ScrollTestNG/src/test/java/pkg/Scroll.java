package pkg;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scroll {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://98.80.120.96:3000"); // Change to your local or deployed app URL
    }

    @Test
    public void testScrollUpAndDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000); // Wait to observe

        // Scroll up to top
        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(2000); // Wait to observe
    }

    @AfterClass
    public void tearDown() {
        if (driver != null);

    }
}
