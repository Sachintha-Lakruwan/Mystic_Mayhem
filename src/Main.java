public class Main {
    public static void main(String[] args) {

        // initialize the existing player and his army
        Player whiteWolf = new Player("GeraltofRivia", "whitewolf", 215, 32);

        String[] troops = { "Ranger", "Squire", "Warlock", "Medic", "Dragon" };
        whiteWolf.createArmy(troops);
        whiteWolf.army.archer.setEquipment("Chainmail");
        whiteWolf.army.healer.setEquipment("Amulet");

        // register new player
        Player jacob = new Player("Jacob Lara", "jacob");

        // now, two players are created successfully. one of them is whitewolf and his
        // army is already created.
        // other one is Jacob, who was created by the user, and his army is yet to be
        // created

        whiteWolf.buyEquipment("Knight", "Chainmail");
        System.out.println(whiteWolf.army.knight.attack);

    }
}
