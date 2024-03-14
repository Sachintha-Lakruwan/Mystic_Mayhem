public class Main {
    public static void main(String[] args) {
        GameName game=new GameName();
        game.gameStart();

        //initialise default player
        Player whiteWolf = new Player("GeraltofRivia", "whitewolf", 215, 32);
        String[] troops = { "Ranger", "Squire", "Warlock", "Medic", "Dragon" };
        whiteWolf.createArmy(troops);
        whiteWolf.army.archer.setEquipment("Chainmail");
        whiteWolf.army.healer.setEquipment("Amulet");

        Interface test=new Interface();

        //register user as a player
        test.registerPlayer();
        Player player=test.player;
        test.createArmy(player);
        test.doYouWantBuyEquipment(player);
        test.printArmy(player);

        //Whitewolf is challenging you! What are you gonna do?
        //1. Accept the challenge
        //2. View player army
        //3. Decline the challenge

        //choose a ground you like:
        //1. HilCrest
        //2.
        //3.
        //4.

        boolean challengeAccepted = test.defaultPlayer(whiteWolf);
        String ground = test.selectHomeLand();


        Battle battleField = new Battle();
        if (challengeAccepted){
            battleField.Challenge(whiteWolf, player, ground);
        }

    }
}