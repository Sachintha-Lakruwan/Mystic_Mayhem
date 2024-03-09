import java.util.Objects;

public class Player {
    String name;
    String username;
    int id;
    int gold;
    int xp;
    Army army;

    public Player(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public Player(String name, String username, int gold, int xp) {
        this.name = name;
        this.username = username;
        this.gold = gold;
        this.xp = xp;
    }

    public void createArmy(String[] troops){
        this.army = new Army(troops);
    }

    public void buyArcher(String name){
        // check if the gold is enough for the purchase
        // if not print a error message
        // else reduce the gold
        this.army.archer = new Soldier(name);

    }
    // make this kind of methods for all the troops. make methods for sell troops also. so there should be 10 methods in total

    /*
    complete other 9 methods here



     */

    public void buyEquipment(String soldier, String equipment){
        // check if the gold is enough for the purchase
        // if not print a error message
        // else reduce the gold
        if (Objects.equals(soldier, "Knight")){

            this.army.knight.setEquipment(equipment);
        }
        // complete other if statements for other 4 troops.
    }
    // create a method for sellEquipment
}
