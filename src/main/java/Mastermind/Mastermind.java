package Mastermind;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mastermind {

    @Getter @Setter
    private int gameState;

    private Random rand;

    @Getter
    private int[] guessColors;

    private ImageView view;
    private Color color;

    /**
     * Make 4 random secret color. And set active(1) status for game state.
     */
    public Mastermind(){
        this.gameState = 1;
        this.rand = new Random();
        this.guessColors = new int[4];
        for (int i = 0; i < 4; i++)
            this.guessColors[i] = this.rand.nextInt(8);
    }

    /**
     * Get the image which we need
     * @param gridNumber Index of image which we need.
     * @param leftPane A grid pane where we want to search the right image with a right index.
     * @param lastStep An integer which contain how many steps we did.
     */
    private void getImage(int gridNumber, GridPane leftPane, int lastStep){
        view = (ImageView) leftPane.getChildren().get(((int) Math.floor(lastStep / 4) - 1) * 4 + gridNumber);
        color = Color.findByImage(view.getImage());
    }

    /**
     * Return how many correct colors in good place we guessed well (black pins),
     * and how many correct colors in bad place we guessed well (white pins).
     * @param leftPane A grid pane, where we want to check answers.
     * @param lastStep An integer which contain how many steps we did.
     * @return Return values of black pins and white pins.
     */
    public PinStruct process(GridPane leftPane, int lastStep) {
        int whitePin = 0;
        int blackPin = 0;
        List<Integer> whiteExt = new ArrayList<Integer>();
        List<Integer> whiteMyExt = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            getImage(i, leftPane, lastStep);
            if (color != null)
                if (color.equals(Color.getByValue(guessColors[i]))) {
                    blackPin++;         //If our color tip is correct we got a black pin for it and that position will be overlooked next time
                    whiteExt.add(i);    //(i position) Will be overlooked secret side.
                    whiteMyExt.add(i);  //(i position) Will be overlooked tips side.
                }
        }

        //After previous for loop we already know black pins, and which positions need to overlooked, so now we can start to count white pins
        for (int i = 0; i < 4; i++) {
            getImage(i, leftPane, lastStep);
            if (color != null) {
                if (!color.equals(Color.getByValue(guessColors[i])) && !whiteMyExt.contains(i)) {
                    for (int j = 0; j < 4; j++) {
                        Color guess = Color.getByValue(guessColors[j]);
                        if (!whiteExt.contains(j) && !whiteMyExt.contains(i)) { //If we do not need to overlooked them then continue
                            if (color.equals(guess)) { //If our tip is equal with the secret color then...
                                whitePin++;         //we got a white pin for that and...
                                whiteExt.add(j);    //we add to it to "overlooked" list in secret side and...
                                whiteMyExt.add(i);  //we add to it to "overlooked" list in tips side too.
                            }
                        }
                    }
                }
            }
        }
        return new PinStruct(whitePin, blackPin);   //Return the number of black and white pins.
    }
}
