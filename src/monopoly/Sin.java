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
                battlePlayer(player, board.players[i]);
                battleTriggered=false;
                break;
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
            System.out.println(" Choose your option 1.Attack  2.Item  3.Flee");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    monster.setHp(-(player.attack(player.getStrength(), monster.getDefence())));
                    if (monster.getHp()<15)
                        System.out.println("Monster's current hp :"+ monster.getHp()+" [Monster's HP is low !Attack!]");
                    else
                        System.out.println("Monster's current hp :"+ monster.getHp());
                    break;
                case 2:
                    //if get item
                    player.setHp(20);
                    player.setDefence(5);
                   /* System.out.println(player.getItem());
                    System.out.println("Which item do you want to use?");
                    String item=sc.next();
                    applyItem(item);*/
                    break;
                case 3:
                    player.flee();
                    //check player's agility > monster's agility , only can flee
                    break flee;
            }

            System.out.println("--> Monster's turn to attack <--");
            player.setHp(-(monster.attack(monster.getStrength(), player.getDefence())));
            if(player.getHp()<12)
                System.out.println("Player's current hp : "+ player.getHp()+ "[Consider get item to prevent defeated by monster!]");
            else
                System.out.println("Player's current hp : "+ player.getHp());
        }
        if(player.getHp()<=0)
            System.out.println(player.getName() + " lose this battle");
        if(monster.getHp()<=0) {
            System.out.println("Monster is defeated ");
            player.setGold(30);
            player.setExp(20);
            player.setNoOfMonsterEncounter(1);
            player.levelUp();
            System.out.println("Your gold and EXP has increased!\n"+ player.toString());
        }
        player.resetHp(25);
        monster.resetHp(30);
    }

    private void applyItem(String item) {
        //check which item player get then add hp
    }
}