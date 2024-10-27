package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static boolean isLastAndFirstAreSame(int num) {
        int lastDigit = num % 10;

        while (num >= 10) {
            num /= 10;
        }

        int firstDigit = num;

        return firstDigit == lastDigit;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Input error. Size <= 0");
                    break;
                }

                int[] answer = new int[n];
                int count = 0;

                for (int i = 0; i < n; i++) {
                    int a = sc.nextInt();
                    if (isLastAndFirstAreSame(a)) {
                        answer[count++] = a;

                    }
                }
                if (count == 0) {
                    System.out.println("There are no such elements");
                } else {
                    for (int j = 0; j < count; j++) {
                        System.out.print(answer[j] + " ");
                    }
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                sc.nextLine();
            }
        }
    }
}
