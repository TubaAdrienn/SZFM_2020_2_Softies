package mastermind;

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

    public Mastermind(){
        this.gameState = 1;
        this.rand = new Random();
        this.guessColors = new int[4];

        for (int i = 0; i < 4; i++)
            this.guessColors[i] = this.rand.nextInt(8);
    }

    public PinStruct process(GridPane leftPane, int lastStep) {
        int whitePin = 0;
        int blackPin = 0;
        List<Integer> whiteExt = new ArrayList<Integer>();
        List<Integer> whiteMyExt = new ArrayList<Integer>();

        for (int i = 0; i < 4; i++) {
            ImageView view = (ImageView) leftPane.getChildren().get(((int) Math.floor(lastStep / 4) - 1) * 4 + i);
            Color color = Color.findByImage(view.getImage());
            if (color != null)
                if (color.equals(Color.getByValue(guessColors[i]))) {
                    blackPin++;
                    whiteExt.add(i);
                    whiteMyExt.add(i);
                }
        }

        for (int i = 0; i < 4; i++) {
            ImageView view = (ImageView) leftPane.getChildren().get(((int) Math.floor(lastStep / 4) - 1) * 4 + i);
            Color color = Color.findByImage(view.getImage());
            if (color != null)
                if (!color.equals(Color.getByValue(guessColors[i])) && !whiteMyExt.contains(i)) {
                    for (int j = 0; j < 4; j++) {
                        Color guess = Color.getByValue(guessColors[j]);
                        if (!whiteExt.contains(j) && !whiteMyExt.contains(i)) {
                            if (color.equals(guess)) {
                                whiteExt.add(j);
                                whiteMyExt.add(i);
                                whitePin++;
                            }
                        }
                    }
                }
        }

        return new PinStruct(whitePin, blackPin);
    }
}
