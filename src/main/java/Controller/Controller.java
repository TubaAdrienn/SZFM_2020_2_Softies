package Controller;

import javafx.scene.Scene;

public class Controller {

    protected String game;
    protected String name1;
    protected String name2;
    protected Scene scene;

    public void initdata(String game,String name1,String name2){
        this.name1=name1;
        this.name2=name2;
        this.game=game;
    }

    public void init(Scene scene){ this.scene = scene; }
}