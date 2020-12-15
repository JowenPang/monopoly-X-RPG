package monopoly;

public abstract class Square {


     //public abstract void position(Player player);

     public abstract void event(Player player);
}
class Start extends Square{
    @Override
    public void event(Player player){
        System.out.println("game Started");
    }

}
class Shop extends Square{
    @Override
    public void event(Player player){
        System.out.println("welcome to shop");
    }

}
class Chest extends Square{
    @Override
    public void event(Player player){
        System.out.println("You can open a treasure chest");
    }

}
class Empty extends Square{
    @Override
    public void event(Player player){
        System.out.println("You can rest");
    }

}
class Sin extends Square{
    @Override
    public void event(Player player){
        System.out.println("you will fight one monster");
    }

}
class Duo extends Square{
    @Override
    public void event(Player player){
        System.out.println("you will fight two monster");
    }

}
class Tri extends Square{
    @Override
    public void event(Player player){
        System.out.println("you will fight two monster");
    }

}
