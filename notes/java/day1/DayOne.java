package day1;

import java.lang.reflect.Array;

public class DayOne {
    public static void main(String[] args) {
        System.out.println("Whats Up class");
        System.out.println("Hanging out with the class");

        // Data Types
        int age = 44;
        double altAge = 44.5;
        System.out.println(age);
        System.out.println(altAge);
        // System.out.println(age, altAge);
        // System.out.println(age + altAge);
        // System.out.printf("%s and %s", age,altAge);
        // System.out.print(age + "\n" + altAge);
        char test = 'a';
        String myString = "This is a string";
        // hi();
        // FizzBuzz();
        int[] myArray;
        myArray = new int[5];    // Initialization
        myArray[0] = 4;
        myArray[1] = 8;
        myArray[2] = 8;
        myArray[3] = 5;
        myArray[4] = 9;
        String[] fruits = {"banana", "pear", "papaya", "kiwi"};
        // for (int i = 0; i < fruits.length; i++) {
        //     System.out.println(fruits[i]);
        // }
        for (String item : fruits) {
            System.out.print(item + " ");
        }
        for (int item : myArray) {
            System.out.print(item + " ");
        }
    }
    public static void hi() {
        System.out.println("\nHello my old friends.");
    }
    public static String favNum(String name, int num) {
        return String.format("Hey everyone guess what? " + name + " has a favorite number of " + num);
    }
    public static void FizzBuzz() {
        int i = 1;
        while (i <= 100) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
            i++;
        }
    }
}