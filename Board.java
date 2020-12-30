package monopoly;

import java.util.Scanner;

public class Board {
    private int currentTurn;
    private int noOfPlayer;
    Square[] square = new Square[32];
    public Player [] players;
    Scanner sc=new Scanner(System.in);
    public Board(){
        currentTurn=0;
        players =new Player[noOfPlayer];

        System.out.println("Enter character to represent each player");
        for (int i = 0; i < players.length; i++) {
            char name = sc.next().charAt(0);
            players[i] = new Player(name);      //create each new player
            players[i].setFirstDiceRoll(players[i].rollDice());
            System.out.println("first dice roll: " + players[i].getFirstDiceRoll());

        }
        checkSequence(players);
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player "+(i+1)+" : "+players[i].getName());  //to check the sequence of player
        }
        System.out.println();
        System.out.println();
        System.out.println("***** "+players[0].getName() +" plays First! Let's begin. "+"*****");

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

    public Board(int noOfPlayer) {
        this.noOfPlayer=noOfPlayer;
    }

    public void  play() {
        int nextPosition=0;
        Player player=getCurrentPlayer(); //first point to the specific player in this round
        int a=player.rollDice();
        System.out.println("Player's dice: "+ a);
        int nextPositionBfr=player.getPosition()+a;  //nextPOsitionBfr is because i havent mod by 32
        if(nextPositionBfr>=32)
            nextPosition =nextPositionBfr%32;
        else
            nextPosition=nextPositionBfr;
        player.setPosition(nextPosition); //update player new position
        System.out.println("Player's next position: "+ nextPosition);
        printBoard();      //show the location of player after toss dice
        if(nextPositionBfr>32)
            square[0].event(player);
        // after each round , even if player didn't reach the Start tile, the player is still consider to be upgraded
        square[nextPosition].event(player);
       /* this will pass the player to the event occur in each square , following the number of position,can  refer to
        square object set in constructor*/
    }

    public void printBoard() {
        int space;
        // print upper bar
        for (int m = 16; m< 25; m++) {
            System.out.print("----------");
        }
        System.out.println("-");

        for (int m = 16; m < 25; m++) {
            System.out.printf("| %-8s",square[m].name);
        }
        System.out.println("|");
        for (int m = 16; m < 25; m++) {
            space=0;
            System.out.print("| ");
            for (int i = 0; i < players.length ;i++) {
                if (players[i].getPosition() == m) {
                    System.out.print(players[i].getName()+" ");
                    space+=2;
                }
            }
            for (int i = space; i < 8 ; i++) {
                System.out.print(" ");
            }
        }
        System.out.println("|");
        for (int m = 16; m< 25; m++) {
            if (m==16){
                System.out.print("|---------|");
            } else if (m==23 || m==24){
                System.out.print("---------|");
            } else {
                System.out.print("----------");
            }
        }
        System.out.println();

        // print middle rows
        int part1=15, part2=25;
        while (part1>=9 && part2<=31){
            System.out.printf("| %-8s|",square[part1].name);
            System.out.printf("%69s"," ");
            System.out.printf("| %-8s|\n",square[part2].name);
            System.out.print("| ");
            space=0;
            for (int i = 0; i < players.length ;i++) {
                if (players[i].getPosition() == part1) {
                    System.out.print(players[i].getName()+" ");
                    space+=2;
                }
            }
            for (int i = space; i < 8 ; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.printf("%69s"," ");

            space=0;
            System.out.print("| ");
            for (int i = 0; i < players.length ;i++) {
                if (players[i].getPosition() == part2) {
                    System.out.print(players[i].getName()+ " ");
                    space+=2;
                }
            }
            for (int i = space; i < 8 ; i++) {
                System.out.print(" ");
            }
            System.out.println("|");
            if (part1!=9 && part2!=31){
                System.out.printf("|---------|");
                System.out.printf("%69s"," ");
                System.out.printf("|---------|");
                System.out.println();
            }
            part1--;
            part2++;
        }
        // print lower bar
        for (int m = 16; m< 25; m++) {
            if (m==16){
                System.out.print("|---------|");
            } else if (m==23 || m==24){
                System.out.print("---------|");
            } else {
                System.out.print("----------");
            }
        }
        System.out.println();
        for (int m = 8; m >=0; m--) {
            System.out.printf("| %-8s",square[m].name);
        }
        System.out.println("|");
        for (int m = 8; m >=0; m--) {
            space=0;
            System.out.print("| ");
            for (int i = 0; i < players.length ;i++) {
                if (players[i].getPosition() == m) {
                    System.out.print(players[i].getName()+ " ");
                    space+=2;
                }
            }
            for (int i = space; i < 8 ; i++) {
                System.out.print(" ");
            }
        }
        System.out.println("|");
        for (int m = 8; m >=0; m--) {
            System.out.print("----------");
        }
        System.out.println("-");
    }
    //decide sequence
    private static Player [] checkSequence(Player[] player) {
        for (int pass = 0; pass<player.length-1; pass++) {
            for (int i = 0; i < player.length-1; i++) {
                Player temp;
                if(player[i].getFirstDiceRoll()<player[i+1].getFirstDiceRoll()) {
                    temp = player[i];            //swap between player , swap whole object
                    player[i] = player[i + 1];
                    player[i + 1] = temp;
                }
            }

        }return player;
    }
    public Player getCurrentPlayer(){
        return players[currentTurn-1];
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    //every time loop in main, current turn will reset by adding 1, player playing is this turn will be follow [currentTurn-1]
    public void setCurrentTurn(int num) {
        this.currentTurn = currentTurn+1;
        if(this.currentTurn> players.length)
            this.currentTurn=1;
    }

    //return array of player following sequence
    public Player[] getPlayer() {
        return players;
    }
}
