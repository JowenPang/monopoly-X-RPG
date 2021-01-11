package monopoly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player extends Role implements Serializable {
    private char name;
    private int firstDiceRoll;
    private int position;
    private boolean quitGame=false;
    private int noOfMonsterEncounter;
    Random r =new Random();
    transient Scanner sc=new Scanner(System.in);

    public Player(){

    }

    //if quitGame is true , then the player is count as removed from the game
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
        if(sc==null)
            sc=new Scanner(System.in);
        if(weapon.contains(w))
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
        else if(w.equalsIgnoreCase("Master Sword")) {
            System.out.println("This weapon can be only use once");
            System.out.println("Strength 30 , Defence 30 , Hp +20");
            setHp(20);
            setStrength(30);
            setDefence(30);
            weapon.remove(w);
        }
        else if(w.equalsIgnoreCase("Blade of Chaos")){
            System.out.println("This weapon can be only use once");
            System.out.println("Strength 30 , Defence 30 , Hp +20");
            setHp(20);
            setStrength(30);
            setDefence(30);
            weapon.remove(w);
        }
        else if(w.equalsIgnoreCase("Key Blade")){
            System.out.println("This weapon can be only use once");
            System.out.println("Strength 30 , Defence 30 , Hp +20");
            setHp(20);
            setStrength(30);
            setDefence(30);
            weapon.remove(w);

        }
        else if(w.equalsIgnoreCase("Hidden Blade")){
            System.out.println("This weapon can be only use once");
            System.out.println("Strength 25 , Defence 25 , Hp +18");
            setHp(18);
            setStrength(25);
            setDefence(25);
            weapon.remove(w);
        }
        else if(w.equalsIgnoreCase("Gravity Gun")){
            System.out.println("This weapon can be only use once");
            System.out.println("Strength 30 , Defence 30 , Hp +20");
            setHp(20);
            setStrength(30);
            setDefence(30);
            weapon.remove(w);
        }
        else {
            System.out.println("Please enter a valid weapon");
            item(sc.next()); //recursion , call back the method
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
                resetHp(25); //resetHp
        }
        else{
            if(exp<150){
                resetHp(27);
                if(this.level<2){
                    this.level=2;
                    setGold(25); //gold no limit for every level
                }
                this.strength=10;
                this.defence=10;
                this.agility=10;
                
            }

            else if(exp<280){
                resetHp(29);
                if(this.level<3){
                    this.level=3;
                    setGold(50);
                }
                this.strength=20;
                this.defence=20;
                this.agility=20;
                
            }

            else if(exp<350){
                resetHp(31);
                if(this.level<4){
                    this.level=4;
                    setGold(75);
                }
                this.strength=30;
                this.defence=30;
                this.agility=30;
                
            }

            else if(exp<420){
                resetHp(33);
                if(this.level<5){
                    this.level=5;
                    setGold(100);
                }
                this.strength=40;
                this.defence=40;
                this.agility=40;
               
            }

            else if(exp<490){
                resetHp(35);
                if(this.level<6){
                    this.level=6;
                    setGold(125);
                }this.strength=50;
                this.defence=50;
                this.agility=50;
            }

            else if(exp<560){
                resetHp(38);
                if(this.level<6){
                    this.level=6;
                    setGold(150);
                }
                this.strength=60;
                this.defence=60;
                this.agility=60;
                  
            }


            else if(exp<630){
                resetHp(41);
                    if(this.level<7){
                        this.level=7;
                        setGold(175);
                    }
                this.strength=70;
                this.defence=70;
                this.agility=70;
            }

            else if(exp<700){
                resetHp(44);
                if(this.level<8){
                    this.level=8;
                    setGold(200);
                }
                this.strength=80;
                this.defence=80;
                this.agility=80;
            }

            else if(exp<770){
                resetHp(47);
                if(this.level<9){
                    this.level=9;
                    setGold(225);
                }
                this.strength=90;
                this.defence=90;
                this.agility=90;
            }
            else{
                resetHp(50);
                if(this.level<10){
                    this.level=10;
                    setGold(250);
                }else{
                    System.out.println("You have reached the maximum level");
                }
                this.strength=100;
                this.defence=100;
                this.agility=100;
            }
            }

        }
    }
