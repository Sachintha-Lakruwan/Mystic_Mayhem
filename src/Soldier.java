public class Soldier {

    String name;
    int price;
    int attack;
    int defence;
    int health;
    int speed;
    Equipment equipment;

    public Soldier(String name, String category) {
        this.name = name;
        this.equipment = null;

        //get data from json file
        //hasitha
        this.price = 100;
        this.attack = 10;
        this.defence = 5;
        this.health = 8;
        this.speed = 9;
    }

    public void setEquipment(String equipmentName){
        equipment = new Equipment(equipmentName);
    }
}
