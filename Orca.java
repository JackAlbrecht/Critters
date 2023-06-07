import java.awt.Color;

public class Orca extends Critter {
    private Color color; // The color of the Orca
    private String name; // The name of the Orca
    private int moveCount; // Keeps track of the number of moves made by the Orca

    public Orca() {
        this.color = Color.BLACK; // Set the color of the Orca to black
        this.name = "JAWS"; // Set the name of the Orca to "JAWS"
        this.moveCount = 0; // Initialize moveCount to 0
    }

    public Color getColor() {
        return color; // Returns the color of the Orca
    }

    public String toString() {
        return name; // Returns the name of the Orca
    }

    public Action getMove(CritterInfo info) {
        moveCount++; // Increment the moveCount by 1 with each call to getMove()

        if (moveCount > 6) {
            moveCount = 1;
            // If moveCount exceeds 6, reset it to 1 to start counting again
            // This allows for the repetitive movement pattern of the Orca
        }

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
            // If there is an enemy (OTHER) in front, return Action.INFECT
            // Indicates that the Orca wants to infect the enemy
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
            // If there is a wall (WALL) in front or to the right, return Action.LEFT
            // Indicates that the Orca wants to turn left
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
            // If there is a fellow Orca (SAME) in front, return Action.RIGHT
            // Indicates that the Orca wants to turn right
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
            // If the front is empty, return Action.HOP
            // Indicates that the Orca wants to hop forward
        } else {
            return Action.RIGHT;
            // If none of the above conditions are met, default to turning right
            // This helps the Orca avoid getting stuck in certain situations
        }
    }
}
