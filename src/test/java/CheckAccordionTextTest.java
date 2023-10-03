import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import po.MainPage;
import static constants.MainUrl.MAIN_PAGE_URL;

@RunWith(Parameterized.class)
public class CheckAccordionTextTest extends BaseTest {
    private final String accordionValue;
    private final boolean expected;

    public CheckAccordionTextTest(String accordionHeader, boolean expected) {
        this.accordionValue = accordionHeader;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionHeader() {
        return new Object[][] {
                { "Сколько это стоит? И как оплатить?",true},
                { "Хочу сразу несколько самокатов! Так можно?",true},
                { "Как рассчитывается время аренды?",true},
                { "Можно ли заказать самокат прямо на сегодня?",true},
                { "Можно ли продлить заказ или вернуть самокат раньше?",true},
                { "Вы привозите зарядку вместе с самокатом?",true},
                { "Можно ли отменить заказ?",true},
                { "Я жизу за МКАДом, привезёте?",true},
        };
    }
    @Test
    public void checkAccordionTextDisplayedTest(){
        MainPage mainPage = new MainPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.cookiesAcceptButtonClick();
        mainPage.accordionItemButtonScrollTo(accordionValue);
        mainPage.accordionItemButtonClick(accordionValue);
        Assert.assertEquals(expected,mainPage.isDataAccordionTextExpandedVisible(accordionValue));
    }
}
