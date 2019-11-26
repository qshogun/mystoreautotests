package com.qshogun.pages.authentication;

import com.qshogun.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {

    @FindBy(xpath = "//header[@class='page-header']/h1[contains(text(),'Log in')]")
    private WebElement logInHeader;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordTextbox;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='no-account']/a")
    private WebElement createAccountLink;


    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage isAt() {
        waitForVisibilityOf(logInHeader);
        Assert.assertTrue(logInHeader.isDisplayed());
        Assert.assertEquals("Login", driver.getTitle());
        return this;
    }
    public AuthenticationPage provideEmail(String emailAddress) {
        emailTextbox.sendKeys(emailAddress);
        return this;
    }
    public AuthenticationPage providePassword(String password) {
        passwordTextbox.sendKeys(password);
        return this;
    }
    public AuthenticationPage signIn() {
        signInButton.click();
        return this;
    }
    public AuthenticationPage createAccountClick() {
        createAccountLink.click();
        return this;
    }
}
