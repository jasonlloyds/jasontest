package seleniumTest.BeanConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class DriverFactory {
    public DriverFactory(){
        PageFactory.initElements(driver, this);}

        public static RemoteWebDriver driver ;



}
