import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountLoginPage {
    private WebDriver driver;

    public PersonalAccountLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By fieldEmailLoginPage =  By.xpath("//label[text()='Email']//following::input[1]");
    // поле Email на странице входа в личный кабинет

    public void sendFieldEmailLoginPage(String email) {
        driver.findElement(fieldEmailLoginPage).sendKeys(email); //метод ввода email
    }

    private By fieldPasswordLoginPage = By.xpath("//input[@name='Пароль']");
    // поле Пароль на странице входа в личный кабинет
    public void sendFieldPasswordLoginPage(String password) {
        driver.findElement(fieldPasswordLoginPage).sendKeys(password); //метод ввода password
    }
    private By buttonSignInLoginPage = By.xpath("//button[text()='Войти']");
    // кнопка Войти на странице входа в личный кабинет

    public void clickButtonSignInLoginPage() throws InterruptedException {
        driver.findElement(buttonSignInLoginPage).click(); //клик по кнопке Войти
    }

    private By textSignInLoginPage = By.xpath("//h2[text()='Вход']");
    // текст Вход на странице входа в личный кабинет

    public void visibilityLogInAndWait(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(textSignInLoginPage));
    }

    public String getTextSignInLogin(){
      return driver.findElement(textSignInLoginPage).getText();
    }
}
