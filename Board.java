import java.util.*;

/**
 * Holds Board meta-information (e.g., Board width, height, available colors),
 * stores all Notes and Pins.
 */
public class Board {

    private int width;
    private int height;
    private List<String> colors;
    private List<Note> notes;
    private List<Pin> pins;

    public Board(int width, int height, String... colors) {
        this.width = width;
        this.height = height;
        this.colors = Arrays.asList(colors);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getColors() {
        return colors;
    }

    public List<Note> getNotes() {
        return notes;
    }

    /**
     * Adds a Note to the Board's List of Notes if the Note falls within
     * the Boards bounds.
     * @param note - Note to add to Board
     * @return true if Note added, false otherwise
     */
    public boolean addNote(Note note) {
        if (checkBounds(note.getX(), note.getY(), note.getWidth(), note.getHeight())) {
            notes.add(note);
            return true;
        }
        return false;
    }

    /**
     * Adds a Pin to the Board if the Pin falls within the Boards bounds.
     * Any Notes this Pin intersects has its status updated to <i>pinned</i>.
     * @param x - X coord of Pin
     * @param y - Y coord of Pin
     * @return true if Pin added, false otherwise
     */
    public boolean pin(int x, int y) {
        if (checkBounds(x, y, 0, 0)) {
            return true;
        }
        return false;
    }

    /**
     * Removes a Pin from the board <i>if the Pin exists</i>.
     *
     * Any Notes that only have this Pin intersecting them has its status
     * updated to <i>unpinned</i>. Notes that are pinned by more than one Pin
     * will not have their status updated.
     * @param x - X coord of Pin
     * @param y - Y coord of Pin
     * @return true if Pin removed, false otherwise
     */
    public boolean unpin(int x, int y) {
        if (checkBounds(x, y, 0, 0)) {
            return true;
        }
        return false;
    }

    public List<Note> filterNotes(String filters) {
        StringTokenizer tokens = new StringTokenizer(filters);
        System.out.println(tokens);

        return new ArrayList<Note>();
    }

    /**
     * Removes any <i>unpinned</i> Notes from the Board.
     */
    public void shake() {
        Iterator<Note> i = notes.iterator();
        while (i.hasNext()) {
            Note n = i.next();
            if (!n.isPinned()) {
                i.remove();
            }
        }
    }

    /**
     * Removes all Notes and Pins from the Board.
     */
    public void clear() {
        notes.clear();
        pins.clear();
    }

    /**
     * Checks whether the given coordinates and dimensions fit on the Board.
     * @param x - X coord
     * @param y - Y coord
     * @param w - Width
     * @param h - Height
     * @return true if within bounds, false otherwise
     */
    private boolean checkBounds(int x, int y, int w, int h) {
        return x >= 0
                && y >= 0
                && w >= 0
                && h >= 0
                && (x + w) < width
                && (y + h) < height;
    }
}
