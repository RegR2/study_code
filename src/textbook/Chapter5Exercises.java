package textbook;

import java.lang.management.MemoryType;
import java.util.Arrays;
import java.util.Scanner;

public class Chapter5Exercises {
    public static void main(String[] args) {
//        positiveAndNegativeNumbers();
//        repeatAdditions();
//        kgToPounds();
//        milesToKilometers();
//        kgToPoundDoubleTable();
//        kmToMilesDoubleTable();
//        universityTuition();
//        highestScore();
//        twoHighestScores();
//        numbersDivisbleBy5And6();
//        numbersDivisbleBy5And6NotBoth();
//        smallestN();
//        largestN();
//        greatestCommonDivisor();
//        displayAscii();
//        findFactorsOfInteger();
//        displayFourPatters();
//        displayPrimeNumbers();
//        loansWithVariousInterestRates();
//        amortizationSchedule();
//        cancellationErrors();
//        sumASeries();
//        computePi();
//        computerE();
//        displayLeapYears();
//        firstDaysOfMonth();
//        displayCalendars();
//        compoundValue();
//        computerCdValue();
//        lottery();
//        perfectNumber();
//        scissorPaperRock();
//        summation();
//        checkingIsbn();
//        convertToBinary();
//        convertToOctal();
//        findTheSalesAmount();
//        headsOrTails();
//        occurenceOfMaxNumbers();
//        findSalesAmount();
//        combinations();
//        meanStandardDeviation();
//        reverseString();
//        checkIsbn13();
//        processString();
//        vowelsAndConsonants();
//        upperCase();
//        longestCommonPrefix();
//        displayPyramid();
//        dislayNumbersInPyramidPattern();
        bitLevelOperations();
    }

    //5.1
    private static void positiveAndNegativeNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an integers, the input ends if it is 0: ");
        String inputIntegers = input.nextLine();

        String[] inputArray = inputIntegers.split(" ");

        int index = 0;
        int numberOfPositives = 0;
        int numberOfNegatives = 0;
        float total = 0;

        while (index <= inputArray.length - 1) {
            if (inputArray[index].equals("0")) {
                break;
            } else {
                int number = Integer.parseInt(inputArray[index]);
                if (number < 0) {
                    numberOfNegatives++;
                } else {
                    numberOfPositives++;
                }

                total += number;
                index++;
            }
        }
        float average = total / index;

