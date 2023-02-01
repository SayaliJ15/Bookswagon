package testbase;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import utils.Utility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {
    public static WebDriver driver;
    public static Properties prop;

    public WebTestBase() {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void initialization(){
            String browserName = prop.getProperty("browser");
            if (browserName.equals("chrome")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
                driver =  new ChromeDriver();
            }


            driver.navigate().to(prop.getProperty("url"));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD_TIMEOUT));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICITLY_WAIT));
            driver.manage().deleteAllCookies();
        }
    }


