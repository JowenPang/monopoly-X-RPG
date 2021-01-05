package monopoly;

import java.util.Random;

class Duo extends Square{
    Random r=new Random();
    Board board=new Board();
    private boolean battleTriggered=true;
    int n=0;
    private Sin sin = new Sin();
    
    public Duo (String name) {
        this.name = name;
    }

    public void event(Player player){
        sin.checkbattle(player);
        //if true, battle monster; if false, battle player.
        if(battleTriggered) {
            System.out.println("You will fight TWO monsters.");
            while(n<2) {
                sin.battleMonster(player, board.monsters[r.nextInt(5)]);
                n++;
            }
        }
    }
}
