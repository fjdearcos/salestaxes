package es.fjdearcos.salestaxes;

import es.fjdearcos.salestaxes.configuration.SalesTaxesConfiguration;
import es.fjdearcos.salestaxes.service.PurchaseProcessorService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class SalesTaxesApplicationIT {

    private static final String TEST_INPUT_1 = "1 book at 12.49\n" +
            "1 music CD at 14.99\n" +
            "1 chocolate bar at 0.85";
    private static final String TEST_INPUT_2 = "1 imported box of chocolates at 10.00\n" +
            "1 imported bottle of perfume at 47.50";
    private static final String TEST_INPUT_3 = "1 imported bottle of perfume at 27.99\n" +
            "1 bottle of perfume at 18.99\n" +
            "1 packet of headache pills at 9.75\n" +
            "1 box of imported chocolates at 11.25";
    private static final String EXPECTED_OUTPUT_1 = "1 book: 12.49\n" +
            "1 music CD: 16.49\n" +
            "1 chocolate bar: 0.85\n" +
            "Sales Taxes: 1.50\n" +
            "Total: 29.83";
    private static final String EXPECTED_OUTPUT_2 = "1 imported box of chocolates: 10.50\n" +
            "1 imported bottle of perfume: 54.65\n" +
            "Sales Taxes: 7.65\n" +
            "Total: 65.15";
    private static final String EXPECTED_OUTPUT_3 = "1 imported bottle of perfume: 32.19\n" +
            "1 bottle of perfume: 20.89\n" +
            "1 packet of headache pills: 9.75\n" +
            "1 imported box of chocolates: 11.85\n" +
            "Sales Taxes: 6.70\n" +
            "Total: 74.68";


    private PurchaseProcessorService purchaseProcessorService;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SalesTaxesConfiguration.class);
        ctx.refresh();

        purchaseProcessorService = ctx.getBean(PurchaseProcessorService.class);
    }

    @Test
    public void testInput1() {
        String result = purchaseProcessorService.process(TEST_INPUT_1);

        assertEquals(EXPECTED_OUTPUT_1, result);
    }


    @Test
    public void testInput2() {
        String result = purchaseProcessorService.process(TEST_INPUT_2);

        assertEquals(EXPECTED_OUTPUT_2, result);
    }


    @Test
    public void testInput3() {
        String result = purchaseProcessorService.process(TEST_INPUT_3);

        assertEquals(EXPECTED_OUTPUT_3, result);
    }
}
