package textbook;

import java.util.Arrays;
import java.util.Scanner;

public class Chapter7Exercises {
    public static void main(String[] args) {
//        assignGrades();
//        reverse();
//        occurenceOfNumbers();
//        analyzeScores();
//        printDistinctNumbers();
//        isPrimeNumber();
//        countSingleDigits();
//        averageAnArray();
//        smallestElement();
//        indexOfSmallestElement();
//        computeStandardDeviation();
//        reverseArray();
//        randomNumberChooser();
//        computeGcd();
//        eliminateDuplicates();
//        executionTime();
//        sortStudents();
//        bubbleSort();
//        sorted();
//        reviseSelectionSort();
//        lockerPuzzle();
//        couponCollectors();
//        solveQuadraticEquations();
//        strictlyIdenticalArrays();
//        identicalArrays();
//        combinations();
//        patternRecognition();
//        sumIntegers(args);
//        mergeSortedLists();
//        partitionOfAList();
//        chineseZodiac();
//        sortCharactersInAString();
//        pickFourCards();
//        hangman();
        beanMachine();
    }

    //7.1
    private static void assignGrades() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int students = input.nextInt();

        System.out.println("Enter " + students + " scores: ");

        int[] scores = new int[students];
        int bestScore = 0;

        for (int i = 0; i < students; i++) {
            int score = input.nextInt();
            scores[i] = score;

            if (score > bestScore) {
                bestScore = score;
            }
        }

