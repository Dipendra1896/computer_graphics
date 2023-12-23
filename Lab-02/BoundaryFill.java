import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.util.Stack;

/**
 * The BoundaryFill class is a Java program that demonstrates the boundary fill algorithm.
 * It fills a circle with a specified fill color while maintaining the boundary color.
 */
public class BoundaryFill extends JFrame {

    private int x = 150, y = 200, radius = 70;
    private int FILL_COLOR = Color.GREEN.getRGB();
    private int BOUNDARY_COLOR = Color.BLACK.getRGB();
    private BufferedImage image;

    /**
     * The entry point of the program.
     * Creates an instance of the BoundaryFill class.
     */
    public static void main(String[] args) {
        new BoundaryFill();
    }

    /**
     * The constructor of the BoundaryFill class.
     * Sets up the GUI window, initializes the image buffer, and draws the circle boundary.
     */
    public BoundaryFill() {
        setTitle("Boundary Fill");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
        g.dispose();
    }

    /**
     * Overrides the paint method of JFrame to draw the image buffer on the GUI window
     * and fill the circle using the boundaryFill method.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);

        // Fill the circle
        boundaryFill(x, y, FILL_COLOR, BOUNDARY_COLOR);
        g.drawImage(image, 0, 0, this);
    }

    /**
     * Performs the boundary fill algorithm to fill the circle with the specified fill color
     * while maintaining the boundary color.
     */
    private void boundaryFill(int x, int y, int fillColor, int boundaryColor) {
        Color targetColor = new Color(image.getRGB(x, y));

        if (!targetColor.equals(new Color(fillColor)) && !targetColor.equals(new Color(boundaryColor))) {
            Stack<Point> stack = new Stack<>();
            stack.push(new Point(x, y));

            while (!stack.isEmpty()) {
                Point point = stack.pop();
                int px = point.x;
                int py = point.y;

                targetColor = new Color(image.getRGB(px, py));
                if (!targetColor.equals(new Color(fillColor)) && !targetColor.equals(new Color(boundaryColor))) {
                    image.setRGB(px, py, fillColor);

                    if (px + 1 < getWidth()) {
                        stack.push(new Point(px + 1, py));
                    }
                    if (px - 1 >= 0) {
                        stack.push(new Point(px - 1, py));
                    }
                    if (py + 1 < getHeight()) {
                        stack.push(new Point(px, py + 1));
                    }
                    if (py - 1 >= 0) {
                        stack.push(new Point(px, py - 1));
                    }
                }
            }
        }
    }

    /**
     * Represents a point in the image.
     */
    private static class Point {
        int x, y;

        /**
         * Constructs a Point object with the given coordinates.
         */
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
