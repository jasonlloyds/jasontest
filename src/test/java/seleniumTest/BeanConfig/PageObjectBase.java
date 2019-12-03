package seleniumTest.BeanConfig;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//import sun.awt.windows.WBufferStrategy;


@Component
public abstract class PageObjectBase<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected Environment environment;

    //private static XSSFSheet excelWSheet;
    //private static XSSFWorkbook excelWBook;
    //private static XSSFCell cell;
    //private static XSSFRow Row;
    private static XSSFSheet excelWSheet;
    private static XSSFWorkbook excelWBook;
    private static XSSFCell cell;
    private static HSSFRow Row;

    public int totalRows = 0;
    public int totalCols = 0;
    public static String currentDateTime;


    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void entervalue(WebElement element, String value) {
        Assert.assertTrue("Element not visible on the page", element.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(value);
    }

    public void clearValue(WebElement element) {
        Assert.assertTrue("Element not visible on the page", element.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.clear();
    }

    public void scrollForElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollForElement(List<WebElement> elementList) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementList);
    }

    public void scrollForElement(String s) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(s)));
    }

    public void hoverOverElement(WebElement element) {
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(element).perform();
    }

    public void waitForAnElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAnElement(List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public void waitOnElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitOnElementClickable(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(name))));
    }

    public void waitOnElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitOnElementVisible(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(name))));
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(String getPathText) {
        try {
            String customedString = "//*[@node_name=\"BBSummaryOfDealScriptWrapper\"]//*[text()='" + getPathText + "']";
            WebElement element = driver.findElement(By.xpath(customedString));
            element.isDisplayed();
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementEnabaled(WebElement element) {
        try {
            element.isEnabled();
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent(List<WebElement> element) {
        try {
            element.isEmpty();
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCustomisedElementPresent(String customisedString) {
        try {

            WebElement element = driver.findElement(By.xpath(customisedString));
            waitForAnElement(element);
            scrollForElement(element);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getCustomizedEelement(String customisedString) throws InterruptedException {
        return driver.findElement(By.xpath(customisedString));
    }

    public List<WebElement> getCustomizedListOfElement(String customisedString) {
        return driver.findElements(By.xpath(customisedString));
    }

    public void ifElementPresentClick(WebElement element) {
        try {
            scrollForElement(element);
            element.isDisplayed();
            element.click();
        } catch (NoSuchElementException e) {
        }
    }

    public void selectValueFromDropdown(WebElement locator, String text) throws InterruptedException {
        Select dropdown = new Select(locator);
        dropdown.selectByVisibleText(text);
    }

    public void selectIndexFromDropdown(WebElement locator, int index) throws InterruptedException {
        Select dropdown = new Select(locator);
        dropdown.selectByIndex(index);
        Thread.sleep(3000);
    }

    public String getAllValuesFromDropDown(WebElement locator) {
        Select dropdown = new Select(locator);
        ArrayList<String> textList = new ArrayList<>();
        List<WebElement> list = dropdown.getOptions();
        for (WebElement element : list) {
            textList.add(element.getText());
        }
        return String.valueOf(textList);
    }

    public String getAllValuesFromList(List<WebElement> locator) {
        ArrayList<String> textList = new ArrayList<>();
        for (WebElement element : locator) {
            textList.add(element.getText());
        }
        return String.valueOf(textList);
    }

    public int getlistOfSize(WebElement locator) {
        Select dropdown = new Select(locator);
        return dropdown.getOptions().size();
    }

    public String getSelectedValueFromDropDown(WebElement locator) {
        Select dropdown = new Select(locator);
        return dropdown.getFirstSelectedOption().getText();
    }

    public Date getCurrentDate() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        return cal.getTime();
    }

    public int generateRandomIndex(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public String getSelectedTextInDropDown(WebElement locator) {
        Select dropdown = new Select(locator);
        return dropdown.getFirstSelectedOption().getText();
    }

    public String getDateFormat() {
        String DATE_FORMAT = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        currentDateTime = sdf.format(getCurrentDate());
        System.out.println(currentDateTime);
        return currentDateTime;
    }

    public void setIntegerValues(WebElement element, int enterIntegerValues) {
        element.sendKeys(String.valueOf(enterIntegerValues));
    }

    public Date addTermMonthsToCurrentDate(int getTermMonths) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, getTermMonths);
        return cal.getTime();
    }

    public void setRationale() throws InterruptedException {
        List<WebElement> linkElements = driver.findElements(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
        for (int j = 1; j <= linkElements.size(); j++) {
            //System.out.println("Value is :: " + j);
            Thread.sleep(2000);
            WebElement frame1 = driver.findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[" + j + "]"));
            driver.switchTo().frame(frame1);
            driver.findElement(By.xpath("//body[contains(@class,'cke_editable')]")).sendKeys("Automation Test Notes");
            Thread.sleep(1000);
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
            driver.switchTo().frame("PegaGadget0Ifr");
            Thread.sleep(1000);
        }
        // submitSanctionRequestButton.click();
    }


    public void setRationaleOne() throws InterruptedException {
        List<WebElement> linkElements = driver.findElements(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
        for (int j = 1; j <= linkElements.size(); j++) {
            Thread.sleep(2000);
            WebElement frame1 = driver.findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[" + j + "]"));
            driver.switchTo().frame(frame1);
            driver.findElement(By.xpath("//body[contains(@class,'cke_editable')]")).sendKeys("Automation Test Notes");
            Thread.sleep(1000);
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
            driver.switchTo().frame("PegaGadget0Ifr");
            Thread.sleep(1000);
        }
    }

    public void getCurrentURL() {
        System.out.println(driver.getCurrentUrl());
    }

    public boolean getExpectedTextFromListOfElements(String getExpectedValue, List<WebElement> elementList) {
        boolean valuesExists = false;
        waitForAnElement(elementList);
        for (WebElement element : elementList) {
            System.out.println("Print the label name :: " + element.getText().replaceAll("[:]+", ""));
            if (element.getText().replaceAll("[:]+", "").equalsIgnoreCase(getExpectedValue)) {
                valuesExists = true;
                break;
            }
        }
        return valuesExists;
    }

    public boolean getExpectedValueFromListOfElements(String getExpectedValue, List<WebElement> elementList) {
        int i = 0;
        boolean valuesExists = false;
        waitForAnElement(elementList);
        for (WebElement element : elementList) {
            if (elementList.get(i).getText().trim().replaceAll("[£,%]+", "").equals(getExpectedValue)) {
                valuesExists = true;
                break;
            }
            i++;
        }
        return valuesExists;
    }


    public boolean checkValuesExistsFromListOfElements(List<WebElement> elementList) {
        boolean valuesExists = true;
        waitForAnElement(elementList);
        for (WebElement element : elementList) {
            if (element.getText().isEmpty()) {
                valuesExists = false;
                break;
            }
        }
        return valuesExists;
    }

    public boolean checkAscendingOrder(List<WebElement> elementList) throws ParseException {
        waitForAnElement(elementList);
        Iterator<WebElement> iter = elementList.iterator();
        // The size and count integers are intended to limit the iterator and just do the date row only
        int size = elementList.size();
        return checkOrdering(iter, size, "Ascend");
    }

    public void clickOnListOfWebElements(Iterator<WebElement> iter, WebElement element) throws InterruptedException {
        Thread.sleep(3000);
        int elementNum = 1;
        while (iter.hasNext()) {
            element.click();
        }
        elementNum++;
    }

    private boolean checkOrdering(Iterator<WebElement> iter, int tableSize, String direction) throws ParseException {
        DateFormat f = new SimpleDateFormat("MMM yyyy");
        Date refDate = null;
        Date currDate = null;
        String str1, str2 = "";
        boolean isOrderCorrect = true;  // order is assumed to be Acsending and set to false if otherwise
        boolean tempDateCheck = false;
        int elementCount = 1;
        while (iter.hasNext()) {
            if (elementCount == (tableSize / 2)) {
                break;
            }
            // initial run through the loop, which sets up the reference date refDate
            if (refDate == null) {
                str1 = iter.next().getText();
                refDate = f.parse(str1);
            }
            str2 = iter.next().getText();
            currDate = f.parse(str2);
            // checks that the reference date is less than the current date, hence traverses the failure path
            switch (direction) {
                case "Ascend":
                    tempDateCheck = refDate.after(currDate);
                    break;
                case "Decend":
                    tempDateCheck = refDate.before(currDate);
                    break;

            }
            if (tempDateCheck) {
                isOrderCorrect = false;
                break;
            } else {
                refDate = f.parse(str2);
                ;
            }
            elementCount++;
        }
        return isOrderCorrect;

    }

    public int getCountList(List<WebElement> elementList) {
        return elementList.size();
    }

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
    public void setExcelFile(String Path, String SheetName) throws Exception {
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            // Access the required test data sheet
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(SheetName);
        } catch (Exception e) {
            throw (e);
        }
    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = cell.getStringCellValue();
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }

    public Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(SheetName);
            int startCol = 0;
            int ci = 0, cj = 0;
            totalRows = excelWSheet.getLastRowNum();
            //System.out.println("Rows :" +totalRows);
            totalCols = excelWSheet.getRow(totalRows).getLastCellNum();
            //System.out.println("Cols :" +totalCols);
            tabArray = new String[totalRows][totalCols];
            for (int i = 0; i < totalRows; i++) {
                for (int j = startCol; j < totalCols; j++) {
                    tabArray[i][j] = getCellData(i, j);
                    //System.out.println(tabArray[ci][cj]);

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }

    public static HashMap<String, ArrayList> getDataFromExcel(String FilePath, String SheetName) throws Exception {
        HashMap<String, ArrayList> hashMap = new HashMap<>();
        FileInputStream ExcelFile = new FileInputStream(FilePath);
        // Access the required test data sheet
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(SheetName);
        int totalRows = excelWSheet.getLastRowNum();
        int totalCols = excelWSheet.getRow(totalRows).getLastCellNum();
        FormulaEvaluator formulaEvaluator = excelWBook.getCreationHelper().createFormulaEvaluator();
        for (int row = 0; row <= totalRows; row++) {
            ArrayList recordData = new ArrayList();
            for (int col = 0; col < totalCols; col++) {
                cell = excelWSheet.getRow(row).getCell(col);
                recordData.add(cell.getStringCellValue().trim());
            }
            hashMap.put(String.format("%d", row), recordData);
        }
        return hashMap;
    }

    public static HashMap<String, ArrayList> getDataFromAnyExcel(String FilePath, String SheetName) throws Exception {
        HashMap<String, ArrayList> hashMap = new HashMap<>();
        FileInputStream ExcelFile = new FileInputStream(FilePath);
        // Access the required test data sheet
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(SheetName);
        int totalRows = excelWSheet.getLastRowNum();
        int totalCols = excelWSheet.getRow(totalRows).getLastCellNum();
        FormulaEvaluator formulaEvaluator = excelWBook.getCreationHelper().createFormulaEvaluator();
        for (int row = 0; row < totalRows; row++) {
            ArrayList recordData = new ArrayList();
            for (int col = 0; col < totalCols; col++) {
                cell = excelWSheet.getRow(row).getCell(col);
                switch (formulaEvaluator.evaluateInCell(cell).getCellTypeEnum()) {
                    case STRING:
                        recordData.add(cell.getStringCellValue().trim());
                        break;
                    case NUMERIC:
                        recordData.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                        break;
                    default:
                        ;
                }
            }
            hashMap.put(String.format("%d", row), recordData);
        }
        return hashMap;
    }

    private Map<?, ?> jsonFileToMapStrings(String fileName, String fields) {
        return jsonFileToMapStrings(fileName, fields, "Lloyds");
    }

    private Map<?, ?> jsonFileToMapStrings(String fileName, String fields, String brand) {
        String cwd = System.getProperty("user.dir");
        //System.out.println(cwd);
        String filePath = new File(cwd + "/src/test/resources/com/pega/selenium/features/JSONTestData/" + fileName).getAbsolutePath();
        //String filePath = new File("C:\\Users\\8405842\\IdeaProjects\\testing-pega-ui-bb\\src\\test\\resources\\com\\pega\\selenium\\features\\JSONTestData\\" + fileName).getAbsolutePath();
        //System.out.println(filePath);
        Map<String, String> data = new HashMap<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            //JSONArray jsonObject = (JSONArray) obj;
            JSONObject pageFields = (JSONObject) jsonObject.get(fields);
            JSONObject brandFields = (JSONObject) pageFields.get(brand);
            Iterator iterator = brandFields.keySet().iterator();
            while (iterator.hasNext()) {
                Object field = iterator.next();
                String key = field.toString();
                String value = brandFields.get(key).toString();
                data.put(key, value);
            }
        } catch (org.json.simple.parser.ParseException | IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<?, ?> getTestDataValues(String secType, String dataSet) {
        return getTestDataValues(secType, dataSet, "Lloyds");
    }

    public Map<?, ?> getTestDataValues(String secType, String dataSet, String brand) {
        String fileName = secType + "SecurityDetails.json";
        return jsonFileToMapStrings(fileName, dataSet, brand);
        /*Map<String, String> dataValues = null;
        dataValues = jsonFileToMapStrings(fileName, dataSet);
        return dataValues;*/
    }


    public String getTextOrderList(List<WebElement> elementList) {
        ArrayList<String> list = new ArrayList<>();
        for (WebElement element : elementList) {
            list.add(element.getText());
        }
        return String.valueOf(list);
    }

    public void typeTextInCommentArea(WebElement enteriFrame, WebElement typeTextElement, String getTextToType) {
        waitForAnElement(enteriFrame);
        scrollForElement(enteriFrame);
        driver.switchTo().frame(enteriFrame);
        typeTextElement.clear();
        typeTextElement.sendKeys(getTextToType);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("PegaGadget0Ifr");
    }

    public void typeTextInCommentArea(String enteriFrameStr, WebElement typeTextElement, String getTextToType) throws InterruptedException{
        WebElement enteriFrame= getCustomizedEelement(enteriFrameStr);
        waitForAnElement(enteriFrame);
        scrollForElement(enteriFrame);
        driver.switchTo().frame(enteriFrame);
        typeTextElement.clear();
        typeTextElement.sendKeys(getTextToType);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("PegaGadget0Ifr");
    }

    public String getTextInCommentArea(WebElement enteriFrame, WebElement commentTextElement) {
        waitForAnElement(enteriFrame);
        scrollForElement(enteriFrame);
        driver.switchTo().frame(enteriFrame);
        String getText = commentTextElement.getText();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("PegaGadget0Ifr");
        return getText;
    }

    public void waitForCustomizedElement(String getCustomLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(getCustomLocator))));
    }

    public String simpleDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String strDate = sdf.format(date);
        System.out.println("formatted date in mm/dd/yy : " + strDate);
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        strDate = sdf.format(date);
        return strDate;
    }

    public String getSystemDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }

    public String getTodaysDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }

    public String addMonth(int numberOfMonths) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.MONTH, numberOfMonths);
        Date currentDatePlusOne = c.getTime();
        return dateFormat.format(currentDatePlusOne);
    }

    public void customedElementSelection(String pathtoCutomer) throws InterruptedException {
        Thread.sleep(2000);
        scrollForElement(pathtoCutomer);
        WebElement element = driver.findElement(By.xpath(pathtoCutomer));
        if (!element.isSelected()) {
            element.click();
        }
        Thread.sleep(2000);
    }

    public void customedElementEnterKeys(String pathtoCutomer, String enterKeyValue) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(pathtoCutomer));
        element.clear();
        element.sendKeys(enterKeyValue);
        element.sendKeys(Keys.TAB);
        Thread.sleep(2000);
    }

    public String getAttributeValue(String pathToCustome) {
        WebElement element = driver.findElement(By.xpath(pathToCustome));
        return element.getAttribute("value");
    }

    public String getAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public String customedElementGetAttribut(String pathtoCutomer, String attributeName) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(pathtoCutomer));
        getWaitAndScrollElement(element);
        return element.getAttribute(attributeName);
    }

    public String customedElementGetText(String pathtoCutomer) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(pathtoCutomer));
        getWaitAndScrollElement(element);
        return element.getText();
    }

    public void customedElementClick(String pathtoCutomer) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(pathtoCutomer));
        getWaitAndScrollElement(element);
        element.click();
        Thread.sleep(2000);
    }

    public void customedElementJSClick(String pathToCustomer) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(pathToCustomer));
        getWaitAndScrollElement(element);
        clickElement(element);
        Thread.sleep(2000);
    }


    public void clearTextInCommentArea(WebElement enteriFrame, WebElement typeTextElement) {
        waitForAnElement(enteriFrame);
        scrollForElement(enteriFrame);
        driver.switchTo().frame(enteriFrame);
        typeTextElement.clear();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("PegaGadget0Ifr");
    }

    public void setAttributeValueBlank(WebElement elem) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', '')", elem);
    }

    public WebElement getWaitAndScrollElement(WebElement element) throws InterruptedException {
        Thread.sleep(2000);
        scrollForElement(element);
        return element;
    }

    public int getDoubleAmt(String getChargeCardAmt) {
        return (2 * Integer.parseInt(getChargeCardAmt));
    }

    public WebElement stateElementHandlerClick(WebElement element) {
        return new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getExpectedText(String enterTextName) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/rewording.properties"));
        return properties.getProperty(enterTextName);
    }

    public void selectRadioButton(WebElement element) throws InterruptedException {
        scrollForElement(element);
        if (!element.isSelected()) {
            clickElement(element);
            Thread.sleep(2000);
        }
    }

    public boolean checkBlankValueinListOfElements(List<WebElement> elementList) {
        boolean valueBlank = false;
        waitForAnElement(elementList);
        breakLoop:
        for (WebElement element : elementList) {
            if (element.getText().isEmpty()) {
                valueBlank = true;
            } else {
                break breakLoop;
            }
        }
        return valueBlank;
    }

    public String calculateYearAndMonth(int termMonths) {
        int getYear = termMonths / 12;
        int getMonth = termMonths % 12;
        return "Fixed Rate - Defined Break Cost - " + String.valueOf(getYear).concat("y ") + String.valueOf(getMonth).concat("m");
    }

    public WebElement retryingFindClick(By by) {
        WebElement result = null;
        int attempts = 0;
        while (attempts < 2) {
            try {
                driver.findElement(by).click();
                return result;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }


    public void validatePrePopulatedFields(String secType) throws InterruptedException {
    }

    public void validateMandatoryFields(String secType) throws InterruptedException {
    }

    public void instructSecurityFields(String secType) throws InterruptedException {
    }

    public String getDropDownListNames(WebElement element) {
        ArrayList<String> list = new ArrayList<>();
        Select select = new Select(element);
        List<WebElement> allOptions = select.getOptions();
        int i = 0;
        for (WebElement elements : allOptions) {
            String dropDownNamesList = elements.getText();
            list.add(dropDownNamesList);
        }
        return String.valueOf(list);
    }

}
