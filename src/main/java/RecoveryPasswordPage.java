import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {

    private WebDriver driver;

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private By buttonSignInRecoveryPasswordPage = By.xpath("//a[@href='/login']");
    // линк Войти на странице восстановления пароль

    public void clickButtonSignInRecoveryPasswordPage() throws InterruptedException {
        driver.findElement(buttonSignInRecoveryPasswordPage).click();
    }
}
