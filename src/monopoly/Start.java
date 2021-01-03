package monopoly;
class Start extends Square {

    public Start(String name) {
        this.name = name;
    }

    public void event(Player player){
        System.out.println("You made it through one round, congratulations!");
        System.out.println("");
        player.setHp(20);
        player.setStrength(25);
        player.setDefence(10);
        player.setAgility(10);
        System.out.println("Your new statistics: \n"+ player.toString());
        System.out.println("Continue enjoy the game!");

    }
}
