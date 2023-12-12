package com.orangehrm.demo.pages;

import com.orangehrm.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 4.AdminPage - UserManagement, Job, Organization Tabs Locators and it's actions
 */

public class AdminPage extends Utility {
    //click On "Admin" Tab
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]/span[1]")
    WebElement clickOnAdmin;


    //________________________________________________________________________________//
    public void clickOnAdmin(){
        clickOnElement(clickOnAdmin);
    }

}
