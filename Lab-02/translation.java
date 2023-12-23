import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.awt.RenderingHints;

public class translation extends JFrame {
    private static final long serialVersionUID = 1L;

    int x1, y1, x2, y2, x3, y3;

    public translation() {
        setTitle("Triangle Translation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        // Taking input for triangle coordinates
        String input1 = JOptionPane.showInputDialog("Enter x1 y1 coordinates (separated by space): ");
        String[] coords1 = input1.split(" ");
        x1 = Integer.parseInt(coords1[0]);
        y1 = Integer.parseInt(coords1[1]);

        String input2 = JOptionPane.showInputDialog("Enter x2 y2 coordinates (separated by space): ");
        String[] coords2 = input2.split(" ");
        x2 = Integer.parseInt(coords2[0]);
        y2 = Integer.parseInt(coords2[1]);

        String input3 = JOptionPane.showInputDialog("Enter x3 y3 coordinates (separated by space): ");
        String[] coords3 = input3.split(" ");
        x3 = Integer.parseInt(coords3[0]);
        y3 = Integer.parseInt(coords3[1]);

        // Taking input for translation distances
        int tx = Integer.parseInt(JOptionPane.showInputDialog("Enter translation in x direction: "));
        int ty = Integer.parseInt(JOptionPane.showInputDialog("Enter translation in y direction: "));

        // Applying translation to triangle vertices using AffineTransform
        AffineTransform transform = AffineTransform.getTranslateInstance(tx, ty);
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);
        transform.transform(p1, p1);
        transform.transform(p2, p2);
        transform.transform(p3, p3);

        // Creating a JPanel for drawing
        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Enable anti-aliasing
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                drawTriangle(g, x1, y1, x2, y2, x3, y3, Color.BLACK);
                drawTriangle(g, (int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY(),
                        (int) p3.getX(), (int) p3.getY(), Color.BLUE);
            }
        };

        getContentPane().add(panel);

        // Display the frame
        setVisible(true);
    }

    private void drawTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        g.setColor(color);
        int[] xPoints = { x1, x2, x3 };
        int[] yPoints = { y1, y2, y3 };
        int nPoints = 3;

        g.drawPolygon(new Polygon(xPoints, yPoints, nPoints));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new translation();
        });
    }
}