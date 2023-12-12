package com.orangehrm.demo.testsuite;

import com.orangehrm.demo.customlistener.CustomListener;
import com.orangehrm.demo.pages.DashboardPage;
import com.orangehrm.demo.pages.HomePage;
import com.orangehrm.demo.pages.LoginPage;
import com.orangehrm.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 *2. LoginTest
 * Inside LoginTest class create following testmethods
 * 1. verifyUserShouldLoginSuccessFully()
 * Enter username
 * Enter password
 * Click on Login Button
 * Verify "WelCome" Message
 * 2. verifyThatTheLogoDisplayOnHomePage()
 * Login To The application
 * Verify Logo is Displayed
 * 3. verifyUserShouldLogOutSuccessFully()
 * Login To The application
 * Click on User Profile logo
 * Mouse hover on "Logout" and click
 * Verify the text "Login Panel" is displayed
 * 4. verifyErrorMessageWithInvalidCredentials()
 * Enter username <username>
 * Enter password <password>
 * Click on Login Button
 * Verify Error message <errorMessage>

 * Test Data:
 * username             * password         * errorMessage
                                           * Required
 * test123@gmail.com                       * Required
                         * test123         * Required
 * test123@gmail.com     * test123         * Invalid credentials
 */

@Listeners(CustomListener.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {
        //Enter username
        loginPage.enterUserName("Admin");

        //Enter password
        loginPage.enterPassword("admin123");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Verify "Dashboard" Message
        String expectedMessage = "Dashboard";
        String actualMessage = dashboardPage.verifyDashboardMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Message Displayed");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() throws InterruptedException {
        //Login To The application

        //Enter username
        loginPage.enterUserName("Admin");

        //Enter password
        loginPage.enterPassword("admin123");

        //Click on Login Button
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);

        //Verify Logo is Displayed
        loginPage.verifyLogoIsDisplayed();

    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() throws InterruptedException {
        //Login To The application
        //Enter username
        loginPage.enterUserName("Admin");

        //Enter password
        loginPage.enterPassword("admin123");

        //Click on Login Button
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);

        //Click on User Profile logo
        dashboardPage.clickOnUserProfileLogo();

        //Mouse hover on "Logout" and click
        loginPage.clickOnLogout();

        //Verify the text "Login Panel" is displayed
        String expectedText = "Login";
        String actualText = loginPage.logInPanelText();
        Assert.assertEquals(actualText, expectedText, "Text is Display");
    }

    @Test(groups = {"regression"}, dataProvider = "Credentials", dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String Username, String Password, String message){
        //Enter username
        loginPage.enterUserName(Username);

        //Enter password
        loginPage.enterPassword(Password);

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //Verify Error message <errorMessage>
        // * Verify Error message <errorMessage>
        String expected = message;
        String actual = loginPage.getErrorMessage();
        Assert.assertEquals(actual, expected, "Invalid Input");
    }


    }





