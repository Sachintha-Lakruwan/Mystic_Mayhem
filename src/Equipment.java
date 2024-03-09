import java.util.List;

public class Equipment {

    String name;
    int price;
    int attack;
    int defence;
    int health;
    int speed;

    public Equipment(String name) {
        this.name = name;

        // Retrieve the equipment list from the Data class
        List<List<Object>> equipmentList = EquipmentData.data();

        // Default values
        this.price = 0;
        this.attack = 0;
        this.defence = 0;
        this.health = 0;
        this.speed = 0;

        // Iterate over the 2D list to find a match
        for (List<Object> row : equipmentList) {
            if (name.equals(row.get(0))) {
                // Assign other details based on the matched row
                this.price = (int) row.get(1);
                this.attack = (int) row.get(2);
                this.defence = (int) row.get(3);
                this.health = (int) row.get(4);
                this.speed = (int) row.get(5);
                return; // Exit function after finding a match
            }
        }
    }

}
