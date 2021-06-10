package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class Dashboard extends commonMethods {

    @FindBy(id = "welcome")
    public WebElement welcome;

     public Dashboard(){
         PageFactory.initElements(driver, this);

     }

}
