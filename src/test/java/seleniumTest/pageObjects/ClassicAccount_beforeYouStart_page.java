package seleniumTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumTest.BeanConfig.DriverFactory;

public class ClassicAccount_beforeYouStart_page extends DriverFactory {

    @FindBy(xpath="//button[@class='btn continue']")
    public WebElement continueButton;

    public void clickContinue (){
        continueButton.click();
    }

}
