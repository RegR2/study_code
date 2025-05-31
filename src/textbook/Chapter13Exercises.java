package textbook;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.util.*;

public class Chapter13Exercises {
    public static void main(String[] args) throws CloneNotSupportedException {
//        testNewTriangle();
//        shuffleArrayList();
//        sortArrayList();
//        displayCalendar();
//        enableGeometricObjectComparable();
//        comparableCircle();
//        colourable();
//        myStack();
//        checkCircle();
//        checkRectangle();
//        checkOctagon();
//        sumAreas();
//        testCourse();
//        testRational();
//        calculator();
//        testComplexNumbers();
//        usingRationalClass();
//        convertDecimalsToFractions();
//        solveQuadraticEquation();
        vertexFormEquations();
    }

    //13.1
    private static void testNewTriangle() {
        NewTriangle triangle = new NewTriangle(4.0, 6.0, 5.0, "red", true);

        System.out.println("Area = " + triangle.getArea());
        System.out.println("Perimeter = " + triangle.getPerimeter());
        System.out.println("Description = " + triangle.toString());
    }

    //13.2
    private static void shuffleArrayList() {
        ArrayList<Number> list = new ArrayList<>();
        list.add(4.0);
        list.add(3);
        list.add(new BigInteger("7"));
        list.add(new BigDecimal("8"));

        System.out.println("Unshuffled list: " + list.toString());

        Collections.shuffle(list);

        System.out.println("Shuffled list: " + list.toString());
    }

    //13.3
    private static void sortArrayList() {
        ArrayList<Number> list = new ArrayList<>();
        list.add(4.0);
        list.add(3);
        list.add(new BigInteger("7"));
        list.add(new BigDecimal("8"));

        System.out.println("Unshuffled list: " + list.toString());

        list.sort(Comparator.comparingDouble(Number::doubleValue));

        System.out.println("Shuffled list: " + list.toString());
    }

    //13.4
    private static void displayCalendar() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter full year (e.g., 2001): ");
        int year = input.nextInt();

