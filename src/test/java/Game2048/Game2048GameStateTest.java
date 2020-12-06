package Game2048;

import Game2048.GameState;
import javafx.scene.input.KeyCode;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void isWinningStateTrueTest() {
        GameState game;
        game = new GameState();
        int[][] gameState = new int[4][4];
        game.setGameState(gameState);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameState[i][j] = 0;
            }
        }
        gameState[0][0]=2048;
        assertTrue(game.isWinningState());
    }

    @Test
    public void isWinningStateFalseTest() {
        GameState game;
        game = new GameState();
        int[][] gameState = new int[4][4];
        game.setGameState(gameState);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameState[i][j] = 0;
            }
        }
        assertFalse(game.isWinningState());
    }

    @Test
    public void isOverTrueTest(){
        GameState game;
        game = new GameState();

        int[][] gameState = new int[][]
                        {{2,4,8,16},
                        {4,8,16,32},
                        {2,64,2,8},
                        {4,8,4,2}};

        game.setGameState(gameState);
        assertTrue(game.isOver());
    }

    @Test
    public void isOverFalseTest(){
        GameState game;
        game = new GameState();

        int[][] gameState = new int[][]
                        {{2,4,8,16},
                        {4,8,16,32},
                        {2,64,2,8},
                        {2,8,4,2}};

        game.setGameState(gameState);
        assertFalse(game.isOver());
    }

    @Test
    public void hasMergableTrueTest(){
        GameState game;
        game = new GameState();

        int[][] gameState = new int[][]
                        {{2,4,8,16},
                        {4,8,16,32},
                        {2,64,2,8},
                        {2,8,4,2}};

        game.setGameState(gameState);
        assertTrue(game.hasMergable());
    }

    @Test
    public void hasMergableFalseTest(){
        GameState game;
        game = new GameState();

        int[][] gameState = new int[][]
                        {{2,4,8,16},
                        {4,8,16,32},
                        {2,64,2,8},
                        {4,8,4,2}};

        game.setGameState(gameState);
        assertFalse(game.hasMergable());
    }

//    @Test
//    public void moveCellsTest(){
//        GameState game;
//        game = new GameState();
//        boolean valider = true;
//
//        int[][] validGameState = new int[][]
//                        {{2,4,8,16},
//                        {4,8,16,32},
//                        {4,64,2,8},
//                        {2,8,4,2}};
//
//        int[][] gameState = new int[][]
//                        {{2,4,8,16},
//                        {4,8,16,32},
//                        {2,64,2,8},
//                        {2,8,4,2}};
//
//
//        game.setGameState(gameState);
//        game.moveCells(KeyCode.W);
//
//        for (int i=0; i<4; i++){
//            for (int j=0; j<4; j++){
//                if (gameState[i][j]!=validGameState[i][j]){
//                    valider=false;
//                }
//            }
//        }
//
//        assertTrue(valider);
//
//        game.moveCells(KeyCode.A);
//        game.moveCells(KeyCode.S);
//        game.moveCells(KeyCode.D);
//    }
}