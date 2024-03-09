import java.util.Objects;

public class Army {
    String[] troops;

    Soldier archer;
    Soldier knight;
    Soldier mages;
    Soldier healer;
    Soldier mythical;

    public Army(String[] troops) {
        this.archer = new Soldier(troops[0]);
        this.knight = new Soldier(troops[1]);
        this.mages = new Soldier(troops[2]);
        this.healer = new Soldier(troops[3]);
        this.mythical = new Soldier(troops[4]);
    }

    public Army() {
    }

}
