package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static int fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int num = sc.nextInt();
                if (num > 46) {
                    System.out.println("Too large n");
                } else {
                    System.out.println(fibonacci(num));
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                sc.nextLine();
            }
        }
    }
}