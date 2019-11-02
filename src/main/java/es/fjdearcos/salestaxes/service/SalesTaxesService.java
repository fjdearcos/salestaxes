package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Purchase;
import es.fjdearcos.salestaxes.domain.Receipt;

public interface SalesTaxesService {
    Receipt getReceipt(Purchase purchase);
}
