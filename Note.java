/**
 * Holds Note meta-information (e.g. location on the Board, width, height,
 * color, content/message, pinned/unpinned).
 */
public class Note {

    private int x;
    private int y;
    private int width;
    private int height;
    private String color;
    private String message;
    private boolean pinned;
    private int numPins;

    public Note(int x, int y, int width, int height, String color, String message) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.message = message;
        this.pinned = false;
        this.numPins = 0;
    }

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

    public void updatePinned(boolean beingPinned) {
        if (beingPinned) {
            // Same action if 1st Pin or 100th Pin
            this.numPins++;
            this.pinned = true;
        } else {
            if (this.numPins == 1) {
                // Last Pin pinning this Note to the Board, update to un-pinned
                this.numPins = 0;
                this.pinned = false;
            } else {
                // Just removing a Pin
                this.numPins--;
            }
        }
    }
}
