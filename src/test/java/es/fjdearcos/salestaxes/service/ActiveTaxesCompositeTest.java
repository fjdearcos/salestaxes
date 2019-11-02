package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ActiveTaxesCompositeTest {

    private static final Product TEST_PRODUCT = new Product(1, "testProduct", 10.0f, false);
    private static final float TAX_1 = 1.0f;
    private static final float TAX_2 = 0.5f;
    private static final float DELTA = 0.001f;


    @Mock
    private SalesTax mockedTax1;
    @Mock
    private SalesTax mockedTax2;

    private ActiveTaxesComposite activeTaxesComposite;


    @Before
    public void setUp() {
        activeTaxesComposite = new ActiveTaxesComposite(Arrays.asList(mockedTax1, mockedTax2));
    }

    @Test
    public void testApplyTax() {
        float expectedTax = TAX_1 + TAX_2;

        when(mockedTax1.applyTax(any(Product.class))).thenReturn(TAX_1);
        when(mockedTax2.applyTax(any(Product.class))).thenReturn(TAX_2);

        float actualTax = activeTaxesComposite.applyTax(TEST_PRODUCT);

        assertEquals(expectedTax, actualTax, DELTA);
        verify(mockedTax1).applyTax(eq(TEST_PRODUCT));
        verify(mockedTax2).applyTax(eq(TEST_PRODUCT));
    }
}