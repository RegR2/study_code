package textbook;

import java.util.Scanner;

public class Chapter2Exercises {
    public static void main(String[] args) {
//        convertCelciusToFahrenheit();
//        computeVolumeOfCylinder();
//        convertFeedIntoMeters();
//        convertPoundToKilograms();
//        calculateTips();
//        sumDigitsInInteger();
//        numberOfYears();
//        currentTime();
//        acceleration;
//        calculatingEnergy();
//        projectPopulation();
//        runwayLength();
//        financialApplication();
//        computingBmi();
//        distanceOfTwoPoints();
//        areaOfHexagon();
//        windChill();
//        printTable();
        areaOfTriangle();
//        calculateInterest();
//        futureInvestmentValue();
//        monetaryUnits();
//        costOfDriving();
    }

    //2.1
    private static void convertCelciusToFahrenheit() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a degree in Celsius as a double: ");

        double c = input.nextDouble();
        double f = (9.0 / 5) * c + 32;

        System.out.println(c + " Celcius is " + f + " Fahrenheit");
    }

    //2.2
    private static void computeVolumeOfCylinder() {
        final double PI = 3.14295;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius as a double and length as an int of a cylinder: ");

        double radius = input.nextDouble();
        int length = input.nextInt();

        double area = radius * radius * PI;
        System.out.println("the area is " + area);
        double volume = area * length;
        System.out.println("the volume is " + volume);
    }

    //2.3
    private static void convertFeedIntoMeters() {
        final double METERS_IN_FOOT = 0.305;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a value for feet in double: ");

        double feet = input.nextDouble();

        System.out.println(feet + " feet is " + feet * METERS_IN_FOOT + " meters");
    }

    //2.4
    private static void convertPoundToKilograms() {
        final double POUND_TO_KG = 0.454;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter double in pounds: ");

        double pounds = input.nextDouble();

        System.out.println(pounds + " is " + pounds * POUND_TO_KG + " kilograms");
    }

    //2.5
    private static void calculateTips() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the subtotal (double) and a gratuity rate (double): ");

        double subtotal = input.nextDouble();
        double gratuityRate = input.nextDouble();

        double gratuity = subtotal * (gratuityRate / 100);
        double total = subtotal + gratuity;

        System.out.println("the gratuiity is $" + gratuity + " and total is $" + total);
    }

    //2.6
    private static void sumDigitsInInteger() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000: ");

        int digit = input.nextInt();

        int lastDigit = digit % 10;
        int remainingDigitLastRemoved = digit / 10;

        int secondLastDigit = remainingDigitLastRemoved % 10;
        int remainingDigitSecondLastRemoved = remainingDigitLastRemoved / 10;

        int thirdLastDigit = remainingDigitSecondLastRemoved % 10;
        int remainingDigitThirdLastRemoved = remainingDigitSecondLastRemoved / 10;

        System.out.println("The sum of the digits is " + (lastDigit + secondLastDigit + thirdLastDigit + remainingDigitThirdLastRemoved));
    }

    //2.7
    private static void numberOfYears() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number of minutes: ");

        int minutes = input.nextInt();

        int minutesInDay = 24 * 60;
        int minutesInYear = 365 * minutesInDay;

        int years = minutes / minutesInYear;
        int remainingMinutes = minutes % minutesInYear;

        int days = remainingMinutes / minutesInDay;

        System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days");
    }

    //2.8
    private static void currentTime() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the time zone offset to GMT: ");

        int timeZoneOffset = input.nextInt();

        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        long currentSecond = totalSeconds % 60;

        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;

        long totalHours = totalSeconds / 60;
        long currentHour = (totalHours + timeZoneOffset) % 24;

        System.out.println("Current time is " + currentHour + ":" + currentMinute + ":" + currentSecond);
    }

    //2.9
    private static void acceleration() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter v0, v1, and t:: ");

        double v0 = input.nextDouble();
        double v1 = input.nextDouble();
        double t = input.nextDouble();

        double averageAcceleration = (v1 - v0) / t;

        System.out.println("The average acceleration is " + averageAcceleration);
    }

    //2.10
    private static void calculatingEnergy() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount of water in kilograms: ");
        double water = input.nextDouble();

        System.out.print("Enter the initial temperature: ");
        double initalTemp = input.nextDouble();

        System.out.print("Enter the final temperature: ");
        double finalTemp = input.nextDouble();

        double energyNeeded = water * (finalTemp - initalTemp) * 4184;

        System.out.println("The energy needed is  " + energyNeeded);
    }

    //2.11
    public static void projectPopulation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of years: ");

        int numberofYears = input.nextInt();

        int currentPopulation = 312032486;
        int secondsInAYear = 365 * 24 * 60 * 60;

        double birthRate = secondsInAYear / 7.0;
        double deathRate = secondsInAYear / 13.0;
        double immigrationRate = secondsInAYear / 45.0;

        int endPopulation = currentPopulation;

        for (int i = 1; i <= numberofYears; i++) {
            endPopulation = (int) (endPopulation + birthRate - deathRate + immigrationRate);
        }

        System.out.println("The population in " + numberofYears + " is " + endPopulation);
    }

    //2.12
    public static void runwayLength() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter speed and acceleration: ");

        int speed = input.nextInt();
        double acceleration = input.nextDouble();

        double length = Math.pow(speed, 2) / (2 * acceleration);

        System.out.println("The minimum runway length for this airplane is " + length);
    }

    //2.13
    public static void financialApplication() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the monthly saving amount:  ");

        double depositAmount = input.nextDouble();

        double firstMonth = depositAmount * (1 + 0.00417);
        double secondMonth = (depositAmount + firstMonth) * (1 + 0.00417);
        double thirdMonth = (depositAmount + secondMonth) * (1 + 0.00417);
        double fourthMonth = (depositAmount + thirdMonth) * (1 + 0.00417);
        double fifthMonth = (depositAmount + fourthMonth) * (1 + 0.00417);
        double sixthMonth = (depositAmount + fifthMonth) * (1 + 0.00417);

        System.out.println("After the sixth month, the account value is $" + sixthMonth);
    }

    //2.14
    public static void computingBmi() {
        final double POUND_TO_KG = 0.45359237;
        final double INCH_TO_M = 0.0254;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in pounds:  ");
        double weight = input.nextDouble();

        System.out.print("Enter height in inches:  ");
        double height = input.nextDouble();

        double bmi = weight * POUND_TO_KG / Math.pow((height * INCH_TO_M), 2);

        System.out.println("BMI is " + bmi);
    }

    //2.15
    public static void distanceOfTwoPoints() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter x1 and y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.print("Enter x2 and y4: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        double xSquared = Math.pow((x2 - x1), 2);
        double ySquared = Math.pow((y2 - y1), 2);

        double distance = Math.pow((xSquared + ySquared), 0.5);
        System.out.println("The distance between the two points is " + distance);
    }

    //2.16
    public static void areaOfHexagon() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the side: ");
        double side = input.nextDouble();

        double area = ((3 * Math.pow(3, 0.5)) / 2) * (side * side);

        System.out.println("The area of the hexagon is  " + area);
    }

    //2.17
    public static void windChill() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Fahrenheit between -58°F and 41°F: ");
        double temperature = input.nextDouble();

        System.out.print("Enter the wind speed (7 = 2) in miles per hour: ");
        double windSpeed = input.nextDouble();

        double windChilld = 35.74 + (0.6215 * temperature) - (35.75 * Math.pow(windSpeed, 0.16)) + 0.4275 * (temperature * Math.pow(windSpeed, 0.16));

        System.out.println("The wind chill index is  " + windChilld);
    }

    //2.18
    public static void printTable() {
        System.out.println("a        b         pow(a, b)");
        System.out.println("1        2         " + (int) Math.pow(1, 2));
        System.out.println("2        3         " + (int) Math.pow(2, 3));
        System.out.println("3        4         " + (int) Math.pow(3, 4));
        System.out.println("4        5         " + (int) Math.pow(4, 5));
        System.out.println("5        6         " + (int) Math.pow(5, 6));
    }

    //2.19
    public static void areaOfTriangle() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the coordinates of three points separated by spaces like x1 y1 x2 y2 x3 y3: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        double side1 = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
        double side2 = Math.pow(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2), 0.5);
        double side3 = Math.pow(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2), 0.5);

        double s = (side1 + side2 + side3) / 2;

        double beforeSquareRoot = s * (s - side1) * (s - side2) * (s - side3);
        double areaOfTriangle = Math.pow(beforeSquareRoot, 0.5);

        System.out.println("The area of the triangle is " + areaOfTriangle);
    }

    //2.20
    public static void calculateInterest() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter balance and interest rate (e.g., 3 for 3%): ");
        double balance = input.nextDouble();
        double annualInterestRate = input.nextDouble();

        double interestRate = balance * (annualInterestRate / 1200);

        System.out.println("The interest is " + interestRate);
    }

    //2.21
    public static void futureInvestmentValue() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = input.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double annualInterest = input.nextDouble();
        double monthlyInterest = (annualInterest / 100) / 12;

        System.out.print("Enter number of years: ");
        int years = input.nextInt();

        int power = years * 12;
        double interest = 1 + monthlyInterest;

        double futureInvestmentAmount = investmentAmount * Math.pow(interest, power);

        System.out.println("Future value is $" + futureInvestmentAmount);
    }

    //2.22
    public static void monetaryUnits() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an amount in integers, for example 1156 = 11.56: ");
        int amount = input.nextInt();

        int remainingAmount = amount;

        int numberOfOneDollars = remainingAmount / 100;
        remainingAmount = remainingAmount % 100;

        int numberOfQuarters = remainingAmount / 25;
        remainingAmount = remainingAmount % 25;

        int numberOfDimes = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;

        int numberOfNickels = remainingAmount / 5;
        remainingAmount = remainingAmount % 5;

        int numberOfPennies = remainingAmount;

        System.out.println("Your amount " + amount + " consists of");
        System.out.println(" " + numberOfOneDollars + " dollars");
        System.out.println(" " + numberOfQuarters + " quarters ");
        System.out.println(" " + numberOfDimes + " dimes");
        System.out.println(" " + numberOfNickels + " nickels");
        System.out.println(" " + numberOfPennies + " pennies");
    }

    //2.23
    public static void costOfDriving() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the driving distance: ");
        double distance = input.nextDouble();

        System.out.print("Enter miles per gallon: ");
        double miles = input.nextDouble();

        System.out.print("Enter price per gallon: ");
        double price = input.nextDouble();

        System.out.println("The cost of driving is $" + distance / miles * price);
    }
}
