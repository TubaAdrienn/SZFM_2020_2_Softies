package Game2048;

import javafx.scene.input.KeyCode;

import java.util.Random;

public class GameState {

    private int[][] gameState;

    public GameState() {
        this.gameState = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameState[i][j] = 0;
            }
        }
        generateNewCells();
        generateNewCells();
    }

    public GameState(int[][] gameState, int current) {
        this.gameState = gameState;
    }

    public int[][] getState() {
        return this.gameState;
    }

    public int[][] getGameState() {
        return gameState;
    }

    public void generateNewCells() {
        Random rand = new Random();
        boolean success = false;
        while (success == false) {
            int row = rand.nextInt(4);
            int col = rand.nextInt(4);
            int twoOrFour = rand.nextInt(10);
            switch (twoOrFour) {
                case 1:
                    twoOrFour = 4;
                    break;
                default:
                    twoOrFour = 2;
                    break;
            }
            if (this.gameState[row][col] == 0) {
                this.gameState[row][col] = twoOrFour;
                success = true;
            }
        }
    }

    public void winner() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameState[i][j] == 2048) {
                    System.out.println("You won");
                }
            }
        }
    }

    public boolean isOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameState[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void showState() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("[" + String.valueOf(gameState[i][j]) + "]");
                if (j == 3) {
                    System.out.println();
                }
            }
        }
    }

    private void setCell(int i, int k, int moveI, int moveJ) {
        int originalCell = gameState[i][k];
        gameState[i][k] = 0;
        gameState[moveI][moveJ] += originalCell;
    }

    public void moveCellsRight() {
        boolean moveHappened = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                for (int k = j; k < 3; k++) {
                    if ( gameState[i][k] == gameState[i][k + 1] && gameState[i][k] != 0 ){
                        setCell(i, k, i, k + 1);
                        moveHappened = true;
                    }
                    if (gameState[i][k + 1] == 0 && gameState[i][k] != 0) {
                        setCell(i, k, i, k + 1);
                        moveHappened = true;
                    }
                }
            }
        }
        if (moveHappened) generateNewCells();
    }

    public void moveCellsLeft() {
        boolean moveHappened = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = j; k > 0; k--) {
                    if (gameState[i][k] == gameState[i][k - 1] && gameState[i][k] != 0 ) {
                        setCell(i, k, i, k - 1);
                        moveHappened = true;
                    }
                    if (gameState[i][k - 1] == 0 && gameState[i][k] != 0) {
                        setCell(i, k, i, k - 1);
                        moveHappened = true;
                    }
                }
            }
        }
        if (moveHappened) generateNewCells();
    }

    public void moveCellsUp() {
        boolean moveHappened = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = j; k > 0; k--) {
                    if (gameState[k][i] == gameState[k - 1][i] && gameState[k][i] != 0 ) {
                        setCell(k, i, k - 1, i);
                        moveHappened = true;
                    }
                    if (gameState[k - 1][i] == 0 && gameState[k][i] != 0) {
                        setCell(k, i, k - 1, i);
                        moveHappened = true;
                    }
                }
            }
        }
        if (moveHappened) generateNewCells();
    }

    public void moveCellsDown() {
        boolean moveHappened = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = j; k < 3; k++) {
                    if (gameState[k][i] == gameState[k + 1][i] && gameState[k][i] != 0 ) {
                        setCell(k, i, k + 1, i);
                        moveHappened = true;
                    }
                    if (gameState[k + 1][i] == 0 && gameState[k][i] != 0) {
                        setCell(k, i, k + 1, i);
                        moveHappened = true;
                    }
                }
            }
        }
        if (moveHappened) generateNewCells();
    }

    public void moveCells(KeyCode direction) {
        switch (direction.toString()) {
            case "A":
                this.moveCellsLeft();
                break;
            case "S":
                this.moveCellsDown();
                break;
            case "D":
                this.moveCellsRight();
                break;
            case "W":
                this.moveCellsUp();
                break;
        }
    }
}
