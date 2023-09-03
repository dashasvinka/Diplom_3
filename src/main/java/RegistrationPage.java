import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //тут все нужные мне элементы на странице Регистрации

    private By userName = By.xpath("//label[text()='Имя']//following::input[1]");
    // поле Имя пользователя при регистрации

    public void sendUserName(String name) {
        driver.findElement(userName).sendKeys(name); //метод ввода имени
    }

    private By userEmail = By.xpath("//label[text()='Email']//following::input[1]");
    // поле Email пользователя при регистрации

    public void sendUserEmail(String email) {
        driver.findElement(userEmail).sendKeys(email); //метод ввода имейла
    }

    private By userPassword = By.xpath("//input[@name='Пароль']");
    // поле Пароль пользователя при регистрации

    public void sendUserPassword(String password) {
        driver.findElement(userPassword).sendKeys(password); //метод ввода пароля
    }
    private By buttonRegistration = By.xpath("//button[@class=\"button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa\"]");
    // кнопка Зарегистрироваться для регистрации пользователя на странице регистрации

    public void clickButtonRegistration() throws InterruptedException {
        driver.findElement(buttonRegistration).click(); //клик по кнопке Зарегестрироваться
    }

    private By notificationIncorrectPassword = By.xpath("//p[@class=\"input__error text_type_main-default\" and text()=\"Некорректный пароль\"]");
    // нотификация при вводе некорректного пароля "Некорректный пароль" на странице регистрации

    public String getNotificationIncorrectPassword(){
        return driver.findElement(notificationIncorrectPassword).getText(); // метод получения ошибки регистрации
    }
    private By buttonSignInRegistrationPage = By.xpath("//a[@href='/login']");
    // кнопка "Войти" на странице регистрации

    public void clickButtonSignInRegistrationPage() throws InterruptedException {
        driver.findElement(buttonSignInRegistrationPage).click();
    }

}
