package po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    protected WebDriver driver;
    private By cookiesAcceptButton = By.id("rcc-confirm-button");
    private By accordionItemButton = By.xpath(".//div[@data-accordion-component='AccordionItemButton']");
    private By isDataAccordionTextExpanded = By.xpath(".//div[@id='accordion__panel-0']/p");
    private By orderButtonHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private By orderButtonFinish = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

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

    public void orderButtonClick(By orderButton){
        driver.findElement(orderButton).click();
    }


}
