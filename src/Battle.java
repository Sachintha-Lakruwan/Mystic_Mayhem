import java.util.ArrayList;
import java.util.List;

public class Battle {
    public void Challenge(Player challenger, Player accepter, String ground) {
        if (ground == "Desert") {
            Desert(challenger, accepter);
        } else if (ground == "MarshLand") {
            MarshLand(challenger, accepter);
        } else if (ground == "HilCrest") {
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

    public void HilCrest(Player challenger, Player accepter) {
        System.out.println("Battle in HilCrest");

        // Apply modifiers for each soldier type
        applyModifiersHilCrest(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersHilCrest(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
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
        System.out.println("Battle in MarshLand");

        // Apply modifiers for each soldier type
        applyModifiersMarshLand(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersMarshLand(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
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
        System.out.println("Battle in Desert");

        // Apply modifiers for each soldier type
        applyModifiersDesert(challenger.army.archer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.knight, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.mage, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.healer, Highlanders, Marshlanders, Sunchildren, Mystics);
        applyModifiersDesert(challenger.army.mythical, Highlanders, Marshlanders, Sunchildren, Mystics);
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

}

// System.out.println("Name " + soldier.name);
// System.out.println("Attack " + soldier.attack);
// System.out.println("Defence " + soldier.defence);
// System.out.println("Health " + soldier.health);
// System.out.println("Speed " + soldier.speed);
// System.out.println("-----------------------------");

// public void HilCrest(Player challenger, Player accepter) {
// System.out.println("Battle in HilCrest");
// int x = 0;
// for(String i : Highlanders){
// if(challenger.army.archer.name == i ){
// challenger.army.archer.attack += 1;
// challenger.army.archer.defence += 1;
// x=1;
// break;
// }
// }
// if(x != 0){
// for(String i : Marshlanders){
// if(challenger.army.archer.name == i ){
// challenger.army.archer.speed -= 1;
// x=2;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Sunchildren){
// if(challenger.army.archer.name == i ){
// challenger.army.archer.speed -= 1;
// x=3;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Mystics){
// if(challenger.army.archer.name == i ){
// x=4;
// break;
// }
// }
// }

// int y = 0;
// for(String i : Highlanders){
// if(challenger.army.archer.name == i ){
// challenger.army.archer.attack += 1;
// challenger.army.archer.defence += 1;
// y=1;
// break;
// }
// }
// if(y != 0){
// for(String i : Marshlanders){
// if(challenger.army.archer.name == i ){
// challenger.army.archer.speed -= 1;
// y=2;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Sunchildren){
// if(challenger.army.archer.name == i ){
// challenger.army.archer.speed -= 1;
// y=3;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Mystics){
// if(challenger.army.archer.name == i ){
// y=4;
// break;
// }
// }
// }
// //----------------------------------------------------------------------------------------
// x = 0;
// for(String i : Highlanders){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.attack += 1;
// challenger.army.knight.defence += 1;
// x=1;
// break;
// }
// }
// if(x != 0){
// for(String i : Marshlanders){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.speed -= 1;
// x=2;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Sunchildren){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.speed -= 1;
// x=3;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Mystics){
// if(challenger.army.knight.name == i ){
// x=4;
// break;
// }
// }
// }

// y = 0;
// for(String i : Highlanders){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.attack += 1;
// challenger.army.knight.defence += 1;
// y=1;
// break;
// }
// }
// if(y != 0){
// for(String i : Marshlanders){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.speed -= 1;
// y=2;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Sunchildren){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.speed -= 1;
// y=3;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Mystics){
// if(challenger.army.knight.name == i ){
// y=4;
// break;
// }
// }
// }
// //-------------------------------------------------------------------

// x = 0;
// for(String i : Highlanders){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.attack += 1;
// challenger.army.knight.defence += 1;
// x=1;
// break;
// }
// }
// if(x != 0){
// for(String i : Marshlanders){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.speed -= 1;
// x=2;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Sunchildren){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.speed -= 1;
// x=3;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Mystics){
// if(challenger.army.knight.name == i ){
// x=4;
// break;
// }
// }
// }

// y = 0;
// for(String i : Highlanders){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.attack += 1;
// challenger.army.knight.defence += 1;
// y=1;
// break;
// }
// }
// if(y != 0){
// for(String i : Marshlanders){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.speed -= 1;
// y=2;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Sunchildren){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.speed -= 1;
// y=3;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Mystics){
// if(challenger.army.knight.name == i ){
// y=4;
// break;
// }
// }
// }

// //-------------------------------------------------------------------

// x = 0;
// for(String i : Highlanders){
// if(challenger.army.mage.name == i ){
// challenger.army.mage.attack += 1;
// challenger.army.mage.defence += 1;
// x=1;
// break;
// }
// }
// if(x != 0){
// for(String i : Marshlanders){
// if(challenger.army.mage.name == i ){
// challenger.army.mage.speed -= 1;
// x=2;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Sunchildren){
// if(challenger.army.mage.name == i ){
// challenger.army.mage.speed -= 1;
// x=3;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Mystics){
// if(challenger.army.mage.name == i ){
// x=4;
// break;
// }
// }
// }

// y = 0;
// for(String i : Highlanders){
// if(challenger.army.mage.name == i ){
// challenger.army.mage.attack += 1;
// challenger.army.mage.defence += 1;
// y=1;
// break;
// }
// }
// if(y != 0){
// for(String i : Marshlanders){
// if(challenger.army.mage.name == i ){
// challenger.army.mage.speed -= 1;
// y=2;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Sunchildren){
// if(challenger.army.mage.name == i ){
// challenger.army.mage.speed -= 1;
// y=3;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Mystics){
// if(challenger.army.mage.name == i ){
// y=4;
// break;
// }
// }
// }

// //-------------------------------------------------------------------

// x = 0;
// for(String i : Highlanders){
// if(challenger.army.healer.name == i ){
// challenger.army.healer.attack += 1;
// challenger.army.healer.defence += 1;
// x=1;
// break;
// }
// }
// if(x != 0){
// for(String i : Marshlanders){
// if(challenger.army.healer.name == i ){
// challenger.army.healer.speed -= 1;
// x=2;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Sunchildren){
// if(challenger.army.healer.name == i ){
// challenger.army.healer.speed -= 1;
// x=3;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Mystics){
// if(challenger.army.healer.name == i ){
// x=4;
// break;
// }
// }
// }

// y = 0;
// for(String i : Highlanders){
// if(challenger.army.healer.name == i ){
// challenger.army.healer.attack += 1;
// challenger.army.healer.defence += 1;
// y=1;
// break;
// }
// }
// if(y != 0){
// for(String i : Marshlanders){
// if(challenger.army.knight.name == i ){
// challenger.army.knight.speed -= 1;
// y=2;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Sunchildren){
// if(challenger.army.healer.name == i ){
// challenger.army.healer.speed -= 1;
// y=3;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Mystics){
// if(challenger.army.healer.name == i ){
// y=4;
// break;
// }
// }
// }

// //-------------------------------------------------------------------

// x = 0;
// for(String i : Highlanders){
// if(challenger.army.mythical.name == i ){
// challenger.army.mythical.attack += 1;
// challenger.army.mythical.defence += 1;
// x=1;
// break;
// }
// }
// if(x != 0){
// for(String i : Marshlanders){
// if(challenger.army.mythical.name == i ){
// challenger.army.mythical.speed -= 1;
// x=2;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Sunchildren){
// if(challenger.army.mythical.name == i ){
// challenger.army.mythical.speed -= 1;
// x=3;
// break;
// }
// }
// }
// if(x != 0){
// for(String i : Mystics){
// if(challenger.army.mythical.name == i ){
// x=4;
// break;
// }
// }
// }

// y = 0;
// for(String i : Highlanders){
// if(challenger.army.mythical.name == i ){
// challenger.army.mythical.attack += 1;
// challenger.army.mythical.defence += 1;
// y=1;
// break;
// }
// }
// if(y != 0){
// for(String i : Marshlanders){
// if(challenger.army.mythical.name == i ){
// challenger.army.mythical.speed -= 1;
// y=2;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Sunchildren){
// if(challenger.army.mythical.name == i ){
// challenger.army.mythical.speed -= 1;
// y=3;
// break;
// }
// }
// }
// if(y != 0){
// for(String i : Mystics){
// if(challenger.army.mythical.name == i ){
// y=4;
// break;
// }
// }
// }

// }