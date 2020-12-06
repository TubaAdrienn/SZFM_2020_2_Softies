package Controller;

import Database.DatabaseXML;
import Database.Rules;
import Helpers.PageLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
@Log4j2
public class RulesController extends Controller {

    @FXML
    private Label rulesLabel;

    @FXML
    private TextField nameField;
  
    @FXML
    private ImageView iconimage;

    private String rulesText;

    private Rules rules;

    public RulesController(String game) throws Exception {
        rules = DatabaseXML.loadRules();
        this.game=game;
        rulesText = rules.getRuleByName(game).getDesc();
    }

    @FXML
    private void initialize(){
        switch (game){
            case "2048":
                iconimage.setImage(new Image(RulesController.class.getResource("/images/icon2048.png").toExternalForm()));
                break;
            case "mastermind":
                iconimage.setImage(new Image(RulesController.class.getResource("/images/iconmm.png").toExternalForm()));
                break;
            case "snake":
                iconimage.setImage(new Image(RulesController.class.getResource("/images/iconsnake.png").toExternalForm()));
                break;
            case "tictactoe":
                nameField.setVisible(false);
                iconimage.setImage(new Image(RulesController.class.getResource("/images/iconttt.png").toExternalForm()));
                break;
        }
        rulesLabel.setText(rulesText);
    }

    public void playClick (MouseEvent mouseEvent) throws IOException {
        try{
            log.info("Play button is clicked.");
            name1=nameField.getText();
            if(!name1.isEmpty()){
                PageLoader.loadGame(mouseEvent, this.game, name1);
                log.info("Username is set to {}, loading {} scene.", name1,game);
            } else{
                PageLoader.loadGame(mouseEvent, this.game, "Anonymus");
                log.info("Username is set to {}, loading {} scene.","Anonymus",game);
            }
        } catch (Exception e){
           throw e;
        }
    }

    public void backClick(MouseEvent mouseEvent) throws IOException {
        PageLoader.loadGame(mouseEvent, "main", null);
        log.info("Back button is clicked.");
    }
}
