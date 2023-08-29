import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@RunWith(Parameterized.class)
public class RegistrationTests {

    private WebDriver driver;
    private final DriverType driverType;

    public RegistrationTests(DriverType driverType) {
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
    public void checkPositiveRegistration() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        String generateName = getAlphaNumericString(5);
        registrationPage.sendUserName(generateName);
        registrationPage.sendUserEmail(String.format("%s@gmail.com", generateName));
        registrationPage.sendUserPassword("avrora43890934");
        registrationPage.clickButtonRegistration();
        personalAccountLoginPage.visibilityLogInAndWait();
        String text = personalAccountLoginPage.getTextSignInLogin();
        Assert.assertEquals("Вход", text);
    }

    @Test
    public void checkNegativeRegistration() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        PersonalAccountLoginPage personalAccountLoginPage = new PersonalAccountLoginPage(driver);
        String generateName = getAlphaNumericString(5);
        registrationPage.sendUserName(generateName);
        registrationPage.sendUserEmail(String.format("%s@gmail.com", generateName));
        registrationPage.sendUserPassword("a34");
        registrationPage.clickButtonRegistration();
        String text = registrationPage.getNotificationIncorrectPassword();
       Assert.assertEquals("Некорректный пароль", text);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    static String getAlphaNumericString(int n)
    {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
