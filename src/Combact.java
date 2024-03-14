public class Combact {
    GameName game=new GameName();
    public void showStat(String attackingPlayer, Soldier attacker, Soldier defender) {
        // Print winner
        System.out.println("Winner: " + attackingPlayer);

        // Print attacker's attack on defender
        System.out.println(attacker.name + " attacks " + defender.name);

        // Print health before attack
        System.out.println("Defence:");
        System.out.println("+----------------+----------------+");
        System.out.println("|    Attacker    |    Defender    |");
        System.out.println("+----------------+----------------+");
        System.out.printf("|%10.2f      |%10.2f      |%n", attacker.defence, defender.defence);
        System.out.println("+----------------+----------------+");

        // Check if defender's health is zero or negative
        if (defender.health <= 0) {
            System.out.println(defender.name + " Died");
        }

        // Print health after attack
        System.out.println("Health after attack:");
        System.out.println("+----------------+----------------+");
        System.out.println("|    Attacker    |    Defender    |");
        System.out.println("+----------------+----------------+");
        System.out.printf("|%10.2f      |%10.2f      |%n", attacker.health, defender.health);
        System.out.println("+----------------+----------------+");
        System.out.println("Final XP:");
        System.out.println("+----------------+----------------+");
        System.out.println("|    Attacker    |    Defender    |");
        System.out.println("+----------------+----------------+");
        game.animatePrint("+----------------+----------------+",GameName.ANSI_RED);
    }



    public void showWinner(boolean winner) {
        if (winner) {
            String wonstate=
                    " _____                             _         _       _   _                 _ _ _  __   __                                _ _ _ \n" +
                            "/  __ \\                           | |       | |     | | (_)               | | | | \\ \\ / /                               | | | |\n" +
                            "| /  \\/ ___  _ __   __ _ _ __ __ _| |_ _   _| | __ _| |_ _  ___  _ __  ___| | | |  \\ V /___  _   _  __      _____  _ __ | | | |\n" +
                            "| |    / _ \\| '_ \\ / _` | '__/ _` | __| | | | |/ _` | __| |/ _ \\| '_ \\/ __| | | |   \\ // _ \\| | | | \\ \\ /\\ / / _ \\| '_ \\| | | |\n" +
                            "| \\__/\\ (_) | | | | (_| | | | (_| | |_| |_| | | (_| | |_| | (_) | | | \\__ \\_|_|_|   | | (_) | |_| |  \\ V  V / (_) | | | |_|_|_|\n" +
                            " \\____/\\___/|_| |_|\\__, |_|  \\__,_|\\__|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_|___(_|_|_)   \\_/\\___/ \\__,_|   \\_/\\_/ \\___/|_| |_(_|_|_)\n" +
                            "                    __/ |                                                                                                      \n" +
                            "                   |___/                                                                                                       \n";
            game.animatePrint(wonstate,GameName.ANSI_BLUE);
        }
        else{
            String loststatus=
                    "░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░      ░▒▓██████▓▒░ ░▒▓███████▓▒░▒▓████████▓▒░ \n" +
                            "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░        \n" +
                            "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░        \n" +
                            " ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓██████▓▒░   \n" +
                            "   ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░        \n" +
                            "   ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░     ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░        \n" +
                            "   ░▒▓█▓▒░    ░▒▓██████▓▒░ ░▒▓██████▓▒░       ░▒▓████████▓▒░▒▓██████▓▒░░▒▓███████▓▒░░▒▓████████▓▒░ \n" +
                            "                                                                                                   \n" +
                            "                                                                                                   \n";
            game.animatePrint(loststatus,GameName.ANSI_RED);
        }

    }
    public   void drawBattle(){
        String draw="\n" +
                "███╗   ███╗ █████╗ ████████╗ ██████╗██╗  ██╗    ██████╗ ██████╗  █████╗ ██╗    ██╗\n" +
                "████╗ ████║██╔══██╗╚══██╔══╝██╔════╝██║  ██║    ██╔══██╗██╔══██╗██╔══██╗██║    ██║\n" +
                "██╔████╔██║███████║   ██║   ██║     ███████║    ██║  ██║██████╔╝███████║██║ █╗ ██║\n" +
                "██║╚██╔╝██║██╔══██║   ██║   ██║     ██╔══██║    ██║  ██║██╔══██╗██╔══██║██║███╗██║\n" +
                "██║ ╚═╝ ██║██║  ██║   ██║   ╚██████╗██║  ██║    ██████╔╝██║  ██║██║  ██║╚███╔███╔╝\n" +
                "╚═╝     ╚═╝╚═╝  ╚═╝   ╚═╝    ╚═════╝╚═╝  ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚══╝╚══╝ \n" +
                "                                                                                  \n";
game.animatePrint(draw,GameName.ANSI_BLUE);
    }

}