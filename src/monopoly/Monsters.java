package monopoly;

import java.io.Serializable;

public class Monsters extends Role implements Serializable {

    public Monsters(){

    }

    public Monsters(String name, int level, int hp, int strength, int defence, int agility) {
        super(name, level, hp, strength, defence, agility);
    }

    @Override
    public int attack(int a, int b) {
        return a * (35 / (5 + b));
        // a is monster's strength , b is player's defence
    }

    @Override
    public void item() {
    }

    @Override
    public void flee() {
    }

    @Override
    public String toString() {
        return "You met " + name + "!\nMonsters level=" + level +
                "\nhp= " + hp +
                "\nstrength= " + strength +
                "\ndefence= " + defence +
                "\nagility= " + agility;
    }
}
