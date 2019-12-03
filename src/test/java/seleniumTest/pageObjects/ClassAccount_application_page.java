package seleniumTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.env.Environment;
import seleniumTest.BeanConfig.DriverFactory;
import seleniumTest.BeanConfig.Utility;

import java.io.IOException;
import java.util.List;

public class ClassAccount_application_page extends DriverFactory {

    protected Environment environment;

    @FindBy(xpath ="//select[@name='title']")
    public WebElement title;

    @FindBy(xpath = "//input[contains(@title,'Full first Name')]")
    public WebElement firstName;

    @FindBy (xpath ="//input[contains(@title,'Middle Name')]")
    public WebElement middleName;

    @FindBy (xpath ="//input[@title='Last Name']")
    public WebElement lastName;

    @FindBy (xpath ="//input[@name='dobDate']")
    public WebElement date;

    @FindBy (xpath = "//input[@name='dobMonths']")
    public WebElement months;

    @FindBy (xpath = "//input[@name='dobYears']")
    public WebElement years;

    @FindBy (xpath="//span[text()='Male']")
    public WebElement gender;

    @FindBy (xpath="//select[@title='Marital status']")
    public WebElement maritalStatus;

    @FindBy (xpath="//select[@title='Nationality']")
    public WebElement nationality;

    @FindBy (xpath = "//select[@title = 'Country of birth']")
    public WebElement countryOfBirth;

    @FindBy (xpath = "//select[@title = 'Country/countries in which you have tax residency ']")
    public WebElement taxResidency;

    @FindBy (xpath="//a[@data-selector='whereYouLive-link']")
    public WebElement whereYouLive;

    @FindBy (xpath = "//input[@name = 'post-code-input']")
    public WebElement inputPostCode;

    @FindBy (xpath = "//button[@class='highlight findAdress']")
    public WebElement findAddressButton;

    @FindBy (xpath = "//select[@title='Select your address and press confirm']//child::option[1]")
    public WebElement selectAddress;

    @FindBy (xpath = "//button[@name='select-address']")
    public WebElement confirmAddress;

    @FindBy (xpath = "//select[@name='durationOfStay-year']")
    public WebElement durationOfStayYear;

    @FindBy (xpath = "//select[@name='durationOfStay-month']")
    public WebElement durationOfStayMonth;

    @FindBy (xpath = "//select[@name='residentialStatus']")
    public WebElement residentialStatus;

    @FindBy (xpath ="//a[@data-selector='contactDetails-link']")
    public WebElement contactDetailsButton;

    @FindBy (xpath = "//select[@name='mainPhoneNo-deviceType']")
    public WebElement mainPhoneNumberType;

    @FindBy (xpath = "//input[@name='mainPhoneNo-countryCode']")
    public WebElement phoneNumberCountryCode;

    @FindBy (xpath="//input[@name = 'mainPhoneNoNumber']")
    public WebElement mainPhoneNumber;

    @FindBy (xpath = "//input[@name='emailAddress']")
    public WebElement emailAddress;

    @FindBy (xpath = "//input[@name='confirmEmailAddress']")
    public WebElement confirmEmailAddress;

    @FindBy (xpath = "//a[@data-selector='marketingPreferences-link']")
    public WebElement yourMarketingChoiceLink;

    @FindBy (xpath = "//input[contains(@id,'internet-banking-yes')]//parent::div")
    public WebElement internetBanking;

    @FindBy (xpath = "//input[contains(@id,'email-yes')]//parent::div")
    public WebElement email;

    @FindBy (xpath = "//input[contains(@id,'post-yes')]//parent::div")
    public WebElement post;

    @FindBy (xpath= "//input[contains(@id,'device-messaging-yes')]//parent::div")
    public WebElement deviceMessaging;

    @FindBy (xpath= "//input[contains(@id,'text-messages-yes')]//parent::div")
    public WebElement textmessages;

    @FindBy (xpath= "//input[contains(@id,'phone-yes')]//parent::div")
    public WebElement phone;

    @FindBy (xpath = "//a[@data-selector='incomeExpenses-link']")
    public WebElement incomeExpensesLink;

    @FindBy (xpath = "//input[@class='currency medium']")
    public WebElement monthlyIncome;

    @FindBy (xpath = "//label[contains(@for,'incomeExpensesno')]")
    public WebElement monthlyIncomeRadioButton;

    @FindBy (xpath = "//label[@for='checkbox-bills']")
    public WebElement billCheckbox;

    @FindBy (xpath = "//label[@for='checkbox-spendings']")
    public WebElement spendingCheckbox;

    @FindBy (xpath = "//label[@for='checkbox-savings']")
    public WebElement savingCheckbox;

    @FindBy (xpath = "//select[@data-selector='incomeExpensespaymoney-select']")
    public  WebElement paymentMethod;

    @FindBy (xpath = "//input[@data-selector='incomeExpensesapproxmoney-input']")
    public WebElement approxPayIn;

