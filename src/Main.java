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

        jacob.buyArcher("Shooter");
        jacob.buyKnight("Squire");
        jacob.buyMage("Warlock");
        jacob.buyHealer("Soother");
        jacob.buyMythicalCreature("Dragon");

        Battle battlefield = new Battle();

        battlefield.Challenge(whiteWolf, jacob, "HilCrest");
    }
}
