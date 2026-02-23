import java.util.*;

// This class handles the money calculation part only
public class BillingCalculator {

    private final Map<String, MenuItem> menu;

    public BillingCalculator(Map<String, MenuItem> menu) {
        this.menu = menu;
    }

    public BillResult calculate(String customerType, List<OrderLine> lines) {
        double subtotal = 0.0;
        List<String> lineDetails = new ArrayList<>();

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            lineDetails.add(String.format("- %s x%d = %.2f", item.name, l.qty, lineTotal));
        }

        double taxPct = TaxRules.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;

        return new BillResult(lineDetails, subtotal, taxPct, tax, discount, total);
    }
}
