package monopoly;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Role {
    private char name;
    private int firstDiceRoll;
    private int position;
    private boolean quitGame=false;
    private int noOfMonsterEncounter;


    //if isLose is true , then the player is count as removed from the game, the player cannot play game if isLose is true
    ArrayList<String> item = new ArrayList<String>();
    ArrayList<String> weapon = new ArrayList<String>();
    //act as backpack of player , can add and remove item and weapon

    public Player(char name) {
        this.name=name; firstDiceRoll=0;position=0;
        item.add("Hi-Potion");
        item.add("Hi-Potion");
        item.add("Sword");
        noOfMonsterEncounter=0;

    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setFirstDiceRoll(int firstDiceRoll) {
        this.firstDiceRoll = firstDiceRoll;
    }
    public int getPosition(){
        return position;
    }

    //when get Item , will show the list of item added by player into his backpack
    public ArrayList<String> getItem() {
        return item;
    }

    public ArrayList<String> getWeapon() {
        return weapon;
    }

    public int rollDice(){
        Random r=new Random();
        int max=6;
        return r.nextInt(max)+1;
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

    //properties that inherited from abstract class Role
    public String toString() {
        return "-----------------------"+ "\nlevel= " + level + "\nhp= " + hp + "\nstrength= " + strength +
                "\ndefence= " + defence + "\nagility= " + agility + "\nexp= " + exp +
                "\ngold= " + gold+ "\n-----------------------";
    }

    public char getName() {
        return name;
    }

    public int getFirstDiceRoll() {
        return firstDiceRoll;
    }

    public boolean isQuitGame() {
        return quitGame;
    }

    public void setQuitGame(boolean quitGame) {
        this.quitGame = quitGame;
    }

    //apply to the algorithm of item drop system, if %3==0, item drop
    public int getNoOfMonsterEncounter() {
        return noOfMonsterEncounter;
    }

    //accumulate after everytime succeeded in a battle
    public void setNoOfMonsterEncounter(int noOfMonsterEncounter) {
        this.noOfMonsterEncounter += noOfMonsterEncounter;
    }
}

