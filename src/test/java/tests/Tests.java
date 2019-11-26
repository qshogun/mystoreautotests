package tests;

import com.github.javafaker.Faker;
import com.qshogun.components.NavigationMenu;
import com.qshogun.pages.ContactUs;
import com.qshogun.pages.HomePage;
import com.qshogun.pages.authentication.CreateAccount;
import com.qshogun.pages.authentication.AuthenticationPage;
import com.qshogun.pages.authentication.myaccount.MyAccount;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {

    //region fake create account credentials
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String emailAddress = faker.internet().emailAddress();
    String password = faker.internet().password();
    String messageText = faker.country().capital();
    //endregion
    //region pages
    private WebDriver driver;
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

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://5.196.7.235/");
    }

    @After
    public void after() {
        driver.quit();
    }

    //tests - account creation, logging in
    @Test
    public void createAccountTest() {
        System.out.println("in createAccountTest");
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
                .provideFirstName(firstName)
                .provideLastName(lastName)
                .provideEmail(emailAddress)
                .providePassword(password)
                .receiveOffers()
                .signUpForNewsletter()
                .createAccountSubmit();
        homePage
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
        homePage = new HomePage(driver);
        homePage
                .isAt();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu
                .clickContactUsDesktop();
        contactUs = new ContactUs(driver);
        contactUs
                .isAt()
                .chooseSubjectWebmaster()
                .provideEmail(emailAddress)
                .provideMessage(messageText)
                .submitMessage()
                .ifMessageSentSuccessfully();
    }
    @Test
    public void sendMessageCustomerService() {
        System.out.println("in sendMessageCustomerservice");
        homePage = new HomePage(driver);
        homePage
                .isAt();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu
                .clickContactUsDesktop();
        contactUs = new ContactUs(driver);
        contactUs
                .isAt()
                .chooseSubjectCustomerservice()
                .provideEmail(emailAddress)
                .provideMessage(messageText)
                .submitMessage()
                .ifMessageSentSuccessfully();
    }

}
