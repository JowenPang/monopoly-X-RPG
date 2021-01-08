package monopoly;

import java.util.Random;

class Tri extends Square{
    Random r=new Random();
    Board board;
    private boolean battleWithMonster;
    private int n;
    private Sin sin = new Sin(board);

    public Tri(String name, Board board) {
        this.name = name;
        this.board=board;
    }

    public void event(Player player){
        battleWithMonster =true;  //n and battleTriggered should be initialized here , so everytime will refresh
        n=0;
        sin.checkbattle(player);
        //if true, battle monster; if false, battle player.
        if(battleWithMonster) {
            System.out.println("You will fight THREE monsters.");
            while(n<3) {
                System.out.println("\n---------------Round "+(n+1)+"--------------\n");
                sin.battleMonster(player, board.monsters[r.nextInt(5)]);
                n++;
            }
        }
    }
}
