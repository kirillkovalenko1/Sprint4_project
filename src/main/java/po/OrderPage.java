package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    protected WebDriver driver;
    private final By firstNameForOrder = By.cssSelector("input[placeholder='* Имя']");
    private final By lastNameForOrder = By.cssSelector("input[placeholder='* Фамилия']");
    private final By addressForOrder = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationForOrder = By.cssSelector("input[placeholder='* Станция метро']");
    private final By phoneNumberForOrder = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private final By middleNextButton = By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By datePickerForOrder = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    private final By rentalPeriodDropDown = By.cssSelector("div[class='Dropdown-placeholder']");
    private final By rentalPeriodDropDownPicker = By.cssSelector("div[class='Dropdown-option']");
    private final By colorCheckbox = By.cssSelector("label[for='black']");
    private final By confirmationButton = By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By finalOrderPage = By.cssSelector("div[class='Order_ModalHeader__3FDaJ']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstNameForOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(firstNameForOrder));
        driver.findElement(firstNameForOrder).sendKeys("ТестовоеИмя");
    }

    public void fillLastNameForOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(lastNameForOrder));
        driver.findElement(lastNameForOrder).sendKeys("ТестоваяФамилия");
    }

    public void fillAddressForOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(addressForOrder));
        driver.findElement(addressForOrder).sendKeys("Тестовый адрес 1 кв.1");
    }

    public void fillMetroStationForOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(metroStationForOrder));
        driver.findElement(metroStationForOrder).click();
        driver.findElement(metroStationForOrder).sendKeys(Keys.DOWN);
        driver.findElement(metroStationForOrder).sendKeys(Keys.RETURN);
    }

    public void fillPhoneNumberForOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(phoneNumberForOrder));
        driver.findElement(phoneNumberForOrder).sendKeys("8999111999111");
    }

    public void middleNextButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(middleNextButton));
        driver.findElement(middleNextButton).click();
    }

    public void fillDatePickerForOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(datePickerForOrder));
        driver.findElement(datePickerForOrder).sendKeys("22.12.2022");
        driver.findElement(datePickerForOrder).sendKeys(Keys.RETURN);
    }

    public void checkRentalPeriodDropDown() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(rentalPeriodDropDown));
        driver.findElement(rentalPeriodDropDown).click();
        driver.findElement(rentalPeriodDropDownPicker).click();
    }

    public void colorCheckboxClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(colorCheckbox));
        driver.findElement(colorCheckbox).click();
    }

    public void confirmationButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(confirmationButton));
        driver.findElement(confirmationButton).click();
    }

    public String finalOrderPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(finalOrderPage));
        return driver.findElement(finalOrderPage).getAttribute("value");
    }
}
