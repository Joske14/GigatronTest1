package pages;

import locators.GigatronLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductNameContains(String expectedBrand) {

        WebElement productName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))
        );

        return productName.getText()
                .toLowerCase()
                .contains(expectedBrand.toLowerCase());
    }

    public CartPage addToCart() {

        System.out.println("URL: " + driver.getCurrentUrl());

        WebElement addToCartButton = driver.findElements(
                org.openqa.selenium.By.xpath("//span[contains(text(),'Dodaj u korpu')]/ancestor::button")
        ).get(0);

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", addToCartButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new CartPage(driver);
    }
    public ProductPage addToCompare() {

        WebElement compareButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        GigatronLocators.ADD_TO_COMPARE_BUTTON
                )
        );

        compareButton.click();

        return this;
    }


    public ProductPage clickWishlist() {

        WebElement wishlist = wait.until(
                ExpectedConditions.elementToBeClickable(
                        GigatronLocators.WISHLIST_BUTTON)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", wishlist);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {}

        System.out.println("URL POSLE KLIKA: " + driver.getCurrentUrl());

        return this;
    }
}