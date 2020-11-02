package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mastermind.Color;
import mastermind.Mastermind;
import mastermind.PinStruct;

import java.io.IOException;

public class GameController {

    private int lastStep;
    private int rowHelper;

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
    }

    @FXML
    public void processColor(ActionEvent event) {
        if (mastermind.getGameState() == 1 && rowHelper != 4) {
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
            rowHelper++;
        } else if (mastermind.getGameState() == 1) {
            errorLabel.setText("You need to check that you guessed " + "\n" + "correctly or not!" + "\n" +
                    "Use Submit button!" + "\n" +
                    "Or change your selected colors with " + "\n" +"Back button!");
        }
    }

    public void processBack(ActionEvent event) {
        if (lastStep > 0 && mastermind.getGameState() == 1 && rowHelper > 0) {
            errorLabel.setText("");
            ImageView view = (ImageView) leftPane.getChildren().get(lastStep - 1);
            view.setImage(null);
            lastStep--;
            rowHelper--;
        }
    }

    public void setColor(int i, Image color) {
        ((ImageView)secretPane.getChildren().get(i)).setImage(color);
    }

    public void processSubmit(ActionEvent event) {
        errorLabel.setText("");
        if (lastStep % 4 == 0 && lastStep != 0 && lastStep != 40) {
            PinStruct pins = mastermind.process(leftPane, lastStep);

            for (int i = 0; i < pins.getBlack() + pins.getWhite(); i++) {
                ImageView rightView = (ImageView) rightPane.getChildren().get(((int) Math.floor(lastStep / 4) - 1) * 4 + i);
                if (i < pins.getBlack()) {
                    rightView.setImage(Color.get(Color.BLACK));
                } else
                    rightView.setImage(Color.get(Color.WHITE));
            }
            rowHelper = 0;

            if (pins.getBlack() + pins.getWhite() == 0) {
                errorLabel.setText("All of your guesses are wrong!");
            } else if (pins.getBlack() == 4) {
                mastermind.setGameState(2);
                errorLabel.setText("Congratulations, you win!" + "\n" + "You guessed all the colors!" + "\n" + "If you want to play another match " +
                        "\n" + "press new game button!" + "\n" + "Or if you want to play another with " + "\n" + "another mini game, press " +
                        "\n" + "Back to menu button!");
                for (int i = 0; i < 4; i++) {
                    setColor(i, Color.get(Color.getByValue(mastermind.getGuessColors()[i])));
                }
            }
        } else if(lastStep < 40 ){
            errorLabel.setText("You must select 4 colors to check!" + "\n" +
                    "Use Color buttons");
        }else {
            mastermind.setGameState(3);
            errorLabel.setText("Unfortunately you failed this time");
            for (int i = 0; i < 4; i++) {
                setColor(i, Color.get(Color.getByValue(mastermind.getGuessColors()[i])));
            }
        }

    }

    public void processNewGame(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mastermind.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void processBackToMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
