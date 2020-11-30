package tictactoe;

import TicTacToe.GameState;
import TicTacToe.Operator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TicTacToeGameStateTest {

    private GameState gameState;


    @BeforeEach
    public void setUp() {
        gameState = new GameState();
    }

    @AfterEach
    public void tearDown() {
        gameState = null;
    }

    @Test
    public void testGameStateIsOverTest() {
        char[][] gameOver = {{'O', 'X', 'O'}, {'X', 'O', 'X'}, {'O', 'X', 'O'}};
        gameState = new GameState(gameOver, 1);
        assertEquals(true, gameState.isOver());

        gameState = new GameState();
        assertEquals(false, gameState.isOver());
    }

    @Test
    public void testGameIsWinningStateTest() {
        char[][] game = {{'O', 'O', 'O'}, {'X', 'O', 'X'}, {'O', 'X', 'O'}};
        char[][] game2 = {{'O', 'X', 'X'}, {'X', 'O', 'O'}, {'O', 'O', 'X'}};
        char[][] game3 = {{'O', ' ', ' '}, {'X', 'O', 'X'}, {'O', ' ', 'X'}};
        gameState = new GameState(game, 1);
        assertEquals(true, gameState.isWinningState());

        gameState = new GameState(game2, 1);
        assertEquals(false, gameState.isWinningState());

        gameState = new GameState(game3, 1);
        assertEquals(false, gameState.isWinningState());

    }

    @Test
    public void moveIsAppliableTest() {
        char[][] game = {{'O', ' ', 'X'}, {'X', 'O', 'X'}, {'O', ' ', 'X'}};
        char[][] game2 = {{'O', ' ', ' '}, {'X', 'O', 'X'}, {'O', ' ', 'X'}};
        Operator op = new Operator(0, 2);

        assertEquals(false, op.isApplicable(game));
        assertEquals(true, op.isApplicable(game2));
    }

    @Test
    public void applyMoveTest() {
        char[][] game = {{'O', ' ', ' '}, {'X', 'O', 'X'}, {'O', ' ', 'X'}};
        char[][] expected = {{'O', ' ', 'O'}, {'X', 'O', 'X'}, {'O', ' ', 'X'}};
        gameState = new GameState(game, 1);
        Operator op = new Operator(0, 2);

        gameState = op.applyMove(gameState);
        Assert.assertArrayEquals(expected, gameState.getState());
    }
}