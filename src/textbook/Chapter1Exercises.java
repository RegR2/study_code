package textbook;

public class Chapter1Exercises {
    public static void main(String[] args) {
        //Display three messages) Write a program that displays Welcome to Java,
        //Welcome to Computer Science, and Programming is fun
            System.out.println("Welcome to Java");
            System.out.println("Welcome to Computer Science");
            System.out.println("Programming is fun");


        //(Display five messages) Write a program that displays Welcome to Java five
        //times.
        System.out.println("Welcome to Java");
        System.out.println("Welcome to Java");
        System.out.println("Welcome to Java");
        System.out.println("Welcome to Java");
        System.out.println("Welcome to Java");

        //(Display a pattern) Write a program that displays the following pattern:
        // J A V V A
        // J A A V V A A
        //J J AAAAA V V AAAAA
        // J J A A V A A

        System.out.println("      J     A   V     V     A");
        System.out.println("      J    A A   V   V     A A");
        System.out.println("  J   J   AAAAA   V V     AAAAA");
        System.out.println("   J J   A     A   V     A     A");


        System.out.println(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9);


        System.out.println(4 * ( 1.0 - 1.0/3.0 + 1.0/5.0 - 1.0/7.0 + 1.0/9.0 - 1.0/11.0));
        System.out.println(4 * ( 1.0 - 1.0/3.0 + 1.0/5.0 - 1.0/7.0 + 1.0/9.0 - 1.0/11.0 + 1.0/13.0));

        System.out.println("perimeter of circle = " + 2 * 5.5/ 3.14);
        System.out.println("area of circle = " + 5.5 * 5.5/ 3.14);
        System.out.println("area of rectangle = " + 4.5 * 7.9);

        projectPopulation();
    }

    public static void projectPopulation() {
        int currentPopulation = 312032486;
        int secondsInAYear = 365 * 24 * 60 * 60;

        double birthRate = secondsInAYear / 7.0;
        double deathRate = secondsInAYear / 13.0;
        double immigrationRate = secondsInAYear / 45.0;

        for (int i = 0; i <= 4; i++) {
            System.out.println("populate for year: " + i + " is " + (int) (currentPopulation + birthRate - deathRate + immigrationRate));
        }
    }
}
