public class Equipment {

    String name;
    int price;
    int attack;
    int defence;
    int health;
    int speed;
    static DataBase database = new DataBase();

    public Equipment(String name) {

        int[] EquipmentData = database.getEquipmentData(name);

        // Check if soldier data is found
        if (EquipmentData != null) {
            this.name = name;
            this.price = EquipmentData[0];
            this.attack = EquipmentData[1];
            this.defence = EquipmentData[2];
            this.health = EquipmentData[3];
            this.speed = EquipmentData[4];
        }
    }
}
