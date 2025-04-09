package textbook;

import java.lang.reflect.Array;
import java.util.*;

public class Chapter11Exercises {
    public static void main(String[] args) {
//        testTriangle();
//        testSchool();
//        testAccounts();
//        maximumElement();
//        useArrayList();.
//        shuffleIntegers();
//        testAccounts();
//        testAccount();
//        largestRowsAndColumns();
//        myStack();
//        sortArrayList();
//        sumAllNumbersInArrayList();
//        removeDuplicates();
//        combineTwoLists();
//        areaOfConvexPolygon();
//        repeatAdditionQuiz();
//        perfectSquare();
//        toCharacterArray();
        binPacking();
    }

    //11.1
    private static void testTriangle() {
        Triangle triangle = new Triangle(4.0, 6.0, 5.0);

        System.out.println("Area = " + triangle.getArea());
        System.out.println("Perimeter = " + triangle.getPerimeter());
        System.out.println("Description = " + triangle.toString());
    }

    //11.2
    private static void testSchool() {
        Person person = new Person("name1", "address1, stree1, blah blah", "123456789", "testemail.com");
        System.out.println(person.toString());

        Student student = new Student("studentName", "studentAddress", "123456789", "studentEmail.com", Student.SOPHMORE);
        System.out.println(student.toString());

        Employee employee = new Employee("employeeName", "employeeAddress", "123456789",
                "employeeEmail.com", "employeeOffice", 123.45);
        System.out.println(employee.toString());

        Faculty faculty = new Faculty("facultyName", "facultyAddress", "123456789",
                "facultyEmail.com", "facultyOffice", 65.32, "9-5", "facultyRank");
        System.out.println(faculty.toString());

        Staff staff = new Staff("staffName", "staffAddress", "123456789",
                "staffEmail.com", "staffOffice", 65.32, "staffTitle");
        System.out.println(staff.toString());
    }

    //11.3
    private static void testAccounts() {
        Account account = new Account(112245, 123456.52, 10);
        CheckingAccount checking = new CheckingAccount(112, 1234.52, 10, 400);
        SavingsAccount savingsAccount = new SavingsAccount(213456, 124.52, 10);

        System.out.println("Checking Balance before= " + checking.getBalance());
        checking.withdraw(50);
        System.out.println("Checking Balance after= " + checking.getBalance());

        System.out.println("Savings Balance before= " + savingsAccount.getBalance());
        savingsAccount.withdraw(100);
        System.out.println("Savings Balance after= " + savingsAccount.getBalance());
    }

    //11.4
    private static void maximumElement() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an array of integers. End the list of 0 when you have finished entering the numbers: ");

        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            int num = input.nextInt();

            if (num == 0) {
                break;
            }

