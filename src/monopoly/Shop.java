package monopoly;

public class Shop extends Square{
    public Shop(String name) {
        this.name = name;
    }

    public void event(Player player){
        int choice=0;
        System.out.println("Welcome to Mystery shop!");
        System.out.println("You current gold: " + player.getGold());

        while(choice!=4){

            System.out.println("\nOption: 1.Buy items and weapons  2.Sell items and weapons  3.Upgrade weapons  4.Exit ");
            System.out.print("Your option: ");
            choice=sc.nextInt();
            System.out.println();

            switch(choice){
                case 1: //buy item and weapon
                    if(player.getGold()>0){ //can buy only if have money
                        System.out.println("Items sell as below:");
                        System.out.printf("%-10s%5s%15s%12s%10s\n","No","Items","Strength","Defence","Gold");
                        System.out.printf("%-10s%5s%11s%11s%13s\n","1.","Potion","2","3","8");
                        System.out.printf("%-10s%5s%8s%11s%13s\n","2.","Hi-Potion","4","6","12");
                        System.out.printf("%-10s%5s%7s%11s%13s\n","3.","Smoke bomb","3","5","9");
                        System.out.printf("%-10s%5s%11s%11s%13s\n","4.","Poison","7","3","15");
                        System.out.println("");
                        System.out.println("Weapons sell as below:");
                        System.out.printf("%-10s%5s%15s%12s%10s\n","No","Items","Strength","Defence","Gold");
                        System.out.printf("%-10s%5s%12s%11s%13s\n","5.","Sword","10","10","6");
                        System.out.printf("%-10s%5s%12s%11s%13s\n","6.","Spear","10","11","12");
                        System.out.printf("%-10s%5s%7s%11s%13s\n","7.","Wooden axe","13","12","15");
                        System.out.printf("%-10s%5s%11s%11s%13s\n","8.","Shield","15","19","18");
                        System.out.printf("%-10s%5s%8s%11s%13s\n","9.","Crossbows","15","16","20");
                        System.out.printf("%-10s%4s%13s%11s%13s\n","10.","Bows","18","18","22");
                        System.out.printf("%-10s%5s%9s%11s%13s\n","11.","Tridents","18","18","25");
                        System.out.printf("%-10s%5s%12s%11s%13s\n","12.","Armor","20","20","30");
                        System.out.print("Select the item / weapon that you would like to buy: ");
                        int itemBuy=sc.nextInt();
                        System.out.println("");

                        switch(itemBuy){
                            case 1:
                                player.setGold(-8);
                                player.weapon.add("Potion");
                                System.out.println("You successfully bought a potion");
                                break;
                            case 2:
                                player.setGold(-12);
                                player.weapon.add("Hi-Potion");
                                System.out.println("You successfully bought a hi-potion");
                                break;
                            case 3:
                                player.setGold(-9);
                                player.weapon.add("Smoke bomb");
                                System.out.println("You successfully bought a smoke bomb");
                                break;
                            case 4:
                                player.setGold(-15);
                                player.weapon.add("Poison");
                                System.out.println("You successfully bought a poison");
                                break;
                            case 5:
                                player.setGold(-6);
                                player.weapon.add("Sword");
                                System.out.println("You successfully bought a sword");
                                break;
                            case 6:
                                player.setGold(-12);
                                player.weapon.add("Spear");
                                System.out.println("You successfully bought a spear");
                                break;
                            case 7:
                                player.setGold(-15);
                                player.weapon.add("Wooden axe");
                                System.out.println("You successfully bought a wooden axe");
                                break;
                            case 8:
                                player.setGold(-18);
                                player.weapon.add("Shield");
                                System.out.println("You successfully bought a shield");
                                break;
                            case 9:
                                player.setGold(-20);
                                player.weapon.add("Crossbows");
                                System.out.println("You successfully bought a crossbows");
                                break;
                            case 10:
                                player.setGold(-22);
                                player.weapon.add("Bows");
                                System.out.println("You successfully bought a bows");
                                break;
                            case 11:
                                player.setGold(-25);
                                player.weapon.add("Tridents");
                                System.out.println("You successfully bought a tridents");
                                break;
                            case 12:
                                player.setGold(-30);
                                player.weapon.add("Armor");
                                System.out.println("You successfully bought an armor");
                                break;
                        }
                    }else{
                        System.out.println("You don't have enough money to buy.");
                        break;
                    }
                    break;

                case 2: //sell item
                    String itemSell;
                    System.out.println("Option: 1.Sell item  2.Sell weapon");
                    System.out.print("Your option: ");
                    int option=sc.nextInt();
                    System.out.println();

                    if(option==1){
                        System.out.println("Item you have: " +player.getWeapon());
                        System.out.println("Which item you want to sell?");
                        sc.nextLine();
                        itemSell=sc.nextLine();
                        boolean sell=false;

                        for(String item:player.getWeapon()){
                            if(itemSell.equalsIgnoreCase("Potion")){
                                player.setGold(8);
                                player.weapon.remove("Potion");
                                System.out.println("You successfully sold a Potion");
                                sell=true;
                                break;
                            }
                            if(itemSell.equalsIgnoreCase("Hi-Potion")){
                                player.setGold(12);
                                player.weapon.remove("Hi-Potion");
                                System.out.println("You successfully sold a Hi-Potion");
                                sell=true;
                                break;
                            }
                            if(itemSell.equalsIgnoreCase("Smoke bomb")){
                                player.setGold(9);
                                player.weapon.remove("Smoke bomb");
                                System.out.println("You successfully sold a Smoke bomb");
                                sell=true;
                                break;
                            }
                            if(itemSell.equalsIgnoreCase("Poison")){
                                player.setGold(15);
                                player.weapon.remove("Posion");
                                System.out.println("You successfully sold a Poison");
                                sell=true;
                                break;
                            }
                        }
                        if(!sell){
                            System.out.println("Opps!You dont have this item to sell.");
                        }
                    }else {
                        System.out.println("Weapon you have: " +player.getWeapon());
                        System.out.println("Which weapon you want to sell?");
                        sc.nextLine();
                        String weaponSell=sc.nextLine();
                        boolean sell=false;

                        for(String weapon:player.getWeapon()){
                            if(weaponSell.equalsIgnoreCase("Sword")){
                                player.setGold(6);
                                player.weapon.remove("Sword");
                                System.out.println("You successfully sold a Sword");
                                sell=true;
                                break;
                            }
                            if(weaponSell.equalsIgnoreCase("Spear")){
                                player.setGold(12);
                                player.weapon.remove("Spear");
                                System.out.println("You successfully sold a Spear");
                                sell=true;
                                break;
                            }
                            if(weaponSell.equalsIgnoreCase("Wooden axe")){
                                player.setGold(15);
                                player.weapon.remove("Wooden axe");
                                System.out.println("You successfully sold a Wooden axe");
                                sell=true;
                                break;
                            }
                            if(weaponSell.equalsIgnoreCase("Shield")){
                                player.setGold(18);
                                player.weapon.remove("Shield");
                                System.out.println("You successfully sold a Shield");
                                sell=true;
                                break;
                            }
                            if(weaponSell.equalsIgnoreCase("Crossbows")){
                                player.setGold(20);
                                player.weapon.remove("Crossbows");
                                System.out.println("You successfully sold a Crossbows");
                                sell=true;
                                break;
                            }
                            if(weaponSell.equalsIgnoreCase("Bows")){
                                player.setGold(22);
                                player.weapon.remove("Bows");
                                System.out.println("You successfully sold a Bows");
                                sell=true;
                                break;
                            }
                            if(weaponSell.equalsIgnoreCase("Tridents")){
                                player.setGold(25);
                                player.weapon.remove("Tridents");
                                System.out.println("You successfully sold a Tridents");
                                sell=true;
                                break;
                            }
                            if(weaponSell.equalsIgnoreCase("Armor")){
                                player.setGold(30);
                                player.weapon.remove("Armor");
                                System.out.println("You successfully sold a Armor");
                                sell=true;
                                break;
                            }
                        }
                        if(!sell){
                            System.out.println("Opps!You dont have this item to sell.");
                        }
                    }
                    break;

                case 3://upgrade weapon
                    if(player.getGold()>0){
                        System.out.println("Option: 1.Upgrade item  2.Upgrade weapon");
                        System.out.print("Your option: ");
                        option=sc.nextInt();
                        System.out.println();

                        if(option==1){
                            System.out.println("Items can be upgraded as below:");
                            System.out.printf("%-10s%5s%15s%12s%10s\n","No","Items","Strength","Defence","Gold");
                            System.out.printf("%-10s%5s%11s%11s%13s\n","1.","Potion","4","6","16");
                            System.out.printf("%-10s%5s%8s%11s%13s\n","2.","Hi-Potion","8","12","24");
                            System.out.printf("%-10s%5s%7s%11s%13s\n","3.","Smoke bomb","6","10","18");
                            System.out.printf("%-10s%5s%11s%11s%13s\n","4.","Poison","14","6","30");
                            System.out.println("");
                            System.out.println("Item you have: " +player.getWeapon());
                            System.out.println("Which item you want to upgrade?");
                            sc.nextLine();
                            String itemUpgrade=sc.nextLine();
                            boolean upgrade=false;

                            for(String item:player.getWeapon()){
                                if(itemUpgrade.equalsIgnoreCase("Potion")){
                                    player.setGold(-16);
                                    System.out.println("You successfully upgrade a Potion");
                                    upgrade=true;
                                    break;
                                }
                                if(itemUpgrade.equalsIgnoreCase("Hi-Potion")){
                                    player.setGold(-24);
                                    System.out.println("You successfully upgrade a Hi-Potion");
                                    upgrade=true;
                                    break;
                                }
                                if(itemUpgrade.equalsIgnoreCase("Smoke bomb")){
                                    player.setGold(-18);
                                    System.out.println("You successfully upgrade a Smoke bomb");
                                    upgrade=true;
                                    break;
                                }
                                if(itemUpgrade.equalsIgnoreCase("Poison")){
                                    player.setGold(-30);
                                    System.out.println("You successfully upgrade a Poison");
                                    upgrade=true;
                                    break;
                                }

                            }
                            if(!upgrade){
                                System.out.println("Opps!You dont have this item to upgrade.");
                            }
                        }else{
                            System.out.println("Weapons can be upgraded as below:");
                            System.out.printf("%-10s%5s%15s%12s%10s\n","No","Items","Strength","Defence","Gold");
                            System.out.printf("%-10s%5s%12s%11s%13s\n","1..","Sword","6","4","12");
                            System.out.printf("%-10s%5s%12s%11s%13s\n","2.","Spear","8","10","24");
                            System.out.printf("%-10s%5s%7s%11s%13s\n","3.","Wooden axe","12","10","30");
                            System.out.printf("%-10s%5s%11s%11s%13s\n","4.","Shield","12","12","36");
                            System.out.printf("%-10s%5s%8s%11s%13s\n","5.","Crossbows","10","16","40");
                            System.out.printf("%-10s%4s%13s%11s%13s\n","6.","Bows","14","10","44");
                            System.out.printf("%-10s%5s%9s%11s%13s\n","7.","Tridents","16","20","50");
                            System.out.printf("%-10s%5s%12s%11s%13s\n","8.","Armor","16","24","60");
                            System.out.println("Weapon you have: " +player.getWeapon());
                            System.out.println("Which weapon you want to upgrade?");
                            sc.nextLine();
                            String weaponUp=sc.nextLine();
                            boolean upgrade=false;

                            for(String weapon:player.getWeapon()){
                                if(weaponUp.equalsIgnoreCase("Sword")){
                                    player.setGold(-12);
                                    System.out.println("You successfully upgrade a Sword");
                                    upgrade=true;
                                    break;
                                }
                                if(weaponUp.equalsIgnoreCase("Spear")){
                                    player.setGold(-24);
                                    System.out.println("You successfully upgrade a Spear");
                                    upgrade=true;
                                    break;
                                }
                                if(weaponUp.equalsIgnoreCase("Wooden axe")){
                                    player.setGold(-30);
                                    System.out.println("You successfully upgrade a Wooden axe");
                                    upgrade=true;
                                    break;
                                }
                                if(weaponUp.equalsIgnoreCase("Shield")){
                                    player.setGold(-36);
                                    System.out.println("You successfully upgrade a Shield");
                                    upgrade=true;
                                    break;
                                }
                                if(weaponUp.equalsIgnoreCase("Crossbows")){
                                    player.setGold(-40);
                                    System.out.println("You successfully upgrade a Crossbows");
                                    upgrade=true;
                                    break;
                                }
                                if(weaponUp.equalsIgnoreCase("Bows")){
                                    player.setGold(-44);
                                    System.out.println("You successfully upgrade a Bows");
                                    upgrade=true;
                                    break;
                                }
                                if(weaponUp.equalsIgnoreCase("Tridents")){
                                    player.setGold(-50);
                                    System.out.println("You successfully upgrade a Tridents");
                                    upgrade=true;
                                    break;
                                }
                                if(weaponUp.equalsIgnoreCase("Armor")){
                                    player.setGold(-60);
                                    System.out.println("You successfully upgrade a Armor");
                                    upgrade=true;
                                    break;
                                }

                            }
                            if(!upgrade){
                                System.out.println("Opps!You dont have this item to upgrade.");
                            }
                        }
                    }else{
                        System.out.println("You don't have enough money to upgrade.");
                    }
            }
            System.out.println("You current gold: " + player.getGold());
        }

        System.out.println("Thank you and have a nice day!");
    }

}