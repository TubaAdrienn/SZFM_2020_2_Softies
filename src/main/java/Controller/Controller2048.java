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

import javax.persistence.NoResultException;

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
                                    label.setStyle("-fx-background-color: #AED6F1;");
                                    break;
                                case 4:
                                    label.setStyle("-fx-background-color: #0E6251;");
                                    break;
                                case 8:
                                    label.setStyle("-fx-background-color: #48C9B0;");
                                    break;
                                case 16:
                                    label.setStyle("-fx-background-color: #78281F;");
                                    break;
                                case 32:
                                    label.setStyle("-fx-background-color: #A569BD;");
                                    break;
                                case 64:
                                    label.setStyle("-fx-background-color: #F8C471;");
                                    break;
                                case 128:
                                    label.setStyle("-fx-background-color: #154360;");
                                    break;
                                case 256:
                                    label.setStyle("-fx-background-color: #DC7633;");
                                    break;
                                case 512:
                                    label.setStyle("-fx-background-color: #A2D9CE;");
                                    break;
                                case 1024:
                                    label.setStyle("-fx-background-color: #186A3B;");
                                    break;
                                case 2048:
                                    label.setStyle("-fx-background-color: #D35400;");
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
            System.out.println(code);
            gameState.moveCells(code);
            renderGame();
        } else if (gameState.isWinningState()) {
            gameWin.setVisible(true);
        } else {
            gameOver.setVisible(true);
        }
        if (gameState.isOver() == true) {
            if (score == null) {
                database.persist(new HighScore(this.game, this.name1, gameState.getScore()));
            } else if (gameState.getScore() > score.getScore()) {
                database.update(score, gameState.getScore(), this.name1);
                highScore.setText("Highscore: "+String.valueOf(gameState.getScore()));
            }
        }
    }

    public void newGame() {
        gameState = new GameState();
        renderGame();
    }

    public void backToRules(MouseEvent event) throws Exception {
        PageLoader.loadRules(event, "2048");
    }

    public void setScore() {
        gameScore.setText("Score: " + String.valueOf(gameState.getScore()));
        try {
            highScore.setText("Highscore: " + String.valueOf(database.findScoreByName("2048").getScore()));
        } catch (NoResultException e) {

        }
    }
}
