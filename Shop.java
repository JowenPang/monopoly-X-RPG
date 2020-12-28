import java.util.Scanner;

/**
 *
 * @author User
 */
public class Shop {
     Scanner sc= new Scanner (System.in);
     
    int hp,strength,gold;

    public void Shop(){
    int choice=0;
    System.out.println("Welcome to the shop!");
    while(choice!=6){
       System.out.println("");
       System.out.println("Option: 1.Buy items  2.Sell items  3.Buy weapons  4.Sold weapons  5.Upgrade weapons  6.Exit ");
       System.out.print("Your option: ");
       choice=sc.nextInt();
       System.out.println("");
    
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
                        hp+=10;
                        strength+=15;
                        gold-=40;
                        System.out.println("You successfully bought a potion");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                    case 2:
                        hp+=15;
                        strength+=15;
                        gold-=60;
                        System.out.println("You successfully bought a hi-potion");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                    case 3:
                        hp+=20;
                        strength+=25;
                        gold-=80;
                        System.out.println("You successfully bought a smoke bomb");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                    case 4:
                        hp+=30;
                        strength+=25;
                        gold-=100;
                        System.out.println("You successfully bought a poison");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                        
                }
                break;
           case 2: //sell item
                System.out.printf("%-10s%5s%12s%15s%10s\n","No","Items","HP","Strength","Gold");
                System.out.printf("%-10s%5s%11s%11s%13s\n","1.","Potion","10","15","40");
                System.out.printf("%-10s%5s%8s%11s%13s\n","2.","Hi-Potion","15","15","60");
                System.out.printf("%-10s%5s%7s%11s%13s\n","3.","Smoke bomb","20","25","80");
                System.out.printf("%-10s%5s%11s%11s%13s\n","4.","Poison","30","25","100");
                System.out.print("Select the item that you would like to sell:");
                int itemSell=sc.nextInt();
                System.out.println("");
             
                switch(itemSell){
                    case 1:
                        hp-=10;
                        strength-=15;
                        gold+=40;
                        System.out.println("You successfully sold a potion");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                    case 2:
                        hp-=15;
                        strength-=15;
                        gold+=60;
                        System.out.println("You successfully sold a hi-potion");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                    case 3:
                        hp-=20;
                        strength-=25;
                        gold+=80;
                        System.out.println("You had sold a smoke bomb");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                    case 4:
                        hp-=30;
                        strength-=25;
                        gold+=100;
                        System.out.println("You had sold a poison");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                }
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
                        hp+=10;
                        strength+=10;
                        gold-=30;
                        System.out.println("You successfully bought a sword");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 2:
                        hp+=15;
                        strength+=20;
                        gold-=40;
                        System.out.println("You successfully bought a spear");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                       break;
                   case 3:
                        hp+=5;
                        strength+=10;
                        gold-=25;
                        System.out.println("You successfully bought a wooden axe");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 4:
                        hp+=20;
                        strength+=25;
                        gold-=80;
                        System.out.println("You successfully bought a shield");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 5:
                        hp+=30;
                        strength+=25;
                        gold-=100;
                        System.out.println("You successfully bought a crossbows");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 6:
                        hp+=15;
                        strength+=15;
                        gold-=35;
                        System.out.println("You successfully bought bows");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 7:
                        hp+=25;
                        strength+=30;
                        gold-=120;
                        System.out.println("You successfully bought a tridents");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 8:
                        hp+=40;
                        strength+=30;
                        gold-=180;
                        System.out.println("You successfully bought a armor");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
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
                        hp-=10;
                        strength-=10;
                        gold+=30;
                        System.out.println("You successfully sold a sword");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 2:
                        hp-=15;
                        strength-=20;
                        gold+=40;
                        System.out.println("You successfully sold a spear");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 3:
                        hp-=5;
                        strength-=10;
                        gold+=25;
                        System.out.println("You successfully sold a wooden axe");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 4:
                        hp-=20;
                        strength-=25;
                        gold+=80;
                        System.out.println("You successfully sold a shield");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 5:
                        hp-=30;
                        strength-=25;
                        gold+=100;
                        System.out.println("You successfully sold a crossbows");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 6:
                        hp-=15;
                        strength-=15;
                        gold+=35;
                        System.out.println("You successfully sold a bows");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 7:
                        hp-=25;
                        strength-=30;
                        gold+=120;
                        System.out.println("You successfully sold a tridents");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 8:
                        hp-=40;
                        strength-=30;
                        gold+=180;
                        System.out.println("You successfully sold a armor");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
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
                        hp+=20;
                        strength+=20;
                        gold-=60;
                        System.out.println("You successfully upgrade a sword");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 2:
                        hp+=30;
                        strength+=40;
                        gold-=80;
                        System.out.println("You successfully upgrade a spear");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 3:
                        hp+=10;
                        strength+=20;
                        gold-=50;
                        System.out.println("You successfully upgrade a wooden axe");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 4:
                        hp+=40;
                        strength+=50;
                        gold-=160;
                        System.out.println("You successfully upgrade a shield");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 5:
                        hp+=60;
                        strength+=50;
                        gold-=200;
                        System.out.println("You successfully upgrade a crossbows");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 6:
                        hp+=30;
                        strength+=30;
                        gold-=70;
                        System.out.println("You successfully upgrade a bows");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 7:
                        hp+=50;
                        strength+=60;
                        gold-=240;
                        System.out.println("You successfully upgrade a tridents");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
                   case 8:
                        hp+=80;
                        strength+=60;
                        gold-=360;
                        System.out.println("You successfully upgrade a armor");
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        System.out.println("You current gold: " + gold);
                        break;
               }
               break;     
          
           
       }
    }
    System.out.println("Your current hp: " + hp);
    System.out.println("Your current strength: " +strength);
    System.out.println("You current gold: " + gold);
    System.out.println("Thank you and have a nice day!");
}
}