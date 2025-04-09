package textbook;

import java.util.*;

public class Chapter9Exercises {
    public static void main(String[] args) {
//        getRectangleDetails();
//        getStockDetails();
//        getDates();
//        getRandom();
//        gregorianCalendar();
//        getStopwatch();
//        getAccountDetails();
//        getFanDetails();
//        getRegularPolygon();
//        solveQuadraticEquation();
//        solveLinearEquations();
//        solveIntersectingPoints();
        getLocationOfLargest();
    }

    //9.1
    private static void getRectangleDetails() {
        Rectangle r1 = new Rectangle(4.0, 40.0);
        Rectangle r2 = new Rectangle(3.5, 35.9);

        System.out.println(r1.toString());
        System.out.println(r2.toString());

        System.out.println("area of r1=" + r1.getArea());
        System.out.println("perimeter of r1=" + r1.getPerimeter());

        System.out.println("area of r2=" + r2.getArea());
        System.out.println("perimeter of r2=" + r2.getPerimeter());

    }

    //9.2
    private static void getStockDetails() {
        Stock orcl = new Stock("ORCL", "Oracle Corporation");
        orcl.setPreviousClosingPrice(34.5);
        orcl.setCurrentPrice(34.35);

        System.out.println("Percentage change = " + orcl.getChangePercentage());
    }

    //9.3
    private static void getDates() {
        Date d1 = new Date(10000);
        Date d2 = new Date(100000);
        Date d3 = new Date(1000000);
        Date d4 = new Date(10000000);
        Date d5 = new Date(100000000);
        Date d6 = new Date(1000000000);
        Date d7 = new Date(10000000000L);
        Date d8 = new Date(100000000000L);

        List<Date> dates = List.of(d1, d2, d3, d4, d5, d6, d7, d8);

        for (Date date : dates) {
            System.out.println(date.toString());
        }
    }

    //9.4
    private static void getRandom() {
        Random r = new Random(1000);
        for (int i = 0; i <= 50; i++) {
            System.out.print(r.nextInt(100) + " ");
        }
    }

    //9.5
    private static void gregorianCalendar() {
        GregorianCalendar c = new GregorianCalendar();
        System.out.println("Current Date: " + c.get(GregorianCalendar.DAY_OF_MONTH) + "/" + c.get(GregorianCalendar.MONTH) + "/" + c.get(GregorianCalendar.YEAR));

        c.setTimeInMillis(1234567898765L);
        System.out.println("Updated Date: " + c.get(GregorianCalendar.DAY_OF_MONTH) + "/" + c.get(GregorianCalendar.MONTH) + "/" + c.get(GregorianCalendar.YEAR));
    }

    //9.6
    private static void getStopwatch() {
        Stopwatch stopwatch = new Stopwatch();

        int[] nums = new int[100000];

        for (int i = 0; i < 100000; i++) {
            nums[i] = (int) (Math.random() * 100000) + 1;
        }

        stopwatch.start();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        stopwatch.stop();

        System.out.println("Elapsed time for sort: " + stopwatch.getElapsedTime());
    }

    //9.7
    private static void getAccountDetails() {
        Account a = new Account(1122, 20000, 4.5);
        a.withdraw(2500);
        a.deposit(3000);

        System.out.println("Balance= " + a.getBalance() + ", Monthly interest= " + a.getMonthlyInterest() + ", Date created = " + a.getDateCreated());
    }

    //9.8
    private static void getFanDetails() {
        Fan f1 = new Fan();
        f1.setSpeed(Fan.FAST);
        f1.setRadius(10);
        f1.setColor("yellow");
        f1.setOn(true);

        System.out.println(f1.toString());

        Fan f2 = new Fan();
        f1.setSpeed(Fan.MEDIUM);
        f1.setRadius(5);
        f1.setOn(false);

        System.out.println(f2.toString());
    }

    //9.9
    private static void getRegularPolygon() {
        RegularPolygon r1 = new RegularPolygon();
        RegularPolygon r2 = new RegularPolygon(6, 4);
        RegularPolygon r3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("R1 perimeter = " + r1.getPerimeter() + ", R1 area = " + r1.getArea());
        System.out.println("R2 perimeter = " + r2.getPerimeter() + ", R2 area = " + r2.getArea());
        System.out.println("R3 perimeter = " + r3.getPerimeter() + ", R3 area = " + r3.getArea());
    }

