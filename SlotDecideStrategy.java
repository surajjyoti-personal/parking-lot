import java.util.List;

public interface SlotDecideStrategy {
    List<Integer> giveSlot(List<List<Slot>> slots, Vehicle vehicle);
}
