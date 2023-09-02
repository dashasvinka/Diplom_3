import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@RunWith(Parameterized.class)
public class SignInTests {

    private WebDriver driver;
    private final DriverType driverType;

    public SignInTests(DriverType driverType) {
        this.driverType = driverType;
    }

    @Before
    public void startUp() throws IOException {
        driver = ConfigurationWebDriver.getDriverByDriverType(driverType);
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {DriverType.Chrome},
                {DriverType.Yandex}
        };
    }

    @Test
    public void checkSignInLogin() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainMenuPage.clickButtonSignInMainPage();
        personalAccountLoginPage.sendFieldEmailLoginPage("khmelkovadaria@gmail.com");
        personalAccountLoginPage.sendFieldPasswordLoginPage("28sdjkgffkjh");
        personalAccountLoginPage.clickButtonSignInLoginPage();
        String text = mainMenuPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", text);
    }

    @Test
    public void checkPersonalAccountLogin() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainMenuPage.clickPersonalAccountMainPage();
        personalAccountLoginPage.sendFieldEmailLoginPage("khmelkovadaria@gmail.com");
        personalAccountLoginPage.sendFieldPasswordLoginPage("28sdjkgffkjh");
        personalAccountLoginPage.clickButtonSignInLoginPage();
        String text = mainMenuPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", text);
    }

    @Test
    public void checkRegistrationLogin() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickButtonSignInRegistrationPage();
        personalAccountLoginPage.sendFieldEmailLoginPage("khmelkovadaria@gmail.com");
        personalAccountLoginPage.sendFieldPasswordLoginPage("28sdjkgffkjh");
        personalAccountLoginPage.clickButtonSignInLoginPage();
        String text = mainMenuPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", text);
    }

    @Test
    public void checkRecoveryLogin() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
        recoveryPasswordPage.clickButtonSignInRecoveryPasswordPage();
        personalAccountLoginPage.sendFieldEmailLoginPage("khmelkovadaria@gmail.com");
        personalAccountLoginPage.sendFieldPasswordLoginPage("28sdjkgffkjh");
        personalAccountLoginPage.clickButtonSignInLoginPage();
        String text = mainMenuPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", text);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
