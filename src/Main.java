public class Main {
    public static void main(String[] args) {
        GameName game=new GameName();
        game.gameStart();


        // ASCII art with light blue color

        /*

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

        jacob.buyArcher("Shooter");
        System.out.println(jacob.army.archer.defence);

        jacob.buyEquipment("Archer", "Chainmail");
        System.out.println(jacob.army.archer.defence);*/
        Interface test=new Interface();

        //test.registerplayer();


        test.registerPlayer();
        //layer player=new Player("has","san");
        Player player=test.player;
        test.createArmy(player);
        test.printArmy();

        //System.out.println(player.army.archer.name);
        //player.buyEquipment("Archer","Amulet");
        //System.out.println(player.army.archer.attack);
        test.player.army.archer=new Soldier("Zing","Archer");
        test.printArmy();



        //System.out.println(Player.players);


    }
}