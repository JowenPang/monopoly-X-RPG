package monopoly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Player extends Role implements Serializable {
    private char name;
    private int firstDiceRoll;
    private int position;
    private boolean quitGame=false;
    private int noOfMonsterEncounter;
    Random r =new Random();

    public Player(){

    }

    //if isLose is true , then the player is count as removed from the game, the player cannot play game if isLose is true
    ArrayList<String> item = new ArrayList<String>();
    ArrayList<String> weapon = new ArrayList<String>();
    //act as backpack of player , can add and remove item and weapon

    public Player(char name) {
        this.name=name; firstDiceRoll=0;position=0;
        item.add("Hi-Potion");
        item.add("Hi-Potion");
        item.add("Smoke Bomb");
        item.add("Smoke Bomb");
        item.add("Smoke Bomb");
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

    //everytime player choose a new item , means switch item , strength and defence is no more accumulate
    @Override
    public void item(String w){
        if(weapon.contains(w)) {
            System.out.println("You are now using " + w);
            if(w.equalsIgnoreCase("Sword")) {
                System.out.println("Strength 8 , Defence 10 , Hp +8");
                setHp(8);
                setStrength(10);
                setDefence(10);
            }
            else if(w.equalsIgnoreCase("Spear")) {
                System.out.println("Strength 10 , Defence 11 , Hp +8");
                setHp(8);
                setStrength(10);
                setDefence(11);
            }
            else if(w.equalsIgnoreCase("Wooden Axe")) {
                System.out.println("Strength 13 , Defence 12 , Hp +10");
                setHp(10);
                setStrength(13);
                setDefence(12);
            }
            else if(w.equalsIgnoreCase("Shield")) {
                System.out.println("Strength 15 , Defence 19 , Hp +10");
                setHp(10);
                setStrength(15);
                setDefence(19);
            }
            else if(w.equalsIgnoreCase("Crossbows")) {
                System.out.println("Strength 15 , Defence 16 , Hp +12");
                setHp(12);
                setStrength(15);
                setDefence(16);
            }
            else if(w.equalsIgnoreCase("Bows")) {
                System.out.println("Strength 18 , Defence 18 , Hp +12");
                setHp(12);
                setStrength(18);
                setDefence(18);
            }
            else if(w.equalsIgnoreCase("Tridents")) {
                System.out.println("Strength 18 , Defence 18 , Hp +13");
                setHp(13);
                setStrength(18);
                setDefence(18);
            }
            else if(w.equalsIgnoreCase("Armor")) {
                System.out.println("Strength 20 , Defence 20 , Hp +15");
                setHp(15);
                setStrength(20);
                setDefence(20);
            }
            else if(w.equalsIgnoreCase("Master Sword")|| w.equalsIgnoreCase("Blade of Chaos")
            ||w.equalsIgnoreCase("Key Blade") ||w.equalsIgnoreCase("Hidden Blade")||
                    w.equalsIgnoreCase("Gravity Gun")){
                System.out.println("You can apply "+ w + " to let other players to downgrade one level ");

                weapon.remove(w);
            }
            else {
                System.out.println("Please enter a valid weapon");
                item(w); //recursion , call back the method
            }
        }
        else {
            System.out.println("You don't have this weapon, choose other weapon.");
            item(w);
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
        return "-----------------------"+ "\nLevel = " + level + "\nHp = " + hp + "\nStrength = " + strength +
                "\nDefence = " + defence + "\nAgility = " + agility + "\nEXP = " + exp +
                "\nGold = " + gold+ "\n-----------------------";
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
        String []itemDrop ={"Potion","Hi-Potion","Smoke bomb","Poison"};
        String drop;
        drop=itemDrop[r.nextInt(itemDrop.length)]; //randomise the index
            if(drop.equals(itemDrop[0])){
                item.add("Potion");
            }else if (drop.equals(itemDrop[1])){
                item.add("Hi-Potion");
            }else if (drop.equals(itemDrop[2])){
                item.add("Smoke bomb");
            }else{
                item.add("Poison");
            }
            System.out.println(" You got " + drop);

    }
    public void levelUp(){
        if(exp<100){
            System.out.println();
        }
        else{
            if(exp<150){
                if(this.level<2){
                    System.out.println("-----level up!-----");
                    this.level=2;
                    setGold(25); //gold no limit for every level
                }
                //this set the level up element
                //if else is to check if the player get potion in earlier stage it can still use the potion until their hp is used up
                if(this.hp<27){
                    this.hp=27;
                }
                if(this.strength<10){
                    this.strength=10;
                }
                if(this.defence<10){
                    this.defence=10;
                }
                if(this.agility<10){
                    this.agility=10;
                }
            }

            else if(exp<280){
                if(this.level<3){
                    this.level=3;
                    setGold(50);
                    System.out.println("-----level up!-----");
                }
                if(this.hp<29){
                    this.hp=29;
                }
                if(this.strength<20){
                    this.strength=20;
                }
                if(this.defence<20){
                    this.defence=20;
                }
                if(this.agility<20){
                    this.agility=20;
                }
            }

            else if(exp<350){
                if(this.level<4){
                    this.level=4;
                    setGold(75);
                    System.out.println("-----level up!-----");
                }
                if(this.hp<31){
                    this.hp=31;
                }
                if(this.strength<30){
                    this.strength=30;
                }
                if(this.defence<30){
                    this.defence=30;
                }
                if(this.agility<30){
                    this.agility=30;
                }
            }

            else if(exp<420){
                if(this.level<5){
                    this.level=5;
                    setGold(100);
                    System.out.println("-----level up!-----");
                }
                if(this.hp<33){
                    this.hp=33;
                }
                if(this.strength<40){
                    this.strength=40;
                }
                if(this.defence<40){
                    this.defence=40;
                }
                if(this.agility<40){
                    this.agility=40;
                }
            }

            else if(exp<490){
                if(this.level<6){
                    this.level=6;
                    setGold(125);
                    System.out.println("-----level up!-----");
                }
                if(this.hp<35){
                    this.hp=35;
                }
                if(this.strength<50){
                    this.strength=50;
                }
                if(this.defence<50){
                    this.defence=50;
                }
                if(this.agility<50){
                    this.agility=50;
                }
            }
                    

            else if(exp<560){
                    if(this.level<6){
                        this.level=6;
                        setGold(150);
                        System.out.println("-----level up!-----");
                    }
                    if(this.hp<38){
                        this.hp=38;
                    }
                    if(this.strength<60){
                        this.strength=60;
                    }
                    if(this.defence<60){
                        this.defence=60;
                    }
                    if(this.agility<60){
                        this.agility=60;
                    }
                }

            else if(exp<630){
                    if(this.level<7){
                        this.level=7;
                        setGold(175);
                        System.out.println("-----level up!-----");
                    }
                    if(this.hp<41){
                        this.hp=41;
                        }
                    if(this.strength<70){
                        this.strength=70;
                    }
                    if(this.defence<70){
                        this.defence=70;
                    }
                    this.agility=70;
            }

            else if(exp<700){
                if(this.level<8){
                    this.level=8;
                    setGold(200);
                    System.out.println("-----level up!-----");
                }
                if(this.hp<44){
                    this.hp=44;
                }
                if(this.strength<80){
                    this.strength=80;
                }
                if(this.defence<80){
                    this.defence=80;
                }
                this.agility=80;
            }

            else if(exp<770){
                if(this.level<9){
                    this.level=9;
                    setGold(225);
                    System.out.println("-----level up!-----");
                }
                if(this.hp<47){
                    this.hp=47;
                }
                if(this.strength<90){
                    this.strength=90;
                }
                if(this.defence<90){
                    this.defence=90;
                }
                this.agility=90;
            }
            else{
                if(this.level<10){
                    this.level=10;
                    setGold(250);
                }else{
                    System.out.println("You have reached the maximum level");
                }
                if(this.hp<50){
                    this.hp=50;
                }
                if(this.strength<100){
                    this.strength=100;
                }
                if(this.defence<100){
                    this.defence=100;
                }
                this.agility=100;
            }
            }
        }
    }

