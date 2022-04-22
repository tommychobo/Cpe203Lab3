import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.awt.Color;
import java.awt.Point;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class TestCases
{
   public static final double DELTA = 0.00001;

   /* some sample tests but you must write more! see lab write up */

   @Test
   public void testCircleGetArea()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(101.2839543, c.getArea(), DELTA);
   }

   @Test
   public void testCircleGetPerimeter()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(35.6759261, c.getPerimeter(), DELTA);
   }

   @Test
   public void testWorkSpaceAreaOfAllShapes()
   {
      WorkSpace ws = new WorkSpace();

      ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Circle(5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), 
                 Color.BLACK));

      assertEquals(114.2906063, ws.getAreaOfAllShapes(), DELTA);
   }

   @Test
   public void testWorkSpaceGetCircles()
   {
      WorkSpace ws = new WorkSpace();
      List<Circle> expected = new LinkedList<>();

      // Have to make sure the same objects go into the WorkSpace as
      // into the expected List since we haven't overriden equals in Circle.
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Circle c2 = new Circle(1.11, new Point(-5, -3), Color.RED);

      ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
      ws.add(c1);
      ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
                 Color.BLACK));
      ws.add(c2);

      expected.add(c1);
      expected.add(c2);

      // Doesn't matter if the "type" of lists are different (e.g Linked vs
      // Array).  List equals only looks at the objects in the List.
      assertEquals(expected, ws.getCircles());
   }

   /* HINT - comment out implementation tests for the classes that you have not 
    * yet implemented */
   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getRadius", "setRadius", "getCenter", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         double.class, void.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[] {double.class}, new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getWidth", "setWidth", "getHeight", "setHeight", "getTopLeft", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         double.class, void.class, double.class, void.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[] {double.class}, new Class[0], new Class[] {double.class}, 
         new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testTriangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getVertexA", "getVertexB", "getVertexC", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         Point.class, Point.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[0], new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Triangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }


   @Test
   public void testColorList(){
      Point p = new Point(0, 0);
      Point q = new Point(1, 1);
      Point r = new Point(0, 1);
      WorkSpace ws = new WorkSpace();
      ws.add(new Circle(5, p, Color.BLACK));
      ws.add(new Triangle(p, q, r, Color.BLACK));
      ws.add(new Circle(5, p, Color.PINK));
      ws.add(new Circle(5, p, Color.BLUE));
      ws.add(new Rectangle(1, 1, p, Color.PINK));
      List<Shape> black = ws.getShapesByColor(Color.BLACK);
      assertTrue(black.get(0).equals(new Circle(5, p, Color.BLACK)));
      assertTrue(black.get(1).equals(new Triangle(p, q, r, Color.BLACK)));
      List<Shape> pink = ws.getShapesByColor(Color.PINK);
      assertTrue(pink.get(0).equals(new Circle(5, p, Color.PINK)));
      assertTrue(pink.get(1).equals(new Rectangle(1, 1, p, Color.PINK)));

   }

   @Test
   public void testPerimeterAdd(){
      Point p = new Point(0, 0);
      Point q = new Point(1, 1);
      Point r = new Point(0, 1);
      WorkSpace ws = new WorkSpace();
      ws.add(new Circle(5, p, Color.BLACK));
      ws.add(new Triangle(p, q, r, Color.BLACK));
      ws.add(new Circle(5, p, Color.PINK));
      ws.add(new Circle(5, p, Color.BLUE));
      ws.add(new Rectangle(1, 1, p, Color.PINK));
      assertEquals(ws.getPerimeterOfAllShapes(), 101.661993, DELTA);
   }

   @Test
   public void testAreaAdd(){
      Point p = new Point(0, 0);
      Point q = new Point(1, 1);
      Point r = new Point(0, 1);
      WorkSpace ws = new WorkSpace();
      ws.add(new Circle(5, p, Color.BLACK));
      ws.add(new Triangle(p, q, r, Color.BLACK));
      ws.add(new Circle(5, p, Color.PINK));
      ws.add(new Circle(5, p, Color.BLUE));
      ws.add(new Rectangle(1, 1, p, Color.PINK));
      assertEquals(ws.getAreaOfAllShapes(), 237.1194490, DELTA);
   }

   @Test
   public void testGetSpecificShape(){
      Point p = new Point(0, 0);
      Point q = new Point(1, 1);
      Point r = new Point(0, 1);
      WorkSpace ws = new WorkSpace();
      ws.add(new Circle(5, p, Color.BLACK));
      ws.add(new Triangle(p, q, r, Color.BLACK));
      ws.add(new Circle(5, p, Color.PINK));
      ws.add(new Circle(5, p, Color.BLUE));
      ws.add(new Rectangle(1, 1, p, Color.PINK));
      assertEquals(ws.getRectangles().get(0), new Rectangle(1, 1, p, Color.PINK));
      assertEquals(ws.getTriangles().get(0), new Triangle(p, q, r, Color.BLACK));
      assertEquals(ws.getCircles().get(2), new Circle(5, p, Color.BLUE));
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, clazz.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}
