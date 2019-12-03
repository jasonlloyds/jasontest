package seleniumTest.BeanConfig;

//import com.pega.selenium.tests.config.BrowserCapabilities;
//import com.pega.selenium.tests.config.TryFunction;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * {@link} BeanConfig config class for all bean creation
 */
@PropertySource({"classpath:test.properties"})
//@PropertySource({"classpath:${env:env}.properties"})
@Configuration
@ComponentScan(basePackages = "src.test.java.seleniumTest.pageObjects")
public class BeanConfig {

    @Autowired
    private Environment environment;

    @Autowired(required = false)
    private URL seleniumGridURL;

    private static final Logger LOG = LoggerFactory.getLogger(BeanConfig.class);
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    @Value("${browser}")
    private String browser;

    @Value("${remote}")
    private String remote;

    /**
     * @link Initialize system path variables for browsers
     */
    @PostConstruct
    public void getEnvironmentInfo() throws IOException {

        LOG.info(" ");
        LOG.info("Current Operating System: " + operatingSystem);
        LOG.info("Current Architecture: " + systemArchitecture);
        LOG.info("Current Browser Selection: " + browser);
        LOG.info("Use RemoteWebDriver: " + remote);
        LOG.info(" ");

    }

    @PostConstruct
    public void setDriverPath() throws IOException {

//        TryFunction<String, String> path = location -> new File(".").getCanonicalPath()+"/src/test/resources/"+location;
//
//        switch (browser.toUpperCase()){
//            case "CHROME":
//                if (operatingSystem.contains("WINDOWS")) {
//                    System.setProperty("webdriver.chrome.driver",path.apply("selenium_browser_drivers/windowsChromedriver/chromedriver.exe"));
//                } else if (operatingSystem.contains("MAC")) {
//                    System.setProperty("webdriver.chrome.driver",path.apply("selenium_browser_drivers/macChromedriver/chromedriver"));
//                } else if (operatingSystem.contains("LINUX")) {
//                    System.setProperty("webdriver.chrome.driver",path.apply("selenium_browser_drivers/linuxChromedriver/chromedriver"));
//                }
//                break;
//            case "IE":
//                System.setProperty("webdriver.ie.driver",path.apply("selenium_browser_drivers/windowsIEdriver/IEDriverServer.exe"));
//                break;
//        }
    }



    /**
     * @link Chrome bean generator
     */
    @Bean(destroyMethod = "quit")
    @Conditional(BeanConfig.ChromeCondition.class)
    @Autowired
    public ChromeDriver chrome(DesiredCapabilities capabilities) {
        return new ChromeDriver(capabilities);
    }


    //@Bean
    @Conditional(BeanConfig.ChromeCapabilityCondition.class)
//    public DesiredCapabilities chromeDesiredCapabilities(){
//        return BrowserCapabilities.newInstance().getChromeCapabilities();
//    }


    private static class ChromeCapabilityCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            List<Boolean> chromeSelector=new ArrayList<>();
            Environment env=context.getEnvironment();
            String browser=env.getProperty("browser","chrome");
            String remote=env.getProperty("remote", "false");
            chromeSelector.add(browser.equalsIgnoreCase("chrome"));
            chromeSelector.add(remote.equalsIgnoreCase("false") || remote.isEmpty());
            return chromeSelector.get(0)&&chromeSelector.get(1);
        }
    }

    /**
     * @link Condition for creating chrome browser bean
     */
    private static class ChromeCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            List<Boolean>chromeSelector=new ArrayList<>();
            Environment env=context.getEnvironment();
            String browser=env.getProperty("browser","chrome");
            String remote=env.getProperty("remote", "false");
            chromeSelector.add(browser.equalsIgnoreCase("chrome"));
            chromeSelector.add(remote.equalsIgnoreCase("false") || remote.isEmpty());
            return chromeSelector.get(0)&&chromeSelector.get(1);
        }
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * @link remoteDriver bean generator
     */
    @Bean(destroyMethod="quit")
    @Conditional(BeanConfig.RemoteCondition.class)
    @Autowired
    public WebDriver remoteWebdriver(DesiredCapabilities capabilities) throws MalformedURLException {
        System.out.println("Remote Webdriver Created");
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL(System.getProperty("hub")),capabilities);
        webDriver.manage().window().maximize();
        webDriver.setFileDetector(new LocalFileDetector());
        return webDriver;
    }

    /**
     * @link Condition for creating remote chrome browser bean
     */
   // @Bean
    @Conditional(BeanConfig.RemoteCondition.class)
//    public DesiredCapabilities remoteChromeDesiredCapabilities(){
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        capabilities = BrowserCapabilities.newInstance().getChromeCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setJavascriptEnabled(true);
//        capabilities.setPlatform(Platform.LINUX);
//        capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
//        return capabilities;
//    }

    /**
     * @link Condition for creating remoteWebdriver bean
     */
    private static class RemoteCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            Environment env =context.getEnvironment();
            return env.getProperty("remote").equalsIgnoreCase("true");
        }
    }
}