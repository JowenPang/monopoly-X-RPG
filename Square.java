package monopoly;

import java.util.Scanner;

public abstract class Square {
    protected String name;
    Scanner sc=new Scanner(System.in);

    public abstract void event(Player player);
}
class Chest extends Square{
    public Chest(String name) {
        this.name = name;
    }
    @Override
    public void event(Player player){
        System.out.println("You can open a treasure chest");
    }

}

class Sin extends Square{
    Monsters monster=new Monsters();
    Board board=new Board();
    Player [] players;
    public Sin(String name) {
        this.name = name;
        
    }
    @Override
    public void event(Player player) {

        System.out.println("you will fight one monster");
        for (int i = 0; i < players.length; i++) {
            if (players[i].getPosition() == player.getPosition() && players[i] != board.getCurrentPlayer()) {
                battlePlayer(player, players[i]);
            } else
                battleMonster(player, monster);

        }
    }

    private void battlePlayer(Player player, Player player1) {
        player1.getDefence(); // just example 
    }

    private void battleMonster(Player player, Monsters monster) {
        System.out.println(" Choose your option 1.Attack  2.Item  3.Flee");
        player.getDefence();
        monster.getStrength();
    }

}
class Duo extends Square{
    public Duo(String name) {
        this.name = name;
    }
    @Override
    public void event(Player player){
        System.out.println("you will fight two monster");
        outerloop:
        for (int i = 0; i <2 ; i++) {
            System.out.println(" Choose your option 1.Attack  2.Item  3.Flee");
            int option=sc.nextInt();
            switch(option){
                case 1:
                    player.attack();
                    break;
                case 2:
                    player.item();
                    break;
                case 3:
                    player.flee();
                    break outerloop;
            }
        }
    }

}
class Tri extends Square{
    public Tri(String name) {
        this.name = name;
    }
    @Override
    public void event(Player player){
        System.out.println("you will fight three monster");
        outerloop:
        for (int i = 0; i < 3; i++) {
            System.out.println(" Choose your option 1.Attack  2.Item  3.Flee");
            int option=sc.nextInt();
            switch(option){
                case 1:
                    player.attack();
                    break;
                case 2:
                    player.item();
                    break;
                case 3:
                    player.flee();
                    break outerloop;

            }
        }
    }

}
