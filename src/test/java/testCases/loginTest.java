package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.LoginPage;
import utils.commonMethods;
import utils.configReader;

public class loginTest extends commonMethods {

    @Test
    public void adminLogin(){

        //login in to application
        LoginPage loginPage= new LoginPage();
        sendText(loginPage.userNameBox, configReader.getPropValue("username"));
        sendText(loginPage.passwordBox, configReader.getPropValue("password"));
        click(loginPage.loginBtn);

        Dashboard dashboard = new Dashboard();
        Assert.assertTrue(dashboard.welcome.isDisplayed(), "welcome message is not displayed ");


    }





}
