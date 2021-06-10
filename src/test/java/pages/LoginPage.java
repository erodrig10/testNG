package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;
import utils.configReader;

public class LoginPage extends commonMethods{
    public @FindBy(id = "txtUsername")
    WebElement userNameBox;

    public @FindBy(id= "txtpassword")
    WebElement passwordBox;

    public @FindBy(id = "btnLogin")
    WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        sendText(loginPage.userNameBox, configReader.getPropValue("username"));
        sendText(loginPage.passwordBox, configReader.getPropValue("password"));
        click(loginPage.loginBtn);

    }


}
