package monopoly;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player extends Role {
    private char name;
    private int firstDiceRoll;
    private int position;
    private boolean quitGame=false;
    private int noOfMonsterEncounter;
    Scanner sc=new Scanner(System.in);
    

    //if isLose is true , then the player is count as removed from the game, the player cannot play game if isLose is true
    ArrayList<String> item = new ArrayList<String>();
    ArrayList<String> weapon = new ArrayList<String>();
    //act as backpack of player , can add and remove item and weapon

    public Player(char name) {
        this.name=name; firstDiceRoll=0;position=0;
        item.add("Hi-Potion");
        item.add("Hi-Potion");
        item.add("Smoke bomb");
        weapon.add("Sword");
        weapon.add("Shield");
        weapon.add("Armor");
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
    public int attack(int a, int b){
        return a*(35/(5+b));
        // a is monster's strength , b is player's defence
    }

    @Override
    public void item(){
        System.out.println(getWeapon());
        System.out.println("Which weapon do you want to use?");
        String w=sc.next();
        if(weapon.contains(w)) {
            System.out.println("You are now using " + w);
            if(w.equalsIgnoreCase("Sword")) {
                System.out.println("Strength +3 , Defence +10 , Hp +8");
                setHp(8);
                setStrength(3);
                setDefence(10);
            }
            else if(w.equalsIgnoreCase("Spear")) {
                System.out.println("Strength +4 , Defence +11 , Hp +8");
                setHp(8);
                setStrength(4);
                setDefence(11);
            }
            else if(w.equalsIgnoreCase("Wooden Axe")) {
                System.out.println("Strength +6 , Defence +12 , Hp +10");
                setHp(10);
                setStrength(6);
                setDefence(12);
            }
            else if(w.equalsIgnoreCase("Shield")) {
                System.out.println("Strength +8 , Defence +12 , Hp +10");
                setHp(10);
                setStrength(8);
                setDefence(12);
            }
            else if(w.equalsIgnoreCase("Crossbows")) {
                System.out.println("Strength +8 , Defence +12 , Hp +12");
                setHp(12);
                setStrength(8);
                setDefence(12);
            }
            else if(w.equalsIgnoreCase("Bows")) {
                System.out.println("Strength +10 , Defence +13 , Hp +12");
                setHp(12);
                setStrength(10);
                setDefence(13);
            }
            else if(w.equalsIgnoreCase("Tridents")) {
                System.out.println("Strength +12 , Defence +13 , Hp +13");
                setHp(13);
                setStrength(12);
                setDefence(13);
            }
            else if(w.equalsIgnoreCase("Armor")) {
                System.out.println("Strength +15 , Defence +15 , Hp +15");
                setHp(15);
                setStrength(15);
                setDefence(15);
            }
            else {
                System.out.println("Please enter a valid weapon");
                item();
            }
        }
        else {
            System.out.println("You don't have this weapon, choose other weapon.");
            item();
        }
    }

    @Override
    public void flee(){
        System.out.println("--------------------------------------------------");
        System.out.println("         You had escaped from the battle!         ");
        System.out.println("--------------------------------------------------");
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

    public void itemDrop(){

    }
    public void levelUp(){
        if(exp<100){
            System.out.println();
        }
        else{
            if(exp<150) {
                setLevel(1);
                setHp(2);
                setStrength(5);
                setDefence(5);
                setAgility(5);
                setGold(25);
            }
            else if(exp<280){
                setLevel(1);
                setHp(2);
                setStrength(10);
                setDefence(10);
                setAgility(10);
                setGold(50);
            }

            else if(exp<350){
                setLevel(1);
                setHp(2);
                setStrength(15);
                setDefence(15);
                setAgility(15);
                setGold(75);
            }

            else if(exp<420){
                setLevel(1);
                setHp(2);
                setStrength(20);
                setDefence(20);
                setAgility(20);
                setGold(100);
            }

            else if(exp<490){
                setLevel(1);
                setHp(2);
                setStrength(25);
                setDefence(25);
                setAgility(25);
                setGold(125);
            }

            else if(exp<560){
                setLevel(1);
                setHp(3);
                setStrength(30);
                setDefence(30);
                setAgility(30);
                setGold(150);
            }

            else if(exp<630){
                setLevel(1);
                setHp(3);
                setStrength(35);
                setDefence(35);
                setAgility(35);
                setGold(175);
            }   

            else if(exp<700){
                setLevel(1);
                setHp(3);
                setStrength(40);
                setDefence(40);
                setAgility(40);
                setGold(200);
                }    

            else if(exp<770){
                setLevel(1);
                setHp(3);
                setStrength(45);
                setDefence(45);
                setAgility(45);
                setGold(225);
            }   
            else{
                setLevel(1);
                setHp(3);
                setStrength(50);
                setDefence(50);
                setAgility(50);
                setGold(250);
            }
            System.out.println("--------------------------------------------------");
            System.out.println("            You have been leveled up!             ");            
            System.out.println("--------------------------------------------------");
        }
    }    
}

