package seleniumTest.step_def;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import seleniumTest.BeanConfig.DriverFactory;
import seleniumTest.BeanConfig.Utility;
import seleniumTest.pageObjects.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class currenct_account_step_definition extends DriverFactory {

    protected Environment environment;


    @Given("Customer launches the Lloyds Bank Website")
    public void customer_launches_the_Lloyds_Bank_Website() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/seleium_brower_driver/chromedriver");
        driver = new ChromeDriver();
        //driver.get("https://www.lloydsbank.com");
       // System.out.println(Utility.getData().getProperty("lloydsbank_url"));
        driver.get(Utility.getData().getProperty("lloydsbank_url"));
        driver.manage().window().maximize();

    }

    @When("Customer click {string}")
    public void customer_click(String ProductType) {

        FrontPage frontPage = new FrontPage();
        //System.out.println(frontPage);
        frontPage.clickCurrentAccount();

        // Write code here that turns the phrase above into concrete actions
    }

    @When("Customer choose {string}")
    public void customer_choose(String string) {
        // Write code here that turns the phrase above into concrete actions
        CurrentAccountPage currentAccountPage = new CurrentAccountPage();
        currentAccountPage.clickClassAccount();

        ClassicAccountPage classicAccountPage = new ClassicAccountPage();
        classicAccountPage.applyClassicAccount();

    }

    @When("Customer enter No in the existing customer page")
    public void customer_enter_No_in_the_existing_customer_page() {
        ClassicAccount_applyNow_page classicAccount_applyNow_page = new ClassicAccount_applyNow_page();
        classicAccount_applyNow_page.existingLloydsBankCustomer();
    }



    @When("Customer click continue in the before you start page")
    public void customer_click_continue_in_the_before_you_start_page() {
        // Write code here that turns the phrase above into concrete actions
        ClassicAccount_beforeYouStart_page classicAccount_beforeYouStart_page = new ClassicAccount_beforeYouStart_page();
        classicAccount_beforeYouStart_page.clickContinue();
    }

    @When("Customer will fill in all the details")
    public void customer_will_fill_in_all_the_details() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        ClassAccount_application_page classAccount_application_page = new ClassAccount_application_page();
        classAccount_application_page.fillInDetail();
    }

    @Then("Customer will be able to create a new account")
    public void customer_will_be_able_to_create_a_new_account() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }

}
