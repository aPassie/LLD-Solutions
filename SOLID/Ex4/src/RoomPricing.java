import java.util.*;

// stores base price for each room type - easy to add new room types here
public class RoomPricing {
    private final Map<Integer, Double> prices = new HashMap<>();

    public RoomPricing() {
        // register default room prices
        prices.put(LegacyRoomTypes.SINGLE, 14000.0);
        prices.put(LegacyRoomTypes.DOUBLE, 15000.0);
        prices.put(LegacyRoomTypes.TRIPLE, 12000.0);
        prices.put(LegacyRoomTypes.DELUXE, 16000.0);
    }

    public double getBasePrice(int roomType) {
        return prices.getOrDefault(roomType, 16000.0);
    }
}