        for (int i = 0; i <= scores.length - 1; i++) {
            if (scores[i] >= (bestScore - 10)) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is A");
            } else if (scores[i] >= (bestScore - 20)) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is B");
            } else if (scores[i] >= (bestScore - 30)) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is C");
            } else if (scores[i] >= (bestScore - 40)) {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is D");
            } else {
                System.out.println("Student " + i + " score is " + scores[i] + " and grade is F");
            }
        }
    }

    //7.2
    private static void reverse() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 numbers ");
        int[] nums = new int[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = input.nextInt();
        }

        for (int j = nums.length - 1; j >= nums.length / 2; j--) {
            int temp = nums[nums.length - 1 - j];
            nums[nums.length - 1 - j] = nums[j];
            nums[j] = temp;

        }

        System.out.println(Arrays.toString(nums));
    }

    //7.3
    private static void occurenceOfNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the integers between 1 and 100: ");

        int[] intArray = new int[100];

        int num = input.nextInt();
        while (num != 0) {
            intArray[num]++;

            num = input.nextInt();
        }

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != 0) {
                System.out.println(i + " occurs " + intArray[i] + (intArray[i] > 1 ? " times" : " time"));
            }
        }
    }

    //7.4
    private static void analyzeScores() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the scores: ");

        int[] intArray = new int[100];

        int num = input.nextInt();
        int index = 0;
        double sum = 0;

        while (num >= 0) {
            intArray[index] = num;
            sum += num;
            index++;

            num = input.nextInt();
        }

        double average = sum / index + 1.0;

        int belowAverage = 0;
        int aboveAverage = 0;

        for (int i = 0; i <= index; i++) {
            if (intArray[i] >= average) {
                aboveAverage++;
            } else {
                belowAverage++;
            }
        }

        System.out.println("Average: " + average + ". Above average: " + aboveAverage + ". Below average: " + belowAverage);
    }

    //7.5
    private static void printDistinctNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the scores: ");

        int[] intArray = new int[10];
        int numberOfDistinct = 0;

        for (int i = 0; i < 10; i++) {
            int num = input.nextInt();

            boolean exists = false;
            for (int j : intArray) {
                if (j == num) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                intArray[numberOfDistinct] = num;
                numberOfDistinct++;
            }
        }

        int[] finalArray = new int[numberOfDistinct];
        System.arraycopy(intArray, 0, finalArray, 0, numberOfDistinct);

        System.out.println("The number of distinc numbers if " + numberOfDistinct);
        System.out.println("The dinstinct numbers are: " + Arrays.toString(finalArray));
    }

    //7.6
    private static void isPrimeNumber() {
        final int NUMBER_OF_PRIMES = 50; // Number of primes to display
        final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        int[] primes = new int[NUMBER_OF_PRIMES];

        System.out.println("The first 50 prime numbers are \n");

        // Repeatedly find prime numbers
        while (count < NUMBER_OF_PRIMES) {
            boolean isPrime = true;

            // Test if number is prime
            for (int i = 0; i < count && primes[i] <= Math.sqrt(number); i++) {
                if (number % primes[i] == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                primes[count] = number;
                count++; // Increase the count

                if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                    // Print the number and advance to the new line
                    System.out.println(number);
                } else {
                    System.out.print(number + " ");
                }
            }

            // Check if the next number is prime
            number++;
        }
    }

    //7.7
    private static void countSingleDigits() {
        int[] singleDigs = new int[10];

        for (int i = 0; i < 100; i++) {
            int num = (int) (Math.random() * 10);

            singleDigs[num]++;
        }

        for (int j = 0; j < singleDigs.length; j++) {
            System.out.println("Integer " + j + " occurred " + singleDigs[j] + " times.");
        }
    }

    //7.8
    private static void averageAnArray() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 integers: ");
        int[] intArray = new int[10];

        for (int i = 0; i < 10; i++) {
            intArray[i] = input.nextInt();
        }

        double averageInt = average(intArray);
        System.out.println("Average of int array is " + averageInt);

        System.out.println("Enter 10 doubles: ");
        double[] dArray = new double[10];

        for (int i = 0; i < 10; i++) {
            dArray[i] = input.nextDouble();
        }

        double averageD = average(dArray);
        System.out.println("Average of double array is " + averageD);
    }

    public static double average(int[] array) {
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }

    public static double average(double[] array) {
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }

    //7.9
    private static void smallestElement() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 integers: ");
        double[] dArray = new double[10];

        for (int i = 0; i < 10; i++) {
            dArray[i] = input.nextDouble();
        }

        double min = min(dArray);

        System.out.println("The smallest value is " + min);
    }

    public static double min(double[] array) {
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    //7.10
    private static void indexOfSmallestElement() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 doubles: ");
        double[] dArray = new double[10];

        for (int i = 0; i < 10; i++) {
            dArray[i] = input.nextDouble();
        }

        int min = indexOfSmallestElement(dArray);

        System.out.println("The smallest value is " + min);
    }

    public static int indexOfSmallestElement(double[] array) {
        double min = array[0];
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }

        return index;
    }

    //7.11
    private static void computeStandardDeviation() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 doubles: ");
        double[] dArray = new double[10];

        for (int i = 0; i < 10; i++) {
            dArray[i] = input.nextDouble();
        }

        double mean = mean(dArray);
        System.out.println("The mean is: " + mean);

        double deviation = deviation(dArray);
        System.out.println("The standard deviation is: " + deviation);
    }

    public static double deviation(double[] x) {
        double sum = 0;

        for (double value : x) {
            sum += value;
        }

        double mean = sum / x.length;

        double sumNumerator = 0;
        for (double v : x) {
            sumNumerator += Math.pow((v - mean), 2);
        }

        return Math.sqrt((sumNumerator / (x.length - 1)));
    }

    public static double mean(double[] x) {
        double sum = 0;

        for (double v : x) {
            sum += v;
        }

        return sum / x.length;
    }

    //7.12
    private static void reverseArray() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 integers: ");
        int[] intArray = new int[10];

        for (int i = 0; i < 10; i++) {
            intArray[i] = input.nextInt();
        }

        reverseArray(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    private static void reverseArray(int[] array) {
        for (int i = array.length - 1; i >= array.length / 2; i--) {
            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i];
            array[i] = temp;
        }
    }

    //7.13
    private static void randomNumberChooser() {
        int numPerLines = 1;

        for (int i = 0; i <= 45; i++) {
            if (numPerLines == 15) {
                System.out.println(getRandom(1, 100, 4, 8, 95, 93) + " ");
                numPerLines = 1;
            } else {
                System.out.print(getRandom(1, 100, 4, 8, 95, 93) + " ");
                numPerLines++;
            }
        }
    }

    public static int getRandom(int start, int end, int... numbers) {
        int random = start;

        boolean cont = true;
        while (cont) {
            random = start + (int) (Math.random() * end);

            for (int number : numbers) {
                if (random == number) {
                    break;
                } else {
                    cont = false;
                }
            }
        }

        return random;
    }

    //7.14
    private static void computeGcd() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 5 integers: ");
        int[] intArray = new int[5];

        for (int i = 0; i < 5; i++) {
            intArray[i] = input.nextInt();
        }

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray.length; j++) {
                if (intArray[j] < intArray[i]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[i];
                    intArray[i] = temp;
                }
            }
        }

        System.out.println("Greatest common denominator is " + gcd(intArray));
    }

    public static int gcd(int... numbers) {
        int gcd = 0;

        for (int i = numbers[0] / 2; i > 0; i--) {
            boolean isDivisor = false;
            for (int j = 1; j < numbers.length; j++) {
                isDivisor = numbers[j] % i == 0;

                if (!isDivisor) {
                    break;
                }
            }

            if (isDivisor) {
                gcd = i;
                break;
            }
        }

        return gcd;
    }

    //7.15
    private static void eliminateDuplicates() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 integers: ");
        int[] intArray = new int[10];

        for (int i = 0; i < 10; i++) {
            intArray[i] = input.nextInt();
        }

        System.out.println(Arrays.toString(eliminateDuplicates(intArray)));
    }

    public static int[] eliminateDuplicates(int[] list) {
        int[] removedDuplicates = new int[list.length];
        int numInArray = 0;

        for (int num : list) {
            boolean contains = false;

            for (int i : removedDuplicates) {
                if (num == i) {
                    contains = true;
                    break;
                }
            }

            if (!contains) {
                removedDuplicates[numInArray] = num;
                numInArray++;
            }
        }

        int[] returnArray = new int[numInArray];
        System.arraycopy(removedDuplicates, 0, returnArray, 0, numInArray);

        return returnArray;
    }

    //7.16
    private static void executionTime() {
        int[] a = new int[100000];

        for (int i = 0; i < 100000; i++) {
            a[i] = (int) (1 + Math.random() * 100);
        }

        int key = (int) (1 + Math.random() * 100);

        long startTimeLiner = System.nanoTime();
        linearSearch(a, key);
        long endTimeLinear = System.nanoTime();
        long executionTimeLinear = endTimeLinear - startTimeLiner;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        long startTimeBinary = System.nanoTime();
        binarySearch(a, key);
        long endTimeBInary = System.nanoTime();
        long executionTimeBinary = endTimeBInary - startTimeBinary;

        System.out.println("Execution time linear: " + executionTimeLinear + ", execution time binary: " + executionTimeBinary);

    }

    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i])
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }

        return -low - 1; // Now high < low
    }

    //7.17
    private static void sortStudents() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int num = input.nextInt();

        String[] studentNames = new String[num];
        System.out.println("Enter name of students: ");

        for (int i = 0; i < num; i++) {
            studentNames[i] = input.next();
        }

        int[] scores = new int[num];

        System.out.println("Enter student scores: ");
        for (int j = 0; j < num; j++) {
            scores[j] = input.nextInt();
        }

        for (int k = 0; k < num; k++) {
            for (int l = k + 1; l < num; l++) {
                if (scores[l] > scores[k]) {
                    int temp = scores[k];
                    scores[k] = scores[l];
                    scores[l] = temp;

                    String t = studentNames[k];
                    studentNames[k] = studentNames[l];
                    studentNames[l] = t;
                }
            }
        }

        for (int i = 0; i < num; i++) {
            System.out.println("Student: " + studentNames[i] + ", Score: " + scores[i]);
        }
    }

    //7.18
    private static void bubbleSort() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 numbers: ");
        int[] i = new int[10];

        for (int j = 0; j < 10; j++) {
            i[j] = input.nextInt();
        }

        for (int k = 0; k < 10; k++) {
            for (int l = k + 1; l < 10; l++) {
                if (i[k] > i[l]) {
                    int temp = i[k];
                    i[k] = i[l];
                    i[l] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(i));
    }

    //7.19
    private static void sorted() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the list: ");
        int num = input.nextInt();

        System.out.println("Enter the contents of the list: ");
        int[] i = new int[num];

        for (int j = 0; j < num; j++) {
            i[j] = input.nextInt();
        }

        boolean isSorted = true;

        for (int j = 0; j < num - 1; j++) {
            if (i[j] > i[j + 1]) {
                isSorted = false;
                break;
            }
        }

        System.out.println("The list has " + num + " integers: " + Arrays.toString(i));
        System.out.println("The list is " + (isSorted ? "sorted" : "not sorted"));
    }

    //7.20
    private static void reviseSelectionSort() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a list of 10 doubles: ");
        double[] d = new double[10];

        for (int j = 0; j < 10; j++) {
            d[j] = input.nextDouble();
        }

        selectionSort(d);

        System.out.println("Sorted array in descending order: " + Arrays.toString(d));
    }

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            double currentMax = list[i];
            int currentMaxIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMax < list[j]) {
                    currentMax = list[j];
                    currentMaxIndex = j;
                }
            }

            if (currentMaxIndex != i) {
                list[currentMaxIndex] = list[i];
                list[i] = currentMax;
            }
        }
    }

    //7.21
    private static void sumIntegers(String[] args) {
        int sum = 0;

        for (String arg : args) {
            sum += Integer.parseInt(arg);
        }
        System.out.println(sum);
    }

    //7.22
    private static void upperCaseLettersInString(String[] args) {
        int numUC = 0;

        for (int i = 0; i < args[0].length(); i++) {
            if (Character.isUpperCase(args[0].charAt(i))) {
                numUC++;
            }
        }

        System.out.println(numUC);
    }

    //7.23
    private static void lockerPuzzle() {
        boolean[] lockers = new boolean[101];

        for (int i = 0; i <= 100; i++) {
            lockers[i] = false;
        }

        for (int i = 1; i <= 100; i++) {
            for (int j = i; j <= 100; j += i) {
                lockers[j] = !lockers[j];
            }
        }

        for (int i = 1; i <= 100; i++) {
            if (lockers[i]) {
                System.out.print(i + " ");
            }
        }
    }

    //7.24
    private static void couponCollectors() {
        int[] deck = new int[52];
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "Jack", "Queen", "King"};

        // Initialize cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }

        // Shuffle the cards
        for (int i = 0; i < deck.length; i++) {
            // Generate an index randomly
            int index = (int) (Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }

        int numberOfPicks = 0;
        int count = 0;

        boolean[] found = new boolean[4];

        while (count < 4) {
            int i = (int) (Math.random() * deck.length);
            int card = deck[i] / 13;

            if (found[card]) {
                numberOfPicks++;
                continue;
            }

            String suit = suits[deck[i] / 13];
            String rank = ranks[deck[i] % 13];

            System.out.println(suit + " of " + rank);
            numberOfPicks++;
            found[card] = true;
            count++;

        }
        System.out.println("number of picks: " + numberOfPicks);
    }

    //7.25
    private static void solveQuadraticEquations() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double[] eqn = new double[]{a, b, c};
        double[] roots = new double[2];

        int numRoots = solveQuadratic(eqn, roots);

        System.out.println(numRoots == 0 ? "There are no roots" :
                numRoots == 1 ? "There is 1 root and it is " + roots[0] :
                        "There are 2 roots" + roots[0] + " & " + roots[1]);
    }

    private static int solveQuadratic(double[] eqn, double[] roots) {
        double x = eqn[1] * eqn[1] - (4 * eqn[0] * eqn[2]);

        if (x == 0) {
            double r1 = (-eqn[1] + Math.pow(x, 0.5)) / 2 * eqn[0];
            roots[0] = r1;

            return 1;
        } else if (x > 0) {
            double r1 = (-eqn[1] + Math.pow(x, 0.5)) / 2 * eqn[0];
            double r2 = (-eqn[1] - Math.pow(x, 0.5)) / 2 * eqn[0];
            roots[0] = r1;
            roots[1] = r2;

            return 2;
        } else {
            return 0;
        }
    }

    //7.26
    private static void strictlyIdenticalArrays() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter list1 size and contents:");
        int[] l1 = new int[input.nextInt()];

        for (int i = 0; i < l1.length; i++) {
            l1[i] = input.nextInt();
        }

        System.out.println("Enter list2 size and contents:");
        int[] l2 = new int[input.nextInt()];

        for (int i = 0; i < l2.length; i++) {
            l2[i] = input.nextInt();
        }

        if (Arrays.equals(l1, l2)) {
            System.out.println("The two lists are identical");
        } else {
            System.out.println("The two lists are not stricly identical");
        }
    }

    //7.27
    private static void identicalArrays() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter list1 size and contents:");
        int[] l1 = new int[input.nextInt()];

        for (int i = 0; i < l1.length; i++) {
            l1[i] = input.nextInt();
        }

        sortArrays(l1);

        System.out.println("Enter list2 size and contents:");
        int[] l2 = new int[input.nextInt()];

        for (int i = 0; i < l2.length; i++) {
            l2[i] = input.nextInt();
        }

        sortArrays(l2);

        if (Arrays.equals(l1, l2)) {
            System.out.println("The two lists are identical");
        } else {
            System.out.println("The two lists are not identical");
        }
    }

    private static void sortArrays(int[] i) {
        for (int k = 0; k < i.length; k++) {
            for (int l = k + 1; l < i.length; l++) {
                if (i[k] > i[l]) {
                    int temp = i[k];
                    i[k] = i[l];
                    i[l] = temp;
                }
            }
        }
    }

    //7.28
    private static void combinations() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 integers: ");

        int[] a = new int[10];

        for (int i = 0; i < 10; i++) {
            a[i] = input.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                System.out.println(a[i] + ", " + a[j]);
            }
        }
    }

    //7.29
    private static void pickFourCards() {
        int[] deck = new int[52];
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "Jack", "Queen", "King"};

        // Initialize cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }

        // Shuffle the cards
        for (int i = 0; i < deck.length; i++) {
            // Generate an index randomly
            int index = (int) (Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }

        int numOf24 = 0;
        int sum = 0;
        int numOfCards = 0;

        for (int card : deck) {
            if (numOfCards == 4) {
                if (sum == 24) {
                    numOf24++;
                }
                numOfCards = 0;
                sum = 0;
            }

            String rank = ranks[card % 13];

            switch (rank) {
                case "Ace" -> sum += 1;
                case "King" -> sum += 13;
                case "Queen" -> sum += 12;
                case "Jack" -> sum += 11;
                default -> sum += Integer.parseInt(rank);
            }

            numOfCards++;
        }
        System.out.println(numOf24);
    }

    //7.30
    private static void patternRecognition() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of integers: ");

        int n = input.nextInt();

        System.out.println("Enter " + n + " integers: ");
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        System.out.println(isConsecutiveFour(a) ? "The list has consecutive fours" : "The list has no consecutive fours");
    }

    public static boolean isConsecutiveFour(int[] values) {
        int num = values[0];
        int total = 1;

        for (int i = 1; i < values.length; i++) {
            if (total == 4) {
                return true;
            }

            if (values[i] == num) {
                total++;
            } else {
                num = values[i];
                total = 1;
            }
        }

        return false;
    }

    //7.31
    private static void mergeSortedLists() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter list1 size and contents:");
        int[] l1 = new int[input.nextInt()];

        for (int i = 0; i < l1.length; i++) {
            l1[i] = input.nextInt();
        }

        System.out.println("Enter list2 size and contents:");
        int[] l2 = new int[input.nextInt()];

        for (int i = 0; i < l2.length; i++) {
            l2[i] = input.nextInt();
        }

        System.out.println("The merged list is: " + Arrays.toString(merge(l1, l2)));
    }

    public static int[] merge(int[] list1, int[] list2) {
        int[] returnList = new int[list1.length + list2.length];

        int l1Index = 0;
        int l2Index = 0;
        int rIndex = 0;

        while (l1Index < list1.length && l2Index < list2.length) {
            if (list1[l1Index] < list2[l2Index]) {
                returnList[rIndex] = list1[l1Index];
                l1Index++;
            } else {
                returnList[rIndex] = list2[l2Index];
                l2Index++;
            }
            rIndex++;
        }

        if (l1Index < list1.length - 1) {
            while (l1Index < list1.length) {
                returnList[rIndex] = list1[l1Index];
                l1Index++;
                rIndex++;
            }
        }

        if (l2Index < list2.length - 1) {
            while (l2Index < list2.length) {
                returnList[rIndex] = list2[l2Index];
                l2Index++;
                rIndex++;
            }
        }

        return returnList;
    }

    //7.32
    private static void partitionOfAList() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter list size:");
        int num = input.nextInt();

        System.out.println("Enter list content: ");
        int[] list = new int[num];

        for (int i = 0; i < num; i++) {
            list[i] = input.nextInt();
        }

        int pivot = list[0];

        int low = 1;
        int high = list.length - 1;

        while (low <= high) {
            if (list[low] <= pivot) {
                low++;
                continue;
            }

            if (list[high] > pivot) {
                high--;
                continue;
            }

            if (low < high) {
                int temp = list[low];
                list[low] = list[high];
                list[high] = temp;
            }
        }

        list[0] = list[high];
        list[high] = pivot;

        System.out.println("After the parition, this list is: " + Arrays.toString(list));
    }

    //7.33
    private static void chineseZodiac() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        String[] zodiac = new String[]{"monkey", "rooster", "dog", "pig", "rat", "ox", "tiger", "rabbit", "dragon", "snake", "horse", "sheep"};

        int zodiacIndex = year % 12;
        System.out.println("The zodiac for the year is: " + zodiac[zodiacIndex]);
    }

    //7.34
    private static void sortCharactersInAString() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string ");
        String string = input.nextLine();

        char[] c = string.toCharArray();

        for (int i = 0; i < c.length; i++) {
            for (int j = i + 1; j < c.length; j++) {
                if (c[i] > c[j]) {
                    char temp = c[j];
                    c[j] = c[i];
                    c[i] = temp;
                }
            }
        }

        String returnString = "";

        for (char letter : c) {
            returnString += letter;
        }

        System.out.println("sorted string: " + returnString);
    }

    //7.35
    private static void hangman() {
        Scanner input = new Scanner(System.in);
        String[] words = {"write", "that", "hold", "love", "dragon"};

        int index = (int) (Math.random() * words.length);

        String word = words[index];
        char[] wordCharArray = new char[word.length()];

        for (int i=0; i< word.length(); i++) {
            wordCharArray[i] = '*';
        }

        boolean isWholeWordFound = false;
        int numberOfGuess = 0;

        while (!isWholeWordFound) {
            System.out.print("(Guess) Enter a letter in word " + Arrays.toString(wordCharArray).replace(",", "") + "> ");
            String guess = input.nextLine();
            char gChar = guess.charAt(0);

            for (char c : wordCharArray) {
                if (c == gChar) {
                    System.out.println(gChar + " is already in the word");
                    break;
                }
            }

            boolean isCharInLetter = false;
            for (int i=0; i < word.length(); i++) {
                if (word.charAt(i) == gChar) {
                    wordCharArray[i] = gChar;
                    isCharInLetter = true;
                }
            }

            if (!isCharInLetter) {
                System.out.println(gChar + " is not in the word");
                numberOfGuess++;
                continue;
            }

            boolean isStar = false;
            for (char c : wordCharArray) {
                if (c == '*') {
                    isStar = true;
                    break;
                }
            }

            if (!isStar){
                isWholeWordFound = true;
            }
        }

        System.out.println("The word is " + word + ". You missed " + numberOfGuess + (numberOfGuess > 1 ? " times" : "time"));

        System.out.println("Do you want to guess another word? Enter y or no> ");

        String want = input.nextLine();

        if (want.equals("y")) {
            hangman();
        }
    }

    //7.36
    private static void eightQueens() {
        int[][] queens = new int[][]{new int[8], new int[8], new int[8], new int[8], new int[8], new int[8], new int[8], new int[8]};


        for (int row=0; row< 8; row++) {
            for (int column=0; column< 8; column++) {

            }

        }
    }

    //7.37
    private static void beanMachine() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of balls to drop: ");
        int balls = input.nextInt();

        System.out.println("Enter the number of slots in the bean machine:");
        int n = input.nextInt();

        int[] slots = new int[n];

        while (balls > 0) {
            int numOfRs = 0;

            for (int i=0; i<7; i++) {
                int direction = (int) (Math.random() *2) +1;

                if (direction == 1) {
                    numOfRs++;
                    System.out.print("R");
                } else {
                    System.out.print("L");
                }
            }
            System.out.println();
            slots[numOfRs]++;
            balls--;
        }

        int highestRow = 0;

        for (int row : slots) {
            if (row > highestRow) {
                highestRow = row;
            }
        }

        while (highestRow > 0) {
            for (int i=0; i< slots.length; i++) {
                if (slots[i] >= highestRow) {
                    System.out.print("0");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            highestRow--;
        }
    }
}

//go back and check pickfourCards (29)
//go back and look at what chatgpt suggets for hangman game
