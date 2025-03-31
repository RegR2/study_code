package textbook;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Chapter10Exercises {
    public static void main(String[] args) {
//        testRectangle();
//        boundingRectangle();
//        testMyDate();
//        divisibleBy2or3();
//        squareNumbers();
//        largePrimeNumbers();
//        mersennePrime();
//        approximateE();
//        divideBy5or6();
//        myString();
//        myString2();
//        myCharacter();
        splitString();
//        calculator();
    }

    //10.13
    private static void testRectangle() {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.println("Area of r1: " + r1.getArea());
        System.out.println("Perimeter of r1: " + r1.getPerimeter());
        System.out.println("R1 contains point: " + r1.contains(3, 3));
        System.out.println("R1 contains rectangle: " + r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println("R1 overlaps rectangle: " + r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }

    //10.14
    private static void testMyDate() {
        MyDate d1 = new MyDate();
        System.out.println("D1 = " + d1.getDay() + "/" + d1.getMonth() + "/" + d1.getYear());

        MyDate d2 = new MyDate();
        d2.setDate(34355555133101L);
        System.out.println("D2 = " + d2.getDay() + "/" + d2.getMonth() + "/" + d2.getYear());
    }

    //10.15
    private static void boundingRectangle() {
        Scanner input = new Scanner(System.in);

        double[][] d = new double[5][2];

        System.out.println("Enter five points:  ");

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                d[i][j] = input.nextDouble();
            }
        }

        double minX = d[0][0];
        double maxX = d[0][0];
        double minY = d[0][1];
        double maxY = d[0][1];

        for (double[] doubles : d) {
            if (doubles[0] < minX) {
                minX = doubles[0];
            }

            if (doubles[0] > maxX) {
                maxX = doubles[0];
            }

            if (doubles[1] < minY) {
                minY = doubles[1];
            }

            if (doubles[1] > maxY) {
                maxY = doubles[1];
            }
        }

        double height = maxY - minY;
        double width = maxX - minX;
        double centerX = (minX + maxX) / 2;
        double centerY = (minY + maxY) / 2;

        System.out.println("Center points = (" + centerX + ", " + centerY + ")");
        System.out.println("Width = " + width);
        System.out.println("Height = " + height);
    }

    //10.16
    private static void divisibleBy2or3() {
        BigInteger bigNum = new BigInteger(
                "10000000000000000000000000000000000000000000000001");

        int count = 1;
        while (count <= 10) {
            if (bigNum.remainder(new BigInteger("2")).equals(BigInteger.ZERO) ||
                    bigNum.remainder(new BigInteger("3")).equals(BigInteger.ZERO)) {
                System.out.println(bigNum + " ");
                count++;
            }

            bigNum = bigNum.add(BigInteger.ONE);
        }
    }

    //10.17
    private static void squareNumbers() {
        BigInteger max = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);

        int count = 1;
        while (count <= 10) {
            BigInteger multiplied = max.multiply(max);

            if (multiplied.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
                System.out.println(max.multiply(max) + " ");
                max = max.add(BigInteger.ONE);
                count++;
            }
        }
    }

    //10.18
    private static void largePrimeNumbers() {
        int count = 0;
        BigInteger max = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);

        System.out.println("Started");

        while (count <= 5) {
            if (max.divide(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0) {
                continue;
            }

            if (isPrime(max)) {
                System.out.println(max + " ");
                count++;
            }

            max = max.add(BigInteger.ONE);
        }

        System.out.println("Finished");
    }

    private static void mersennePrime() {
        System.out.println("p                   2^p-1");
        System.out.println("-------------------------");

        for (int i = 2; i <= 100; i++) {
            if (isPrime(BigInteger.valueOf(i))) {
                BigInteger p = BigInteger.TWO.pow(i).subtract(BigInteger.ONE);

                if (isPrime(p)) {
                    System.out.println(i + "                       " + p);
                }
            }
        }
    }

    public static boolean isPrime(BigInteger number) {
        for (BigInteger divisor = BigInteger.TWO; divisor.compareTo(number.divide(BigInteger.TWO)) <= 0; divisor = divisor.add(BigInteger.ONE)) {
            if (number.remainder(divisor).compareTo(BigInteger.ZERO) == 0) { // If true, number is not prime
                return false; // number is not a prime
            }
        }

        return true; // number is prime
    }

    //10.20
    private static void approximateE() {
        BigDecimal e = BigDecimal.ONE;
        MathContext mc = new MathContext(25);

        BigDecimal factorial = BigDecimal.ONE;

        for (int i = 1; i <= 1000; i++) {
            factorial = factorial.divide(new BigDecimal(i), mc);
            e = e.add(factorial);
            System.out.printf("Value of e after %2d terms: %.15f%n", i, e);
        }
    }

    //10.21
    private static void divideBy5or6() {
        int count = 0;
        BigInteger max = BigInteger.valueOf(Long.MAX_VALUE);

        while (count <= 10) {
            if (max.remainder(BigInteger.valueOf(5)).compareTo(BigInteger.ZERO) == 0 || max.remainder(BigInteger.valueOf(6)).compareTo(BigInteger.ZERO) == 0) {
                System.out.println(max + " ");
                count++;
            }
            max = max.add(BigInteger.ONE);
        }
    }

    //10.22
    private static void myString() {
        char[] value = "This is a test".toCharArray();

        MyString1 test = new MyString1(value);
        System.out.println("test = " + Arrays.toString(test.chars));

        System.out.println("charAt = " + test.charAt(7));
        System.out.println("length = " + test.length());
        System.out.println("substring = " + Arrays.toString(test.substring(0, 5).chars));
        System.out.println("toLowercase = " + Arrays.toString(test.toLowerCase().chars));
        System.out.println("equals = " + test.equals(new MyString1("This is a test".toCharArray())));
        System.out.println("valueOf = " + Arrays.toString(MyString1.valueOf(65).chars));

    }

    //10.23
    private static void myString2() {
        MyString2 s = new MyString2("The best yet to come");

        System.out.println("s = " + s.toString());
        System.out.println("compare = " + s.compare("Heya heyo!"));
        System.out.println("substring = " + s.substring(4).toString());
        System.out.println("toUppercase = " + s.toUpperCase().toString());
        System.out.println("toChars = " + Arrays.toString(s.toChars()));
        System.out.println("valueOf = " + MyString2.valueOf(true).toString());
    }

    //10.24
    private static void myCharacter() {
        MyCharacter c = new MyCharacter('a');

        System.out.println("c = " + c);
        System.out.println("c = " + c);
    }

    //10.25
    private static void splitString() {
        System.out.println(Arrays.toString(split("a?b?gf#e", "[?#]")));
    }

    private static String[] split(String s, String delimeter) {
        String[] sA = new String[s.length()];

        String[] delimeterArray;
        if (delimeter.contains("[") && delimeter.contains("]")) {
            int indexOfO = delimeter.indexOf("[");
            int indexOfC = delimeter.indexOf("]");

            delimeter = delimeter.substring(indexOfO + 1, indexOfC);
            char[] a = delimeter.toCharArray();
            delimeterArray = new String[a.length];

            for (int i = 0; i < a.length; i++) {
                delimeterArray[i] = a[i] + "";
            }
        } else {
            delimeterArray = new String[]{delimeter};
        }

        int idx = 0;
        int startSubstring = 0;

        for (int i = 0; i < s.length(); i++) {
            int intForSubstring = -1;
            String value = String.valueOf(s.charAt(i));
            for (String string : delimeterArray) {
                if (value.equals(string)) {
                    intForSubstring = i;
                    break;
                }
            }

            if (intForSubstring > -1) {
               sA[idx++] = s.substring(startSubstring, intForSubstring);
               sA[idx++] = value;
               startSubstring = intForSubstring + 1;
            }
        }

        if (startSubstring <= s.length() - 1) {
            sA[idx] = s.substring(startSubstring);
        }

        String[] finalArray = new String[idx + 1];
        System.arraycopy(sA, 0, finalArray, 0, idx + 1);
        return finalArray;
    }

    //10.26
    private static void calculator() {
        System.out.println(calculator("3 +        4"));
        System.out.println(calculator("3*4"));
        System.out.println(calculator("3 - 4"));
    }

    private static int calculator(String input) {
        int end = 0;
        char mathSymbol = '+';

        for (char c : input.toCharArray()) {
            if (c != ' ' && !Character.isDigit(c)) {
                mathSymbol = c;
            }

            if (Character.isDigit(c)) {
                if (mathSymbol == '+') {
                    end += Character.getNumericValue(c);
                } else if (mathSymbol == '*') {
                    end *= Character.getNumericValue(c);
                } else if (mathSymbol == '-') {
                    end -= Character.getNumericValue(c);
                } else {
                    end /= Character.getNumericValue(c);
                }
            }
        }

        return end;
    }

    //10.27

}

