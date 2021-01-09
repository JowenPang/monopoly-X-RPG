package monopoly;

import java.util.Random;

class Sin extends Square {
    Board board;
    Battle battle;
    Random r = new Random();

    public Sin(Board board) {
        this.board = board;
        battle=new Battle(board);
    }

    public Sin(String name, Board board) {
        this.name = name;
        this.board = board;
        battle=new Battle(board);
    }

    public void event(Player player) {

        if(battle.checkbattle(player)){

        }
        /*after checking if there is no player in same tiles ,
        will return false , only will trigger battle with monster*/
        else {
            System.out.println("You will fight ONE monster.");
            battle.battleMonster(player, board.monsters[r.nextInt(5)]);
        }
    }
}