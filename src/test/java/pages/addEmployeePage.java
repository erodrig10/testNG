package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class addEmployeePage extends commonMethods {

    @FindBy(id="firstname")
    public WebElement firstname;

    @FindBy(id="middlename")
    public WebElement middlename;

    @FindBy(id="lastname")
    public WebElement lastname;

    @FindBy(id="empolyeeid")
    public WebElement empolyeeid;

    @FindBy(id="btnSave")
    public WebElement btnSave;

    @FindBy(id="chkLogin")
    public WebElement chkLogin;

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }

}
