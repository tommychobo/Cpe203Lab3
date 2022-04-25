import java.awt.Color;
import java.awt.Point;

public class Rectangle implements Shape{
    private double width;
    private double height;
    private Point topLeft;
    private Color color;

    public Rectangle(double width, double height, Point topLeft, Color color){
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
        this.color = color;
    }

    public double getWidth(){
        return width;
    }
    public void setWidth(double w){
        width = w;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double h){
        height = h;
    }
    public Point getTopLeft(){
        return topLeft;
    }

    @Override
    public boolean equals(Object o){
        double delta = 0.000001;
        if(o instanceof Rectangle){
            Rectangle r = (Rectangle)o;
            return Math.abs(r.width - this.width) < delta &&
                    Math.abs(r.height - this.height) < delta &&
                    r.topLeft.equals(this.topLeft) &&
                    r.color.equals(this.color);
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
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*width + 2*height;
    }

    @Override
    public void translate(Point p) {
        topLeft.setLocation(topLeft.getX()+p.getX(), topLeft.getY()+p.getY());
    }
}
