package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeController {

    @FXML
    private Label scoreLabel;

    @FXML
    private Label highScoreLabel;

    @FXML
    private Button backButton;

    @FXML
    private Pane grid;

    @FXML
    public void initialize(){
        generateGridPane();
    }

    private void generateGridPane(){
        GridPane gridPane = new GridPane();
        gridPane.setPrefWidth(700.5);
        gridPane.setPrefHeight(500);
        gridPane.setGridLinesVisible(true);
        for(int i=0; i<15; i++){
            for(int j=0; j<15; j++){
                Label label = new Label ();
                label.setId(createID(i,j));
                label.setPrefHeight(33.0);
                label.setPrefWidth(46.7);
                gridPane.addRow(i, label);
                System.out.println(label.getId());
            }
        }
        grid.getChildren().add(gridPane);
    }

    public String createID(int i, int j){
        return String.valueOf(i)+"_"+String.valueOf(j);
    }

    public void backToRulePage(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();

        if (button.getId().equals("backButton")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/rules.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
