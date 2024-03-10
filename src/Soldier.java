import java.util.List;

public class Soldier {

    String name;
    int price;
    int attack;
    int defence;
    int health;
    int speed;
    Equipment equipment;
    private static final DataBase database = new DataBase();

    public Soldier(String name, String category) {
        List<Object> soldierData=database.getSoldierData(name);

        this.equipment = null;


        if (soldierData != null) {
            this.name = (String) soldierData.get(0);
            this.price = (int) soldierData.get(1);
            this.attack = (int) soldierData.get(2);
            this.defence = (int) soldierData.get(3);
            this.health = (int) soldierData.get(4);
            this.speed = (int) soldierData.get(5);
        }
    }

    public void setEquipment(String equipmentName){
        Equipment equipment = new Equipment(equipmentName);

    }


}
