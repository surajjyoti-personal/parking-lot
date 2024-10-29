import java.util.List;

public class Strategy {
    private static Strategy instance;
    private Strategy() {}
    public static synchronized Strategy getInstance() {
        if (instance == null) {
            instance = new Strategy();
        }
        return instance;
    }
    public SlotDecideStrategy getSlotDecideStrategy(Vehicle vehicle) {
        return new FirstEmptyStrategy();
    }
}
