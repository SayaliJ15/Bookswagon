import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class LoginTest extends WebTestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void beforeMethod(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Test
    public void verifyLoginWithValidCredential(){
        SoftAssert softAssert = new SoftAssert();
        homePage.userSearchClick();
        loginPage.login(prop.getProperty("mobile"), prop.getProperty("password"));
        softAssert.assertEquals(myAccountPage.getTextOFMYAccountPage(), "My Account", "My Account text should be match");
        softAssert.assertAll();
    }

    @Test
    public void verifySearchBar(){
        SoftAssert softAssert = new SoftAssert();
        myAccountPage.search();
        softAssert.assertEquals(myAccountPage.getTextOfSearch(), "Showing results for \"the power of your subconscious mind\"\n" +
                "244 results found","Showing results for \"the power of your subconscious mind\"\n" +
                "244 results found text should be match");
        myAccountPage.selectDropDown("byVisibleText", "Best Seller");
        softAssert.assertAll();
    }


    @Test
    public void verifyMouseHover(){
        SoftAssert softAssert = new SoftAssert();
        myAccountPage.mouseHover();
        softAssert.assertAll();
    }

    @Test
    public void verifyScrollDown(){
        SoftAssert softAssert = new SoftAssert();
        myAccountPage.scrollDownMethod();
        softAssert.assertAll();
    }

    @Test
    public void verifyGetWindowHandle(){
        SoftAssert softAssert = new SoftAssert();
        myAccountPage.windowHandle();
        softAssert.assertAll();
    }

    @Test
    public void verifyCookiesHandle(){
        SoftAssert softAssert = new SoftAssert();
        myAccountPage.getCookiesHandle();
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }


}
