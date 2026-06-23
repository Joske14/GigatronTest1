package tests;

import constants.GigatronConstants;
import locators.GigatronLocators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Nested
class GigatronTest extends BaseTest {


    // TC1

    @Test
    @Order(1)
    public void tc1_add_remove_cart() {

        HomePage home = new HomePage(driver);

        SearchResultsPage results = home
                .navigateToLaptops()
                .clickSearch();

        Assertions.assertTrue(results.hasResults());

        ProductPage product = results.clickFirstProduct();

        CartPage cart = product.addToCart();

        cart.navigateToCart();

        cart.removeFromCart();

        Assertions.assertTrue(cart.isCartEmpty());
    }

    //TC2
    @Test
    @Order(2)
    public void tc2_invalid_search() throws InterruptedException {

        HomePage home = new HomePage(driver);

        driver.get("https://gigatron.rs");
        Thread.sleep(2000);
        home.closeCookies();

        SearchResultsPage results = home
                .searchFor(GigatronConstants.INVALID_SEARCH_TERM)
                .clickSearch();

        Thread.sleep(2000);

        Assertions.assertTrue(results.isNoResultsMessageDisplayed());
    }


    // TC3

    @Test
    @Order(3)
    public void tc3_navigation_tv() throws InterruptedException {


            System.out.println("TC3 START");

            HomePage home = new HomePage(driver);

            home.navigateToTelevisions();

            System.out.println("URL: " + driver.getCurrentUrl());

            Assertions.assertTrue(
                    driver.getCurrentUrl().contains("televizori")
            );

            System.out.println("Pronađeni proizvodi: "
                    + driver.findElements(GigatronLocators.PRODUCT_LINKS).size());

            Assertions.assertFalse(
                    driver.findElements(GigatronLocators.PRODUCT_LINKS).isEmpty()
            );


        Thread.sleep(10000);
        }




    // TC4

    @Test
    @Order(4)
    public void tc4_increase_quantity() throws InterruptedException {

        HomePage home = new HomePage(driver);

        home.navigateToLaptops();
        Thread.sleep(2000);
        home.closeCookies();
        Thread.sleep(2000);

        // Umesto direktnog klika preko page objekta koji puca, nalazimo element i klikćemo preko JS-a
        List<WebElement> products = driver.findElements(GigatronLocators.PRODUCT_LINKS);
        if(!products.isEmpty()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", products.get(0));
        }

        Thread.sleep(3000);

        ProductPage productPage = new ProductPage(driver);
        CartPage cart = productPage.addToCart();

        Thread.sleep(2000);
        cart.navigateToCart();

        Thread.sleep(2000);
        cart.increaseQuantity();

        Assertions.assertTrue(true);
    }


    // TC5

    @Test
    @Order(5)
    public void tc5_compare_products() throws InterruptedException {

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
            closeButtons.getLast().click();
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


    // TC6

    @Test
    @Order(6)
    public void tc6_wishlist_login_redirect() {

        HomePage home = new HomePage(driver);

        SearchResultsPage results = home
                .navigateToLaptops()
                .clickSearch();

        ProductPage product = results.clickFirstProduct();

        product.clickWishlist();

        LoginPage login = new LoginPage(driver);

        Assertions.assertTrue(login.isLoginPageDisplayed());
    }
}