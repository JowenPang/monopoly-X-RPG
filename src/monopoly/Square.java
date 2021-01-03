package monopoly;
import java.util.Scanner;

public abstract class Square {
    protected String name;
    Scanner sc=new Scanner(System.in);

    public abstract void event(Player player);
}





