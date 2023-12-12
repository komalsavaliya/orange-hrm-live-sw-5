package com.orangehrm.demo.pages;

import com.orangehrm.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewSystemUsersPage extends Utility {
    //Verify "System Users" Text
    @CacheLookup
    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")
    WebElement verifyTextSystemUser;

    //click On "Add" button
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement clickOnAddButton;

    //enter Username
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement enterUserName;

    //Click on "Search" Button
    @CacheLookup
    @FindBy(xpath ="//button[normalize-space()='Search']")
    WebElement clickOnSearchButton;

    //Verify the User should be in Result list.
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Joe.Root')]")
    WebElement verifyTheUserShouldBeINList;

    //Click on Check box
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement clickOnCheckBox;

  //Click on Delete Button
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Delete Selected']")
    WebElement clickOnDeleteButton;

    //verify message "(1) Record Found"
    @CacheLookup
    @FindBy(xpath = ("//span[normalize-space()='No Records Found']"))
    WebElement noRecordFound;

  //Verify username <username>
    @CacheLookup
    @FindBy(xpath = ("//label[normalize-space()='Username']"))
    WebElement verifyUsername;

    //Click on Reset Tab
    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Reset']"))
    WebElement reSetButton;



    //------------------------------------------------------------------------------//
    public String verifyTextSystemUser() {
        return getTextFromElement(verifyTextSystemUser);
    }

    public void clickOnAddButton(){
        clickOnElement(clickOnAddButton);
    }

    public void enterUserName(String user){
        sendTextToElement(enterUserName,user);
    }
    public void clickOnSearchButton() {
        clickOnElement(clickOnSearchButton);
    }

    public String verifyTheUserShouldBeINList(){
        return getTextFromElement(verifyTheUserShouldBeINList);
    }

    public void clickOnCheckBox() {
        mouseHoverToElementAndClick(clickOnCheckBox);
    }
    public void clickOnDeleteButton() {
        clickOnElement(clickOnAddButton);
    }

    public void verifyNoRecordFoundMessage(String text) {
        verifyThatTextIsDisplayed(noRecordFound, text);
    }
    public void verifyUsernameLabel(String text) {
        verifyThatTextIsDisplayed(verifyUsername, text);
    }
    public void clickOnReSetButton() {
        clickOnElement(reSetButton);
    }

}