package Controller;

import Helpers.PageLoader;
import antlr.StringUtils;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MainController extends Controller{

    private ImageView image;

    private String game;

    public void gameChosing(MouseEvent mouseEvent) throws Exception{
        try{
            image=(ImageView)mouseEvent.getTarget();
            getGameFromID();
            PageLoader.loadRules(mouseEvent,game);
            log.info("{} is chosen.", game);
        } catch (Exception e){
            throw e;
        }
    }

    private void getGameFromID(){
        game=image.getId();
        game=game.substring(5);
    }
}
