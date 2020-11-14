package Controller;

import Helpers.PageLoader;
import Snake.GameState;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class SnakeController {

    @FXML
    private Label scoreLabel;

    @FXML
    private Label highScoreLabel;

    @FXML
    private Pane grid;

    private GridPane gridPane;
    private GameState gameState;

    @FXML
    public void initialize() {
        generateGridPane();
    }

    public void startGame(){
        this.gameState = new GameState();
        renderSnake();
    }

    private void generateGridPane() {
        gridPane = new GridPane();
        gridPane.setPrefWidth(700);
        gridPane.setPrefHeight(500);
        gridPane.setGridLinesVisible(true);
        gridPane.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderStroke.THICK)));
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 26; j++) {
                Label label = new Label();
                label.setId(createID(i, j));
                label.setPrefHeight(500/20.0);
                label.setPrefWidth(700/26.0);
                gridPane.addRow(i, label);
            }
        }
        grid.getChildren().add(gridPane);
        System.out.println("GridPane finished.");
    }

    public String createID(int col, int row) {
        return String.valueOf(row) + "_" + String.valueOf(col);
    }

    private void renderSnake() {
        Node label;
        String id;
        int[][] state = gameState.getGameState();
        clearCells();
        try{
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 26; j++) {
                    if (state[i][j] != 0) {
                        id = createID(i, j);
                        String finalId = id;
                        System.out.println("Final ID: " + finalId);
                        label = (Label) gridPane.getChildren().stream()
                                .filter(x -> x.getId() != null)
                                .filter(x -> x.getId().equals(finalId))
                                .findFirst()
                                .get();
                        if (state[i][j] != -1) label.setStyle("-fx-background-color: black;");
                        else label.setStyle("-fx-background-color: red;");
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Game Over.");
        }
    }

    public void snakeMove(KeyEvent keyEvent) {
        System.out.println("Key Pressed");
        KeyCode code = keyEvent.getCode();
        System.out.println(code);
        gameState.moveSnake(code);
        renderSnake();
    }

    public void clearCells() {
        for (Node label : gridPane.getChildren()) {
            label.setStyle("");
        }
    }

    public void backToRulePage(MouseEvent event) throws IOException {
        PageLoader.loadRules(event, "snake");
    }

}
