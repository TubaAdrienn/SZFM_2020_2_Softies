package Controller;

import javafx.scene.Scene;

public class Controller {

    protected String game;
    protected String name1;
    protected Scene scene;

    public void initdata(String game,String name1){
        this.name1=name1;
        this.game=game;
        System.out.println("Data initalized. Name: "+name1+", game: "+game);
    }

    public void init(Scene scene){ this.scene = scene; }
}
