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
                    blackPin++;
                    whiteExt.add(i);
                    whiteMyExt.add(i);
                }
        }

        for (int i = 0; i < 4; i++) {
            getImage(i, leftPane, lastStep);
            if (color != null) {
                if (!color.equals(Color.getByValue(guessColors[i])) && !whiteMyExt.contains(i)) {
                    for (int j = 0; j < 4; j++) {
                        Color guess = Color.getByValue(guessColors[j]);
                        if (!whiteExt.contains(j) && !whiteMyExt.contains(i)) {
                            if (color.equals(guess)) {
                                whitePin++;
                                whiteExt.add(j);
                                whiteMyExt.add(i);
                            }
                        }
                    }
                }
            }
        }
        return new PinStruct(whitePin, blackPin);
    }
}
