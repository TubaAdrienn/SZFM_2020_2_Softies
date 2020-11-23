package Controller;

import Database.DatabaseXML;
import Database.Rules;
import Helpers.PageLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class RulesController extends Controller {

    @FXML
    private Label rulesLabel;

    @FXML
    private TextField nameField;

    private String rulesText;

    private Rules rules;

    public RulesController(String game) throws Exception {
        rules = DatabaseXML.loadRules();
        this.game=game;
        rulesText = rules.getRuleByName(game).getDesc();
    }

    @FXML
    private void initialize(){
        System.out.println("InitData");
        rulesLabel.setText(rulesText);
    }

    public void playClick (MouseEvent mouseEvent) throws IOException {
        try{
            name1=nameField.getText();
            if(!name1.isEmpty()){
                PageLoader.loadGame(mouseEvent, this.game, name1);
            } else{
                PageLoader.loadGame(mouseEvent, this.game, "Anonymus");
            }
        } catch (Exception e){
            System.out.println("Game not implemented yet.");
        }
    }

    public void backClick(MouseEvent mouseEvent) throws IOException {
        PageLoader.loadGame(mouseEvent, "main", null);
    }
}
