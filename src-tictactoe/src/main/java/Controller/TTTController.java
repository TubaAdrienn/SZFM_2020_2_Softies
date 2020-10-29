package Controller;

import AI.GameState;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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
        setButton();
    }

    private void AIMove() {
        // AI move manager
    }

    public void displayAIMove() {
        // Displays AI move on the view
    }

    private void getRowAndColumn() {
        //Gets clicked row and column by ID
    }

    private void stateChecker() {
        //Checks if state is winning, or over
    }
}
