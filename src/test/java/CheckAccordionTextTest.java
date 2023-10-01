import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import po.MainPage;
import static constants.MainUrl.MAIN_PAGE_URL;

@RunWith(Parameterized.class)
public class CheckAccordionTextTest extends BaseTest {
    private final String accordionHeader;
    private final boolean expected;

    public CheckAccordionTextTest(String accordionHeader, boolean expected) {
        this.accordionHeader = accordionHeader;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionHeader() {
        return new Object[][] {
                { "accordion__heading-0",true},
                { "accordion__heading-1",true},
                { "accordion__heading-2",true},
                { "accordion__heading-3",true},
                { "accordion__heading-4",true},
                { "accordion__heading-5",true},
                { "accordion__heading-6",true},
                { "accordion__heading-7",true},
        };
    }
    @Test
    public void checkAccordionTextDisplayedTest(){
        MainPage mainPage = new MainPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.cookiesAcceptButtonClick();
        mainPage.accordionItemButtonScrollTo(accordionHeader);
        mainPage.accordionItemButtonClick(accordionHeader);
        Assert.assertEquals(expected,mainPage.isDataAccordionTextExpandedVisible(accordionHeader));
    }
}
