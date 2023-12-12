package com.orangehrm.demo.pages;

import com.orangehrm.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 2. HomePage - Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text locatores
 * and create appropriate methods for it.
 */

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    //_____________________________________________________________________________________//

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }
    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }
}