        System.out.print("Enter month in number between 1 and 12: ");
        int month = input.nextInt();

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        printMonth(calendar);
    }

    /**
     * Print the calendar for a month in a year
     */
    public static void printMonth(GregorianCalendar calendar) {
        // Print the headings of the calendar
        printMonthTitle(calendar);

        // Print the body of the calendar
        printMonthBody(calendar);
    }

    /**
     * Print the month title, e.g., May, 1999
     */
    public static void printMonthTitle(GregorianCalendar calendar) {
        System.out.println("         " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)
                + " " + calendar.get(Calendar.YEAR));
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /**
     * Print month body
     */
    public static void printMonthBody(GregorianCalendar calendar) {
        // Get start day of the week for the first date in the month
        int startDay = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);

        // Get number of days in the month
        int numberOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Pad space before the first day of the month
        int i = 0;
        for (i = 0; i < startDay; i++)
            System.out.print("    ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0)
                System.out.println();
        }

        System.out.println();
    }

    //13.5
    private static void enableGeometricObjectComparable() {
        //done in chapter 11
    }

    //13.6
    private static void comparableCircle() {
        ComparableCircle cirlce1 = new ComparableCircle(5);
        ComparableCircle circle2 = new ComparableCircle(10);

        System.out.println(cirlce1.compareTo(circle2));
    }

    //13.7
    private static void colourable() {
        GeometricObject square1 = new Square("red", true, 5);
        GeometricObject circle = new NewTriangle(2, 5, 7, "red", false);
        Square square3 = new Square("orange", true, 9);

        List<GeometricObject> objects = List.of(square1, circle, square3);

        for (GeometricObject object : objects) {
            System.out.println(object.toString());

            if (object instanceof Colorable) {
                ((Colorable) object).howToColor();
            }
        }
    }

    //13.8
    private static void myStack() throws CloneNotSupportedException {
        MyStack stack = new MyStack();
        stack.push("S1");
        stack.push("S2");
        stack.push("S");

        MyStack stack2 = (MyStack) (stack.clone());
        stack2.push("S1");
        stack2.push("S2");
        stack2.push("S");

        System.out.println(stack.getSize());
        System.out.println(stack2.getSize());
    }

    //13.9
    private static void checkCircle() {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(5);

        System.out.println(circle1.equals(circle2));
    }

    //13.10
    private static void checkRectangle() {
        Rectangle rec1 = new Rectangle(8, 10);
        Rectangle rec2 = new Rectangle(10, 5);

        System.out.println(rec1.equals(rec2));
        System.out.println(rec1.compareTo(rec2));
    }

    //13.11
    private static void checkOctagon() throws CloneNotSupportedException {
        Octagon octagon = new Octagon(5, "red", true);
        System.out.println("Original octagon Area = " + octagon.getArea() + ", Perimeter = " + octagon.getPerimeter());

        Octagon clone = (Octagon) octagon.clone();
        System.out.println("Clone compared to original = " + octagon.compareTo(clone));
        System.out.println("Clone octagon Area = " + clone.getArea() + ", Perimeter = " + clone.getPerimeter());
    }

    //13.12
    private static void sumAreas() {
        GeometricObject cicle1 = new Circle(5);
        GeometricObject circle2 = new Circle(10);
        GeometricObject rectangle1 = new Rectangle(5, 10);
        GeometricObject rectangle2 = new Rectangle(3, 8);

        GeometricObject[] array = new GeometricObject[]{cicle1, circle2, rectangle2, rectangle1};

        double sum = 0;

        for (GeometricObject obj : array) {
            sum += obj.getArea();
        }

        System.out.println(sum);
    }

    //13.13
    private static void testCourse() throws CloneNotSupportedException {
        Course course = new Course("Reggie Test Course");
        course.addStudent("Reggie");
        course.addStudent("Dasha");
        course.addStudent("Ben");
        course.addStudent("Vasilii");

        Course clonedCourse = (Course) course.clone();

        for (String student : clonedCourse.getStudents()) {
            System.out.println(course.getCourseName() + " " + student);
        }
    }

    //13.14 && 13.15
    private static void testRational() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first rational number: ");
        Rational r1 = new Rational(new BigInteger(input.next()), new BigInteger(input.next()));

        System.out.print("Enter the second rational number: ");
        Rational r2 = new Rational(new BigInteger(input.next()), new BigInteger(input.next()));

        System.out.println(r1.toString() + " + " + r2.toString() + " = " + r1.add(r2).toString());
        System.out.println(r1.toString() + " - " + r2.toString() + " = " + r1.subtract(r2).toString());
        System.out.println(r1.toString() + " * " + r2.toString() + " = " + r1.multiply(r2).toString());
        System.out.println(r1.toString() + " / " + r2.toString() + " = " + r1.divide(r2).toString());
        System.out.println(r2.toString() + " is " + r2.doubleValue());
    }

    //13.16
    private static void calculator() {
        System.out.println(calculator("3/4 + 1/5"));
        System.out.println(calculator("3/4 - 1/5"));
        System.out.println(calculator("3/4 * 1/5"));
        System.out.println(calculator("3/4 / 1/5"));
    }

    private static String calculator(String input) {
        String mathSymbol = "+";
        Rational r1;
        Rational r2;

        if (input.contains("+")) {
            String[] rationalStrings = input.split("\\+");

            String[] rat1Integers = rationalStrings[0].split("/");
            r1 = new Rational(new BigInteger(rat1Integers[0].replace(" ", "")), new BigInteger(rat1Integers[1].replace(" ", "")));

            String[] rat2Integers = rationalStrings[1].split("/");
            r2 = new Rational(new BigInteger(rat2Integers[0].replace(" ", "")), new BigInteger(rat2Integers[1].replace(" ", "")));
        } else if (input.contains("-")) {
            String[] rationalStrings = input.split("-");
            mathSymbol = "-";

            String[] rat1Integers = rationalStrings[0].split("/");
            r1 = new Rational(new BigInteger(rat1Integers[0].replace(" ", "")), new BigInteger(rat1Integers[1].replace(" ", "")));

            String[] rat2Integers = rationalStrings[1].split("/");
            r2 = new Rational(new BigInteger(rat2Integers[0].replace(" ", "")), new BigInteger(rat2Integers[1].replace(" ", "")));
        } else if (input.contains("*")) {
            String[] rationalStrings = input.split("\\*");
            mathSymbol = "*";

            String[] rat1Integers = rationalStrings[0].split("/");
            r1 = new Rational(new BigInteger(rat1Integers[0].replace(" ", "")), new BigInteger(rat1Integers[1].replace(" ", "")));

            String[] rat2Integers = rationalStrings[1].split("/");
            r2 = new Rational(new BigInteger(rat2Integers[0].replace(" ", "")), new BigInteger(rat2Integers[1].replace(" ", "")));
        } else {
            String[] rationalString = input.split("/");

            r1 = new Rational(new BigInteger(rationalString[0].replace(" ", "")), new BigInteger(rationalString[1].replace(" ", "")));
            r2 = new Rational(new BigInteger(rationalString[2].replace(" ", "")), new BigInteger(rationalString[3].replace(" ", "")));

            mathSymbol = "/";
        }

        Rational end;

        if (mathSymbol.equals("+")) {
            end = r1.add(r2);
        } else if (mathSymbol.equals("*")) {
            end = r1.multiply(r2);
        } else if (mathSymbol.equals("-")) {
            end = r1.subtract(r2);
        } else {
            end = r1.divide(r2);
        }

        return end.toString();
    }

