import java.awt.Color;
import java.awt.Point;

public class Triangle implements Shape{
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    private Color color;

    public Triangle(Point a, Point b, Point c, Color color){
        vertexA = a;
        vertexB = b;
        vertexC = c;
        this.color = color;
    }

    public Point getVertexA() {
        return vertexA;
    }

    public Point getVertexB() {
        return vertexB;
    }

    public Point getVertexC() {
        return vertexC;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Triangle){
            Triangle t = (Triangle)o;
            return t.vertexA.equals(this.vertexA) &&
                    t.vertexB.equals(this.vertexB) &&
                    t.vertexC.equals(this.vertexC);
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
        double s = getPerimeter()/2.0;
        double a = vertexA.distance(vertexB);
        double b = vertexB.distance(vertexC);
        double c = vertexC.distance(vertexA);
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public double getPerimeter() {
        return vertexA.distance(vertexB)+vertexB.distance(vertexC)+vertexC.distance(vertexA);
    }

    @Override
    public void translate(Point p) {
        vertexA.setLocation(vertexA.getX()+p.getX(), vertexA.getY()+p.getY());
        vertexB.setLocation(vertexB.getX()+p.getX(), vertexB.getY()+p.getY());
        vertexC.setLocation(vertexC.getX()+p.getX(), vertexC.getY()+p.getY());
    }
}
