package monopoly;

// public class Monsters extends Role {

//     @Override
//     public void attack(){
//     }

//     @Override
//     public void item(){
//     }

//     @Override
//     public void flee(){
//     }
// }

public class Monsters extends Role {

    private String name;

    public Monsters(String name, int lvl, int hp, int strength, int defence, int agility) {
        this.name= name;
        this.level=lvl;
        this.hp=hp;
        this.strength=strength;
        this.defence=defence;
        this.agility=agility;
    }

    @Override
    public void attack(){
        System.out.println("Monster's turn to attack");
    }

    @Override
    public void item(){
    }

    @Override
    public void flee(){
    }

    @Override
    public String toString() {
        return name+"\nMonsters level=" + level +
                "\nhp= " + hp +
                "\nstrength= " + strength +
                "\ndefence= " + defence +
                "\nagility= " + agility;
    }
}
