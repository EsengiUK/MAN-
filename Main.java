import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Arrays;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        double coordinates_vertex[][] = {
                {400, 200, 20},
                {300, 200, 20},
                {300, 100, 20},
                {400, 100, 20}
        };
        double turningAngle = 2;
        double rotation_vertex [][] = new double[4][3];
        JFrame jf = new JFrame("Square");
        Point p1 = new Point(coordinates_vertex[0][0], coordinates_vertex[0][1], coordinates_vertex[0][2]);
        Point p2 = new Point(coordinates_vertex[1][0], coordinates_vertex[1][1], coordinates_vertex[1][2]);
        Point p3 = new Point(coordinates_vertex[2][0], coordinates_vertex[2][1], coordinates_vertex[2][2]);
        Point p4 = new Point(coordinates_vertex[3][0], coordinates_vertex[3][1], coordinates_vertex[3][2]);
        Square s = new Square(p1, p2, p3, p4);
        for (int i = 0; i < coordinates_vertex.length ; i++) {
            for (int j = 0; j < coordinates_vertex[i].length; j++) {
                rotation_vertex[i][j] = (int) (coordinates_vertex[i][j] * turningAngle);
            }
        }
        System.out.println(Arrays.deepToString(coordinates_vertex));
        System.out.println(Arrays.deepToString(rotation_vertex));

        jf.add(s);
        jf.setSize(1000, 1000);
        //jf.setVisible(true);
    }
}

class Square extends JPanel {
    //нижня права
    private Point p12;
    //нижня ліва
    private Point p23;
    //верхня ліва
    private Point p34;
    //верхня права
    private Point p41;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Ellipse2D el1 = new Ellipse2D.Double(p12.x - (p12.radius / 2), p12.y - (p12.radius / 2), p12.radius, p12.radius);
        Ellipse2D el2 = new Ellipse2D.Double(p23.x - (p23.radius / 2), p23.y - (p23.radius / 2), p23.radius, p23.radius);
        Ellipse2D el3 = new Ellipse2D.Double(p34.x - (p34.radius / 2), p34.y - (p34.radius / 2), p34.radius, p34.radius);
        Ellipse2D el4 = new Ellipse2D.Double(p41.x - (p41.radius / 2), p41.y - (p41.radius / 2), p41.radius, p41.radius);

        g2.fill(el1);
        g2.fill(el2);
        g2.fill(el3);
        g2.fill(el4);

        Line2D l1 = new Line2D.Double(p12.x, p12.y, p23.x, p23.y);
        Line2D l2 = new Line2D.Double(p23.x, p23.y, p34.x, p34.y);
        Line2D l3 = new Line2D.Double(p34.x, p34.y, p41.x, p41.y);
        Line2D l4 = new Line2D.Double(p41.x, p41.y, p12.x, p12.y);

        g2.draw(l1);
        g2.draw(l2);
        g2.draw(l3);
        g2.draw(l4);
    }

    public Square(Point p1, Point p2, Point p3, Point p4) {
        this.p12 = p1;
        this.p23 = p2;
        this.p34 = p3;
        this.p41 = p4;
    }

    public Point getP12() {
        return p12;
    }

    public void setP12(Point p12) {
        this.p12 = p12;
    }

    public Point getP23() {
        return p23;
    }

    public void setP23(Point p23) {
        this.p23 = p23;
    }

    public Point getP34() {
        return p34;
    }

    public void setP34(Point p34) {
        this.p34 = p34;
    }

    public Point getP41() {
        return p41;
    }

    public void setP41(Point p41) {
        this.p41 = p41;
    }
}

class Point {
    double x;
    double y;
    double radius;

    public Point(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
