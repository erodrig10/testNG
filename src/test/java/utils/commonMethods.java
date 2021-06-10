package utils;

import com.sun.tools.internal.jxc.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class commonMethods {

    public static WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public static void setUp() {
        configReader.getPropValue(constants.CONFIGURATION_FILEPATH);
        switch (configReader.getPropValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup().
                    driver = new ChromeDriver();
                

                break;

        }
        driver.get(configReader.getPropValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(constants.IMPLICT_WAIT, TimeUnit.SECONDS);

        }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, constants.EXPLIICIT_WAIT);
        return wait;

    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }
    public static void jsclick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click()", element);
        
    }

    @Test
    public void test() {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.dir"));


    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


