package lab04;

import java.util.Arrays;

/**
 * Лабораторна робота №4
 * Варіант 8 -> Завдання №2 (пункт 38 з таблиці 2)
 * Тема: Знайти суму третього та найбільшого додатного елементів масиву.
 *
 * Використано цикл for.
 *
 * @author Kurbatov
 */
public class Task38 {

    /**
     * Точка входу. Тестує метод sumThirdAndMaxPositive з різними масивами.
     */
    public static void main(String[] args) {
        System.out.println("=== Завдання 2 (пункт 38): Сума 3-го та макс. додатного елементів ===");
        System.out.println("--- Дозволені значення ---");
        printResult(new int[]{10, -5, 4, 8, 2});      // 3-й = 4, max = 10 -> 14
        printResult(new int[]{-10, -20, -5, 1, 15});  // 3-й = -5, max = 15 -> 10
        printResult(new int[]{1, 2, 3});              // 3-й = 3, max = 3 -> 6
        printResult(new int[]{5, 10, -2, 0, 7});      // 3-й = -2, max = 10 -> 8

        System.out.println("\n--- Заборонені (помилкові) значення ---");
        printResult(new int[]{1, 2});                 // менше 3 елементів
        printResult(new int[]{-5, -1, -3, -8});       // немає додатних елементів
        printResult(new int[]{0, 0, 0});              // нулі, немає додатних
        printResult(null);                            // null
    }

    /**
     * Знаходить суму третього елемента масиву (індекс 2) та найбільшого додатного елемента.
     * За правилами чистоти коду метод не взаємодіє з консоллю напряму.
     *
     * @param array масив цілих чисел
     * @return сума третього та найбільшого додатного елементів
     * @throws NullPointerException якщо масив null
     * @throws IllegalArgumentException якщо розмір масиву < 3 або у масиві немає додатних чисел
     */
    public static int sumThirdAndMaxPositive(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null!");
        }
        if (array.length < 3) {
            throw new IllegalArgumentException("Масив повинен містити щонайменше 3 елементи!");
        }

        int thirdElement = array[2];
        int maxPositive = 0;
        boolean foundPositive = false;

        // Обов'язкове використання циклу for
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (!foundPositive || array[i] > maxPositive) {
                    maxPositive = array[i];
                    foundPositive = true;
                }
            }
        }

        if (!foundPositive) {
            throw new IllegalArgumentException("У масиві відсутні додатні елементи!");
        }

        return thirdElement + maxPositive;
    }

    /**
     * Допоміжний метод для тестування та виведення результатів.
     */
    public static void printResult(int[] array) {
        try {
            int result = sumThirdAndMaxPositive(array);
            System.out.println("Масив: " + Arrays.toString(array) + " -> Результат: " + result);
        } catch (Exception e) {
            System.out.println("Масив: " + (array == null ? "null" : Arrays.toString(array))
                    + " -> Помилка: " + e.getClass().getSimpleName() + " (" + e.getMessage() + ")");
        }
    }
}
