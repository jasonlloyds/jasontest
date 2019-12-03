package seleniumTest.BeanConfig;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility
{
    @Autowired
    protected WebDriver driver;

    @After
    public void screenshot(Scenario scenario) throws IOException {
        System.out.println(" Screenshot method");
        if(scenario.isFailed()){
            System.out.println("Failed");
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("Screenshots\\"+ scenario.getName()+".jpg"));
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");    }}


    public static Properties getData() throws IOException{
        File file = new File("src/test/resources/test.properties");
        FileInputStream input = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(input);
        return prop;
    }
}

