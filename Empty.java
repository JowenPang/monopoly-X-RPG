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
            if(player.item.contains("Hi-Potion")){
                System.out.println("Do you want to use Hi-Potion to heal yourself?");
                sc.nextLine();
                String ans=sc.nextLine();
                if(ans.equalsIgnoreCase("Yes")){
                    player.setHp(15);
                    player.setStrength(15);
                    player.item.remove("Hi-Potion");
                    System.out.println("You successfully used a Hi-Potion to heal yourself.\n");
                }else{
                    System.out.println("You choose not to use Hi-Potion to heal yourself");
                }
            }
            else{
                    System.out.println("You don't have a healing item");
                }
        }else{
            System.out.println("You choose to do nothing!");
        }
            
        System.out.println("Your current hp: " + player.getHp());
        System.out.println("Your current strength: " + player.getStrength()); 
        System.out.println("Good Day!");
    }
}
