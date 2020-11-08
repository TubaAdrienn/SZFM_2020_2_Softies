package TicTacToe;
import java.util.ArrayList;
import java.util.List;

public class Operator {
    public int row, column;
    private ArrayList<Operator> OPERATORS = new ArrayList<Operator>();

    public Operator(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Operator() {
    }

    //Creating the operators
    public List<Operator> getOperators() {
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                OPERATORS.add(new Operator(i, j));
            }
        }
        return this.OPERATORS;
    }

    //If applicable to the state
    public boolean isApplicable(char[][] gameState) {
        if (this.row < 3 && this.row >= 0 && this.column < 3 && this.column >= 0
                && gameState[this.row][this.column] == ' ') {
            return true;
        }
        return false;
    }

    //Applying operator to the state
    public GameState applyMove(GameState game) {
        char[][] newState = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newState[i][j] = game.getState()[i][j];
            }
        }
        switch (game.getCurrent()) {
            case 1:
                newState[this.row][this.column] = 'O';
                break;
            case -1:
                newState[this.row][this.column] = 'X';
                break;
        }
        return new GameState(newState, game.getCurrent() * -1);
    }
}