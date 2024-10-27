package org.example;

import java.util.Scanner;

public class SequenceChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int prevNumber = Integer.MIN_VALUE;
        int position = 0;
        boolean isOrdered = true;
        boolean hasInput = false;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int currentNumber = scanner.nextInt();
                hasInput = true;

                if (currentNumber < prevNumber) {
                    System.out.println("The sequence is not ordered from the ordinal number of the number " + position);
                    isOrdered = false;
                    break;
                }

                prevNumber = currentNumber;
                position++;
            } else {
                scanner.next();
                if (hasInput) {
                    break;
                } else {
                    System.out.println("Input error");
                    return;
                }
            }
        }

        if (isOrdered && hasInput) {
            System.out.println("The sequence is ordered in ascending order");
        }
    }
}
