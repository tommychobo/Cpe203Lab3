import java.awt.Color;
import java.awt.Point;

public class Circle implements Shape{
    private double radius;
    private Point center;
    private Color color;

    public Circle(double radius, Point center, Color color){
        this.radius = radius;
        this.center = center;
        this.color = color;
    }

    public double getRadius(){
        return radius;
    }
    public void setRadius(double r) {
        radius = r;
    }
    public Point getCenter(){
        return center;
    }

    @Override
    public boolean equals(Object o){
        double delta = 0.000001;
        if(o instanceof Circle) {
            Circle c = (Circle)o;
            return c.center.equals(this.center) && Math.abs(c.radius - this.radius) < delta
                    && c.color.equals(this.color);
        }
        return false;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color c) {
        color = c;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public void translate(Point p) {
        center.setLocation(center.getX()+p.getX(), center.getY()+p.getY());
    }
}
