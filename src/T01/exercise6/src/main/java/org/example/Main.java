package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner scanner = new Scanner(System.in);

        int size;
        while (true) {
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size > 0) break;
                else System.out.println("Input error. Size <= 0");
            } else {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.next();
            }
        }

        double[] numbers = new double[size];
        for (int i = 0; i < size; i++) {
            while (true) {
                if (scanner.hasNextDouble()) {
                    numbers[i] = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Couldn't parse a number. Please, try again");
                    scanner.next();
                }
            }
        }

        selectionSort(numbers);

        for (double num : numbers) {
            System.out.println(num + " ");
        }
    }

    public static void selectionSort(double[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}