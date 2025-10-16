package pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CallUsButtonTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://98.80.120.96:3000"); // Change to your actual URL
    }

    @Test
    public void testCallUsButtonClick() {
        // Locate the "Call us" button by its text or class
        WebElement callUsButton = driver.findElement(By.xpath("//button[contains(text(),'Call us')]"));
        Assert.assertTrue(callUsButton.isDisplayed(), "'Call us' button should be visible");
        callUsButton.click();

      //  You can;
        //add further assertions here, e.g., check if a modal or phone dialer opens;
        //Example:
        //Assert that a modal is displayed (change selector as needed)
        //WebElement modal = driver.findElement(By.id("callModal"));
        //Assert.assertTrue(modal.isDisplayed(), "Call modal should appear after clicking");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) ;

    }

}
