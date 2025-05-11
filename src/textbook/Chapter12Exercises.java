package textbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.NoSuchFileException;
import java.util.*;

public class Chapter12Exercises {
    public static void main(String[] args) throws IllegalTriangleException, HexFormatException, IOException {
//        calculatorWithExceptionHandler(new String[]{"3", "+", "true"});
//        inputMismatchException();
//        arrayIndexOutOfBounds();
//        illegalTriangleException();
//        hex2String();
//        bin2Dec();
//        outOfMemoryError();
//        removeText();
//        reformatSourceCode();
//        countCharsWordsLines();
//        processScores();
//        writeReadData();
//        replaceText();
//        hangman();
//        countWords();
//        processScoresInTextFile();
//        largeDataSet();
//        processLargeDataset();
//        createDirectory();
//        createFiles();
//        replaceWords();
//        renameFileName();
//        occurrencesOfEachLetter();
//        babyName();
//        rankingSummary();
        webCrawler();
    }

    //12.1
    private static void calculatorWithExceptionHandler(String[] args) {
        // Check number of strings passed
        if (args.length != 3) {
            System.out.println(
                    "Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }

        int num1;
        int num2;

        try {
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Argument is not of type number: " + e.getMessage());
            return;
        }

        // The result of the operation
        int result = 0;

        // Determine the operator
        switch (args[1].charAt(0)) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '.':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
        }

        // Display result
        System.out.println(num1 + ' ' + args[1] + ' ' + num2 + " = " + result);
    }

    //12.2
    private static void inputMismatchException() {
        Scanner input = new Scanner(System.in);

        boolean inputsCorrect = false;
        int num1 = 0, num2 = 0;

        while (!inputsCorrect) {
            System.out.println("Please enter first number:");
            String first = input.nextLine();

            System.out.println("Please enter second number:");
            String second = input.nextLine();

            try {
                num1 = Integer.parseInt(first);
                num2 = Integer.parseInt(second);
                inputsCorrect = true;
            } catch (NumberFormatException e) {
                System.out.println("Argument is not of type number: " + e.getMessage());
            }
        }

        System.out.println("Result of " + num1 + " + " + num2 + " = " + (num1 + num2));
    }

    //12.2
    private static void arrayIndexOutOfBounds() throws ArrayIndexOutOfBoundsException {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 100 + 1);
            array.add(random);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter chosen index: ");
        int index = input.nextInt();

        if (index > array.size() || index < 0) {
            System.out.println("Index out of bounds: " + index);
            throw new ArrayIndexOutOfBoundsException();
        }

        System.out.println("Number at index " + index + ": " + array.get(index));
    }

    //12.4 - see chapter 11 loan class

    //12.5
    private static void illegalTriangleException() throws IllegalTriangleException {
        Triangle triangle = new Triangle(1.0, 3.0, 5.0);

        System.out.println("Area = " + triangle.getArea());
        System.out.println("Perimeter = " + triangle.getPerimeter());
        System.out.println("Description = " + triangle.toString());
    }

    //12.6
    private static void hex2String() throws HexFormatException {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();

        System.out.println("The decimal value for hex number "
                + hex + " is " + hexToDecimal(hex.toUpperCase()));
    }

    private static int hexToDecimal(String hex) throws HexFormatException {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }

