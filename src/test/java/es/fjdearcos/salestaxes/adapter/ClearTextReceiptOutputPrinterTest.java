package es.fjdearcos.salestaxes.adapter;

import es.fjdearcos.salestaxes.domain.Receipt;
import es.fjdearcos.salestaxes.domain.TaxedProduct;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ClearTextReceiptOutputPrinterTest {

    private static final TaxedProduct TAXED_PRODUCT_1 =
            new TaxedProduct(1, "book", false, 0f, 15.0f);
    private static final TaxedProduct TAXED_PRODUCT_2 =
            new TaxedProduct(1, "music CD", true, 2.5f, 15.0f);
    private static final TaxedProduct TAXED_PRODUCT_3 =
            new TaxedProduct(2, "games", false, 10f, 90f);
    private static final Receipt TEST_RECEIPT =
            new Receipt(Arrays.asList(TAXED_PRODUCT_1, TAXED_PRODUCT_2, TAXED_PRODUCT_3));


    private final ClearTextReceiptOutputPrinter clearTextReceiptOutputPrinter = new ClearTextReceiptOutputPrinter();


    @Test
    public void testPrint() {
        String result = clearTextReceiptOutputPrinter.print(TEST_RECEIPT);

        String[] lines = result.split("\n");
        assertEquals(5, lines.length);
        assertEquals("1 book: 15.00", lines[0]);
        assertEquals("1 imported music CD: 15.00", lines[1]);
        assertEquals("2 games: 90.00", lines[2]);
        assertEquals("Sales Taxes: 12.50", lines[3]);
        assertEquals("Total: 120.00", lines[4]);
    }
}