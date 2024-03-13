public class Battle {
    public void Challege(Player challenger, Player accepter, String ground){
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

    }
    public void MarshLand(Player challenger, Player accepter){

    }
    public void Desert(Player challenger, Player accepter){

    }
    public void Arcane(Player challenger, Player accepter){

    }
}
