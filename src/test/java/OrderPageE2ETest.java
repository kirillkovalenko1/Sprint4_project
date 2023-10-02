import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import po.MainPage;
import po.OrderPage;

import static constants.MainUrl.MAIN_PAGE_URL;

@RunWith(Parameterized.class)
public class OrderPageE2ETest extends BaseTest {
    private final String orderButton;
    private final String expected;

    public OrderPageE2ETest(String orderButton, String expected) {
        this.orderButton = orderButton;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionHeader() {
        return new Object[][]{
                {".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']", "Заказ оформлен"},
                {".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']", "Заказ оформлен"},
        };
    }

    @Test
    public void checkCompleteOrderScenario() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.cookiesAcceptButtonClick();
        mainPage.orderButtonClick(orderButton);
        orderPage.fillFirstNameForOrder();
        orderPage.fillLastNameForOrder();
        orderPage.fillAddressForOrder();
        orderPage.fillMetroStationForOrder();
        orderPage.fillPhoneNumberForOrder();
        orderPage.middleNextButtonClick();
        orderPage.fillDatePickerForOrder();
        orderPage.checkRentalPeriodDropDown();
        orderPage.colorCheckboxClick();
        orderPage.confirmationButtonClick();
        Assert.assertEquals(expected, orderPage.finalOrderPageIsDisplayed());
    }
}
