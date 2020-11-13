package Controller;

import TicTacToe.GameState;
import TicTacToe.Operator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TTTController {

    @FXML
    private Label winner_label;

    @FXML
    private Button b11, b12, b13,
            b21, b22, b23,
            b31, b32, b33;

    private boolean isOver = false;

    private Button button;

    private GameState gameState = new GameState();

    private boolean AImode = false;

    private int currentPlayer = 1;

    private String id;
    private int row, column;

    public void setTo1v1() {
        gameState = null;
        gameState = new GameState();
        AImode = false;
        clearCells();
    }

    public void setTo1vAI() {
        gameState = null;
        gameState = new GameState();
        AImode = true;
        clearCells();
    }

    public void clearCells() {
        b11.setText("");
        b12.setText("");
        b13.setText("");
        b21.setText("");
        b22.setText("");
        b23.setText("");
        b31.setText("");
        b32.setText("");
        b33.setText("");
        winner_label.setText("");
        isOver = false;
        currentPlayer = 1;
    }

    public void choseCell(MouseEvent clickEvent) {
        try {
            button = (Button) clickEvent.getTarget();
            if (button.getText().isEmpty() && !isOver) {
                manageGameState();
                this.currentPlayer = this.currentPlayer * (-1);
            }
        } catch (Exception exc) {
            throw exc;
        }
    }

    private void setButton() {
        switch (this.currentPlayer) {
            case 1:
                button.setText("O");
                System.out.println("Set Button O");
                break;
            case -1:
                button.setText("X");
                System.out.println("Set Button X");
                break;
        }
    }

    private void manageGameState() {
        if (AImode == true) {
            getRowAndColumn();
            Operator op = new Operator(row, column);
            gameState = op.applyMove(gameState);
            button.setText("O");
            stateChecker();
            if (isOver == false) {
                AIMove();
                this.currentPlayer = this.currentPlayer * (-1);
            }
        } else if (AImode == false) {
            setButton();
            getRowAndColumn();
            Operator op = new Operator(row, column);
            gameState = op.applyMove(gameState);
        }
        stateChecker();
    }

    private void AIMove() {
        // AI move manager
    }

    public void displayAIMove() {
        // Displays AI move on the view
    }

    private void getRowAndColumn() {
        id = button.getId();
        row = Character.getNumericValue(id.charAt(1)) - 1;
        column = Character.getNumericValue(id.charAt(2)) - 1;
    }

    private void stateChecker() {
        if (gameState.isWinningState()) {
            switch (this.currentPlayer) {
                case -1:
                    winner_label.setText("Winner is X.");
                    break;
                case 1:
                    winner_label.setText("Winner is O.");
                    break;
            }
            isOver = true;
        } else if (gameState.isOver()) {
            winner_label.setText("Game Over.");
            isOver = true;
        }
    }
}
