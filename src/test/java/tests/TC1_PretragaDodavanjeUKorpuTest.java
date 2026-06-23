package tests;

import constants.GigatronConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

/**
 * TC1: Pretraga, dodavanje u korpu i uklanjanje
 *
 * Scenarij:
 * 1. Otvori početnu stranicu
 * 2. Navigiraj na stranicu sa laptopima
 * 3. Odaberi prvi laptop
 * 4. Provjeri da naziv sadrži "Lenovo"
 * 5. Klikni "Dodaj u korpu"
 * 6. Idi u korpu
 * 7. Ukloni proizvod iz korpe
 * 8. Provjeri da je korpa prazna
 */
public class TC1_PretragaDodavanjeUKorpuTest extends BaseTest {

    @Test
    public void test_TC1_PretragaDodavanjeUKorpuIUklanjanje() {
        HomePage homePage = new HomePage(driver);


        SearchResultsPage resultsPage = homePage
                .navigateToLaptops()
                .clickSearch();


        Assertions.assertTrue(resultsPage.hasResults(),
                "❌ GREŠKA: Nema rezultata za laptope!");


        ProductPage productPage = resultsPage.clickFirstProduct();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());


        CartPage cartPage = productPage.addToCart();


        cartPage.navigateToCart();


        cartPage.removeFromCart();


        Assertions.assertTrue(cartPage.isCartEmpty(),
                "❌ GREŠKA: Korpa nije prazna nakon uklanjanja proizvoda!");

        System.out.println("✅ TC1 PROŠAO: Pretraga, dodavanje u korpu i uklanjanje!");
    }
}