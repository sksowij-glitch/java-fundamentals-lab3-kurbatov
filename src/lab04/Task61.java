package lab04;

import java.util.Arrays;

/**
 * Лабораторна робота №4
 * Варіант 8 -> Завдання №3 (пункт 61 з таблиці 2)
 * Тема: Формування масиву C(n) з масивів A(n) та B(n).
 *
 * @author Kurbatov
 */
public class Task61 {

    /**
     * Точка входу. Тестує формування масиву C з різними парами масивів A і B.
     */
    public static void main(String[] args) {
        System.out.println("=== Завдання 3 (пункт 61): Створення масиву C з масивів A і B ===");
        System.out.println("--- Дозволені значення ---");
        int[] a1 = { 2, -3,  5, -4, 0};
        int[] b1 = { 3, -2, -1,  6, 5};
        printResult(a1, b1);

        int[] a2 = { 10, -5,  0};
        int[] b2 = {  4, -8,  0};
        printResult(a2, b2);

        System.out.println("\n--- Заборонені (помилкові) значення ---");
        printResult(new int[]{1, 2, 3}, new int[]{1, 2}); // різна довжина
        printResult(new int[]{}, new int[]{});             // порожні масиви
        printResult(null, new int[]{1, 2});                // масив null
        printResult(new int[]{1, 2}, null);                // другий масив null
    }

    /**
     * Формує масив C за правилом:
     * C[i] = A[i] + B[i], якщо A[i] > 0 і B[i] > 0
     * C[i] = A[i] * B[i], якщо A[i] < 0 і B[i] < 0
     * C[i] = 0 в усіх інших випадках
     *
     * За правилами чистоти коду метод не взаємодіє з консоллю напряму.
     *
     * @param a перший масив
     * @param b другий масив
     * @return результуючий масив c
     * @throws NullPointerException якщо хоча б один масив null
     * @throws IllegalArgumentException якщо довжини масивів не співпадають або вони порожні
     */
    public static int[] buildArrayC(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new NullPointerException("Масиви не можуть бути null!");
        }
        if (a.length != b.length) {
            throw new IllegalArgumentException("Масиви A та B повинні бути однакової довжини!");
        }
        if (a.length == 0) {
            throw new IllegalArgumentException("Масиви не можуть бути порожніми!");
        }

        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && b[i] > 0) {
                c[i] = a[i] + b[i];
            } else if (a[i] < 0 && b[i] < 0) {
                c[i] = a[i] * b[i];
            } else {
                c[i] = 0;
            }
        }
        return c;
    }

    /**
     * Допоміжний метод для тестування та виведення результатів.
     */
    public static void printResult(int[] a, int[] b) {
        try {
            int[] c = buildArrayC(a, b);
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
