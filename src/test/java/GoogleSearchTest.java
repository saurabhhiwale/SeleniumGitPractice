import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyGoogleSearch() {

        driver.get("https://www.google.com");

        driver.findElement(By.name("q"))
                .sendKeys("Selenium WebDriver");

        driver.findElement(By.name("q"))
                .submit();

        Assert.assertTrue(
                driver.getTitle().contains("Selenium"),
                "Google search result title does not contain Selenium"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}