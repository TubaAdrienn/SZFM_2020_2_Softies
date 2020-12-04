package Controller;

import Database.HighScore;
import Database.HighScoreDao;
import Game2048.GameState;
import Helpers.PageLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import lombok.extern.log4j.Log4j2;

import javax.persistence.NoResultException;
@Log4j2
public class Controller2048 extends Controller {

    @FXML
    private GridPane grid;

    private GameState gameState;

    @FXML
    private Label gameScore;

    @FXML
    private Label highScore;

    @FXML
    private Label gameOver;

    @FXML
    private Label gameWin;

    HighScoreDao database = HighScoreDao.getInstance();

    @FXML
    public void initialize() {
        newGame();
    }

    private void renderGame() {
        setScore();
        gameOver.setVisible(false);
        gameWin.setVisible(false);
        Label label;
        String id;
        int[][] state = gameState.getGameState();
        clearCells();
        try {
            if (gameState.isOver() == false) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (state[i][j] != 0) {
                            id = createID(i, j);
                            String finalId = id;
                            label = (Label) grid.getChildren().stream()
                                    .filter(x -> x.getId() != null)
                                    .filter(x -> x.getId().equals(finalId))
                                    .findFirst()
                                    .get();
                            label.setText(String.valueOf(state[i][j]));
                            switch (state[i][j]) {
                                case 2:
                                    label.setStyle("-fx-background-color: #FFFF66;");
                                    break;
                                case 4:
                                    label.setStyle("-fx-background-color: green;");
                                    break;
                                case 8:
                                    label.setStyle("-fx-background-color: brown;");
                                    break;
                                case 16:
                                    label.setStyle("-fx-background-color: yellow;");
                                    break;
                                case 32:
                                    label.setStyle("-fx-background-color: orange;");
                                    break;
                                case 64:
                                    label.setStyle("-fx-background-color: grey;");
                                    break;
                                case 128:
                                    label.setStyle("-fx-background-color: red;");
                                    break;
                                case 256:
                                    label.setStyle("-fx-background-color: pink;");
                                    break;
                                case 512:
                                    label.setStyle("-fx-background-color: purple;");
                                    break;
                                case 1024:
                                    label.setStyle("-fx-background-color: white;");
                                    break;
                                case 2048:
                                    label.setStyle("-fx-background-color: aqua;");
                                    break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            gameOver.setVisible(true);

        }
    }

    private String createID(int i, int j) {
        return "id_" + String.valueOf(i) + String.valueOf(j);
    }

    private void clearCells() {
        for (Node label : grid.getChildren()) {
            ((Label) label).setText("");
            //default color cell
            label.setStyle("-fx-background-color: #E1EFA2;");
        }
    }

    public void refreshPage(KeyEvent keyEvent) {
        if (gameState.isOver() == false && gameState.isWinningState() == false) {
            KeyCode code = keyEvent.getCode();
            gameState.moveCells(code);
            renderGame();
            log.info("{} key is pressed. Score :{}",code,gameState.getScore());
        } else if (gameState.isWinningState()) {
            gameWin.setVisible(true);
            log.info("Winner won.");
        } else {
            gameOver.setVisible(true);
            log.info("Game Over.");
        }
        if (gameState.isOver() == true) {
            if (score == null) {
                database.persist(new HighScore(this.game, this.name1, gameState.getScore()));
            } else if (gameState.getScore() > score.getScore()) {
                database.update(score, gameState.getScore(), this.name1);
                log.info("Highscore saved. {}",gameState.getScore());
                highScore.setText("Highscore: "+String.valueOf(gameState.getScore()));
            }
        }
    }

    public void newGame() {
        log.info("New game is started.");
        gameState = new GameState();
        renderGame();
    }

    public void backToRules(MouseEvent event) throws Exception {
        PageLoader.loadRules(event, "2048");
        log.info("Back button is clicked.");
    }

    public void setScore() {
        gameScore.setText("Score: " + String.valueOf(gameState.getScore()));
        try {
            highScore.setText("Highscore: " + String.valueOf(database.findScoreByName("2048").getScore()));
        } catch (NoResultException e) {
            log.error("No result found.");
        }
    }
}
