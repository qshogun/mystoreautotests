package tests;

import com.qshogun.common.TestsSuite;
import com.qshogun.components.NavigationMenu;
import com.qshogun.model.ContactUsMessageTemplate;
import com.qshogun.model.User;
import com.qshogun.pages.ContactUs;
import com.qshogun.pages.HomePage;
import com.qshogun.pages.authentication.CreateAccount;
import com.qshogun.pages.authentication.AuthenticationPage;
import com.qshogun.pages.authentication.myaccount.MyAccount;
import com.qshogun.provider.DataFactory;
import org.junit.Test;

public class Tests extends TestsSuite {

    private HomePage homePage;
    private NavigationMenu navigationMenu;
    private AuthenticationPage authenticationPage;
    private CreateAccount createAccount;
    private ContactUs contactUs;
    private MyAccount myAccount;
    //endregion
    //region login credentials - correct
    private String emailCorrect = "johndoe@gmail.com";
    private String passwordCorrect = "asdf1234";
    //endregion

    //tests - account creation, logging in
    @Test
    public void createAccountTest() {
        System.out.println("in createAccountTest");
        User user = DataFactory.getUser();

        homePage = new HomePage(driver);
        homePage
                .isAt();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu
                .clickMyAccountDesktop();
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage
                .isAt()
                .createAccountClick();
        createAccount = new CreateAccount(driver);
        createAccount
                .isAt()
                .selectMr()
                .registerUser(user)
                .receiveOffers()
                .signUpForNewsletter()
                .createAccountSubmit()
                .isLoggedIn();

    }
    @Test
    public void logInTest() {
        System.out.println("in logInTest");
        homePage = new HomePage(driver);
        homePage
                .isAt();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu
                .clickMyAccountDesktop();
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage
                .provideEmail(emailCorrect)
                .providePassword(passwordCorrect)
                .signIn();
        navigationMenu
                .isPageLoaded();
        myAccount = new MyAccount(driver);
        myAccount
                .isAt();
    }

    //tests - contact us
    @Test
    public void sendMessageWebmaster() {
        System.out.println("in sendMessageWebMaster");
        ContactUsMessageTemplate messageTemplate = DataFactory.getContactUsMessageTemplateWebmaster();
        homePage = new HomePage(driver);
        homePage
                .isAt();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu
                .clickContactUsDesktop();
        contactUs = new ContactUs(driver);
        contactUs
                .isAt()
                .sendMessageWebmaster(messageTemplate)
                .submitMessage()
                .ifMessageSentSuccessfully();
    }
    @Test
    public void sendMessageCustomerService() {
        System.out.println("in sendMessageCustomerservice");
        ContactUsMessageTemplate messageTemplate = DataFactory.getContactUsMessageTemplateCustomerService();
        homePage = new HomePage(driver);
        homePage
                .isAt();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu
                .clickContactUsDesktop();
        contactUs = new ContactUs(driver);
        contactUs
                .isAt()
                .sendMessageCustomerservice(messageTemplate)
                .submitMessage()
                .ifMessageSentSuccessfully();
    }

}
