import java.awt.Color;
import java.util.Random;
public class Giant extends Critter {
    private int moveCount;
    private int sequenceIndex;
    private String[] sequences;

    public Giant() {
        this.moveCount = 0;
        this.sequenceIndex = 0;
        this.sequences = new String[]{"fee", "fie", "foe", "fum"};
    }

    public Color getColor() {
        return Color.GRAY;
    }

    public String toString() {
        return sequences[sequenceIndex];
    }

    public Action getMove(CritterInfo info) {
        moveCount++;
        if (moveCount > 6) {
            sequenceIndex = (sequenceIndex + 1) % sequences.length;
            moveCount = 1;
        }

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
}
