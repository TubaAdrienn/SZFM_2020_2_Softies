package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class RulesController extends Controller {

    @FXML
    private Label rulesLabel;

    protected String rules;

    public RulesController(String game) {
        this.game=game;
        switch (game) {
            case "tictactoe":
                this.rules = "TicTacToe rules.";
                break;
            case "mastermind":
                this.rules = "Mastermind rules.";
                break;
            case "2048":
                this.rules = "2048 rules.";
                break;
            case "snake":
                this.rules = "Snake rules.";
                break;
        }
    }

    @FXML
    private void initialize(){
        System.out.println("InitData");
        rulesLabel.setText(rules);
    }

    public void playClick (MouseEvent mouseEvent) throws IOException {
        try{
            PageLoader.loadGame(mouseEvent, this.game, name1, name2);
        } catch (Exception e){
            System.out.println("Game not implemented yet.");
        }
    }

    public void backClick(MouseEvent mouseEvent) throws IOException {
        PageLoader.loadGame(mouseEvent, "main", name1, name2);
    }
}
