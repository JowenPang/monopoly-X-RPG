package monopoly;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Instructions.help();
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of player(s):");
        int noOfPlayer = sc.nextInt();
        int n = noOfPlayer;
        Board board = new Board(n);

        board.printBoard();
        
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
        
        while (n > 1 && n <= 4) {
            if (!board.getCurrentPlayer().isQuitGame()) {
                System.out.println("\n************* Now is Player " + board.getCurrentPlayer().getName() + "'s turn *************");
                System.out.println("Option: 1.Roll Dice  2.Check Stats  3.Quit the Game");
                int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            board.play();
                            break;
                        case 2:
                            System.out.println(board.getCurrentPlayer().toString());
                            System.out.println("Continue to roll dice? 1. Yes  2. Skip turn  3. Quit Game");
                            int choice2 = sc.nextInt();
                            switch (choice2){
                                case 1:
                                    board.play();
                                    break;
                                case 2:
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("             Your turn is skipped!                ");
                                    System.out.println("--------------------------------------------------");
                                    break;
                                case 3:
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("             Player " + board.getCurrentPlayer().getName() + " left the game!");
                                    System.out.println("--------------------------------------------------");
                                    board.getCurrentPlayer().setQuitGame(true);
                                    n = n - 1;
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("--------------------------------------------------");
                            System.out.println("             Player " + board.getCurrentPlayer().getName() + " left the game!");
                            System.out.println("--------------------------------------------------");
                            board.getCurrentPlayer().setQuitGame(true);
                            n = n - 1;
                            break;
                    }
            }
            board.setCurrentTurn(1); //every round update current turn to know which player to get in this turn
        }

        char winner = board.determineWinner(noOfPlayer);
        System.out.println("**************************************************");
        System.out.println("                 The winner is " + winner+"!");
        System.out.println("**************************************************");


    }
}
