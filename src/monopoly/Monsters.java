package monopoly;

public class Monsters extends Role {

    public Monsters(){

    }

    public Monsters(String name, int level, int hp, int strength, int defence, int agility) {
        super(name, level, hp, strength, defence, agility);
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
