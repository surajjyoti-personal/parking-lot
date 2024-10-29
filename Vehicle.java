public class Vehicle {
    private CarType carType;
    private String vehicleNumber;
    public Vehicle(CarType carType, String vehicleNumber) {
        this.carType = carType;
        this.vehicleNumber = vehicleNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
