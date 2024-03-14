import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Battle {

    Combact showResult = new Combact();

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

    ArrayList<String> Highlanders = new ArrayList<String>();
    ArrayList<String> Marshlanders = new ArrayList<String>();
    ArrayList<String> Sunchildren = new ArrayList<String>();
    ArrayList<String> Mystics = new ArrayList<String>();

    // Constructor
    public Battle() {

        Highlanders.add("Shooter");
        Highlanders.add("Ranger");
        Highlanders.add("Cavalier");
        Highlanders.add("Zoro");
        Highlanders.add("Enchanter");
        Highlanders.add("Conjurer");
        Highlanders.add("Medic");

        Marshlanders.add("Squire");
        Marshlanders.add("Swiftblade");
        Marshlanders.add("Warlock");
        Marshlanders.add("Alchemist");
        Marshlanders.add("Basilisk");
        Marshlanders.add("Hydra");

        Sunchildren.add("Sunfire");
        Sunchildren.add("Zing");
        Sunchildren.add("Templar");
        Sunchildren.add("Soother");
        Sunchildren.add("Lightbringer");
        Sunchildren.add("Dragon");
        Sunchildren.add("Phoenix");

        Mystics.add("Saggitarius");
        Mystics.add("Illusionist");
        Mystics.add("Eldritch");
        Mystics.add("Saint");
        Mystics.add("Pegasus");

    }

//    private void UpdatePlayers(Player player, List<String> highlanders, List<String> marshlanders,
//                               List<String> sunchildren, List<String> mystics){
//
//    }

    public void HilCrest(Player challenger, Player accepter) {
        // Apply modifiers for each soldier type
        applyModifiersHilCrest(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
        Fight(challenger, accepter, "HilCrest");
    }

    private void applyModifiersHilCrest(Soldier soldier, List<String> highlanders, List<String> marshlanders,
                                        List<String> sunchildren, List<String> mystics) {
        // Apply attack and defense modifiers for Highlanders
        if (highlanders.contains(soldier.name)) {

            soldier.attack += 1;
            soldier.defence += 1;
        }
        // Apply speed modifier for Marshlanders and Sunchildren
        if (marshlanders.contains(soldier.name) || sunchildren.contains(soldier.name)) {
            soldier.speed -= 1;

        }
    }

    public void MarshLand(Player challenger, Player accepter) {
        // Apply modifiers for each soldier type
        applyModifiersMarshLand(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
        Fight(challenger, accepter, "MarshLand");

    }

    private void applyModifiersMarshLand(Soldier soldier, List<String> highlanders, List<String> marshlanders,
                                         List<String> sunchildren, List<String> mystics) {
        if (marshlanders.contains(soldier.name)) {
            soldier.defence += 2;
        }
        // Apply speed modifier for Marshlanders and Sunchildren
        if (sunchildren.contains(soldier.name)) {
            soldier.attack -= 1;
        }

        if (mystics.contains(soldier.name)) {
            soldier.speed -= 1;
        }
    }

    public void Desert(Player challenger, Player accepter) {
        // Apply modifiers for each soldier type
        applyModifiersDesert(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
        Fight(challenger, accepter, "Desert");

    }

    private void applyModifiersDesert(Soldier soldier, List<String> highlanders, List<String> marshlanders,
                                      List<String> sunchildren, List<String> mystics) {
        if (marshlanders.contains(soldier.name)) {
            soldier.health -= 1;
        }
        // Apply speed modifier for Marshlanders and Sunchildren
        if (sunchildren.contains(soldier.name)) {
            soldier.attack -= 1;
        }
    }

    public void Arcane(Player challenger, Player accepter) {
        System.out.println("Battle in Arcane");

        // Apply modifiers for each soldier type
        applyModifiersArcane(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersArcane(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
        Fight(challenger, accepter, "Arcane");

    }

    private void applyModifiersArcane(Soldier soldier, List<String> highlanders, List<String> marshlanders,
                                      List<String> sunchildren, List<String> mystics) {
        if (highlanders.contains(soldier.name)) {
            soldier.speed -= 1;
            soldier.defence -= 1;
        }
        // Apply speed modifier for Marshlanders and Sunchildren
        if (mystics.contains(soldier.name)) {
            soldier.speed += 2;

        }
    }

    private void Fight(Player challenger, Player accepter, String ground){
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
                if (ground == "Arcane"){

                }
            } else {
                accepterArmy[acceptorsIndex].health -= 0.5 * challengerArmy[challengersIndex].attack - 0.1 * accepterArmy[acceptorsIndex].defence;
                accepterArmy = RemoveDeadSoldiers(accepterArmy);
                army1Size = accepterArmy.length;
            }

            showResult.showStat("sachintha", "lakruwan", challengerArmy[challengersIndex], accepterArmy[acceptorsIndex], 10, 15);

            if (accepterArmy.length == 0) {
                showResult.showWinner(false);
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

            showResult.showStat("lakruwan", "sachintha", accepterArmy[acceptorsIndex],challengerArmy[challengersIndex], 15, 10);

            if (challengerArmy.length == 0) {
                showResult.showWinner(true);
                return;
            }
        }
        System.out.println("---Match Drawn---");
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
