package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> strings = new ArrayList<>();

        // Чтение строк и добавление их в список
        for (int i = 0; i < n; i++) {
            strings.add(scanner.nextLine());
        }

        String substring = scanner.nextLine();

        List<String> filteredStrings = filterStrings(strings, substring);

        if (filteredStrings.isEmpty()) {
            System.out.println();
        } else {
            for (int i = 0; i < filteredStrings.size(); i++) {
                System.out.print(filteredStrings.get(i));
                if (i < filteredStrings.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }

    /**
     * Метод для фильтрации списка строк по заданной подстроке.
     *
     * @param strings Список строк для фильтрации
     * @param substring Подстрока, по которой происходит фильтрация
     * @return Список строк, содержащих подстроку
     */
    public static List<String> filterStrings(List<String> strings, String substring) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str.contains(substring)) {
                result.add(str);
            }
        }
        return result;
    }
}
