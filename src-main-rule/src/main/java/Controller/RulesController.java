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
        //Constructor
    }

    @FXML
    private void initialize(){
       //Init code
    }

    public void playClick (MouseEvent mouseEvent) {
        // Pageloader loads page
    }

    public void backClick(MouseEvent mouseEvent) {
        //Pageloader loads Main page
    }
}
