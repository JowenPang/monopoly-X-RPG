package monopoly;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private int currentTurn;
    public int noOfPlayer;
    private int diceValue;
    boolean startGame=false;
    public static Player [] players;
    public static Monsters[] monsters;
    public static Square[] square = new Square[32];
    Scanner sc=new Scanner(System.in);

    public Board(){
    }
    public Board(int noOfPlayer) {
        this.noOfPlayer=noOfPlayer;
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

        monsters=new Monsters[5];
        monsters[0]=new Monsters("Fire",1,25,5,10,20);
        monsters[1]=new Monsters("Water", 2,25,7,13,20);
        monsters[2]=new Monsters("Wind", 3,75,8,15,20);
        monsters[3]=new Monsters("Land",4,100,10,18,20);
        monsters[4]=new Monsters("Magic",1,25,5,10,20);

    }

    public void  play() {
        int nextPosition=0;
        Player player=getCurrentPlayer(); //first point to the specific player in this round
        player.resetHp();
        diceValue=player.rollDice();
        int nextPositionBfr=player.getPosition()+diceValue;  //nextPositionBfr is because i havent mod by 32
        if(nextPositionBfr>=32)
            nextPosition =nextPositionBfr%32;
        else
            nextPosition=nextPositionBfr;
        player.setPosition(nextPosition); //update player new position
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
            if(part1==15 && isStartGame()) {
                System.out.print("[Player " + getCurrentPlayer().getName() + "]" + " moved " + diceValue + " steps");
                System.out.printf("%45s"," ");
            }
            else
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
        return players[currentTurn];
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    //every time loop in main, current turn will reset by adding 1, player playing is this turn will be follow [currentTurn-1]
    public void setCurrentTurn(int num) {
        this.currentTurn = currentTurn+1;
        if(this.currentTurn== players.length)
            this.currentTurn=0;
    }

    //cf: determine method
    public char determineWinner(int n){
        Player temp;
        for(int i=1; i<n; i++) {
            for (int j = 1; i < players.length; i++) {
                if (players[j].getLevel() > players[j - 1].getLevel()) {
                    temp = players[j];
                    players[j] = players[j - 1];
                    players[j - 1] = temp;
                }
            }
        }
        return players[0].getName();
    }

    //return array of player following sequence
    public Player[] getPlayer() {
        return players;
    }
    public boolean isStartGame() {
        return startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    public Square[] getSquare() {
        return square;
    }

    public static Square [] resetSquare() {
        Random r = new Random();

        for (int i = square.length-2; i > 0; i--) {

            int j = r.nextInt(i)+1;

            Square temp = square[i];
            square[i] = square[j];
            square[j] = temp;
        }
        return square;
    }
}