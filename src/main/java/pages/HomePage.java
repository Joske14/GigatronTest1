package pages;

import constants.GigatronConstants;
import locators.GigatronLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

/**
 * Stranica: Početna stranica / Lista proizvoda
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Ide na početnu stranicu
     */
    public HomePage navigateTo() {
        driver.get(GigatronConstants.GIGATRON_BASE_URL);
        return this;
    }

    /**
     * Ide na stranicu sa laptopima
     */
    public HomePage navigateToLaptops() {
        driver.get(GigatronConstants.GIGATRON_LAPTOPS_URL);

        // Čekaj da se PROIZVODI učitaju
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(GigatronLocators.PRODUCT_LINKS));

        try {
            Thread.sleep(GigatronConstants.THREAD_SLEEP_MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }
    public HomePage navigateToTelevisions() {
        driver.get("https://gigatron.rs/tv-audio-video/televizori");

        wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        GigatronLocators.PRODUCT_LINKS
                )
        );

        return this;
    }

    /**
     * Unosi tekst u search polje
     */
    public HomePage searchFor(String term) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GigatronLocators.SEARCH_INPUT));

        WebElement searchInput = wait.until(
                ExpectedConditions.elementToBeClickable(GigatronLocators.SEARCH_INPUT)
        );

        searchInput.clear();
        searchInput.sendKeys(term);

        return this;
    }

    /**
     * Klika na search dugme
     */
    public SearchResultsPage clickSearch() {
        WebElement searchButton = wait.until(
                ExpectedConditions.elementToBeClickable(GigatronLocators.SEARCH_BUTTON)
        );
        searchButton.click();

        try {
            Thread.sleep(GigatronConstants.THREAD_SLEEP_MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new SearchResultsPage(driver);
    }

    /**
     * Pronalazi prvi proizvod i klika na njega
     */
    public ProductPage clickFirstProduct() {
        try {
            Thread.sleep(GigatronConstants.THREAD_SLEEP_MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> products = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(GigatronLocators.PRODUCT_LINKS)
        );

        if (!products.isEmpty()) {
            products.get(0).click();
        }

        return new ProductPage(driver);
    }
    public HomePage openTelevisionsCategory() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        GigatronLocators.CATEGORIES_BUTTON
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        GigatronLocators.TV_AUDIO_VIDEO_MENU
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        GigatronLocators.TELEVIZORI_CATEGORY
                )
        ).click();

        return this;
    }
    public void closeCookies() {

        try {
            WebElement closeBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            GigatronLocators.COOKIE_CLOSE_BUTTON
                    )
            );

            closeBtn.click();

            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Cookie popup nije pronađen.");
        }
    }
}