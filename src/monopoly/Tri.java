package monopoly;

import java.util.Random;

class Tri extends Square{
    Random r=new Random();
    Board board=new Board();
    private boolean battleTriggered=true;
    int n=0;
    private Sin sin = new Sin();

    public Tri(String name) {
        this.name = name;
    }

    public void event(Player player){
        sin.checkbattle(player);
        //if true, battle monster; if false, battle player.
        if(battleTriggered) {
            System.out.println("You will fight THREE monsters.");
            while(n<3) {
                sin.battleMonster(player, board.monsters[r.nextInt(5)]);
                n++;
            }
        }
    }
}
