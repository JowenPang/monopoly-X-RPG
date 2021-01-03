package monopoly;

public class Monsters extends Role {

    public Monsters(){

    }

    public Monsters(String name, int level, int hp, int strength, int defence, int agility) {
        super(name, level, hp, strength, defence, agility);
    }

    @Override
    public int attack(int a, int b){
        System.out.println("--> Monster's turn to attack <--");
        int damage = a*(10/(2+b));
        return damage;
    }

    @Override
    public void item(){
    }

    @Override
    public void flee(){
    }

    @Override
    public String toString() {
        return name+"Monsters level=" + level +
                "\nhp= " + hp +
                "\nstrength= " + strength +
                "\ndefence= " + defence +
                "\nagility= " + agility;
    }
}
