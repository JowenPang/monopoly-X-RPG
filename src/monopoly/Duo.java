package monopoly;

import java.util.Random;

class Duo extends Square{
    Random r=new Random();
    Board board=new Board();
    private boolean battleWithMonster;
    private int n;
    private Sin sin = new Sin();
    
    public Duo (String name) {
        this.name = name;
    }

    public void event(Player player){
        n=0;
        battleWithMonster =true;
        sin.checkbattle(player);
        //if true, battle monster; if false, battle player.
        if(battleWithMonster) {
            System.out.println("You will fight TWO monsters.");
            while(n<2) {
                System.out.println("\n---------------Round "+(n+1)+"--------------\n");
                sin.battleMonster(player, board.monsters[r.nextInt(5)]);
                n++;
            }
        }
    }
}
