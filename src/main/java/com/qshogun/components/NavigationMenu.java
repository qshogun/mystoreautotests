package com.qshogun.components;

import com.qshogun.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends BasePage {

    @FindBy(xpath = "//div[@id='_desktop_logo']//img")
    private WebElement logoDesktop;

    @FindBy(xpath = "//div[@id='_desktop_contact_link']/div[@id='contact-link']")
    private WebElement contactUsLinkDesktop;

    @FindBy(xpath = "//div[@id='_desktop_user_info']//span[contains(text(),'Sign in')]")
    private WebElement signInButtonDesktop;

    @FindBy(xpath = "//div[@id='_desktop_cart']/div[@class='header']")
    private WebElement shoppingCartDesktop;

    @FindBy(xpath = "//div[@id='_desktop_cart']/span[@class='cart-products-count']")
    private WebElement shoppingCartProductsCountDesktop;

    @FindBy(id = "category-3")
    private WebElement clothesDropdownMenu;

    @FindBy(id = "category-4")
    private WebElement clothesMenSubmenu;

    @FindBy(id = "category-5")
    private WebElement clothesWomenSubmenu;

    @FindBy(id = "category-6")
    private WebElement accessoriesDropdownMenu;

    @FindBy(id = "category-7")
    private WebElement accessoriesStationerySubmenu;

    @FindBy(id = "category-8")
    private WebElement accessoriesHomeSubmenu;

    @FindBy(id = "category-9")
    private WebElement artDropdownMenu;


    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public NavigationMenu isPageLoaded() {
        waitForVisibilityOf(logoDesktop);
        Assert.assertTrue(logoDesktop.isDisplayed());
        return this;
    }
    public NavigationMenu clickLogoDesktop() {
        logoDesktop.click();
        return this;
    }
    public NavigationMenu clickContactUsDesktop() {
        contactUsLinkDesktop.click();
        return this;
    }
    public NavigationMenu clickMyAccountDesktop() {
        signInButtonDesktop.click();
        return this;
    }
    public NavigationMenu clickShoppingCartDesktop() {
        shoppingCartDesktop.click();
        return this;
    }

}
