package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;

public interface SalesTax {
    float applyTax(Product product);
}
