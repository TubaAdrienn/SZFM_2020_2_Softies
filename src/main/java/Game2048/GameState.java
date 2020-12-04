package Game2048;

import javafx.scene.input.KeyCode;
import java.util.Random;

public class GameState {

    private int score;
    private int highScore;

    private int[][] gameState;
    private int[][] prevGameState;

    public GameState() {
        int currentScore = 0;
        this.score = 0;
        this.prevGameState = new int[4][4];
        this.gameState = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                currentScore+=gameState[i][j];
                gameState[i][j] = 0;
            }
        }
        generateNewCells();
        generateNewCells();
        this.score+=currentScore;
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
                    this.score+= 4;
                    break;
                default:
                    twoOrFour = 2;
                    this.score+= 2;
                    break;
            }
            if (this.gameState[row][col] == 0) {
                this.gameState[row][col] = twoOrFour;
                success = true;
            }
        }
    }

    public boolean isWinningState() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameState[i][j] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameState[i][j] == 0) {
                    return false;
                }
                if (hasMergable()) return false;
            }
        }
        return true;
    }

    private boolean hasMergable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(gameState[i][j]==gameState[i+1][j]) return true;
                else if(gameState[i][j]==gameState[i][j+1]) return true;
            }
        }
        return false;
    }

    public void showState(int[][] gameState) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("[" + gameState[i][j] + "]");
                if (j == 3) {
                    System.out.println();
                }
            }
        }
    }

    private boolean hasChanged() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.prevGameState[i][j] != this.gameState[i][j]) return true;
            }
        }
        return false;
    }

    private void copy() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                prevGameState[i][j] = this.gameState[i][j];
            }
        }
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
            col[i] = gameState[i][j];
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
        }
        return newCol;
    }

    public void moveCellsRight() {
        copy();
        int row[] = new int[4];
        for (int i = 0; i < 4; i++) {
            row = getRow(i);
            row = moveRight(row);
            for (int j = 0; j < 4; j++) {
                gameState[i][j] = row[j];
            }
        }
        if (hasChanged()) generateNewCells();
        //showState(this.gameState);
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
        }
        return newCol;
    }

    public void moveCellsLeft() {
        copy();
        int row[] = new int[4];
        for (int i = 0; i < 4; i++) {
            row = getRow(i);
            row = moveLeft(row);
            for (int j = 0; j < 4; j++) {
                gameState[i][j] = row[j];
            }
        }
        if (hasChanged()) generateNewCells();
        //showState(this.gameState);
    }

    public void moveCellsUp() {
        copy();
        int row[] = new int[4];
        for (int i = 0; i < 4; i++) {
            row = getCol(i);
            row = moveLeft(row);
            for (int n = 0; n < 4; n++) {
                gameState[n][i] = row[n];
            }
        }
        if (hasChanged()) generateNewCells();
        //showState(this.gameState);
    }

    public void moveCellsDown() {
        copy();
        int row[] = new int[4];
        for (int i = 0; i < 4; i++) {
            row = getCol(i);
            row = moveRight(row);
            for (int n = 0; n < 4; n++) {
                gameState[n][i] = row[n];
            }
        }
        if (hasChanged()) generateNewCells();
        //showState(this.gameState);
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

    public int getScore() {
        return this.score;
    }
}
