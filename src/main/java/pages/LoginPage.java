package pages;

import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public boolean isLoginPageDisplayed() {

        String currentUrl = driver.getCurrentUrl().toLowerCase();

        System.out.println("LOGIN URL: " + currentUrl);

        return currentUrl.contains("login")
                || currentUrl.contains("prijava");
    }
}