    @FindBy (xpath = "//select[@data-selector='incomeExpensesempStatus-select']")
    public WebElement employmentStatus;

    @FindBy (xpath = "//select[@name = 'occType']")
    public WebElement occupationType;

    @FindBy (xpath = "//input[@name='employer']")
    public WebElement nameOfEmployer;

    @FindBy (xpath = "//select[@name='employersLength-year']")
    public WebElement workYear;

    @FindBy (xpath = "//select[@name='employersLength-month']")
    public WebElement workMonth;

    @FindBy (xpath = "//input[@data-selector='spendingExpensesmortgages-input']")
    public WebElement mortgagePayment;

    @FindBy (xpath = "//input[@data-selector='spendingExpensesspending-input']")
    public WebElement expensespayment;

    @FindBy (xpath = "//select[@data-selector='incomeExpensessavingsAmount-select']")
    public WebElement totalSaving;

    @FindBy (xpath = "//button[@data-selector='yourDetails-continue-button']")
    public WebElement continueButton1;

public void fillInDetail () throws IOException, InterruptedException {

    //About you


    Select t= new Select(title);
    t.selectByVisibleText(Utility.getData().getProperty("title"));

    WebDriverWait wait = new WebDriverWait(driver,1);
    WebElement textAppear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@title,'Full first Name')]")));


    firstName.sendKeys(Utility.getData().getProperty("fullFirstName"));

    middleName.sendKeys(Utility.getData().getProperty("middleName"));

    lastName.sendKeys(Utility.getData().getProperty("lastName"));

    date.sendKeys(Utility.getData().getProperty("day"));

    months.sendKeys(Utility.getData().getProperty("month"));

    years.sendKeys(Utility.getData().getProperty("year"));

    gender.click();

    maritalStatus.sendKeys(Utility.getData().getProperty("MaritalStatus"));

    nationality.sendKeys(Utility.getData().getProperty("Nationality"));

    countryOfBirth.sendKeys(Utility.getData().getProperty("CountryOfBirth"));

    taxResidency.sendKeys(Utility.getData().getProperty("taxResidency"));

    //Where you live
    whereYouLive.click();

    inputPostCode.sendKeys(Utility.getData().getProperty("postcode"));
    findAddressButton.click();

//    WebDriverWait wait = new WebDriverWait(driver,20);
//    WebElement textAppear;
//    textAppear = wait.until(ExpectedConditions.visibilityOf();
//    Thread.sleep(1000);
    List <WebElement> list = driver.findElements(By.xpath("//select[@title='Select your address and press confirm']"));
    if(list.size()==0){
        Thread.sleep(1000);
    }

    selectAddress.click();

    confirmAddress.click();

    durationOfStayYear.sendKeys(Utility.getData().getProperty("durationOfStayYear"));

    durationOfStayMonth.sendKeys(Utility.getData().getProperty("durationOfStayMonth"));

    residentialStatus.sendKeys(Utility.getData().getProperty("residentialStatus"));

    //Contact details
    contactDetailsButton.click();

    mainPhoneNumberType.sendKeys(Utility.getData().getProperty("mainPhoneNumberType"));

    //phoneNumberCountryCode.clear();

    phoneNumberCountryCode.sendKeys(Utility.getData().getProperty("phoneNumberCountryCode"));

    mainPhoneNumber.sendKeys(Utility.getData().getProperty("mainPhoneNumber"));

    emailAddress.sendKeys(Utility.getData().getProperty("emailAddress"));

    confirmEmailAddress.sendKeys(Utility.getData().getProperty("confirmEmailAddress"));

    //Your marketing choice

    yourMarketingChoiceLink.click();

    internetBanking.click();

    email.click();

    post.click();

    deviceMessaging.click();

    textmessages.click();

    phone.click();

    //Income and expenses

    incomeExpensesLink.click();

    monthlyIncome.sendKeys(Utility.getData().getProperty("monthlyIncome"));

    monthlyIncomeRadioButton.click();

    billCheckbox.click();

    spendingCheckbox.click();

    paymentMethod.sendKeys(Utility.getData().getProperty("payMethod"));

    approxPayIn.sendKeys(Utility.getData().getProperty("approxPayIn"));

    employmentStatus.sendKeys(Utility.getData().getProperty("employmentStatus"));

    occupationType.sendKeys(Utility.getData().getProperty("occupationType"));

    nameOfEmployer.sendKeys(Utility.getData().getProperty("nameOfEmployer"));

    workYear.sendKeys(Utility.getData().getProperty("workYear"));

    workMonth.sendKeys(Utility.getData().getProperty("workMonth"));

    mortgagePayment.sendKeys(Utility.getData().getProperty("mortgagePayment"));

    expensespayment.sendKeys(Utility.getData().getProperty("expensePayment"));

    Select totalsaving = new Select(totalSaving);
    totalsaving.selectByIndex(1);

    continueButton1.click();

    }

}
