package tests;

import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TC4_KolicinaUKorpiTest extends BaseTest {

    @Test
    public void testPovecanjeKolicine() {

        HomePage homePage = new HomePage(driver);

        homePage.navigateToLaptops();
        homePage.closeCookies();

        ProductPage productPage = homePage.clickFirstProduct();

        CartPage cartPage = productPage.addToCart();

        cartPage.navigateToCart();

        cartPage.increaseQuantity();
    }
}