package es.fjdearcos.salestaxes.service;

import es.fjdearcos.salestaxes.domain.Purchase;
import es.fjdearcos.salestaxes.domain.Receipt;
import es.fjdearcos.salestaxes.port.PurchaseInputParser;
import es.fjdearcos.salestaxes.port.ReceiptOutputPrinter;

public class PurchaseProcessorServiceImpl implements PurchaseProcessorService {

    private final PurchaseInputParser purchaseInputParser;
    private final SalesTaxesService salesTaxesService;
    private final ReceiptOutputPrinter receiptOutputPrinter;


    public PurchaseProcessorServiceImpl(PurchaseInputParser purchaseInputParser, SalesTaxesService salesTaxesService,
                                        ReceiptOutputPrinter receiptOutputPrinter) {
        this.purchaseInputParser = purchaseInputParser;
        this.salesTaxesService = salesTaxesService;
        this.receiptOutputPrinter = receiptOutputPrinter;
    }

    @Override
    public String process(String purchaseDescription) {
        Purchase purchase = purchaseInputParser.parse(purchaseDescription);
        Receipt receipt = salesTaxesService.getReceipt(purchase);
        return receiptOutputPrinter.print(receipt);
    }
}
