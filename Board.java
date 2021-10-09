import java.util.*;
import java.util.stream.Collectors;

/**
 * Holds Board meta-information (e.g., Board width, height, available colors),
 * stores all Notes and Pins.
 */
public class Board {

    private int width;
    private int height;
    private ArrayList<String> colors;
    private ArrayList<Note> notes;
    private ArrayList<Pin> pins;

    public Board(int width, int height, String... colors) {
        this.width = width;
        this.height = height;
        this.colors = new ArrayList<String>(Arrays.asList(colors));
        this.notes = new ArrayList<Note>();
        this.pins = new ArrayList<Pin>();
    }


    public String inputParser(String args){
        if (args == null) return "Welcome";

        String outMsg = "ERROR";
        String[] splitArgs = args.split(" ");
        // Attempt to remove the null values
        ArrayList<String> temp = new ArrayList<String>();
        for (String s : splitArgs) {
            if (!s.isEmpty() && !s.equals("null")) {
                System.out.println("Adding " + s + " to temp");
                temp.add(s);
            }
        }
        String[] aArgs = temp.toArray(new String[0]);
        String command = aArgs[0];

        for (String s : aArgs) {
            System.out.println(">> " + s);
        }

        if (command.equals("DISCONNECT")) {
            return command;
        } else if (command.equals("GET")) {
            String color = aArgs.length >= 2 ? aArgs[1].substring("color=".length()) : "";
            String[] contains = aArgs.length >= 3 ? aArgs[2].substring("contains=".length()).split(" ") : new String[]{"-1","-1"};
            int x = Integer.parseInt(contains[0]);
            int y = Integer.parseInt(contains[1]);
            String refersTo = aArgs.length >= 4 ? aArgs[3].substring("refersTo=".length()) : "";
            ArrayList<Note> notes;
            if (x == -1 || y == -1)
                notes = filterNotes(color, "", refersTo);
            else
                notes = filterNotes(color, new String(x+" "+y), refersTo);
            outMsg = "";
            for (Note n : notes) {
                System.out.println("Adding note.." + n.toString());
                outMsg += n.toString();
                outMsg += "\n";
            }
        } else if (command.equals("POST")) {
            int x = Integer.parseInt(aArgs[1]);
            int y = Integer.parseInt(aArgs[2]);
            int w = Integer.parseInt(aArgs[3]);
            int h = Integer.parseInt(aArgs[4]);
            String color = aArgs[5];
            String message = aArgs[6];
            outMsg = "";

            boolean added = addNote(x, y, w, h, color, message.toString());
            if (added) outMsg += "Note added.";
            else outMsg += "Note not added. Please try again.";
        } else if (command.equals("PIN")) {
            String[] coords = aArgs[1].split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);

            outMsg = "";
            boolean pinned = pin(x, y);
            if (pinned) outMsg += "Pin added.";
            else outMsg += "Pin not added. Please try again.";
        } else if (command.equals("UNPIN")) {
            String[] coords = aArgs[1].split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);

            outMsg = "";
            boolean unpinned = unpin(x, y);
            if (unpinned) outMsg += "Pin removed.";
            else outMsg += "Pin not removed. Please try again.";
        } else if (command.equals("SHAKE")) {
            outMsg = "";
            boolean shaked = shake();
            if (shaked) outMsg += "Board shaken.";
            else outMsg += "Something happened while shaking the Board. Please try again.";
        } else if (command.equals("CLEAR")) {
            clear();
            outMsg = "Board cleared.";
        }
        return outMsg;
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
            Pin chosenPin = new Pin(-1, -1, null);
            for (Pin pin : pins) {
                if (pin.getX() == x && pin.getY() == y) {
                    chosenPin = pin;
                    break;
                }
            }
            // Check if chosenPin valid
            if (chosenPin.getX() == -1 && chosenPin.getY() == -1)
                return false;
            // Check if Pin on any Notes, update Pin's list of Notes
            if (!chosenPin.getPinnedNotes().isEmpty()) {
                for (Note n : chosenPin.getPinnedNotes()) {
                    n.updatePinned(false);
                }
            }
            return true;
        }
        return false;
    }

    public synchronized ArrayList<Note> filterNotes(String color, String contains, String refersTo) {
        ArrayList<Note> fnotes = new ArrayList<Note>();
        // Only filter on filters that are present
        boolean fColor = color.isEmpty() ? false : true;
        boolean fContains = contains.isEmpty() ? false : true;
        boolean fRefersTo = refersTo.isEmpty() ? false : true;

        // Checks which filters are present and filters the notes accordingly.
        // The filtered Notes are then added to the fnotes List above, to be returned to the caller.
        // Any suggestions on how to do this without this big branch would be welcomed :)
        if (color.equals("all")){
            // Requesting all colors, which is really just all notes
            fnotes.addAll(getNotes());
        } else {
            if (fColor) {
                if (fContains) {
                    // Get the coords out of the string
                    String[] containsTmp = contains.split(" ");
                    int x = Integer.parseInt(containsTmp[0]);
                    int y = Integer.parseInt(containsTmp[1]);
                    if (fRefersTo) {
                        fnotes.addAll(
                                notes.stream()
                                        .filter(n -> n.getColor().equals(color) &&
                                                checkBounds(n.getX(), n.getY(), n.getWidth(), n.getHeight(),
                                                        x, y, 0, 0) &&
                                                n.getMessage().contains(refersTo)
                                        ).collect(Collectors.toList())
                        );
                    }
                } else if (fRefersTo) {
                    fnotes.addAll(
                            notes.stream()
                                    .filter(n -> n.getColor().equals(color) &&
                                            n.getMessage().contains(refersTo)
                                    ).collect(Collectors.toList())
                    );
                } else {
                    fnotes.addAll(
                            notes.stream()
                                    .filter(n -> n.getColor().equals(color)
                                    ).collect(Collectors.toList())
                    );
                }
            } else if (fContains) {
                if (fRefersTo) {
                    fnotes.addAll(
                            notes.stream()
                                    .filter(n -> checkBounds(n.getX(), n.getY(), n.getWidth(), n.getHeight(),
                                            x, y, 0, 0) &&
                                            n.getMessage().contains(refersTo)
                                    ).collect(Collectors.toList())
                    );
                } else {
                    fnotes.addAll(
                            notes.stream()
                                    .filter(n -> checkBounds(n.getX(), n.getY(), n.getWidth(), n.getHeight(),
                                            x, y, 0, 0)
                                    ).collect(Collectors.toList())
                    );
                }
            } else if (fRefersTo) {
                fnotes.addAll(
                        notes.stream()
                                .filter(n -> n.getMessage().contains(refersTo)
                                ).collect(Collectors.toList())
                );
            } else {
                fnotes.addAll(notes);
            }
        }
        return fnotes;
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
