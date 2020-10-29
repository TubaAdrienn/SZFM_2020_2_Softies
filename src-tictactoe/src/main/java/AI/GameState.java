package AI;

public class GameState {

    private char[][] gameState;
    private int currentPlayer;

    public GameState() {
        this.gameState = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameState[i][j] = ' ';
            }
        }
        this.currentPlayer = 1;
    }

    public int getCurrent() {
        return this.currentPlayer;
    }

    public char[][] getState() {
        return this.gameState;
    }

    public boolean isWinningState() {
        for (int i = 0; i < 3; i++) {
            if ((this.gameState[i][0] == this.gameState[i][1]
                    && this.gameState[i][1] == this.gameState[i][2]) && this.gameState[i][0] != ' ') {
                return true;
            } else if ((this.gameState[0][i] == this.gameState[1][i]
                    && this.gameState[1][i] == this.gameState[2][i]) && this.gameState[0][i] != ' ') {
                return true;
            }
        }

        if (this.gameState[0][0] == this.gameState[1][1] && this.gameState[1][1] == this.gameState[2][2] && this.gameState[1][1] != ' ') {
            return true;
        }

        if (this.gameState[2][0] == this.gameState[1][1] && this.gameState[1][1] == this.gameState[0][2] && this.gameState[1][1] != ' ') {
            return true;
        }
        return false;
    }

    public boolean isOver() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (this.gameState[i][j] == ' ')
                    return false;
        return true;
    }

    public int getWinner() {
        if (isWinningState()) {
            return this.currentPlayer;
        } else {
            return 0;
        }
    }

    public void showState() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("[ " + gameState[i][j] + " ]");
                if (j == 2) {
                    System.out.println();
                }
            }
        }
    }
}
