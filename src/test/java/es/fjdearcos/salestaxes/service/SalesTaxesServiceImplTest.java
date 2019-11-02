package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;
import es.fjdearcos.salestaxes.domain.Purchase;
import es.fjdearcos.salestaxes.domain.Receipt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SalesTaxesServiceImplTest {

    private static final float TEST_PRICE_1 = 10.0f;
    private static final Product TEST_PRODUCT_1 = new Product(1, "testProduct", TEST_PRICE_1, false);
    private static final float TEST_PRICE_2 = 20.0f;
    private static final Product TEST_PRODUCT_2 = new Product(2, "testProduct2", TEST_PRICE_2, false);
    private static final Purchase TEST_PURCHASE = new Purchase(Arrays.asList(TEST_PRODUCT_1, TEST_PRODUCT_2));
    private static final float TEST_TAX_1 = 2.5f;
    private static final float TEST_TAX_2 = 5.0f;
    private static final float DELTA = 0.001f;

    @Mock
    private SalesTax mockedSalesTax;
    @InjectMocks
    private SalesTaxesServiceImpl salesTaxesServiceImpl;


    @Test
    public void testGetReceipt() {
        when(mockedSalesTax.applyTax(any(Product.class))).thenReturn(TEST_TAX_1).thenReturn(TEST_TAX_2);

        Receipt receipt = salesTaxesServiceImpl.getReceipt(TEST_PURCHASE);

        assertEquals(TEST_TAX_1 + TEST_TAX_2, receipt.getTaxes(), DELTA);
        assertEquals(TEST_PRICE_1 + TEST_TAX_1 + TEST_PRICE_2 + TEST_TAX_2, receipt.getTotal(), DELTA);
    }
}