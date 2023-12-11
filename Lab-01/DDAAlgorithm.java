// Java Code for DDA line generation 
public class DDAAlgorithm { 

    /**
     * Rounds off a float number to the nearest integer.
     * @param n The float number to be rounded off.
     * @return The rounded integer value.
     */
    public static int round(float n) { 
        if (n - (int) n < 0.5) 
            return (int) n; 
        return (int) (n + 1); 
    } 

    /**
     * Generates a line between two points using the DDA algorithm.
     * @param x0 The x-coordinate of the starting point.
     * @param y0 The y-coordinate of the starting point.
     * @param x1 The x-coordinate of the ending point.
     * @param y1 The y-coordinate of the ending point.
     */
    public static void DDALine(int x0, int y0, int x1, int y1) { 
        System.out.println("Starting point: (x,y)= ("+x0+","+y0+")");
        System.out.println("Ending point: (x,y)= ("+x1+","+y1+")\n");
        
        // Calculate dx and dy 
        int dx = x1 - x0; 
        int dy = y1 - y0; 
        float slope = (float) dy / dx;
        
        // Take the initial points as x and y 
        float x = x0; 
        float y = y0; 

        int step; 

        // If dx > dy we will take step as dx 
        // else we will take step as dy to draw the complete line 
        if (Math.abs(dx) > Math.abs(dy)) 
            step = Math.abs(dx); 
        else
            step = Math.abs(dy); 

        for (int i = 0; i < step; i++) { 
            if (slope < 1) {
                x = x + 1;
                y = y + slope;
            } else if (slope > 1) {
                x = x + 1 / slope;
                y = y + 1;
            } else {
                x = x + 1;
                y = y + 1;
            }
            System.out.println("Iteration "+(i+1)+" (x,y)= ("+round(x)+","+round(y)+")");
        } 
    } 

    // Driver code 
    public static void main(String[] args) { 

        int x0 = 5, y0 = 6, x1 = 8, y1 = 12; 

        // Function call 
        DDALine(x0, y0, x1, y1); 

    } 
}