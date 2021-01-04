package monopoly;

import java.util.Random;

class Sin extends Square{
    private boolean battleTriggered=true;
    Random r=new Random();

    public Sin(String name) {
        this.name = name;
    }

    @Override
    public void event(Player player){
        for (int i = 0; i <  board.players.length; i++) {
            //to check if there is player at the same tile but need to exclude the player itself
            if ((board.players[i].getPosition() == player.getPosition())&& board.players[i].getName()!= player.getName()) {
                if (player.getLevel()>=5 && board.players[i].getLevel()>=5){
                    battlePlayer(player, board.players[i]);
                    battleTriggered=false;
                break;
                }
            }
        }
        //if battle between player is triggered, battle with monster won't triggered
        if(battleTriggered)
            battleMonster(player, board.monsters[r.nextInt(5)]);
    }

    public void battlePlayer(Player player, Player player1) {
        System.out.println("Player will fight with player "+ player1.getName());
        while(player.getHp()>0 && player1.getHp()>0) {
            System.out.println(" Choose your option 1.Attack  2.Item  3.Flee");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    player1.setHp(-(player.attack(player.getStrength(), player1.getDefence())));
                    System.out.println(player1.getName() + "'s turn");
                    break;
                case 2:
                    System.out.println("The item you have: " + player.getItem());
                    //System.out.println("Which item do you want to use?");
                    break;
                case 3:
                    player.flee();
                    break;
            }
            player.setHp(-(player1.attack(player1.getStrength(), player.getDefence())));
        }
        if(player.getHp()<=0)
            System.out.println(player.getName() + " lose this battle");
        else {
            System.out.println(player1.getName() + " is defeated ");
            System.out.println("you will get gold and exp");
        }
    }

    public void battleMonster(Player player, Monsters monster) {
        System.out.println("You will fight ONE monster.");
        System.out.println("Monster's stats\n"+ monster.toString());
        flee:
        while(player.getHp()>0 && monster.getHp()>0) {
            System.out.println("--> Fighting monster <--");
            System.out.println("Choose your option 1.Attack  2.Item  3.Flee");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    int damage = player.attack(player.getStrength(), monster.getDefence());
                    monster.setHp(-damage);
                    System.out.println("You dealed a DAMAGE of "+damage+" onto the monster.");
                    System.out.println("Monster's current hp :"+ monster.getHp()+"\n");
                    break;
                case 2:
                    System.out.println(player.getItem());
                    break;
                case 3:
                    if (player.getAgility() < monster.getAgility())
                        System.out.println("Opps ! You can't escape from the battle.");
                    else{
                        player.flee();
                        break flee;
                    }
            }

            System.out.println("--> Monster's turn to attack <--");
            int damage = monster.attack(monster.getStrength(), player.getDefence());
            player.setHp(-damage);
            System.out.println("The monster hit you with a DAMAGE dealed "+damage);
            System.out.println("Player's current hp : "+ player.getHp()+"\n");
        }
        if(player.getHp()<=0)
            System.out.println(player.getName() + " lose this battle");
        if(monster.getHp()<=0) {
            System.out.println("Monster is defeated.");
            System.out.println("Excellent ! You will get Gold and EXP");
        }
    }
}