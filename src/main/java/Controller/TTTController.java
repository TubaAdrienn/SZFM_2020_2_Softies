package Controller;

import Database.HighScore;
import Database.HighScoreDao;
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
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
@Log4j2
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
        log.info("1v1 mode is on.");
        gameState = null;
        gameState = new GameState();
        AImode = false;
        clearCells();
    }

    public void setTo1vAI() {
        log.info("AI mode is on.");
        gameState = null;
        gameState = new GameState();
        AImode = true;
        personBlocked=false;
        clearCells();
        /* Usage Example

        //Create the highscore
        HighScore score=new HighScore("tictactoe", "Adrienn", "3456");

        //Create the dao
        HighScoreDao dao=HighScoreDao.getInstance();

        //Save the score to the database if its non-existant
        dao.persist(score);
        System.out.println(dao.findScoreByName("tictactoe"));

        //Updating the highscore
        dao.update(score,"3453453");
        System.out.println(dao.findScoreByName("tictactoe"));
        */
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
                //gameState.showState();
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
            log.info("'{}' row: {} column: {} ",button.getText(),row+1,column+1);
            stateChecker();
            AIMoveManager(clickEvent);
        } else if (AImode == false) {
            setButton();
            getRowAndColumn();
            Operator op = new Operator(row, column);
            gameState = op.applyMove(gameState);
            log.info("'{}' row: {} column: {} ",button.getText(),row+1,column+1);

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
                    //System.out.printf(String.valueOf(currentPlayer));
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
        log.info("AI: 'X' row: {} column: {} ",row,column);
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
                    log.info("'X' won the game.");
                    break;
                case 1:
                    winner_label.setText("Winner is O.");
                    log.info("'O' won the game.");
                    break;
            }
            isOver = true;
        } else if (gameState.isOver()) {
            winner_label.setText("Game Over.");
            log.info("There is no winner. Game Over.");
            isOver = true;
        }
    }

    public void backToRules(MouseEvent mouseEvent) throws Exception {
        PageLoader.loadRules(mouseEvent, "tictactoe");
        log.info("Back button is clicked.");
    }
}
