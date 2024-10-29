public class Client {
    public static void main(String[] args) {
        ParkingLotManager manager = ParkingLotManager.getInstance();
//        manager.printSlots();
        manager.bookSlot(new Vehicle(CarType.CAR, "101"));
    }
}
