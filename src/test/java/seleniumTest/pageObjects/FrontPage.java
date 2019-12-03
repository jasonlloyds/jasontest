package seleniumTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumTest.BeanConfig.DriverFactory;
import seleniumTest.step_def.currenct_account_step_definition;

public class FrontPage extends DriverFactory {
//    public FrontPage() {
//        PageFactory.initElements(driver, this);
//    }


    @FindBy(xpath = "(//a[@title='Current accounts'])[1]")
    private WebElement currentAccountButton;


    public void clickCurrentAccount(){

        currentAccountButton.click();
    }

}
