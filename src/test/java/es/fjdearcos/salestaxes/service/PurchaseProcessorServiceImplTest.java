package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;
import es.fjdearcos.salestaxes.domain.Purchase;
import es.fjdearcos.salestaxes.domain.Receipt;
import es.fjdearcos.salestaxes.domain.TaxedProduct;
import es.fjdearcos.salestaxes.port.PurchaseInputParser;
import es.fjdearcos.salestaxes.port.ReceiptOutputPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseProcessorServiceImplTest {

    private static final String TEST_INPUT = "Test input";
    private static final Purchase TEST_PURCHASE = new Purchase(Collections.singleton(
            new Product(1, "test", 5.0f, false)));
    private static final Receipt TEST_RECEIPT = new Receipt(Collections.singleton(
            new TaxedProduct(1, "test", false, 0.5f, 5.5f)));


    @Mock
    private PurchaseInputParser mockedPurchaseInputParser;
    @Mock
    private SalesTaxesService mockedSalesTaxesService;
    @Mock
    private ReceiptOutputPrinter mockedReceiptOutputPrinter;
    @InjectMocks
    private PurchaseProcessorServiceImpl testPurchaseProcessorService;

    @Test
    public void testProcess() {
        String expectedResult = "Test result";

        when(mockedPurchaseInputParser.parse(anyString())).thenReturn(TEST_PURCHASE);
        when(mockedSalesTaxesService.getReceipt(any(Purchase.class))).thenReturn(TEST_RECEIPT);
        when(mockedReceiptOutputPrinter.print(any(Receipt.class))).thenReturn(expectedResult);

        String result = testPurchaseProcessorService.process(TEST_INPUT);

        assertEquals(expectedResult, result);
        verify(mockedPurchaseInputParser).parse(eq(TEST_INPUT));
        verify(mockedSalesTaxesService).getReceipt(eq(TEST_PURCHASE));
        verify(mockedReceiptOutputPrinter).print(eq(TEST_RECEIPT));
    }
}