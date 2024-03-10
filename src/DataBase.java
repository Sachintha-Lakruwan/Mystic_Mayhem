import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

    List<List<Object>> equipmentList;
    List<List<Object>> soldiersData;

    // Constructor to initialize the equipment list with data
    public DataBase() {
        equipmentList = new ArrayList<>();
        soldiersData=new ArrayList<>();

        // Add data to the equipment list
        equipmentList.add(Arrays.asList("Chainmail", 70, 0, 1, 0, -1));
        equipmentList.add(Arrays.asList("Excalibur", 150, 2, 0, 0, 0));
        equipmentList.add(Arrays.asList("Regalia", 105, 0, 1, 0, 0));
        equipmentList.add(Arrays.asList("Amulet", 200, 1, -1, 1, 1));
        equipmentList.add(Arrays.asList("Fleece", 150, 0, 2, 1, -1));
        equipmentList.add(Arrays.asList("Crystal", 210, 2, 1, -1, -1));

        // Add data to the soldier list

        soldiersData.add(Arrays.asList("Shooter", 80, 11, 4, 6, 9));
        soldiersData.add(Arrays.asList("Squire", 85, 8, 9, 7, 8));
        soldiersData.add(Arrays.asList("Warlock", 100, 12, 7, 10, 12));
        soldiersData.add(Arrays.asList("Soother", 95, 10, 8, 9, 6));
        soldiersData.add(Arrays.asList("Dragon", 120, 12, 14, 15, 8));
        soldiersData.add(Arrays.asList("Ranger", 115, 14, 5, 8, 10));
        soldiersData.add(Arrays.asList("Cavalier", 110, 10, 12, 7, 10));
        soldiersData.add(Arrays.asList("Illusionist", 120, 13, 8, 12, 14));
        soldiersData.add(Arrays.asList("Medic", 125 , 12, 9, 10, 7));
        soldiersData.add(Arrays.asList("Basilisk", 165, 15, 11, 10, 12));
        soldiersData.add(Arrays.asList("Sunfire", 160, 15, 5, 7, 14));
        soldiersData.add(Arrays.asList("Templar", 155, 14, 16, 12, 12));
        soldiersData.add(Arrays.asList("Enchanter", 160, 16, 10, 13, 16));
        soldiersData.add(Arrays.asList("Alchemist", 150, 13, 13, 13, 13));
        soldiersData.add(Arrays.asList("Hydra", 205, 12, 16, 15, 11));
        soldiersData.add(Arrays.asList("Zing", 200, 16, 9, 11, 14));
        soldiersData.add(Arrays.asList("Zoro", 180, 17, 16, 13, 14));
        soldiersData.add(Arrays.asList("Conjurer", 195, 18, 15, 14, 12));
        soldiersData.add(Arrays.asList("Saint", 200, 16, 14, 17, 9));
        soldiersData.add(Arrays.asList("Phoenix", 275, 17, 13, 17, 19));
    }




    // Method to get soldier data by name
    public int[] getEquipmentData(String name) {
        for (List<Object> soldier : equipmentList) {
            if (name.equals(soldier.get(0))) {
                int price = (int) soldier.get(1);
                int attack = (int) soldier.get(2);
                int defence = (int) soldier.get(3);
                int health = (int) soldier.get(4);
                int speed = (int) soldier.get(5);
                int[] data = {price, attack, defence, health, speed};
                return data;
            }
        }
        return null; // Return null if no match found
    }
    public int[] getSoldierData(String name) {
        for (List<Object> soldier : soldiersData) {

            if (name.equals(soldier.get(0))) {
                int price = (int) soldier.get(1);
                int attack = (int) soldier.get(2);
                int defence = (int) soldier.get(3);
                int health = (int) soldier.get(4);
                int speed = (int) soldier.get(5);
                int[] data = {price, attack, defence, health, speed};
                return data;
            }
        }
        return null; // Return null if no match found
    }

}