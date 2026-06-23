package constants;


public class GigatronConstants {

    // ============ URL-ovi ============
    public static final String GIGATRON_BASE_URL = "https://www.gigatron.rs";
    public static final String GIGATRON_LAPTOPS_URL = "https://gigatron.rs/laptop-racunari-i-it-oprema/laptop-racunari";
    public static final String GIGATRON_SEARCH_URL = "https://www.gigatron.rs/pretraga";

    // ============ Očekivani rezultati ============
    public static final String EXPECTED_BRAND_LENOVO = "Lenovo";
    public static final String INVALID_SEARCH_TERM = "asdfghjkl";

    // ============ Poruke ============
    public static final String EMPTY_CART_MESSAGE_PATTERN = "prazna|nemate";
    public static final String ZERO_RESULTS_MESSAGE_PATTERN = "0|nema|nije pronađeno";

    // ============ Čekanja (timeout-i) ============
    public static final int EXPLICIT_WAIT_SECONDS = 20;
    public static final int IMPLICIT_WAIT_SECONDS = 10;
    public static final int THREAD_SLEEP_MILLISECONDS = 3000;
}