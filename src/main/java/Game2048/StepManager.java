package Game2048;

public class StepManager {
    private int row;
    private int col;
    private String direction;
    private int moveI;
    private int moveJ;

    public StepManager(int row, int col, String direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }

    private void setDirectionCoords() {
        switch (direction) {
            case "Up":
                moveI = -1;
                moveJ = 0;
                break;
            case "Down":
                moveI = 1;
                moveJ = 0;
                break;
            case "Left":
                moveI = 0;
                moveJ = -1;
                break;
            case "Right":
                moveI = 0;
                moveJ = 1;
                break;
        }
    }

    public int[][] applyMove(int[][] gameState) {
        setDirectionCoords();
        boolean canApply = checkMove(gameState);
        if (canApply) apply(gameState);
        return gameState;
    }

    private boolean checkMove(int[][] gameState) {
        boolean canApply = false;
        int rowMove = row + moveI;
        int colMove = col + moveJ;
        if (rowMove >= 0 && rowMove < 4 && colMove < 4 && colMove >= 0) {
            if (gameState[rowMove][colMove] == gameState[row][col]
                    || gameState[rowMove][colMove] == 0) {
                canApply = true;
            }
        }
        return canApply;
    }

    private void apply(int[][] gameState) {
        int originalCell = gameState[row][col];
        gameState[row][col] = 0;
        gameState[row + moveI][col + moveJ] += originalCell;
    }
}
