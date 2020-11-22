package Controller;

import Helpers.PageLoader;
import TicTacToe.GameState;
import TicTacToe.Operator;
import TicTacToe.StepAdvisor;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class TTTController extends Controller {

    @FXML
    private Label winner_label;

    @FXML
    private Button b11, b12, b13,
            b21, b22, b23,
            b31, b32, b33;

    private Button button;
    private boolean isOver = false;
    private GameState gameState = new GameState();
    private boolean AImode = false;
    private int currentPlayer = 1;
    private String id;
    private int row, column;
    private boolean personBlocked=false;

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
        personBlocked=false;
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
                manageGameState(clickEvent);
                gameState.showState();
                this.currentPlayer = this.currentPlayer * (-1);
            }
        } catch (Exception exc) {
            throw exc;
        }
    }

    private void setButton() {
        switch (this.currentPlayer) {
            case 1:
                button.setTextFill(Color.PURPLE);
                button.setText("O");
                break;
            case -1:
                button.setTextFill(Color.DARKRED);
                button.setText("X");
                break;
        }
    }

    private void manageGameState(MouseEvent clickEvent) {
        if (AImode == true && personBlocked == false) {
            personBlocked=true;
            getRowAndColumn();
            Operator op = new Operator(row, column);
            gameState = op.applyMove(gameState);
            button.setTextFill(Color.PURPLE);
            button.setText("O");
            stateChecker();
            AIMoveManager(clickEvent);
        } else if (AImode == false) {
            setButton();
            getRowAndColumn();
            Operator op = new Operator(row, column);
            gameState = op.applyMove(gameState);
        }
        stateChecker();
    }

    private void AIMoveManager(MouseEvent clickEvent) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            private int i = 1;

            @Override
            public void handle(ActionEvent event) {
                if (isOver == false) {
                    AIMove(clickEvent);
                    stateChecker();
                    currentPlayer = currentPlayer * (-1);
                    System.out.printf(String.valueOf(currentPlayer));
                    personBlocked=false;
                }
                i++;
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    private void AIMove(MouseEvent clickEvent) {
        Operator op = new Operator();
        op = StepAdvisor.offerMove(gameState, -1, 0, 6);
        gameState = op.applyMove(gameState);
        displayAIMove(op, clickEvent);
    }

    public void displayAIMove(Operator op, MouseEvent clickEvent) {
        row = op.row + 1;
        column = op.column + 1;
        id = "b" + row + column;
        button = (Button) ((Node) clickEvent.getSource()).getScene().lookup("#" + id);
        button.setTextFill(Color.DARKRED);
        button.setText("X");
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

    public void backToRules(MouseEvent mouseEvent) throws IOException {
        PageLoader.loadRules(mouseEvent, "tictactoe");
    }
}
