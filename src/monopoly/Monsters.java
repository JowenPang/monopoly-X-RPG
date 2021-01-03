package monopoly;

public class Monsters extends Role {

    public Monsters(String name, int level, int hp, int strength, int defence, int agility) {
        super(name, level, hp, strength, defence, agility);
    }

    @Override
    public int attack(int a, int b){
        return a*(25/(2+b));
    }

    @Override
    public void item(){
    }

    @Override
    public void flee(){
    }

    @Override
    public String toString() {
        return "You met " +name+"!\nMonsters level=" + level +
                "\nhp= " + hp +
                "\nstrength= " + strength +
                "\ndefence= " + defence +
                "\nagility= " + agility;
    }
}
