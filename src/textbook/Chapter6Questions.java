package textbook;

import java.util.Scanner;

public class Chapter6Questions {
    public static void main(String[] args) {
//        pentagonalNumbers();
//        digitsInAnInteger();
//        reverse(3443);
//        displaySortedNumbers(30.6, 29.5, 30.5);
//        displayPatterns();
//        financialApplication();
//        betweenCandF();
//        betweenFandM();
//        primeNumbers();
//        computeCommission();
//        printChars('1', 'Z', 10);
//        sumSeries();
//        estimatePi();
//        tax();
//        printNumberOfDaysInYear();
//        printMatrix();
//        checkPassword();
//        triangles();
//        countLetters();
//        phoneKeypads();
//        approximateTheSquareRoot();
//        specifiedCharacter();
//        convertMilliseconds();
//        palindromicPrime();
//        emirp();
//        mersennePrime();
//        twinPrimes();
//        craps();
//        creditCardValidation();
//        chanceOfWinningAtCraps();
//        areaOfPentagon();
//        areaOfRegularPolygon();
//        formatInteger(34, 1);
//        generateRandomChars();
//        pointPosition();
//        displayCurrentDateTime();
//        currentDateTime();
        printCalendar();
    }

    //6.1
    private static void pentagonalNumbers() {
        int numbersPerLine = 0;
        for (int i = 1; i <= 100; i++) {
            if (numbersPerLine == 10) {
                System.out.println();
                numbersPerLine = 0;
            }
            System.out.print(getPentagonalNumber(i) + " ");
            numbersPerLine++;
        }
    }

