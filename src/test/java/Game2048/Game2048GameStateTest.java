package Game2048;

import Game2048.GameState;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Game2048GameStateTest {



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
        GameState game;
        game = new GameState();
        int[][] gameState = new int[4][4];
        game.setGameState(gameState);
        int newCell=0;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                gameState[i][j]=0;
            }
        }

        game.generateNewCells();

        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (gameState[i][j]!=0){
                    newCell++;
                }
            }
        }
        assertEquals(1,newCell);
    }
}