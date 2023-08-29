import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@RunWith(Parameterized.class)
public class PageTransitionsTests {

    private WebDriver driver;
    private final DriverType driverType;

    public PageTransitionsTests(DriverType driverType) {
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
    public void checkRoutePersonalAccount() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainMenuPage.clickButtonSignInMainPage();
        personalAccountLoginPage.sendFieldEmailLoginPage("khmelkovadaria@gmail.com");
        personalAccountLoginPage.sendFieldPasswordLoginPage("28sdjkgffkjh");
        personalAccountLoginPage.clickButtonSignInLoginPage();
        mainMenuPage.clickPersonalAccountMainPage();
        PersonalProfile personalProfile = new PersonalProfile(driver);
        String text = personalProfile.getLogoutButton();
        Assert.assertEquals("Выход", text);
    }

    @Test
    public void checkRoutePersonalConstruction() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainMenuPage.clickButtonSignInMainPage();
        personalAccountLoginPage.sendFieldEmailLoginPage("khmelkovadaria@gmail.com");
        personalAccountLoginPage.sendFieldPasswordLoginPage("28sdjkgffkjh");
        personalAccountLoginPage.clickButtonSignInLoginPage();
        mainMenuPage.clickPersonalAccountMainPage();
        mainMenuPage.clickButtonConstructorMainPage();
        String text = mainMenuPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", text);
    }

    @Test
    public void checkRouteLogo() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainMenuPage.clickButtonSignInMainPage();
        personalAccountLoginPage.sendFieldEmailLoginPage("khmelkovadaria@gmail.com");
        personalAccountLoginPage.sendFieldPasswordLoginPage("28sdjkgffkjh");
        personalAccountLoginPage.clickButtonSignInLoginPage();
        mainMenuPage.clickPersonalAccountMainPage();
        mainMenuPage.clickLogoStellarBurgersMainPage();
        String text = mainMenuPage.getTextOrderButton();
        Assert.assertEquals("Оформить заказ", text);
    }

        @After
        public void tearDown() {
            driver.quit();
        }

}
