package monopoly;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Role {
    char name;
    int firstDiceRoll;
    int position;

    public ArrayList<String> getItem() {
        return item;
    }

    public ArrayList<String> getWeapon() {
        return weapon;
    }

    ArrayList<String> item = new ArrayList<String>();
    ArrayList<String> weapon = new ArrayList<String>();


    public String toString() {
        return "-----------------------"+ "\nlevel= " + level + "\nhp= " + hp + "\nstrength= " + strength +
                "\ndefence= " + defence + "\nagility= " + agility + "\nexp= " + exp +
                "\ngold= " + gold+ "\n-----------------------";
    }

    public Player(char name) {
        this.name=name; firstDiceRoll=0;position=0;
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

    public char getName() {
        return name;
    }
}

