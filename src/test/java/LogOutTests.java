import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@RunWith(Parameterized.class)
public class LogOutTests {

    private WebDriver driver;
    private final DriverType driverType;

    public LogOutTests(DriverType driverType) {
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
    public void checkLogOut() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        mainMenuPage.clickButtonSignInMainPage();
        personalAccountLoginPage.sendFieldEmailLoginPage("khmelkovadaria@gmail.com");
        personalAccountLoginPage.sendFieldPasswordLoginPage("28sdjkgffkjh");
        personalAccountLoginPage.clickButtonSignInLoginPage();
        mainMenuPage.clickPersonalAccountMainPage();
        PersonalProfile personalProfile = new PersonalProfile(driver);
        personalProfile.clickLogoutButton();
        String text = personalAccountLoginPage.getTextSignInLogin();
        Assert.assertEquals("Вход", text);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
