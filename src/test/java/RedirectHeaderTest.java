import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import po.MainPage;
import po.OrderPage;

import static constants.MainUrl.MAIN_PAGE_URL;
import static constants.MainUrl.ORDER_BUTTON_URL;

public class RedirectHeaderTest extends BaseTest {

    @Test
    public void checkRedirectScooterButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.cookiesAcceptButtonClick();
        mainPage.orderButtonClick(ORDER_BUTTON_URL);
        orderPage.clickRedirectScooterButton();
        Assert.assertTrue(mainPage.checkMainPageHomeHeader());
    }
}
