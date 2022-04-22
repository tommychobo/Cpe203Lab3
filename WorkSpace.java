import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class WorkSpace {
    private List<Shape> shapes;
    public WorkSpace(){
        shapes = new ArrayList<>();
    }
    public void add(Shape shape){
        shapes.add(shape);
    }
    public Shape get(int index){
        return shapes.get(index);
    }
    public int size(){
        return shapes.size();
    }

    public List<Circle> getCircles(){
        List<Circle> circles = new ArrayList<>();
        for(Shape s : shapes){
            if(s instanceof Circle c){
                circles.add(c);
            }
        }
        return circles;
    }

    public List<Rectangle> getRectangles(){
        List<Rectangle> rectangles = new ArrayList<>();
        for(Shape s : shapes){
            if(s instanceof Rectangle r){
                rectangles.add(r);
            }
        }
        return rectangles;
    }

    public List<Triangle> getTriangles(){
        List<Triangle> triangles = new ArrayList<>();
        for(Shape s : shapes){
            if(s instanceof Triangle t){
                triangles.add(t);
            }
        }
        return triangles;
    }

    public List<Shape> getShapesByColor(Color color){
        List<Shape> colorShapes = new ArrayList<>();
        for(Shape s : shapes){
            if(s.getColor().equals(color)){
                colorShapes.add(s);
            }
        }
        return colorShapes;
    }

    public double getAreaOfAllShapes(){
        double total = 0.0;
        for(Shape s : shapes){
            total += s.getArea();
        }
        return total;
    }

    public double getPerimeterOfAllShapes(){
        double total = 0.0;
        for(Shape s : shapes){
            total += s.getPerimeter();
        }
        return total;
    }
}
