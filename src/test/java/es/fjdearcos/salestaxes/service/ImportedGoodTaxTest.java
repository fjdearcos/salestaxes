package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImportedGoodTaxTest {

    private static final float TEST_PRICE = 5.00f;
    private static final Product TEST_PRODUCT = new Product(1, "testProduct", TEST_PRICE, true);
    private static final float DELTA = 0.001f;


    private final ImportedGoodTax importedGoodTax = new ImportedGoodTax();


    @Test
    public void testApplyTaxToImportedProduct() {
        float expectedTax = 0.05f * TEST_PRICE;

        float actualTax = importedGoodTax.applyTax(TEST_PRODUCT);

        assertEquals(expectedTax, actualTax, DELTA);
    }

    @Test
    public void testApplyTaxToNotImportedProduct() {
        Product notImportedProduct = new Product(1, "testProduct", TEST_PRICE, false);

        float actualTax = importedGoodTax.applyTax(notImportedProduct);

        assertEquals(0.0f, actualTax, DELTA);
    }
}