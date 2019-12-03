package seleniumTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumTest.BeanConfig.DriverFactory;

public class ClassicAccountPage extends DriverFactory {


    @FindBy(xpath = "(//a[@title='Apply now'][@href='https://apply.lloydsbank.co.uk/sales-content/cwa/l/pca/?product=classicaccountLTB'])[2]")
    public WebElement applyNowButton;

    public void applyClassicAccount(){
        applyNowButton.click();
    }
}
