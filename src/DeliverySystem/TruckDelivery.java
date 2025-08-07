package DeliverySystem;

public class TruckDelivery implements DeliveryStrategy {
    @Override
    public void deliver(Parcel parcel) {
        System.out.println("Delivering " + parcel + " by truck.");
    }
    
}
