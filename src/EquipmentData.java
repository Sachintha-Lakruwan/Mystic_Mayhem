import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquipmentData {
    public static List<List<Object>> data() {
        List<List<Object>> equipmentList = new ArrayList<>();

        equipmentList.add(Arrays.asList("Chainmail", 70, 0, 1, 0, -1));
        equipmentList.add(Arrays.asList("Excalibur", 150, 2, 0, 0, 0));
        equipmentList.add(Arrays.asList("Regalia", 105, 0, 1, 0, 0));
        equipmentList.add(Arrays.asList("Amulet", 200, 1, -1, 1, 1));
        equipmentList.add(Arrays.asList("Fleece", 150, 0, 2, 1, -1));
        equipmentList.add(Arrays.asList("Crystal", 210, 2, 1, -1, -1));

        return equipmentList;

        // Print the 2D list


        // Now you have the 2D list assigned to the variable equipmentList
        // You can use equipmentList for further processing
    }
}
