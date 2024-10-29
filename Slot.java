public class Slot {
    private final CarType carType;
    private String vehicle;
    private String ticketId;
    public Slot(CarType carType) {
        this.carType = carType;
        this.vehicle = null;
        this.ticketId = null;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
