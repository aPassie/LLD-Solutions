import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final RoomPricing roomPricing;

    public HostelFeeCalculator(FakeBookingRepo repo, RoomPricing roomPricing) {
        this.repo = repo;
        this.roomPricing = roomPricing;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double base = roomPricing.getBasePrice(req.roomType);

        double addOnTotal = 0.0;
        for (AddOn a : req.addOns) {
            addOnTotal += a.price; // price is stored in the enum itself now
        }

        return new Money(base + addOnTotal);
    }
}
