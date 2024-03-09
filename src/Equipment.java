import java.util.List;
import java.util.Objects;

public class Equipment {

    String name;
    int price;
    int attack;
    int defence;
    int health;
    int speed;

    public Equipment(String name) {
        DataBase database = new DataBase();
        List<Object> soldierData = database.getSoldierData(name);

        // Check if soldier data is found
        if (soldierData != null) {
            this.name = (String) soldierData.get(0);
            this.price = (int) soldierData.get(1);
            this.attack = (int) soldierData.get(2);
            this.defence = (int) soldierData.get(3);
            this.health = (int) soldierData.get(4);
            this.speed = (int) soldierData.get(5);
        }
    }


}



