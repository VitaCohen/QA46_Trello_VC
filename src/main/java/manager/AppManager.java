package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class AppManager {
    private WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(AppManager.class);

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Start testing"+ method.getName());
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(Method method){
        logger.info("Stop testing" + method.getName());
        //if(driver!=null){
          //  driver.quit();
    //}
    }
}
