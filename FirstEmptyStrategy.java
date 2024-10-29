import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstEmptyStrategy implements SlotDecideStrategy{
    @Override
    public List<Integer> giveSlot(List<List<Slot>> slots, Vehicle vehicle) {
        List<Integer> result = null;
        boolean found = false;
        for (int i =0 ;i<slots.size();i++){
            for (int j =0 ;j<slots.get(i).size();j++){
                if (slots.get(i).get(j).getCarType().equals(vehicle.getCarType()) && slots.get(i).get(j).getVehicle() == null){
                    slots.get(i).get(j).setVehicle(vehicle.getVehicleNumber());
                    found = true;
                    result = new ArrayList<>(Arrays.asList(i,j));
                    break;
                }
                if (found) break;
            }
        }

        if (!found){
            System.out.println("No slot found");
        }
        return result;
    }
}
