package Snake;

public class Step {
    private int row;
    private int col;
    private int snakeLength;

    public Step(int row, int col, int snakeLength){
        this.row=row;
        this.col=col;
        this.snakeLength=snakeLength;
    }

    /**
     * Applies move to gamestate
     * @param gameState current gamestate
     * @return modified gamestate or null
     */
    public int[][] applyMove (int[][] gameState){
        if(canMakeStep(gameState)){
            gameState[row][col]=snakeLength;
            return gameState;
        }
        else{
            return null;
        }
    }

    /**
     * Checks if move is appliable
     * @param gameState current gamestate
     * @return whether move is appliable
     */
    private boolean canMakeStep(int[][] gameState){
        boolean canApplyMove=false;
        canApplyMove=checkIfCellNotOver();
        if(canApplyMove){
            canApplyMove=checkIfNotSelf(gameState);
        }
        return canApplyMove;
    }

    /**
     * Returns true if next cell is free of food
     * @param gameState current gamestate
     * @return if self or not
     */
    private boolean checkIfNotSelf(int[][] gameState){
        if(gameState[row][col]==0 || gameState[row][col]==-1){
            return true;
        }
        System.out.printf("Its you, buddy.");
        return false;
    }

    /**
     * Checks if cell is over or not
     * @return if cells are over or not
     */
    private boolean checkIfCellNotOver(){
        if(row>=0 && row<10 && col >=0 && col<10 ){
            return true;
        }
        System.out.printf("Cells over.");
        return false;
    }
}