class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return Math.abs(x - this.x) <= width / 2 && Math.abs(y - this.y) <= height / 2;
    }

    public boolean contains(MyRectangle2D r) {
        return contains(r.x - r.width / 2, r.y + r.height / 2) &&
                contains(r.x - r.width / 2, r.y - r.height / 2) &&
                contains(r.x + r.width / 2, r.y + r.height / 2) &&
                contains(r.x + r.width / 2, r.y - r.height / 2);
    }

    public boolean overlaps(MyRectangle2D r) {
        return Math.abs(x - r.x) <= (width + r.width) / 2 && Math.abs(y - r.y) <= (height + r.height) / 2;
    }
}

class MyDate {
    private long year;
    private long month;
    private long day;

    public MyDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(System.currentTimeMillis());

        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH) + 1;
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);

    }

    public MyDate(long year, long month, long day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public long getYear() {
        return year;
    }

    public long getMonth() {
        return month;
    }

    public long getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);

        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH) + 1;
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
}

class MyString1 {
    char[] chars;

    public MyString1(char[] chars) {
        this.chars = chars;
    }

    public char charAt(int i) {
        return this.chars[i];
    }

    public int length() {
        return this.chars.length;
    }

    public MyString1 substring(int start, int end) {
        char[] newArray = new char[end - start];
        System.arraycopy(this.chars, start, newArray, 0, end - start);
        return new MyString1(newArray);
    }

