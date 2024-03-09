import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

    List<List<Object>> equipmentList;

    // Constructor to initialize the equipment list with data
    public DataBase() {
        equipmentList = new ArrayList<>();

        // Add data to the equipment list
        equipmentList.add(Arrays.asList("Chainmail", 70, 0, 1, 0, -1));
        equipmentList.add(Arrays.asList("Excalibur", 150, 2, 0, 0, 0));
        equipmentList.add(Arrays.asList("Regalia", 105, 0, 1, 0, 0));
        equipmentList.add(Arrays.asList("Amulet", 200, 1, -1, 1, 1));
        equipmentList.add(Arrays.asList("Fleece", 150, 0, 2, 1, -1));
        equipmentList.add(Arrays.asList("Crystal", 210, 2, 1, -1, -1));
    }




    // Method to get soldier data by name
    public List<Object> getSoldierData(String name) {
        for (List<Object> soldier : equipmentList) {
            if (name.equals(soldier.get(0))) {
                System.out.println("Name: " + soldier.get(0));
                System.out.println("Price: " + soldier.get(1));
                System.out.println("Attack: " + soldier.get(2));
                System.out.println("Defence: " + soldier.get(3));
                System.out.println("Health: " + soldier.get(4));
                System.out.println("Speed: " + soldier.get(5));

                return soldier;
            }
        }
        return null; // Return null if no match found
    }

}
