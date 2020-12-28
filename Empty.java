import java.util.Scanner;

/**
 *
 * @author User
 */
public class Empty {
    Scanner sc= new Scanner (System.in);
    int hp, strength;
    
    public void Empty(){
        System.out.println("Welcome to the Empty!");
        System.out.println("Option: 1.Heal yourself  2.Do nothing");
        System.out.print("Your option: ");
        int option=sc.nextInt();
        System.out.println("");
        
        switch(option){
            case 1: //heal yourself
                System.out.printf("%-10s%5s%12s%15s\n","No","Items","HP","Strength");
                System.out.printf("%-10s%5s%11s%11s\n","1.","Potion","10","15");
                System.out.print("Select the item that you would like to use to heal youself: ");
                int weaponUse=sc.nextInt();
                
                switch(weaponUse){
                    case 1:
                        hp+=15;
                        strength+=15;
                        System.out.println("You successfully used Hi-Potion to heal yourself");
                        System.out.println();
                        System.out.println("Your current hp: " + hp);
                        System.out.println("Your current strength: " +strength);
                        break;
                }
                break;
            case 2: //do nothing
                System.out.println("You choose to do nothing");
                System.out.println("Your current hp: " + hp);
                System.out.println("Your current strength: " +strength);
                break;
        }
        System.out.println("Thank you!");
    }
}
