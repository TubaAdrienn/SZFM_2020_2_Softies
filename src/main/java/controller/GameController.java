package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import mastermind.Color;
import mastermind.Mastermind;

public class GameController {

    private int lastStep;

    @FXML
    private GridPane leftPane;

    @FXML
    private GridPane rightPane;

    @FXML
    private Label errorLabel;

    @FXML
    private Pane mainPane;

    @FXML
    private GridPane secretPane;

    private Mastermind mastermind;

    @FXML
    public void initialize() {
        mainPane.setStyle("-fx-background-color: #A09586");
        mastermind = new Mastermind();
        for (int i = 0; i < 4; i++){
            setColor(i, Color.get(Color.getByValue(mastermind.getGuessColors()[i])));
        }
    }
    @FXML
    public void processColor(ActionEvent event) {
        if (mastermind.getGameState() == 1) {
            String colorPressed = ((Button) event.getSource()).getText();
            errorLabel.setText("");
            ImageView view = (ImageView) leftPane.getChildren().get(lastStep);
            switch (colorPressed) {
                case "RED":
                    view.setImage(Color.get(Color.RED));
                    break;
                case "WHITE":
                    view.setImage(Color.get(Color.WHITE));
                    break;
                case "BLUE":
                    view.setImage(Color.get(Color.BLUE));
                    break;
                case "PINK":
                    view.setImage(Color.get(Color.PINK));
                    break;
                case "ORANGE":
                    view.setImage(Color.get(Color.ORANGE));
                    break;
                case "PURPLE":
                    view.setImage(Color.get(Color.PURPLE));
                    break;
                case "YELLOW":
                    view.setImage(Color.get(Color.YELLOW));
                    break;
                case "GREEN":
                    view.setImage(Color.get(Color.GREEN));
                    break;
            }
            lastStep++;
        }
    }

    public void processBack(ActionEvent event) {
        if (lastStep > 0 && mastermind.getGameState() == 1) {
            errorLabel.setText("");
            ImageView view = (ImageView) leftPane.getChildren().get(lastStep - 1);
            view.setImage(null);
            lastStep--;
        }
    }

    public void setColor(int i, Image color) {
        ((ImageView)secretPane.getChildren().get(i)).setImage(color);
    }
}
