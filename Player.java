package monopoly;

import java.util.Random;

public class Player extends Role {
    char name;
    int firstDiceRoll;
    int position;

    public Player(char name) {
        this.name=name; firstDiceRoll=0;position=0;
    }
    
    public String toString() {
        return "level=" + level + ", hp=" + hp + ", strength=" + strength +
                ", defence=" + defence + ", agility=" + agility + ", exp=" + exp +
                ", gold=" + gold;
    }

    public int rollDice(){
        Random r=new Random();
        int max=6;
        return r.nextInt(max)+1;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition(){
        return position;
    }

    @Override
    public void attack(){
        System.out.println("fight monster");
        strength--;
    }

    @Override
    public void item(){
        System.out.println("sword, potion , smoke bomb");
    }

    @Override
    public void flee(){
        System.out.println("your turn is finish");
    }
}

