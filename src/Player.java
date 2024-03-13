import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    public static final String Army = null;
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

        if (gold < Obj1.price) {
            System.out.println("Insufficient gold to buy an Archer.");
            return; // Exit the method if there's not enough gold
        } else {
            this.gold -= Obj1.price; // reduce the gold After buying the Archer

            // Create a new Archer soldier and assign it to the player's army
            if (army == null) {
                army = new Army(); // Initialize the army if it's not already initialized
            }

            // this.army.archer = new Soldier("Archer", name);
            this.army.archer = Obj1;
        }

    }

    public void sellArcher() {
        if (army != null && army.archer != null) { // Check if the player has an Archer
            int sellValue = (int) (army.archer.price * 0.9); // Calculate sell value (90% of the price)

            // Add the sell value to the player's gold
            this.gold += sellValue;

            // Remove the Archer from the player's army
            this.army.archer = null;

            System.out.println("Archer sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have an Archer to sell.");
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

    public void sellKnight() {
        if (army != null && army.knight != null) {
            int sellValue = (int) (army.knight.price * 0.9);
            this.gold += sellValue;
            this.army.knight = null;
            System.out.println("Knight sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have a Knight to sell.");
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

    public void sellMage() {
        if (army != null && army.mage != null) {
            int sellValue = (int) (army.mage.price * 0.9);
            this.gold += sellValue;
            this.army.mage = null;
            System.out.println("Mage sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have a Mage to sell.");
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

    public void sellHealer() {
        if (army != null && army.healer != null) {
            int sellValue = (int) (army.healer.price * 0.9);
            this.gold += sellValue;
            this.army.healer = null;
            System.out.println("Healer sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have a Healer to sell.");
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

    public void sellMythicalCreature() {
        if (army != null && army.mythical != null) {
            int sellValue = (int) (army.mythical.price * 0.9);
            this.gold += sellValue;
            this.army.mythical = null;
            System.out.println("MythicalCreature sold successfully for " + sellValue + " gold.");
        } else {
            System.out.println("You don't have a MythicalCreature to sell.");
        }
    }

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
                this.army.archer.price += data[0];
                this.army.archer.attack += data[1];
                this.army.archer.defence += data[2];
                this.army.archer.health += data[3];
                this.army.archer.speed += data[4];

            }

            if (soldier == "Knight") {

                this.army.knight.setEquipment(equipment);
                this.army.knight.price += data[0];
                this.army.knight.attack += data[1];
                this.army.knight.defence += data[2];
                this.army.knight.health += data[3];
                this.army.knight.speed += data[4];
            }

            if (soldier == "Mage") {

                this.army.mage.setEquipment(equipment);
                this.army.mage.price += data[0];
                this.army.mage.attack += data[1];
                this.army.mage.defence += data[2];
                this.army.mage.health += data[3];
                this.army.mage.speed += data[4];
            }

            if (soldier == "Healer") {

                this.army.healer.setEquipment(equipment);
                this.army.healer.price += data[0];
                this.army.healer.attack += data[1];
                this.army.healer.defence += data[2];
                this.army.healer.health += data[3];
                this.army.healer.speed += data[4];
            }

            if (soldier == "Mythical") {

                this.army.mythical.setEquipment(equipment);
                this.army.mythical.price += data[0];
                this.army.mythical.attack += data[1];
                this.army.mythical.defence += data[2];
                this.army.mythical.health += data[3];
                this.army.mythical.speed += data[4];
            }
        }
    }
}
