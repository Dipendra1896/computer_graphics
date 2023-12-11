// Java Code for Bresenham line generation 
public class BresenhamAlgorithm {

    /**
     * Generates the points on a line connecting two given points using the Bresenham algorithm.
     *
     * x0 The x-coordinate of the starting point.
     * y0 The y-coordinate of the starting point.
     * x1 The x-coordinate of the ending point.
     * y1 The y-coordinate of the ending point.
     */
    public static void BresenhamLine(int x0, int y0, int x1, int y1) {
        System.out.println("Starting point: (x,y)= (" + x0 + "," + y0 + ")");
        System.out.println("Ending point: (x,y)= (" + x1 + "," + y1 + ")\n");

        // Calculate dx and dy
        int dx = x1 - x0;
        int dy = y1 - y0;

        // Calculate the decision parameter
        int pk = 2 * dy - dx;

        // Take the initial points as x and y
        int x = x0;
        int y = y0;

        int count = 1;

        while (x != x1 && y != y1) {
            if (pk < 0) {
                x++;
                pk += 2 * dy;
            } else if (pk > 0) {
                x++;
                y++;
                pk += 2 * dy - 2 * dx;
            } else {
                // Do nothing if pk = 0; not possible.
            }

            System.out.println("Iteration " + count + " (x,y)= (" + x + "," + y + ")");
            count++;
        }
    }

    // Driver code
    public static void main(String[] args) {
        int x0 = 9, y0 = 18, x1 = 14, y1 = 22;

        // Function call
        BresenhamLine(x0, y0, x1, y1);
    }
}