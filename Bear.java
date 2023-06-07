import java.awt.Color;

public class Bear extends Critter {
    private boolean polar; // Tells us if the bear is polar or not
    private boolean slash; // Allows us to switch between a slash and a backslash

    public Bear(boolean polar) {
        this.polar = polar; // Initialize the polar variable with the provided value
        this.slash = true; // Initialize the slash variable to be true
    }

    public Color getColor() {
        return polar ? Color.WHITE : Color.BLACK;
        // If polar is true, return Color.WHITE (white color for polar bears)
        // Otherwise, return Color.BLACK (black color for black bears)
    }

    public String toString() {
        slash = !slash; // Toggle the value of slash variable with each call to toString()
        return slash ? "/" : "\\";
        // If slash is true, return "/" (slash)
        // If slash is false, return "\" (backslash)
        // This alternates the character returned with each call, starting with a slash
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
            // If there is an enemy (OTHER) in front, return Action.INFECT
            // Indicates that the bear wants to infect the enemy
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
            // If there is an empty space (EMPTY) in front, return Action.HOP
            // Indicates that the bear wants to hop forward
        } else {
            return Action.LEFT;
            // If none of the above conditions are met, return Action.LEFT
            // Indicates that the bear wants to turn left
        }
    }
}
