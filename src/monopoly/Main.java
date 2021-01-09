package monopoly;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        Board board=null;
        int noOfPlayer=0;
        String str;
        boolean newGame=true;
        boolean gamePause=true;

        System.out.println("---WELCOME TO THE MONOPOLY X RPG---\n");

        do{
            System.out.println("\nType [-help] for game instructions.");
            System.out.println("Type [-start] to start the game.");
            System.out.println("Type [-load] to load the previous game.\n");
            str = sc.nextLine();
            if(str.equals("-help"))
                help();
            else if(str.equals("-start")) {
                break;
            }else if (str.equals("-load")) {
                newGame=false;
                board = ResourceManager.load("monopoly.txt");
                board.printBoard();
                System.out.println("\n-------Game is resume--------");
                break;
            }
        } while (true);


        //if player choose to load previous game , wil skip this block of code
        if(newGame) {
            while(true){
                System.out.println("Number of player(s):");
                noOfPlayer = sc.nextInt();
                if (noOfPlayer > 1 && noOfPlayer <= 4)
                    break;
                else
                    System.out.println("Only 2 to 4 players are allowed in this game.");
            }
            board = new Board(noOfPlayer);
            board.printBoard();
            board.setStartGame(true);
        }



        //Game continue to play as long as no end game
        outer :
        while (board.getNoOfPlayer()> 1 && board.getNoOfPlayer()<= 4) {
            if (!board.getCurrentPlayer().isQuitGame()) {
                System.out.println("\n************* Now is Player " + board.getCurrentPlayer().getName() + "'s turn *************");
                System.out.println("Option: 1.Roll Dice  2.Check Stats  3.Quit the Game 4.Save file");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        board.play();
                        break;
                    case 2:
                        System.out.println(board.getCurrentPlayer().toString());
                        System.out.println("Continue to roll dice? 1. Yes  2. Skip turn  3. Quit Game");
                        int choice2 = sc.nextInt();
                        switch (choice2) {
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
                                board.setNoOfPlayer(1);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("--------------------------------------------------");
                        System.out.println("             Player " + board.getCurrentPlayer().getName() + " left the game!");
                        System.out.println("--------------------------------------------------");
                        board.getCurrentPlayer().setQuitGame(true);
                        board.setNoOfPlayer(1);
                        break;
                    case 4 :
                        ResourceManager.save(board,"monopoly.txt");
                        System.out.println("Game is pause and saved. Resume when you are free!");
                        gamePause=false;
                        break outer;
                }
            }
            board.setCurrentTurn(1); //every round update current turn to know which player to get in this turn
        }

        //if game is pause , will not reveal the winner
        if(gamePause) {
            char winner = board.determineWinner(noOfPlayer);
            System.out.println("**************************************************");
            System.out.println("                 The winner is " + winner + "!");
            System.out.println("**************************************************");
        }
    }
    public static void help() {
                    // print lines area
                    for (int i = 0; i < 80; i++) {
                        System.out.print("-");
                    }
                    System.out.println();
                    // Game Instructions
                    System.out.printf(" %-76s \n", "Game Instructions");
                    System.out.printf(" %-76s \n", "How to Play ?");
                    System.out.printf(" %-76s \n", "To start  : Each player rolls dice and the highest dice value plays first.");
                    System.out.printf(" %-76s \n", "To move   : Each player takes turns to roll the dice.");
                    System.out.printf(" %-76s \n", "To battle : ");
                    System.out.printf(" %-76s \n", " - Against monsters :  ");
                    System.out.printf(" %-76s \n", "  - SIN-M : 1 monster");
                    System.out.printf(" %-76s \n", "  - DUO-M : 2 monsters");
                    System.out.printf(" %-76s \n", "  - TRI-M : 3 monsters");
                    System.out.printf(" %-76s \n", " - Against players :  ");
                    System.out.printf(" %-76s \n", "  - Min. Level 5 for both players");
                    System.out.printf(" %-76s \n", "  - Only 2 players battle in the same square");
                    System.out.printf(" %-76s \n", "-- NO BATTLE at START, CHEST, SHOP --");
                    System.out.printf(" %-76s \n", "To win: ");
                    System.out.printf(" %-76s \n", "- Last player standing wins.");
                    System.out.printf(" %-76s \n", "- All players quit.");
                    System.out.printf(" %-76s \n", "- Highest LEVEL or highest amount of GOLD wins.");

                    // print lines area
                    for (int i = 0; i < 80; i++) {
                        System.out.print("-");
                    }

        }
    }

