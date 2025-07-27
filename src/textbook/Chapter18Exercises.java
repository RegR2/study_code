package textbook;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chapter18Exercises {
    public static int numberOfMoves = 0;
    public static String hex2Bin = "";

    public static void main(String[] args) {
//        factorial();
//        fibonacci();
//        gcd();
//        sumSeriesOne();
//        sumSeriesTwo();
//        sumSeriesThree();
//        fibonacciSeries();
//        reverseDisplayInt();
//        reverseDisplayString();
//        count();
//        sumDigits();
//        reverseDisplayString2();
//        largestNumber();
//        upperCases();
//        occurrencesOfSpecifiedChars();
//        count3();
//        occurrences();
//        towerOfHanoi();
//        dec2Bin();
//        dec2Hex();
//        binary2Dec();
//        hex2Dec();
        stringPermutation();
    }

    //18.1
    private static void factorial() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        BigInteger n = new BigInteger(input.nextLine());

        // Display factorial
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ONE;
        } else
            return n.multiply(factorial(n.subtract(BigInteger.ONE))); // Recursive call
    }

    //18.2
    private static void fibonacci() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        System.out.println("The Fibonacci number at index "
                + index + " is " + fibo(index));
    }

    public static long fibo(long index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            int f0 = 0;
            int f1 = 1;
            int currentFib = 0;

            for (int i = 2; i <= index; i++) {
                currentFib = f0 + f1;
                f0 = f1;
                f1 = currentFib;
            }

            return f1;
        }
    }

    //18.3
    private static void gcd() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 2 integers: ");

        int m = input.nextInt();
        int n = input.nextInt();

        System.out.println("The GCD is " + gcd(m, n));
    }

    private static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        }

        return gcd(n, m % n);
    }

    //18.4
    private static void sumSeriesOne() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(sumSeriesOne(i));
        }
    }

    private static double sumSeriesOne(int goal) {
        if (goal == 1) {
            return 1;
        }
        return (1.0 / goal) + sumSeriesOne(goal - 1);
    }

    //18.5
    private static void sumSeriesTwo() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(sumSeriesTwo(i));
        }
    }

    private static double sumSeriesTwo(int goal) {
        if (goal == 1) {
            return 1.0 / (2 * goal + 1);
        } else {
            return goal / (2.0 * goal + 1) + sumSeriesTwo(goal - 1);
        }
    }

    //18.6
    private static void sumSeriesThree() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(sumSeriesThree(i));
        }
    }

    private static double sumSeriesThree(int goal) {
        if (goal == 1) {
            return 1.0 / (goal + 1);
        } else {
            return ((double) goal / (goal + 1)) + sumSeriesThree(goal - 1);
        }
    }

    //18.7
    private static void fibonacciSeries() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

        long numberOfTimesCalled = 1;

        System.out.println("Number of times called is " + fib(index, numberOfTimesCalled));
    }

    public static long fib(long index, long numberOfTimesCalled) {
        if (index == 0) {
            return numberOfTimesCalled;
        } else if (index == 1) {
            return numberOfTimesCalled + 1;
        } else {
            return fib(index - 1, numberOfTimesCalled + 1) + fib(index - 2, numberOfTimesCalled + 1);
        }
    }

    //18.8
    private static void reverseDisplayInt() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer to reverse: ");
        int num = input.nextInt();

        reverseDisplayInt(num);
    }

    private static void reverseDisplayInt(int num) {
        if (num < 10) {
            System.out.print(num);
            return;
        }

        System.out.print(num % 10);
        reverseDisplayInt(num / 10);
    }

    //18.9
    private static void reverseDisplayString() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String num = input.nextLine();

        reverseDisplayString(num);
    }

    private static void reverseDisplayString(String num) {
        if (num.isEmpty()) {
            return;
        }

        System.out.print(num.charAt(num.length() - 1) + "");
        reverseDisplayString(num.substring(0, num.length() - 1));
    }

    //18.10
    private static void count() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = input.nextLine();

        System.out.print("Specify letter you want counted: ");
        char character = input.nextLine().charAt(0);

        System.out.println("The number of " + character + "s in " + word + " is " + count(word, character));
    }

    private static int count(String word, char character) {
        int result = 0;

        if (!word.isEmpty()) {
            result = count(word.substring(1), character) + ((word.charAt(0) == character) ? 1 : 0);
        }

        return result;
    }

    //18.11
    private static void sumDigits() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer to sum: ");
        int num = input.nextInt();

        System.out.println("Sum of digits = " + sumDigits(num));
    }

    private static int sumDigits(int num) {
        int result = 0;

        if (num < 10) {
            return result + num;
        } else {
            result = (num % 10) + sumDigits(num / 10);
        }

        return result;
    }

    //18.12
    private static void reverseDisplayString2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String word = input.nextLine();

        reverseDisplayString2(word, word.length() - 1);
    }

    private static void reverseDisplayString2(String word, int higherIndex) {
        if (word.isEmpty()) {
            return;
        }

        System.out.print(word.charAt(higherIndex));

        if (higherIndex == 0) {
            return;
        }
        reverseDisplayString2(word, higherIndex - 1);
    }

    //18.13
    private static void largestNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an array of 8 numbers: ");

        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            array.add(input.nextInt());
        }

        System.out.println("The largest number is " + getHighest(array, array.get(0), 1));
    }

    private static int getHighest(List<Integer> array, int highest, int index) {
        if (index == array.size()) {
            return highest;
        }

        highest = highest > array.get(index) ? highest : array.get(index);
        return getHighest(array, highest, index + 1);
    }

    //18.14
    private static void upperCases() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to with upper and lower cases: ");
        String word = input.nextLine();

        System.out.println("The number of upper case letters is " + getUpperCases(word, 0));
    }

    private static int getUpperCases(String word, int index) {
        if (index == word.length() - 1) {
            return Character.isUpperCase(word.charAt(index)) ? 1 : 0;
        }
        return (Character.isUpperCase(word.charAt(index)) ? 1 : 0) + getUpperCases(word, index + 1);
    }

    //18.15
    private static void occurrencesOfSpecifiedChars() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = input.nextLine();

        System.out.print("Specify letter you want counted: ");
        char character = input.nextLine().charAt(0);

        System.out.println("The number of " + character + "s in " + word + " is " + count2(word, character, word.length() - 1));
    }

    private static int count2(String word, char character, int high) {
        int result = 0;

        if (!word.isEmpty()) {
            result = count(word.substring(0, high - 1), character) + ((word.charAt(high) == character) ? 1 : 0);
        }

        return result;
    }

    //18.16
    private static void count3() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to count: ");
        String word = input.nextLine();

        char[] chars = word.toCharArray();

        System.out.println("The number of upper case characters is " + count3(chars, chars.length - 1));
    }

    private static int count3(char[] chars, int high) {
        if (high < 0) {
            return 0;
        }

        return count3(chars, high - 1) + (Character.isUpperCase(chars[high]) ? 1 : 0);
    }

    //18.17
    private static void occurrences() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = input.nextLine();

        System.out.print("Specify letter you want counted: ");
        char character = input.nextLine().charAt(0);

        char[] chars = word.toCharArray();

        System.out.println("The number of " + character + "s in " + word + " is " + occurrences(chars, character, word.length() - 1));
    }

    private static int occurrences(char[] chars, char character, int high) {
        if (high < 0) {
            return 0;
        }

        return occurrences(chars, character, high - 1) + (chars[high] == character ? 1 : 0);
    }

    //18.18
    private static void towerOfHanoi() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();

        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');
        System.out.println("The number of moves are " + numberOfMoves);
    }

    public static void moveDisks(int n, char fromTower,
                                 char toTower, char auxTower) {
        numberOfMoves++;
        if (n == 1) {
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
        } else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }

    //18.21
    private static void dec2Bin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number to convert to binary: ");
        int n = input.nextInt();

        System.out.println(n + " as binary is " + dec2Bin(n));
    }

    private static String dec2Bin(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        return dec2Bin(n / 2) + (n % 2);
    }

    //18.22
    private static void dec2Hex() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a decimal value: ");
        int v = input.nextInt();

        System.out.println(v + " as hex number is " + dec2Hex(v));
    }

    private static String dec2Hex(int n) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        String result = "";

        if (n > 0) {
            result += dec2Hex(n / 16) + hexDigits[(n % 16)];
        }

        return result;
    }

    //    //18.23
    private static void binary2Dec() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a binary value: ");
        String v = input.nextLine();

        System.out.println(v + " as decimal number is " + binary2Dec(v, 0));
    }

    private static int binary2Dec(String n, int index) {
        int res = 0;

        if (index < n.length()) {
            int num = n.charAt(n.length() - 1 - index) == '1' ? 1 : 0;
            res += (num * (int) Math.pow(2, index)) + binary2Dec(n, index + 1);
        }

        return res;
    }

    //18.24
    private static void hex2Dec() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a hex value: ");
        String v = input.nextLine();

        System.out.println(v + " as decimal number is " + hex2Dec(v, 0));
    }

    private static int hex2Dec(String hexString, int index) {
        int idx = hexString.length() - 1 - index;

        if (idx < 0) {
            return 0;
        }


        char toDecode = hexString.charAt(idx);
        int val;

        if (Character.isDigit(toDecode)) {
            val = Character.digit(toDecode, 10);
        } else {
            val = 10 + Character.toUpperCase(toDecode) - 'A';
        }

        return val * (int) Math.pow(16, index) + hex2Dec(hexString, index + 1);
    }


    //18.25
    private static void stringPermutation() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string value: ");
        String v = input.nextLine();

        stringPermutation("", v);
    }

    private static void stringPermutation(String s1, String s2) {
        if (s2.isEmpty()) {
            System.out.println(s1);
            return;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            String remaining = s2.substring(0, i) + s2.substring(i + 1);
            stringPermutation(s1 + c, remaining);
        }
    }
}
