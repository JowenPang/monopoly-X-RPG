

public class Empty extends Square{
    public Empty(String name) {
        this.name = name;
    }
    
    public void event(Player player){
        System.out.println("Welcome to the Empty!");
        System.out.println("Option: 1.Heal yourself  2.Do nothing");
        System.out.print("Your option: ");
        int option=sc.nextInt();
        System.out.println();
        
     
        if(option==1){
            System.out.println("The healing item you have: " + player.getItem());
            System.out.print("Choose the healing item that you would like to use: ");
            sc.nextLine();
            String healingItem=sc.nextLine();
            boolean buy = false;
            for(String item: player.getItem()){
                if(healingItem.equalsIgnoreCase("Hi-Potion")){
                    player.setHp(15);
                    player.setStrength(15);
                    player.item.remove("Hi-potion");
                    System.out.println("You successfully used a Hi-Potion to heal yourself.\n");
                    System.out.println("Current item that you have: " + player.getItem()); // show remaining in backpack
                    buy = true;
                    break;
                }
            }
            if (!buy){
                System.out.println("Oops! You don't have current item to heal yourself yet.");
            }
        } else {
             System.out.println("You choose to do nothing");
        }
        System.out.println("Your current hp: " + player.getHp());
        System.out.println("Your current strength: " + player.getStrength()); 
        System.out.println("Good Day!");
    }
}
