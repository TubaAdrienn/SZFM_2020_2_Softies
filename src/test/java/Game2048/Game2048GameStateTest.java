package Game2048;

import Game2048.GameState;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class Game2048GameStateTest {

    private GameState gameState;

    @BeforeEach
    public void setUp() { gameState = new GameState();}

    @AfterEach
    public void tearDown() {
        gameState = null;
    }

    @Test
    public void generateNewCellTest(){
        int[][] game = new int[4][4];
        int newCell=0;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                game[i][j]=0;
            }
        }
        gameState.setGameState(game);
        gameState.generateNewCells();
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (game[i][j]==0){
                    newCell++;
                }
            }
        }
        assertEquals(1,newCell);
    }

}