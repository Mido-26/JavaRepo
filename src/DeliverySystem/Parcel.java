package DeliverySystem;

public class Parcel implements Comparable<Parcel> {
    private String id;
    private String sender;
    private String receiver;
    private String sourceCity;
    private String destinationCity;
    private double weight;
    private String priority; // "High", "Medium", "Low"

    public Parcel(String id, String sender, String receiver, String sourceCity, String destinationCity, double weight, String priority) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.weight = weight;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getPriority() {
        return priority;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Parcel other) {
        return getPriorityValue(other.priority) - getPriorityValue(this.priority);
    }

    private int getPriorityValue(String p) {
        return switch (p) {
            case "High" -> 3;
            case "Medium" -> 2;
            default -> 1;
        };
    }

    @Override
    public String toString() {
        return id + ": " + sender + " -> " + receiver + " (" + priority + ")";
    }
}
