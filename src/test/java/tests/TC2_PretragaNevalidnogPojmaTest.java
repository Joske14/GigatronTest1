package tests;

import constants.GigatronConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultsPage;

/**
 * TC2: Pretraga nevalidnog pojma (asdfghjkl)
 *
 * Scenarij:
 * 1. Otvori početnu stranicu
 * 2. Unesi nevalidnu pretragu "asdfghjkl"
 * 3. Klikni pretragu
 * 4. Provjeri da je prikazana poruka "Nema rezultata"
 */
public class
TC2_PretragaNevalidnogPojmaTest extends BaseTest {

    @Test
    public void test_TC2_PretragaNevalidnogPojma() {

        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();


        SearchResultsPage resultsPage = homePage
                .searchFor(GigatronConstants.INVALID_SEARCH_TERM)
                .clickSearch();


        Assertions.assertTrue(resultsPage.isNoResultsMessageDisplayed(),
                "❌ GREŠKA: Nije prikazana poruka 'Nema rezultata' za nevalidnu pretragu!");

        System.out.println("✅ TC2 PROŠAO: Pretraga nevalidnog pojma vraća 'Nema rezultata'!");
    }
}