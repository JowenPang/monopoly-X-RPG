package monopoly;

import java.util.Random;
import java.util.Scanner;

class Duo extends Square {
    Random r = new Random();
    Board board;
    Battle battle;
    private int n;


    public Duo(String name, Board board) {
        this.name = name;
        this.board = board;
        battle=new Battle(board);
    }

    public void event(Player player) {
        n = 0;
        if(battle.checkbattle(player)){

        }
        //if true, battle monster; if false, battle player.
        else{
            System.out.println("You will fight TWO monsters.");
            while (n < 2) {
                System.out.println("\n---------------Round " + (n + 1) + "--------------\n");
                battle.battleMonster(player, board.monsters[r.nextInt(5)]);
                n++;
            }
        }
    }
}
