package monopoly;

import java.util.Scanner;

public class Instructions{

    public static void help(){
        Scanner s = new Scanner (System.in);
        String str = "", ans ="";
        outsideloop:
        System.out.println("WELCOME TO THE MONOPOLY X RPG");
        while (!str.equalsIgnoreCase("-start")&&!ans.equalsIgnoreCase("yes")){
            System.out.println("Type [-help] for game instructions.");
            System.out.println("Type [-start] to start the game.\n");

            str = s.nextLine();
            switch (str){
                case "-help":
                    // print lines area
                    for (int i = 0; i < 80; i++) {
                        System.out.print("-");
                    }
                    System.out.println();
                    // Game Instructions
                    System.out.printf(" %-76s \n","Game Instructions");
                    System.out.printf(" %-76s \n","How to Play ?");
                    System.out.printf(" %-76s \n","To start  : Each player rolls dice and the highest dice value plays first.");
                    System.out.printf(" %-76s \n","To move   : Each player takes turns to roll the dice.");
                    System.out.printf(" %-76s \n","To battle : ");
                    System.out.printf(" %-76s \n"," - Against monsters :  ");
                    System.out.printf(" %-76s \n","  - SIN-M : 1 monster");
                    System.out.printf(" %-76s \n","  - DUO-M : 2 monsters");
                    System.out.printf(" %-76s \n","  - TRI-M : 3 monsters");
                    System.out.printf(" %-76s \n"," - Against players :  ");
                    System.out.printf(" %-76s \n","  - Min. Level 5 for both players");
                    System.out.printf(" %-76s \n","  - Only 2 players battle in the same square");
                    System.out.printf(" %-76s \n","-- NO BATTLE at START, CHEST, SHOP --");
                    System.out.printf(" %-76s \n","To win: ");
                    System.out.printf(" %-76s \n","- Last player standing wins.");
                    System.out.printf(" %-76s \n","- All players quit.");
                    System.out.printf(" %-76s \n","- Highest LEVEL or highest amount of GOLD wins.");

                    // print lines area
                    for (int i = 0; i < 80; i++) {
                        System.out.print("-");
                    }
                    System.out.print("\nDo you wish to start? ");
                    ans = s.nextLine();
                    if (ans.equalsIgnoreCase("yes"))
                        break;
                    break;

                case "-start":
                    break;
            }
        }
    }
}
