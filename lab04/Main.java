package lab04;

import java.util.Arrays;

/**
 * Лабораторна робота №4
 * Тема: Масиви
 * Студент: Курбатов Володимир (група ЦК-41)
 * Варіант: 8
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота №4 (Варіант 8): Масиви ===");
        System.out.println("Виконав: студент групи ЦК-41 Курбатов Володимир\n");

        // -------------------------------------------------------------
        // ЗАВДАННЯ 1: Знайти суму елементів, що кратні 3 (цикл for-each)
        // -------------------------------------------------------------
        System.out.println("=== Завдання 1: Сума елементів, кратних 3 (for-each) ===");
        int[] array1 = { 3, 4, 6, 7, 9, 10 };
        System.out.println("Масив 1: " + Arrays.toString(array1));
        System.out.println("Сума кратних 3: " + task1(array1)); // 3 + 6 + 9 = 18

        int[] array1Alt = { -9, -3, 2, 5, 12 };
        System.out.println("Масив 2: " + Arrays.toString(array1Alt));
        System.out.println("Сума кратних 3: " + task1(array1Alt)); // -9 + (-3) + 12 = 0
        System.out.println();

        // -------------------------------------------------------------
        // ЗАВДАННЯ 2: Сума 3-го та найбільшого додатного (цикл for)
        // -------------------------------------------------------------
        System.out.println("=== Завдання 2: Сума 3-го та макс. додатного (for) ===");
        int[] array2 = { 10, -5, 4, 8, 2 };
        System.out.println("Масив 1: " + Arrays.toString(array2));
        System.out.println("Результат: " + task2(array2)); // 3-й = 4, макс додатний = 10 -> 14

        int[] array2Alt = { -10, -20, -5, 1, 15 };
        System.out.println("Масив 2: " + Arrays.toString(array2Alt));
        System.out.println("Результат: " + task2(array2Alt)); // 3-й = -5, макс додатний = 15 -> 10
        System.out.println();

        // -------------------------------------------------------------
        // ЗАВДАННЯ 3: Побудова масиву C на основі масивів A і B
        // -------------------------------------------------------------
        System.out.println("=== Завдання 3: Побудова масиву C на основі A і B ===");
        int[] a = { 2, -3, 5, -4, 0 };
        int[] b = { 3, -2, -1, 6, 5 };
        int[] c = task3(a, b);

        System.out.println("Масив A: " + Arrays.toString(a));
        System.out.println("Масив B: " + Arrays.toString(b));
        System.out.println("Масив C: " + Arrays.toString(c));
    }

    // =========================================================================
    // ЛОГІКА ЗАВДАНЬ
    // =========================================================================

    /**
     * Завдання 1 (пункт 8): Знайти суму елементів масиву, що кратні 3.
     * За вимогою використано цикл for-each.
     */
    public static int task1(int[] array) {
        int sum = 0;
        // Цикл for-each перебирає всі елементи без використання індексів
        for (int element : array) {
            if (element % 3 == 0) {
                sum += element;
            }
        }
        return sum;
    }

    /**
     * Завдання 2 (пункт 38): Знайти суму 3-го та найбільшого додатного елемента.
     * За вимогою використано класичний цикл for.
     */
    public static int task2(int[] array) {
        // 3-й елемент має індекс 2 (нумерація в Java починається з 0)
        int thirdElement = array[2];

        int maxPositive = 0;
        boolean foundPositive = false;

        // Звичайний цикл for з лічильником
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                // Якщо це перше знайдене додатне число або більше за поточний максимум
                if (!foundPositive || array[i] > maxPositive) {
                    maxPositive = array[i];
                    foundPositive = true;
                }
            }
        }

        return thirdElement + maxPositive;
    }

    /**
     * Завдання 3 (пункт 61): Сформувати масив C(n) за правилом:
     * C[i] = A[i] + B[i], якщо обидва додатні;
     * C[i] = A[i] * B[i], якщо обидва від'ємні;
     * C[i] = 0 в усіх інших випадках.
     */
    public static int[] task3(int[] a, int[] b) {
        int[] c = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && b[i] > 0) {
                // Обидва додатні -> сума
                c[i] = a[i] + b[i];
            } else if (a[i] < 0 && b[i] < 0) {
                // Обидва від'ємні -> добуток
                c[i] = a[i] * b[i];
            } else {
                // Всі інші варіанти (різні знаки або нулі) -> 0
                c[i] = 0;
            }
        }

        return c;
    }
}