    //9.10
    private static void solveQuadraticEquation() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter values for a, b and c:" );
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        QuadraticEquation q = new QuadraticEquation(a, b, c);

        double desc = q.getDescriminant();

        if (desc == 0 ) {
            System.out.println("The root is " + q.getRoot1());
        } else if (desc > 0) {
            System.out.println("The roots are " + q.getRoot1() + "& " + q.getRoot2());
        } else {
            System.out.println("There are no roots");
        }

    }

    //9.11
    private static void solveLinearEquations() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter values for a, b, c, d, e and f:" );
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();

        LinearEquation l = new LinearEquation(a, b, c, d, e, f);

        if (l.isSolvable()) {
            System.out.println("X = " + l.getX() + ", Y = " + l.getY());
        } else {
            System.out.println("The equation has no solution");
        }
    }

    //9.12
    private static void solveIntersectingPoints() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");

        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();

        double a = (y1 - y2);
        double b = (-x1 + x2);
        double c = (y3 - y4);
        double d = (-x3 + x4);
        double e = -y1 * (x1 - x2) + (y1 - y2) * x1;
        double f = -y3 * (x3 - x4) + (y3 - y4) * x3;

        LinearEquation l = new LinearEquation(a, b, c, d, e, f);

        if (!l.isSolvable()) {
            System.out.println("The two lines are parallel");
        } else {
            System.out.println("The intersecting point is at (" + l.getX() + ", " + l.getY() + ")");
        }

    }

    //9.13
    private static void getLocationOfLargest() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the array: ");

        double[][] a = new double[3][4];

        for (int i=0; i< a.length; i++) {
            for (int j=0; j< a[i].length; j++) {
                a[i][j] = input.nextDouble();
            }
        }

        System.out.println(locateLargest(a).toString());
    }

    public static Location locateLargest(double[][] a) {
        double largest = a[0][0];
        int row = 0;
        int column = 0;

        for (int i=0; i< a.length; i++) {
            for (int j=0; j< a.length; j++) {
                if (largest < a[i][j]) {
                    largest = a[i][j];
                    row = i;
                    column = j;
                }
            }
        }

        return new Location(row, column, largest);
    }
}


class Rectangle {
    double width;
    double height;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return 2 * (this.height + this.width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getChangePercentage() {
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }
}

class Stopwatch {
    private long startTime;
    private long endTime;

    public Stopwatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }
}

class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.id++;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 1200;
    }

    public double getMonthlyInterest() {
        return this.balance * (annualInterestRate / 1200);
    }

    public void withdraw(double amount) {
        this.balance = this.balance - amount;
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                ", dateCreated=" + dateCreated +
                '}';
    }
}

class Fan {
    static final int SLOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    String color = "blue";

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.on) {
            return "Fan{" +
                    "speed=" + speed +
                    ", on=" + on +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            return "Fan{" +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    ", fan is off" + '\'' +
                    '}';
        }
    }
}

class RegularPolygon {
    private int n;
    private double side;
    private double x;
    private double y;

    public RegularPolygon() {
        this.n = 3;
        this.side =1;
        this.x = 0;
        this.y = 0;
    }

    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
        this.x = 0;
        this.y = 0;
    }

    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return this.n * this.side;
    }

    public double getArea() {
        return (this.n * this.side * this.side) / (4 * Math.tan(Math.PI / this.n));
    }
}

class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDescriminant() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }

    public double getRoot1() {
        return this.getDescriminant() >= 0 ?  (-this.b + Math.sqrt(this.getDescriminant())) / (2 * this.a) : 0;
    }

    public double getRoot2() {
        return this.getDescriminant() > 0 ? (-this.b - Math.sqrt(this.getDescriminant())) / (2 * this.a) : 0;
    }
}

class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public boolean isSolvable() {
        return (this.a * this.d - this.b * this.c) != 0;
    }

    public double getX() {
        return (this.e * this.d - this.b * this.f) / (this.a * this.d - this.b * this.c);
    }

    public double getY() {
        return (this.a * this.f - this.e * this.c) / (this.a * this.d - this.b * this.c);
    }
}

class Location {
    public int row;
    public int column;
    public double maxValue;

    public Location(int row, int column, double maxValue) {
        this.row = row;
        this.column = column;
        this.maxValue = maxValue;
    }

    public String toString() {
        return "the location of the largest element is " + this.maxValue + " at (" + this.row + ", " + this.column + ")";
    }
}