            list.add(num);
        }

        if (list == null || list.isEmpty()) {
            System.out.println("You have not entered any numbers!");
        } else {
            System.out.println("Max number is " + Collections.max(list));
        }
    }

    //11.6
    private static void useArrayList() {
        ArrayList<Object> list = new ArrayList<>();

        Loan loan = new Loan(10, 5, 500.0);
        SimpleCircle circle = new SimpleCircle(5);
        Date date = new Date();

        list.add(loan);
        list.add(circle);
        list.add(date);

        for (Object object : list) {
            System.out.println(object.toString());
        }
    }

    //11.7
    private static void shuffleIntegers() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        System.out.println(list.toString());
    }

    //11.8
    private static void testAccount() {
        NewAccount account = new NewAccount(1122, 1000, 1.5, "George");

        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);

        System.out.println(account.toString());
    }

    //11.9
    private static void largestRowsAndColumns() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the array size n: ");
        int size = input.nextInt();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int number = (int) (Math.random() * 2);
                matrix[i][j] = number;
            }
        }

        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();

        int numRow = 0;
        int numCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            int num = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    num++;
                }
            }

            if (num > numRow) {
                rows.clear();
                rows.add(i);
                numRow = num;
            } else if (num == numRow) {
                rows.add(i);
            }
        }

        for (int col = 0; col < matrix[0].length; col++) {
            int num = 0;

            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] == 1) {
                    num++;
                }
            }

            if (num > numCol) {
                columns.clear();
                columns.add(col);
                numCol = num;
            } else if (num == numCol) {
                columns.add(col);
            }
        }

        System.out.print("The largest row indexes: ");
        for (Integer row : rows) {
            System.out.print(row + " ");
        }

        System.out.println();

        System.out.print("The largest column indexes: ");
        for (Integer col : columns) {
            System.out.print(col + " ");
        }
    }

    //11.10
    private static void myStack() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 strings: ");

        MyStack stack = new MyStack();

        for (int i = 0; i < 5; i++) {
            stack.push(input.nextLine());
        }

        System.out.println(stack.getSize() + " strings are: ");
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

    //11.11
    private static void sortArrayList() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(input.nextInt());
        }

        Collections.sort(list);
        System.out.println(list.toString());
    }

    //11.12
    private static void sumAllNumbersInArrayList() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");

        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(input.nextDouble());
        }

        double sum = 0;
        for (Double number : list) {
            sum += number;
        }

        System.out.println(sum);
    }

    //11.13
    private static void removeDuplicates() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 10 integers: ");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(input.nextInt());
        }

        for (int i=0; i< list.size(); i++) {
            for (int j=i+1; j< list.size(); j++) {
                if (Objects.equals(list.get(i), list.get(j))) {
                    list.remove(j);
                }
            }
        }
        System.out.println(list.toString());
    }

    //11.14
    private static void combineTwoLists() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 integers for list 1: ");
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(input.nextInt());
        }

        System.out.println("Enter 5 integers for list 2: ");
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list2.add(input.nextInt());
        }

        list1.addAll(list2);
        System.out.println(list1.toString());
    }

    //11.15
    private static void areaOfConvexPolygon() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        int size = input.nextInt();

        System.out.println("Enter the coordinates of the points: ");
        ArrayList<ArrayList<Double>> points = new ArrayList<>();

        int num = 0;
        while (num < size) {
            ArrayList<Double> point = new ArrayList<>();
            point.add(input.nextDouble());
            point.add(input.nextDouble());
            points.add(point);
            num++;
        }

        double sum = 0;
        double sum2 = 0;

        for (int i=0; i<points.size(); i++) {
            ArrayList<Double> pointsA = points.get(i);

            ArrayList<Double> pointsB;
            if (i == points.size() -1) {
                pointsB = points.get(0);
            } else {
                pointsB = points.get(i +1);
            }


            sum += (pointsA.get(0) * pointsB.get(1));
            sum2 += (pointsA.get(1) * pointsB.get(0));
        }

        double area = 0.5 * (Math.abs(sum - sum2));

        System.out.println(area);
    }

    //11.16
    private static void repeatAdditionQuiz() {
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);

        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.print(
                "What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();

        ArrayList<Integer> guesses = new ArrayList<>();

        while (number1 + number2 != answer) {
            if (guesses.contains(answer)) {
                System.out.println("You already entered " + answer);
            }
            guesses.add(answer);
            System.out.print("Wrong answer. Try again. What is "
                    + number1 + " + " + number2 + "? ");
            answer = input.nextInt();
        }

        System.out.println("You got it!");
    }

    //11.17
    private static void perfectSquare() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer m: ");
        int m = input.nextInt();

        int iint = 2;
        int num = m;

        ArrayList<Integer> factors = new ArrayList<>();

        while (num > 1) {
            if (num % iint == 0) {
                factors.add(iint);
                num = num / iint;
            } else {
                iint++;
            }
        }

        ArrayList<Integer> oddOccuringNumbers = new ArrayList<>();

        for (int i=0; i<factors.size(); i++) {
            if (oddOccuringNumbers.contains(factors.get(i))) {
                continue;
            }

            int numOfTimesOccuring = 0;

            for (int j=0; j<factors.size(); j++) {
                if (Objects.equals(factors.get(i), factors.get(j))) {
                    numOfTimesOccuring++;
                }
            }

            if (numOfTimesOccuring % 2 != 0) {
                oddOccuringNumbers.add(factors.get(i));
            }
        }

        int total = 1;
        for (Integer number : oddOccuringNumbers) {
            total *= number;
        }

        System.out.println("The smallest number n for m * n to be a perfect square is " + total);
        System.out.println("m * n is " + (total * m));
    }

    //11.18
    private static void toCharacterArray() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String s = input.nextLine();

        ArrayList<Character> chars = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            chars.add(s.charAt(i));
        }

        System.out.println(chars.toString());
    }

    //11.19
    private static void binPacking() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of objects: ");
        int num = input.nextInt();

        System.out.println("Enter the weights of the objects: ");

        ArrayList<Integer> weights = new ArrayList<>();

        for (int i=0; i<num; i++) {
            weights.add(input.nextInt());
        }

        ArrayList<ArrayList<Integer>> bins = new ArrayList<>();

        for (Integer weight : weights) {
            boolean hasBeenAdded = false;

            for (int i=0; i<bins.size(); i++) {
                int sumOfWeights = 0;
                for (int j=0; j<bins.get(i).size(); j++) {
                    sumOfWeights += bins.get(i).get(j);
                }

                if (sumOfWeights + weight < 10) {
                    bins.get(i).add(weight);
                    hasBeenAdded = true;
                    break;
                }
            }

            if (!hasBeenAdded) {
                ArrayList<Integer> newBin = new ArrayList<>();
                newBin.add(weight);
                bins.add(newBin);
            }
        }

        for (int i=0; i<bins.size(); i++) {
            System.out.print("Container " + i + " contains objects with weight ");
            for (int j=0; j<bins.get(i).size(); j++) {
                System.out.print(bins.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}

class Triangle {
    private double side1, side2, side3 = 1.0;

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
    public String toString() {
        return "Triangle: " +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ".";
    }
}

class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**
     * Construct a default geometric object
     */
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with the specified color
     * and filled value
     */
    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean,
     * its get method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Return a string representation of this object
     */
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }
}

