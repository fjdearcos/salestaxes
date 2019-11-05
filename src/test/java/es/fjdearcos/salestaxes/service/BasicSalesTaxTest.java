package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;
import es.fjdearcos.salestaxes.repository.BookProductsRepository;
import es.fjdearcos.salestaxes.repository.FoodProductsRepository;
import es.fjdearcos.salestaxes.repository.MedicalProductsRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasicSalesTaxTest {

    private static final String TEST_NAME = "testProduct";
    private static final float TEST_PRICE = 20.0f;
    private static final Product TEST_PRODUCT = new Product(1, TEST_NAME, TEST_PRICE, false);
    private static final float DELTA = 0.001f;


    @Mock
    private BookProductsRepository mockedBookProductsRepository;
    @Mock
    private FoodProductsRepository mockedFoodProductsRepository;
    @Mock
    private MedicalProductsRepository mockedMedicalProductsRepository;
    @InjectMocks
    private BasicSalesTax basicSalesTax;


    @Test
    public void testApplyTaxNoExemptProduct() {
        float expectedTax = 0.10f * TEST_PRICE;

        float actualTax = basicSalesTax.applyTax(TEST_PRODUCT);

        assertEquals(expectedTax, actualTax, DELTA);
        verify(mockedBookProductsRepository).isBookProduct(eq(TEST_NAME));
        verify(mockedFoodProductsRepository).isFoodProduct(eq(TEST_NAME));
        verify(mockedMedicalProductsRepository).isMedicalProduct(eq(TEST_NAME));

    }

    @Test
    public void testApplyTaxExemptBookProduct() {
        when(mockedBookProductsRepository.isBookProduct(anyString())).thenReturn(true);

        float actualTax = basicSalesTax.applyTax(TEST_PRODUCT);

        assertEquals(0, actualTax, DELTA);
        verify(mockedBookProductsRepository).isBookProduct(eq(TEST_NAME));
    }

    @Test
    public void testApplyTaxExemptFoodProduct() {
        when(mockedFoodProductsRepository.isFoodProduct(anyString())).thenReturn(true);

        float actualTax = basicSalesTax.applyTax(TEST_PRODUCT);

        assertEquals(0, actualTax, DELTA);
        verify(mockedFoodProductsRepository).isFoodProduct(eq(TEST_NAME));
    }

    @Test
    public void testApplyTaxExemptMedicalProduct() {
        when(mockedMedicalProductsRepository.isMedicalProduct(anyString())).thenReturn(true);

        float actualTax = basicSalesTax.applyTax(TEST_PRODUCT);

        assertEquals(0, actualTax, DELTA);
        verify(mockedMedicalProductsRepository).isMedicalProduct(eq(TEST_NAME));
    }

    @Test
    public void testApplyTaxRoundTax() {
        Product productToRound = new Product(1, TEST_NAME, TEST_PRICE + 0.01f, false);
        float roundedTax = 2.05f;

        float actualTax = basicSalesTax.applyTax(productToRound);

        assertEquals(roundedTax, actualTax, DELTA);
    }
}