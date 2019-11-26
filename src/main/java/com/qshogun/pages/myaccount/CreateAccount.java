package com.qshogun.pages.myaccount;

import com.qshogun.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccount extends BasePage {

    @FindBy(xpath = "//header[@class='page-header']//h1[contains(text(),'Create')]")
    private WebElement createAccountHeader;

    @FindBy(xpath = "//input[@name='id_gender' and @value='1']")
    private WebElement mrRadiobutton;

    @FindBy(xpath = "//input[@name='id_gender' and @value='2']")
    private WebElement mrsRadiobutton;

    @FindBy(name = "firstname")
    private WebElement firstnameTextbox;

    @FindBy(name = "lastname")
    private WebElement lastnameTextbox;

    @FindBy(name = "email")
    private WebElement emailTextbox;

    @FindBy(name = "password")
    private WebElement passwordTextbox;

    @FindBy(name = "optin")
    private WebElement receiveOffersCheckbox;

    @FindBy(name = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//button[contains(text(),'Save') and @type='submit']")
    private WebElement createAccountSubmitButton;


    public CreateAccount(WebDriver driver) {
        super(driver);
    }
    public CreateAccount isAt() {
        waitForVisibilityOf(createAccountHeader);
        Assert.assertTrue(createAccountHeader.isDisplayed());
        return this;
    }
    public CreateAccount selectMr() {
        mrRadiobutton.click();
        return this;
    }
    public CreateAccount selectMrs() {
        mrsRadiobutton.click();
        return this;
    }
    public CreateAccount provideFirstName(String firstName) {
        firstnameTextbox.sendKeys(firstName);
        return this;
    }
    public CreateAccount provideLastName(String lastName) {
        lastnameTextbox.sendKeys(lastName);
        return this;
    }
    public CreateAccount provideEmail(String emailAddress) {
        emailTextbox.sendKeys(emailAddress);
        return this;
    }
    public CreateAccount providePassword(String password) {
        passwordTextbox.sendKeys(password);
        return this;
    }
    public CreateAccount receiveOffers() {
        receiveOffersCheckbox.click();
        return this;
    }
    public CreateAccount signUpForNewsletter() {
        newsletterCheckbox.click();
        return this;
    }
    public CreateAccount createAccountSubmit() {
        createAccountSubmitButton.click();
        return this;
    }
}
