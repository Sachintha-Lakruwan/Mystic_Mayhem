import java.util.Objects;

public class Army {
    String[] troops;

    Soldier archer;
    Soldier knight;
    Soldier mage;
    Soldier healer;
    Soldier mythical;

    public Army(String[] troops) {
        this.archer = new Soldier(troops[0], "Archer");
        this.knight = new Soldier(troops[1], "Knight");
        this.mage = new Soldier(troops[2], "Mages");
        this.healer = new Soldier(troops[3], "Healer");
        this.mythical = new Soldier(troops[4], "Mythical");
    }

    public Army() {
    }

}
