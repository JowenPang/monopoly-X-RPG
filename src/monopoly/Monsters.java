package monopoly;

public class Monsters extends Role {

    public Monsters() {
    }

    @Override
    public void attack(){
        System.out.println("Monster's turn to attack");
    }

    @Override
    public void item(){
    }

    @Override
    public void flee(){
    }

    @Override
    public String toString() {
        return "Monsters level=" + level +
                "\nhp= " + hp +
                "\nstrength= " + strength +
                "\ndefence= " + defence +
                "\nagility= " + agility;
    }
}
