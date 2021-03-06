package Helpers;

import Controller.Controller;
import Controller.RulesController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
@Log4j2
public class PageLoader {

    public static void loadGame(MouseEvent mouseEvent, String game, String name) throws IOException {
        //log.info("{}.fxml is loaded.",game);
        FXMLLoader fxmlLoader = new FXMLLoader(PageLoader.class.getResource("/fxml/"+game+".fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.<Controller>getController().initdata(game,name);
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void loadRules(MouseEvent mouseEvent, String game) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(PageLoader.class.getResource("/fxml/rules.fxml"));
        RulesController controller = new RulesController(game);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
