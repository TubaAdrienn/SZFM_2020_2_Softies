package snake;

import Snake.Direction;
import Snake.GameState;
import Snake.Step;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class SnakeTest {

    private Direction direction;
    private Step step;
    private GameState gameState;

    @BeforeEach
    public void setUp()
    {
        gameState = new GameState();
    }

    @AfterEach
    public void tearDown()
    {
        gameState = null;
    }


    @Test
    public void checkIfCellNotOver(){
        //cell is over
        Step step = new Step(0,-1,3);
        assertEquals(false,step.checkIfCellNotOver());

        //cell is not over
        Step step2 = new Step(0,2,3);
        assertEquals(true,step2.checkIfCellNotOver());

    }
}
