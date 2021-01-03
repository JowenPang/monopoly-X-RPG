package monopoly;

import java.util.Random;

class Duo extends Square{
    Random r=new Random();
    private boolean battleTriggered=true; 

    public Duo(String name) {
        this.name = name;
    }

    @Override
    public void event(Player player){
        for (int i = 0; i <  board.players.length; i++) {
            //to check if there is player at the same tile but need to exclude the player itself
            if ((board.players[i].getPosition() == player.getPosition())&& board.players[i].getName()!= player.getName()) {
                System.out.println(board.players[i].getName() + i + board.getCurrentTurn() );
                battlePlayer(player, board.players[i]);
                battleTriggered=false;
                break;
            }
        }
        //if battle between player is triggered, battle with monster won't triggered
        if(battleTriggered)
            battleMonster(player, board.monsters[r.nextInt(5)],board.monsters[r.nextInt(5)]);
    }

    public void battlePlayer(Player player, Player player1) {
        System.out.println("Player will fight with player "+ player1.getName());
        System.out.println("Choose your option 1.Attack  2.Item  3.Flee");
        int option=sc.nextInt();
        switch(option){
            case 1:
                player1.setHp(-(player.attack(player.getStrength(),player1.getDefence())));
                System.out.println(player1.getName() + "'s turn");
                player.setHp(-(player1.attack(player1.getStrength(),player.getDefence())));
                break;
            case 2:
                player.item();
                break;
            case 3:
                player.flee();
                break;
        }
    }

    public void battleMonster(Player player, Monsters monster, Monsters monster1) {
        System.out.println("You will fight TWO monsters.");
        System.out.println("\nMonster 1 stats: \n"+ monster.toString());
        System.out.println("\nMonster 2 stats: \n"+ monster1.toString());
        //while(monster.hp>=0 || monster1.hp>=0 && player.hp>=0)
        System.out.println("Choose your option 1.Attack  2.Item  3.Flee");
        int option=sc.nextInt();
        switch(option){
            case 1:
                monster.setHp(-(player.attack(player.getStrength(),monster.getDefence())));
                monster1.setHp(-(player.attack(player.getStrength(),monster1.getDefence())));
                player.setHp(-(monster.attack(monster.getStrength(),player.getDefence())));
                player.setHp(-(monster1.attack(monster1.getStrength(),player.getDefence())));
                break;
            case 2:
                player.item();
                break;
            case 3:
                player.flee();
                break;
        }
    }
}
