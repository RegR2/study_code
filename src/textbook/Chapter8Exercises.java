package textbook;

import javax.swing.text.Style;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Chapter8Exercises {
    public static void main(String[] args) {
//        sumColumn();
//        sumMajorDiagonal();
//        sortStudentsOnGrades();
//        weeklyHoursForEachEmployee();
//        addTwoMatrices();
//        multipleTwoMatrices();
//        pointsNearestEachOther();
//        allClosestPairsOfPoints();
//        largestRowAndColumn();
//        ticTacToe();
//        headsAndTails();
//        computeTax();
//        locateLargestElement();
//        exploreMatrix();
//        sameLine();
//        sortTwoDimensionalArray();
//        financialTsunami();
//        shuffleRows();
//        patternRecognition();
//        connectFour();
//        centralCity();
//        evenNumber1s();
//        findTheFlippedCell();
//        checkSudoku();
//        isMarkovMatrix();
//        rowSorting();
//        columnSorting();
//        strictlyIdenticalArrays();
//        identicalArrays();
//        solveLinearEquations();
//       intersectingPoint();
//        areaOfATriangle();
//        polygonSubareas();
//        rightmostLowestPoint();
//        largestBlock();
//        latinSquare();
        capitals();
    }

    //8.1
    private static void sumColumn() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 3−by−4 matrix row by row: ");

        double[][] m = new double[3][4];

        for (int h = 0; h < m.length; h++) {
            for (int i = 0; i < m[h].length; i++) {
                m[h][i] = input.nextDouble();
            }
        }

        int columnIndex = 0;
        double sum = 0;

        while (columnIndex < 4) {
            for (double[] doubles : m) {
                for (int column = columnIndex; column < columnIndex + 1; column++) {
                    sum += doubles[column];
                }
            }

            System.out.println("Sum of the elements at column " + columnIndex + " is " + sum);
            sum = 0;
            columnIndex++;
        }
    }

    //8.2
    private static void sumMajorDiagonal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 4−by−4 matrix row by row: ");

        double[][] m = new double[4][4];

        for (int h = 0; h < m.length; h++) {
            for (int i = 0; i < m[h].length; i++) {
                m[h][i] = input.nextDouble();
            }
        }

        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < i + 1; j++) {
                sum += m[i][j];
            }
        }

        System.out.print("Sum of the elements in the major diagonal is " + sum);
    }

    //8.3
    private static void sortStudentsOnGrades() {
        char[][] answers = {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

        // Key to the questions
        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

        int[][] students = new int[8][1];

        // Grade all answers
        for (int i = 0; i < answers.length; i++) {
            // Grade one student
            int correctCount = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == keys[j])
                    correctCount++;
            }

            students[i][0] = correctCount;
        }

        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i][0] > students[j][0]) {
                    int[] temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        System.out.println("Students grades in ascending order: ");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + i + " with grade " + students[i][0]);
        }
    }

    //8.4
    private static void weeklyHoursForEachEmployee() {
        int[][] hours = {
                {2, 4, 3, 4, 5, 8, 8},
                {7, 3, 4, 3, 3, 4, 4},
                {3, 3, 4, 3, 3, 2, 2},
                {9, 3, 4, 7, 3, 4, 1},
                {3, 5, 4, 3, 6, 3, 8},
                {3, 4, 4, 6, 3, 4, 4},
                {3, 7, 4, 8, 3, 8, 4},
                {6, 3, 5, 9, 2, 7, 9}};

        int[][] totalHours = new int[8][1];

        for (int i = 0; i < hours.length; i++) {
            int sum = 0;
            for (int j = 0; j < hours[i].length; j++) {
                sum += hours[i][j];
            }

            totalHours[i][0] = sum;
        }

        for (int k = 0; k < totalHours.length; k++) {
            for (int l = k + 1; l < totalHours.length; l++) {
                if (totalHours[k][0] < totalHours[l][0]) {
                    int[] temp = totalHours[l];
                    totalHours[l] = totalHours[k];
                    totalHours[k] = temp;
                }
            }
        }

        System.out.println("Total hours by employee in descending order: ");
        for (int i = 0; i < totalHours.length; i++) {
            System.out.println("Employee " + i + " worked total of " + totalHours[i][0]);
        }
    }

    //8.5
    private static void addTwoMatrices() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix 1: ");

        double[][] m1 = new double[3][3];

        for (int h = 0; h < m1.length; h++) {
            for (int i = 0; i < m1[h].length; i++) {
                m1[h][i] = input.nextDouble();
            }
        }

        System.out.print("Enter matrix 2: ");

        double[][] m2 = new double[3][3];

        for (int h = 0; h < m2.length; h++) {
            for (int i = 0; i < m2[h].length; i++) {
                m2[h][i] = input.nextDouble();
            }
        }

        double[][] m3 = addMatrix(m1, m2);

        System.out.println("The matrices are added as follows: ");
        printMatrices(m1, m2, m3, '+');
    }

    public static double[][] addMatrix(double[][] a, double[][] b) {
        double[][] newMatrix = new double[3][3];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                newMatrix[i][j] = a[i][j] + b[i][j];
            }
        }

        return newMatrix;
    }

    public static void printMatrices(double[][] m1, double[][] m2, double[][] m3, char symbol) {
        for (int i = 0; i < m1.length; i++) {

            for (int j = 0; j < m1.length; j++) {
                System.out.print(m1[i][j] + " ");
            }

            if (i == 1) {
                System.out.print(" " + symbol + " ");
            } else {
                System.out.print("   ");
            }

            for (int k = 0; k < m2.length; k++) {
                System.out.print(m2[i][k] + " ");
            }

            if (i == 1) {
                System.out.print(" = ");
            } else {
                System.out.print("   ");
            }

            for (int l = 0; l < m2.length; l++) {
                System.out.print(m3[i][l] + " ");
            }
            System.out.println();
        }
    }

    //8.6
    private static void multipleTwoMatrices() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix 1: ");

        double[][] m1 = new double[3][3];

        for (int h = 0; h < m1.length; h++) {
            for (int i = 0; i < m1[h].length; i++) {
                m1[h][i] = input.nextDouble();
            }
        }

        System.out.print("Enter matrix 2: ");

        double[][] m2 = new double[3][3];

        for (int h = 0; h < m2.length; h++) {
            for (int i = 0; i < m2[h].length; i++) {
                m2[h][i] = input.nextDouble();
            }
        }

        double[][] m3 = multiplyMatrix(m1, m2);

        System.out.println("The multiplication of the matrices is");
        printMatrices(m1, m2, m3, '*');
    }

    public static double[][] multiplyMatrix(double[][] m1, double[][] m2) {
        double[][] result = new double[3][3];
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < result.length; j++)
                for (int k = 0; k < 3; k++)
                    result[i][j] += m1[i][k] * m2[k][j];

        return result;
    }


    //8.7
    private static void pointsNearestEachOther() {
        double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1},
                {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2},
                {5.5, 4, -0.5}};

        int p1 = 0, p2 = 1; // Initial two points
        double shortestDistance = distance(points[p1][0], points[p1][1], points[p1][2],
                points[p2][0], points[p2][1], points[p2][2]);

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1], points[i][2],
                        points[j][0], points[j][1], points[j][2]); // Find distance

                if (shortestDistance > distance) {
                    p1 = i; // Update p1
                    p2 = j; // Update p2
                    shortestDistance = distance; // Update shortestDistance
                }
            }
        }

        System.out.println("The closest two points are " +
                "(" + points[p1][0] + ", " + points[p1][1] + ", " + points[p1][2] + ") and (" +
                points[p2][0] + ", " + points[p2][1] + ", " + points[p2][2] + ")");
    }

    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
    }

    //8.8
    private static void allClosestPairsOfPoints() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int numberOfPoints = input.nextInt();

        // Create an array to store points
        double[][] points = new double[numberOfPoints][2];
        System.out.print("Enter " + numberOfPoints + " points: ");
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        // p1 and p2 are the indices in the points array
        int p1 = 0, p2 = 1; // Initial two points
        double shortestDistance = distance(points[p1][0], points[p1][1],
                points[p2][0], points[p2][1]); // Initialize shortestDistance

        int[][] shortestDistances = new int[numberOfPoints][2];
        int idx = 0;

        // Compute distance for every two points
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1],
                        points[j][0], points[j][1]); // Find distance

                if (shortestDistance > distance) {
                    shortestDistance = distance; // Update shortestDistance
                    shortestDistances[0][0] = i;
                    shortestDistances[0][1] = j;
                    idx = 0;
                } else if (shortestDistance == distance) {
                    shortestDistances[idx][0] = i;
                    shortestDistances[idx][1] = j;
                    idx++;
                }
            }
        }

        for (int i = 0; i < idx; i++) {
            int point1 = shortestDistances[i][0];
            int point2 = shortestDistances[i][1];

            System.out.println("The closest two points are " +
                    "(" + points[point1][0] + ", " + points[point1][1] + ") and (" +
                    points[point2][0] + ", " + points[point2][1] + ")");
        }
        System.out.println("Their distance is " + shortestDistance);
    }

    public static double distance(
            double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    //8.9
    private static void ticTacToe() {
        Scanner input = new Scanner(System.in);
        String[][] board = new String[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " ";
            }
        }

        boolean isStillPlaying = true;
        boolean isX = false;
        String winner = "";

        while (isStillPlaying) {
            isX = !isX;
            printBoard(board);

            System.out.print("Enter a row (0, 1, or 2) for player " + (isX ? " X: " : "0: "));
            int row = input.nextInt();

            System.out.print("Enter a column (0, 1, or 2) for player " + (isX ? " X: " : "0: "));
            int column = input.nextInt();

            if (board[row][column].equals(" ")) {
                board[row][column] = isX ? "X" : "O";
            } else {
                System.out.println("Spot is taken, please select a different spot.");
                isX = !isX;
                continue;
            }

            winner = checkBoard(board);

            if (!winner.isEmpty()) {
                isStillPlaying = false;
            }
        }

        printBoard(board);
        System.out.println(winner + " player won");
    }

    private static void printBoard(String[][] board) {
        System.out.println("-------------");

        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static String checkBoard(String[][] board) {
        String winner = "";
        //check rows
        int numOfSameCharsInRow = 0;
        int numberOfSelectedCharsTotal = 0;

        for (int i = 0; i < board.length; i++) {
            String firstCharInRow = board[i][0];
            if (Objects.equals(firstCharInRow, " ")) {
                continue;
            }
            numOfSameCharsInRow++;
            numberOfSelectedCharsTotal++;

            for (int j = 1; j < board[i].length; j++) {
                if (firstCharInRow.equals(board[i][j])) {
                    numOfSameCharsInRow++;
                    numberOfSelectedCharsTotal++;
                } else if (!board[i][j].equals(" ")) {
                    numberOfSelectedCharsTotal++;
                }
            }

            if (numOfSameCharsInRow == board[i].length) {
                winner = firstCharInRow;
                break;
            }
            numOfSameCharsInRow = 0;
        }

        //check columns
        int numOfCharsInColumn = 0;
        for (int col = 0; col < board[0].length; col++) {
            String firstCharOfColumn = board[0][col];
            if (Objects.equals(firstCharOfColumn, " ")) {
                continue;
            }
            numOfCharsInColumn++;
            for (int row = 1; row < board.length; row++) {
                if (firstCharOfColumn.equals(board[row][col])) {
                    numOfCharsInColumn++;
                }
            }

            if (numOfCharsInColumn == board[col].length) {
                winner = firstCharOfColumn;
                break;
            }
            numOfCharsInColumn = 0;
        }

        //check first diagonal
        String firstCharOfDiagonal = board[0][0];
        if (!Objects.equals(firstCharOfDiagonal, " ")) {
            int numberOfCharsInFirstDiagonal = 1;
            for (int i = 1; i < board.length; i++) {
                if (firstCharOfDiagonal.equals(board[i][i])) {
                    numberOfCharsInFirstDiagonal++;
                }
            }

            if (numberOfCharsInFirstDiagonal == 3) {
                winner = firstCharOfDiagonal;
            }
        }

        //check second diagonal
        String firstCharOfSecondDiagonal = board[board.length - 1][board.length - 1];
        if (!Objects.equals(firstCharOfSecondDiagonal, " ")) {
            int numberOfCharsInSecondDiagonal = 1;
            for (int i = 1; i >= 0; i--) {
                if (firstCharOfSecondDiagonal.equals(board[i][i])) {
                    numberOfCharsInSecondDiagonal++;
                }
            }

            if (numberOfCharsInSecondDiagonal == 3) {
                winner = firstCharOfSecondDiagonal;
            }
        }

        if (numberOfSelectedCharsTotal == (board.length * board[0].length) && winner.isEmpty()) {
            winner = "No";
        }

        return winner;
    }

    //8.10
    private static void largestRowAndColumn() {
        int[][] m = new int[4][4];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = (int) (Math.random() * 2);
                System.out.print(m[i][j]);
            }
            System.out.println();
        }

        int r = 0;
        int c = 0;

        int largestAmountOf1 = 0;

        for (int i = 0; i < m.length; i++) {
            int sum = 0;
            for (int j = 0; j < m.length; j++) {
                sum += m[i][j];
            }

            if (largestAmountOf1 < sum) {
                largestAmountOf1 = sum;
                r = i;
            }
        }

        largestAmountOf1 = 0;
        int column = 0;
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < m.length; j++) {
                sum += m[j][column];
            }

            if (largestAmountOf1 < sum) {
                largestAmountOf1 = sum;
                c = i;
            }
        }
        System.out.println("The largest row index: " + r);
        System.out.println("The largest column index: " + c);
    }

    //8.11
    private static void headsAndTails() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number between 0 and 511: ");
        int num = input.nextInt();

        String binary = Integer.toBinaryString(num);

        int numsBeforeBinary = 9 - binary.length();
        int totalInRow = 0;

        for (int i = 0; i < numsBeforeBinary; i++) {
            if (totalInRow == 3) {
                System.out.println();
                totalInRow = 0;
            }

            System.out.print("H");
            totalInRow++;
        }

        for (int i = 0; i < binary.length(); i++) {
            if (totalInRow == 3) {
                System.out.println();
                totalInRow = 0;
            }

            if (binary.charAt(i) == '0') {
                System.out.print("H");
            } else {
                System.out.print("T");
            }
            totalInRow++;
        }
    }

    //8.12
    private static void computeTax() {
        Scanner input = new Scanner(System.in);

        System.out.print("(0-single filer, 1-married jointly or " +
                "qualifying widow(er), 2-married separately, 3-head of " +
                "household) Enter the filing status: ");

        int status = input.nextInt();

        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();

        int[][] brackets = {
                {8350, 33950, 82250, 171550, 372950}, // Single filer
                {16700, 67900, 137050, 20885, 372950}, // Married jointly −or qualifying widow(er)
                {8350, 33950, 68525, 104425, 186475}, // Married separately
                {11950, 45500, 117450, 190200, 372950} // Head of household
        };

        double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

        int[] relevantBracket = brackets[status];
        Integer idx = null;

        for (int i = 0; i < relevantBracket.length; i++) {
            if (income <= relevantBracket[i]) {
                idx = i;
                break;
            }
        }

        if (idx == null) {
            idx = 5;
        }

        double tax = relevantBracket[0] * rates[0];

        for (int i = 1; i <= idx; i++) {
            if (i == 5) {
                tax += (income - relevantBracket[4]) * rates[i];
                break;
            }

            tax += ((relevantBracket[i] - relevantBracket[i - 1]) * rates[i]);
        }

        System.out.print("Tax for income " + income + " is " + tax);
    }

    //8.13
    private static void locateLargestElement() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of the array: ");

        int row = input.nextInt();
        int col = input.nextInt();

        double[][] arr = new double[row][col];

        for (int i = 0; i < row; i++) {
            System.out.println("Enter the array: ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = input.nextDouble();
            }
        }

        double largest = arr[0][0];
        int lRow = 0;
        int lCol = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] > largest) {
                    largest = arr[i][j];
                    lRow = i;
                    lCol = j;
                }
            }
        }

        System.out.println("The location of the largest element is at (" + lRow + ", " + lCol + ")");
    }

    //8.14
    private static void exploreMatrix() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size for the matrix: ");
        int size = input.nextInt();

        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = (int) (Math.random() * 2);
            }
        }

        checkRow(arr);
        checkColumn(arr);
        checkMajorDiagonal(arr);
        checkSubDiagonal(arr);
    }

    private static void checkRow(int[][] arr) {
        int[][] sameNums = new int[arr.length][2];
        int totalOfSame = 0;

        int totalNumOfSameNum = 0;

        for (int i = 0; i < arr.length; i++) {
            int firstNumInRow = arr[i][0];

            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == firstNumInRow) {
                    totalNumOfSameNum++;
                }
            }

            if (totalNumOfSameNum == arr[i].length - 1) {
                sameNums[totalOfSame] = new int[]{firstNumInRow, i};
                totalOfSame++;
            }

            totalNumOfSameNum = 0;
        }

        if (totalOfSame == 0) {
            System.out.println("No same numbers on a row");
        } else {
            for (int i = 0; i < totalOfSame; i++) {
                int num = sameNums[i][0];
                int row = sameNums[i][1];

                System.out.println("All " + num + "s on row " + row);
            }
        }
    }

    private static void checkColumn(int[][] arr) {
        int[][] sameNums = new int[arr.length][2];
        int totalOfSame = 0;

        int totalNumOfSameNum = 0;

        for (int col = 0; col < arr[0].length; col++) {
            int firstNumInCol = arr[0][col];

            for (int row = 1; row < arr.length; row++) {
                if (arr[row][col] == firstNumInCol) {
                    totalNumOfSameNum++;
                }
            }

            if (totalNumOfSameNum == arr[0].length - 1) {
                sameNums[totalOfSame] = new int[]{firstNumInCol, col};
                totalOfSame++;
            }
            totalNumOfSameNum = 0;
        }

        if (totalOfSame == 0) {
            System.out.println("No same numbers on a column");
        } else {
            for (int i = 0; i < totalOfSame; i++) {
                int num = sameNums[i][0];
                int column = sameNums[i][1];

                System.out.println("All " + num + "s in column " + column);
            }
        }
    }

    private static void checkMajorDiagonal(int[][] arr) {
        int totalNumOfSameNum = 0;
        int firstNumOfDiagonal = arr[0][0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][i] == firstNumOfDiagonal) {
                totalNumOfSameNum++;
            }
        }

        if (totalNumOfSameNum == arr[0].length - 1) {
            System.out.println("All " + firstNumOfDiagonal + "s on the major diagonal");
        } else {
            System.out.println("No same numbers on the major diagonal");
        }
    }

    private static void checkSubDiagonal(int[][] arr) {
        int totalNumOfSameNum = 0;
        int firstNumOfDiagonal = arr[0][arr[0].length - 1];

        for (int i = 1; i < arr[0].length; i++) {
            if (arr[i][arr[i].length - 1 - i] == firstNumOfDiagonal) {
                totalNumOfSameNum++;
            }
        }

        if (totalNumOfSameNum == arr[0].length - 1) {
            System.out.println("All " + firstNumOfDiagonal + "s on the sub diagonal");
        } else {
            System.out.println("No same numbers on the sub diagonal");
        }
    }

    //8.15
    private static void sameLine() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter five points: ");

        double[][] points = new double[5][2];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                points[i][j] = input.nextDouble();
            }
        }

        boolean isOnTheSameLine = false;
        for (int i = 0; i < points.length - 2; i++) {
            isOnTheSameLine = onTheSameLine(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1], points[i + 2][0], points[i + 2][1]);

            if (!isOnTheSameLine) {
                break;
            }
        }

        if (isOnTheSameLine) {
            System.out.println("The five points are on the same line");
        } else {
            System.out.println("The five points are not on the same line");
        }
    }

    public static boolean onTheSameLine(double x0, double y0,
                                        double x1, double y1, double x2, double y2) {
        double position = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return position == 0.0;
    }

    //8.16
    private static void sortTwoDimensionalArray() {
        int[][] m = new int[][]{{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}};

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][0] < m[j][0]) { //sort by rows
                    int[] temp = m[i];
                    m[i] = m[j];
                    m[j] = temp;
                } else if (m[i][0] == m[j][0]) { //sort by columns
                    if (m[i][1] < m[j][1]) {
                        int[] temp = m[i];
                        m[i] = m[j];
                        m[j] = temp;
                    }
                }
            }
        }

        for (int[] ints : m) {
            System.out.print(Arrays.toString(ints) + ",");
        }
    }

    //8.17
    private static void financialTsunami() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of banks and the safety limit");
        int banks = input.nextInt();
        double limit = input.nextDouble();

        double[][][] borrowers = new double[banks][][];
        double[] totalAssets = new double[banks];

        for (int i = 0; i < banks; i++) {
            System.out.println("Enter bank assests: ");
            double bankBalance = input.nextDouble();

            int numOfBanksLendedTo = input.nextInt();
            borrowers[i] = new double[numOfBanksLendedTo][2];

            for (int j = 0; j < numOfBanksLendedTo; j++) {
                int bankNum = input.nextInt();
                double amountBorrowed = input.nextDouble();

                bankBalance += amountBorrowed;

                borrowers[i][j] = new double[]{bankNum, amountBorrowed};
                totalAssets[i] = bankBalance;
            }
        }

        for (int i = 0; i < banks; i++) {
            double totalBankAssets = totalAssets[i];

            double[][] banksWhoBorrowed = borrowers[i];

            for (int j = 0; j < banksWhoBorrowed.length; j++) {
                int bankWhichBorrowed = (int) banksWhoBorrowed[j][0]; //id of bank which borrowed
                if (totalAssets[bankWhichBorrowed] < limit) {
                    totalBankAssets -= banksWhoBorrowed[j][1];
                    banksWhoBorrowed[j][1] = 0;
                }
            }
            totalAssets[i] = totalBankAssets;
        }

        System.out.print("Unsafe banks are ");
        for (int i = 0; i < totalAssets.length; i++) {
            if (totalAssets[i] < limit) {
                System.out.print(i + " ");
            }
        }
    }

    //8.18
    private static void shuffleRows() {
        int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};

        for (int i = 0; i < m.length; i++) {
            int newIdx = (int) (Math.random() * m.length);
            int temp = m[i][0];
            m[i][0] = m[newIdx][0];
            m[newIdx][0] = temp;
        }

        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]) + ", ");
        }
    }

    //8.19
    private static void patternRecognition() {
        Scanner input = new Scanner(System.in);

        System.out.println("Number of rows: ");
        int rows = input.nextInt();
        System.out.println("Number of columns: ");
        int col = input.nextInt();

        int[][] m = new int[rows][col];

        for (int i = 0; i < rows; i++) {
            System.out.println("Enter row: ");
            for (int j = 0; j < col; j++) {
                m[i][j] = input.nextInt();
            }
        }

        if (checkRows(m)) {
            System.out.println("true");
        } else if (checkColumns(m)) {
            System.out.println("true");
        } else if (checkForwardDiagonals(m)) {
            System.out.println("true");
        } else if (checkBackwardsDiagonals(m)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean checkRows(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            int numOfConsecutives = 1;
            int numOfPrevious = m[i][0];

            for (int j = 1; j < m[i].length; j++) {
                if (numOfConsecutives == 4) {
                    return true;
                }

                if (m[i][j] == numOfPrevious) {
                    numOfConsecutives++;
                } else {
                    numOfPrevious = m[i][j];
                    numOfConsecutives = 1;
                }
            }
        }

        return false;
    }

    private static boolean checkColumns(int[][] m) {
        for (int col = 0; col < m[0].length; col++) {
            int numOfConsecutives = 1;
            int numOfPrevious = m[0][col];

            for (int row = 1; row < m.length; row++) {
                if (numOfConsecutives == 4) {
                    return true;
                }

                if (m[row][col] == numOfPrevious) {
                    numOfConsecutives++;
                } else {
                    numOfPrevious = m[row][col];
                    numOfConsecutives = 1;
                }
            }
        }

        return false;
    }

    private static boolean checkForwardDiagonals(int[][] m) {
        int numOfConsecutives = 1;
        for (int i = 0; i < m.length; i++) { //need to go row by row --> column by column + row by row, increasing the row# each time
            for (int j = 0; j < m[i].length - 4; j++) {//going column by column, stopping 4 before because no point in continuing as anything beyond won't resolve in 4 of the same
                if (numOfConsecutives == 4) {
                    return true;
                }

                numOfConsecutives = 1;
                int numOfPrevious = m[i][j];

                int col = j + 1;
                int row = i + 1;

                while (row < m.length && col < m[i].length) {
                    if (numOfConsecutives == 4) {
                        return true;
                    }

                    if (m[row][col] == numOfPrevious) {
                        numOfConsecutives++;
                    } else {
                        break; //beacuse will check the rest of the diagonal in further iterations of the rows
                    }

                    col++;
                    row++;
                }
            }
        }

        return false;
    }

    private static boolean checkBackwardsDiagonals(int[][] m) {
        int numOfConsecutives = 1;

        for (int i = 0; i < m.length; i++) { //need to go row by row --> column by column + row by row, increasing the row# each time
            for (int j = m[i].length - 1; j >= 3; j--) { //going column by column, stopping at index 3 because anything less won't produce 4 of the ame
                if (numOfConsecutives == 4) {
                    return true;
                }
                numOfConsecutives = 1;
                int numOfPrevious = m[i][j];

                int col = j - 1;
                int row = i + 1;

                while (row < m.length && col >= 0) {
                    if (numOfConsecutives == 4) {
                        return true;
                    }

                    if (m[row][col] == numOfPrevious) {
                        numOfConsecutives++;
                    } else {
                        break;
                    }

                    col--;
                    row++;
                }
            }
        }

        return false;
    }

    //8.20
    private static void connectFour() {
        Scanner input = new Scanner(System.in);
        String[][] board = new String[6][7];

        for (String[] strings : board) {
            Arrays.fill(strings, " ");
        }

        boolean isStillPlaying = true;
        boolean isRed = false;
        String winner = "";

        while (isStillPlaying) {
            isRed = !isRed;
            printConnectFourBoard(board);

            System.out.print("Drop a" + (isRed ? " red" : " yellow") + " disk at column (0-6): ");
            int column = input.nextInt();

            if (column > board.length) {
                System.out.println("Invalid number - please select a column betwee 0 and 6");
                isRed = !isRed;
                continue;
            }

            dropDisk(board, column, isRed);

            winner = checkConnectFourBoard(board, column);

            if (!winner.isEmpty()) {
                isStillPlaying = false;
            }
        }

        printConnectFourBoard(board);

        System.out.println((winner.equals("R") ? "The red" : winner.equals("Y") ? "The yellow" : winner) + " player won");
    }

    private static void dropDisk(String[][] board, int column, boolean isRed) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (Objects.equals(board[row][column], " ")) {
                board[row][column] = isRed ? "R" : "Y";
                break;
            }
        }
    }

    private static String checkConnectFourBoard(String[][] board, int column) {
        String columns = checkConnectFourColumns(board, column);
        if (!columns.isEmpty()) {
            return columns;
        }

        String rows = checkConnectFourRows(board);
        if (!rows.isEmpty()) {
            return rows;
        }

        String forwardDiagonal = checkConnectFourForwardDiagonal(board);
        if (!forwardDiagonal.isEmpty()) {
            return forwardDiagonal;
        }

        String reverseDiagonal = checkConnectFourReverseDiagonal(board);
        if (!reverseDiagonal.isEmpty()) {
            return reverseDiagonal;
        }

        return "";
    }

    private static String checkConnectFourColumns(String[][] board, int column) {
        int numOfSame = 1;

        for (int row = board.length - 2; row >= 0; row--) {
            if (board[row][column].equals(" ")) {
                break;
            }

            if (board[row][column].equals(board[row + 1][column])) {
                numOfSame++;
            } else {
                numOfSame = 1;
            }

            if (numOfSame == 4) {
                return board[row][column];
            }
        }

        return "";
    }

    private static String checkConnectFourRows(String[][] board) {
        int totalBoardFull = 0;

        for (int row = board.length - 1; row >= 0; row--) {
            if (totalBoardFull == board.length * board[0].length) {
                return "No";
            }

            int numOfSame = 1;
            for (int col = 1; col < board[row].length; col++) {
                if (!board[row][col].equals(" ") && board[row][col].equals(board[row][col - 1])) {
                    numOfSame++;
                } else {
                    numOfSame = 1;
                }

                if (numOfSame == 4) {
                    return board[row][col];
                }

                totalBoardFull++;
            }
        }

        return "";
    }

    private static String checkConnectFourForwardDiagonal(String[][] board) {
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length - 4; j++) {
                String first = board[i][j];
                int numOfSame = 1;

                int row = i - 1;
                int col = j + 1;

                while (row >= 0 && col < board[i].length) {
                    if (board[row][col].equals(" ") || !board[row][col].equals(first)) {
                        break;
                    } else {
                        numOfSame++;
                    }

                    if (numOfSame == 4) {
                        return first;
                    }

                    row--;
                    col++;
                }
            }
        }

        return "";
    }

    private static String checkConnectFourReverseDiagonal(String[][] board) {
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = board[i].length - 1; j >= 3; j--) {
                String first = board[i][j];
                int numOfSame = 1;

                int row = i - 1;
                int col = j - 1;

                while (row >= 0 && col >= 0) {
                    if (board[row][col].equals(" ") || !board[row][col].equals(first)) {
                        break;
                    } else {
                        numOfSame++;
                    }

                    if (numOfSame == 4) {
                        return first;
                    }

                    row--;
                    col--;
                }
            }
        }

        return "";
    }

    private static void printConnectFourBoard(String[][] board) {
        for (String[] strings : board) {
            System.out.print("|");
            for (String string : strings) {
                System.out.print(" " + string + " |");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    //8.21
    private static void centralCity() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of cities: ");
        int num = input.nextInt();

        double[][] cities = new double[num][2];

        System.out.println("Enter the coordinates of the cities: ");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < cities[i].length; j++) {
                cities[i][j] = input.nextDouble();
            }
        }

        double shortestTotalToOtherCities = 0;
        int indexOfShortest = 0;

        for (int i = 0; i < cities.length; i++) {
            double totalDistance = 0;
            double x1 = cities[i][0];
            double y1 = cities[i][1];

            for (int j = 0; j < cities.length; j++) {
                if (i == j) {
                    continue;
                }

                double x2 = cities[j][0];
                double y2 = cities[j][1];

                totalDistance += distanceToCities(x1, y1, x2, y2);
            }
            if (shortestTotalToOtherCities == 0) {
                shortestTotalToOtherCities = totalDistance;
            } else if (shortestTotalToOtherCities > totalDistance) {
                shortestTotalToOtherCities = totalDistance;
                indexOfShortest = i;
            }
        }

        System.out.println("The central city is at (" + cities[indexOfShortest][0] + ", " + cities[indexOfShortest][1] + ")");
        System.out.println("The total distance to all other cities is " + shortestTotalToOtherCities);

    }

    private static double distanceToCities(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    //8.23
    private static void evenNumber1s() {
        int[][] m = new int[6][6];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random() * 2);
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        //check rows
        boolean evenNumOf1s = false;

        for (int i = 0; i < m.length; i++) {
            int numOf1s = 0;
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) {
                    numOf1s++;
                }
            }

            if (numOf1s % 2 == 0) {
                evenNumOf1s = true;
            } else {
                break;
            }
        }

        if (!evenNumOf1s) {
            System.out.println("Not even number of 1s");
        } else {
            for (int col = 0; col < m[0].length; col++) {
                int numOf1s = 0;
                for (int row = 0; row < m.length; row++) {
                    if (m[row][col] == 1) {
                        numOf1s++;
                    }
                }

                if (numOf1s % 2 != 0) {
                    evenNumOf1s = false;
                    break;
                }
            }

            if (evenNumOf1s) {
                System.out.println("There are an even number of ones in all columns and rows");
            } else {
                System.out.println("Not even number of 1s");
            }
        }
    }

    //8.23
    private static void findTheFlippedCell() {
        Scanner input = new Scanner(System.in);

        int[][] m = new int[6][6];

        System.out.println("Enter a 6−by−6 matrix row by row: ");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = input.nextInt();
            }
        }

        int row = 0;
        int col = 0;

        for (int i = 0; i < m.length; i++) {
            int numOf0s = 0;
            int numOf1s = 0;

            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    numOf0s++;
                } else {
                    numOf1s++;
                }
            }
            if (numOf1s % 2 != 0 || numOf0s % 2 != 0) {
                row = i;
                break;
            }
        }

        for (int c = 0; c < m[0].length; c++) {
            int numOf0sCol = 0;
            int numOf0sRow = 0;

            for (int r = 0; r < m.length; r++) {
                if (m[r][c] == 0) {
                    numOf0sCol++;
                } else {
                    numOf0sRow++;
                }
            }

            if (numOf0sCol % 2 != 0 || numOf0sRow % 2 != 0) {
                col = c;
                break;
            }
        }

        System.out.println("The flipped cell is at (" + row + ", " + col + ")");
    }

    //8.24
    private static void checkSudoku() {
        // Read a Sudoku solution
        int[][] grid = readASolution();

        System.out.println(isValid(grid) ? "Valid solution"
                : "Invalid solution");
    }

    public static int[][] readASolution() {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Sudoku puzzle solution:");
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                grid[i][j] = input.nextInt();

        return grid;
    }

    /**
     * Check whether grid[i][j] is valid in the grid
     */
    public static boolean isValid(int[][] grid) {
        //check rows
        for (int row = 0; row < grid.length; row++) {
            boolean[] exists = new boolean[grid.length];

            for (int col = 0; col < grid[row].length; col++) {
                if (exists[grid[row][col] - 1]) {
                    return false;
                } else {
                    exists[grid[row][col] - 1] = true;
                }
            }
        }

        // check columns
        for (int column = 0; column < grid[0].length; column++) {
            boolean[] exists = new boolean[grid.length];
            for (int row = 0; row < grid.length; row++) {
                if (exists[grid[row][column] - 1]) {
                    return false;
                } else {
                    exists[grid[row][column] - 1] = true;
                }
            }
        }

        // Check whether grid[i][j] is valid in the 3 by 3 box
        for (int row = 0; row < grid.length; row += 2) {
            boolean[] exists = new boolean[grid.length];
            for (int col = 0; col <= grid[row].length; col += 2) {
                if (exists[grid[row][col] - 1]) {
                    return false;
                } else {
                    exists[grid[row][col] - 1] = true;
                }
            }
        }

        return true;
    }

    //8.25
    private static void isMarkovMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3−by−3 matrix row by row:");

        double[][] m = new double[3][3];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = input.nextDouble();
            }
        }

        boolean isMarkov = true;
        for (int col = 0; col < m[0].length; col++) {
            double sumOfCol = 0;
            for (int row = 0; row < m.length; row++) {
                if (m[row][col] < 0) {
                    isMarkov = false;
                    break;
                }

                sumOfCol += m[row][col];
            }

            if (!isMarkov) {
                break;
            }

            if (sumOfCol != 1) {
                isMarkov = false;
                break;
            }
        }

        System.out.println(isMarkov ? "It is a Markov Matrix" : "It is not a Markov matrix");
    }

    //8.26
    private static void rowSorting() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3−by−3 matrix row by row:");

        double[][] m = new double[3][3];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = input.nextDouble();
            }
        }

        double[][] sortedArray = sortRows(m);

        System.out.println("The row sorted array is ");
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 0; j < sortedArray[i].length; j++) {
                System.out.print(sortedArray[i][j] + " ");

                if (j == sortedArray[i].length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public static double[][] sortRows(double[][] m) {
        double[][] returnArray = new double[3][3];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                for (int k = j + 1; k < m[i].length; k++) {
                    if (m[i][j] > m[i][k]) {
                        double temp = m[i][j];
                        m[i][j] = m[i][k];
                        m[i][k] = temp;
                    }
                }

                for (int l = 0; l < m.length; l++) {
                    returnArray[i][l] = m[i][l];
                }
            }
        }

        return returnArray;
    }

    //8.27
    private static void columnSorting() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3−by−3 matrix row by row:");

        double[][] m = new double[3][3];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = input.nextDouble();
            }
        }

        double[][] sortedArray = sortColumns(m);

        System.out.println("The column sorted array is ");
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 0; j < sortedArray[i].length; j++) {
                System.out.print(sortedArray[i][j] + " ");

                if (j == sortedArray[i].length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public static double[][] sortColumns(double[][] m) {
        double[][] returnArray = new double[3][3];

        for (int col = 0; col < m[0].length; col++) {
            for (int row = 0; row < m.length; row++) {
                for (int row1 = 0; row1 < m.length; row1++) {
                    if (m[row][col] < m[row1][col]) {
                        double temp = m[row][col];
                        m[row][col] = m[row1][col];
                        m[row1][col] = temp;
                    }
                }

                for (int l = 0; l < m.length; l++) {
                    returnArray[l][col] = m[l][col];
                }
            }
        }

        return returnArray;
    }

    //8.28
    private static void strictlyIdenticalArrays() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter list1:");
        int[][] l1 = new int[3][3];

        for (int i = 0; i < l1.length; i++) {
            for (int j = 0; j < l1[i].length; j++) {
                l1[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter list2:");
        int[][] l2 = new int[3][3];

        for (int i = 0; i < l2.length; i++) {
            for (int j = 0; j < l2[i].length; j++) {
                l2[i][j] = input.nextInt();
            }
        }

        boolean isStrictlyEqual = true;

        for (int i = 0; i < l1.length; i++) {
            isStrictlyEqual = Arrays.equals(l1[i], l2[i]);

            if (!isStrictlyEqual) {
                break;
            }
        }

        System.out.println(isStrictlyEqual ? "The two arrays are strictly equal " : "The two arrays are not strictly equal");
    }

    //8.29
    private static void identicalArrays() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter list1:");
        int[][] l1 = new int[3][3];

        for (int i = 0; i < l1.length; i++) {
            for (int j = 0; j < l1[i].length; j++) {
                l1[i][j] = input.nextInt();
            }
        }

        sortArrays(l1);

        System.out.println("Enter list2:");
        int[][] l2 = new int[3][3];

        for (int i = 0; i < l2.length; i++) {
            for (int j = 0; j < l2[i].length; j++) {
                l2[i][j] = input.nextInt();
            }
        }

        sortArrays(l2);

        boolean isEqual = true;

        for (int i = 0; i < l1.length; i++) {
            isEqual = Arrays.equals(l1[i], l2[i]);

            if (!isEqual) {
                break;
            }
        }

        System.out.println(isEqual ? "The two arrays are identical " : "The two arrays are not identical");
    }

    private static void sortArrays(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                for (int k = j + 1; k < m[i].length; k++) {
                    if (m[i][j] > m[i][k]) {
                        int temp = m[i][j];
                        m[i][j] = m[i][k];
                        m[i][k] = temp;
                    }
                }
            }
        }
    }

    //8.30
    private static void solveLinearEquations() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the a matrix: ");
        double[][] a = new double[2][2];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = input.nextDouble();
            }
        }

        double[] b = new double[2];
        System.out.println("Enter the b0 and b1 : ");
        for (int i = 0; i < b.length; i++) {
            b[i] = input.nextDouble();
        }

        double sumOfAs = a[0][0] * a[1][1] - a[0][1] * a[1][0];

        if (sumOfAs == 0) {
            System.out.println("The equation has no solution");
        } else {
            double x = (b[0] * a[1][1] - b[1] * a[0][1]) / sumOfAs;
            double y = (b[1] * a[0][0] - b[0] * a[1][0]) / sumOfAs;

            System.out.println("x is " + x + " and y is " + y);
        }
    }

    //8.31
    private static void intersectingPoint() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the 4 points: ");
        double[][] points = new double[4][2];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = input.nextDouble();
            }
        }

        double x0 = points[0][0];
        double y0 = points[0][1];
        double x1 = points[1][0];
        double y1 = points[1][1];
        double x2 = points[2][0];
        double y2 = points[2][1];
        double x3 = points[3][0];
        double y3 = points[3][1];

        double a1 = y0 - y1;
        double b1 = -(x0 - x1);
        double c1 = a1 * x0 - (x0 - x1) * y0;

        double a2 = y2 - y3;
        double b2 = -(x2 - x3);
        double c2 = a2 * x2 - (x2 - x3) * y2;

        double adbc = a1 * b2 - a2 * b1;

        double e = c1 * b2 - c2 * b1;
        double f = a1 * c2 - a2 * c1;


        if (adbc == 0) {
            System.out.println("The two lines are parallel");
        } else {
            double x = e / adbc;
            double y = f / adbc;

            System.out.println("The intersecting point is at (" + x + ", " + y + ")");
        }
    }

    //8.32
    private static void areaOfATriangle() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the 3 points of a triangle: ");
        double[][] points = new double[3][2];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = input.nextDouble();
            }
        }

        double x0 = points[0][0];
        double y0 = points[0][1];
        double x1 = points[1][0];
        double y1 = points[1][1];
        double x2 = points[2][0];
        double y2 = points[2][1];

        double side1 = Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
        double side2 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double side3 = Math.sqrt((x2 - x0) * (x2 - x0) + (y2 - y0) * (y2 - y0));

        double s = (side1 + side2 + side3) / 2;

        double beforeSquareRoot = s * (s - side1) * (s - side2) * (s - side3);

        if (beforeSquareRoot <= 0) {
            System.out.println("The point are on the same line");
        } else {
            double areaOfTriangle = Math.sqrt(beforeSquareRoot);
            System.out.println("The area of the triangle is " + areaOfTriangle);
        }
    }

    //8.33
    private static void polygonSubareas() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the 4 vertices: ");
        double[][] points = new double[4][2];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = input.nextDouble();
            }
        }

        double x1 = points[0][0];
        double y1 = points[0][1];
        double x2 = points[1][0];
        double y2 = points[1][1];
        double x3 = points[2][0];
        double y3 = points[2][1];
        double x4 = points[3][0];
        double y4 = points[3][1];

        //get the intersecting points
        double a1 = y1 - y3;
        double b1 = -(x1 - x3);
        double c1 = a1 * x1 - (x1 - x3) * y1;

        double a2 = y2 - y4;
        double b2 = -(x2 - x4);
        double c2 = a2 * x2 - (x2 - x4) * y2;

        double adbc = a1 * b2 - a2 * b1;

        double e = c1 * b2 - c2 * b1;
        double f = a1 * c2 - a2 * c1;

        double x = e / adbc;
        double y = f / adbc;

        double[] areas = new double[4];

        //calculate the areas of the triangles

        for (int i = 0; i < points.length; i++) {
            double pt1x;
            double pt1y;

            if (i == points.length - 1) {
                pt1x = points[0][0];
                pt1y = points[0][1];
            } else {
                pt1x = points[i + 1][0];
                pt1y = points[i + 1][1];
            }

            double pt0x = points[i][0];
            double pt0y = points[i][1];

            double side1 = Math.sqrt((pt1x - pt0x) * (pt1x - pt0x) + (pt1y - pt0y) * (pt1y - pt0y));
            double side2 = Math.sqrt((x - pt1x) * (x - pt1x) + (y - pt1y) * (y - pt1y));
            double side3 = Math.sqrt((x - pt0x) * (x - pt0x) + (y - pt0y) * (y - pt0y));

            double s = (side1 + side2 + side3) / 2;
            double beforeSquareRoot = s * (s - side1) * (s - side2) * (s - side3);
            areas[i] = Math.sqrt(beforeSquareRoot);
        }

        Arrays.sort(areas);
        System.out.println("Area of the polygon is " + Arrays.toString(areas));
    }

    //8.34
    private static void rightmostLowestPoint() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the 6 points: ");
        double[][] points = new double[6][2];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = input.nextDouble();
            }
        }

        for (int col = 0; col < points[0].length; col++) {
            for (int row = 0; row < points.length; row++) {
                for (int row1 = 0; row1 < points.length; row1++) {
                    if (points[row][col] < points[row1][col]) {
                        double[] temp = points[row];
                        points[row] = points[row1];
                        points[row1] = temp;
                    }
                }
            }
        }

        if (points[0][1] > points[1][1]) {
            System.out.println("The rightmost lowest point is (" + points[0][0] + "," + points[0][1] + ")");
        } else {
            System.out.println("The rightmost lowest point is (" + points[1][0] + "," + points[1][1] + ")");
        }
    }

    //8.35
    private static void largestBlock() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows in the matrix: ");
        int rows = input.nextInt();

        int[][] m = new int[rows][5];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = input.nextInt();
            }
        }

        int p1 = 0;
        int p2 = 0;

        int totalInRow = 0;
        int totalSize = 0;

        for (int i = 0; i < m.length - 1; i++) {
            int rowInLoop = 0;
            int colInLoop = 0;
            int lastColInLoop = 0;

            int totalAmountOf1sInRow = 0;
            for (int j = 0; j < m[i].length - 1; j++) {
                if (m[i][j] == 1) {
                    if (totalAmountOf1sInRow == 0) { //because this is the first 1
                        rowInLoop = i;
                        colInLoop = j;
                    }
                    totalAmountOf1sInRow++;
                } else {
                    if (totalInRow < totalAmountOf1sInRow && j != 0) {
                        lastColInLoop = j - 1;
                        totalInRow = totalAmountOf1sInRow;
                    }
                    totalAmountOf1sInRow = 0;
                }
            }

            if (lastColInLoop == 0) {
                lastColInLoop = m[i].length - 1;
            }

            int totalInColumn = 0;
            boolean countThisMatrix = true;
            if (totalInRow > 1) {
                int maxRowLength = m.length;
                for (int col = colInLoop; col <= lastColInLoop; col++) {
                    for (int row = i + 1; row < maxRowLength; row++) {
                        if (m[row][col] == 1) {
                            totalInColumn++;
                        } else {
                            maxRowLength = row;
                            break;
                        }
                    }

                    if (maxRowLength == i + 1) {
                        countThisMatrix = false;
                        break;
                    }
                }

                if (countThisMatrix) {
                    int size = totalInColumn + totalInRow;

                    if (size > totalSize) {
                        p1 = rowInLoop;
                        p2 = colInLoop;
                        totalSize = size;
                    }
                }
            }
        }

        System.out.println("The maximum square submatrix is at (" + p1 + ", " +  p2  + ") with size " + totalSize);
    }

    //8.36
    private static void latinSquare() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Enter number n: ");
        int n = input.nextInt();

        System.out.println("Enter " + n + "rows of letters separated by spaces:");

        char[][] array = new char[n][n];

        boolean isLatinSquare = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char inputtedLetter = input.next().toUpperCase().charAt(0);

                int index = inputtedLetter - 'A';

                if (index >= n) {
                    System.out.println("Wrong input: the letters must be from A to " + (char) ('A' + n - 1));
                    isLatinSquare = false;
                    break;
                } else if (array[i][index] != '\u0000') {
                    isLatinSquare = false;
                    System.out.println("Wrong input: can only be one of each letter ");
                } else {
                    array[i][index] = inputtedLetter;
                }
            }

            if (!isLatinSquare) {
                break;
            }
        }

        if (isLatinSquare) {
            System.out.println("The input array is a Latin square");
        }
    }

    //8.37
    private static void capitals() {
        Scanner input = new Scanner(System.in);

        String[][] capitals = new String[][] {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New Mexico", "Santa Fe"},
                {"New York", "Albany"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };

        int correct = 0;

        for (String[] capital : capitals) {
            System.out.println("What is the capital of " + capital[0]);
            String guess = input.nextLine();

            if (guess.equalsIgnoreCase(capital[1])) {
                correct++;
            }
        }

        System.out.println("You got " + correct + " capitals correct");
    }
}

