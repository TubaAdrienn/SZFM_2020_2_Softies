package Controller;

import Game2048.GameState;
import Helpers.PageLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class Controller2048 {

    @FXML
    private GridPane grid;

    private GameState gameState;

    @FXML
    private Label gameOver;

    @FXML
    private Label gameWin;

    @FXML
    public void initialize() {
        newGame();
    }

    private void renderGame(){
        gameOver.setVisible(false);
        gameWin.setVisible(false);
        Label label;
        String id;
        int[][] state = gameState.getGameState();
        clearCells();
        try{
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (state[i][j] != 0) {
                        id = createID(i , j);
                        String finalId = id;
                        label = (Label) grid.getChildren().stream()
                                .filter(x -> x.getId() != null)
                                .filter(x -> x.getId().equals(finalId))
                                .findFirst()
                                .get();
                        label.setText(String.valueOf(state[i][j]));
                        switch (state[i][j]){
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
        catch (Exception e){
            gameOver.setVisible(true);
            System.out.println("Game Over");
        }
    }

    private String createID(int i,int j){
        return "id_"+String.valueOf(i)+String.valueOf(j);
    }

    private void clearCells(){
        for (Node label : grid.getChildren()) {
            ((Label) label).setText("");
            //default color cell
            label.setStyle("-fx-background-color: #E1EFA2;");
        }
    }

    public void refreshPage(KeyEvent keyEvent) {
        if(gameState.isOver()==false && gameState.isWinningState()==false){
            KeyCode code = keyEvent.getCode();
            System.out.println(code);
            gameState.moveCells(code);
            renderGame();
        } else if(gameState.isWinningState()){
            gameWin.setVisible(true);
            System.out.println("Winner won.");
        }else {
            gameOver.setVisible(true);
            System.out.println("Game Over");
        }
    }

    public void newGame(){
        gameState = new GameState();
        renderGame();
    }

    public void backToRules(MouseEvent event) throws IOException {
        PageLoader.loadRules(event, "2048");
    }
}
