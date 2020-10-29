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

    private Button button;

    private GameState gameState = new GameState();

    private boolean AImode = false;

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
        //Clear cells code
        //Runs when new game starts
    }

    public void choseCell(MouseEvent clickEvent) {
        // Chosing cells on the view
        System.out.println("Chose cell.");
    }

    private void setButton() {
       //Sets button's label based on player
    }

    private void manageGameState() {
        // Manages game state, checks if over, if winning state
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
