import java.awt.Color;
import java.util.Random;

public class Lion extends Critter {
    private Color color;
    private int moveCount;
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};

    public Lion() {
        this.color = getRandomColor();
        this.moveCount = 0;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "L";
    }

    public Action getMove(CritterInfo info) {
        moveCount++;
        if (moveCount > 3) {
            color = getRandomColor();
            moveCount = 1;
        }

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    private Color getRandomColor() {
        Random random = new Random();
        int choice = random.nextInt(colors.length);
        return colors[choice];
    }
}
