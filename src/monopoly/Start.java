package monopoly;
class Start extends Square {

    public Start(String name) {
        this.name = name;
    }

    public void event(Player player){
        System.out.println("You made it through one round, congratulations!");
        player.setExp(80);
        player.levelUp();
        System.out.println("Your new statistics: \n"+ player.toString());
        System.out.println("Continue enjoy the game!");

    }
}
