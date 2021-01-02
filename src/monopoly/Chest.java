import java.util.Random;

 public class Chest extends Square{
    public Chest(String name) {
        this.name = name;
    }
    @Override
    public void event(Player player){
        Random r= new Random();
        String rare;
        String[]rareItem={"Master Sword","Blade of Chaos","Key Blade","Hidden Blade","Gravity Gun"};     
        System.out.println("You can open a treasure chest");
        System.out.println("");
        System.out.println("Choose 1 or 2: ");
        int choose =sc.nextInt();
        
        switch(choose){
            case 1:
                   int gold =r.nextInt(101);
                   player.setGold(gold);
                   System.out.println("Congratulations! You got " + gold + " gold as reward");
                   break;
        
            case 2:
                   rare=rareItem[r.nextInt(rareItem.length)]; //randomise the index
                   if(rare==rareItem[0]){
                         //player.setHp(2);
                         //player.setStrength(5);
                         player.item.add("Master Sword");
                    }else if (rare==rareItem[1]){
                         //player.setHp(3);
                         //player.setStrength(4);
                         player.item.add("Blade of Chaos");
                    }else if (rare==rareItem[2]){
                         //player.setHp(5);
                         //player.setStrength(4);
                         player.item.add("Key blade");
                    }else if(rare==rareItem[3]){
                         //player.setHp(6);
                         //player.setStrength(6);
                         player.item.add("Hidden Blade");
                    }else{
                         //player.setHp(7);
                         //player.setStrength(8);
                         player.item.add("Gravity Gun");
                    }
                   System.out.println("Congratulations! You got " + rare +" as reward");
                   break;
        }
       
  
    }

}
    

