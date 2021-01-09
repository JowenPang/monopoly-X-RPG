package monopoly;


import java.util.Random;
import java.util.Scanner;

class Sin extends Square {
    Board board;
    private boolean battleWithMonster;
    Random r = new Random();

    public Sin(Board board) {
        this.board = board;
    }

    public Sin(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public void event(Player player) {
        battleWithMonster = true;
        checkbattle(player);
        //if true, battle monster; if false, battle player.
        if (battleWithMonster) {
            System.out.println("You will fight ONE monster.");
            battleMonster(player, board.monsters[r.nextInt(5)]);
        }
    }

    // check whether battle monsters or battle players
    public void checkbattle(Player player) {
        int headcnt = 0, head = 0;
        for (int i = 0; i < board.players.length; i++) {
            //to check if there are players in the same tile excluding the player himself
            if ((board.players[i].getPosition() == player.getPosition()) && board.players[i].getName() != player.getName()) {
                // to count num of players in the tile
                headcnt++;
                // set index to variable [note: if the headcnt != 1, the variable head is no longer needed]
                head = i;
            }
        }
        // if there is only one player in the tile
        if (headcnt == 1) {
            // and if both players are at least level 5
            if (player.getLevel() >= 5 && board.players[head].getLevel() >= 5) {
                // battle player
                battlePlayer(player, board.players[head]);
                battleWithMonster = false;
            }
        }
    }

    // battle against player 
    public void battlePlayer(Player player, Player player1) {
        // player 
        System.out.println("Player will fight with Player "+ player1.getName());
        battle:
        while(player.getHp()>0 && player1.getHp()>0) {
            System.out.println("-->  Now is Player "+player.getName()+"'s turn <--");
            System.out.println("Choose your option 1.Attack  2.Item ");
            int option = sc.nextInt();
            switch (option) {
                case 1: //attack
                    player1.setHp(-(player.attack(player.getStrength(), player1.getDefence())));
                    break;
                case 2: // player can choose weapon from his backpack
                    if(player.getItem().contains("Smoke Bomb")){
                        System.out.println("You have smoke bomb. Do you wish to use it to flee?");
                        String ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("yes")){
                            System.out.println("You escaped this battle using your Smoke Bomb. ");
                            player.item.remove("Smoke Bomb");
                            //flee from battle
                            player.flee();
                            System.out.println("- No rewards for both players ! -");
                            break battle;
                        }
                    }
                    player.item();
                    break;
            }
        
            // player 1 
            System.out.println("-->  Now is Player "+player1.getName()+"'s turn <--");
            System.out.println("Choose your option 1.Attack  2.Item ");
            int option1 = sc.nextInt();
            switch (option1) {
                case 1: //attack
                    player.setHp(-(player1.attack(player1.getStrength(), player.getDefence())));
                    break;
                case 2: // player1 can choose weapon from his backpack
                    if(player.getItem().contains("Smoke Bomb")){
                        System.out.println("You have smoke bomb. Do you wish to use it to flee?");
                        String ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("yes")){
                            System.out.println("You escaped this battle using your Smoke Bomb. ");
                            player.item.remove("Smoke Bomb");
                            //flee from battle
                            player.flee();
                            System.out.println("- No rewards for both players ! -");
                            break battle;
                        }
                    }
                    player.item();
                    break;
            }
        }
        if (player.getHp() <= 0) {
            System.out.println("--------------------------------------------------");
            System.out.println("        Player " + player.getName() + ",you have lost this battle");
            System.out.println("--------------------------------------------------");
            System.out.println("Congratulations ! Player " + player1.getName() +"!");
            player1.setGold(30);
            player1.setExp(30);
            System.out.println("Your are rewarded with gold and EXP!\nCheck out your new Statistics:\n"+ player1.toString());
        } 
        if(player1.getHp()<=0){
            System.out.println("--------------------------------------------------");
            System.out.println("        Player "+player1.getName()+",you have lost this battle");
            System.out.println("--------------------------------------------------");
            System.out.println("Congratulations ! Player " + player.getName() +"!");
            player.setGold(30);
            player.setExp(30);
            System.out.println("Your are rewarded with gold and EXP!\nCheck out your new Statistics:\n"+ player.toString());
        }
    }

    // battle against monster
    public void battleMonster(Player player, Monsters monster) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Monster's stats\n" + monster.toString());
        battle:
        while (player.getHp() > 0 && monster.getHp() > 0) {
            if (monster.getHp() < 12)
                System.out.println("[Monster's HP is low !Attack!]");
            System.out.println("---> Fighting monster <---");
            System.out.println("Choose your option 1.Attack  2.Item  3.Flee");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    int damage = player.attack(player.getStrength(), monster.getDefence()); //damage towards monster
                    monster.setHp(-damage);
                    try {
                        // thread to sleep for 1000 milliseconds
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println();
                    }
                    System.out.println("You dealed a DAMAGE of " + damage + " onto the monster.");
                    if (monster.getHp() <= 0) {
                        System.out.println("Monster's current hp :" + monster.getHp());
                        break battle;
                    } else
                        System.out.println("Monster's current hp :" + monster.getHp());
                    System.out.println();
                    break;
                case 2:// player can choose weapon from his backpack
                    player.item();
                    break;
                case 3:
                    if (player.getWeapon().contains("Smoke Bomb")) {
                        System.out.println("You escaped this battle using your Smoke Bomb. ");
                        player.weapon.remove("Smoke Bomb");
                        System.out.println("Your backpack is left with :" + player.getItem());
                        break battle;
                    } else if (player.getAgility() > monster.getAgility()) {
                        player.flee();
                        break battle;
                    } else {
                        System.out.println("--------------------------------------------------");
                        System.out.println("     Opps ! You can't escape from the battle.     ");
                        System.out.println("--------------------------------------------------");
                    }
            }

            System.out.println("---> Monster's turn to attack <---\n");
            int damage = monster.attack(monster.getStrength(), player.getDefence()); //damage towards player
            player.setHp(-damage);
            try {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println();
            }
            System.out.println("The monster hit you with a DAMAGE dealed " + damage);
            if (player.getHp() > 0 && player.getHp() < 12)
                System.out.println("Player's current hp : " + player.getHp() + " [Consider get item to prevent being defeated!]");
            else
                System.out.println("Player's current hp : " + player.getHp());
            System.out.println();
        }
        if (player.getHp() <= 0) {
            System.out.println("--------------------------------------------------");
            System.out.println("       Player " + player.getName() + ", you have lost this battle.");
            System.out.println("--------------------------------------------------");
        }
        if (monster.getHp() <= 0) {
            System.out.println("Monster is defeated.");
            player.setGold(30);
            player.setExp(30);
            player.setNoOfMonsterEncounter(1);
            player.levelUp();
            System.out.println("Your are rewarded with gold and EXP!\nCheck out your new Statistics:\n" + player.toString());
        }
        player.resetHp(25);
        monster.resetHp(30);
    }
    
     //item drop system
    public void itemDrop(Player player, Monsters monster){
      String []itemDrop ={"Potion","Hi-Potion","Smoke bomb","Poison"};
      String drop;
      
      if(player.getNoOfMonsterEncounter()%3==0){
          drop=itemDrop[r.nextInt(itemDrop.length)]; //randomise the index
                if(drop.equals(itemDrop[0])){
                    player.item.add("Potion");
                }else if (drop.equals(itemDrop[1])){
                    player.item.add("Hi-Potion");
                }else if (drop.equals(itemDrop[2])){
                    player.item.add("Smoke bomb");
                }else{
                    player.item.add("Poison");
                }
       System.out.println(" You got " + drop);
    }
}
}


}
