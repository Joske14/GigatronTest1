package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class TC6_WishlistBezPrijaveTest extends BaseTest {

    @Test
    public void test_TC6_WishlistBezPrijave() {

        HomePage homePage = new HomePage(driver);

        SearchResultsPage resultsPage = homePage
                .navigateToLaptops()
                .clickSearch();

        ProductPage productPage = resultsPage.clickFirstProduct();

        productPage.clickWishlist();


        LoginPage loginPage = new LoginPage(driver);

        Assertions.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "❌ Nije izvršen redirect na login stranicu!"
        );

        System.out.println("✅ TC6 PROŠAO!");
    }
}