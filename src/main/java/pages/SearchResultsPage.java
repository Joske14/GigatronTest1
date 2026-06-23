package pages;

import constants.GigatronConstants;
import locators.GigatronLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

/**
 * Stranica: Rezultati pretrage / Lista proizvoda
 */
public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Klika na prvi proizvod iz liste
     */
    public ProductPage clickFirstProduct() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> products = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        GigatronLocators.PRODUCT_LINKS)
        );

        for (WebElement product : products) {

            String href = product.getAttribute("href");

            if (href != null &&
                    href.contains("/proizvod/") &&
                    !href.contains("secure.gigatron")) {

                System.out.println("Klik na proizvod: " + href);

                driver.get(href);

                return new ProductPage(driver);
            }
        }

        throw new RuntimeException("Nije pronađen nijedan proizvod!");
    }
    /**
     * Proverava da li ima rezultata
     */
    public boolean hasResults() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(GigatronLocators.PRODUCT_GRID));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Proverava da li postoji poruka "Nema rezultata"
     */
    public boolean isNoResultsMessageDisplayed() {

        String page = driver.getPageSource().toLowerCase();

        return page.contains("nema proizvoda")
                || page.contains("nije pronađen")
                || page.contains("nije pronađena")
                || page.contains("0 proizvoda")
                || page.contains("nema rezultata")
                || page.contains("0 rezultata");
    }
}