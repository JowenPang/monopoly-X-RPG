package monopoly;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Instructions.help();
        Scanner sc = new Scanner(System.in);
        int noOfPlayer;
        while(true) {
            System.out.println("Number of player(s):");
            noOfPlayer = sc.nextInt();
            if(noOfPlayer>1 &&noOfPlayer<=4)
                break;
            else
                System.out.println("Only 2 to 4 players are allowed in this game.");
        }
        int n = noOfPlayer;
        Board board = new Board(n);

        board.printBoard();
        board.setStartGame(true);

        //Game continue to play as long as no end game
        while (n > 1 && n <= 4) {
            board.gameStart();
        }

        char winner = board.determineWinner(noOfPlayer);
        System.out.println("**************************************************");
        System.out.println("                 The winner is " + winner+"!");
        System.out.println("**************************************************");


    }

}
