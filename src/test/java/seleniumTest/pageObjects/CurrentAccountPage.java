package seleniumTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumTest.BeanConfig.DriverFactory;

public class CurrentAccountPage extends DriverFactory {

    @FindBy(xpath = "(//a[@class='button button-primary'])[1]")
    public WebElement classicAccountFindOutMore;

    public void  clickClassAccount(){
        classicAccountFindOutMore.click();
    }
}
