package DeliverySystem;

public class DeliveryService {
    private DeliveryStrategy strategy;

    public void setStrategy(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public void deliver(Parcel parcel) {
        if (strategy != null) {
            strategy.deliver(parcel);
        } else {
            System.out.println("No delivery strategy set.");
        }
    }
}

