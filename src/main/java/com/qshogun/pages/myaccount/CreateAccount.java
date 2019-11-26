package com.qshogun.pages.myaccount;

import com.qshogun.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccount extends BasePage {

    @FindBy(xpath = "//header[@class='page-header']/h1[contains(text(),'create')]")
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

    @FindBy(xpath = "//button[contains(text(),'SAVE') and @type='submit']")
    private WebElement createAccountSubmitButton;


    public CreateAccount(WebDriver driver) {
        super(driver);
    }
    public void isAt() {
        waitForVisibilityOf(createAccountHeader);
        Assert.assertTrue(createAccountHeader.isDisplayed());
    }
    public void selectMr() {
        mrRadiobutton.click();
    }
    public void selectMrs() {
        mrsRadiobutton.click();
    }
    public void provideFirstName(String firstName) {
        firstnameTextbox.sendKeys(firstName);
    }
    public void provideLastName(String lastName) {
        lastnameTextbox.sendKeys(lastName);
    }
    public void provideEmail(String emailAddress) {
        emailTextbox.sendKeys(emailAddress);
    }
    public void providePassword(String password) {
        passwordTextbox.sendKeys(password);
    }
    public void receiveOffers() {
        receiveOffersCheckbox.click();
    }
    public void signUpForNewsletter() {
        newsletterCheckbox.click();
    }
    public void createAccountSubmit() {
        createAccountSubmitButton.click();
    }
}
