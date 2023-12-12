package com.orangehrm.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrm.demo.customlistener.CustomListener;
import com.orangehrm.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * baseUrl :https://opensource-demo.orangehrmlive.com/
 * Page Object project with page factory with extent report, Use data provider, create runner.xml file to run test
 * Project name: orange-hrm
 * Group-Id : com.orangehrmlive.demo
 * main package.
 * create all packages and class that you created for page object model
 * In Pages package
 * 1.LoginPage - Store username, password, Login Button and LOGIN Panel text Locators
 * and create appropriate methods for it.
 */

public class LoginPage extends Utility {

    //Enter username
    @CacheLookup
   // @FindBy(xpath = "//input[@placeholder='Username']")
    @FindBy(name = "username")
    WebElement userNameField;


    //Enter password
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;


    //Click on Login Button
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    //Verify Logo is Displayed
    @CacheLookup
    //@FindBy(xpath = "//img[@alt='client brand banner']")
    @FindBy(xpath = "//div[@class='oxd-brand-banner']//img[@alt='client brand banner']")
    WebElement verifyLogoIsDisplayed;

    // Mouse hover on "Logout" and click
    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement clickOnLogout;

    //Verify the text "Login Panel" is displayed
    @CacheLookup
    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    WebElement verifyTextLoginPanel;

    //Verify Error message <errorMessage>
    @CacheLookup
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[1]")
    WebElement errorMessage;


    //------------------------------------------------------------------------------//
    public void enterUserName(String username) {
        sendTextToElement(userNameField, username);
        CustomListener.test.log(Status.PASS, "Enter UserName" + username);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListener.test.log(Status.PASS, "Enter Password" + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        CustomListener.test.log(Status.PASS, "Click On loginButton");
    }

    public void verifyLogoIsDisplayed() {
        driver.findElement((By) verifyLogoIsDisplayed).isDisplayed();

    }

    public void clickOnLogout() {
        mouseHoverToElementAndClick(clickOnLogout);
    }

    public String logInPanelText() {
        String text = getTextFromElement(verifyTextLoginPanel);
        CustomListener.test.log(Status.PASS, "Text is Display");
        return text;
    }

    public String getErrorMessage() {
        return getTextFromElement(errorMessage);
    }
}