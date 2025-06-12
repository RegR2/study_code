package textbook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Chapter17Exercises {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        createTextFile();
//        createBinaryFile();
//        sumBinaryData();
//        convertTextToUtf();
//        storeObjectsAndArraysInFile();
//        storeLoanObjects();
//        updateCount();
        addressBook();
    }

    //17.1
    private static void createTextFile() throws FileNotFoundException {
        try (FileOutputStream fos = new FileOutputStream("src/textbook/exercise_files/Chapter17/Exercise17_01.txt")) {
            for (int i = 1; i <= 100; i++) {
                fos.write((i + " ").getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //17.2
    private static void createBinaryFile() throws FileNotFoundException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/textbook/exercise_files/Chapter17/Exercise17_02.dat", true))) {
            for (int i = 1; i <= 100; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    //17.3
    private static void sumBinaryData() throws FileNotFoundException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("src/textbook/exercise_files/Chapter17/Exercise17_02.dat"))) {
            int sum = 0;
            try {
                while (true) {
                    sum += dis.readInt();
                }
            } catch (EOFException ex) {
                System.out.println("Sum " + sum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //17.4
    private static void convertTextToUtf() throws FileNotFoundException {
        try (FileInputStream fis = new FileInputStream("src/textbook/exercise_files/Chapter17/Exercise17_01.txt");
             DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/textbook/exercise_files/Chapter17/Exercise17_04.dat"))) {

            int value;
            while ((value = fis.read()) != -1) {
                dos.writeUTF(String.valueOf(value));
            }

            try (
                    InputStream input1 = new FileInputStream("src/textbook/exercise_files/Chapter17/Exercise17_01.txt");
                    InputStream input2 = new FileInputStream("src/textbook/exercise_files/Chapter17/Exercise17_04.dat");
            ) {
                System.out.println("Text file size is " + input1.available() + " bytes");
                System.out.println("UTF file size is " + input2.available() + " bytes");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //17.5
    private static void storeObjectsAndArraysInFile() throws IOException, ClassNotFoundException {
        int[] array = new int[]{11, 12, 13, 14, 15};
        Date dateObject = new Date(System.currentTimeMillis());
        double num = 45.6;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/textbook/exercise_files/Chapter17/Exercise17_05.dat"))) {
            oos.writeObject(array);
            oos.writeObject(dateObject);
            oos.writeDouble(num);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/textbook/exercise_files/Chapter17/Exercise17_05.dat"))) {
            System.out.println(Arrays.toString((int[]) ois.readObject()));
            System.out.println(ois.readObject());
            System.out.println(ois.readDouble());
        }
    }

    //17.6 + 17/7
    private static void storeLoanObjects() throws FileNotFoundException {
        Loan loan1 = new Loan(0.05, 10, 10000);
        Loan loan2 = new Loan(0.06, 11, 10000);
        Loan loan3 = new Loan(0.07, 12, 10000);
        Loan loan4 = new Loan(0.08, 13, 10000);
        Loan loan5 = new Loan(0.09, 14, 10000);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/textbook/exercise_files/Chapter17/Exercise17_06.dat"))) {
            oos.writeObject(loan1);
            oos.writeObject(loan2);
            oos.writeObject(loan3);
            oos.writeObject(loan4);
            oos.writeObject(loan5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/textbook/exercise_files/Chapter17/Exercise17_06.dat"))) {
            double totalLoanAmount = 0;
            try {
                while (true) {
                    Loan loan = (Loan) ois.readObject();
                    totalLoanAmount += loan.getLoanAmount();
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Total loan amount from file = " + totalLoanAmount);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //17.8
    private static void updateCount() throws FileNotFoundException {
        try (FileInputStream fis = new FileInputStream("src/textbook/exercise_files/Chapter17/Exercise17_08.txt");
             FileInputStream fis2 = new FileInputStream("src/textbook/exercise_files/Chapter17/Exercise17_08.dat");
             FileOutputStream fos = new FileOutputStream("src/textbook/exercise_files/Chapter17/Exercise17_08.dat")) {
            for (int i = 0; i < 10; i++) {
                while (fis.available() > 0) {
                    fis.read();
                }

                if (i==0) {
                    fos.write(1);
                    continue;
                }

                int num = fis2.read();
                fos.write(num + 1);
            }

            System.out.println("Total times read = " + fis2.read());
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    //17.9
    private static void addressBook() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int function = 0;

        while (function != 4) {
            System.out.println("Select which functionality you would like to do: 1. Add address, 2. Get address, 3. Update address, 4. Exit system");
            function = input.nextInt();
            input.nextLine();

            try (RandomAccessFile raf = new RandomAccessFile("src/textbook/exercise_files/Chapter17/Exercise17_09.txt", "rw")) {
                switch (function) {
                    case 1: handleAddAddress(raf, input); break;
                    case 2: handleGetAddress(raf, input); break;
                    case 3: handleUpdateAddress(raf, input);
                    default: continue;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void handleAddAddress(RandomAccessFile raf, Scanner input) throws IOException {
        System.out.println("Enter address you wish to add - including full name of person, street, city, state and zipcode");
        String address = input.nextLine();

        raf.seek(raf.length());
        raf.writeBytes(address + "\n");
    }

    private static void handleGetAddress(RandomAccessFile raf, Scanner input) throws IOException {
        System.out.println("Enter the name of the person who's address you would like to get: ");
        String name = input.nextLine();

        raf.seek(0);
        String returnAddress = "";

        String line;
        while ((line = raf.readLine()) != null) {
            if (line.contains(name)) {
                returnAddress = line;
                break;
            }
        }

        System.out.println(!returnAddress.isEmpty() ? "Address is: " + returnAddress : "Address not found");
    }

    private static void handleUpdateAddress(RandomAccessFile raf, Scanner input) throws IOException {
        System.out.println("Enter the name of the person who's address you would like to update: ");
        String name = input.nextLine();

        raf.seek(0);
        String returnAddress = "";

        long filePointer = 0;
        String line;
        while ((line = raf.readLine()) != null) {
            if (line.contains(name)) {
                returnAddress = line;
                break;
            }

            filePointer = raf.getFilePointer();
        }


        if (returnAddress.isEmpty()) {
            System.out.println("Couldn't find address. Try adding it. ");
            return;
        }

        System.out.println("Current address is: " + returnAddress + ". Please enter the address you wish to update to - including full name of person, street, city, state and zipcode");
        String newAddress = input.nextLine();

        raf.seek(filePointer);
        raf.writeBytes(newAddress + "\n");
    }

    //17.70

}
