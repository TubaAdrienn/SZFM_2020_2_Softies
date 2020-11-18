package Game2048;

import javafx.scene.input.KeyCode;

import java.awt.geom.GeneralPath;
import java.util.Random;

public class GameState {

    private int[][] gameState;
    private boolean moveHappened = false;

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
        int cellToMerge = gameState[i][k];
        gameState[i][k] = 0;
        gameState[moveI][moveJ] += cellToMerge;
    }

    private int[] getRow(int i) {
        int[] row = new int[4];
        for (int j = 0; j < 4; j++) {
            row[j] = gameState[i][j];
        }
        return row;
    }

    private int[] getCol(int j) {
        int[] col = new int[4];
        for (int i = 0; i < 4; i++) {
            col[i]=gameState[i][j];
        }
        return col;
    }

    private int[] moveRight(int[] row) {
        int[] newCol = new int[4];
        int prev = -1;
        int j = 3;
        for (int i = 0; i < 4; i++) {
            newCol[i] = 0;
        }

        for (int i = 3; i >= 0; i--) {
            if (row[i] != 0) {
                if (prev == -1) {
                    prev = row[i];
                } else {
                    if (prev == row[i]) {
                        newCol[j] = 2 * row[i];
                        j -= 1;
                        prev = -1;
                    } else {
                        newCol[j] = prev;
                        j -= 1;
                        prev = row[i];
                    }

                }
            }
        }
        if (prev != -1) {
            newCol[j] = prev;
            moveHappened = true;
        }
        return newCol;
    }

    public void moveCellsRight() {
        moveHappened = false;
        int row[] = new int[4];
        for (int i = 0; i < 4; i++) {
            row = getRow(i);
            row = moveRight(row);
            for (int j = 0; j < 4; j++) {
                gameState[i][j] = row[j];
            }
        }
        if (moveHappened) generateNewCells();
    }

    private int[] moveLeft(int[] col) {
        int[] newCol = new int[4];
        int prev = -1;
        int j = 0;
        for (int i = 0; i < 4; i++) {
            newCol[i] = 0;
        }

        for (int i = 0; i < 4; i++) {
            if (col[i] != 0) {
                if (prev == -1) {
                    prev = col[i];
                } else {
                    if (prev == col[i]) {
                        newCol[j] = 2 * col[i];
                        j += 1;
                        prev = -1;
                    } else {
                        newCol[j] = prev;
                        j += 1;
                        prev = col[i];
                    }

                }
            }
        }
        if (prev != -1) {
            newCol[j] = prev;
            moveHappened = true;
        }
        return newCol;
    }

    public void moveCellsLeft() {
        moveHappened = false;
        int row[] = new int[4];
        for (int i = 0; i < 4; i++) {
            row = getRow(i);
            row = moveLeft(row);
            for (int j = 0; j < 4; j++) {
                gameState[i][j] = row[j];
            }
        }
        if (moveHappened) generateNewCells();
    }

    public void moveCellsUp() {
        moveHappened = false;
        int row[] = new int[4];
        for (int i = 0; i < 4; i++) {
            row = getCol(i);
            row=moveLeft(row);
            for (int n = 0; n < 4; n++) {
                gameState[n][i] = row[n];
            }
        }
        if (moveHappened) generateNewCells();
    }

    public void moveCellsDown() {
        moveHappened = false;
        int row[] = new int[4];
        for (int i = 0; i < 4; i++) {
            row = getCol(i);
            row=moveRight(row);
            for (int n = 0; n < 4; n++) {
                gameState[n][i] = row[n];
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
