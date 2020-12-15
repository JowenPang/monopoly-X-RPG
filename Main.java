package monopoly;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Number of player:");
        int n=sc.nextInt();

        Player [] player=new Player[n];  //Object Array
        Monsters monster =new Monsters();
        Board board=new Board();


        System.out.println("Enter character to represent each player");
        for (int i = 0; i < player.length; i++) {
            char name=sc.next().charAt(0);
            player[i]=new Player(name);      //create each new player
            player[i].firstDiceRoll=player[i].rollDice();
            System.out.println( "first dice roll: "+ player[i].firstDiceRoll);
        }
        checkSequence(player);
        for (int i = 0; i < player.length; i++) {
            System.out.print(player[i].name + " ");  //to check the sequence of player
        }
        do {
            board.play(player[0]);
        }while(n!=0);


    }

    private static Object [] checkSequence(Player[] player) {
        //decide sequence
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
}
