public class Equipment {

    String name;
    int price;
    int attack;
    int defence;
    int health;
    int speed;

    public Equipment(String name) {
        this.name = name;

        //get data from json file
        //hasitha
        this.price = 100;
        this.attack = 10;
        this.defence = 0;
        this.health = 0;
        this.speed = 9;
    }
}