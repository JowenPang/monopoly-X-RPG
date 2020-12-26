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
                System.out.println("Option: 1.Roll Dice  2.Check Stats  3.Quit the Game");
                int choice= sc.nextInt();
                if(choice==1)
                    board.play(board.getCurrentPlayer());
                else if (choice==2) {
                    System.out.println(board.getCurrentPlayer().toString());
                    System.out.println("Continue to roll dice? 1. Yes 2. No");
                    int choice2= sc.nextInt();
                    if(choice2==1)
                        board.play(board.getCurrentPlayer());
                    else
                        System.out.println("your turn is skip");
                }
                else
                    System.out.println("Player "+ (i+1) + "left the game");


                //will need special condition to break the loop
            }
        }while(n!=0);
    }
}
