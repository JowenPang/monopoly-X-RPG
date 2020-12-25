package monopoly;
package monopoly;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Number of player:");
        int n=sc.nextInt();
        Board board=new Board(n);

        Player [] player=new Player[n];  //Object Array
        Monsters monster =new Monsters();

        //the game will continue loop in this do while loop
        do {
            for (int i = 0; i <player.length ; i++) {

                board.setCurrentTurn(i);
                System.out.println("\nNow is player "+ (i+1)+ " turn");
                board.play(board.getCurrentPlayer());
                board.printBoard(board.getCurrentPlayer());
                //will need special condition to break the loop
            }
        }while(n!=0);
    }
}
