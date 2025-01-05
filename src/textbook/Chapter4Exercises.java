package textbook;

import java.util.Scanner;

public class Chapter4Exercises {
    public static void main(String[] args) {
//        areaOfAPentagon();
//        greatCircleDistance();
//        estimateAreas();
//        areaOfHexagon();
//        areaOfRegularPolygon();
//        randomPointsOnACircle();.
//        cornerPointCoordinates();
//        charOfAsciiCode();
//        unicodeOfCharacter();
//        guessBirthday();
//        decimalToHex();
//        hexToBinary();
//        vowelOrConsonant();
//        letterToGrade();
//        phoneKeyPads();
//        randomCharacter();
//        daysOfAMonth();
//        majorAndStatus();
//        processAString();
//        checkSsn();
//        checkSubstring();
//        payroll();
//        orderCities();
//        generateVehiclePlate();
//        financialApplication();
        isbn();
    }

    //4.1
    private static void areaOfAPentagon() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length from the center to a vertex: ");
        double r = input.nextDouble();

        double s = 2 * r * (Math.sin(Math.PI / 5));
        double area = (5 * s * s) / (4 * Math.tan(Math.PI / 5));

        area = Math.round(area * 100.0) / 100.0;

        System.out.println("The area of the pentagon is " + area);
    }

    //4.2
    private static void greatCircleDistance() {
        final double RADIUS = 6371.01;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
        double x1 = Math.toRadians(input.nextDouble());
        double y1 = Math.toRadians(input.nextDouble());

        System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
        double x2 = Math.toRadians(input.nextDouble());
        double y2 = Math.toRadians(input.nextDouble());

        double d = RADIUS * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        System.out.println("The distance between the two points is " + d + "km");
    }

    //4.3
    private static void estimateAreas() {
        final double RADIUS = 6371.01;

        double ax = Math.toRadians(33.7489954);
        double ay = Math.toRadians(-84.3879824);

        double cx = Math.toRadians(35.2270869);
        double cy = Math.toRadians(-80.8431267);

        double sx = Math.toRadians(32.0835407);
        double sy = Math.toRadians(-81.0998342);

        double ox = Math.toRadians(28.5383355);
        double oy = Math.toRadians(-81.3792365);

        double distanceAC = RADIUS * Math.acos(Math.sin(ax) * Math.sin(cx) + Math.cos(ax) * Math.cos(cx) * Math.cos(ay - cy));
        double distanceCS = RADIUS * Math.acos(Math.sin(cx) * Math.sin(sx) + Math.cos(cx) * Math.cos(sx) * Math.cos(cy - sy));
        double distanceSO = RADIUS * Math.acos(Math.sin(sx) * Math.sin(ox) + Math.cos(sx) * Math.cos(ox) * Math.cos(sy - oy));
        double distanceOA = RADIUS * Math.acos(Math.sin(ox) * Math.sin(ax) + Math.cos(ox) * Math.cos(ax) * Math.cos(oy - ay));
        double distanceSA = RADIUS * Math.acos(Math.sin(sx) * Math.sin(ax) + Math.cos(sx) * Math.cos(ax) * Math.cos(sy - ay));

        double triangle1S = (distanceAC + distanceCS + distanceSA) / 2;
        double areaTriangle1 = Math.sqrt(triangle1S * (triangle1S - distanceAC) * (triangle1S - distanceCS) * (triangle1S - distanceSA));

        double triangle2S = (distanceSA + distanceOA + distanceSO) / 2;
        double areaTriangle2 = Math.sqrt(triangle2S * (triangle2S - distanceSA) * (triangle2S - distanceOA) * (triangle2S - distanceSO));

        System.out.println("Estimated area enclosed by 4 cities: " + (areaTriangle1 + areaTriangle2) + "km");
    }

    //4.4
    private static void areaOfHexagon() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the side: ");
        double s = input.nextDouble();

        double area = (6 * (s * s)) / (4 * Math.tan(Math.PI / 6));

        System.out.println("The area of the hexagon is " + area);
    }

    //4.5
    private static void areaOfRegularPolygon() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of sides: ");
        double n = input.nextInt();

        System.out.print("Enter the side: ");
        double s = input.nextDouble();

        double area = (n * (s * s)) / (4 * Math.tan(Math.PI / n));

        System.out.println("The area of the polygon is " + area);
    }

    //4.6
    private static void randomPointsOnACircle() {
        final double radius = 40;

        double angle1 = Math.random() * (2 * Math.PI);
        double x1 = radius * Math.cos(angle1);
        double y1 = radius * Math.sin(angle1);
        System.out.println("(" + x1 + ", " + y1 + ")");

        double angle2 = Math.random() * (2 * Math.PI);
        double x2 = radius * Math.cos(angle2);
        double y2 = radius * Math.sin(angle2);
        System.out.println("(" + x2 + ", " + y2 + ")");

        double angle3 = Math.random() * (2 * Math.PI);
        double x3 = radius * Math.cos(angle3);
        double y3 = radius * Math.sin(angle3);
        System.out.println("(" + x3 + ", " + y3 + ")");
    }

    //4.7
    private static void cornerPointCoordinates() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius of the bounding circle: ");
        double r = input.nextDouble();

        System.out.println("The coordinates of five points on the pentagon are");

        double angle1 = 0;
        double x1 = r * Math.cos(angle1);
        double y1 = r * Math.sin(angle1);
        System.out.println("(" + x1 + ", " + y1 + ")");

        double angle2 = (2 * Math.PI) / 5;
        double x2 = r * Math.cos(angle2);
        double y2 = r * Math.sin(angle2);
        System.out.println("(" + x2 + ", " + y2 + ")");

        double angle3 = (4 * Math.PI) / 5;
        double x3 = r * Math.cos(angle3);
        double y3 = r * Math.sin(angle3);
        System.out.println("(" + x3 + ", " + y3 + ")");

        double angle4 = (6 * Math.PI) / 5;
        double x4 = r * Math.cos(angle4);
        double y4 = r * Math.sin(angle4);
        System.out.println("(" + x4 + ", " + y4 + ")");

        double angle5 = (8 * Math.PI) / 5;
        double x5 = r * Math.cos(angle5);
        double y5 = r * Math.sin(angle5);
        System.out.println("(" + x5 + ", " + y5 + ")");
    }

    //4.8
    private static void charOfAsciiCode() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an ASCII code: ");
        int ascii = input.nextInt();

        System.out.println("The character for ASCII code 69 is " + (char) ascii);
    }

    //4.9
    private static void unicodeOfCharacter() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a character ");
        char unicode = input.nextLine().charAt(0);

        System.out.println("The Unicode for the character " + unicode + " is " + (int) unicode);
    }

    //4.10
    private static void guessBirthday() {
        String set1 = " 1 3 5 7\n" +
                " 9 11 13 15\n" +
                "17 19 21 23\n" +
                "25 27 29 31";

        String set2 = " 2 3 6 7\n" +
                "10 11 14 15\n" +
                "18 19 22 23\n" +
                "26 27 30 31";

        String set3 = " 4 5 6 7\n" +
                "12 13 14 15\n" +
                "20 21 22 23\n" +
                "28 29 30 31";

        String set4 = " 8 9 10 11\n" +
                "12 13 14 15\n" +
                "24 25 26 27\n" +
                "28 29 30 31";

        String set5 = "16 17 18 19\n" +
                "20 21 22 23\n" +
                "24 25 26 27\n" +
                "28 29 30 31";

        int day = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Is your birthday in Set1?\n");
        System.out.print(set1);
        System.out.print("\nEnter N for No and Y for Yes: ");

        char answer = input.nextLine().charAt(0);
        if (answer == 'Y') {
            day += 1;
        }

        System.out.print("Is your birthday in Set2?\n");
        System.out.print(set2);
        System.out.print("\nEnter N for No and Y for Yes: ");

        answer = input.nextLine().charAt(0);
        if (answer == 'Y') {
            day += 2;
        }

        System.out.print("Is your birthday in Set3?\n");
        System.out.print(set3);
        System.out.print("\nEnter N for No and Y for Yes: ");

        answer = input.nextLine().charAt(0);
        if (answer == 'Y') {
            day += 4;
        }

        System.out.print("Is your birthday in Set4?\n");
        System.out.print(set4);
        System.out.print("\nEnter N for No and Y for Yes: ");

        answer = input.nextLine().charAt(0);
        if (answer == 'Y') {
            day += 8;
        }

        System.out.print("Is your birthday in Set5?\n");
        System.out.print(set5);
        System.out.print("\nEnter N for No and Y for Yes: ");

        answer = input.nextLine().charAt(0);
        if (answer == 'Y') {
            day += 16;
        }

        System.out.println("\nYour birthday is " + day + "!");
    }

    //4.11
    private static void decimalToHex() {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a decimal value (0 to 15): ");
        int v = input.nextInt();

        if (v < 0 || v > 15) {
            System.out.println(v + " is an invalid input");
        } else {
            System.out.println("The hex value is " + hexDigits[v]);
        }
    }

    //4.12
    private static void hexToBinary() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a hexadecimal value: ");
        String v = input.nextLine();
        char hex = v.charAt(0);

        String result = "";

        switch (hex) {
            case '0':
                result = "0";
                break;
            case '1':
                result = "1";
                break;
            case '2':
                result = "10";
                break;
            case '3':
                result = "11";
                break;
            case '4':
                result = "100";
                break;
            case '5':
                result = "101";
                break;
            case '6':
                result = "110";
                break;
            case '7':
                result = "111";
                break;
            case '8':
                result = "1000";
                break;
            case '9':
                result = "1001";
                break;
            case 'A':
                result = "1010";
                break;
            case 'B':
                result = "1011";
                break;
            case 'C':
                result = "1100";
                break;
            case 'D':
                result = "1101";
                break;
            case 'E':
                result = "1110";
                break;
            case 'F':
                result = "1111";
                break;
            default:
                System.out.println(hex + " is an invalid input");
                System.exit(1);
        }

        System.out.println("The binary of " + hex + " is " + result);
    }

    //4.13
    private static void vowelOrConsonant() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a hexadecimal value: ");
        String v = input.nextLine();
        char letter = Character.toUpperCase(v.charAt(0));

        if (letter <= 'Z' && letter >= 'A') {
            if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
                System.out.println(v + " is a vowel");
            } else {
                System.out.println(v + " is a consonant");
            }
        } else {
            System.out.println(v + " is an invalid input");
        }
    }

    //4.14
    private static void letterToGrade() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a hexadecimal value: ");
        String v = input.nextLine();
        char letter = Character.toUpperCase(v.charAt(0));

        String result = "";

        if (letter <= 'Z' && letter >= 'A') {
            switch (letter) {
                case 'A':
                    result = "4";
                    break;
                case 'B':
                    result = "3";
                    break;
                case 'C':
                    result = "2";
                    break;
                case 'D':
                    result = "1";
                    break;
                case 'F':
                    result = "0";
                    break;
                default:
                    System.out.println(v + " is an invalid grade");
                    System.exit(1);
            }
        } else {
            System.out.println(v + " is an invalid grade");
        }

        System.out.println("The numeric value for grade " + v + " is " + result);
    }

    //4.15
    private static void phoneKeyPads() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a letter: ");
        String v = input.nextLine();
        char letter = Character.toUpperCase(v.charAt(0));

        String result = "";
        if (letter <= 'Z' && letter >= 'A') {
            switch (letter) {
                case 'A':
                    result = "2";
                    break;
                case 'B':
                    result = "2";
                    break;
                case 'C':
                    result = "2";
                    break;
                case 'D':
                    result = "3";
                    break;
                case 'E':
                    result = "3";
                    break;
                case 'F':
                    result = "3";
                    break;
                case 'G':
                    result = "4";
                    break;
                case 'H':
                    result = "4";
                    break;
                case 'I':
                    result = "4";
                    break;
                case 'J':
                    result = "5";
                    break;
                case 'K':
                    result = "5";
                    break;
                case 'L':
                    result = "5";
                    break;
                case 'M':
                    result = "6";
                    break;
                case 'N':
                    result = "6";
                    break;
                case 'O':
                    result = "6";
                    break;
                case 'P':
                    result = "7";
                    break;
                case 'Q':
                    result = "7";
                    break;
                case 'R':
                    result = "7";
                    break;
                case 'S':
                    result = "7";
                    break;
                case 'T':
                    result = "8";
                    break;
                case 'U':
                    result = "8";
                    break;
                case 'V':
                    result = "8";
                    break;
                case 'W':
                    result = "9";
                    break;
                case 'X':
                    result = "9";
                    break;
                case 'Y':
                    result = "9";
                    break;
                case 'Z':
                    result = "9";
                    break;
                default:
                    System.out.println(v + " is an invalid input");
                    System.exit(1);
            }
        } else {
            System.out.println(v + " is an invalid input");
        }

        System.out.println("The corresponding number is " + result);
    }

    //4.16
    private static void randomCharacter() {
        int random = (int) (Math.random() * (90 - 65 + 1)) + 65;

        System.out.println(random + " is equal to " + (char) random);
    }

    //4.17
    private static void daysOfAMonth() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a year: ");
        int year = input.nextInt();

        input.nextLine();

        System.out.println("Enter a month: ");
        String v = input.nextLine();

        if (v.charAt(0) <= 'Z' && v.charAt(0) >= 'A') {
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

            if (v.equals("Feb") && isLeapYear) {
                System.out.println(v + " " + year + " has 29 days");
            } else {
                String numberOfDays = "";

                switch (v) {
                    case "Jan":
                        numberOfDays = "31";
                        break;
                    case "Mar":
                        numberOfDays = "31";
                        break;
                    case "Apr":
                        numberOfDays = "30";
                        break;
                    case "May":
                        numberOfDays = "31";
                        break;
                    case "Jun":
                        numberOfDays = "30";
                        break;
                    case "Jul":
                        numberOfDays = "31";
                        break;
                    case "Aug":
                        numberOfDays = "31";
                        break;
                    case "Sep":
                        numberOfDays = "30";
                        break;
                    case "Oct":
                        numberOfDays = "31";
                        break;
                    case "Nov":
                        numberOfDays = "30";
                        break;
                    case "Dec":
                        numberOfDays = "31";
                        break;
                    default:
                        System.out.println(v + " " + year + " has 28 days");
                        System.exit(0);
                }
                System.out.println(v + " " + year + " has " + numberOfDays + " days");
            }
        } else {
            System.out.println(v + " is not a correct month name");
        }
    }

    //4.18
    private static void majorAndStatus() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter two characters: ");
        String chars = input.nextLine();

        char major = chars.charAt(0);
        char year = chars.charAt(1);

        if (major == 'M' || major == 'C' || major == 'I') {
            String student = "";

            switch(year) {
                case '1': student = "Freshman"; break;
                case '2': student = "Sophomore"; break;
                case '3': student = "Junior"; break;
                case '4': student = "Senior"; break;
                default: System.out.println("Invalid input"); System.exit(1);
            }

            if (major == 'M') {
                System.out.println("Mathematics " + student);
            } else if (major == 'C') {
                System.out.println("Computer Science " + student);
            } else {
                System.out.println("Information Technology " + student);
            }
        } else {
            System.out.println("Invalid input");
        }
    }

    //4.19
    private static void isbn() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first 9 digits of an ISBN as integer: ");

        String isbn = input.nextLine();

        int firstDigit = Integer.parseInt("" + isbn.charAt(0));
        int secondDigit = Integer.parseInt("" + isbn.charAt(1));
        int thirdDigit = Integer.parseInt("" + isbn.charAt(2));
        int fourthDigit = Integer.parseInt("" + isbn.charAt(3));
        int fifthDigit = Integer.parseInt("" + isbn.charAt(4));
        int sixthDigit = Integer.parseInt("" + isbn.charAt(5));
        int seventhDigit = Integer.parseInt("" + isbn.charAt(6));
        int eigthDigit = Integer.parseInt("" + isbn.charAt(7));
        int ninthDigit = Integer.parseInt("" + isbn.charAt(8));

        int checkSum =
                (firstDigit + secondDigit * 2 + thirdDigit * 3 + fourthDigit * 4 + fifthDigit * 5 + sixthDigit * 6 + seventhDigit * 7 + eigthDigit * 8 + ninthDigit * 9) % 11;

        if (checkSum == 10) {
            System.out.println("The ISBN-10 number is " + isbn + "X");
        } else {
            System.out.println("The ISBN-10 number is " + isbn + "" + checkSum);
        }
    }

    //4.20
    static void processAString() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String string = input.nextLine();

        System.out.println("The length is " + string.length() + ", and the first character is " + string.charAt(0));
    }

    //4.21
    private static void checkSsn() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a SSN: ");
        String string = input.nextLine();

        int indexOfFirst = string.indexOf('-');
        String firstSubstring = string.substring(0, indexOfFirst);

        if (firstSubstring.length() != 3) {
            System.out.println(string + " is an invalid social security number");
            System.exit(1);
        }

        int indexOfSecond = string.indexOf('-', indexOfFirst + 1);
        String secondSubstring = string.substring(indexOfFirst + 1, indexOfSecond);

        if (secondSubstring.length() != 2) {
            System.out.println(string + " is an invalid social security number");
            System.exit(1);
        }

        String thirdSubstring = string.substring(indexOfSecond+ 1);

        if (thirdSubstring.length() != 4) {
            System.out.println(string + " is an invalid social security number");
            System.exit(1);
        }

        System.out.println(string + " is a valid social security number");
    }

    //4.22
    private static void checkSubstring() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string s1:  ");
        String string1 = input.nextLine();

        System.out.println("Enter string s2:  ");
        String string2 = input.nextLine();

        if(string1.indexOf(string2) > 0) {
            System.out.println(string2 + " is a substring of " + string1);
        } else {
            System.out.println(string2 + " is not a substring of " + string1);
        }
    }

    //4.23
    private static void payroll() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name:  ");
        String name = input.nextLine();

        System.out.println("Number of hours worked in a week (e.g., 10)  ");
        double hoursWorked = input.nextDouble();

        System.out.println("Hourly pay rate (e.g., 9.75)  ");
        double payRate = input.nextDouble();

        System.out.println("Federal tax withholding rate ");
        double federalTax = input.nextDouble();

        System.out.println("state tax withholding rate ");
        double stateTax = input.nextDouble();

        double grossPay = payRate * hoursWorked;
        double federalWitholding =  grossPay * federalTax;
        double stateWitholding = grossPay * stateTax;
        double totalDeductions = federalWitholding + stateWitholding;
        double netPay = grossPay - totalDeductions;

        System.out.println("Employee Name: " + name);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Pay Rate: $" + payRate);
        System.out.println("Gross Pay: $" + grossPay);
        System.out.println("Deductions:");
        System.out.println("  Federal Witholding (" + federalTax * 100 + "%): " + federalWitholding);
        System.out.println("  State Witholding (" + federalTax * 100 + "%): " + federalWitholding);
        System.out.println("  Total Deduction: " + totalDeductions);
        System.out.println("Net Pay: $" + netPay);
    }

    //4.24
    private static void orderCities() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first city: ");
        String city1 = input.nextLine();

        System.out.println("Enter the second city: ");
        String city2 = input.nextLine();

        System.out.println("Enter the third city: ");
        String city3 = input.nextLine();

        if (city1.compareTo(city2) > 0) {
            String temp = city1;
            city1 = city2;
            city2 = temp;
        }

        if (city2.compareTo(city3) > 0) {
            String temp = city2;
            city2 = city3;
            city3 = temp;
        }

        if (city1.compareTo(city2) > 0) {
            String temp = city1;
            city1 = city2;
            city2 = temp;
        }

        System.out.println("The three cities in alphabetical order are: " + city1 + " " + city2 + " " + city3);
    }

    //4.25
    private static void generateVehiclePlate() {
        char letter1 = (char) ((int) (Math.random() * (90 - 65 + 1) + 65));
        char letter2 = (char) ((int) (Math.random() * (90 - 65 + 1) + 65));
        char letter3 = (char) ((int) (Math.random() * (90 - 65 + 1) + 65));
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
        int number3 = (int) (Math.random() * 10);

        System.out.println("Number plate: " + letter1 + letter2 + letter3 + number1 + number2 + number3);
    }

    //4.26
    private static void financialApplication() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an amount e.g 11.56: ");
        String amount = input.nextLine();

        int indexOfDecimal = amount.indexOf(".");
        String numberOfOneDollars = amount.substring(0, indexOfDecimal);

        int remainingAmount = Integer.parseInt(amount.substring(indexOfDecimal + 1));

        int numberOfQuarters = remainingAmount / 25;
        remainingAmount = remainingAmount % 25;

        int numberOfDimes = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;

        int numberOfNickels = remainingAmount / 5;
        remainingAmount = remainingAmount % 5;

        int numberOfPennies = remainingAmount;

        System.out.println("Your amount " + amount + " consists of");
        if (!numberOfOneDollars.equals("0")) {
            System.out.println(" " + numberOfOneDollars + (numberOfOneDollars.length() > 1 ? " dollars" : " dollar"));
        }

        if (numberOfQuarters > 0) {
            System.out.println(" " + numberOfQuarters + (numberOfQuarters > 1 ? " quarters" : " quarter"));
        }

        if (numberOfDimes > 0) {
            System.out.println(" " + numberOfDimes + (numberOfDimes > 1 ? " dimes" : " dime"));
        }

        if (numberOfNickels > 0) {
            System.out.println(" " + numberOfNickels + (numberOfNickels > 1 ? " nickels" : " nickel"));
        }

        if (numberOfPennies > 0) {
            System.out.println(" " + numberOfPennies + (numberOfPennies > 1 ? " pennies" : " penny"));
        }
    }
}
