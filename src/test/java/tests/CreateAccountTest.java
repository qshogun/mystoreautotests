package tests;

import com.github.javafaker.Faker;
import com.qshogun.components.NavigationMenu;
import com.qshogun.pages.HomePage;
import com.qshogun.pages.myaccount.CreateAccount;
import com.qshogun.pages.myaccount.LoggedOut;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccountTest {

    //region pages
    private WebDriver driver;
    private HomePage homePage;
    private NavigationMenu navigationMenu;
    private LoggedOut loggedOut;
    private CreateAccount createAccount;
    //endregion

    //region fake create account credentials
    private Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String emailAddress = faker.internet().emailAddress();
    private String password = faker.internet().password();
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

    @Test
    public void createAccountTest() {
        System.out.println("in createAccountTest");
        homePage = new HomePage(driver);
        homePage.isAt();
        navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickMyAccountDesktop();
        loggedOut = new LoggedOut(driver);
        loggedOut.isAt();
        loggedOut.createAccountClick();
        createAccount = new CreateAccount(driver);
        createAccount.isAt();
        createAccount.selectMr();
        createAccount.provideFirstName(firstName);
        createAccount.provideLastName(lastName);
        createAccount.provideEmail(emailAddress);
        createAccount.providePassword(password);
        createAccount.receiveOffers();
        createAccount.signUpForNewsletter();
        createAccount.createAccountSubmit();
        homePage = new HomePage(driver);
        homePage.isLoggedIn();

    }
}
