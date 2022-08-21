package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GooglePage extends BasePage{

    @FindBy(name = "q")
    WebElement searchBox;


    public void search(String searchWord){
        searchBox.sendKeys(searchWord+Keys.ENTER);
    }
}
