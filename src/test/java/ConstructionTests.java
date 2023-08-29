import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@RunWith(Parameterized.class)
public class ConstructionTests {

    private WebDriver driver;
    private final DriverType driverType;

    public ConstructionTests(DriverType driverType) {
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
    public void checkBun() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickButtonFillingMainPage();
        mainMenuPage.clickButtonBunMainPage();
        Assert.assertTrue(mainMenuPage.isBunActive());
    }

    @Test
    public void checkSauces() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickButtonFillingMainPage();
        mainMenuPage.clickButtonSaucesMainPage();
        Assert.assertTrue(mainMenuPage.isSauceActive());
    }

    @Test
    public void checkFilling() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickButtonSaucesMainPage();
        mainMenuPage.clickButtonFillingMainPage();
        Assert.assertTrue(mainMenuPage.isFillingActive());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
