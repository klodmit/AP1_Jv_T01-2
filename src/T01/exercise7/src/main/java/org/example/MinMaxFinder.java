package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MinMaxFinder {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        List<Double> numbers = readNumbersFromFile(filePath);

        if (numbers != null && !numbers.isEmpty()) {
            double min = numbers.stream().min(Double::compare).orElseThrow();
            double max = numbers.stream().max(Double::compare).orElseThrow();
            saveResultToFile(min, max);
            System.out.println("Saving min and max values in file");
        }
    }

    private static List<Double> readNumbersFromFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Input error. File isn't exist");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int size = Integer.parseInt(reader.readLine().trim());

            if (size <= 0) {
                System.out.println("Input error. Size <= 0");
                return null;
            }

            List<Double> numbers = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null && numbers.size() < size) {
                for (String str : line.split(" ")) {
                    try {
                        numbers.add(Double.parseDouble(str));
                    } catch (NumberFormatException e) {
                        // Пропуск ошибочного ввода
                    }
                }
            }

            if (numbers.size() < size) {
                System.out.println("Input error. Insufficient number of elements");
                return null;
            }

            System.out.println(size);
            numbers.forEach(System.out::println);
            return numbers;

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void saveResultToFile(double min, double max) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("result.txt"))) {
            writer.printf("%.1f %.1f%n", min, max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
