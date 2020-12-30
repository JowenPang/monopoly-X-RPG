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
        while(choice!=4){
            System.out.println("\nOption: 1.Buy items and weapons  2.Sell items and weapons  3.Upgrade weapons  4.Exit ");
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
                    System.out.println("");
                    System.out.println("Weapons sell as below:");
                    System.out.printf("%-10s%5s%12s%15s%10s\n","No","Items","HP","Strength","Gold");
                    System.out.printf("%-10s%5s%12s%11s%13s\n","5..","Sword","10","10","30");
                    System.out.printf("%-10s%5s%12s%11s%13s\n","6.","Spear","15","20","40");
                    System.out.printf("%-10s%5s%7s%11s%13s\n","7.","Wooden axe","5","10","25");
                    System.out.printf("%-10s%5s%11s%11s%13s\n","8.","Shield","20","25","80");
                    System.out.printf("%-10s%5s%8s%11s%13s\n","9.","Crossbows","30","25","100");
                    System.out.printf("%-10s%4s%13s%11s%13s\n","10.","Bows","15","15","35");
                    System.out.printf("%-10s%5s%9s%11s%13s\n","11.","Tridents","25","30","120");
                    System.out.printf("%-10s%5s%12s%11s%13s\n","12.","Armor","40","30","180");
                    System.out.print("Select the item / weapon that you would like to buy: ");
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
                            player.item.add("Hi-potion");
                            System.out.println("You successfully bought a hi-potion");
                            break;
                        case 3:
                            player.setHp(20);
                            player.setStrength(25);
                            player.setGold(-80);
                            player.item.add("Smoke bomb");
                            System.out.println("You successfully bought a smoke bomb");
                            break;
                        case 4:
                            player.setHp(30);
                            player.setStrength(25);
                            player.setGold(-100);
                            player.item.add("Poison");
                            System.out.println("You successfully bought a poison");
                            break;
                        case 5:
                            player.setHp(10);
                            player.setStrength(10);
                            player.setGold(-30);
                            player.weapon.add("Sword");
                            System.out.println("You successfully bought a sword");
                            break;
                        case 6:
                            player.setHp(15);
                            player.setStrength(20);
                            player.setGold(-40);
                            player.weapon.add("Spear");
                            System.out.println("You successfully bought a spear");
                            break;
                        case 7:
                            player.setHp(5);
                            player.setStrength(10);
                            player.setGold(-25);
                            player.weapon.add("Wooden axe");
                            System.out.println("You successfully bought a wooden axe");
                            break;
                        case 8:
                            player.setHp(15);
                            player.setStrength(20);
                            player.setGold(-40);
                            player.weapon.add("Shield");
                            System.out.println("You successfully bought a shield");
                            break;
                        case 9:
                            player.setHp(30);
                            player.setStrength(25);
                            player.setGold(-100);
                            player.weapon.add("Crossbows");
                            System.out.println("You successfully bought a crossbows");
                            break;
                        case 10:
                            player.setHp(15);
                            player.setStrength(15);
                            player.setGold(-35);
                            player.weapon.add("Bows");
                            System.out.println("You successfully bought a bows");
                            break;
                        case 11:
                            player.setHp(25);
                            player.setStrength(30);
                            player.setGold(-120);
                            player.weapon.add("Tridents");
                            System.out.println("You successfully bought a tridents");
                            break;
                        case 12:
                            player.setHp(40);
                            player.setStrength(30);
                            player.setGold(-180);
                            player.weapon.add("Armor");
                            System.out.println("You successfully bought an armor");
                            break;
                    }
                    break;
                case 2: //sell item
                    String itemSell;
                    System.out.println("The item you have: " +player.getItem());
                    System.out.println("The weapon you have: " + player.getWeapon());
                    System.out.println("Which item / weapon do you want to sell?");
                    sc.nextLine();
                    itemSell=sc.nextLine();

                    if(itemSell.equalsIgnoreCase("Potion")){
                        player.item.remove("Potion");
                        player.setHp(-10);
                        player.setStrength(-15);
                        player.setGold(40);
                        System.out.println("You successfully sold a potion");
                    }else if (itemSell.equalsIgnoreCase("Hi-Potion")){
                        player.setHp(-15);
                        player.setStrength(-15);
                        player.setGold(60);
                        System.out.println("You successfully sold a hi-potion");
                    } else if(itemSell.equalsIgnoreCase("Smoke bomb")){
                        player.setHp(-20);
                        player.setStrength(-25);
                        player.setGold(80);
                        System.out.println("You had sold a smoke bomb");
                    } else if (itemSell.equalsIgnoreCase("Poison")){
                        player.setHp(-30);
                        player.setStrength(-25);
                        player.setGold(100);
                        System.out.println("You had sold a poison");
                    } else{
                        System.out.println("You dont have items to sell");
                    }
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

                /*case 3: //sell weapon
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
                    break;*/
                case 3: //upgrade weapon
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
                    System.out.println("The weapon you have: " + player.getWeapon());
                    System.out.print("Which weapon do you want to upgrade: ");
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