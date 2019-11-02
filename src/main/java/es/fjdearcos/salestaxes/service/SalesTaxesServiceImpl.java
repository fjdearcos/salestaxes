package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;
import es.fjdearcos.salestaxes.domain.Purchase;
import es.fjdearcos.salestaxes.domain.Receipt;
import es.fjdearcos.salestaxes.domain.TaxedProduct;

import java.util.LinkedList;
import java.util.List;

public class SalesTaxesServiceImpl implements SalesTaxesService {

    private final SalesTax taxesService;


    public SalesTaxesServiceImpl(SalesTax taxesService) {
        this.taxesService = taxesService;
    }

    public Receipt getReceipt(Purchase purchase) {
        List<TaxedProduct> taxedProducts = new LinkedList<TaxedProduct>();
        for (Product product: purchase.getProducts()) {
            float tax = taxesService.applyTax(product);
            taxedProducts.add(new TaxedProduct(product.getQuantity(), product.getName(), tax, product.getPrice() + tax));
        }
        return new Receipt(taxedProducts);
    }
}
