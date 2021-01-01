package monopoly;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        
        Instructions.help();
        Scanner sc=new Scanner(System.in);
        System.out.println("Number of player:");
        int n=sc.nextInt();
        Board board=new Board(n);

        board.printBoard(); //show all players at starting point
        System.out.println("Do you want to shuffle the arrangement of tiles in game board?");
        sc.nextLine();
        String shuffle=sc.nextLine();
        while(shuffle.equals("yes")){
            Board.resetSquare();
            board.printBoard();
            System.out.println("Do you want to shuffle the arrangement of tiles in game board?");
            shuffle=sc.nextLine();
        }
        board.setStartGame(true);
        do {
            System.out.println("\nNow is player "+ board.getCurrentPlayer().getName() + " turn");
            System.out.println("Option: 1.Roll Dice  2.Check Stats  3.Quit the Game");
            int choice= sc.nextInt();
            if(choice==1)
                board.play();
            else if (choice==2) {
                System.out.println(board.getCurrentPlayer().toString());
                System.out.println("Continue to roll dice? 1. Yes 2. No");
                int choice2= sc.nextInt();
                if(choice2==1)
                    board.play();
                else
                    System.out.println("your turn is skip");
            }
            else {
                System.out.println("Player " + board.getCurrentTurn() + "left the game");
                board.getCurrentPlayer().setQuitGame(true);
            }
            board.setCurrentTurn(1); //every round update current turn to know which player to get in this turn
        }while(n!=0);


    }
}