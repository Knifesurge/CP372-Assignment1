import java.util.List;

/**
 * Holds Pin meta-information (e.g. location on the board),
 * and information about what Notes this Pin "pins" to the Board.
 */
public class Pin {

    private int x;
    private int y;
    private List<Note> pinnedNotes;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Note> getPinnedNotes() {
        return pinnedNotes;
    }
}
