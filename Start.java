

public class Start {
    int level, hp, strength,defence, agibility;
    
    
    public void Start(){
        System.out.println("You are now at Start");
        System.out.println("");
        level+=1;
        hp+=20;
        strength+=25;
        defence+=10;
        agibility+=10;
        System.out.println("You current level: " + level);
        System.out.println("Your current hp: " + hp);
        System.out.println("Your current strength: " + strength);
        System.out.println("Your current defence: " + defence);
        System.out.println("Your current agibility: " +agibility);
        System.out.println("");
        System.out.println("Continue enjoy the game!");
        
    }
    
}
