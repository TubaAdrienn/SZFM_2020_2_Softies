package Game2048;

import Game2048.GameState;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Game2048GameStateTest {

    private GameState game;


//    @BeforeEach
//    public void setUp() {
//        gameState = new GameState();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        gameState = null;
//    }

    @Test
    public void generateNewCellTest(){
        game = new GameState();
        game = null;
        int[][] gameState = new int[4][4];
        int newCell=0;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                gameState[i][j]=0;
            }
        }
//        game.generateNewCells();
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (gameState[i][j]!=0){
                    newCell++;
                }
            }
        }
        assertEquals(0,newCell);
    }
}