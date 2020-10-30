package mastermind;

import lombok.Getter;
import lombok.Setter;

public class Mastermind {

    @Getter @Setter
    private int gameState;

    public Mastermind(){
        this.gameState = 1;
    }
}
