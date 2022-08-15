package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class TooltipScreen extends BaseScreen {
    public TooltipScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='clickOnLoginWikiButton()']")
    MobileElement logInButton;
    @FindBy(xpath = "//*[resource-id='org.wikipedia:id/explore_overflow_account_name']")
    MobileElement accountName;
    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/explore_overflow_log_out']")
    MobileElement logOutButton;

    public LoginScreen clickOnLoginWikiButton() {
        logInButton.click();
        return new LoginScreen(driver);
    }
    public boolean isLogged(){
        return  accountName.isDisplayed();
    }
    public MainScreen logOut(){
        logInButton.click();
        return new MainScreen(driver);
    }
    public  String getInf(){
        return  logInButton.getText();
    }
}
