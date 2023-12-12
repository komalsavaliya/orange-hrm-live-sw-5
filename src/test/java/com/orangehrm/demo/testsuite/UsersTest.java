package com.orangehrm.demo.testsuite;

import com.orangehrm.demo.customlistener.CustomListener;
import com.orangehrm.demo.pages.*;
import com.orangehrm.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * test package.
 * create all packages and class that you created for page object model
 * In Testsuite package
 * create classes
 * 1.UsersTest
 * Inside UsersTest class create following testmethods
 * 1.adminShouldAddUserSuccessFully().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * click On "Add" button
 * Verify "Add User" Text
 * Select User Role "Admin"
 * enter Employee Name "Ananya Dash"
 * enter Username
 * Select status "Disable"
 * enter psaaword
 * enter Confirm Password
 * click On "Save" Button
 * verify message "Successfully Saved"
 * 2. searchTheUserCreatedAndVerifyIt().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * Enter Username
 * Select User Role
 * Select Satatus
 * Click on "Search" Button
 * Verify the User should be in Result list.
 * 3. verifyThatAdminShouldDeleteTheUserSuccessFully().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * Enter Username
 * Select User Role
 * Select Satatus
 * Click on "Search" Button
 * Verify the User should be in Result list.
 * Click on Check box
 * Click on Delete Button
 * Popup will display
 * Click on Ok Button on Popup
 * verify message "Successfully Deleted"
 * 4. searchTheUserAndVerifyTheMessageRecordFound().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * Enter Username <username>
 * Select User Role <userRole>
 * Enter EmployeeName <employeeName>
 * Select Satatus <status>
 * Click on "Search" Button verify message "(1) Record Found"
 * Verify username <username>
 * Click on Reset Tab
 * Data Set
 * username        * userrole         * employeeName       * Status
 * Admin           * Admin            * Paul Collings      * Enable
 * Cassidy.Hope    * ESS              * Cassidy Hope       * Enable
 * Nina.Patel      * ESS              * Nina Patel         * Enable
 * Odis.Adalwin    * Admin            * Odis Adalwin       * Enable
 */
