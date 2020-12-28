
package monopoly;

public class Shop extends Square{
    public Shop(String name) {
        this.name = name;
    }

    public void event(Player player){
        int choice=0;
        System.out.println("Welcome to Mystery shop!");
        System.out.println("\nYour current hp: " + player.getHp());
        System.out.println("Your current strength: " + player.getStrength());
        System.out.println("You current gold: " + player.getGold());
        while(choice!=6){
            System.out.println("\nOption: 1.Buy items  2.Sell items  3.Buy weapons  4.Sold weapons  5.Upgrade weapons  6.Exit ");
            System.out.print("Your option: ");
            choice=sc.nextInt();
            System.out.println();

            switch(choice){
                case 1: //buy item
                    System.out.println("Items sell as below:");
                    System.out.printf("%-10s%5s%12s%15s%10s\n","No","Items","HP","Strength","Gold");
                    System.out.printf("%-10s%5s%11s%11s%13s\n","1.","Potion","10","15","40");
                    System.out.printf("%-10s%5s%8s%11s%13s\n","2.","Hi-Potion","15","15","60");
                    System.out.printf("%-10s%5s%7s%11s%13s\n","3.","Smoke bomb","20","25","80");
                    System.out.printf("%-10s%5s%11s%11s%13s\n","4.","Poison","30","25","100");
                    System.out.print("Select the item that you would like to buy: ");
                    int itemBuy=sc.nextInt();
                    System.out.println("");

                    switch(itemBuy){
                        case 1:
                            player.setHp(10);
                            player.setStrength(15);
                            player.setGold(-40);
                            player.item.add("Potion");
                            System.out.println("You successfully bought a potion");
                            break;
                        case 2:
                            player.setHp(15);
                            player.setStrength(15);
                            player.setGold(-60);
                            System.out.println("You successfully bought a hi-potion");
                            break;
                        case 3:
                            player.setHp(20);
                            player.setStrength(25);
                            player.setGold(-80);
                            System.out.println("You successfully bought a smoke bomb");
                            break;
                        case 4:
                            player.setHp(30);
                            player.setStrength(25);
                            player.setGold(-100);
                            System.out.println("You successfully bought a poison");
                            break;
                    }
                    break;
                case 2: //sell item
                    System.out.println("The item you have: " +player.getItem());
                    System.out.println("Which item do you want to sell?");
                   /* System.out.printf("%-10s%5s%12s%15s%10s\n","No","Items","HP","Strength","Gold");
                    System.out.printf("%-10s%5s%11s%11s%13s\n","1.","Potion","10","15","40");
                    System.out.printf("%-10s%5s%8s%11s%13s\n","2.","Hi-Potion","15","15","60");
                    System.out.printf("%-10s%5s%7s%11s%13s\n","3.","Smoke bomb","20","25","80");
                    System.out.printf("%-10s%5s%11s%11s%13s\n","4.","Poison","30","25","100");
                    System.out.print("Select the item that you would like to sell:");
                    int itemSell=sc.nextInt();
                    System.out.println("");

                    switch(itemSell){
                        case 1:
                            player.setHp(-10);
                            player.setStrength(-15);
                            player.setGold(40);
                            System.out.println("You successfully sold a potion");
                            break;
                        case 2:
                            player.setHp(-15);
                            player.setStrength(-15);
                            player.setGold(60);
                            System.out.println("You successfully sold a hi-potion");
                            break;
                        case 3:
                            player.setHp(-20);
                            player.setStrength(-25);
                            player.setGold(80);
                            System.out.println("You had sold a smoke bomb");
                            break;
                        case 4:
                            player.setHp(-30);
                            player.setStrength(-25);
                            player.setGold(100);
                            System.out.println("You had sold a poison");
                            break;
                    }*/
                    break;
                case 3: //buy weapons
                    System.out.println("Weapons sell as below:");
                    System.out.printf("%-10s%5s%12s%15s%10s\n","No","Weapons","HP","Strength","Gold");
                    System.out.printf("%-10s%5s%14s%11s%13s\n","1.","Sword","10","10","30");
                    System.out.printf("%-10s%5s%14s%11s%13s\n","2.","Spear","15","20","40");
                    System.out.printf("%-10s%5s%9s%11s%13s\n","3.","Wooden axe","5","10","25");
                    System.out.printf("%-10s%5s%13s%11s%13s\n","4.","Shield","20","25","80");
                    System.out.printf("%-10s%5s%10s%11s%13s\n","5.","Crossbows","30","25","100");
                    System.out.printf("%-10s%4s%15s%11s%13s\n","6.","Bows","15","15","35");
                    System.out.printf("%-10s%5s%11s%11s%13s\n","7.","Tridents","25","30","120");
                    System.out.printf("%-10s%5s%14s%11s%13s\n","8.","Armor","40","30","180");
                    System.out.print("Select the weapon that you would like to buy: ");
                    int weaponBuy=sc.nextInt();
                    System.out.println("");

                    switch(weaponBuy){
                        case 1:
                            player.setHp(10);
                            player.setStrength(10);
                            player.setGold(-30);
                            System.out.println("You successfully bought a sword");
                            break;
                        case 2:
                            player.setHp(15);
                            player.setStrength(20);
                            player.setGold(-40);
                            System.out.println("You successfully bought a spear");
                            break;
                        case 3:
                            player.setHp(5);
                            player.setStrength(10);
                            player.setGold(-25);
                            System.out.println("You successfully bought a wooden axe");
                            break;
                        case 4:
                            player.setHp(20);
                            player.setStrength(25);
                            player.setGold(-80);
                            System.out.println("You successfully bought a shield");
                            System.out.println("Your current hp: " + player.getHp());
                            break;
                        case 5:
                            player.setHp(30);
                            player.setStrength(25);
                            player.setGold(-100);
                            System.out.println("You successfully bought a crossbows");
                            break;
                        case 6:
                            player.setHp(15);
                            player.setStrength(15);
                            player.setGold(-35);
                            System.out.println("You successfully bought bows");
                            break;
                        case 7:
                            player.setHp(25);
                            player.setStrength(30);
                            player.setGold(-120);
                            System.out.println("You successfully bought a tridents");
                            break;
                        case 8:
                            player.setHp(40);
                            player.setStrength(30);
                            player.setGold(-180);
                            System.out.println("You successfully bought a armor");
                    }
                    break;
                case 4: //sell weapon
                    System.out.printf("%-10s%5s%12s%15s%10s\n","No","Weapons","HP","Strength","Gold");
                    System.out.printf("%-10s%5s%14s%11s%13s\n","1.","Sword","10","10","30");
                    System.out.printf("%-10s%5s%14s%11s%13s\n","2.","Spear","15","20","40");
                    System.out.printf("%-10s%5s%9s%11s%13s\n","3.","Wooden axe","5","10","25");
                    System.out.printf("%-10s%5s%13s%11s%13s\n","4.","Shield","20","25","80");
                    System.out.printf("%-10s%5s%10s%11s%13s\n","5.","Crossbows","30","25","100");
                    System.out.printf("%-10s%4s%15s%11s%13s\n","6.","Bows","15","15","35");
                    System.out.printf("%-10s%5s%11s%11s%13s\n","7.","Tridents","25","30","120");
                    System.out.printf("%-10s%5s%14s%11s%13s\n","8.","Armor","40","30","180");
                    System.out.print("Select the weapon that you would like to sell: ");
                    int weaponSell=sc.nextInt();
                    System.out.println("");

                    switch(weaponSell){
                        case 1:
                            player.setHp(-10);
                            player.setStrength(-10);
                            player.setGold(30);
                            System.out.println("You successfully sold a sword");
                            break;
                        case 2:
                            player.setHp(-15);
                            player.setStrength(-20);
                            player.setGold(40);
                            System.out.println("You successfully sold a spear");
                            break;
                        case 3:
                            player.setHp(-5);
                            player.setStrength(-10);
                            player.setGold(25);
                            System.out.println("You successfully sold a wooden axe");
                            break;
                        case 4:
                            player.setHp(-20);
                            player.setStrength(-25);
                            player.setGold(80);
                            System.out.println("You successfully sold a shield");
                            System.out.println("Your current hp: " + player.getHp());
                            break;
                        case 5:
                            player.setHp(-30);
                            player.setStrength(-25);
                            player.setGold(100);
                            System.out.println("You successfully sold a crossbows");
                            break;
                        case 6:
                            player.setHp(-15);
                            player.setStrength(-15);
                            player.setGold(35);
                            System.out.println("You successfully sold a bows");
                            break;
                        case 7:
                            player.setHp(-25);
                            player.setStrength(-30);
                            player.setGold(120);
                            System.out.println("You successfully sold a tridents");
                            break;
                        case 8:
                            player.setHp(-40);
                            player.setStrength(-30);
                            player.setGold(180);
                            System.out.println("You successfully sold a armor");
                            break;
                    }
                    break;
                case 5: //upgrade weapon
                    System.out.println("Weapons can be upgrade are as below:");
                    System.out.printf("%-10s%5s%12s%15s%10s\n","No","Weapons","HP","Strength","Gold");
                    System.out.printf("%-10s%5s%14s%11s%13s\n","1.","Sword","20","20","60");
                    System.out.printf("%-10s%5s%14s%11s%13s\n","2.","Spear","30","40","80");
                    System.out.printf("%-10s%5s%9s%11s%13s\n","3.","Wooden axe","10","20","50");
                    System.out.printf("%-10s%5s%13s%11s%13s\n","4.","Shield","40","50","160");
                    System.out.printf("%-10s%5s%10s%11s%13s\n","5.","Crossbows","60","50","200");
                    System.out.printf("%-10s%4s%15s%11s%13s\n","6.","Bows","30","30","70");
                    System.out.printf("%-10s%5s%11s%11s%13s\n","7.","Tridents","50","60","240");
                    System.out.printf("%-10s%5s%14s%11s%13s\n","8.","Armor","80","60","360");
                    System.out.print("Select the weapon that you would like to upgrade: ");
                    int weaponUpgrade=sc.nextInt();
                    System.out.println(" ");

                    switch(weaponUpgrade){
                        case 1:
                            player.setHp(20);
                            player.setStrength(20);
                            player.setGold(-60);
                            System.out.println("You successfully upgrade a sword");
                            break;
                        case 2:
                            player.setHp(30);
                            player.setStrength(40);
                            player.setGold(-80);
                            System.out.println("You successfully upgrade a spear");
                            break;
                        case 3:
                            player.setHp(10);
                            player.setStrength(20);
                            player.setGold(-50);
                            System.out.println("You successfully upgrade a wooden axe");
                            break;
                        case 4:
                            player.setHp(40);
                            player.setStrength(50);
                            player.setGold(-160);
                            System.out.println("You successfully upgrade a shield");
                            break;
                        case 5:
                            player.setHp(60);
                            player.setStrength(50);
                            player.setGold(-200);
                            System.out.println("You successfully upgrade a crossbows");
                            break;
                        case 6:
                            player.setHp(30);
                            player.setStrength(30);
                            player.setGold(-70);
                            System.out.println("You successfully upgrade a bows");
                            break;
                        case 7:
                            player.setHp(50);
                            player.setHp(60);
                            player.setGold(-240);
                            System.out.println("You successfully upgrade a tridents");
                            break;
                        case 8:
                            player.setHp(80);
                            player.setStrength(60);
                            player.setGold(-360);
                            System.out.println("You successfully upgrade a armor");
                            break;
                    }
                    break;
            }
            System.out.println("Your current hp: " + player.getHp());
            System.out.println("Your current strength: " + player.getStrength());
            System.out.println("You current gold: " + player.getGold());
        }
        System.out.println("Thank you and have a nice day!");
    }
}


    
