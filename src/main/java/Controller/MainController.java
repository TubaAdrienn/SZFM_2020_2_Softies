package Controller;

import Helpers.PageLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainController extends Controller{

    private ImageView image;

    private String game;

    public void gameChosing(MouseEvent mouseEvent) throws Exception{
        try{
            image=(ImageView)mouseEvent.getTarget();
            getGameFromID();
            PageLoader.loadRules(mouseEvent,this.game);
            System.out.println(game);
        } catch (Exception e){
            throw e;
        }
    }

    private void getGameFromID(){
        game=image.getId();
        game=game.substring(5);
        System.out.println(game);
    }
}
