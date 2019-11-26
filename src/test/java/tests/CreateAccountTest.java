package tests;

import com.github.javafaker.Faker;
import com.qshogun.components.NavigationMenu;
import com.qshogun.pages.HomePage;
import com.qshogun.pages.myaccount.CreateAccount;
import com.qshogun.pages.myaccount.LoggedOut;
import org.openqa.selenium.WebDriver;

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
}
