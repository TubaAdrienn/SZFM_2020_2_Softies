package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import mastermind.Mastermind;

public class GameController {
    @FXML
    private GridPane leftPane;

    @FXML
    private GridPane rightPane;

    @FXML
    private Label errorLabel;

    @FXML
    private Pane mainPane;

    private Mastermind mastermind;

    @FXML
    public void initialize() {
        mainPane.setStyle("-fx-background-color: #A09586");
        mastermind = new Mastermind();
    }
}
