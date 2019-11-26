package com.qshogun.components;

import com.qshogun.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends BasePage {

    @FindBy(xpath = "//div[@id=_'desktop_contact_link']/div[@id='contact-link']")
    private WebElement contactUsLinkDesktop;

    @FindBy(xpath = "//div[@id='_desktop_user_info']/a[contains(@title,'Log in')]")
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

    @FindBy(id = "carousel")
    private WebElement carouselSlider;

    @FindBy(xpath = "//div[@id='carousel']/a[contains(@class,'left')]")
    private WebElement carouselSlideLeftButton;

    @FindBy(xpath = "//div[@id='carousel']/a[contains(@class,'right')]")
    private WebElement carouselSlideRightButton;


    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public void clickContactUsDesktop() {
        contactUsLinkDesktop.click();
    }

    public void clickMyAccountDesktop() {
        signInButtonDesktop.click();
    }

    public void clickShoppingCartDesktop() {
        shoppingCartDesktop.click();
    }

}
