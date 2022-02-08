import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestPlanTest {

    private static WebDriver driver;

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
            //System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
            System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
            //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver(new ChromeDriverService.Builder().usingPort(65000).build());

    }



    @Test(testName = "Submit a WebForm")
    public static void submitForm(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.enterFirstName();
        webForm.enterLastName();
        webForm.pressSubmitButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyAlertSuccess();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
