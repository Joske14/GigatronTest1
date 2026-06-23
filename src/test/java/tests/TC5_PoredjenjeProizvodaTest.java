package tests;

import locators.GigatronLocators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.List;

public class TC5_PoredjenjeProizvodaTest extends BaseTest {

    @Test
    public void testPoredjenjeProizvoda() throws Exception {

        HomePage homePage = new HomePage(driver);

        homePage.navigateToLaptops();
        homePage.closeCookies();

        Thread.sleep(3000);

        List<WebElement> compareButtons =
                driver.findElements(GigatronLocators.ADD_TO_COMPARE_BUTTON);


        compareButtons.get(0).click();

        Thread.sleep(2000);


        List<WebElement> closeButtons =
                driver.findElements(GigatronLocators.CLOSE_COMPARE_MODAL);

        if (!closeButtons.isEmpty()) {
            closeButtons.get(closeButtons.size() - 1).click();
        }

        Thread.sleep(2000);


        compareButtons =
                driver.findElements(GigatronLocators.ADD_TO_COMPARE_BUTTON);


        compareButtons.get(1).click();

        Thread.sleep(2000);

        // Klikni na "Uporedi proizvode"
        driver.findElement(
                GigatronLocators.COMPARE_PRODUCTS_BUTTON
        ).click();

        Thread.sleep(3000);

        // Provera URL-a
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("uporedi")
        );


        Assertions.assertTrue(
                driver.findElement(
                        GigatronLocators.COMPARE_PAGE_TITLE
                ).isDisplayed()
        );
    }
}