//13.17
    private static void testComplexNumbers() throws CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        Complex c1 = new Complex(a, b);

        System.out.print("Enter the second complex number: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        Complex c2 = new Complex(c, d);

        System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = " + c1.add(c2));
        System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = " + c1.subtract(c2));
        System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = " + c1.multiply(c2));
        System.out.println("(" + c1 + ")" + " / " + "(" + c2 + ")" + " = " + c1.divide(c2));
        System.out.println("|" + c1 + "| = " + c1.abs());

        Complex c3 = (Complex)c1.clone();
        System.out.println(c1 == c3);
        System.out.println(c3.getRealPart());
        System.out.println(c3.getImaginaryPart());
        Complex c4 = new Complex(4, -0.5);
        Complex[] list = {c1, c2, c3, c4};
        java.util.Arrays.sort(list);
        System.out.println(java.util.Arrays.toString(list));
    }

    //13.18
    private static void usingRationalClass() {
        Rational r = new Rational(BigInteger.ONE, BigInteger.TWO);

        for (BigInteger i = BigInteger.TWO; i.compareTo(new BigInteger("99")) <= 0; i = i.add(BigInteger.ONE)) {
            Rational r2 = new Rational(i, i.add(BigInteger.ONE));

            r = r.add(r2);
        }

        System.out.println("Sum = " + r.doubleValue());
    }

    //13.19
    private static void convertDecimalsToFractions() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");

        String decimal = input.next();
        String[] parts = decimal.split("\\.");

        Rational r1 = new Rational(new BigInteger(parts[0]), BigInteger.ONE);
        Rational r2 = new Rational(new BigInteger(parts[1]), new BigInteger("100"));

        System.out.println("The fraction number is: " + r1.add(r2).toString());
    }

    //13.20
    private static void solveQuadraticEquation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double x = b * b - (4 * a * c);

        if (x > 0) {
            double r1 = (-b + Math.pow(x, 0.5)) / (2 * a);
            double r2 = (-b - Math.pow(x, 0.5)) / (2 * a);

            System.out.println("The equation has two roots " + r1 + " and " + r2);
        } else if (x == 0) {
            double r1 = (-b + Math.pow(x, 0.5)) / (2 * a);
            System.out.println("The equation has one root " + r1);
        } else {
            Complex c1 = new Complex(-b / (2 * a), Math.sqrt(-x) / (2 * a));
            Complex c2 = new Complex(-b / (2 * a), -Math.sqrt(-x) / (2 * a));
            System.out.println("The imaginary square roots are " + c1 + " and " + c2);
        }
    }

    //13.21
    private static void vertexFormEquations() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");

        BigInteger a = input.nextBigInteger();
        BigInteger b = input.nextBigInteger();
        BigInteger c = input.nextBigInteger();

        Rational h = new Rational(b.multiply(new BigInteger("-1")), BigInteger.TWO.multiply(a));

        BigInteger kNumerator = new BigInteger("4").multiply(a).multiply(c).subtract(b.multiply(b));
        Rational k = new Rational(kNumerator, new BigInteger("4").multiply(a));

        System.out.println("h is " + h + " k is " + k);
    }
}