    private static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }

    //6.2
    private static void digitsInAnInteger() {
        System.out.println(sumDigits(335));
        System.out.println(sumDigits(234));
        System.out.println(sumDigits(475));
    }

    private static int sumDigits(long n) {
        int total = 0;

        while (n != 0) {
            long num = n % 10;
            total += (int) num;

            n = n / 10;
        }

        return total;
    }

    //6.3 + 6.4
    private static void reverse(int number) {
        String reverse = "";
        int num = number;

        while (num != 0) {
            reverse += num % 10;
            num = num / 10;
        }

        int reverseNumber = Integer.parseInt(reverse);
        System.out.print(reverseNumber + " ");
        isPalindrome(reverseNumber, number);
    }

    private static void isPalindrome(int reverseNumber, int number) {
        if (reverseNumber == number) {
            System.out.print("is a palindrome of " + number);
        } else {
            System.out.print("is not a palindrome of " + number);
        }
    }

    //6.5
    private static void displaySortedNumbers(double num1, double num2, double num3) {
        if (num1 > num2) {
            double temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if (num2 > num3) {
            double temp = num2;
            num2 = num3;
            num3 = temp;
        }

        if (num1 > num2) {
            double temp = num1;
            num1 = num2;
            num2 = temp;
        }

        System.out.println("numbers in ascending order: " + num1 + " " + num2 + " " + num3);
    }

    //6.6
    private static void displayPatterns() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();

        displayPattern(number);
    }

    private static void displayPattern(int number) {
        int intCount = 0;

        while (intCount < number) {
            System.out.printf("%" + ((number * 2) - (intCount - 1) * 2) + "s", " ");
            int decNumber = intCount + 1;

            while (decNumber >= 1) {
                System.out.print(decNumber + " ");
                decNumber--;
            }

            intCount++;
            System.out.println();
        }
    }

    //6.7
    private static void financialApplication() {
        Scanner input = new Scanner(System.in);

        System.out.println("Amount invested: ");
        double investmentAmount = input.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double annualInterest = input.nextDouble();
        double monthlyInterest = (annualInterest / 100) / 12;

        System.out.println("Years          Future Value");

        for (int i = 1; i <= 30; i++) {
            System.out.println(i + "          " + futureInvestmentValue(investmentAmount, monthlyInterest, i));
        }
    }

    private static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        int power = years * 12;
        double interest = 1 + monthlyInterestRate;

        return investmentAmount * Math.pow(interest, power);
    }

    //6.8
    private static void betweenCandF() {
        double startC = 40.0;
        double startF = 120.0;

        System.out.println("Celcius    Fahrenheit    |     Fahrenheit      Celsius");
        System.out.println("------------------------------------------------------");

        while (startC > 30) {
            System.out.printf("%.2f%3s%.2f%s%.2f%3s%.2f", startC, "        ", celsiusToFahrenheit(startC), "      |       ", startF, "    ", fahrenheitToCelsius(startF));
            startC--;
            startF = startF - 10.0;
            System.out.println(" ");
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    //6.9
    private static void betweenFandM() {
        double startF = 1.0;
        double startM = 20.0;

        System.out.println("Feet    Meters    |     Meters      Feet");
        System.out.println("----------------------------------------");

        while (startF <= 10) {
            System.out.printf("%.1f%3s%.3f%s%.1f%3s%.3f", startF, "   ", footToMeter(startF), "       |      ", startM, "    ", meterToFoot(startM));
            startF++;
            startM += 5;
            System.out.println(" ");
        }
    }

    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    //6.10
    private static void primeNumbers() {
        int numberOfPrimes = 0;

        for (int i = 0; i <= 10000; i++) {
            if (isPrime(i)) {
                numberOfPrimes++;
            }
        }

        System.out.print(numberOfPrimes);
    }

    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) { // If true, number is not prime
                return false; // number is not a prime
            }
        }

        return true; // number is prime
    }

    //6.11
    private static void computeCommission() {
        System.out.println("Sales Amount        Commissions");
        int i = 10000;
        while (i <= 100000) {
            //compute commission for first  5000
            //then 10000
            //then the rest

            int total = i;

            double commission = 0;

            commission += 5000 * 0.08;
            total -= 5000;

            commission += 5000 * 0.10;
            total -= 5000;

            commission += (total * 0.12);

            System.out.println(i + "               " + commission);

            i += 5000;
        }
    }

    //6.12
    private static void printChars(char ch1, char ch2, int numberPerLine) {
        int line = 0;

        for (int i = (int) ch1; i <= (int) ch2; i++) {
            if (line == numberPerLine) {
                line = 0;
                System.out.println();
            }

            System.out.print((char) i + " ");
            line++;
        }
    }

    //6.13
    private static void sumSeries() {
        double m = 0;

        System.out.println("i                   m(i)");

        for (int i = 1; i <= 20; i++) {
            m += i / (i + 1.0);

            System.out.printf("%d%s%.4f\n", i, "                 ", m);
        }

    }

    //6.14
    private static void estimatePi() {
        System.out.println("i                           m(i)");

        for (int i = 1; i <= 901; i += 100) {
            double pi = calculatePi(i);
            System.out.printf("%d%s%.4f\n", i, "                         ", pi);
        }

    }

    private static double calculatePi(int num) {
        double pi = 0.0;

        for (int i = 1; i <= num; i++) {
            double sum = Math.pow(-1, i + 1) / (2.0 * i - 1);
            pi += sum;
        }

        return 4 * pi;
    }

    //6.15
    private static void tax() {
        int taxableIncome = 50000;
        System.out.printf("%s%s%s%s%s\n", "Income", "    0    ", "    1   ", "    2    ", "   3");
        while (taxableIncome <= 60000) {
            long status0 = Math.round(computeTax(0, taxableIncome));
            long status1 = Math.round(computeTax(1, taxableIncome));
            long status2 = Math.round(computeTax(2, taxableIncome));
            long status3 = Math.round(computeTax(3, taxableIncome));
            System.out.printf("%d%s%d%s%d%s%d%s%d\n", taxableIncome, "    ", status0, "   ", status1, "    ", status2, "    ", status3);
            taxableIncome += 50;
        }

    }

    private static double computeTax(int status, int income) {
        if (status == 0) {
            if (income <= 8350) {
                return income * 0.10;
            } else if (income <= 33950) {
                return 8350 * 0.10 + (income - 8350) * 0.15;
            } else if (income <= 82250) {
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
            } else if (income <= 171550) {
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
            } else if (income <= 372950) {
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (income - 171550) * 0.33;
            } else {
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
            }
        } else if (status == 1) {
            if (income <= 16700) {
                return income * 0.10;
            } else if (income <= 67900) {
                return 16700 * 0.10 + (income - 16700) * 0.15;
            } else if (income <= 137050) {
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (income - 67900) * 0.25;
            } else if (income <= 208850) {
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (income - 137050) * 0.28;
            } else if (income <= 372950) {
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (income - 372950) * 0.33;
            } else {
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (income - 372950) * 0.35;
            }
        } else if (status == 2) {
            if (income <= 8350) {
                return income * 0.10;
            } else if (income <= 33950) {
                return 8350 * 0.10 + (income - 8350) * 0.15;
            } else if (income <= 68525) {
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
            } else if (income <= 104425) {
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (income - 68525) * 0.28;
            } else if (income <= 186475) {
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (income - 104425) * 0.33;
            } else {
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (186475 - 104425) * 0.33 + (income - 186475) * 0.35;
            }
        } else {
            if (income <= 11950) {
                return income * 0.10;
            } else if (income <= 45500) {
                return 11950 * 0.10 + (income - 11950) * 0.15;
            } else if (income <= 117450) {
                return 11950 * 0.10 + (45500 - 11950) * 0.15 + (income - 45500) * 0.25;
            } else if (income <= 190200) {
                return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (income - 117450) * 0.28;
            } else if (income <= 372950) {
                return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (income - 190200) * 0.33;
            } else {
                return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (372950 - 190200) * 0.33 + (income - 372950) * 0.35;
            }
        }
    }

    //6.16
    private static void printNumberOfDaysInYear() {
        for (int i = 2000; i <= 2020; i++) {
            System.out.println("There are " + numberOfDaysInAYear(i) + " in " + i);
        }
    }

    public static int numberOfDaysInAYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        } else {
            return 365;
        }
    }

    //6.17
    private static void printMatrix() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((int) (Math.random() + 0.5) + " ");
            }
            System.out.println();
        }
    }

    //6.18
    private static void checkPassword() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter password: ");
        String password = input.nextLine();

        if (password.length() < 8) {
            System.out.println("Invalid password");
        } else {
            boolean isValid = true;
            int numberOfDigits = 0;
            for (int i = 0; i <= password.length() - 1; i++) {
                if (!Character.isDigit(password.charAt(i)) && !Character.isAlphabetic(password.charAt(i))) {
                    isValid = false;
                }

                if (Character.isDigit(password.charAt(i))) {
                    numberOfDigits++;
                }
            }

            System.out.println(!isValid || numberOfDigits < 2 ? "Invalid password" : "Valid Password");
        }
    }

    //6.19
    private static void triangles() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 3 sides of a triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        if (isValid(side1, side2, side3)) {
            System.out.println("Area of the triangle: " + area(side1, side2, side3));
        } else {
            System.out.println("Input is invalid");
        }
    }

    public static boolean isValid(double side1, double side2, double side3) {
        return (side1 + side2) > side3 || (side1 + side3) > side2 || (side2 + side3 > side1);
    }

    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2.0;

        double beforeSquareRoot = s * (s - side1) * (s - side2) * (s - side3);
        return Math.pow(beforeSquareRoot, 0.5);
    }

    //6.20
    private static void countLetters() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string: ");
        String s = input.nextLine();

        int numberOfLetters = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                numberOfLetters++;
            }
        }

        System.out.println(numberOfLetters);
    }

    //6.21
    private static void phoneKeypads() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string: ");
        String s = input.nextLine();

        String returnString = "";
        for (int i = 0; i <= s.length() - 1; i++) {
            char character = s.charAt(i);

            if (Character.isAlphabetic(character)) {
                int num = getNumber(Character.toUpperCase(character));

                if (num == 0) {
                    returnString = "Invalid Input";
                    break;
                } else {
                    returnString += num;
                }
            } else {
                if (!Character.isDigit(character) && character != '-') {
                    returnString = "Invalid Input";
                    break;
                } else {
                    returnString += character;
                }
            }
        }

        System.out.println(returnString);
    }

    private static int getNumber(char letter) {
        return switch (letter) {
            case 'A', 'B', 'C' -> 2;
            case 'D', 'E', 'F' -> 3;
            case 'G', 'H', 'I' -> 4;
            case 'J', 'K', 'L' -> 5;
            case 'M', 'N', 'O' -> 6;
            case 'P', 'Q', 'R', 'S' -> 7;
            case 'T', 'U', 'V' -> 8;
            case 'W', 'X', 'Y', 'Z' -> 9;
            default -> 0;
        };
    }

    private static void approximateTheSquareRoot() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number: ");
        double num = input.nextDouble();

        double lastGuess = 1 + (Math.random() * (num / 2));

        while (true) {
            double nextGuess = (lastGuess + num / lastGuess) / 2;

            if (lastGuess - nextGuess <= 0.0001) {
                lastGuess = nextGuess;
                break;
            } else {
                lastGuess = nextGuess;
            }
        }

        System.out.println(lastGuess);
    }

    //6.23
    private static void specifiedCharacter() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string: ");
        String s = input.nextLine();

        System.out.println("Enter a character: ");
        char c = input.next().charAt(0);

        System.out.println("The letter " + c + " appears " + count(s, c));
    }

    public static int count(String str, char a) {
        int o = 0;

        for (int i = 0; i <= str.length() - 1; i++) {
            if (a == str.charAt(i)) {
                o++;
            }
        }

        return o;
    }

    //6.24
    private static void displayCurrentDateTime() {
        //same as 6.33
    }

    private static boolean isLeapYear(int year) {
       return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    //6.25
    private static void convertMilliseconds() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number: ");
        long ms = input.nextLong();

        System.out.println(convertMillis(ms));
    }

    public static String convertMillis(long millis) {
        long totalSeconds = millis / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours < 24 ? totalHours % 24 : totalHours;

        return currentHour + ":" + currentMinute + ":" + currentSecond;
    }

    //6.26
    private static void palindromicPrime() {
        int numberOfPrimes = 0;
        int currentNum = 2;
        int numPerLines = 0;

        while (numberOfPrimes != 100) {
            String numString = "";
            if (isPrime(currentNum)) {
                if (numPerLines == 10) {
                    numPerLines = 0;
                    System.out.println();
                }

                int n = currentNum;

                while (n > 0) {
                    numString += n % 10;
                    n = n / 10;
                }

                if (Integer.parseInt(numString) == currentNum) {
                    System.out.print(currentNum + " ");
                    numberOfPrimes++;
                    numPerLines++;
                }

            }
            currentNum++;
        }
    }

    //6.27
    private static void emirp() {
        int numberOfEmirps = 0;
        int currentNum = 2;
        int numPerLines = 0;

        while (numberOfEmirps != 100) {
            String numString = "";
            if (isPrime(currentNum)) {
                if (numPerLines == 10) {
                    numPerLines = 0;
                    System.out.println();
                }

                int n = currentNum;

                while (n > 0) {
                    numString += n % 10;
                    n = n / 10;
                }

                if (Integer.parseInt(numString) != currentNum && isPrime(Integer.parseInt(numString))) {
                    System.out.print(currentNum + " ");
                    numberOfEmirps++;
                    numPerLines++;
                }

            }
            currentNum++;
        }
    }

    private static void mersennePrime() {
        System.out.println("p                   2^p-1");
        System.out.println("-------------------------");

        for (int i = 2; i <= 31; i++) {
            if (isPrime(i)) {
                int p = (int) Math.pow(2, i) - 1;

                if (isPrime(p)) {
                    System.out.println(i + "                       " + p);
                }
            }
        }
    }

    //6.29
    private static void twinPrimes() {
        int prime = 2;

        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                if (i - prime == 2) {
                    System.out.println("(" + prime + "," + i + ")");
                }
                prime = i;
            }
        }
    }

    //6.30
    private static void craps() {
        int points = 0;

        while (true) {
            int dice1 = 1 + (int) (Math.random() * 6);
            int dice2 = 1 + (int) (Math.random() * 6);

            int summed = dice1 + dice2;

            if (points == 0 & (summed == 2 || summed == 3 || summed == 12)) {
                System.out.println("You rolled " + dice1 + " + " + dice2);
                System.out.println("You lose");
                break;
            } else if (points == 0 && (summed == 7 || summed == 11)) {
                System.out.println("You rolled " + dice1 + " + " + dice2);
                System.out.println("You win");
                break;
            } else if (points != 0 && summed == 7) {
                System.out.println("You rolled " + dice1 + " + " + dice2);
                System.out.println("You lose");
                break;
            } else if (points == summed) {
                System.out.println("You rolled " + dice1 + " + " + dice2);
                System.out.println("You win");
                break;
            } else {
                points = summed;
                System.out.println("You rolled " + dice1 + " + " + dice2);
                System.out.println("Point is " + summed);
            }
        }
    }

    //6.31
    private static void creditCardValidation() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a credit card number (must be between 13 and 16 digits long): ");
        String creditCard = input.nextLine();

        if (isValid(creditCard)) {
            System.out.println(creditCard + " is valid");
        } else {
            System.out.println(creditCard + " is invalid");
        }
    }

    /**
     * Return true if the card number is valid
     */
    public static boolean isValid(String number) {
        int length = getSize(number);
        if (length < 13 || length > 16) {
            return false;
        }

        int sumOfDigs = getSumOfDigs(number);
        if (sumOfDigs % 10 != 0) {
            return false;
        }

        return prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6);
    }

    public static int getSumOfDigs(String number) {
        int sumOfEvenDigits = 0;
        int sumOfOddDigits = 0;
        boolean isSecondDigit = false;

        for (int i = number.length() - 1; i >= 0; i--) {
            int dig = Character.getNumericValue(number.charAt(i));
            if (isSecondDigit) {
                int doubled = dig * 2;

                if (doubled > 9) {
                    int num1 = doubled % 10;
                    sumOfEvenDigits += (num1 + (doubled / 10));
                } else {
                    sumOfEvenDigits += doubled;
                }
                isSecondDigit = false;
            } else {
                sumOfOddDigits += dig;
                isSecondDigit = true;
            }
        }

        return sumOfEvenDigits + sumOfOddDigits;
    }


    /**
     * Return true if the number d is a prefix for number
     */
    public static boolean prefixMatched(String number, int d) {
        int prefix;
        if (d < 10) {
            prefix = (int) getPrefix(number, 1);
        } else {
            prefix = (int) getPrefix(number, 2);
        }

        return prefix == d;
    }

    /**
     * Return the number of digits in d
     */
    public static int getSize(String d) {
        return d.length();
    }

    /**
     * Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number.
     */
    public static long getPrefix(String number, int k) {
        if (number.length() < k) {
            return Long.parseLong(number);
        } else {
            return Long.parseLong(number.substring(0, k));
        }

    }

    //6.32
    private static void chanceOfWinningAtCraps() {
        int numOfWins = 0;
        int points = 0;

        for (int i = 1; i <= 10000; i++) {
            int dice1 = 1 + (int) (Math.random() * 6);
            int dice2 = 1 + (int) (Math.random() * 6);

            int summed = dice1 + dice2;

            if (points == 0 && (summed == 7 || summed == 11)) {
                numOfWins++;
            } else if (points != 0 && summed == 7) {
                points = 0;
            } else if (points == summed) {
                numOfWins++;
                points = 0;
            } else {
                points = summed;
            }
        }

        System.out.println(numOfWins);
    }

    //6.33
    private static void currentDateTime() {
        long totalMilliseconds = System.currentTimeMillis();

        long totalSeconds = totalMilliseconds / 1000;

        long currentSecond = totalSeconds % 60;

        long totalMinutes = totalSeconds / 60;

        long currentMinute = totalMinutes % 60;

        long totalHours = totalMinutes / 60;

        long currentHour = totalHours % 24;

        long totalDays = totalHours / 24;

        long totalWeeks = totalDays / 7;

        long totalYears =  totalWeeks / 52;

        long currentYear = 1970 + totalYears;

        long numberOfDaysUntilThisYear  = 0;

        for (int i=1970; i < currentYear; i++) {
            if (isLeapYear(i))
                numberOfDaysUntilThisYear = numberOfDaysUntilThisYear + 366;
            else
                numberOfDaysUntilThisYear = numberOfDaysUntilThisYear + 365;
        }

        long numberOfDaysThisYear = totalDays - numberOfDaysUntilThisYear;

        long currentMonth = numberOfDaysThisYear / 12;
        long currentDateInMonth = currentMonth % 7;

        String month = getMonthName((int) currentMonth);

        System.out.println("Current date and time is " + month + " " + currentDateInMonth + ", " + currentYear + " " +
                currentHour + ":" + currentMinute + ":" + (currentSecond < 10 ? "0" + currentSecond : currentSecond));
    }

    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December";
        }

        return monthName;
    }

    //6.34
    private static void printCalendar() {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter year
        System.out.print("Enter full year (e.g., 2001): ");
        int year = input.nextInt();

        // Prompt the user to enter month
        System.out.print("Enter month in number between 1 and 12: ");
        int month = input.nextInt();

        // Print calendar for the month of the year
        printMonth(year, month);
    }

    /** Print the calendar for a month in a year */
    public static void printMonth(int year, int month) {
        // Print the headings of the calendar
        printMonthTitle(year, month);

        // Print the body of the calendar
        printMonthBody(year, month);
    }

    /** Print the month title, e.g., May, 1999 */
    public static void printMonthTitle(int year, int month) {
        System.out.println("         " + getMonthName(month)
                + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /** Print month body */
    public static void printMonthBody(int year, int month) {
        // Get start day of the week for the first date in the month
        int startDay = getStartDay(year, month, 1);

        // Get number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

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

    /** Get the start day of month/1/year */
    public static int getStartDay(int year, int month, int dayOfMOnth) {
        if (month == 1 || month == 2) {
            month = month == 1 ? 13 : 14;
            --year;
        }

        int k = year % 100;
        int j = year / 100;

        int dayOfTheWeek = (dayOfMOnth + (26 * (month + 1)) / 10 + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        return (dayOfTheWeek + 6) % 7;
    }

    private static String getDay21(int day) {
        return switch (day) {
            case 0 -> "Saturday";
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            default -> "";
        };
    }

    /** Get the number of days in a month */
    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;

        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0; // If month is incorrect
    }

    //6.35
    private static void areaOfPentagon() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the side of a pentagon: ");
        int side = input.nextInt();
        System.out.println(area(side));
    }

    public static double area(double side) {
        return (5 * (side * side)) / (4 * Math.tan(Math.PI / 5));
    }

    //6.36
    private static void areaOfRegularPolygon() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of sides: ");
        int numberofSides = input.nextInt();

        System.out.println("Enter the side: ");
        double side = input.nextDouble();

        System.out.println(area(numberofSides, side));
    }

    public static double area(int n, double side) {
        return (n * (side * side)) / (4 * Math.tan(Math.PI / n));
    }

    //6.37
    public static void formatInteger(int number, int width) {
        String n = String.valueOf(number);

        if (n.length() >= width) {
            System.out.println(n);
        } else {
            int numberOf0ToAdd = width - n.length();

            String returnString = "";

            for (int i=1; i<= numberOf0ToAdd; i++) {
                returnString += "0";
            }

            returnString += n;

            System.out.println(returnString);
        }
    }

    //6.38
    private static void generateRandomChars() {
        int charsPerLine = 0;

        for (int i=1; i<= 100; i++) {
            if (charsPerLine == 50) {
                System.out.println();
                charsPerLine = 0;
            }
            System.out.print(getRandomCharacter('A', 'Z') + " ");
            charsPerLine++;
        }

        System.out.println();
        charsPerLine = 0;

        for (int i=1; i<= 100; i++) {
            if (charsPerLine == 50) {
                System.out.println();
                charsPerLine = 0;
            }
            System.out.print(getRandomCharacter('0', '9') + " ");
            charsPerLine++;
        }
    }

    public static char getRandomCharacter(char ch1, char ch2) {
        return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    //6.39
    private static void pointPosition() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter three points for p0, p1, and p2: ");
        double x0 = input.nextDouble();
        double y0 = input.nextDouble();
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        boolean isLeft = leftOfTheLine(x0, y0, x1, y1, x2, y2);;
        boolean isOnTheSameLIne = onTheSameLine(x0, y0, x1, y1, x2, y2);
        boolean isOnTheLineSegment = onTheLineSegment(x0, y0, x1, y1, x2, y2);

        if (isLeft) {
            System.out.println("(" + x2 + ", " + y2 + ") is on the left side of the line from " + "(" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
        } else if (isOnTheLineSegment) {
            System.out.println("(" + x2 + ", " + y2 + ") is on the line segment from " + "(" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
        } else if (isOnTheSameLIne) {
            System.out.println("(" + x2 + ", " + y2 + ") is on the same line from " + "(" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
        }  else {
            System.out.println("(" + x2 + ", " + y2 + ") is on the right side of the line from " + "(" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
        }
    }

    /** Return true if point (x2, y2) is on the left side of the
     * directed line from (x0, y0) to (x1, y1) */
    public static boolean leftOfTheLine(double x0, double y0,
                                        double x1, double y1, double x2, double y2) {
        double position = getPosition(x0, y0, x1, y1, x2, y2);
        return position > 0.0;
    }

    /** Return true if point (x2, y2) is on the same
     * line from (x0, y0) to (x1, y1) */
    public static boolean onTheSameLine(double x0, double y0,
                                        double x1, double y1, double x2, double y2) {
        double position = getPosition(x0, y0, x1, y1, x2, y2);
        return position == 0.0;
    }
    /** Return true if point (x2, y2) is on the
     * line segment from (x0, y0) to (x1, y1) */
    public static boolean onTheLineSegment(double x0, double y0,
                                           double x1, double y1, double x2, double y2) {
        double position = getPosition(x0, y0, x1, y1, x2, y2);
        return (!(position < 0.0) && !(position > 0.0)) && (x2 <= x1 && x2 >= x0);
    }

    private static double getPosition(double x0, double y0,
                                      double x1, double y1, double x2, double y2) {
      return  (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
    }

}