import java.util.List;

/**
 * Holds Pin meta-information (e.g. location on the board),
 * and information about what Notes this Pin "pins" to the Board.
 */
public class Pin {

    private int x;
    private int y;
    private List<Note> pinnedNotes;

    /**
     * Create a new Pin at coordinates (x, y).
     * @param x - X-coord of this Pin
     * @param y - Y-coord of this Pin
     * @param notes - Notes that this Pin pins to the Board
     */
    public Pin(int x, int y, List<Note> notes) {
        this.x = x;
        this.y = y;
        this.pinnedNotes = notes;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Note> getPinnedNotes() {
        return pinnedNotes;
    }

    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }
}