        System.out.println("The number of positives is " + numberOfPositives);
        System.out.println("The number of negatives is " + numberOfNegatives);
        System.out.println("The total is " + total);
        System.out.println("The average is " + average);
    }

    //5.2
    private static void repeatAdditions() {
        final int NUMBER_OF_QUESTIONS = 5;
        int correctCount = 0;
        int count = 0;
        long startTime = System.currentTimeMillis();
        String output = "";
        Scanner input = new Scanner(System.in);

        while (count < NUMBER_OF_QUESTIONS) {

            int number1 = (int) (Math.random() * 15) + 1;
            int number2 = (int) (Math.random() * 15) + 1;

            System.out.print(
                    "What is " + number1 + " + " + number2 + "? ");
            int answer = input.nextInt();

            if (number1 + number2 == answer) {
                System.out.println("You are correct!\n");
                correctCount++;
            } else {
                System.out.println("Your answer is wrong.\n" + number1
                        + " + " + number2 + " should be " + (number1 + number2) + "\n");
            }

            count++;

            output += "\n" + number1 + "+" + number2 + "=" + answer +
                    ((number1 + number2 == answer) ? " correct" : " wrong");
        }

        long endTime = System.currentTimeMillis();
        long testTime = endTime - startTime;

        System.out.println("Correct count is " + correctCount +
                "\nTest time is " + testTime / 1000 + " seconds\n" + output);
    }

    //5.3
    private static void kgToPounds() {
        int numberInKg = 1;

        System.out.println("Kilograms" + "   " + "Pounds");
        while (numberInKg <= 199) {
            double pounds = numberInKg * 2.2;

            System.out.println(numberInKg + "            " + pounds);
            numberInKg += 2;
        }
    }

    //5.4
    private static void milesToKilometers() {
        int numberInMiles = 1;

        System.out.println("Miles" + "   " + "Kilometers");
        while (numberInMiles <= 10) {
            double km = numberInMiles * 1.609;

            System.out.println(numberInMiles + "            " + km);
            numberInMiles += 1;
        }
    }

    //5.5
    private static void kgToPoundDoubleTable() {
        System.out.printf("%10s%10s    |  %10s%10s\n", "Kilograms", "Pounds",
                "Pounds", "Kilograms");

        int kg = 1;
        int pounds = 20;

        while (kg <= 199) {
            System.out.printf("%-10d%10.1f    |  %-10d%10.2f\n", kg, kg * 2.2,
                    pounds, pounds / 2.2);
            kg += 2;
            pounds += 5;
        }
    }

    //5.6
    private static void kmToMilesDoubleTable() {
        System.out.printf("%-10s%10s    |  %10s%10s\n", "Miles", "Kilometers",
                "Kilometers", "Miles");

        int km = 1;
        int miles = 20;

        while (km <= 10) {
            System.out.printf("%-10d%10.3f    |  %-10d%10.3f\n", km, km * 1.609,
                    miles, miles / 1.609);
            km++;
            miles += 5;
        }
    }

    //5.7
    private static void universityTuition() {
        int tuition = 10000;
        int year = 0;

        int totalAfterYear10 = 0;

        while (year <= 14) {
            tuition = (int) (tuition + tuition * 0.05);

            if (year == 10) {
                System.out.println("Tuition in 10 years is $" + tuition);
            }

            if (year < 10) {
                totalAfterYear10 += tuition;
            }

            year++;
        }

        System.out.println("Total cost of 4 years of tuition starting after 10th year is $" + totalAfterYear10);
    }

    //5.8
    private static void highestScore() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of students ");
        int numberOfStudents = input.nextInt();

        String studentName = "";
        int highestScore = 0;

        for (int i = 0; i <= numberOfStudents - 1; i++) {
            System.out.println("Enter name of student ");
            String name = input.next();
            System.out.println("Enter student's score ");
            int score = input.nextInt();

            if (score > highestScore) {
                studentName = name;
                highestScore = score;
            }
        }

        System.out.println("Highest score is " + highestScore + " by " + studentName);
    }

    // 5.9
    private static void twoHighestScores() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of students ");
        int numberOfStudents = input.nextInt();

        String studentName = "";
        int highestScore = 0;

        String secondHighestName = "";
        int secondHighestScore = 0;

        for (int i = 0; i <= numberOfStudents - 1; i++) {
            System.out.println("Enter name of student ");
            String name = input.next();
            System.out.println("Enter student's score ");
            int score = input.nextInt();

            if (score > highestScore) {
                secondHighestName = studentName;
                secondHighestScore = highestScore;

                studentName = name;
                highestScore = score;
            }
        }

        System.out.println("Highest score is " + highestScore + " by " + studentName);
        System.out.println("Second highest score is " + secondHighestScore + " by " + secondHighestName);
    }

    //5.10
    private static void numbersDivisbleBy5And6() {
        int numbersPerLine = 0;
        int number = 100;

        while (number <= 1000) {
            if (number % 5 == 0 && number % 6 == 0) {
                if (numbersPerLine == 10) {
                    System.out.println();
                    numbersPerLine = 0;
                }
                System.out.print(number + " ");
                numbersPerLine++;
            }
            number++;
        }
    }

    //5.11
    private static void numbersDivisbleBy5And6NotBoth() {
        int numbersPerLine = 0;
        int number = 100;

        while (number <= 1000) {
            if (number % 5 == 0 ^ number % 6 == 0) {
                if (numbersPerLine == 10) {
                    System.out.println();
                    numbersPerLine = 0;
                }
                System.out.print(number + " ");
                numbersPerLine++;
            }
            number++;
        }
    }


    //5.12
    private static void smallestN() {
        int n2 = 0;
        int n = 1;

        while (n2 < 12000) {
            n2 = n * n;
            n++;
        }

        System.out.println("Smallest n " + n + " with n^2 is " + n2);
    }

    //5.13
    private static void largestN() {
        int largestN3 = 0;
        int n = 1;

        while (true) {
            int n3 = n * n * n;
            if (n3 > 12000) {
                break;
            }
            largestN3 = n3;
            n++;
        }

        System.out.println("Largest n " + n + " with n^3 is " + largestN3);
    }

    //5.14
    private static void greatestCommonDivisor() {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter first integer: ");
        int n1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int n2 = input.nextInt();

        int d = Math.min(n1, n2);
        int greatestCommonDivisor = 0;

        while (d > 0) {
            if (n1 % d == 0 && n2 % d == 0) {
                greatestCommonDivisor = d;
                break;
            }
            d--;
        }

        System.out.println("The greatest common divisor for " + n1 +
                " and " + n2 + " is " + greatestCommonDivisor);
    }

    //5.15
    private static void displayAscii() {
        int numberOfChars = 0;

        for (int i = 33; i <= 126; i++) {
            if (numberOfChars == 10) {
                System.out.println();
                numberOfChars = 0;
            }

            System.out.print((char) i + " ");
            numberOfChars++;
        }
    }

    //5.16
    private static void findFactorsOfInteger() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int integer = input.nextInt();

        int divider = integer;
        int number = 2;

        String factors = "";

        while (divider > 1) {
            boolean isNumberPrime = checkPrimeNumber(number);

            if (!isNumberPrime) {
                number++;
                continue;
            }

            if (divider % number == 0) {
                factors += number + ", ";
                divider = divider / number;
            } else {
                number++;
            }
        }

        int lastIndex = factors.lastIndexOf(", ");
        System.out.println(factors.substring(0, lastIndex));
    }

    private static boolean checkPrimeNumber(int number) {
        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);

        for (int i = 3; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    //5.18
    private static void displayFourPatters() {
        System.out.println("Pattern A");
        for (int i = 0; i <= 5; i++) {
            for (int j = 1; j <= i + 1; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        System.out.println();

        System.out.println("Pattern B");
        for (int i = 5; i >= 0; i--) {
            for (int j = 1; j <= i + 1; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        System.out.println();

        System.out.println("Pattern C");
        for (int i = 1; i <= 6; i++) {
            for (int j = 6; j >= 1; j--)
                System.out.print(j <= i ? j + " " : "  ");
            System.out.println();
        }

        System.out.println();
        System.out.println("Pattern D");
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++)
                System.out.print(i <= j ? j + " " : "  ");
            System.out.println();
        }
    }

    //5.19


    //5.20
    private static void displayPrimeNumbers() {
        final int NUMBER_OF_PRIMES = 1000;
        int NUMBER_OF_PRIMES_PER_LINE = 0;
        int number = 2;

        System.out.println("The first 1000 prime numbers are \n");

        while (number < NUMBER_OF_PRIMES) {
            boolean isPrime = checkPrimeNumber(number);

            if (isPrime) {

                if (NUMBER_OF_PRIMES_PER_LINE == 8) {
                    System.out.println(number);
                    NUMBER_OF_PRIMES_PER_LINE = 0;
                } else
                    System.out.print(number + " ");
                NUMBER_OF_PRIMES_PER_LINE++;
            }

            number++;
        }
    }

    //5.21
    private static void loansWithVariousInterestRates() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter loan amount: ");
        double loan = input.nextDouble();

        System.out.println("Number of years: ");
        int years = input.nextInt();

        double annualInterestRate = 5;

        System.out.println("Interest Rate   Monthly Payment   Total Payment");

        while (annualInterestRate <= 8) {
            double monthlyInterestRate = annualInterestRate / 1200;

            double monthlyPayment = loan * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
            double totalPayment = monthlyPayment * years * 12;

            System.out.println(annualInterestRate + "%      " + monthlyPayment + "      " + totalPayment);
            annualInterestRate = annualInterestRate + 0.125;
        }
    }

    //5.22
    private static void amortizationSchedule() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter loan amount: ");
        double loan = input.nextDouble();

        System.out.println("Number of years: ");
        int years = input.nextInt();

        System.out.println("Annual interest rate: ");
        double annualInterestRate = input.nextDouble();

        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loan * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
        double totalPayment = monthlyPayment * years * 12;

        System.out.println("Monthly Payment: " + monthlyPayment);
        System.out.println("Total Payment: " + totalPayment);

        double balance = loan;

        for (int i = 1; i <= years * 12; i++) {
            double interest = monthlyInterestRate * balance;
            double principal = monthlyPayment - interest;
            balance = balance - principal;

            System.out.printf("%-15d%-15.2f%-15.2f%-15.2f\n", i, interest, principal, balance);
        }

    }

    //5.23
    private static void cancellationErrors() {
        double totalLeftToRight = 0;

        int count = 1;

        while (count <= 50000) {
            totalLeftToRight += (1.0 / count);
            count++;
        }

        System.out.println("Left to right: " + totalLeftToRight);

        double rightToLeft = 0;
        int count2 = 50000;

        while (count >= 1) {
            rightToLeft += (1.0 / count2);
            count--;
        }

        System.out.println("Right to left: " + rightToLeft);
    }

    //5.24
    private static void sumASeries() {
        double numerator = 1.0;
        int denominator = 3;

        double total = 0;

        while (numerator <= 97) {
            total += (numerator / denominator);
            numerator += 2;
            denominator += 2;
        }

        System.out.println(total);
    }

    //5.25
    private static void computePi() {

        for (int i = 10000; i <= 100000; i += 10000) {
            double pi = calculatePi(i);
            System.out.println("For i = " + i + ", pi = " + pi);
        }

    }

    private static double calculatePi(int num) {
        double pie = 0.0;

        for (int i = 1; i <= num; i++) {
            double sum = Math.pow(-1, i + 1) / (2.0 * i - 1);
            pie += sum;
        }

        return 4 * pie;
    }

    //5.26
    private static void computerE() {
        double e = 1.0;

        for (int i = 1; i <= 20; i++) {
            int factorial = 1;
            for (int j = 1; j <= i; j++) {
                factorial *= j;
            }

            e += (1.0 / factorial);
            System.out.printf("Value of e after %2d terms: %.15f%n", i, e);
        }

        System.out.println(e);
    }

    //5.27
    private static void displayLeapYears() {
        int countOnLine = 0;
        int totalLeapYears = 0;

        for (int i = 101; i <= 2100; i++) {
            boolean isLeapYear =
                    (i % 4 == 0 && i % 100 != 0) || (i % 400 == 0);

            if (isLeapYear) {
                if (countOnLine == 10) {
                    System.out.println(i + " ");
                    countOnLine = 1;
                } else {
                    System.out.print(i + " ");
                    countOnLine++;
                }
                totalLeapYears++;
            }
        }
        System.out.println();
        System.out.println("Total leap years in period " + totalLeapYears);
    }

    //5.28
    private static void firstDaysOfMonth() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the year as a digit: ");
        int year = input.nextInt();

        System.out.println("Enter the first day of the year: ");
        int dayInt = input.nextInt();

        for (int i = 1; i <= 12; i++) {
            String month = getMonth(i);
            String day = getDay(dayInt);
            System.out.println(month + " 1, " + year + " is " + day);

            int daysInMonth;
            if (i == 2) {
                boolean isLeapYear =
                        (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                daysInMonth = isLeapYear ? getNumberOfDaysInMonth(13) : getNumberOfDaysInMonth(i);
            } else {
                daysInMonth = getNumberOfDaysInMonth(i);
            }

            dayInt = (dayInt + daysInMonth) % 7;
        }
    }

    private static int getNumberOfDaysInMonth(Integer monthInt) {
        return switch (monthInt) {
            case 1 -> 31;
            case 2 -> 28;
            case 3 -> 31;
            case 4 -> 30;
            case 5 -> 31;
            case 6 -> 30;
            case 7 -> 31;
            case 8 -> 31;
            case 9 -> 30;
            case 10 -> 31;
            case 11 -> 30;
            case 12 -> 31;
            default -> 29;
        };
    }

    private static String getDay(int day) {
        return switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "";
        };
    }

    private static String getMonth(Integer monthInt) {
        return switch (monthInt) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
    }

    //5.29
    private static void displayCalendars() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the year as a digit: ");
        int year = input.nextInt();

        System.out.println("Enter the first day of the year: ");
        int dayInt = input.nextInt();

        for (int i = 1; i <= 12; i++) {
            String month = getMonth(i);

            int daysInMonth;
            if (i == 2) {
                boolean isLeapYear =
                        (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                daysInMonth = isLeapYear ? getNumberOfDaysInMonth(13) : getNumberOfDaysInMonth(i);
            } else {
                daysInMonth = getNumberOfDaysInMonth(i);
            }

            System.out.println();
            System.out.printf("%30s%n", " " + month + " " + year + " ");
            System.out.printf("%30s%n", "---------------------------------------------");
            System.out.println("Sun   Mon  Tue  Wed   Thu   Fri   Sat");

            for (int k = 0; k < dayInt; k++) {
                System.out.print("     ");
            }

            int dayOfWeek = dayInt;
            for (int j = 1; j <= daysInMonth; j++) {
                if (dayOfWeek == 7) {
                    System.out.println();
                    dayOfWeek = 0;
                }
                System.out.print(j + "     ");
                dayOfWeek++;
            }

            dayInt = (dayInt + daysInMonth) % 7;
        }
    }

    //5.30
    private static void compoundValue() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter amount: ");
        double amount = input.nextDouble();

        System.out.println("Enter annual interest: ");
        int annualInterest = input.nextInt();

        System.out.println("Number of months: ");
        int months = input.nextInt();

        double monthlyInterest = annualInterest / 1200.0;

        double amountInSavings = 0;
        for (int i = 0; i <= months - 1; i++) {
            amountInSavings = (amountInSavings + amount) * (1 + monthlyInterest);
            System.out.println("Savings after month " + i + " is " + amountInSavings);
        }
    }

    private static void computerCdValue() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the initial deposit amount: ");
        double amount = input.nextDouble();

        System.out.println("Enter annual percentage yield: ");
        double annualInterest = input.nextDouble();

        System.out.println("Enter maturity period (number of months): ");
        int months = input.nextInt();

        double amountInSavings = amount;
        System.out.println("Month        CD Value");
        for (int i = 0; i <= months - 1; i++) {
            amountInSavings = amountInSavings + amountInSavings * annualInterest / 1200;
            System.out.println(i + "      " + amountInSavings);
        }
    }

    //5.32
    private static void lottery() {
        int lotteryDigit1 = (int) (Math.random() * 10) + 1;
        int lotteryDigit2 = lotteryDigit1;

        while (lotteryDigit2 == lotteryDigit1) {
            lotteryDigit2 = (int) (Math.random() * 10) + 1;
        }

        int lottery = Integer.parseInt(lotteryDigit1 + "" + lotteryDigit2);

        // Prompt the user to enter a guess
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick (two digits): ");
        int guess = input.nextInt();

        // Get digits from guess
        int guessDigit1 = guess / 10;
        int guessDigit2 = guess % 10;

        System.out.println("The lottery number is " + lottery);

        // Check the guess
        if (guess == lottery)
            System.out.println("Exact match: you win $10,000");
        else if (guessDigit2 == lotteryDigit1
                && guessDigit1 == lotteryDigit2)
            System.out.println("Match all digits: you win $3,000");
        else if (guessDigit1 == lotteryDigit1
                || guessDigit1 == lotteryDigit2
                || guessDigit2 == lotteryDigit1
                || guessDigit2 == lotteryDigit2)
            System.out.println("Match one digit: you win $1,000");
        else
            System.out.println("Sorry, no match");
    }

    private static void perfectNumber() {
        String fourNumbers = "";
        for (int i = 1; i < 10000; i++) {
            int added = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    added += j;
                }
            }

            if (added == i) {
                fourNumbers += i + ", ";
            }
        }
        System.out.println(fourNumbers);
    }

    private static void scissorPaperRock() {
        int computerWins = 0;
        int userWins = 0;

        while (Math.abs(computerWins - userWins) < 2) {
            int random = (int) (Math.random() * 3);

            Scanner input = new Scanner(System.in);
            System.out.println("paper (0), scissors (1), rock (2):");

            int user = input.nextInt();

            if (random == user) {
            } else if (random < user && (random != 0 && user != 2)) {
                userWins++;
            } else if (user < random && (user != 0 && random != 2)) {
                computerWins++;
            } else if (random == 0 && user == 2) {
                computerWins++;
            } else {
                userWins++;
            }
        }

        if (computerWins < userWins) {
            System.out.println("You won");
        } else {
            System.out.println("Computer won");
        }
    }

    private static void summation() {
        double num1 = 624;
        double num2 = 625;

        double sum = 0;
        while (num1 >= 1) {
            sum += 1 / (Math.sqrt(num1) + Math.sqrt(num2));
            num1--;
            num2--;
        }

        System.out.println(sum);
    }

    private static void checkingIsbn() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first 9 digits of an ISBN as integer: ");

        String isbn = input.nextLine();

        int checkSum = 0;

        for (int i = 0; i <= isbn.length() - 1; i++) {
            checkSum += Integer.parseInt(isbn.charAt(i) + "") * (i + 1);
        }

        checkSum = checkSum % 11;

        if (checkSum == 10) {
            System.out.println("The ISBN-10 number is " + isbn + "X");
        } else {
            System.out.println("The ISBN-10 number is " + isbn + "" + checkSum);
        }
    }

    //5.37
    private static void convertToBinary() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number: ");
        int number = input.nextInt();

        String binary = "";
        while (number > 0) {
            binary += number % 2;
            number = number / 2;
        }

        String returnString = "";

        for (int i = binary.length() - 1; i >= 0; i--) {
            returnString += binary.charAt(i);
        }

        System.out.println(returnString);
    }

    //5.38
    private static void convertToOctal() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number: ");
        int number = input.nextInt();

        String octal = "";
        while (number > 0) {
            octal += number % 8;
            number = number / 8;
        }

        String returnString = "";

        for (int i = octal.length() - 1; i >= 0; i--) {
            returnString += octal.charAt(i);
        }

        System.out.println(returnString);
    }

    //5.39
    private static void findTheSalesAmount() {
        double baseSalary = 5000;
        double sales = 0;

        while (true) {
            double comission = 0;
            if (sales < 5000) {
                comission += sales * 0.08;
            } else if (sales < 10000) {
                comission += sales * 0.10;
            } else if (sales > 15000) {
                comission += sales * 0.12;
            }

            if (comission + baseSalary >= 30000) {
                break;
            }

            sales++;
        }

        System.out.println(sales);
    }

    //5.40
    private static void headsOrTails() {
        int heads = 0;
        int tails = 0;

        for (int i = 0; i <= 1000000; i++) {
            if (Math.random() < 0.05) {
                heads++;
            } else {
                tails++;
            }
        }

        System.out.println("Heads = " + heads + ", tails = " + tails);
    }

    //5.41
    private static void occurenceOfMaxNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter numbers: ");

        int max = 0;
        int count = 0;
        int number = input.nextInt();

        while (number != 0) {
            if (number > max) {
                max = number;
                count = 1;
            } else if (number == max) {
                count++;
            }
            number = input.nextInt();
        }

        System.out.println("The largest number is " + max);
        System.out.println("The occurrence count of the largest number is " + count);
    }

    //5.42
    private static void findSalesAmount() {
        double baseSalary = 5000;
        double sales = 0;
        double total = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter commission sought: ");
        double commissionSought = input.nextDouble();

        for (double i = sales; total < commissionSought; sales++) {
            double comission = 0;
            if (sales < 5000) {
                comission += sales * 0.08;
            } else if (sales < 10000) {
                comission += sales * 0.10;
            } else if (sales > 15000) {
                comission += sales * 0.12;
            }

            total = baseSalary + comission;
        }

        System.out.println(sales);
    }

    //5.43
    private static void combinations() {
        int totalNumber = 0;

        for (int i = 1; i <= 7; i++) {
            for (int j = i + 1; j <= 7; j++) {
                System.out.println(i + " " + j);
                totalNumber++;
            }
        }
        System.out.println("The total number of all combinations is " + totalNumber);
    }

    //5.45
    private static void meanStandardDeviation() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 numbers: ");

        double totalSummed = 0;
        double totalSummedSquared = 0;
        int count = 0;

        while (count < 10) {
            double num = input.nextDouble();
            totalSummed += num;
            totalSummedSquared += num * num;
            count++;
        }

        double mean = totalSummed / 10;

        double standardDeviation = Math.sqrt((totalSummedSquared - ((totalSummed * totalSummed) / 10)) / 9);

        System.out.println("The mean is: " + mean);
        System.out.println("The standard deviation is: " + standardDeviation);
    }

    //5.46
    private static void reverseString() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter string: ");
        String str = input.nextLine();

        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("The reversed string is: " + reversed);
    }

    //5.47
    private static void checkIsbn13() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first 12 digits of an ISBN-13 as a string: ");
        String str = input.nextLine();

        if (str.length() != 12) {
            System.out.println(str + " is an invalid input");
        } else {
            int summed = 0;

            for (int i = 0; i <= str.length() - 1; i++) {
                if (i % 2 == 0) {
                    summed += 3 * Character.getNumericValue(str.charAt(i));
                } else {
                    summed += Character.getNumericValue(str.charAt(i));
                }
            }

            int checkSum = 10 - (summed % 10);

            String isbn13 = str;

            if (checkSum == 10) {
                isbn13 += 0;
            } else {
                isbn13 += checkSum;
            }

            System.out.println("The ISBN-13 number is " + isbn13);
        }
    }

    //5.48
    private static void processString() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = input.nextLine();

        String returnString = "";

        for (int i = 1; i <= str.length(); i++) {
            if (i % 2 != 0) {
                returnString += str.charAt(i - 1);
            }
        }

        System.out.println(returnString);
    }

    //5.49
    private static void vowelsAndConsonants() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = input.nextLine();

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i <= str.length() - 1; i++) {
            String letter = "" + str.charAt(i);
            if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i") ||
                    letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")) {
                vowels++;
            } else if (letter.equals(" ")) {
                continue;
            } else {
                consonants++;
            }
        }

        System.out.println("The number of vowels is " + vowels);
        System.out.println("The number of consonants is " + consonants);
    }

    //5.50
    private static void upperCase() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = input.nextLine();

        int numberOfUppercase = 0;

        for (int i = 0; i <= str.length() - 1; i++) {
            int letter = str.charAt(i);

            if (letter >= 65 && letter <= 90) {
                numberOfUppercase++;
            }
        }

        System.out.println("The number of uppercase letters is " + numberOfUppercase);
    }

    //5.51
    private static void longestCommonPrefix() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first string: ");
        String string1 = input.nextLine();

        System.out.println("Enter the second string: ");
        String string2 = input.nextLine();

        String longestCommonPrefix = "";
        String commonPrefix = "";

        for (int i = 0; i <= string1.length() - 1; i++) {
            if (string1.charAt(i) == string2.charAt(i)) {
                commonPrefix += string1.charAt(i);
            } else {
                if (commonPrefix.length() > longestCommonPrefix.length()) {
                    longestCommonPrefix = commonPrefix;
                }
                commonPrefix = "";
            }
        }

        System.out.println(!longestCommonPrefix.isEmpty() ? "The common prefix is " + longestCommonPrefix : string1 + " and " + string2 + " have no common prefix");
    }


    //5.17
    private static void displayPyramid() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lines: ");
        int lines = input.nextInt();

        int intCount = 0;

        while (intCount < lines) {
            System.out.printf("%" + (lines * 2 - ((intCount - 1) * 2)) + "s", " ");
            int numDesc = intCount + 1;
            while (numDesc >= 1) {
                System.out.print(numDesc + " ");
                numDesc--;
            }

            int intCountAsc = 2;
            while (intCountAsc <= intCount + 1) {
                System.out.print(intCountAsc + " ");
                intCountAsc++;
            }

            intCount++;
            System.out.println();
        }
    }

    //5.19
    private static void dislayNumbersInPyramidPattern() {
        for (int i = 1; i <= 128; i *= 2) {
            double log = ((Math.log10(i) / Math.log10(2)) + (Math.log10(i / 2.0) / Math.log10(2))); //to get the amount of times 2 can be divided into i on both sides of the pyramid
            double lines = 128 - log * 2;
            System.out.printf("%" + lines + "s", "  ");

            for (int j = 2; j <= i * 2; j *= 2) {
                if (j == i * 2 && i >= 32) {
                    System.out.print(j / 2 + "  ");
                } else if (j / 2 == 64 && j != i * 2) {
                    System.out.print(j / 2 + " ");
                } else if (j / 2 >= 8 && j != i * 2) {
                    System.out.print(j / 2 + "  ");
                } else {
                    System.out.print(j / 2 + "   ");
                }
            }

            for (int k = (i * 2) / 2; k >= 2; k /= 2) {
                if (k / 2 >= 32) {
                    System.out.print(k / 2 + "  ");
                } else {
                    System.out.print(k / 2 + "   ");
                }
            }

            System.out.println();
        }
    }


    //5.44
    private static void bitLevelOperations() {
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Enter an integer: ");
//        int number = input.nextInt();
//
//        int bits = number >> 1;
//
//        System.out.println(bits & 1);
    }

}
