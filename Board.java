package monopoly;

import java.util.Scanner;

public class Board {
    private int currentTurn=0;
    Square[] square = new Square[32];
    Player [] player;
    Scanner sc=new Scanner(System.in);

    public Board(int noOfPlayer) {
        player =new Player[noOfPlayer];

        System.out.println("Enter character to represent each player");
        for (int i = 0; i < player.length; i++) {
            char name=sc.next().charAt(0);
            player[i]=new Player(name);      //create each new player
            player[i].firstDiceRoll=player[i].rollDice();
            System.out.println( "first dice roll: "+ player[i].firstDiceRoll);
        }
        checkSequence(player);
        for (int i = 0; i < player.length; i++) {
            System.out.print(player[i].name + " ");  //to check the sequence of player
        }

        for (int i = 0; i < square.length; i++) {
            if (i == 0)
                square[i] = new Start("Start");
            else if (i == 16)
                square[i] = new Chest("Chest");
            else if (i == 8 || i == 24)
                square[i] = new Shop("Shop");
            else if (i == 4 || i == 12 || i == 20 || i == 28)
                square[i] = new Empty("    ");
            else if (i == 2 || i == 15 || i == 19 || i == 29)
                square[i] = new Tri("Tri-M");
            else if (i == 1 || i == 5 || i == 9 || i == 11 || i == 18 || i == 22 || i == 26 || i == 27)
                square[i] = new Duo("Duo-M");
            else
                square[i] = new Sin("Sin-M");

        }
    }

    public Square play(Player player) {
        int a=player.rollDice();
        System.out.println("Player's dice: "+ a);
        int nextPosition=(player.getPosition()+a)%32;
        player.setPosition(nextPosition);
        System.out.println("Player's next position: "+ nextPosition);
        square[nextPosition].event(player);
        return square[nextPosition];

    }

    public void printBoard(Player player) {
        System.out.println(" ----------------------------------------------------------------------");
        for (int m = 16; m < 25; m++) {
            System.out.print(" | " + square[m].name);
        }
        System.out.println("|");
        for (int m = 16; m< 25; m++) {
            System.out.print(" | ");
            for (int n = 0; n< square[m].name.length(); n++) {
                if(n==0) {
                    if (player.getPosition() == m)
                        System.out.print(player.name);
                    else
                        System.out.print(" ");
                }
                else
                    System.out.print(" ");
            }
        }System.out.println("|");
        System.out.println(" ----------------------------------------------------------------------");

        System.out.println(" ----------------------------------------------------------------------");
        for (int m = 8; m >=0; m--) {
            System.out.print(" | " + square[m].name);
        }
        System.out.println("|");
        for (int m = 8; m >=0; m--) {
            System.out.print(" | ");
            for (int n = 0; n< square[m].name.length(); n++) {
                if(n==0) {
                    if (player.getPosition() == m)
                        System.out.print(player.name);
                    else
                        System.out.print(" ");
                }
                else
                    System.out.print(" ");
            }
        }System.out.println("|");
        System.out.println(" ----------------------------------------------------------------------");
    }
    private static Player [] checkSequence(Player[] player) {
        //decide sequence
        for (int pass = 0; pass<player.length-1; pass++) {
            for (int i = 0; i < player.length-1; i++) {
                Player temp;
                if(player[i].firstDiceRoll<player[i+1].firstDiceRoll) {
                    temp = player[i];            //swap between player , swap whole object
                    player[i] = player[i + 1];
                    player[i + 1] = temp;
                }
            }

        }return player;
    }
    public Player getCurrentPlayer(){
        return player[currentTurn];
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }
}


