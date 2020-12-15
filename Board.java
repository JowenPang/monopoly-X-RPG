package monopoly;

public class Board {
    Square[] square = new Square[32];
    public Board() {
        square[0] = new Start();
        square[1] = new Duo();
        square[2] = new Tri();
        square[3] = new Sin();
        square[4] = new Empty();
        square[5] = new Duo();
        square[6] = new Sin();
        square[7] = new Sin();
        square[8] = new Shop();
        square[9] = new Duo();
        square[10] = new Sin();
        square[11] = new Duo();
        square[12] = new Empty();
        square[13] = new Sin();
        square[14] = new Sin();
        square[15] = new Tri();
        square[16] = new Chest();
        square[17] = new Sin();
        square[18] = new Duo();
        square[19] = new Tri();
        square[20] = new Empty();
        square[21] = new Sin();
        square[22] = new Duo();
        square[23] = new Sin();
        square[24] = new Shop();
        square[25] = new Sin();
        square[26] = new Duo();
        square[27] = new Duo();
        square[28] = new Empty();
        square[29] = new Tri();
        square[30] = new Sin();
        square[31] = new Sin();
    }
    public void play(Player player) {
        int nextPosition=player.getPosition();
        Square nextSquare=square[nextPosition];
        nextSquare.event(player);

    }
}


