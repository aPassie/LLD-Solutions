import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        // step 1: calculate the bill
        BillingCalculator calculator = new BillingCalculator(menu);
        BillResult bill = calculator.calculate(customerType, lines);

        // step 2: format the invoice
        String printable = InvoiceFormatter.format(invId, bill);
        System.out.print(printable);

        // step 3: save it
        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