class Square extends GeometricObject implements Colorable {
    int side;

    public Square() {
        super();
        this.side = 0;
    }

    public Square(String color, boolean filled, int side) {
        super(color, filled);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public double getPerimeter() {
        return this.side * 4;
    }

    @Override
    public int compareTo(GeometricObject o) {
        return Double.compare(this.getArea(), ((Square) o).getArea());
    }
}

interface Colorable {
    void howToColor();
}

class ComparableCircle extends SimpleCircle implements Comparable<ComparableCircle> {

    public ComparableCircle(double newRadius) {
        super(newRadius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        ComparableCircle circle = (ComparableCircle) o;

        return Double.compare(this.getArea(), circle.getArea());
    }
}

class NewTriangle extends GeometricObject {
    private double side1, side2, side3 = 1.0;

    public NewTriangle() {
    }

    public NewTriangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double s = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public int compareTo(GeometricObject o) {
        return Double.compare(this.getArea(), ((NewTriangle) o).getArea());
    }

    @Override
    public String toString() {
        return "Triangle: " +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                " created on " + getDateCreated() + "\ncolor: " + getColor() +
                " and filled: " + isFilled() +
                ".";
    }
}

class MyStack implements Cloneable {
    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyStack stack = (MyStack) super.clone();
        stack.list = (ArrayList<Object>) this.list.clone();

        return stack;
    }

    @Override
    /** Override the toString in the Object class */
    public String toString() {
        return "stack: " + list.toString();
    }
}

class Circle extends GeometricObject {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set a new radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    /** Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Return diameter
     */
    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    /** Return perimeter */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /* Print the circle info */
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }

    @Override
    public int compareTo(GeometricObject o) {
        return Double.compare(this.getArea(), ((Circle) o).getArea());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            return this.getRadius() == ((Circle) obj).getRadius();
        }
        return false;
    }
}

class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set a new width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set a new height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    /** Return area */
    public double getArea() {
        return width * height;
    }

    @Override
    /** Return perimeter */
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public int compareTo(GeometricObject o) {
        return Double.compare(this.getArea(), ((Rectangle) o).getArea());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            return this.getArea() == ((Rectangle) obj).getArea();
        }

        return false;
    }
}

class Octagon extends GeometricObject implements Cloneable {
    private double side;

    public Octagon() {
        super("transparent", false);
        this.side = 0;
    }

    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * this.side * this.side;
    }

    @Override
    public double getPerimeter() {
        return this.side * 8;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Octagon) super.clone();
    }

    @Override
    public int compareTo(GeometricObject o) {
        return Double.compare(this.getArea(), ((Octagon) o).getArea());
    }
}

