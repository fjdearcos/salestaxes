package es.fjdearcos.salestaxes.adapter;

import es.fjdearcos.salestaxes.domain.Product;
import es.fjdearcos.salestaxes.domain.Purchase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ClearTextPurchaseInputParserTest {

    private static final String TEST_INPUT = "1 book at 12.49\n" +
            "1 music CD at 14.99\n" +
            "10 imported bottles of water at 20.00\n" +
            "10 bottles of imported soda at 30.00\n" +
            "2 chocolate bar at 0.85";


    private final ClearTextPurchaseInputParser clearTextPurchaseInputParser = new ClearTextPurchaseInputParser();


    @Test
    public void testParse() {
        Purchase purchase = clearTextPurchaseInputParser.parse(TEST_INPUT);

        List<Product> products = getProducts(purchase);
        assertEquals(5, products.size());
        assertProductIsParsed(1, "book", 12.49f, false, products);
        assertProductIsParsed(1, "music CD", 14.99f, false, products);
        assertProductIsParsed(10, "bottles of water", 20.0f, true, products);
        assertProductIsParsed(10, "bottles of soda", 30.0f, true, products);
        assertProductIsParsed(2, "chocolate bar", 0.85f, false, products);
    }

    private List<Product> getProducts(Purchase purchase) {
        List<Product> products = new LinkedList<>();
        for (Product product: purchase.getProducts()) {
            products.add(product);
        }
        return products;
    }

    private void assertProductIsParsed(int quantity, String name, float price, boolean imported, List<Product> products) {
        if (products.stream().noneMatch(product -> quantity == product.getQuantity() &&
                name.equals(product.getName()) && price == product.getPrice() && imported == product.isImported())) {
            fail("No product with quantity " + quantity + ", name " + name + ", price " + price + " and imported " +
                    imported + " is parsed");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidInput() {
        String invalidInput = "Invalid input";

        clearTextPurchaseInputParser.parse(invalidInput);
    }
}