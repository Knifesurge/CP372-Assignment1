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
    public String inputParser(String args){
        String[] aArgs = args.split(" ");
        if (args.isEmpty()) return "Welcome";

        if (aArgs[0].equals("DISCONNECT")) return aArgs[0];

        return "Error";
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
     * @param x - X-coord of Note
     * @param y - Y-coord of Note
     * @param width - Width of Note
     * @param height - Height of Note
     * @param color - Color of Note
     * @param message - Message of Note
     * @return true if Note added, false otherwise
     */
    public synchronized boolean addNote(int x, int y, int width, int height, String color, String message) {
        if (checkBounds(x, y, width, height)) {
            Note note = new Note(x, y, width, height, color, message);
            notes.add(note);
            return true;
        }
        return false;
    }

    /**
     * Adds a Pin to the Board if the Pin falls within the Boards bounds.
     * Any Notes this Pin intersects has its status updated to <i>pinned</i>.
     * @param x - X-coord of Pin
     * @param y - Y-coord of Pin
     * @return true if Pin added, false otherwise
     */
    public synchronized boolean pin(int x, int y) {
        if (checkBounds(x, y, 0, 0)) {
            // Pin coords fall within Board bounds
            // Check if Pin already in this position
            for (Pin p : pins) {
                if (p.getX() == x && p.getY() == y) {
                    // Don't add Pin if position already taken
                    return false;
                }
            }
            // Check if Pin falls on any Notes, keep reference of these Notes
            ArrayList<Note> pinnedNotes = new ArrayList<Note>();
            for (Note n : notes) {
                if (checkBounds(x, y, 0, 0, n.getX(), n.getY(), n.getWidth(), n.getHeight())) {
                    // Pin within bounds of this Note, add to list
                    pinnedNotes.add(n);
                    // Pin the Note
                    n.updatePinned(true);
                }
            }

            // Create a new Pin, add to list of Pins
            Pin pin = new Pin(x, y, pinnedNotes);
            pins.add(pin);
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
    public synchronized boolean unpin(int x, int y) {
        if (checkBounds(x, y, 0, 0)) {
            // Pin within the Board
            // Get the Pin at these coordinates

            // Check if Pin on any Notes, update Pin's list of Notes

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
     *
     * @return true if any Notes were remove, false otherwise
     */
    public synchronized boolean shake() {
        boolean removed = false;
        Iterator<Note> i = notes.iterator();
        while (i.hasNext()) {
            Note n = i.next();
            if (!n.isPinned()) {
                i.remove();
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Removes all Notes and Pins from the Board.
     */
    public synchronized void clear() {
        notes.clear();
        pins.clear();
    }

    /**
     * Checks whether first set of coordinates and dimensions fall within
     * the second set of coordinates and dimensions.
     *
     * This is an alternate way of calling checkBounds and providing each value
     * as an argument.
     *
     * @param bounds - Array of the bounds and dimensions to compare,
     *               formatted as [x1,y1,w1,h1,x2,y2,w2,h2] where x,y
     *               are integer coordinates and w,h are integer dimensions
     *               (width, height)
     * @return true if first set of bounds in the second, false otherwise
     */
    private boolean checkBounds(int... bounds) {

        return checkBounds(bounds[0], bounds[1], bounds[2], bounds[3], bounds[4], bounds[5], bounds[6], bounds[7]);
    }

    /**
     * Checks whether the first set of coordinates and dimensions fall within
     * the second set of coordinates and dimensions.
     *
     * This is used to check if Notes and Pins fall within the Board, and if a
     * Pin falls within the bounds of a Note.
     * @param x1 - X-coord of first object
     * @param y1 - Y-coord of first object
     * @param w1 - Width of first object
     * @param h1 - Height of first object
     * @param x2 - X-coord of second object
     * @param y2 - Y-coord of second object
     * @param w2 - Width of second object
     * @param h2 - Height of second object
     * @return true if first object within second object (totally or
     * partially), false otherwise.
     */
    private boolean checkBounds(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
        return x1 >= 0
                && y1 >= 0
                && w1 >= 0
                && h1 >= 0
                && x2 >= 0
                && y2 >= 0
                && w2 >= 0
                && h2 >= 0
                && (x1 + w1) < w2
                && (y1 + h1) < h2;
    }

    /**
     * Checks whether supplied coordinates and dimensions are within
     * this Board
     *
     * @param x - X-coord of object
     * @param y - Y-coord of object
     * @param w - Width of object
     * @param h - Height of object
     * @return true if object within the Board, false otherwise
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
