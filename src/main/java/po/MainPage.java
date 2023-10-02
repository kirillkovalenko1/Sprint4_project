package po;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    protected WebDriver driver;
    private final By cookiesAcceptButton = By.id("rcc-confirm-button");
    private final By mainPageHomeHeader = By.cssSelector("div[class='Home_Header__iJKdX']");
    private final By yaPageHomeHeader = By.cssSelector("img[alt='Yandex']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cookiesAcceptButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton));
        driver.findElement(cookiesAcceptButton).click();

    }

    public void accordionItemButtonScrollTo(String accordionHeader) {
        String cssSelector = "div#" + accordionHeader;
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(cssSelector))));
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void accordionItemButtonClick(String accordionHeader) {
        String xpath = ".//div[@id ='" + accordionHeader + "']";
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean isDataAccordionTextExpandedVisible(String accordionHeader) {
        String xpath = ".//div[@id ='" + accordionHeader + "']/parent::div/parent::div/div[@data-accordion-component='AccordionItemPanel']/p";
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }
    public void orderButtonClick(String orderButton) {
        driver.findElement(By.xpath(orderButton)).click();
    }
    public boolean checkMainPageHomeHeader(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(mainPageHomeHeader));
        return driver.findElement(mainPageHomeHeader).isDisplayed();
    }

}
