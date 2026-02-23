// Now this class actually does real formatting work
public class InvoiceFormatter {

    public static String format(String invId, BillResult bill) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");

        for (String line : bill.lineDetails) {
            out.append(line).append("\n");
        }

        out.append(String.format("Subtotal: %.2f\n", bill.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", bill.taxPct, bill.tax));
        out.append(String.format("Discount: -%.2f\n", bill.discount));
        out.append(String.format("TOTAL: %.2f\n", bill.total));

        return out.toString();
    }
}
