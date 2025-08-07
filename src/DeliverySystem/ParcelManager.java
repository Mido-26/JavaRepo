package DeliverySystem;

import java.util.*;

public class ParcelManager {
    private PriorityQueue<Parcel> parcelQueue = new PriorityQueue<>();
    private Queue<Parcel> deliveryQueue = new LinkedList<>();
    private Map<String, Parcel> parcelMap = new HashMap<>();

    public void addParcel(Parcel parcel) {
        parcelQueue.offer(parcel);
        parcelMap.put(String.valueOf(parcel.getId()), parcel);
    }

    public List<Parcel> getSortedParcels() {
        List<Parcel> sorted = new ArrayList<>(parcelQueue);
        sorted.sort(Comparator.comparing(Parcel::getId)); // Replace getId with the appropriate property for sorting
        return sorted;
    }

    public Parcel processNextParcel() {
        Parcel next = parcelQueue.poll();
        if (next != null) {
            deliveryQueue.offer(next);
        }
        return next;
    }

    public Parcel deliverNextParcel() {
        return deliveryQueue.poll();
    }

    public boolean cancelParcel(String id) {
        Parcel removed = parcelMap.remove(id);
        return parcelQueue.remove(removed);
    }

    public boolean hasPendingParcels() {
        return !parcelQueue.isEmpty();
    }
}

