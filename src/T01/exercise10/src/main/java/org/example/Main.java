package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        int numberOfUsers;
        try {
            numberOfUsers = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Couldn't parse a number. Please, try again");
            return;
        }

        int successfulInputs = 0;
        while (successfulInputs < numberOfUsers) {
            String name = scanner.nextLine();

            try {
                int age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    System.out.println("Incorrect input. Age <= 0");
                    continue;
                }
                users.add(new User(name, age));
                successfulInputs++;
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.nextLine();
            }
        }

        String adultNames = users.stream()
                .filter(user -> user.getAge() >= 18)
                .map(User::getName)
                .collect(Collectors.joining(", "));

        System.out.println(adultNames.isEmpty() ? "" : adultNames);
    }
}
