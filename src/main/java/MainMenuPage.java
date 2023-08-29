import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenuPage {

    private WebDriver driver;

    public MainMenuPage(WebDriver driver) {
        this.driver = driver;
    }
    private By personalAccountMainPage = By.xpath("//a[@href='/account']");
    // линк Личный Кабинет на главной странице

    public void clickPersonalAccountMainPage() throws InterruptedException {
        driver.findElement(personalAccountMainPage).click(); //клик по линку Личный Кабинет на главной странице
    }

    private By buttonSignInMainPage = By.xpath("//button[text()='Войти в аккаунт']");
    // кнопка Войти в аккаунт на главной странице

    public void clickButtonSignInMainPage() throws InterruptedException {
        driver.findElement(buttonSignInMainPage).click(); //клик по кнопке Войти в аккаунт на главной странице
    }

    private By logoStellarBurgersMainPage = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    // логотип Stellar Burgers на главной странице

    public void clickLogoStellarBurgersMainPage() throws InterruptedException {
        driver.findElement(logoStellarBurgersMainPage).click(); //клик по логотипу
    }


    private By buttonConstructorMainPage = By.xpath("//p[text()='Конструктор']");
    // кнопка Конструктор на главной странице

    public void clickButtonConstructorMainPage() throws InterruptedException {
        driver.findElement(buttonConstructorMainPage).click(); //клик по Конструктуру
    }

    private By buttonBunMainPage = By.xpath("//span[text()='Булки']");
    // кнопка перехода к разделу Булки на главной странице

    public void clickButtonBunMainPage() throws InterruptedException {
        driver.findElement(buttonBunMainPage).click(); //клик по Булки
    }
    private By buttonSaucesMainPage = By.xpath("//span[text()='Соусы']");
    // кнопка перехода к разделу Соусы на главной странице
    public void clickButtonSaucesMainPage() throws InterruptedException {
        driver.findElement(buttonSaucesMainPage).click(); //клик по Соусы
    }
    private By buttonFillingMainPage = By.xpath("//span[text()='Начинки']");
    // кнопка перехода к разделу Начинки на главной странице

    public void clickButtonFillingMainPage() throws InterruptedException {
        driver.findElement(buttonFillingMainPage).click(); //клик по Начинки
    }

    private By orderButton = By.xpath("//button[text()='Оформить заказ']");
    // кнопка "Оформить заказ" на главной странице

    public String getTextOrderButton(){
        return driver.findElement(orderButton).getText();
    }

    //Кнопка раздела "Булки" - активная
    private By activeBunButton = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Кнопка раздела "Булки" - неактивная
    private By inactiveBunButton = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Кнопка раздела "Соусы" - активная
    private By activeSauceButton = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Кнопка раздела "Соусы" - неактивная
    private By inactiveSauceButton = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Кнопка раздела "Начинки" - активная
    private By activeFillingButton = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    //Кнопка раздела "Начинки" - неактивная
    private By inactiveFillingButton = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    public boolean isSauceActive() {
        return driver.findElement(activeSauceButton).isDisplayed();
    }

    public boolean isFillingActive() {
        return driver.findElement(activeFillingButton).isDisplayed();
    }

    public boolean isBunActive() {
        return driver.findElement(activeBunButton).isDisplayed();
    }
}
