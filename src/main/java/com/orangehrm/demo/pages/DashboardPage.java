package com.orangehrm.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrm.demo.customlistener.CustomListener;
import com.orangehrm.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 3.DashboardPage - Dashboard text Locator
 * and create appropriate methods for it.
 */

public class DashboardPage extends Utility {

    //Verify "Dashboard" Message
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement verifyDashboardMessage;

    @CacheLookup
    @FindBy(className = "oxd-userdropdown-img")
    WebElement clickOnUserProfileLogo;
//_____________________________________________________________________________//
    public String verifyDashboardMessage() {
        String message = getTextFromElement(verifyDashboardMessage);
        CustomListener.test.log(Status.PASS, "Dashboard");
        return message;
    }
    public void clickOnUserProfileLogo(){
        clickOnElement(clickOnUserProfileLogo);
    }
}