        return decimalValue;
    }

    private static int hexCharToDecimal(char ch) throws HexFormatException {
        if ('A' <= ch && ch <= 'F') {
            return 10 + ch - 'A';
        } else if (Character.isDigit(ch)) { // ch is '0', '1', ..., or '9'
            return ch - '0';
        } else {
            System.out.println("Invalid hex character: " + ch);
            throw new HexFormatException(ch);
        }
    }

    //12.7
    private static void bin2Dec() throws BinaryFormatException {
//        Scanner input = new Scanner(System.in);
//
//        System.out.print("Enter a binary number: ");
//        String binary = input.nextLine();
//
//        int decimalValue;
//
//        try {
//            decimalValue = Integer.parseInt(binary, 2);
//            System.out.println("Binary number " + binary + " is " + decimalValue);
//        } catch (BinaryFormatException e) {
//            System.out.println("Invalid binary number: " + binary);
//            throw new BinaryFormatException(binary);
//        }
    }

    //12.8 is implemented in 12.6
    //12.9 is is impelmented in 12.7

    //12.10
    private static void outOfMemoryError() {
//        try {
//            int[] list = new int[2147483648];
//        }
//        catch (Error ex) {
//            System.out.println("You are running out of memory.");
//        }
//
//        System.out.println("Out of memeroy error");
    }

    //12.11
    private static void removeText() throws FileNotFoundException {
        File file = new File("C:\\dev\\study\\study_code\\src\\textbook\\Note.txt");

        if (!file.exists()) {
            System.out.println("File does not exist");
            throw new FileNotFoundException();
        }

        try (Scanner input = new Scanner(file);
             PrintWriter output = new PrintWriter("C:\\dev\\study\\study_code\\src\\textbook\\Target");) {
            Scanner command = new Scanner(System.in);
            System.out.println("Enter the word you want found");
            String found = command.nextLine();

            System.out.println("Enter the word you want to replace it with");
            String replace = command.nextLine();

            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(found, replace);
                output.println(s2);
            }
        }
    }

    //12.12
    private static void reformatSourceCode() throws FileNotFoundException {
        File file = new File("C:\\dev\\study\\study_code\\src\\textbook\\JavaSourceCode.txt");

        if (!file.exists()) {
            System.out.println("File does not exist");
            throw new FileNotFoundException();
        }

        StringBuilder output = new StringBuilder();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String s = input.nextLine();

                if (s.contains("{")) {
                    s = " {" + "\r\n";
                } else {
                    s = "\r\n" + s;
                }

                output.append(s);
            }
        }

        try (PrintWriter fileOutput = new PrintWriter("C:\\dev\\study\\study_code\\src\\textbook\\JavaSourceCode.txt")) {
            fileOutput.println(output);
        }
    }

    //12.13
    private static void countCharsWordsLines() throws FileNotFoundException {
        File file = new File("C:\\dev\\study\\study_code\\src\\textbook\\Note.txt");

        if (!file.exists()) {
            System.out.println("File does not exist");
            throw new FileNotFoundException();
        }

        int chars = 0;
        int words = 0;
        int lines = 0;

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String s = input.nextLine();

                lines++;

                for (char c : s.toCharArray()) {
                    if (c == ' ') {
                        words++;
                    } else {
                        chars++;
                    }
                }
                words++;
            }
        }

        System.out.println("File JavaSourceCode.txt has");
        System.out.println(chars + " characters");
        System.out.println(words + " words");
        System.out.println(lines + " lines");
    }

    //12.14
    private static void processScores() throws FileNotFoundException {
        File file = new File("C:\\dev\\study\\study_code\\src\\textbook\\Scores.txt");

        if (!file.exists()) {
            System.out.println("File does not exist");
            throw new FileNotFoundException();
        }

        Scanner input = new Scanner(file);
        int totalScore = 0;
        int numberOfScores = 0;
        int averageScore = 0;

        while (input.hasNext()) {
            String s = input.nextLine();

            try {
                numberOfScores++;

                int score = Integer.parseInt(s);
                totalScore += score;
            } catch (NumberFormatException e) {
                System.out.println("Argument is not of type number: " + e.getMessage());
            }
        }

        averageScore = totalScore / numberOfScores;

        System.out.println("Average score: " + averageScore);
        System.out.println("Total score: " + totalScore);
    }

    //12.15
    private static void writeReadData() throws FileNotFoundException {
        File file = new File("C:\\dev\\study\\study_code\\src\\textbook\\Exercise12_15.txt");

        try (PrintWriter fileOutput = new PrintWriter(file.getAbsolutePath());) {
            for (int i = 0; i < 100; i++) {
                int random = (int) (Math.random() * 100 + 1);
                fileOutput.print(random + " ");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

    //12.16
    private static void replaceText() throws FileNotFoundException {
        File file = new File("C:\\dev\\study\\study_code\\src\\textbook\\Note.txt");
        if (!file.exists()) {
            System.out.println("File does not exist");
            throw new FileNotFoundException();
        }
        Scanner input = new Scanner(file);

        Scanner command = new Scanner(System.in);
        System.out.println("Enter the word you want found");
        String found = command.nextLine();

        System.out.println("Enter the word you want to replace it with");
        String replace = command.nextLine();

        StringBuilder sb = new StringBuilder();

        while (input.hasNext()) {
            String s1 = input.nextLine();
            String s2 = s1.replaceAll(found, replace);
            sb.append(s2).append("\r\n");
        }

        try (PrintWriter output = new PrintWriter(file.getAbsolutePath());) {
            output.print(sb);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //12.17
    private static void hangman() throws FileNotFoundException {
        File hangmanFile = new File("C:\\dev\\study\\study_code\\src\\textbook\\Note.txt");

        if (!hangmanFile.exists()) {
            System.out.println("File does not exist");
            throw new FileNotFoundException();
        }

        ArrayList<String> hangmanWords = new ArrayList<>();

        Scanner wordInput = new Scanner(hangmanFile);
        while (wordInput.hasNext()) {
            hangmanWords.add(wordInput.next());
        }

        playHangman(hangmanWords);
    }

    private static void playHangman(ArrayList<String> words) {
        Scanner input = new Scanner(System.in);

        int index = (int) (Math.random() * words.size());

        String word = words.get(index);
        char[] wordCharArray = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
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
            for (int i = 0; i < word.length(); i++) {
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

            if (!isStar) {
                isWholeWordFound = true;
            }
        }

        System.out.println("The word is " + word + ". You missed " + numberOfGuess + (numberOfGuess > 1 ? " times" : " time"));

        System.out.println("Do you want to guess another word? Enter y or no: ");

        String want = input.nextLine();

        if (want.equals("y")) {
            playHangman(words);
        } else {
            input.close();
        }
    }

    //12.19
    private static void countWords() {
        try {
            URL url = new URL("https://liveexample.pearsoncmg.com/data/Lincoln.txt");
            Scanner input = new Scanner(url.openStream());

            int wordCount = 0;

            while (input.hasNext()) {
                String line = input.nextLine();

                for (Character c : line.toCharArray()) {
                    if (c == ' ') {
                        wordCount++;
                    }
                }
                wordCount++;
            }

            System.out.println("The file has " + wordCount + " words.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 12.21

    //12.23
    private static void processScoresInTextFile() {
        try {
            URL url = new URL("https://liveexample.pearsoncmg.com/data/Scores.txt");
            Scanner input = new Scanner(url.openStream());

            int count = 0;

            while (input.hasNext()) {
                int score = input.nextInt();
                count += score;
            }

            System.out.println("The final score is " + count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //12.24
    private static void largeDataSet() throws FileNotFoundException {
        File file = new File("C:\\dev\\study\\study_code\\src\\textbook\\exercise_files\\Salary.txt");

        List<String> rankList = List.of("assistant", "associate", "full");

        try (PrintWriter fileOutput = new PrintWriter(file.getAbsolutePath());) {
            StringBuilder builder = new StringBuilder();

            for (int i = 1; i <= 1000; i++) {
                int random = (int) (Math.random() * rankList.size());
                String rank = rankList.get(random);
                int salary = getSalary(rank);

                builder.append("FirstName").append(i).append(" ").append("LastName").append(i).append(" ").append(rank).append(" ").append(salary).append("\n");
            }

            fileOutput.write(builder.toString());
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

    private static int getSalary(String rank) {
        return switch (rank) {
            case "assistant" -> (int) (Math.random() * (80000 - 50000 + 1)) + 50000;
            case "associate" -> (int) (Math.random() * (60000 - 110000 + 1)) + 60000;
            case "full" -> (int) (Math.random() * (75000 - 130000 + 1)) + 75000;
            default -> (int) (Math.random() * (80000 - 50000 + 1)) + 50000;
        };
    }

    //12.25
    private static void processLargeDataset() {
        try {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Salary.txt");
            Scanner input = new Scanner(url.openStream());

            BigDecimal assistant = BigDecimal.ZERO;
            BigDecimal associate = BigDecimal.ZERO;
            BigDecimal full = BigDecimal.ZERO;
            BigDecimal faculty = BigDecimal.ZERO;

            BigDecimal totalSalaryAssistant = BigDecimal.ZERO;
            BigDecimal totalSalaryAssociate = BigDecimal.ZERO;
            BigDecimal totalSalaryFull = BigDecimal.ZERO;
            BigDecimal totalFaculty = BigDecimal.ZERO;

            while (input.hasNext()) {
                String line = input.nextLine();

                String[] words = line.split(" ");
                String rank = words[2];
                BigDecimal salary;
                try {
                    salary = new BigDecimal(words[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Salary is not a valid number");
                    continue;
                }

                switch (rank) {
                    case "assistant": {
                        totalSalaryAssistant = totalSalaryAssistant.add(salary);
                        assistant = assistant.add(BigDecimal.ONE);
                        break;
                    }
                    case "associate": {
                        totalSalaryAssociate = totalSalaryAssociate.add(salary);
                        associate = associate.add(BigDecimal.ONE);
                        ;
                        break;
                    }
                    case "full": {
                        totalSalaryFull = totalSalaryFull.add(salary);
                        full = full.add(BigDecimal.ONE);
                        break;
                    }
                }

                totalFaculty = totalFaculty.add(salary);
                faculty = faculty.add(BigDecimal.ONE);
            }

            System.out.println("Total assistant professor salary is " + totalSalaryAssistant + ", with the average salary being " + (totalSalaryAssistant.divide(assistant, 2, RoundingMode.HALF_UP)));
            System.out.println("Total associate professor salary is " + totalSalaryAssociate + ", with the average salary being " + (totalSalaryAssociate.divide(associate, 2, RoundingMode.HALF_UP)));
            System.out.println("Total full professor salary is " + totalSalaryFull + ", with the average salary being " + (totalSalaryFull.divide(full, 2, RoundingMode.HALF_UP)));
            System.out.println("Total faculty salary is " + totalFaculty + ", with the average salary being " + (totalFaculty.divide(faculty, 2, RoundingMode.HALF_UP)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //12.26
    private static void createDirectory() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a directory name");
        String name = input.nextLine();

        String pathName = "C:\\dev\\study\\study_code\\src\\textbook\\exercise_files\\" + name;

        File f = new File(pathName);
        boolean created = f.mkdirs();

        if (created) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Directory already exists");
        }
    }

    private static void createFiles() throws FileNotFoundException {
        String parentDirectory = "C:\\dev\\study\\study_code\\src\\textbook\\exercise_files\\Exercise12_26_27";

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                String fileName = "Exercise" + i + "_" + j;

                File f = new File(parentDirectory, fileName);

                try (PrintWriter fileOutput = new PrintWriter(f.getAbsolutePath());) {
                    fileOutput.println(fileName);
                }
            }
        }
    }

    //exercise 12.27
    private static void replaceWords() throws FileNotFoundException {
        File folder = new File("C:\\dev\\study\\study_code\\src\\textbook\\exercise_files\\Exercise12_26_27");

        if (!folder.exists()) {
            throw new FileNotFoundException();
        }

        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null || listOfFiles.length == 0) {
            throw new FileNotFoundException();
        }

        Arrays.stream(listOfFiles).forEach(file -> {
            String returnString = "";

            try (Scanner input = new Scanner(file);) {
                String line;

                try {
                    line = input.nextLine();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }

                String[] split = line.split("_");

                String exerciseWord = split[0];
                String exerciseNumString = exerciseWord.replace("Exercise", "");

                returnString += "Exercise" + getExerciseNum(exerciseNumString) + "_" + getExerciseNum(split[1]);
            } catch (Exception e) {
                System.out.println("File not found " + file);
            }

            try (PrintWriter fileOutput = new PrintWriter(file.getAbsolutePath());) {
                fileOutput.println(returnString);
            } catch (Exception e) {
                System.out.println("File not found " + file);
            }
        });
    }

    //12.28 + //12.29
    private static void renameFileName() throws FileNotFoundException, NumberFormatException {
        File folder = new File("C:\\dev\\study\\study_code\\src\\textbook\\exercise_files\\Exercise12_26_27");

        if (!folder.exists()) {
            throw new FileNotFoundException();
        }

        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null || listOfFiles.length == 0) {
            throw new FileNotFoundException();
        }

        Arrays.stream(listOfFiles).forEach(file -> {
            String fileName = file.getName();

            String returnString = "";

            String[] split = fileName.split("_");

            String exerciseWord = split[0];
            String exerciseNumString = exerciseWord.replace("Exercise", "");

            returnString += folder.getAbsolutePath() + "\\" + "Exercise" + getExerciseNum(exerciseNumString) + "_" + getExerciseNum(split[1]);

            File newFileName = new File(returnString);

            boolean created = file.renameTo(newFileName);

            if (created) {
                System.out.println("File " + fileName + " renamed to " + returnString);
            }
        });
    }

    private static String getExerciseNum(String exerciseNumString) {
        try {
            int num = Integer.parseInt(exerciseNumString);

            if (num < 10) {
                return "0" + num;
            } else {
                return exerciseNumString;
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    //12.30
    private static void occurrencesOfEachLetter() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a filename: ");
        String name = input.nextLine();

        String directory = "C:\\dev\\study\\study_code\\src\\textbook\\exercise_files\\";

        File f = new File(directory + name);

        if (!f.exists()) {
            throw new FileNotFoundException();
        }

        int[] vals = new int[26];

        try (Scanner fileScanner = new Scanner(f)) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();

                for (char character : line.toCharArray()) {
                    if (!Character.isAlphabetic(character)) {
                        continue;
                    }

                    char upper = Character.toUpperCase(character);
                    int value = upper - 'A';

                    vals[value]++;
                }
            }
        }

        for (int i = 0; i < vals.length; i++) {
            System.out.println("Number of " + ((char) (i + 'A')) + "s: " + vals[i]);
        }
    }

    //12.31
    private static void babyName() throws IOException {
        String baseUrl = "http://liveexample.pearsoncmg.com/data/babynamesranking";
        String txt = ".txt";

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the year: ");
        String year = input.nextLine();

        System.out.println("Enter the gender (as letter): ");
        String gender = input.nextLine();

        int column = Objects.equals(gender, "M") ? 1 : 2;

        System.out.println("Enter the name: ");
        String name = input.nextLine();

        URL url = new URL(baseUrl + year + txt);

        try (Scanner urlScanner = new Scanner(url.openStream())) {
            while (urlScanner.hasNext()) {
                String line = urlScanner.nextLine();

                if (line.contains(name)) {
                    String[] string = line.split(" ");

                    if (string[column].contains(name)) {
                        System.out.println(name + " is ranked #" + string[0] + " in year " + year);
                        break;
                    }
                }
            }

            System.out.println("The name " + name + " is not ranked in year " + year);
        }

    }

    //12.32
    private static void rankingSummary() throws IOException {
        System.out.println("Year    Rank 1    Rank 2    Rank 3    Rank 4    Rank 5    Rank 1    Rank 2    Rank 3    Rank 4    Rank 5");
        String baseUrl = "http://liveexample.pearsoncmg.com/data/babynamesranking";
        String txt = ".txt";

        for (int i = 10; i >= 1; i--) {
            String year;

            if (i < 10) {
                year = "200" + i;
            } else {
                year = "20" + i;
            }

            URL url = new URL(baseUrl + year + txt);

            try (Scanner urlScanner = new Scanner(url.openStream())) {
                List<String> girls = new ArrayList<>();
                List<String> boys = new ArrayList<>();

                for (int j = 0; j <= 4; j++) {
                    String line = urlScanner.nextLine();

                    String[] names = line.split("\t");

                    girls.add(names[3]);
                    boys.add(names[1]);
                }

                urlScanner.close();

                System.out.print(year + "    ");
                for (String name : girls) {
                    System.out.print(name + "    ");
                }

                for (String name : boys) {
                    System.out.print(name + "    ");
                }
                System.out.println();
            }
        }
    }

    //12.33
    private static void webCrawler() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();

        System.out.print("Enter search term: ");
        String term = input.nextLine();
        crawler(url, term); // Traverse the Web from the a starting url
    }

    public static void crawler(String startingURL, String searchTerm) {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();

        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);
            listOfTraversedURLs.add(urlString);
            System.out.println("Crawl " + urlString);

            for (String s : getSubURLs(urlString, searchTerm)) {
                if (!listOfTraversedURLs.contains(s) &&
                        !listOfPendingURLs.contains(s))
                    listOfPendingURLs.add(s);
            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString, String searchTerm) {
        ArrayList<String> list = new ArrayList<>();

        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();

                if (line.contains(searchTerm)) {
                    System.out.println("Url " + urlString + "contains the search term " + searchTerm);
                    break;
                }

                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { // Ensure that a correct URL is found
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    } else
                        current = -1;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return list;
    }

// go back and do 12.18 and 12.20 and 12.22

}

class IllegalTriangleException extends Exception {
    private final double side1;
    private final double side2;
    private final double side3;

    public IllegalTriangleException(double side1, double side2, double side3) {
        super("The sum of two sides must be greater than the third side");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
}

class HexFormatException extends Exception {
    char invalidHex;

    public HexFormatException(char invalidHex) {
        super("Hex character " + invalidHex + " is invalid");
        this.invalidHex = invalidHex;
    }

    public char getInvalidHex() {
        return invalidHex;
    }
}

class BinaryFormatException extends Exception {
    String invalidBinary;

    public BinaryFormatException(String invalidBinary) {
        super("String " + invalidBinary + " is not a valid binary number");
        this.invalidBinary = invalidBinary;
    }

    public String getInvalidBinary() {
        return invalidBinary;
    }

}

