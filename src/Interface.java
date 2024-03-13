import java.util.Scanner;

public class Interface {
    //Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    Player player;
    DataBase db=new DataBase();
    public int registerPlayer() {
        int k = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Username Registration Interface");

        // Animation: Printing each line with a slight delay
        animatePrint("-----------------------------",ANSI_RED);
        animatePrint("Enter Your Name: ",ANSI_GREEN);
        String name = scanner.nextLine();
        animatePrint("Enter a Unique Username: ",ANSI_GREEN);
        String username = scanner.nextLine();

        if (!Player.players.contains(username)) {
            this.player = new Player(name, username); // Creating a new Player object
            System.out.println("Username '" + username + "' is available.");
            k = 1;
        } else {
            System.out.println("Sorry, the username '" + username + "' is already taken. Please choose another.");
        }
        return k;
    }

    // Method to print text with a slight delay
    private void animatePrint(String text, String color) {
        System.out.print(color);
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(20); // Adjust the delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(ANSI_RESET); // Reset color after printing
        System.out.println();
    }

    private void animatePrintFast(String text, String color) {
        System.out.print(color);
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(2); // Adjust the delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(ANSI_RESET); // Reset color after printing
        System.out.println();
    }
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
    public void createArmy(Player player){





        Scanner x=new Scanner(System.in);
        while(true) {


            db.getCategoryData("Archer");


            animatePrint("Select Your Archer....(Give index)",ANSI_GREEN);
            boolean res = false;

            int archer = x.nextInt();
            if (archer == 1) {
                res = player.buyArcher("Shooter");

            } else if (archer == 2) {
                res = player.buyArcher("Ranger");
            } else if (archer == 3) {
                res = player.buyArcher("Sunfire");
            } else if (archer == 4) {
                res = player.buyArcher("Zing");

            } else if (archer == 5) {
                res = player.buyArcher("Saggitarius");

            } else {
                animatePrint("Invalid index. Please enter a valid index.Recreate Army",ANSI_RED);
                res = false;

            }
            if (!res) {
                player.gold = 500;
                player.army = null;
                createArmy(player);
                break;
            }


            db.getCategoryData("Knight");
            animatePrint("Select Your Knight....(Give index)",ANSI_GREEN);


            int knight = x.nextInt();
            if (knight == 1) {
                res = player.buyKnight("Squire");
            } else if (knight == 2) {
                res = player.buyKnight("Cavalier");
            } else if (knight == 3) {
                res = player.buyKnight("Templar");
            } else if (knight == 4) {
                res = player.buyKnight("Zoro");
            } else if (knight == 5) {
                res = player.buyKnight("Swiftblade");
            } else {
                animatePrint("Invalid index. Please enter a valid index.Recreate Army",ANSI_RED);

                res = false;
            }
            if (!res) {
                player.gold = 500;
                player.army = null;
                createArmy(player);

                break;

            }


            db.getCategoryData("Mage");
            animatePrint("Select Your Mage....(Give index)",ANSI_GREEN);
            int mage = x.nextInt();
            if (mage == 1) {
                res = player.buyMage("Warlock");
            } else if (mage == 2) {
                res = player.buyMage("Illusionist");
            } else if (mage == 3) {
                res = player.buyMage("Enchanter");
            } else if (mage == 4) {
                res = player.buyMage("Conjurer");
            } else if (mage == 5) {
                res = player.buyMage("Eldritch");
            } else {
                animatePrint("Invalid index. Please enter a valid index.Recreate Army",ANSI_RED);
                res = false;
            }
            if (!res) {
                player.gold = 500;
                player.army = null;
                createArmy(player);

                break;

            }

            db.getCategoryData("Healer");
            animatePrint("Select Your Healer....(Give index)",ANSI_GREEN);
            int healer = x.nextInt();
            if (healer == 1) {
                res = player.buyHealer("Soother");
            } else if (healer == 2) {
                res = player.buyHealer("Medic");
            } else if (healer == 3) {
                res = player.buyHealer("Alchemist");

            } else if (healer == 4) {
                res = player.buyHealer("Saint");
            } else if (healer == 5) {
                res = player.buyHealer("Lightbringer");
            } else {

                animatePrint("Invalid index. Please enter a valid index.Recreate Army",ANSI_RED);
                res = false;
            }
            if (!res) {
                player.gold = 500;
                player.army = null;
                createArmy(player);

                break;

            }

            db.getCategoryData("Mythical");
            animatePrint("Select Your Mythical....(Give index)",ANSI_GREEN);
            int mythical = x.nextInt();
            if (mythical == 1) {
                res = player.buyMythicalCreature("Dragon");
            } else if (mythical == 2) {
                res = player.buyMythicalCreature("Basilisk");
            } else if (mythical == 3) {
                res = player.buyMythicalCreature("Hydra");
            } else if (mythical == 4) {
                res = player.buyMythicalCreature("Phoenix");
            } else if (mythical == 5) {
                res = player.buyMythicalCreature("Pegasus");
            } else {
                animatePrint("Invalid index. Please enter a valid index.Recreate Army",ANSI_RED);
                res = false;
            }
            if (!res) {
                player.gold = 500;
                player.army = null;
                createArmy(player);

                break;

            }
            else{
                break;
            }

        }


    }
    public void printArmy(){
        animatePrintFast("Creating Your Army..........",ANSI_PURPLE);

        System.out.println();


        animatePrintFast("╔═══════════════════════════════════════════╗", ANSI_CYAN);
        animatePrintFast("║                YOUR ARMY                  ║", ANSI_YELLOW);
        animatePrint("╚═══════════════════════════════════════════╝", ANSI_CYAN);

        animatePrintFast("┌───────────────┬───────────────────────────┐", ANSI_GREEN);
        animatePrintFast("│  Unit Type    │          Name             │", ANSI_GREEN);
        animatePrintFast("├───────────────┼───────────────────────────┤", ANSI_GREEN);
        animatePrintFast("│    Archer     │ " + padRight(player.army.archer.name, 25) + " │", ANSI_RED);
        animatePrintFast("│    Knight     │ " + padRight(player.army.knight.name, 25) + " │", ANSI_RED);
        animatePrintFast("│     Mage      │ " + padRight(player.army.mage.name, 25) + " │", ANSI_RED);
        animatePrintFast("│    Healer     │ " + padRight(player.army.healer.name, 25) + " │", ANSI_RED);
        animatePrintFast("│   Mythical    │ " + padRight(player.army.mythical.name, 25) + " │", ANSI_RED);
        animatePrintFast("└───────────────┴───────────────────────────┘", ANSI_GREEN);
    }


}







