package monopoly;

import java.util.Random;
import java.util.Scanner;

class Sin extends Square{
    private boolean battleTriggered=true;
    Random r=new Random();
    
    public Sin(){
    }
    
    public Sin(String name) {
        this.name = name;
    }

    public void event(Player player){
        checkbattle(player);
        //if true, battle monster; if false, battle player.
        if(battleTriggered) {
            System.out.println("You will fight ONE monster.");
            battleMonster(player, board.monsters[r.nextInt(5)]);
        }
    }
    
    // check whether battle monsters or battle players
    public void checkbattle(Player player){
        int headcnt = 0, head = 0;
        for (int i = 0; i <  board.players.length; i++) {
            //to check if there are players in the same tile excluding the player himself
            if ((board.players[i].getPosition() == player.getPosition())&& board.players[i].getName()!= player.getName()) {
                // to count num of players in the tile
                headcnt++;  
                // set index to variable [note: if the headcnt != 1, the variable head is no longer needed]
                head = i;
            }
        }
        // if there is only one player in the tile
        if (headcnt==1){
            // and if both players are at least level 5
            if (player.getLevel()>=5 && board.players[head].getLevel()>=5){
                // battle player
                battlePlayer(player, board.players[head]);
                battleTriggered=false;
            }
        }
    }

    // battle against player 
    public void battlePlayer(Player player, Player player1) {
        System.out.println("Player will fight with player "+ player1.getName());
        while(player.getHp()>0 && player1.getHp()>0) {
            System.out.println("Choose your option 1.Attack  2.Item  3.Flee");
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
        if(player.getHp()<=0){
            System.out.println("--------------------------------------------------");
            System.out.println("        Player "+player.getName()+",you have lost this battle");
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println(player1.getName() + " is defeated ");
            System.out.println("You will get Gold and EXP!");
        }
    }

    // battle against monster
    public void battleMonster(Player player, Monsters monster) {
        Scanner sc=new Scanner(System.in);
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
                    if (monster.getHp()<15)
                        System.out.println("Monster's current hp :"+ monster.getHp()+" [Monster's HP is low !Attack!]");
                    else
                        System.out.println("Monster's current hp :"+ monster.getHp());
                    System.out.println();
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
                    if (player.getAgility() < monster.getAgility()){
                        System.out.println("--------------------------------------------------");
                        System.out.println("     Opps ! You can't escape from the battle.     ");
                        System.out.println("--------------------------------------------------");
                    }else{
                        player.flee();
                        break flee;
                    }
            }

            System.out.println("--> Monster's turn to attack <--");
            int damage = monster.attack(monster.getStrength(), player.getDefence());
            player.setHp(-damage);
            System.out.println("The monster hit you with a DAMAGE dealed "+damage);
            if(player.getHp()<12)
                System.out.println("Player's current hp : "+ player.getHp()+ " [Consider get item to prevent defeated by monster!]");
            else
                System.out.println("Player's current hp : "+ player.getHp());
            System.out.println();
        }
        if(player.getHp()<=0){
            System.out.println("--------------------------------------------------");
            System.out.println("       Player "+player.getName() + ", you have lost this battle.");
            System.out.println("--------------------------------------------------");
        }
        if(monster.getHp()<=0) {
            System.out.println("Monster is defeated.");
            player.setGold(30);
            player.setExp(30);
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