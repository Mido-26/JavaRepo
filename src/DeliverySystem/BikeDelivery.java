package DeliverySystem;

public class BikeDelivery implements DeliveryStrategy {
    @Override
    public void deliver(Parcel parcel) {
        System.out.println("Delivering " + parcel + " by bike.");
    }
}
