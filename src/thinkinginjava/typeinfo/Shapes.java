package thinkinginjava.typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
    void draw() {
        System.out.println(this.toString() + ".draw()"); // this will call toString() method implicitly
    }
    abstract public String toString(); //Override Object toString()
}

class Circle extends Shape {
    public String toString() { return "Circle"; } //Override Object toString()
}

class Square extends Shape {
    public String toString() { return "Square"; }
}

class Triangle extends Shape {
    public String toString() { return "Triangle"; }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for(Shape shape :  shapeList) {
            shape.draw();
        }

        //test 4: Circle up-cast to Shape And then down-cast to Triangle
        Shape shape = new Circle();
        // Un-comment below will throw ClassCastException: Circle cannot be cast to Triangle
        // Compiler also give warnings
        //((Triangle)shape).draw();
    }
}
