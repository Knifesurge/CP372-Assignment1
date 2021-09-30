import java.util.List;

/**
 * Holds Note meta-information (e.g. location on the Board, width, height,
 * color, content/message, pinned/unpinned, Pins pinning this Note to the Board).
 */
public class Note {

    private int x;
    private int y;
    private int width;
    private int height;
    private String color;
    private String message;
    private boolean pinned;
    private List<Pin> pins;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public String getMessage() {
        return message;
    }

    public boolean isPinned() {
        return pinned;
    }

    public List<Pin> getPins() {
        return pins;
    }

}
