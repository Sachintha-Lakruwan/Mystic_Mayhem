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
        int[] soldierData = database.getSoldierData(name);

        this.equipment = null;

        if (soldierData != null) {
            this.name = name;
            this.price = soldierData[0];
            this.attack = soldierData[1];
            this.defence = soldierData[2];
            this.health = soldierData[3];
            this.speed = soldierData[4];
        }
    }

    public void setEquipment(String equipmentName) {
        this.equipment = new Equipment(equipmentName);

    }

}
