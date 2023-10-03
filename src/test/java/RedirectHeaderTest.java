import org.junit.Assert;
import org.junit.Test;
import po.MainPage;
import po.OrderPage;

import static constants.MainUrl.MAIN_PAGE_URL;

public class RedirectHeaderTest extends BaseTest {

    @Test
    public void checkRedirectScooterButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.cookiesAcceptButtonClick();
        mainPage.primaryOrderButtonClick();
        orderPage.clickRedirectScooterButton();
        Assert.assertTrue(mainPage.checkMainPageHomeHeader());
    }
}
