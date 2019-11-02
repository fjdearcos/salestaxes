package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Product;

interface SalesTax {
    float applyTax(Product product);
}
