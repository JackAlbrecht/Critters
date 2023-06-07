import java.awt.Color;

public class Orca extends Critter {
    private Color color;
    private String name;
    private int moveCount;

    public Orca() {
        this.color = Color.BLACK;
        this.name = "Orca";
        this.moveCount = 0;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return name;
    }

    public Action getMove(CritterInfo info) {
        moveCount++;
        if (moveCount > 6) {
            moveCount = 1;
        }

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT; // Always infect if an enemy is in front
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT; // Turn left if a wall is in front or to the right
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT; // Turn right if a fellow Orca is in front
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP; // Hop if the front is empty
        } else {
            return Action.RIGHT; // Default to turning right to avoid getting stuck
        }
    }
}
