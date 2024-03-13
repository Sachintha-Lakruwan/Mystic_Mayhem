import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<Integer> terminatedSoldiersChallenger = new ArrayList<>();
        ArrayList<Integer> terminatedSoldiersAcceptor = new ArrayList<>();

        int army1Size = challengerArmy.length;
        int army2Size = accepterArmy.length;
        int turns = 0;

        int challengersIndex;
        int acceptorsIndex;


        while (army1Size > 0 && army2Size > 0 && turns < 20) {

            turns++;

            if (terminatedSoldiersChallenger.size() == challengerArmy.length){
                terminatedSoldiersChallenger.clear();
            }

            if (terminatedSoldiersAcceptor.size() == accepterArmy.length){
                terminatedSoldiersAcceptor.clear();
            }

            //challenger attacks acceptor
            acceptorsIndex = LowestDefense(accepterArmy);
            challengersIndex = FastestPlayer(challengerArmy, terminatedSoldiersAcceptor);
            terminatedSoldiersChallenger.add(challengersIndex);

            if (challengerArmy[challengersIndex].category == "Healer"){
                int lowestChallengerHealth = LowestHealth(challengerArmy);
                challengerArmy[lowestChallengerHealth].health += 0.1 * challengerArmy[challengersIndex].attack;
            } else {
                accepterArmy[acceptorsIndex].health -= 0.5 * challengerArmy[challengersIndex].attack - 0.1 * accepterArmy[acceptorsIndex].defence;
                accepterArmy = RemoveDeadSoldiers(accepterArmy);
                army1Size = accepterArmy.length;
            }

            if (accepterArmy.length == 0) {
                //challenger won
                return;
            }

            // acceptor attacks challenger
            challengersIndex = LowestDefense(challengerArmy);
            acceptorsIndex = FastestPlayer(accepterArmy, terminatedSoldiersChallenger);
            terminatedSoldiersAcceptor.add(acceptorsIndex);

            if (accepterArmy[acceptorsIndex].category.equals("Healer")) {
                int lowestAcceptorHealth = LowestHealth(accepterArmy);
                accepterArmy[lowestAcceptorHealth].health += 0.1 * accepterArmy[acceptorsIndex].attack;
            } else {
                challengerArmy[challengersIndex].health -= 0.5 * accepterArmy[acceptorsIndex].attack - 0.1 * challengerArmy[challengersIndex].defence;
                challengerArmy = RemoveDeadSoldiers(challengerArmy);
                army2Size = challengerArmy.length;
            }

            if (challengerArmy.length == 0) {
                // acceptor won
                return;
            }
        }
        //draw
    }

    private int FastestPlayer(Soldier[] army, ArrayList<Integer> terminated){
        int n = army.length;
        int m = terminated.size();
        int maxIndex = 0;
        for (int i = 0; i < n; i++){
            boolean exists = false;

            for (int j = 0; j < m; j++) {
                if (terminated.get(j) == i) {
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

    private Soldier[] RemoveDeadSoldiers(Soldier[] army){
        Soldier[] temp = new Soldier[army.length]; // Initialize temp array with the same size as army
        int count = 0; // Initialize a counter for the valid soldiers in temp

        for (int i = 0; i < army.length; i++){
            if (army[i].health <= 5){
                continue; // Skip dead soldiers
            }
            temp[count] = army[i]; // Add alive soldiers to temp
            count++; // Increment the count of valid soldiers in temp
        }

        // Resize the temp array to contain only the valid soldiers
        Soldier[] result = new Soldier[count];
        System.arraycopy(temp, 0, result, 0, count);

        return result;
    }

}
