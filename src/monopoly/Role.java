package monopoly;

public abstract class Role {
    int level,hp,strength,defence, agility,exp,gold;

    public Role() {
        level=1; hp=25; strength=5; defence=5; agility=5; exp=0;
        gold=200;
    }
    public abstract void attack();

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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = +strength;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence += defence;
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