    public MyString1 toLowerCase() {
        char[] newArray = new char[this.length()];

        for (int i = 0; i < this.length(); i++) {
            if (Character.isUpperCase(this.chars[i])) {
                newArray[i] = Character.toLowerCase(this.chars[i]);
            } else {
                newArray[i] = this.chars[i];
            }
        }

        return new MyString1(newArray);
    }

    public boolean equals(MyString1 string) {
        for (int i = 0; i < this.length(); i++) {
            if (this.chars[i] != string.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static MyString1 valueOf(int i) {
        char[] iChar = String.valueOf(i).toCharArray();
        return new MyString1(iChar);
    }
}

class MyString2 {
    String s;

    public MyString2(String s) {
        this.s = s;
    }

    public int compare(String s) {
        if (this.s.length() > s.length()) {
            return -1;
        } else if (this.s.length() < s.length()) {
            return 1;
        } else {
            for (int i = 0; i < this.s.length(); i++) {
                if (this.s.charAt(i) != s.charAt(i) && this.s.charAt(i) > s.charAt(i)) {
                    return -1;
                } else if (this.s.charAt(i) != s.charAt(i) && this.s.charAt(i) < s.charAt(i)) {
                    return 1;
                }
            }

            return 0;
        }
    }

    public MyString2 substring(int begin) {
        char[] newString = new char[this.s.length() - begin];

        int idx = 0;
        for (int i = begin; i < this.s.length(); i++) {
            newString[idx] = this.s.charAt(i);
        }

        return new MyString2(String.valueOf(newString));
    }

    public MyString2 toUpperCase() {
        char[] sUpperCase = new char[this.s.length()];

        for (int i = 0; i < this.s.length(); i++) {
            if (Character.isLowerCase(this.s.charAt(i))) {
                sUpperCase[i] = Character.toUpperCase(this.s.charAt(i));
            } else {
                sUpperCase[i] = this.s.charAt(i);
            }
        }

        return new MyString2(String.valueOf(sUpperCase));
    }

    public char[] toChars() {
        return this.s.toCharArray();
    }

    public static MyString2 valueOf(boolean b) {
        if (b) {
            return new MyString2("true");
        } else {
            return new MyString2("false");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class MyCharacter {
    private char c;

    public MyCharacter(char c) {
        this.c = c;
    }

    public char getChar() {
        return this.c;
    }

    public int compareTo(MyCharacter other) {
        return this.c - other.c;
    }

    public boolean equals(MyCharacter other) {
        return this.c == other.c;
    }

    public boolean isDigit() {
        return isDigit(this.c);
    }

    public static boolean isDigit(char ch) {
        return ch <= '9' && ch >= '0';
    }

    public static boolean isLetter(char ch) {
        return (ch <= 'z' && ch >= 'a') ||
                (ch <= 'Z' && ch >= 'A');
    }

    public static boolean isLetterOrDigit(char ch) {
        return isLetter(ch) || isDigit(ch);
    }

    public static boolean isLowerCase(char ch) {
        return (ch <= 'z' && ch >= 'a');
    }

    public static boolean isUpperCase(char ch) {
        return (ch <= 'Z' && ch >= 'A');
    }

    public static char toUpperCase(char ch) {
        if (isLowerCase(ch))
            return (char) (ch - 'a' + 'A');
        else
            return ch;
    }

    public static char toLowerCase(char ch) {
        if (isUpperCase(ch))
            return (char) (ch - 'A' + 'a');
        else
            return ch;
    }
}

class MyStringBuilder1 {
    char[] chars;

    public MyStringBuilder1(String s) {
        this.chars = s.toCharArray();
    }

    public MyStringBuilder1 append(MyStringBuilder1 other) {
        char[] newArray = new char[this.chars.length + other.chars.length];
        System.arraycopy(this.chars, 0, newArray, 0, this.chars.length);
        System.arraycopy(other.chars, 0, newArray, this.chars.length, other.chars.length);

        this.chars = newArray;
        return this;
    }

    public MyStringBuilder1 append(int i) {
        char[] newArray = new char[this.chars.length + 1];
        System.arraycopy(this.chars, 0, newArray, 0, this.chars.length);
        newArray[newArray.length - 1] = (char) ('0' + i);

        this.chars = newArray;
        return this;
    }

    public int length() {
        return this.chars.length;
    }

    public int charAt(int index) {
        return this.chars[index];
    }

    public MyStringBuilder1 toLowerCase() {
        char[] newArray = new char[this.chars.length];

        for (int i = 0; i < this.chars.length; i++) {
            if (Character.isUpperCase(this.chars[i])) {
                newArray[i] = Character.toLowerCase(this.chars[i]);
            } else {
                newArray[i] = this.chars[i];
            }
        }

        this.chars = newArray;
        return this;
    }


    public MyStringBuilder1 substring(int begin, int end) {
        char[] newArray = new char[end - begin];
        System.arraycopy(this.chars, begin, newArray, 0, end - begin);
        this.chars = newArray;
        return this;
    }

    public String toString() {
        return String.valueOf(chars);
    }
}

class MyStringBuilder2 {
    private static final int DEFAULT_CAPACITY = 8;
    char[] chars;

    public MyStringBuilder2() {
        this.chars = new char[DEFAULT_CAPACITY];
    }

    public MyStringBuilder2(char[] chars) {
        this.chars = chars;
    }

    public MyStringBuilder2(String s) {
        this.chars = s.toCharArray();
    }

    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
        int indexOfInsertion = (this.chars.length - offset) + s.chars.length;
        char[] newArray = new char[this.chars.length + s.chars.length];
        System.arraycopy(this.chars, 0, newArray, 0, offset);
        System.arraycopy(s.chars, offset, newArray, 0, s.chars.length);
        System.arraycopy(this.chars, indexOfInsertion, newArray, offset, this.chars.length);

        this.chars = newArray;
        return this;
    }

    ;

    public MyStringBuilder2 reverse() {
        char[] newArray = new char[this.chars.length];

        int indx = 0;
        for (int i = this.chars.length - 1; i >= 0; i--) {
            newArray[indx] = chars[i];
            indx++;
        }

        this.chars = newArray;
        return this;
    }

    ;

    public MyStringBuilder2 substring(int begin) {
        if (this.chars.length - begin >= 0) {
            char[] newArray = new char[this.chars.length - begin];
            System.arraycopy(chars, begin, newArray, begin, this.chars.length - begin);
            this.chars = newArray;
            return this;
        } else {
            return this;
        }
    }

    ;

    public MyStringBuilder2 toUpperCase() {
        char[] newArray = new char[this.chars.length];

        for (int i = 0; i < this.chars.length; i++) {
            if (Character.isLowerCase(this.chars[i])) {
                newArray[i] = Character.toUpperCase(this.chars[i]);
            } else {
                newArray[i] = this.chars[i];
            }
        }

        this.chars = newArray;
        return this;
    }

    ;

}
