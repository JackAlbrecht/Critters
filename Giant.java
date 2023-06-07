import java.awt.Color;
import java.util.Random;

public class Giant extends Critter {
    private int moveCount; // Keeps track of the number of moves made by the Giant
    private int sequenceIndex; // The current index of the sequence array
    private String[] sequences; // Array to store the different sequences of strings

    public Giant() {
        this.moveCount = 0; // Initialize moveCount to 0
        this.sequenceIndex = 0; // Initialize sequenceIndex to 0
        this.sequences = new String[]{"fee", "fie", "foe", "fum"};
        // Initialize the sequences array with four strings: "fee", "fie", "foe", "fum"
    }

    public Color getColor() {
        return Color.GRAY;
        // Returns the color of the Giant as gray
    }

    public String toString() {
        return sequences[sequenceIndex];
        // Returns the string at the current sequenceIndex position in the sequences array
    }

    public Action getMove(CritterInfo info) {
        moveCount++; // Increment the moveCount by 1 with each call to getMove()

        if (moveCount > 6) {
            sequenceIndex = (sequenceIndex + 1) % sequences.length;
            moveCount = 1;
            // If moveCount exceeds 6, update sequenceIndex to the next index in a circular manner
            // Reset moveCount to 1 to start counting again for the new sequence
        }

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
            // If there is an enemy (OTHER) in front, return Action.INFECT
            // Indicates that the Giant wants to infect the enemy
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
            // If there is an empty space (EMPTY) in front, return Action.HOP
            // Indicates that the Giant wants to hop forward
        } else {
            return Action.RIGHT;
            // If none of the above conditions are met, return Action.RIGHT
            // Indicates that the Giant wants to turn right
        }
    }
}
