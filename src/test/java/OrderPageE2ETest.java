import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import po.MainPage;
import po.OrderPage;

import static constants.MainUrl.MAIN_PAGE_URL;

@RunWith(Parameterized.class)
public class OrderPageE2ETest extends BaseTest {
    private final String firstNameForOrderValue;
    private final String lastNameForOrderValue;
    private final String addressForOrderValue;
    private final String phoneNumberForOrderValue;
    private final String datePickerForOrderValue;
    private final String expected;

    public OrderPageE2ETest(String firstNameForOrderValue, String lastNameForOrderValue, String addressForOrderValue, String phoneNumberForOrderValue, String datePickerForOrderValue, String expected) {
        this.firstNameForOrderValue = firstNameForOrderValue;
        this.lastNameForOrderValue = lastNameForOrderValue;
        this.addressForOrderValue = addressForOrderValue;
        this.phoneNumberForOrderValue = phoneNumberForOrderValue;
        this.datePickerForOrderValue = datePickerForOrderValue;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionHeader() {
        return new Object[][]{
                {"ПервоеТестоеИмя", "ПерваяТестоваяФамилия", "Тестовый адрес 1, 1", "+79991119991","22.12.2023", "Заказ оформлен"},
                {"ВтороеТестоеИмя", "ВтораяТестоваяФамилия", "Тестовый адрес 2, 2", "+79991119992","23.12.2023", "Заказ оформлен"},
        };
    }

    @Test
    //Upper button
    public void checkCompleteOrderScenarioUpperButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.cookiesAcceptButtonClick();
        mainPage.orderButtonUpperClick();
        orderPage.fillFirstNameForOrder(firstNameForOrderValue);
        orderPage.fillLastNameForOrder(lastNameForOrderValue);
        orderPage.fillAddressForOrder(addressForOrderValue);
        orderPage.fillMetroStationForOrder();
        orderPage.fillPhoneNumberForOrder(phoneNumberForOrderValue);
        orderPage.middleNextButtonClick();
        orderPage.fillDatePickerForOrder(datePickerForOrderValue);
        orderPage.checkRentalPeriodDropDown();
        orderPage.colorCheckboxClick();
        orderPage.confirmationButtonClick();
        Assert.assertEquals(expected, orderPage.finalOrderPageIsDisplayed());
    }
    @Test
    //Footer button
    public void checkCompleteOrderScenarioFooterButton(){
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.cookiesAcceptButtonClick();
        mainPage.orderButtonFooterClick();
        orderPage.fillFirstNameForOrder(firstNameForOrderValue);
        orderPage.fillLastNameForOrder(lastNameForOrderValue);
        orderPage.fillAddressForOrder(addressForOrderValue);
        orderPage.fillMetroStationForOrder();
        orderPage.fillPhoneNumberForOrder(phoneNumberForOrderValue);
        orderPage.middleNextButtonClick();
        orderPage.fillDatePickerForOrder(datePickerForOrderValue);
        orderPage.checkRentalPeriodDropDown();
        orderPage.colorCheckboxClick();
        orderPage.confirmationButtonClick();
        Assert.assertEquals(expected, orderPage.finalOrderPageIsDisplayed());
    }
}
