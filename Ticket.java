import java.util.UUID;

public class Ticket {
    private String id;
    private int floorIndex;
    private int slotIndex;
    public Ticket(int floorIndex, int slotIndex) {
        this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.floorIndex = floorIndex;
        this.slotIndex = slotIndex;
    }

    public String getId() {
        return id;
    }

    public int getFloorIndex() {
        return floorIndex;
    }

    public int getSlotIndex() {
        return slotIndex;
    }
}
