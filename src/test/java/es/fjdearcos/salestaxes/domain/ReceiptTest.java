package es.fjdearcos.salestaxes.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ReceiptTest {

    private static final float TEST_PRICE_1 = 20.0f;
    private static final float TEST_TAX_1 = 2.0f;
    private static final TaxedProduct TEST_TAXED_PRODUCT_1 =
            new TaxedProduct(1, "testProduct", false, TEST_TAX_1, TEST_PRICE_1);
    private static final float TEST_PRICE_2 = 10.0f;
    private static final float TEST_TAX_2 = 1.0f;
    private static final TaxedProduct TEST_TAXED_PRODUCT_2 =
            new TaxedProduct(2, "testProduct2", true, TEST_TAX_2, TEST_PRICE_2);
    private static final float DELTA = 0.001f;


    @Test
    public void testConstructor() {
        Receipt testReceipt = new Receipt(Arrays.asList(TEST_TAXED_PRODUCT_1, TEST_TAXED_PRODUCT_2));

        assertEquals(TEST_PRICE_1 + TEST_PRICE_2, testReceipt.getTotal(), DELTA);
        assertEquals(TEST_TAX_1 + TEST_TAX_2, testReceipt.getTaxes(), DELTA);
    }
}