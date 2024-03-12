import java.util.Objects;

public class Player {
    String name;
    String username;
    int id;
    int gold;
    int xp;
    Army army;
    static DataBase db = new DataBase();
    // global variable to store usernames

    public Player(String name, String username) {
        this.name = name;
        // check if the username exists
        this.username = username;
        // if user exists return null
        // print the error

        this.gold = 500;

    }

    public Player(String name, String username, int gold, int xp) {
        this.name = name;
        this.username = username;
        this.gold = gold;
        this.xp = xp;
    }

    public void createArmy(String[] troops) {
        this.army = new Army(troops);
    }

    public void buyArcher(String name) {
        Soldier Obj1 = new Soldier("Archer", name);

        // check if the gold is enough for the purchase
        // if not print a error message
        // else reduce the gold

        if (gold < Obj1.price) {
            System.out.println("Insufficient gold to buy an Archer.");
            return; // Exit the method if there's not enough gold
        } else {
            gold -= Obj1.price; // reduce the gold After buying the Archer

            // Create a new Archer soldier and assign it to the player's army
            if (army == null) {
                army = new Army(); // Initialize the army if it's not already initialized
            }

            this.army.archer = new Soldier(name, "Archer");
        }

    }

    public void buyKnight(String name) {
        Soldier Obj2 = new Soldier("Knight", name);

        if (gold < Obj2.price) {
            System.out.println("Insufficient gold to buy an Archer.");
            return;
        } else {
            gold -= Obj2.price;

            if (army == null) {
                army = new Army();
            }

            this.army.knight = new Soldier(name, "Knight");
        }
    }

    public void buyMage(String name) {
        Soldier Obj3 = new Soldier("Knight", name);

        if (gold < Obj3.price) {
            System.out.println("Insufficient gold to buy an Archer.");
            return;
        } else {
            gold -= Obj3.price;

            if (army == null) {
                army = new Army();
            }

            this.army.mage = new Soldier(name, "Mage");
        }
    }

    public void buyHealer(String name) {
        Soldier Obj4 = new Soldier("Knight", name);

        if (gold < Obj4.price) {
            System.out.println("Insufficient gold to buy an Archer.");
            return;
        } else {
            gold -= Obj4.price;

            if (army == null) {
                army = new Army();
            }

            this.army.healer = new Soldier(name, "Healer");
        }
    }

    public void buyMythicalCreature(String name) {
        Soldier Obj5 = new Soldier("Knight", name);

        if (gold < Obj5.price) {
            System.out.println("Insufficient gold to buy an Archer.");
            return;
        } else {
            gold -= Obj5.price;

            if (army == null) {
                army = new Army();
            }

            this.army.mythical = new Soldier(name, "MythicalCreature");
        }
    }
    // make this kind of methods for all the troops. make methods for sell troops
    // also. so there should be 10 methods in total

    /*
     * complete other 9 methods here
     * 
     * 
     * 
     */

    // whitewolf.buyEquipment("knight", "name")
    public void buyEquipment(String soldier, String equipment) {
        int[] data = db.getEquipmentData(equipment);
        // check if the gold is enough for the purchase
        // if not print a error message
        // else reduce the gold
        if (soldier == "Knight") {

            this.army.knight.setEquipment(equipment);
        }
        // complete other if statements for other 4 troops.
    }
    // create a method for sellEquipment
}
