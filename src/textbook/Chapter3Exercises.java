package textbook;

import java.util.Scanner;

public class Chapter3Exercises {
    public static void main(String[] args) {
//        checkIfLeapYear();
//        solveQuadraticEquation();
//        addThreeNumbers();
//        solveLinearEquations();
//        randomMonth();
//        findFutureDates();
//        healthApplication();
//        financialApplication();
//        sortThreeIntegers();
//        isbn();
//        additionQuiz();
//        numberOfDaysInAMonth();
//        palindromeInteger();
//        headsOrTails();
//        lottery();
//        rockPaperScissors();
//        costOfShipping();
//        perimeterOfTriange();
        windChill();
    }

    private static void checkIfLeapYear() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Check if the year is a leap year
        boolean isLeapYear =
                (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Display the result
        System.out.println(year + " is a leap year? " + isLeapYear);
    }

    //3.1
    private static void solveQuadraticEquation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double x = b * b - (4 * a * c);

        if (x > 0) {
            double r1 = (-b + Math.pow(x, 0.5)) / 2 * a;
            double r2 = (-b - Math.pow(x, 0.5)) / 2 * a;

            System.out.println("The equation has two roots " + r1 + " and " + r2);
        } else if (x == 0) {
            double r1 = (-b + Math.pow(x, 0.5)) / 2 * a;
            System.out.println("The equation has one root " + r1);
        } else {
            System.out.println("The equation has no real roots");
        }
    }

    //3.2
    private static void addThreeNumbers() {
        int number1 = (int) (System.currentTimeMillis() % 10);
        int number2 = (int) (System.currentTimeMillis() / 10 % 10);
        int number3 = (int) (System.currentTimeMillis() / 100 % 10);

        Scanner input = new Scanner(System.in);
        System.out.println("What is " + number1 + " + " + number2 + " + " + number3 + " ? ");

        int answer = input.nextInt();

        System.out.println(number1 + " + " + number2 + " + " + number3 + " = " + answer + " is " + (number1 + number2 + number3 == answer));
    }

    //3.3
    private static void solveLinearEquations() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c, d, e, f: ");

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();

        double adbc = a * d - b * c;

        if (adbc == 0) {
            System.out.println("The equation has no solution");
        } else {
            double x = (e * d - b * f) / adbc;
            double y = (a * f - e * c) / adbc;

            System.out.println("x is " + x + " and y is " + y);
        }
    }

    //3.4
    private static void randomMonth() {
        int randomInteger = (int) (Math.random() * 12) + 1;

        switch (randomInteger) {
            case 1:
                System.out.println("random integer " + randomInteger + " is January");
                break;
            case 2:
                System.out.println("random integer " + randomInteger + " is February");
                break;
            case 3:
                System.out.println("random integer " + randomInteger + " is March");
                break;
            case 4:
                System.out.println("random integer " + randomInteger + " is April");
                break;
            case 5:
                System.out.println("random integer " + randomInteger + " is May");
                break;
            case 6:
                System.out.println("random integer " + randomInteger + " is June");
                break;
            case 7:
                System.out.println("random integer " + randomInteger + " is July");
                break;
            case 8:
                System.out.println("random integer " + randomInteger + " is August");
                break;
            case 9:
                System.out.println("random integer " + randomInteger + " is September");
                break;
            case 10:
                System.out.println("random integer " + randomInteger + " is October");
                break;
            case 11:
                System.out.println("random integer " + randomInteger + " is November");
                break;
            case 12:
                System.out.println("random integer " + randomInteger + " is December");
                break;
        }
    }

    //3.5
    private static void findFutureDates() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter today’s day:");
        int today = input.nextInt();
        String todayString = getDay(today);

        System.out.println("Enter the number of days elapsed since today:");
        int nextDay = input.nextInt();

        int calculatedNextDay = (today + nextDay) % 7;

        String nextDayString = getDay(calculatedNextDay);

        System.out.println("Today is " + todayString + " and the future day is " + nextDayString);
    }

    private static String getDay(int day) {
        return switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tueday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "";
        };
    }

    //3.6
    private static void healthApplication() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        double weight = input.nextDouble();

        System.out.print("Enter feet: ");
        double feet = input.nextDouble();

        System.out.print("Enter inches: ");
        double inches = input.nextDouble();

        final double KILOGRAMS_PER_POUND = 0.45359237;
        final double METERS_PER_INCH = 0.0254;
        final double FEET_IN_INCHES = 12;

        double heightInInches = feet * FEET_IN_INCHES + inches;

        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double heightInMeters = heightInInches * METERS_PER_INCH;

        double bmi = weightInKilograms / (heightInMeters * heightInMeters);

        System.out.println("BMI is " + bmi);

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }

    //3.7
    private static void financialApplication() {
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
        if (numberOfOneDollars > 0) {
            System.out.println(" " + numberOfOneDollars + (numberOfOneDollars > 1 ? " dollars" : " dollar"));
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

    //3.8
    private static void sortThreeIntegers() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter three integers: ");

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        int lowest;
        int middle;
        int highest;

        lowest = a < b && a < c ? a : b < a && b < c ? b : c;
        highest = a > b && a > c ? a : b > a && b > c ? b : c;
        middle = lowest != a && highest != a ? a : lowest != b && highest != b ? b : c;

        System.out.println(lowest + ", " + middle + ", " + highest);
    }

    //3.9
    private static void isbn() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first 9 digits of an ISBN as integer: ");

        int isbn = input.nextInt();

        int ninthDigit = isbn % 10;

        int isbn8 = isbn / 10;
        int eigthDigit = isbn8 % 10;

        int isbn7 = isbn8 / 10;
        int seventhDigit = isbn7 % 10;

        int isbn6 = isbn7 / 10;
        int sixthDigit = isbn6 % 10;

        int isbn5 = isbn6 / 10;
        int fifthDigit = isbn5 % 10;

        int isbn4 = isbn5 / 10;
        int fourthDigit = isbn4 % 10;

        int isbn3 = isbn4 / 10;
        int thirdDigit = isbn3 % 10;

        int isbn2 = isbn3 / 10;
        int secondDigit = isbn2 % 10;

        int firstDigit = isbn2 / 10;

        int checkSum = (firstDigit + secondDigit * 2 + thirdDigit * 3 + fourthDigit * 4 + fifthDigit * 5 + sixthDigit * 6 + seventhDigit * 7 + eigthDigit * 8 + ninthDigit * 9) % 11;

        if (checkSum == 10) {
            System.out.println("The ISBN-10 number is " + isbn + "X");
        } else {
            System.out.println("The ISBN-10 number is " + isbn + "" + checkSum);
        }
    }

    //3.10
    private static void additionQuiz() {
        int number1 = (int) (Math.random() * 100);
        int number2 = (int) (Math.random() * 100);

        System.out.println("What is " + number1 + " + " + number2 + "? ");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        if (number1 + number2 == answer) {
            System.out.println("You are correct!");
        } else {
            System.out.println("Your answer is wrong.");
            System.out.println(number1 + " + " + number2 + " should be " + (number1 + number2));
        }
    }

    //3.11
    private static void numberOfDaysInAMonth() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the month as a digit: ");
        int month = input.nextInt();

        System.out.println("Enter the year as a digit: ");
        int year = input.nextInt();

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (month == 2 && isLeapYear) {
            System.out.println("February " + year + " has 29 days");
        } else {
            int numberOfDays = month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ? 31 :
                    month == 4 || month == 6 || month == 9 || month == 11 ? 30 : 28;

            System.out.println(getMonth(month) + " " + year + " has " + numberOfDays + " days");
        }
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

    //3.12
    private static void palindromeInteger() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a three-digit integer:");
        int integer = input.nextInt();

        if (integer / 100 == integer % 10) {
            System.out.println(integer + " is a palindrome");
        } else {
            System.out.println(integer + " is not a palindrome");
        }
    }

    //3.12
    private static void computeTaxes() {
        Scanner input = new Scanner(System.in);
        System.out.print("(0-single filer, 1-married jointly or " +
                "qualifying widow(er), 2-married separately, 3-head of " +
                "household) Enter the filing status: ");

        int status = input.nextInt();

        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();

        double tax = 0;

        if (status == 0) { // Compute tax for single filers
            if (income <= 8350) {
                tax = income * 0.10;
            } else if (income <= 33950) {
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            } else if (income <= 82250) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
            } else if (income <= 171550) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
            } else if (income <= 372950) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (income - 171550) * 0.33;
            } else {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
            }
        } else if (status == 1) {
            if (income <= 16700) {
                tax = income * 0.10;
            } else if (income <= 67900) {
                tax = 16700 * 0.10 + (income - 16700) * 0.15;
            } else if (income <= 137050) {
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (income - 67900) * 0.25;
            } else if (income <= 208850) {
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 33950) * 0.25 + (income - 82250) * 0.28;
            } else if (income <= 372950) {
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (income - 171550) * 0.33;
            } else {
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
            }
        }
    }

    //3.14
    private static void headsOrTails() {
        int randomInt = (int) (Math.random() * 10);

        Scanner input = new Scanner(System.in);
        System.out.println("Guess whether heads or tails: ");
        int guess = input.nextInt();

        boolean heads = randomInt == 1;

        System.out.println(randomInt == guess ? "Correct " + randomInt + " is " + (heads ? " heads" : " tails") : "incorrect " + randomInt + " is " + (heads ? " heads" : " tails"));
    }


    //3.15
    private static void lottery() {
        int lottery = (int) (Math.random() * 1000) + 100;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick (three digits): ");
        int guess = input.nextInt();

        int lotteryDigit1 = lottery % 10;
        int lotteryDigit2 = (lottery / 10) % 10;
        int lotteryDigit3 = (lottery / 100) % 10;

        int guessDigit1 = guess % 10;
        int guessDigit2 = (guess / 10) % 10;
        int guessDigit3 = (guess / 100) % 10;

        System.out.println("The lottery number is " + lottery);

        if (guess == lottery) {
            System.out.println("Exact match: you win $10,000");
        } else if ((guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit2 && guessDigit3 == lotteryDigit3) ||
                (guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit2 && guessDigit3 == lotteryDigit3) ||
                (guessDigit1 == lotteryDigit3 && guessDigit2 == lotteryDigit2 && guessDigit3 == lotteryDigit3) ||
                (guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit3) ||
                (guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit3 && guessDigit3 == lotteryDigit3) ||
                (guessDigit1 == lotteryDigit3 && guessDigit2 == lotteryDigit2 && guessDigit3 == lotteryDigit1) ||
                (guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit2)) {
            System.out.println("Match all digits: you win $3,000");
        } else if (guessDigit1 == lotteryDigit1 || guessDigit1 == lotteryDigit2 || guessDigit1 == lotteryDigit3 ||
                guessDigit2 == lotteryDigit1 || guessDigit2 == lotteryDigit2 || guessDigit2 == lotteryDigit3 ||
                guessDigit3 == lotteryDigit1 || guessDigit3 == lotteryDigit2 || guessDigit3 == lotteryDigit3) {
            System.out.println("Match one digit: you win $1,000");
        } else {
            System.out.println("Sorry, no match");
        }
    }

    //3.16
    private static void randomPoint() {
        double x = Math.random() * 100 - 50;
        double y = Math.random() * 200 - 100;

        System.out.println(x + ", " + y);
    }

    //3.17
    private static void rockPaperScissors() {
        int random = (int) (Math.random() * 3);

        Scanner input = new Scanner(System.in);
        System.out.println("paper (0), scissors (1), rock (2):");

        int user = input.nextInt();

        if (random == user) {
            System.out.println("The computer is " + getGuess(random) + ". You are " + getGuess(user) + " too. It is a draw");
        } else if (random < user && (random != 0 && user != 2)) {
            System.out.println("The computer is " + getGuess(random) + ". You are " + getGuess(user) + " You won");
        } else if (user < random && (user != 0 && random != 2)){
            System.out.println("The computer is " + getGuess(random) + ". You are " + getGuess(user) + "  Computer won");
        } else if (random == 0 && user == 2) {
            System.out.println("The computer is " + getGuess(random) + ". You are " + getGuess(user) + " Computer won");
        } else {
            System.out.println("The computer is " + getGuess(random) + ". You are " + getGuess(user) + "  You won");
        }
    }

    private static String getGuess(int guess) {
        return switch(guess) {
            case 0 -> "paper";
            case 1 -> "scissors";
            case 2 -> "rock";
            default -> "";
        };
    }

    //3.18
    private static void costOfShipping() {
        Scanner input = new Scanner(System.in);

        System.out.println("Input the weight of the package");
        double weight = input.nextDouble();

        if (weight > 0.0 && weight <= 1.0) {
         System.out.println("Shipping cost is 3.5");
        } else if (weight > 1.0 && weight <= 3.0) {
            System.out.println("Shipping cost is 5.5");
        } else if (weight > 3.0 && weight <= 10.0) {
            System.out.println("Shipping cost is 8.5");
        } else if (weight > 10.5 && weight <= 20) {
            System.out.println("Shipping cost is 20");
        } else if (weight > 20.0){
            System.out.println("The package cannot be shipped.");
        } else {
            System.out.println("invalid input");
        }
    }

    //3.19
    private static void perimeterOfTriange() {
        Scanner input = new Scanner(System.in);

        System.out.println("Input the three edges of a triangle: ");
        int edge1 = input.nextInt();
        int edge2 = input.nextInt();
        int edge3 = input.nextInt();

        if ((edge1 + edge2 > edge3) && (edge2 + edge3 > edge1) && (edge1 + edge3 > edge2)) {
            System.out.println("Perimeter is " + (edge1 + edge2 + edge3));
        } else {
            System.out.println("Input is invalid");
        }
    }

    //3.20
    private static void windChill() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = input.nextDouble();

        System.out.print("Enter the wind speed (>= 2) in miles per hour: ");
        double windSpeed = input.nextDouble();

        if (temperature < -58 || temperature > 41) {
            System.out.print("Temperature " + temperature + " is invalid");
        } else if (windSpeed < 2) {
            System.out.print("Windspeed " + windSpeed + " is invalid");
        } else {
            double windChill = 35.74 + (0.6215 * temperature) - (35.75 * Math.pow(windSpeed, 0.16)) + 0.4275 * (temperature * Math.pow(windSpeed, 0.16));

            System.out.println("The wind chill index is  " + windChill);
        }
    }
}

