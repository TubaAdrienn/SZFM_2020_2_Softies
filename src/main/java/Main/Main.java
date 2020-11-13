package Main;

import Snake.GameState;
import javafx.application.Application;

public class Main{

    public static void main(String[] args) {
       // Application.launch(MyApp.class, args);
        GameState gameState = new GameState();

        gameState.moveSnake();
    }
}