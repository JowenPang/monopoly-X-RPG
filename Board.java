package monopoly;

import java.util.Scanner;

public class Board {
    private int currentTurn;
    Square[] square = new Square[32];
    public static Player [] player;
    Scanner sc=new Scanner(System.in);

    public Board(int noOfPlayer) {
        currentTurn=0;
        player =new Player[noOfPlayer];

        System.out.println("Enter character to represent each player");
        for (int i = 0; i < player.length; i++) {
            char name = sc.next().charAt(0);
            player[i] = new Player(name);      //create each new player
            player[i].firstDiceRoll = player[i].rollDice();
            System.out.println("first dice roll: " + player[i].firstDiceRoll);

        }
        checkSequence(player);
        for (int i = 0; i < player.length; i++) {
            System.out.println("Player "+(i+1)+" : "+player[i].name);  //to check the sequence of player
        }
        System.out.println();
        System.out.println();
        System.out.println("***** "+player[0].name +" plays First! Let's begin. "+"*****");

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

    public void  play() {
        int nextPosition=0;
        Player player=getCurrentPlayer();
        int a=player.rollDice();
        System.out.println("Player's dice: "+ a);
        int nextPositionBfr=player.getPosition()+a;
        if(nextPositionBfr>=32)
            nextPosition =nextPositionBfr%32;
        else
            nextPosition=nextPositionBfr;
        player.setPosition(nextPosition);
        System.out.println("Player's next position: "+ nextPosition);
        printBoard();
        if(nextPositionBfr>32)
            square[0].event(player);
        square[nextPosition].event(player);
    }

    public void printBoard() {
        int space;
        // print upper bar
        for (int m = 16; m< 25; m++) {
            System.out.print("---------");
        }
        System.out.println("-");

        for (int m = 16; m < 25; m++) {
            System.out.printf("| %-7s",square[m].name);
        }
        System.out.println("|");
        for (int m = 16; m < 25; m++) {
        space=0;
        System.out.print("| ");
            for (int i = 0; i < player.length ;i++) {
                if (player[i].getPosition() == m) {
                    System.out.print(player[i].name+" ");
                    space+=2;
                }
            }
            for (int i = space; i < 7 ; i++) {
                System.out.print(" ");
            }
        }
        System.out.println("|");
        for (int m = 16; m< 25; m++) {
            if (m==16){
                System.out.print("|--------|");
            } else if (m==23 || m==24){
                System.out.print("--------|");
            } else {
                System.out.print("---------");
            }
        }
        System.out.println();

        // print middle rows
        int part1=15, part2=25;
        while (part1>=9 && part2<=31){
            System.out.printf("| %-7s|",square[part1].name);
            System.out.printf("%62s"," ");
            System.out.printf("| %-7s|\n",square[part2].name);
            System.out.print("| ");
            space=0;
            for (int i = 0; i < player.length ;i++) {
                if (player[i].getPosition() == part1) {
                    System.out.print(player[i].name+" ");
                    space+=2;
                }
            }
            for (int i = space; i < 7 ; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.printf("%62s"," ");

            space=0;
            System.out.print("|");
            for (int i = 0; i < player.length ;i++) {
                if (player[i].getPosition() == part2) {
                    System.out.print(player[i].name+ " ");
                    space+=2;
                }
            }
            for (int i = space; i <7 ; i++) {
                System.out.print(" ");
            }
            System.out.println(" |");
            if (part1!=9 && part2!=31){
                System.out.printf("|--------|");
                System.out.printf("%62s"," ");
                System.out.printf("|--------|");
                System.out.println();
            }
            part1--;
            part2++;
        }
        // print lower bar
        for (int m = 16; m< 25; m++) {
            if (m==16){
                System.out.print("|--------|");
            } else if (m==23 || m==24){
                System.out.print("--------|");
            } else {
                System.out.print("---------");
            }
        }
        System.out.println();
        for (int m = 8; m >=0; m--) {
            System.out.printf("| %-7s",square[m].name);
        }
        System.out.println("|");
        for (int m = 8; m >=0; m--) {
        space=0;
            System.out.print("| ");
            for (int i = 0; i < player.length ;i++) {
                if (player[i].getPosition() == m) {
                    System.out.print(player[i].name+ " ");
                    space+=2;
                }
            }
            for (int i = space; i <7 ; i++) {
                System.out.print(" ");
            }
        }
        System.out.println("|");
        for (int m = 8; m >=0; m--) {
            System.out.print("---------");
        }
        System.out.println("-");
    }

    //decide sequence
    private static Player [] checkSequence(Player[] player) {
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
        return player[currentTurn-1];
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int num) {
        this.currentTurn = currentTurn+1;
        if(this.currentTurn> player.length)
            this.currentTurn=1;
    }

    public Player[] getPlayer() {
        return player;
    }
}
