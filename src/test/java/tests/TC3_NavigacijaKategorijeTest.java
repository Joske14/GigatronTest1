package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import locators.GigatronLocators;
public class  TC3_NavigacijaKategorijeTest extends BaseTest {
    @Test
    public void testNavigacijaKategorijeTelevizori() throws InterruptedException {

        System.out.println("TC3 START");

        HomePage homePage = new HomePage(driver);

        homePage.navigateToTelevisions();

        System.out.println("URL: " + driver.getCurrentUrl());

        Assertions.assertTrue(
                driver.getCurrentUrl().contains("televizori")
        );

        System.out.println("Pronadjeni proizvodi: "
                + driver.findElements(GigatronLocators.PRODUCT_LINKS).size());

        Assertions.assertFalse(
                driver.findElements(GigatronLocators.PRODUCT_LINKS).isEmpty()
        );

        System.out.println("✅ TC3 PROSAO");

        Thread.sleep(10000);
    }

}