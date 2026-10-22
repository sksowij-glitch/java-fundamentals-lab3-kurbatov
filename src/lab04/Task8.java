package lab04;

import java.util.Arrays;

/**
 * Лабораторна робота №4
 * Варіант 8 -> Завдання №1 (пункт 8 з таблиці 2)
 * Тема: Знайти суму елементів, що кратні 3.
 *
 * Використано цикл for-each.
 *
 * @author Kurbatov
 */
public class Task8 {

    /**
     * Точка входу. Тестує метод findSumMultiplesOfThree з різними масивами.
     */
    public static void main(String[] args) {
        System.out.println("=== Завдання 1 (пункт 8): Сума елементів, кратних 3 ===");
        System.out.println("--- Дозволені значення ---");
        printResult(new int[]{3, 4, 6, 7, 9, 10});
        printResult(new int[]{-9, -3, 2, 5, 12});
        printResult(new int[]{1, 2, 4, 5});
        printResult(new int[]{0, 3, -6});

        System.out.println("\n--- Заборонені (помилкові) значення ---");
        printResult(new int[]{}); // порожній масив
        printResult(null);        // null посилання
    }

    /**
     * Знаходить суму елементів масиву, що кратні 3.
     * За правилами чистоти коду метод не містить виведення в консоль.
     *
     * @param array масив цілих чисел
     * @return сума елементів, кратних 3
     * @throws NullPointerException якщо передано null
     * @throws IllegalArgumentException якщо масив порожній
     */
    public static int findSumMultiplesOfThree(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може мати значення null!");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім!");
        }

        int sum = 0;
        // Обов'язкове використання циклу for-each
        for (int value : array) {
            if (value % 3 == 0) {
                sum += value;
            }
        }
        return sum;
    }

    /**
     * Допоміжний метод для тестування та виведення результатів.
     */
    public static void printResult(int[] array) {
        try {
            int result = findSumMultiplesOfThree(array);
            System.out.println("Масив: " + Arrays.toString(array) + " -> Сума кратних 3: " + result);
        } catch (Exception e) {
            System.out.println("Масив: " + (array == null ? "null" : Arrays.toString(array))
                    + " -> Помилка: " + e.getClass().getSimpleName() + " (" + e.getMessage() + ")");
        }
    }
}
