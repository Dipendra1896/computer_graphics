import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MovingCar extends JFrame {

    private int carX = 0;

    /**
     * Constructor method that sets up the car window and starts a timer for the animation.
     */
    public MovingCar() {
        setTitle("Moving Car");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(8, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCar();
                repaint();
            }
        });
        timer.start();
    }

    /**
     * Method that updates the car's position by incrementing the `carX` variable and wrapping it around if it reaches the edge.
     */
    private void moveCar() {
        carX += 1;
        if (carX > getWidth()) {
            carX = -50;
        }
    }

    /**
     * Method that is called to paint the car on the window. It calls the `drawCar(Graphics g)` method to draw the car components.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCar(g);
    }

    /**
     * Method that draws the car components (body, roof, wheels) on the window.
     */
    private void drawCar(Graphics g) {
        g.setColor(Color.BLUE);

        // Car body
        g.fillRect(carX, 150, 90, 20);

        // Roof
        g.setColor(Color.YELLOW);
        int[] roofX = {carX + 10, carX + 30, carX + 60, carX + 80};
        int[] roofY = {150, 130, 130, 150};
        g.fillPolygon(roofX, roofY, 4);

        // Left wheel
        g.setColor(Color.BLACK);
        g.fillOval(carX + 10, 165, 25, 25);

        // Right wheel
        g.fillOval(carX + 50, 165, 25, 25);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MovingCar().setVisible(true);
            }
        });
    }
}