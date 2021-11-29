import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UiTest {
    @Parameters("Browser")
    @Test
    public void startBrowser(@Optional("Chrome") String browserName)
    {
        System.out.println("Parameter value is "+browserName);
        WebDriver driver=null;

        if(browserName.contains("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browserName.contains("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Assert.assertTrue(driver.getTitle().contains("Orange"), "Title does not match");
        driver.quit();
    }

}
