package Game2048;

public class GameState {

    private char[][] gameState;
    private int currentPlayer;

    public GameState() {
        this.gameState = new char[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                gameState[i][j] = ' ';
            }
        }
        this.currentPlayer = 1;
    }

    public GameState(char[][] gameState, int current){
        this.gameState = gameState;
        this.currentPlayer = current;
    }

    public int getCurrent() {
        return this.currentPlayer;
    }

    public char[][] getState() {
        return this.gameState;
    }
}
