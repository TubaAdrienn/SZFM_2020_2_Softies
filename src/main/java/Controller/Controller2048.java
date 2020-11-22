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

public class Controller2048 extends Controller {

    @FXML
    private GridPane grid;

    private GameState gameState;

    @FXML
    public void initialize() {
        newGame();
    }

    private void renderGame(){
        Label label;
        String id;
        int[][] state = gameState.getGameState();
        clearCells();
        try{
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (state[i][j] != 0) {
                        id = createID(i, j);
                        String finalId = id;
                        System.out.println("Final ID: " + finalId);
                        label = (Label) grid.getChildren().stream()
                                .filter(x -> x.getId() != null)
                                .filter(x -> x.getId().equals(finalId))
                                .findFirst()
                                .get();
                        label.setText(String.valueOf(state[i][j]));

                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Game Over.");
        }
    }

    private String createID(int i,int j){
        return "id_"+String.valueOf(i)+String.valueOf(j);
    }

    private void clearCells(){
        for (Node label : grid.getChildren()) {
            ((Label) label).setText("");
        }
    }

    public void refreshPage(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        System.out.println(code);
        gameState.moveCells(code);
        renderGame();
    }

    public void newGame(){
        gameState = new GameState();
        renderGame();
    }

    public void backToRules(MouseEvent event) throws Exception {
        PageLoader.loadRules(event, "2048");
    }
}
