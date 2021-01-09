package monopoly;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Square implements Serializable {
    protected String name;
    transient Scanner sc=new Scanner(System.in);

    public abstract void event(Player player);
}
