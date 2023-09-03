import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalProfile {

    private WebDriver driver;

    public PersonalProfile(WebDriver driver) {this.driver = driver;}
    private By logoutButton = By.xpath("//li[@class='Account_listItem__35dAP']/button");
    //Кнопка Выход на странице профиля пользователя

    public String getLogoutButton(){
        return driver.findElement(logoutButton).getText();
    }

    public void clickLogoutButton() throws InterruptedException {
        driver.findElement(logoutButton).click();
    }
}
