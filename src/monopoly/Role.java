package monopoly;

public abstract class Role {
    protected int level, hp, strength, defence, agility, exp, gold;
    protected String name;


    public Role() {
        level = 1;
        hp = 25;
        strength = 5;
        defence = 5;
        agility = 5;
        exp = 0;
        gold = 200;
    }

    public Role(String name, int level, int hp, int strength, int defence, int agility) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.strength = strength;
        this.defence = defence;
        this.agility = agility;
    }

    public abstract int attack(int a, int b);

    public abstract void item();

    public abstract void flee();

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level += level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp += hp;
    }

    public void resetHp(int hp) {
        this.hp = hp;
    } //after every battle , hp is refresh to original hp follow level

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility += agility;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp += exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }
}
