package pages;

import constants.GigatronConstants;
import locators.GigatronLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Ide na stranicu korpe
     */
    public CartPage navigateToCart() {
        driver.get(GigatronConstants.GIGATRON_BASE_URL + "/korpa");
        try {
            Thread.sleep(GigatronConstants.THREAD_SLEEP_MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Klika na "Obriši proizvod" dugme
     */
    public CartPage removeFromCart() {

        // Prvo dugme "Obriši proizvod"
        WebElement removeButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        GigatronLocators.REMOVE_FROM_CART_BUTTON)
        );

        removeButton.click();

        // Popup potvrda
        WebElement confirmButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        GigatronLocators.CONFIRM_REMOVE_BUTTON)
        );

        confirmButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    /**
     * Proverava da li je korpa prazna
     */
    public boolean isCartEmpty() {

        try {

            Thread.sleep(3000);

            return driver.findElements(
                    GigatronLocators.REMOVE_FROM_CART_BUTTON
            ).isEmpty();

        } catch (Exception e) {
            return false;
        }
    }
    public CartPage increaseQuantity() {

        WebElement plusButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        GigatronLocators.INCREASE_QUANTITY_BUTTON
                )
        );

        plusButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }
}