package odev;
import java.util.Scanner;


class GeometricObject {
    private String color;
    private boolean filled;

    public GeometricObject() {
        color = "white";
        filled = false;
    }

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Color: " + color + ", Filled: " + filled;
    }
}

public class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double s = getPerimeter() / 2;

        return Math.sqrt(
            s * (s - side1) * (s - side2) * (s - side3)
        );
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1
             + " side2 = " + side2
             + " side3 = " + side3;
    }
}

class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Birinci kenari girin: ");
        double side1 = input.nextDouble();

        System.out.print("Ikinci kenari girin: ");
        double side2 = input.nextDouble();

        System.out.print("Ucuncu kenari girin: ");
        double side3 = input.nextDouble();

        System.out.print("Ucgenin rengini girin: ");
        String color = input.next();

        System.out.print("Ucgen dolu mu? (true/false): ");
        boolean filled = input.nextBoolean();

        Triangle triangle = new Triangle(side1, side2, side3);

        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println("\n--- Ucgen Bilgileri ---");
        System.out.println(triangle);
        System.out.println("Alan: " + triangle.getArea());
        System.out.println("Cevre: " + triangle.getPerimeter());
        System.out.println("Renk: " + triangle.getColor());
        System.out.println("Dolu mu? " + triangle.isFilled());

        input.close();
    }
}