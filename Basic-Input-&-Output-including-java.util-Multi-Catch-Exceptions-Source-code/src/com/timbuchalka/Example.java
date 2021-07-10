package com.timbuchalka;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by timbuchalka on 1/04/2016.
 */
public class Example {

    public static void main(String[] args) {

        // That's actually true in any language...finally will always execute
        // before a return statement, no matter where that return is in the method body.
        // If that wasn't the case, the finally block wouldn't have much meaning.
        // "Better with debug"
        finallyTest();


        try {
            int result = divide();
            System.out.println(result);
        } catch(ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }
    }

    private static int divide() {
        int x, y;
//        try {
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
//        } catch(NoSuchElementException e) {
//            throw new ArithmeticException("no suitable input");
//        } catch(ArithmeticException e) {
//            throw new ArithmeticException("attempt to divide by zero");
//        }
    }

    public static int finallyTest() {
        int x = 3;
        try {
            try {
                x++;
                if (true) throw new RuntimeException("Ahh!");
                return x; // skipped
            } finally {
                x--;
            }
        } catch (RuntimeException e) {
            return ++x;
        } finally {
            x--;
        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while(true) {
            try {
                return s.nextInt();
            } catch(InputMismatchException e) {
                // go round again.  Read past the end of line in the input first
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9 ");
            }
        }
    }
}
