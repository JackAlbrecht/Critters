import java.awt.Color;
import java.util.Random;

public class Lion extends Critter {
    private Color color; // The current color of the Lion
    private int moveCount; // Keeps track of the number of moves made by the Lion
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE}; // Array to store the possible colors

    public Lion() {
        this.color = getRandomColor(); // Initialize the color randomly
        this.moveCount = 0; // Initialize moveCount to 0
    }

    public Color getColor() {
        return color; // Returns the current color of the Lion
    }

    public String toString() {
        return "L"; // Returns the string "L"
    }

    public Action getMove(CritterInfo info) {
        moveCount++; // Increment the moveCount by 1 with each call to getMove()

        if (moveCount > 3) {
            color = getRandomColor();
            moveCount = 1;
            // If moveCount exceeds 3, update the color to a new random color
            // Reset moveCount to 1 to start counting again for the new color
        }

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
            // If there is an enemy (OTHER) in front, return Action.INFECT
            // Indicates that the Lion wants to infect the enemy
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
            // If there is a wall (WALL) in front or to the right, return Action.LEFT
            // Indicates that the Lion wants to turn left
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
            // If there is a fellow Lion (SAME) in front, return Action.RIGHT
            // Indicates that the Lion wants to turn right
        } else {
            return Action.HOP;
            // If none of the above conditions are met, return Action.HOP
            // Indicates that the Lion wants to hop forward
        }
    }

    private Color getRandomColor() {
        Random random = new Random();
        int choice = random.nextInt(colors.length); // Generate a random index within the range of the colors array
        return colors[choice]; // Return the color at the randomly generated index
    }
}
