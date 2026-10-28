package lab04;

import java.util.Arrays;

/**
 * Лабораторна робота №4
 * Тема: Масиви
 * Виконав: студент групи ЦК-41 Курбатов Володимир
 * Варіант: 8
 *
 * У цьому класі зібрані всі завдання (1, 2, 3) для лабораторної роботи №4
 * в одному файлі з перевірками та тестами.
 *
 * @author Kurbatov
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("Лабораторна робота №4 (Варіант 8): Масиви");
        System.out.println("Виконав: студент групи ЦК-41 Курбатов Володимир");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // ЗАВДАННЯ 1 (пункт 8 з таблиці 2)
        // Тема: Знайти суму елементів, що кратні 3 (використано for-each)
        // -----------------------------------------------------------------
        System.out.println("=== Завдання 1: Сума елементів, кратних 3 (цикл for-each) ===");
        System.out.println("--- Дозволені значення ---");
        testTask1(new int[]{3, 4, 6, 7, 9, 10}); // кратні 3: 3, 6, 9 -> 18
        testTask1(new int[]{-9, -3, 2, 5, 12});  // кратні 3: -9, -3, 12 -> 0
        testTask1(new int[]{1, 2, 4, 5});        // немає кратних 3 -> 0
        testTask1(new int[]{0, 3, -6});          // 0, 3, -6 -> -3

        System.out.println("\n--- Помилкові значення (перевірка викидання виключень) ---");
        testTask1(new int[]{}); // помилка: порожній масив
        testTask1(null);        // помилка: null посилання

        // -----------------------------------------------------------------
        // ЗАВДАННЯ 2 (пункт 38 з таблиці 2)
        // Тема: Сума третього та найбільшого додатного елементів (цикл for)
        // -----------------------------------------------------------------
        System.out.println("\n==================================================");
        System.out.println("=== Завдання 2: Сума 3-го та макс. додатного елементів (цикл for) ===");
        System.out.println("--- Дозволені значення ---");
        testTask2(new int[]{10, -5, 4, 8, 2});      // 3-й = 4, max = 10 -> 14
        testTask2(new int[]{-10, -20, -5, 1, 15});  // 3-й = -5, max = 15 -> 10
        testTask2(new int[]{1, 2, 3});              // 3-й = 3, max = 3 -> 6
        testTask2(new int[]{5, 10, -2, 0, 7});      // 3-й = -2, max = 10 -> 8

        System.out.println("\n--- Помилкові значення (перевірка викидання виключень) ---");
        testTask2(new int[]{1, 2});           // помилка: менше 3 елементів
        testTask2(new int[]{-5, -1, -3, -8}); // помилка: немає додатних елементів
        testTask2(new int[]{0, 0, 0});        // помилка: лише нулі
        testTask2(null);                      // помилка: null посилання

        // -----------------------------------------------------------------
        // ЗАВДАННЯ 3 (пункт 61 з таблиці 2)
        // Тема: Формування масиву C з масивів A і B (сума/добуток/нуль)
        // -----------------------------------------------------------------
        System.out.println("\n==================================================");
        System.out.println("=== Завдання 3: Побудова масиву C на основі масивів A і B ===");
        System.out.println("--- Дозволені значення ---");
        int[] a1 = { 2, -3,  5, -4, 0};
        int[] b1 = { 3, -2, -1,  6, 5};
        testTask3(a1, b1);

        int[] a2 = { 10, -5,  0};
        int[] b2 = {  4, -8,  0};
        testTask3(a2, b2);

        System.out.println("\n--- Помилкові значення (перевірка викидання виключень) ---");
        testTask3(new int[]{1, 2, 3}, new int[]{1, 2}); // помилка: різна довжина
        testTask3(new int[]{}, new int[]{});             // помилка: порожні масиви
        testTask3(null, new int[]{1, 2});                // помилка: перший масив null
        testTask3(new int[]{1, 2}, null);                // помилка: другий масив null
    }


    // =====================================================================
    // МЕТОДИ ЛОГІКИ ЗАВДАНЬ (без System.out всередині, з валідацією аргументів)
    // =====================================================================

    /**
     * Завдання 1 (пункт 8): Знайти суму елементів масиву, що кратні 3.
     * За вимогою обов'язково використано цикл for-each.
     *
     * @param array вхідний масив цілих чисел
     * @return сума елементів, що діляться на 3
     * @throws NullPointerException якщо масив null
     * @throws IllegalArgumentException якщо масив порожній
     */
    public static int task1(int[] array) {
        // Перевіряємо, щоб нам не передали null
        if (array == null) {
            throw new NullPointerException("Масив не може бути null!");
        }
        // Перевіряємо, щоб масив містив хоча б один елемент
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім!");
        }

        int sum = 0;
        // Обов'язковий цикл for-each: просто біжимо по значеннях без лічильника
        for (int element : array) {
            // Перевіряємо кратність трьом (залишок від ділення на 3 дорівнює 0)
            if (element % 3 == 0) {
                sum += element;
            }
        }

        return sum;
    }

    /**
     * Завдання 2 (пункт 38): Знайти суму 3-го та найбільшого додатного елементів масиву.
     * За вимогою використано класичний цикл for.
     *
     * @param array вхідний масив цілих чисел
     * @return сума 3-го елемента (індекс 2) та максимального додатного
     * @throws NullPointerException якщо масив null
     * @throws IllegalArgumentException якщо довжина < 3 або немає жодного числа > 0
     */
    public static int task2(int[] array) {
        // Перевірка на null
        if (array == null) {
            throw new NullPointerException("Масив не може бути null!");
        }
        // Оскільки треба 3-й елемент, довжина масиву має бути щонайменше 3
        if (array.length < 3) {
            throw new IllegalArgumentException("Масив повинен містити щонайменше 3 елементи!");
        }

        // 3-й елемент у програмуванні має індекс 2 (0 - перший, 1 - другий, 2 - третій)
        int thirdElement = array[2];

        int maxPositive = 0;
        boolean foundPositive = false;

        // Використовуємо класичний цикл for з лічильником
        for (int i = 0; i < array.length; i++) {
            // Шукаємо лише додатні числа (> 0)
            if (array[i] > 0) {
                if (!foundPositive || array[i] > maxPositive) {
                    maxPositive = array[i];
                    foundPositive = true;
                }
            }
        }

        // Якщо додатних чисел у масиві взагалі не було
        if (!foundPositive) {
            throw new IllegalArgumentException("У масиві відсутні додатні елементи!");
        }

        return thirdElement + maxPositive;
    }

    /**
     * Завдання 3 (пункт 61): Сформувати масив C(n) за правилом:
     * C[i] = A[i] + B[i], якщо обидва додатні;
     * C[i] = A[i] * B[i], якщо обидва від'ємні;
     * C[i] = 0 в усіх інших випадках.
     *
     * @param a перший масив
     * @param b другий масив
     * @return сформований результуючий масив C
     * @throws NullPointerException якщо один із масивів null
     * @throws IllegalArgumentException якщо довжини масивів не однакові або вони порожні
     */
    public static int[] task3(int[] a, int[] b) {
        // Перевірка на null
        if (a == null || b == null) {
            throw new NullPointerException("Масиви не можуть мати значення null!");
        }
        // Перевіряємо, чи однакова довжина у обох масивів
        if (a.length != b.length) {
            throw new IllegalArgumentException("Масиви A та B повинні бути однакової довжини!");
        }
        // Перевірка на порожність
        if (a.length == 0) {
            throw new IllegalArgumentException("Масиви не можуть бути порожніми!");
        }

        // Створюємо новий результуючий масив C того ж розміру
        int[] c = new int[a.length];

        // Проходимо по всіх індексах
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && b[i] > 0) {
                // Обидва додатні -> беремо суму
                c[i] = a[i] + b[i];
            } else if (a[i] < 0 && b[i] < 0) {
                // Обидва від'ємні -> беремо добуток
                c[i] = a[i] * b[i];
            } else {
                // Всі інші варіанти (нулі або різні знаки) -> ставимо 0
                c[i] = 0;
            }
        }

        return c;
    }


    // =====================================================================
    // ДОПОМІЖНІ МЕТОДИ ДЛЯ ТЕСТУВАННЯ ТА ВИВЕДЕННЯ РЕЗУЛЬТАТІВ
    // =====================================================================

    private static void testTask1(int[] array) {
        try {
            int result = task1(array);
            System.out.println("Масив: " + Arrays.toString(array) + " -> Сума кратних 3: " + result);
        } catch (Exception e) {
            System.out.println("Масив: " + (array == null ? "null" : Arrays.toString(array))
                    + " -> Помилка: " + e.getClass().getSimpleName() + " (" + e.getMessage() + ")");
        }
    }

    private static void testTask2(int[] array) {
        try {
            int result = task2(array);
            System.out.println("Масив: " + Arrays.toString(array) + " -> Результат: " + result);
        } catch (Exception e) {
            System.out.println("Масив: " + (array == null ? "null" : Arrays.toString(array))
                    + " -> Помилка: " + e.getClass().getSimpleName() + " (" + e.getMessage() + ")");
        }
    }

    private static void testTask3(int[] a, int[] b) {
        try {
            int[] c = task3(a, b);
            System.out.println("A: " + Arrays.toString(a));
            System.out.println("B: " + Arrays.toString(b));
            System.out.println("C: " + Arrays.toString(c));
            System.out.println();
        } catch (Exception e) {
            System.out.println("A: " + (a == null ? "null" : Arrays.toString(a))
                    + ", B: " + (b == null ? "null" : Arrays.toString(b))
                    + " -> Помилка: " + e.getClass().getSimpleName() + " (" + e.getMessage() + ")\n");
        }
    }
}
