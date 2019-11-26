package com.qshogun.pages;

import com.qshogun.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

//    @FindBy(xpath = "//div[@id='_desktop_logo']/img")
//    private WebElement logoDesktop;

    @FindBy(id = "carousel")
    private WebElement carouselSlider;

    @FindBy(xpath = "//div[@id='carousel']/a[contains(@class,'left')]")
    private WebElement carouselSlideLeftButton;

    @FindBy(xpath = "//div[@id='carousel']/a[contains(@class,'right')]")
    private WebElement carouselSlideRightButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void isAt() {
        waitForVisibilityOf(carouselSlider);
        Assert.assertTrue(carouselSlider.isDisplayed());
        Assert.assertEquals("TesterSii", driver.getTitle());
    }
}
