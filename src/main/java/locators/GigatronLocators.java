package locators;

import org.openqa.selenium.By;


public class GigatronLocators {


    public static final By SEARCH_INPUT =
            By.name("search");


    public static final By SEARCH_BUTTON = By.xpath(
            "//button[contains(text(), 'Pretraži') or @type='submit']"
    );


    public static final By PRODUCT_GRID = By.xpath(
            "//div[contains(@class, 'grid') or contains(@class, 'product')]"
    );


    public static final By PRODUCT_LINKS = By.xpath(
            "//a[contains(@href,'/proizvod/')]"
    );


    public static final By PRODUCT_CARDS = By.xpath(
            "//div[contains(@class, 'bg-card')]"
    );


    public static final By PRODUCT_NAME =
            By.tagName("h1");


    public static final By ADD_TO_CART_BUTTON =
            By.xpath("//span[contains(text(),'Dodaj u korpu')]/ancestor::button");

    public static final By ADD_TO_CART_BUTTON_ARIA = By.xpath(
            "//button[@aria-label='Dodaj u korpu']"
    );

    // ============ KORPA ============

    public static final By CART_ICON =
            By.xpath("//button[@aria-label='Otvori meni korpe']");


    public static final By REMOVE_FROM_CART_BUTTON =
            By.xpath("//button[contains(@aria-label,'Obriši') or contains(@aria-label,'ukloni')]");


    public static final By CONFIRM_REMOVE_BUTTON =
            By.xpath("//button[.//span[contains(text(),'Obriši')]]");


    public static final By REMOVE_BUTTON_ALT = By.xpath(
            "//button[contains(@class, 'remove') or contains(@class, 'delete')]"
    );


    public static final By EMPTY_CART_MESSAGE =
            By.xpath("//*[contains(text(),'Korpa je prazna') or contains(text(),'prazna')]");



    public static final By CART_TITLE = By.xpath(
            "//h1[contains(text(), 'Vaša korpa') or contains(text(), 'Tvoja korpa')]"
    );

    // ============ REZULTATI PRETRAGE ============

    public static final By NO_RESULTS_MESSAGE = By.xpath(
            "//*[contains(text(), 'Nema rezultata') or contains(text(), '0 rezultata')]"
    );

    /**
     * Broj pronađenih rezultata
     */
    public static final By RESULTS_COUNT = By.xpath(
            "//*[contains(text(), 'rezultata') and contains(@class, 'count')]"
    );
    public static final By TV_AUDIO_VIDEO_MENU =
            By.xpath("//a[@href='/tv-audio-video']");

    public static final By TELEVIZORI_CATEGORY =
            By.xpath("//*[contains(text(),'Televizori')]");

    public static final By CATEGORIES_BUTTON =
            By.xpath("//button[contains(.,'Kategorije proizvoda')]");

    public static final By INCREASE_QUANTITY_BUTTON =
            By.xpath("//button[@aria-label='Povećaj količinu']");
    public static final By COOKIE_CLOSE_BUTTON =
            By.xpath("//button[@aria-label='Zatvori']");

    public static final By ADD_TO_COMPARE_BUTTON =
            By.xpath("//button[@aria-label='Dodaj u listu za poređenje']");


    public static final By COMPARE_PRODUCTS_BUTTON =
            By.xpath("//a[@aria-label='Uporedi proizvode']");


    public static final By CLOSE_COMPARE_MODAL =
            By.xpath("//div[contains(.,'Uporedi proizvode')]//button[@aria-label='Zatvori']");

    public static final By COMPARE_PAGE_TITLE =
            By.xpath("//h1[contains(text(),'Uporedi proizvode')]");

    public static final By WISHLIST_BUTTON =
            By.cssSelector("button[aria-label='Dodaj u listu želja']");

    public static final By LOGIN_FORM =
            By.xpath("//*[contains(text(),'Unesite email i lozinku')]");
}
