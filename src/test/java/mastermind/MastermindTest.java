package mastermind;

import Mastermind.Mastermind;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MastermindTest {
    @Test
    void testGameState() {
        Mastermind mastermind = new Mastermind();
        assertEquals(1, mastermind.getGameState());
        mastermind.setGameState(2);
        assertEquals(2, mastermind.getGameState());
    }

    @Test
    void testGuessedColors() {
        Mastermind mastermind = new Mastermind();
        assertEquals(4, mastermind.getGuessColors().length);
    }
}
