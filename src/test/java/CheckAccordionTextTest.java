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
                { "accordion__heading-8",true},
                { "accordion__heading-9",true},
                { "accordion__heading-10",true},
                { "accordion__heading-11",true},
                { "accordion__heading-12",true},
                { "accordion__heading-13",true},
                { "accordion__heading-14",true},
                { "accordion__heading-15",true},
                { "accordion__heading-16",false},
        };
    }
    @Test
    public void checkAccordionTextDisplayedTest(){
        MainPage mainPage = new MainPage(driver);
        driver.get(MAIN_PAGE_URL);
        mainPage.cookiesAcceptButtonClick();
        mainPage.accordionItemButtonScrollTo(accordionHeader);
        //mainPage.accordionItemButtonClick(accordionHeader);
        //Assert.assertEquals(mainPage.isDataAccordionTextExpandedVisible(accordionHeader),expected);
    }
}
