package seleniumTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumTest.BeanConfig.DriverFactory;

public class ClassicAccount_applyNow_page extends DriverFactory {

    @FindBy(xpath = "(//span[text()='No'])[last()]")
    public WebElement noButton;

    @FindBy(xpath="//button[@class='btn continue']")
    public WebElement continueButton;

    public void existingLloydsBankCustomer(){
        noButton.click();
        continueButton.click();
    }

}
