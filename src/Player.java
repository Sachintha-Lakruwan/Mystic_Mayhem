import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    protected String name;
    protected String username;
    protected int id;
    protected int gold;
    protected int xp;
    // protected HomeGround homeGround;
    protected Army army;

    static DataBase db = new DataBase();
    static List<String> players = new ArrayList<>();

    // static String players[] = { null, null };
    private static int nextId = 1;

    // global variable to store usernames
    public boolean isUsernameTaken(String username) {
        for (String player : players) {
            if (player == username) {
                return true;
            }
        }
        return false;
    }

    public void addUsername(String username) {
        players.add(username);
    }

    public int generateUniqueId() {
        return nextId++;
    }

    public Player(String name, String username) {
        // this.players = new ArrayList<>();

        // this.gold = 500;
        if (isUsernameTaken(username)) {
            System.out.println("Username '" + username + "' is already taken. Please choose another username.");
            // Handle the case where the username already exists, you can throw an exception
            // or handle it accordingly.
        } else {
            this.username = username;
            this.id = generateUniqueId();
            this.gold = 500;
            this.xp = 0;
            addUsername(username); // Add the player to the system
        }

    }

    public Player(String name, String username, int gold, int xp) {
        // this.players = new ArrayList<>();

        if (isUsernameTaken(username)) {
            System.out.println("Username '" + username + "' is already taken. Please choose another username.");

        } else {
            this.username = username;
            this.id = generateUniqueId();
            this.gold = 500;
            this.xp = 0;
            addUsername(username); // Add the player to the system
        }
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
            this.gold -= Obj1.price; // reduce the gold After buying the Archer

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
            System.out.println("Insufficient gold to buy an Knight.");
            return;
        } else {
            this.gold -= Obj2.price;

            if (army == null) {
                army = new Army();
            }

            this.army.knight = new Soldier(name, "Knight");
        }
    }

    public void buyMage(String name) {
        Soldier Obj3 = new Soldier("Knight", name);

        if (gold < Obj3.price) {
            System.out.println("Insufficient gold to buy an Mage.");
            return;
        } else {
            this.gold -= Obj3.price;

            if (army == null) {
                army = new Army();
            }

            this.army.mage = new Soldier(name, "Mage");
        }
    }

    public void buyHealer(String name) {
        Soldier Obj4 = new Soldier("Knight", name);

        if (gold < Obj4.price) {
            System.out.println("Insufficient gold to buy an Healer.");
            return;
        } else {
            this.gold -= Obj4.price;

            if (army == null) {
                army = new Army();
            }

            this.army.healer = new Soldier(name, "Healer");
        }
    }

    public void buyMythicalCreature(String name) {
        Soldier Obj5 = new Soldier("Knight", name);

        if (gold < Obj5.price) {
            System.out.println("Insufficient gold to buy an MythicalCreaturer.");
            return;
        } else {
            this.gold -= Obj5.price;

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

        if (gold < data[0]) { // check if the gold is enough for the purchase
            System.out.println("Insufficient gold to buy an " + equipment); // if not print a error message
            return;
        } else {
            this.gold -= data[0]; // else reduce the gold
            if (soldier == "Archer") {

                this.army.archer.setEquipment(equipment);
            }

            if (soldier == "Knight") {

                this.army.knight.setEquipment(equipment);
            }

            if (soldier == "Mage") {

                this.army.mage.setEquipment(equipment);
            }

            if (soldier == "Healer") {

                this.army.healer.setEquipment(equipment);
            }

            if (soldier == "Mythical") {

                this.army.mythical.setEquipment(equipment);
            }
        }

        // complete other if statements for other 4 troops.
    }
    // create a method for sellEquipment
}
