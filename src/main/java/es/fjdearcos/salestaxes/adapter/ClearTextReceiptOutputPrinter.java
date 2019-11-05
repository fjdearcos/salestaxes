package es.fjdearcos.salestaxes.adapter;

import es.fjdearcos.salestaxes.domain.Receipt;
import es.fjdearcos.salestaxes.domain.TaxedProduct;
import es.fjdearcos.salestaxes.port.ReceiptOutputPrinter;

public class ClearTextReceiptOutputPrinter implements ReceiptOutputPrinter {
    @Override
    public String print(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        for (TaxedProduct taxedProduct : receipt.getTaxedProducts()) {
            sb.append(taxedProduct.getQuantity()).append(taxedProduct.isImported()? " imported " : " ")
                    .append(taxedProduct.getName()).append(": ")
                    .append(printPriceWithTwoDecimals(taxedProduct.getTotalPrice())).append("\n");
        }
        sb.append("Sales Taxes: ").append(printPriceWithTwoDecimals(receipt.getTaxes())).append("\n");
        sb.append("Total: ").append(printPriceWithTwoDecimals(receipt.getTotal()));
        return sb.toString();
    }

    private String printPriceWithTwoDecimals(float price) {
        return String.format("%.02f", price);
    }
}
