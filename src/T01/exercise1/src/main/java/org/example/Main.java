package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    static double calcLengthSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                double dot1 = sc.nextDouble();
                double dot2 = sc.nextDouble();
                double dot3 = sc.nextDouble();
                double dot4 = sc.nextDouble();
                double dot5 = sc.nextDouble();
                double dot6 = sc.nextDouble();
                if (dot1 == dot3 && dot2 == dot4 || dot1 == dot5 && dot2 == dot6 || dot3 == dot5 && dot4 == dot6) {
                    System.out.println("It isn't triangle");
                } else {
                    double a = calcLengthSide(dot1, dot2, dot3, dot4);
                    double b = calcLengthSide(dot1, dot2, dot5, dot6);
                    double c = calcLengthSide(dot3, dot4, dot5, dot6);
                    System.out.printf("Perimeter: %.3f\n", perimeter(a, b, c));
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                sc.nextLine();
            }
        }
    }
}