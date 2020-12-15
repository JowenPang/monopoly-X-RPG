package monopoly;

import java.util.Random;

public class Player extends Role {
    char name;
    int firstDiceRoll;
    int position;

    public Player(char name) {
        this.name=name; firstDiceRoll=0; position=0;
    }
    public int rollDice(){
        Random r=new Random();
        int max=6;
        return r.nextInt(max)+1;
    }
    public int getPosition(){
        //we don't have to everytime roll dice , just know player's new position will do
        Random r=new Random();
        int max=6;
        return (position+(r.nextInt(max)+1))%32;
    }

    @Override
    public void attack(){
    }

    @Override
    public void item(){
    }

    @Override
    public void flee(){
    }

}

