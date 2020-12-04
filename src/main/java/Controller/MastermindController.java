package Controller;

import Database.HighScore;
import Database.HighScoreDao;
import Helpers.PageLoader;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Mastermind.Color;
import Mastermind.Mastermind;
import Mastermind.PinStruct;
import lombok.extern.log4j.Log4j2;

import javax.persistence.NoResultException;

import java.io.IOException;
@Log4j2
public class MastermindController extends Controller {

    private int lastStep;
    private int rowHelper;
    private int gameScore = 10;

    @FXML
    private GridPane leftPane;

    @FXML
    private GridPane rightPane;

    @FXML
    private Label errorLabel;

    @FXML
    private Label highScore;

    @FXML
    private Label currentScore;

    @FXML
    private GridPane secretPane;

    private Mastermind mastermind;

    HighScoreDao database = HighScoreDao.getInstance();

    /**
     * Initialize the game.
     */
    @FXML
    public void initialize() {
        mastermind = new Mastermind();
        try {
            highScore.setText("Highscore: " + String.valueOf(database.findScoreByName("mastermind").getScore()));
        } catch (NoResultException e) {
            log.error("No DB result found.");
        }
    }

    /**
     * Set Image view to the color image (that color what we pressed).
     *
     * @param event Event of the action.
     */
    @FXML
    public void processColor(ActionEvent event) {
        if (mastermind.getGameState() == 1 && rowHelper != 4) {
            String colorPressed = ((Button) event.getSource()).getText();
            errorLabel.setText("");
            ImageView view = (ImageView) leftPane.getChildren().get(lastStep);
            switch (colorPressed) {
                case "RED":
                    view.setImage(Color.get(Color.RED));
                    log.info("RED is clicked.");
                    break;
                case "WHITE":
                    view.setImage(Color.get(Color.WHITE));
                    log.info("WHITE is clicked.");
                    break;
                case "BLUE":
                    view.setImage(Color.get(Color.BLUE));
                    log.info("BLUE is clicked.");
                    break;
                case "PINK":
                    view.setImage(Color.get(Color.PINK));
                    log.info("PINK is clicked.");
                    break;
                case "ORANGE":
                    view.setImage(Color.get(Color.ORANGE));
                    log.info("ORANGE is clicked.");
                    break;
                case "PURPLE":
                    view.setImage(Color.get(Color.PURPLE));
                    log.info("PURPLE is clicked.");
                    break;
                case "YELLOW":
                    view.setImage(Color.get(Color.YELLOW));
                    log.info("YELLOW is clicked.");
                    break;
                case "GREEN":
                    view.setImage(Color.get(Color.GREEN));
                    log.info("GREEN is clicked.");
                    break;
            }
            lastStep++;
            rowHelper++;
        } else if (mastermind.getGameState() == 1) {
            errorLabel.setText("You need to check that you guessed " + "\n" + "correctly or not!" + "\n" +
                    "Use Submit button!" + "\n" +
                    "Or change your selected colors with " + "\n" + "Back button!");
            log.info("You need to check that you guessed correctly or not! Use Submit button! Or change your selected colors with Back button!");
        }
    }

    /**
     * What to do when press the Back button.
     *
     * @param event Action event of the button.
     */
    public void processBack(ActionEvent event) {
        if (lastStep > 0 && mastermind.getGameState() == 1 && rowHelper > 0) {
            errorLabel.setText("");
            ImageView view = (ImageView) leftPane.getChildren().get(lastStep - 1);
            //Delete the last color in image view, if we can (for example we don't submit it yet)
            view.setImage(null);
            //We need to decrease helper integers!
            lastStep--;
            rowHelper--;
            log.info("Back button is clicked. Revert step.");
        }
    }

    /**
     * Show us the secret colors, which had to be guessed.
     *
     * @param i     Color position in integer (4 random color so 0, 1, 2 or 3).
     * @param color Color value.
     */
    public void setColor(int i, Image color) {
        ((ImageView) secretPane.getChildren().get(i)).setImage(color);
    }

    /**
     * What to do when press the Submit button.
     *
     * @param event Action event of the button.
     */
    public void processSubmit(ActionEvent event) {
        log.info("Submit button is clicked.");

        errorLabel.setText("");
        currentScore.setText(String.valueOf(--gameScore));
        //If we have 4 colors in a row we can submit our tips, otherwise we can't
        if (lastStep % 4 == 0 && lastStep != 0 && lastStep != 40) {
            PinStruct pins = mastermind.process(leftPane, lastStep);
            //With this for loop, we write out pins
            for (int i = 0; i < pins.getBlack() + pins.getWhite(); i++) {
                //This will be return the right position:
                ImageView rightView = (ImageView) rightPane.getChildren().get(((int) Math.floor(lastStep / 4) - 1) * 4 + i);
                //Important, we write out black pins first, after whites (not in order according to evaluation)
                if (i < pins.getBlack()) {
                    rightView.setImage(Color.get(Color.BLACK));
                } else
                    rightView.setImage(Color.get(Color.WHITE));
            }
            rowHelper = 0;

            //Write out in infobox if none of our tip is good
            if (pins.getBlack() + pins.getWhite() == 0) {
                errorLabel.setText("All of your guesses are wrong!");

                log.info("All guesses are wrong.");

            } else if (pins.getBlack() == 4) { //If all of them is good write out congratulations message in infobox and...
                mastermind.setGameState(2);
                errorLabel.setText("Congratulations, you win!" + "\n" + "You guessed all the colors!" + "\n" + "If you want to play another match " +
                        "\n" + "press new game button!" + "\n" + "Or if you want to play with " + "\n" + "another mini game, press " +
                        "\n" + "Back to menu button!");

                log.info("Congratulations, you win! You guessed all the colors! If you want to play another match press new game button! " +
                        "Or if you want to play with another mini game, press Back to menu button!");

                for (int i = 0; i < 4; i++) { //...show the secret colors!
                    setColor(i, Color.get(Color.getByValue(mastermind.getGuessColors()[i])));
                }

            }
        } else if (lastStep < 40) { //If we have not 4 colors in a row write this error message in infobox
            errorLabel.setText("You must select 4 colors to check!" + "\n" +
                    "Use Color buttons");

            log.info("You must select 4 colors to check! Use Color buttons");

        } else { //If none of the previous statement, then lose this match unfortunately :( , write this message in infobox:
            mastermind.setGameState(3);
            errorLabel.setText("Unfortunately you failed this time");

            log.info("Unfortunately you failed this time");

            for (int i = 0; i < 4; i++) { //Here show the secret colors like above:
                setColor(i, Color.get(Color.getByValue(mastermind.getGuessColors()[i])));
            }
            if (score == null) {
                database.persist(new HighScore(this.game, this.name1, gameScore));
            } else if (gameScore > this.score.getScore()) {
                database.update(score, gameScore, this.game);

                log.info("Highscore saved: {}",gameScore);

                highScore.setText("Highscore: " + String.valueOf(gameScore));
            }
        }

    }

    /**
     * Start a new game.
     *
     * @param actionEvent Event of the action.
     * @throws IOException Error if file not found.
     */
    public void processNewGame(MouseEvent actionEvent) throws IOException {
        PageLoader.loadGame(actionEvent, "mastermind", this.name1);
        log.info("New game started.");
    }

    /**
     * Go back to main menu.
     *
     * @param actionEvent Event of the action.
     * @throws IOException Error if file not found.
     */
    public void processBackToMenu(MouseEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        log.info("Back to menu button is clicked.");
    }
}