@Listeners(CustomListener.class)
public class UsersTest extends BaseTest {
    AddUserPage addUserPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUserPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUserPage = new ViewSystemUsersPage();
    }

    @Test(groups = {"Sanity", "Smoke", "Regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        //Login To The application
        //Enter username
        loginPage.enterUserName("Admin");

        //Enter password
        loginPage.enterPassword("admin123");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        adminPage.clickOnAdmin();

        //Verify "System Users" Text
        String actualText = viewSystemUserPage.verifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");

        //click On "Add" button
        viewSystemUserPage.clickOnAddButton();

        //Verify "Add User" Text
        String actualMessage = addUserPage.verifyAddUserText();
        String expectedMessage = "Add User";
        Assert.assertEquals(actualMessage, expectedMessage, "Add User is not displayed");

        //Select User Role "Admin"
        addUserPage.clickOnDropDownList();
        Thread.sleep(3000);
        addUserPage.selectUserRoleFromDropDownList("Admin");
        Thread.sleep(3000);

        //enter Employee Name "Ananya Dash"
        addUserPage.enterEmployeeName("Ananya Dash");

        //enter Username
        viewSystemUserPage.enterUserName("Admin");

       //Select status "Disable"
        addUserPage.clickOnDropDownList();
        addUserPage.selectStatusFromDropDownList("Disable");

        //Enter password
        addUserPage.enterPassword1("admin123");

        //Enter Confirm Password
        addUserPage.enterConfirmPassword("admin123");

        //Click On "Save" Button
        addUserPage.clickOnSaveButton();
        Thread.sleep(5000);

        // verify message "Successfully Saved"


    }

    @Test(groups = {"Smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        //Login To The application
        //Enter username
        loginPage.enterUserName("Admin");

        //Enter password
        loginPage.enterPassword("admin123");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        adminPage.clickOnAdmin();

        //Verify "System Users" Text
        String actualText = viewSystemUserPage.verifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");
        Thread.sleep(3000);

        //enter Username
        viewSystemUserPage.enterUserName("Ananya Dash");
        Thread.sleep(5000);

        //Select User Role "Admin"
        addUserPage.clickOnDropDownList();
        Thread.sleep(3000);
        addUserPage.selectUserRoleFromDropDownList("Admin");
        Thread.sleep(3000);

        //addUserPage.selectAdmin();
        Thread.sleep(3000);

        //Select status "Disable"
        addUserPage.clickOnDropDownList();
        addUserPage.selectStatusFromDropDownList("Disable");


        //Click on "Search" Button
        viewSystemUserPage.clickOnSearchButton();
        Thread.sleep(3000);

        //Verify the User should be in Result list.
        String actualResult = viewSystemUserPage.verifyTheUserShouldBeINList();
        String expectedResult = "Ananya Dash";
        Assert.assertEquals(actualResult, expectedResult, "Ananya Dash is not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {

        //Login To The application
        //Enter username
        loginPage.enterUserName("Admin");

        //Enter password
        loginPage.enterPassword("admin123");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        adminPage.clickOnAdmin();

        //Verify "System Users" Text
        String actualText = viewSystemUserPage.verifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");
        Thread.sleep(3000);

        //enter Username
        viewSystemUserPage.enterUserName("Ananya Dash");
        Thread.sleep(5000);

        //Select User Role "Admin"
        addUserPage.clickOnDropDownList();
        Thread.sleep(3000);
        addUserPage.selectUserRoleFromDropDownList("Admin");
        Thread.sleep(3000);

        //Select status "Disable"
        addUserPage.clickOnDropDownList();
        addUserPage.selectStatusFromDropDownList("Disable");

        //Click on "Search" Button
        viewSystemUserPage.clickOnSearchButton();
        Thread.sleep(3000);

        //Verify the User should be in Result list.
        String actualResult = viewSystemUserPage.verifyTheUserShouldBeINList();
        String expectedResult = "Ananya Dash";
        Assert.assertEquals(actualResult, expectedResult, "Ananya Dash is not displayed");

        //Click on Check box
        viewSystemUserPage.clickOnCheckBox();

        //Click on Delete Button
        viewSystemUserPage.clickOnDeleteButton();

        //Popup will display
        viewSystemUserPage.notifyAll();

        //Click on Ok Button on Popup
        viewSystemUserPage.acceptAlert();

        //verify message "Successfully Deleted"
        String actualMessage = viewSystemUserPage.getTextFromAlert();
        String expectedMessage = "Successfully Deleted";
        Assert.assertEquals(actualMessage, expectedMessage, "Successfully Deleted message is not displayed");
    }

    @Test(groups = {"regression"}, dataProvider = "Data Set", dataProviderClass = TestData.class)
    public void searchTheUserAndVerifyTheMessageRecordFound() throws InterruptedException {
        //Login To The application
        //Enter username
        loginPage.enterUserName("Admin");

        //Enter password
        loginPage.enterPassword("admin123");

        //Click on Login Button
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        adminPage.clickOnAdmin();

        //Verify "System Users" Text
        String actualText = viewSystemUserPage.verifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");
        Thread.sleep(3000);

        //enter Username
        viewSystemUserPage.enterUserName("Ananya Dash");
        Thread.sleep(5000);

       //Select User Role "Admin"
        addUserPage.clickOnDropDownList();
        Thread.sleep(3000);
        addUserPage.selectUserRoleFromDropDownList("Admin");
        Thread.sleep(3000);

        //enter Employee Name "Ananya Dash"
        addUserPage.enterEmployeeName("Ananya Dash");

        //Select status "Disable"
        addUserPage.clickOnDropDownList();
        addUserPage.selectStatusFromDropDownList("Disable");


        //Click on "Search" Button
        viewSystemUserPage.clickOnSearchButton();
        Thread.sleep(3000);

        //verify message "(1) Record Found"
        viewSystemUserPage.verifyNoRecordFoundMessage("No Records Found");


        //Verify username <username>
        viewSystemUserPage.verifyUsernameLabel("Username");

        // Click on Reset Tab
        viewSystemUserPage.clickOnReSetButton();
    }
}






