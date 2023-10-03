package po;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    protected WebDriver driver;
    private final By cookiesAcceptButton = By.id("rcc-confirm-button");
    private final By mainPageHomeHeader = By.cssSelector("div[class='Home_Header__iJKdX']");
    private final By primaryOrderButtonUpper =  By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private final By primaryOrderButtonFooter =  By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cookiesAcceptButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton));
        driver.findElement(cookiesAcceptButton).click();

    }
    public void primaryOrderButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(primaryOrderButtonUpper));
        driver.findElement(primaryOrderButtonUpper).click();
    }

    public void accordionItemButtonScrollTo(String accordionValue) {
        String accordionValueLocator = ".//div[.='" + accordionValue + "']";
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(accordionValueLocator))));
        WebElement element = driver.findElement(By.xpath(accordionValueLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void accordionItemButtonClick(String accordionValue) {
        String accordionValueLocator = ".//div[.='" + accordionValue + "']";
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(accordionValueLocator))));
        driver.findElement(By.xpath(accordionValueLocator)).click();
    }

    public boolean isDataAccordionTextExpandedVisible(String accordionValue) {
        String accordionValueLocator = ".//div[.='" + accordionValue + "']/parent::div/parent::div/div[@data-accordion-component='AccordionItemPanel']/p";
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(accordionValueLocator))));
        return driver.findElement(By.xpath(accordionValueLocator)).isDisplayed();
    }
    public void orderButtonUpperClick() {
        driver.findElement(primaryOrderButtonUpper).click();
    }
    public void orderButtonFooterClick() {
        driver.findElement(primaryOrderButtonFooter).click();
    }
    public boolean checkMainPageHomeHeader(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(mainPageHomeHeader));
        return driver.findElement(mainPageHomeHeader).isDisplayed();
    }

}
