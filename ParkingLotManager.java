import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private static ParkingLotManager instance;
    private int numberOfFloors;
    private int slotsPerFloor;
    private List<List<Slot>> parkingLots;
    private Strategy strategy;
    private TicketManager ticketManager;
    private ParkingLotManager(int numberOfFloors,int slotsPerFloor) {
        this.numberOfFloors = numberOfFloors;
        this.slotsPerFloor = slotsPerFloor;
        this.ticketManager = TicketManager.getInstance();
        this.parkingLots = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            List<Slot> slots = new ArrayList<>();
            slots.add(new Slot(CarType.TRUCK));
            slots.add(new Slot(CarType.BIKE));
            slots.add(new Slot(CarType.BIKE));
            for (int j = 3; j < slotsPerFloor; j++) {
                slots.add(new Slot(CarType.CAR));
            }
            parkingLots.add(slots);
        }
        this.strategy = Strategy.getInstance();
    }
    public static synchronized ParkingLotManager getInstance() {
        if (instance == null) {
            instance = new ParkingLotManager(3,4);
        }
        return instance;
    }
    public void bookSlot(Vehicle vehicle) {
        SlotDecideStrategy slotDecideStrategy = strategy.getSlotDecideStrategy(vehicle);
        List<Integer> slot = slotDecideStrategy.giveSlot(parkingLots, vehicle);
        if (slot == null) {
            return;
        }
        Ticket ticket = new Ticket(slot.get(0), slot.get(1));
        ticketManager.addOrder(ticket);
        parkingLots.get(slot.get(0)).get(slot.get(1)).setTicketId(ticket.getId());
        printTicket(ticket);
    }
    public void unparkSlot(String id) {
        Ticket ticket = ticketManager.getTicket(id);
        parkingLots.get(ticket.getFloorIndex()).get(ticket.getSlotIndex()).setTicketId(null);
        parkingLots.get(ticket.getFloorIndex()).get(ticket.getSlotIndex()).setTicketId(null);
        System.out.println("Unpark slot " + id + " from floor " + ticket.getFloorIndex());
    }
    private void printTicket(Ticket ticket) {
        System.out.println(ticket.getId() + " is created");
        System.out.println("Floor: " + ticket.getFloorIndex());
        System.out.println("Slot: " + ticket.getSlotIndex());
    }

    public void printSlots() {
        for (List<Slot> slots : parkingLots) {
            for (Slot slot : slots) {
                System.out.print(slot.getCarType() + " ");
            }
            System.out.println();
        }
    }

}
