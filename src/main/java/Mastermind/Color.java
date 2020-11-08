package Mastermind;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * The Color handle class.
 */
public enum Color {
    /**
     * This is contain the RED color enum.
     */
    RED,
    /**
     * This is contain the WHITEcolor enum.
     */
    WHITE,
    /**
     * This is contain the BLUE color enum.
     */
    BLUE,
    /**
     * This is contain the PINK color enum.
     */
    PINK,
    /**
     * This is contain the ORANGE color enum.
     */
    ORANGE,
    /**
     * This is contain the PURPLE color enum.
     */
    PURPLE,
    /**
     * This is contain the YELLOW color enum.
     */
    YELLOW,
    /**
     * This is contain the GREEN color enum.
     */
    GREEN,
    /**
     * This is contain the BLACK color enum.
     */
    BLACK;

    /**
     * Made color and image key value pair.
     */
    private static HashMap<Color, Image> colors = new HashMap<Color, Image>();

    /**
     * Add images to the color.
     */
    public static void initColors(){
        if (!colors.isEmpty())
            return;
        colors.put(Color.RED, new Image(Color.class.getResource("/img/red.png").toExternalForm()));
        colors.put(Color.WHITE, new Image(Color.class.getResource("/img/white.png").toExternalForm()));
        colors.put(Color.BLUE, new Image(Color.class.getResource("/img/blue.png").toExternalForm()));
        colors.put(Color.PINK, new Image(Color.class.getResource("/img/pink.png").toExternalForm()));
        colors.put(Color.ORANGE, new Image(Color.class.getResource("/img/orange.png").toExternalForm()));
        colors.put(Color.PURPLE, new Image(Color.class.getResource("/img/purple.png").toExternalForm()));
        colors.put(Color.YELLOW, new Image(Color.class.getResource("/img/yellow.png").toExternalForm()));
        colors.put(Color.GREEN, new Image(Color.class.getResource("/img/green.png").toExternalForm()));
        colors.put(Color.BLACK, new Image(Color.class.getResource("/img/black.png").toExternalForm()));
    }


    /**
     * Return color based on values.
     * @param value Value of the color
     * @return Return a color.
     */
    public static Color getByValue(int value) {
        for(Color c : Color.values())
            if (value == c.ordinal())
                return c;
        return null;
    }

    /**
     * Return color based on images.
     * @param image Image of the color.
     * @return Return a color.
     */
    public static Color findByImage(Image image) {
        initColors();

        for (Map.Entry<Color, Image> e : colors.entrySet())
            if (e.getValue().equals(image))
                return e.getKey();
        return null;
    }

    /**
     * Return the color.
     * @param c Color name.
     * @return Color.
     */
    public static Image get(Color c) {
        initColors();
        return colors.get(c);
    }
}