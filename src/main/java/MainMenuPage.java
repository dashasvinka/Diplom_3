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

    private By tabBun = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(.//span, 'Булки')]");
    private By tabSauce = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(.//span, 'Соусы')]");
    private By tabFiling = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(.//span, 'Начинки')]");


    public void clickTabBun(){
        driver.findElement(tabBun).click();
    }
    public void clickTabSauce(){
        driver.findElement(tabSauce).click();
    }
    public void clickTabFiling(){
        driver.findElement(tabFiling).click();
    }
    public boolean isSelectedTabBun(){
        return driver.findElement(tabBun).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }
    public boolean isSelectedTabFiling(){
        return driver.findElement(tabFiling).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }
    public boolean isSelectedTabSauce(){
        return driver.findElement(tabSauce).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }
    //Кнопка раздела "Булки" - активная
    private By activeBunButton = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");

    public void clickActiveBun() throws InterruptedException {
        driver.findElement(activeBunButton).click(); //клик по активным булкам
    }
    //Кнопка раздела "Булки" - неактивная
    private By inactiveBunButton = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    public void clickInActiveBun() throws InterruptedException {
        driver.findElement(inactiveBunButton).click(); //клик по неактивным булкам
    }

    //Кнопка раздела "Соусы" - активная
    private By activeSauceButton = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");

    public void clickActiveSauce() throws InterruptedException {
        driver.findElement(activeSauceButton).click(); //клик по активным соусам
    }
    //Кнопка раздела "Соусы" - неактивная
    private By inactiveSauceButton = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    public void clickInActiveSauce() throws InterruptedException {
        driver.findElement(inactiveSauceButton).click(); //клик по неактивным соусам
    }

    //Кнопка раздела "Начинки" - активная
    private By activeFillingButton = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    public void clickActiveFilling() throws InterruptedException {
        driver.findElement(activeFillingButton).click(); //клик по активным начинкам
    }
    //Кнопка раздела "Начинки" - неактивная
    private By inactiveFillingButton = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    public void clickInActiveFilling() throws InterruptedException {
        driver.findElement(inactiveFillingButton).click(); //клик по неактивным начинкам
    }

    public boolean isSauceActive() {
        return driver.findElement(activeSauceButton).isDisplayed();
    }

    public boolean isFillingActive() {
        return driver.findElement(activeFillingButton).isDisplayed();
    }

    public boolean isBunActive() {
        return driver.findElement(activeBunButton).isDisplayed();
    }

    private By textSauce = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10']");
    private By textBun = By.xpath("//h2[contains(@class, 'text text_type_main-medium mb-6 mt-10') and text() = 'Булки']");

    private By textFilling = By.xpath("//h2[contains(@class, 'text text_type_main-medium mb-6 mt-10') and text() = 'Начинки']");

    public boolean isTextSauce() {
        return driver.findElement(textSauce).isDisplayed();
    }
    public boolean isSelectedBlock() {
        return driver.findElement(buttonSaucesMainPage).isSelected();
    }

    public boolean isVisibleBlockBun() {
        return driver.findElement(textBun).isDisplayed();
    }
}
