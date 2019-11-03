package es.fjdearcos.salestaxes.adapter;

import es.fjdearcos.salestaxes.domain.Product;
import es.fjdearcos.salestaxes.domain.Purchase;
import es.fjdearcos.salestaxes.port.PurchaseInputParser;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClearTextPurchaseInputParser implements PurchaseInputParser {

    private static final Pattern PRODUCT_DESCRIPTION_PATTERN =
            Pattern.compile("(\\d+) ((\\w ?)+) at (\\d+.\\d{2})", Pattern.CASE_INSENSITIVE);
    private static final String IMPORTED_KEYWORD = "imported";


    @Override
    public Purchase parse(String purchaseDescription) {
        List<Product> products = new LinkedList<>();
        String[] productDescriptions = purchaseDescription.split("\n");
        for(String productDescription : productDescriptions) {
            products.add(parseProduct(productDescription));
        }
        return new Purchase(products);
    }

    private Product parseProduct(String productDescription) {
        Matcher matcher = PRODUCT_DESCRIPTION_PATTERN.matcher(productDescription);
        if (matcher.matches()) {
            int quantity = Integer.parseInt(matcher.group(1));
            String name = matcher.group(2);
            boolean imported = false;
            if (name.contains(IMPORTED_KEYWORD)) {
                imported = true;
                name = name.replace(IMPORTED_KEYWORD, "").replaceAll("\\s{2,}", " ").trim();
            }
            float price = Float.parseFloat(matcher.group(4));
            return new Product(quantity, name, price, imported);
        }
        throw new IllegalArgumentException("Invalid product description: " + productDescription);
    }
}
