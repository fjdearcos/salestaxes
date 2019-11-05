package es.fjdearcos.salestaxes.port;

import es.fjdearcos.salestaxes.domain.Receipt;

public interface ReceiptOutputPrinter {
    String print(Receipt receipt);
}
