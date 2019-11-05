package es.fjdearcos.salestaxes.port;

import es.fjdearcos.salestaxes.domain.Purchase;

public interface PurchaseInputParser {
    Purchase parse(String purchaseDescription);
}
