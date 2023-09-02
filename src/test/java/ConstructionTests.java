import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
    public void checkBun() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickTabFiling();
        Assert.assertFalse(mainMenuPage.isSelectedTabBun());
        mainMenuPage.clickTabBun();
        Assert.assertTrue(mainMenuPage.isSelectedTabBun());
    }

    @Test
    public void checkSauces() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        Assert.assertFalse(mainMenuPage.isSelectedTabSauce());
        mainMenuPage.clickTabSauce();
        Assert.assertTrue(mainMenuPage.isSelectedTabSauce());
    }

    @Test
    public void checkFilling() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        Assert.assertFalse(mainMenuPage.isSelectedTabFiling());
        mainMenuPage.clickTabFiling();
        Assert.assertTrue(mainMenuPage.isSelectedTabFiling());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
