package com.qshogun.pages.authentication.myaccount;

import com.qshogun.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

    @FindBy(id = "identity-link")
    private WebElement informationItem;


    public MyAccount(WebDriver driver) {
        super(driver);
    }

    public MyAccount isAt() {
        Assert.assertEquals("My account", driver.getTitle());
        Assert.assertTrue(informationItem.isDisplayed());
        return this;
    }
}
