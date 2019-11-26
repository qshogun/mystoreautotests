package com.qshogun.pages.myaccount;

import com.qshogun.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedOut extends BasePage {

    @FindBy(xpath = "//header[@class='page-header']/h1[contains(text(),'Log in')]")
    private WebElement logInHeader;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordTextbox;

    @FindBy(id = "submit-login")
    private WebElement signInButton;



    public void isAt() {
        waitForVisibilityOf(logInHeader);
        Assert.assertTrue(logInHeader.isDisplayed());
        Assert.assertEquals("Login", driver.getTitle());
    }

    public void provideEmail(String emailAddress) {
        emailTextbox.sendKeys(emailAddress);
    }

    public void providePassword(String password) {
        passwordTextbox.sendKeys(password);
    }

    public void signIn() {
        signInButton.click();
    }

    public LoggedOut(WebDriver driver) {
        super(driver);
    }
}
