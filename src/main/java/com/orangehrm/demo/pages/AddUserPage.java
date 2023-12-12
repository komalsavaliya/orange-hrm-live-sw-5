package com.orangehrm.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrm.demo.customlistener.CustomListener;
import com.orangehrm.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 5.ViewSystemUsersPage - System Users Text, Username Field, User Roll dropDown, Employee Name Field,
 * Status Drop Down, Search Button, Reset Button, Add Button and Delete Button locators and it's actions
 */

public class AddUserPage extends Utility {
    //Verify "Add User" Text
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement verifyAddUserText;

    //Select User Role "Admin"
    @CacheLookup
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]")
    WebElement selectDropDown;
    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(),'Admin')])[1]")
    WebElement userRole;

    //enter Employee Name "Ananya Dash"
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement enterEmployeeName;

    //Select status "Disable"
    // @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Disabled']")
    WebElement disabledStatus;

    //Enter Password
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement enterPassword1;

    //Enter Confirm Password
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement enterConfirmPassword;

    //click On "Save" Button
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement clickOnSaveButton;


    //------------------------------------------------------------------------------------------//
    public String verifyAddUserText() {
        return getTextFromElement(verifyAddUserText);
    }

    public void clickOnDropDownList() {
        clickOnElement(selectDropDown);
    }

   public void selectUserRoleFromDropDownList(String option) {
        dynamicListDropDown(userRole, option);
        CustomListener.test.log(Status.SKIP, "There is a bug");
    }
    public void enterEmployeeName(String name) {
        sendTextToElement(enterEmployeeName, name);
    }

    public void selectStatusFromDropDownList(String option) {
        dynamicListDropDown(disabledStatus, option);
    }

    public void enterPassword1(String password) {
        sendTextToElement(enterPassword1, password);
    }

    public void enterConfirmPassword(String password) {
        sendTextToElement(enterConfirmPassword, password);
    }

    public void clickOnSaveButton() {
        clickOnElement(clickOnSaveButton);
    }


}
