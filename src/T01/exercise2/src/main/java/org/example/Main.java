package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static int input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    static void output(int flag) {
        output(flag, "");
    }

    static void output(int flag, String message) {
        if (flag == -1) {
            System.out.println("Couldn't parse a number. Please, try again.");
        } else if (flag == 1) {
            System.out.println("Incorrect time");
        } else {
            System.out.println(message);
        }
    }

    static void countHMS(int time) {
        if (time < 0) {
            output(1);
        } else {
            int hours = time / 3600;
            int minutes = (time % 3600) / 60;
            int seconds = time % 60;
            String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            output(0, formattedTime);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        while (true) {
            try {
                int time = input();
                countHMS(time);
                break;
            } catch (InputMismatchException e) {
                output(-1);
            }
        }
    }
}
