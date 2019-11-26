package com.qshogun.pages;

import com.qshogun.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends BasePage {

    @FindBy(className = "container")
    private WebElement containerBlock;

    @FindBy(name = "id_contact")
    private WebElement subjectFormselect; //1 for Webmaster, 2 for Customer service

    @FindBy(xpath = "//input[@class='form-control' and @type='email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement messageTextbox;

    @FindBy(name = "submitMessage")
    private WebElement submitMessageButton;

    @FindBy(xpath = "//*[contains(@class,'warning')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[contains(@class,'success')]")
    private WebElement messageSentSuccessfullyBlock;



    public ContactUs isAt() {
        waitForVisibilityOf(submitMessageButton);
        Assert.assertTrue(submitMessageButton.isDisplayed());
        return this;
    }
    public ContactUs chooseSubjectWebmaster() {
        subjectFormselect.sendKeys("Webmaster");
        return this;
    }
    public ContactUs chooseSubjectCustomerservice() {
        subjectFormselect.sendKeys("Customer service");
        return this;
    }
    public ContactUs provideEmail(String emailAddress) {
        emailTextbox.sendKeys(emailAddress);
        return this;
    }
    public ContactUs provideMessage(String messageText) {
        messageTextbox.sendKeys(messageText);
        return this;
    }
    public ContactUs submitMessage() {
        submitMessageButton.click();
        return this;
    }
    public ContactUs ifMessageSentSuccessfully() {
        waitForVisibilityOf(containerBlock);
        Assert.assertTrue(messageSentSuccessfullyBlock.isDisplayed());
        return this;
    }

    public ContactUs(WebDriver driver) {
        super(driver);
    }
}
