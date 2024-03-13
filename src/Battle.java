public class Battle {
    public void Challenge(Player challenger, Player accepter, String ground){
        if (ground == "Desert"){
            Desert(challenger, accepter);
        } else if (ground == "MarshLand"){
            MarshLand(challenger, accepter);
        } else if (ground == "HilCrest"){
            HilCrest(challenger, accepter);
        } else {
            Arcane(challenger, accepter);
        }
    }
    public void HilCrest(Player challenger, Player accepter){
        Fight(challenger, accepter);
    }
    public void MarshLand(Player challenger, Player accepter){

    }
    public void Desert(Player challenger, Player accepter){

    }
    public void Arcane(Player challenger, Player accepter){

    }

    private void Fight(Player challenger, Player accepter){
        Soldier[] challengerArmy = {challenger.army.archer, challenger.army.knight, challenger.army.mage, challenger.army.healer, challenger.army.mythical};
        Soldier[] accepterArmy = {accepter.army.archer, accepter.army.knight, accepter.army.mage, accepter.army.healer, accepter.army.mythical};
        int[] terminatedSoldiersChallenger = {-1};
        int[] terminatedSoldiersAcceptor = {-1};

        int army1Size = challengerArmy.length;
        int army2Size = accepterArmy.length;
        int turns = 0;

        int challengersIndex;
        int acceptorsIndex;


        while (army1Size > 0 && army2Size > 0 && turns < 20) {
            turns++;
            acceptorsIndex = LowestDefense(accepterArmy);
            challengersIndex = FastestPlayer(challengerArmy, terminatedSoldiersAcceptor);
            if (challengerArmy[challengersIndex].category == "Healer"){
                int lowestChallengerHealth = LowestHealth(challengerArmy);
                challengerArmy[lowestChallengerHealth].health += 0.1 * 4;
            }
        }
    }

    private int FastestPlayer(Soldier[] army, int[] terminated){
        int n = army.length;
        int m = terminated.length;
        int maxIndex = 0;
        for (int i = 0; i < n; i++){
            boolean exists = false;

            for (int j = 0; j < m; j++) {
                if (terminated[j] == i) {
                    exists = true;
                    break;
                }
            }
            if (exists){
                continue;
            }
            if (army[i].speed > army[maxIndex].speed){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int LowestDefense(Soldier[] army){
        int n = army.length;
        int minIndex = 0;
        for (int i = 0; i < n; i++){
            if (army[i].defence < army[minIndex].defence){
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int LowestHealth(Soldier[] army){
        int n = army.length;
        int minIndex = 0;
        for (int i = 0; i < n; i++){
            if (army[i].health < army[minIndex].health){
                minIndex = i;
            }
        }
        return minIndex;
    }
}
