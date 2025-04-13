import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExceptionSimulator {

    public static void main(String[] args) {
        simulateArithmeticException();
        simulateNullPointerException();
        simulateArrayIndexOutOfBoundsException();
        simulateStringIndexOutOfBoundsException();
        simulateNumberFormatException();
        simulateClassCastException();
        simulateIllegalArgumentException();
        simulateIllegalStateException();
        simulateNegativeArraySizeException();
        simulateInputMismatchException();
        simulateFileNotFoundException();
        simulateIOException();
        simulateInterruptedException();
        simulateUnsupportedOperationException();
        simulateStackOverflowError();
        simulateArrayStoreException();
    }

    public static void simulateArithmeticException() {
        try {
            int a = 10, b = 2;
            System.out.println("Division result: " + (a / b)); // Normal case
            b = 0;
            System.out.println("Division result: " + (a / b)); // Triggers exception
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public static void simulateNullPointerException() {
        try {
            String s = "Hello";
            System.out.println(s.length()); // Normal
            s = null;
            System.out.println(s.length()); // Triggers exception
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void simulateArrayIndexOutOfBoundsException() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[1]); // Normal
            System.out.println(arr[5]); // Triggers exception
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void simulateStringIndexOutOfBoundsException() {
        try {
            String s = "Java";
            System.out.println(s.charAt(2)); // Normal
            System.out.println(s.charAt(10)); // Triggers exception
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void simulateNumberFormatException() {
        try {
            String validNumber = "123";
            System.out.println(Integer.parseInt(validNumber)); // Normal
            String invalidNumber = "abc";
            System.out.println(Integer.parseInt(invalidNumber)); // Triggers exception
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void simulateClassCastException() {
        try {
            Object x = "Hello";
            String y = (String) x; // Normal
            System.out.println(y);
            Object z = new Object();
            String w = (String) z; // Triggers exception
            System.out.println(w);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public static void simulateIllegalArgumentException() {
        try {
            setAge(25); // Normal
            setAge(-5); // Triggers exception
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age can't be negative");
        System.out.println("Age set to: " + age);
    }

    public static void simulateIllegalStateException() {
        try {
            StringBuilder sb = new StringBuilder("Data");
            System.out.println(sb.toString()); // Normal
            sb = null;
            sb.append("test"); // Triggers exception
        } catch (IllegalStateException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void simulateNegativeArraySizeException() {
        try {
            int size = 5;
            int[] arr = new int[size]; // Normal
            size = -3;
            int[] badArr = new int[size]; // Triggers exception
        } catch (NegativeArraySizeException e) {
            e.printStackTrace();
        }
    }

    public static void simulateInputMismatchException() {
        try {
            Scanner scanner = new Scanner("123\nabc\n");
            int x = scanner.nextInt(); // Normal
            System.out.println("Read integer: " + x);
            int y = scanner.nextInt(); // Triggers exception
            System.out.println("Read another: " + y);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public static void simulateFileNotFoundException() {
        try {
            File file = new File("nonexistent.txt");
            Scanner scanner = new Scanner(file); // Triggers exception
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void simulateIOException() {
        try {
            File temp = File.createTempFile("test", ".txt");
            FileWriter writer = new FileWriter(temp);
            writer.write("Hello");
            writer.close();

            FileReader reader = new FileReader(temp);
            reader.close();
            int c = reader.read(); // Triggers IOException (reader is closed)
            System.out.println((char) c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void simulateInterruptedException() {
        try {
            System.out.println("Sleeping...");
            Thread.sleep(100); // Normal
            Thread.currentThread().interrupt(); // Simulate interrupt
            Thread.sleep(100); // Triggers exception
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void simulateUnsupportedOperationException() {
        try {
            List<String> list = Collections.unmodifiableList(Arrays.asList("A", "B"));
            System.out.println(list.get(0)); // Normal
            list.add("C"); // Triggers exception
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    public static void simulateStackOverflowError() {
        try {
            recursiveCall(); // Triggers error
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }
    }

    public static void recursiveCall() {
        recursiveCall();
    }

    public static void simulateArrayStoreException() {
        try {
            Object[] arr = new String[3];
            arr[0] = "Hello"; // Normal
            arr[1] = 100; // Triggers exception
        } catch (ArrayStoreException e) {
            e.printStackTrace();
        }
    }
}
