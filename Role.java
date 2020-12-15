package monopoly;

public abstract class Role {
    int level,hp,strength,defence, agility,exp,gold;

    public Role() {
        level=1; hp=25; strength=5; defence=5; agility=5; exp=5;
        gold=200;
    }
    public abstract void attack();

    public abstract void item();

    public abstract void flee();

}
