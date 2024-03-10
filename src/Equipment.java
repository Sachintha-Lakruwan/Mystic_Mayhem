import java.util.List;
import java.util.Objects;

public class Equipment {

    String name;
    int price;
    int attack;
    int defence;
    int health;
    int speed;
    static  DataBase database = new DataBase();

    public Equipment(String name) {

        List<Object> EquipmentsoldierData = database.getEquipmentSoldierData(name);

        // Check if soldier data is found
        if (EquipmentsoldierData != null) {
            this.name = (String) EquipmentsoldierData.get(0);
            this.price = (int) EquipmentsoldierData.get(1);
            this.attack = (int) EquipmentsoldierData.get(2);
            this.defence = (int) EquipmentsoldierData.get(3);
            this.health = (int) EquipmentsoldierData.get(4);
            this.speed = (int) EquipmentsoldierData.get(5);
        }
    }


}