class Course implements Cloneable {
    private String courseName;
    private String[] students = new String[4];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        // Left as an exercise in Exercise 10.9
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Course clone = (Course) super.clone();
        clone.students = (String[]) this.students.clone();

        return clone;
    }
}

class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger[] r = new BigInteger[2];

    /**
     * Construct a rational with default properties
     */
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /**
     * Construct a rational with specified numerator and denominator
     */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        r[0] = (denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : BigInteger.valueOf(-1)).multiply(numerator.divide(gcd));
        r[1] = (denominator.compareTo(BigInteger.ZERO) < 0 ? denominator.multiply(BigInteger.valueOf(-1)) : denominator).divide(gcd);
    }

    /**
     * Find GCD of two numbers
     */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.compareTo(BigInteger.ZERO) < 0 ? n.multiply(BigInteger.valueOf(-1)) : n;
        BigInteger n2 = d.compareTo(BigInteger.ZERO) < 0 ? d.multiply(BigInteger.valueOf(-1)) : d;
        BigInteger gcd = BigInteger.ONE;

        for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) {
            if (n1.mod(k).compareTo(BigInteger.ZERO) == 0 && n2.mod(k).compareTo(BigInteger.ZERO) == 0)
                gcd = k;
        }

        return gcd;
    }

    /**
     * Return numerator
     */
    public BigInteger getNumerator() {
        return r[0];
    }

    /**
     * Return denominator
     */
    public BigInteger getDenominator() {
        return r[1];
    }

    /**
     * Add a rational number to this rational
     */
    public Rational add(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getDenominator()).add(r[1].multiply(secondRational.getNumerator()));
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public Rational subtract(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getDenominator()).subtract(r[1].multiply(secondRational.getNumerator()));
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number to this rational
     */
    public Rational multiply(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getNumerator());
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Divide a rational number from this rational
     */
    public Rational divide(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getDenominator());
        BigInteger d = r[1].multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override // Override toString()
    public String toString() {
        if (r[1].equals(BigInteger.ONE))
            return r[0] + "";
        else
            return r[0] + "/" + r[1];
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((Rational) (other))).getNumerator().equals(BigInteger.ZERO))
            return true;
        else
            return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return r[0].doubleValue() / r[1].doubleValue();
    }

    @Override // Implement the abstract BigIntegerValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
            return 1;
        else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0)
            return -1;
        else
            return 0;
    }
}

class Complex implements Cloneable, Comparable<Complex> {
    private double a;
    private double b;


    public Complex() {
        this.a = 0;
        this.b = 0;
    }

    public Complex(double a) {
        this.a = a;
        this.b = 0;
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String add(Complex o) {
        return (this.getA() + o.getA()) + " + " + (this.getB() + o.getB()) + "i";
    }

    public String subtract(Complex o) {
        return (this.getA() - o.getA()) + " + " + (this.getB() - o.getB()) + "i";
    }

    public String multiply(Complex o) {
        return (this.getA() * o.getA() - this.getB() * o.getB()) + " - " + (this.getB() * o.getA() + this.getA() * o.getB())  + "i";
    }

    public String divide(Complex o) {
        double real = this.getA() * o.getA() + this.getB() * o.getB();
        double imaginary = this.getB() * o.getA() - this.getA() * o.getB();
        double denominator = Math.pow(o.getA(), 2) + Math.pow(o.getB(), 2);
        return (real/denominator) + " + " + (imaginary/denominator) + "i";
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.getA(), 2) + Math.pow(this.getB(), 2));
    }

    public double getRealPart() {
        return this.getA();
    }

    public double getImaginaryPart() {
        return this.getB();
    }

    @Override
    public int compareTo(Complex o) {
        return Double.compare(this.abs(), o.abs());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Complex) super.clone();
    }

    @Override
    public String toString() {
        return this.getB() == 0 ? "" + this.getA() : this.getA() == 0 ? "" + 0 : this.getA() + " + " + this.getB() + "i";
    }
}