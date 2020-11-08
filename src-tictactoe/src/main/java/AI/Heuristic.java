package AI;

public class Heuristic {

    public static int heurNum(GameState gameState, int supportedPlayer) {

        if (supportedPlayer == gameState.getWinner()) {
            return -10;
        } else if (gameState.getWinner() == 0) {
            return 0;
        } else {
            return 10;
        }
    }
}