class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person - " +
                "name =" + getName();
    }
}

class Student extends Person {
    static final String FRESHMAN = "Freshman";
    static final String SOPHMORE = "Sophmore";
    static final String JUNIOR = "Junior";
    static final String SENIOR = "Senior";

    private String classStatus;

    public Student(String name, String address, String phoneNumber, String email, String classStatus) {
        super(name, address, phoneNumber, email);
        this.classStatus = classStatus;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public String toString() {
        return "Student - " +
                "name =" + getName();
    }
}

class Employee extends Person {
    private String office;
    private double salary;
    private MyDate dateHired;

    public Employee(String name, String address, String phoneNumber, String email, String office, double salary) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = new MyDate();
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Employee - " +
                "name =" + getName();
    }
}

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String email, String office, double salary, String officeHours, String rank) {
        super(name, address, phoneNumber, email, office, salary);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty - " +
                "name =" + getName();
    }
}

class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phoneNumber, String email, String office, double salary, String title) {
        super(name, address, phoneNumber, email, office, salary);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff - " +
                "name =" + getName();
    }
}

class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int id, double balance, double annualInterestRate, double overdraftLimit) {
        super(id, balance, annualInterestRate);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        double remaining = this.getBalance() - amount;

        if (Math.abs(remaining) >= this.overdraftLimit) {
            this.setBalance(this.getBalance() - amount);
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(int id, double balance, double annualInterestRate) {
        super(id, balance, annualInterestRate);
    }

    @Override
    public void withdraw(double amount) {
        double remaining = this.getBalance() - amount;

        if (remaining >= 0) {
            this.setBalance(this.getBalance() - amount);
        } else {
            System.out.println("Unable to withdraw money");
        }
    }
}

class Course {
    private String courseName;
    private ArrayList<String> students = new ArrayList<>();
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students.add(student);
        numberOfStudents++;
    }

    public ArrayList<String> getStudents() {
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
}

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /**
     * Default constructor
     */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a loan with specified annual interest rate,
     * number of years, and loan amount
     */
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    /**
     * Return annualInterestRate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Set a new annualInterestRate
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Return numberOfYears
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set a new numberOfYears
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Return loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Set a newloanAmount
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Find monthly payment
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /**
     * Find total payment
     */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /**
     * Return loan date
     */
    public java.util.Date getLoanDate() {
        return loanDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "annualInterestRate=" + annualInterestRate +
                ", numberOfYears=" + numberOfYears +
                ", loanAmount=" + loanAmount +
                ", loanDate=" + loanDate +
                '}';
    }
}

class SimpleCircle {
    /**
     * Main method
     */
    public static void main(String[] args) {
        // Create a circle with radius 1
        SimpleCircle circle1 = new SimpleCircle();
        System.out.println("The area of the circle of radius "
                + circle1.radius + " is " + circle1.getArea());

        // Create a circle with radius 25
        SimpleCircle circle2 = new SimpleCircle(25);
        System.out.println("The area of the circle of radius "
                + circle2.radius + " is " + circle2.getArea());

        // Create a circle with radius 125
        SimpleCircle circle3 = new SimpleCircle(125);
        System.out.println("The area of the circle of radius "
                + circle3.radius + " is " + circle3.getArea());

        // Modify circle radius
        circle2.radius = 100;
        System.out.println("The area of the circle of radius "
                + circle2.radius + " is " + circle2.getArea());
    }

    double radius;

    /**
     * Construct a circle with radius 1
     */
    SimpleCircle() {
        radius = 1;
    }

    /**
     * Construct a circle with a specified radius
     */
    SimpleCircle(double newRadius) {
        radius = newRadius;
    }

    /**
     * Return the area of this circle
     */
    double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Return the perimeter of this circle
     */
    double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /**
     * Set a new radius for this circle
     */
    void setRadius(double newRadius) {
        radius = newRadius;
    }

    @Override
    public String toString() {
        return "SimpleCircle{" +
                "radius=" + radius +
                '}';
    }
}

class NewAccount extends Account {
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public NewAccount(int id, double balance, double annualInterestRate, String name) {
        super(id, balance, annualInterestRate);
        this.name = name;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);

        Transaction withdrawal = new Transaction('W', amount, this.getBalance(), "withdrawal");
        transactions.add(withdrawal);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);

        Transaction deposit = new Transaction('D', amount, this.getBalance(), "deposit");
        transactions.add(deposit);
    }

    @Override
    public String toString() {
        return super.toString() + " " + name + " " + transactions.toString();
    }
}

class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}

class MyStack extends ArrayList {
    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int getSize() {
        return size();
    }

    public Object peek() {
        return get(getSize() - 1);
    }

    public Object pop() {
        return remove(getSize() - 1);
    }

    public Object push(Object o) {
        add(o);
        return o;
    }

    public String toString() {
        return "stack: " + toString();
    }
}
