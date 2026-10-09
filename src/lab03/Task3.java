package lab03;

/**
 * Лабораторна робота №3
 * Варіант 8 -> Завдання №1 (пункт 3 з таблиці 2)
 *
 * @author Kurbatov
 */
public class Task3 {

    /**
     * Точка входу. Тестує метод calculateSum з різними аргументами.
     */
    public static void main(String[] args) {
        System.out.println("=== Завдання 1 (пункт 3 з таблиці 2) ===");
        System.out.println("--- Дозволені значення ---");
        printResults(1, 1.0);
        printResults(2, 2.0);
        printResults(5, 0.5);
        printResults(10, 3.0);
        printResults(14, 1.0);

        System.out.println("\n--- Заборонені (помилкові) значення ---");
        printResults(0, 1.0);     // помилка: k < 1
        printResults(15, 1.0);    // помилка: k >= 15
        printResults(20, 1.0);    // помилка: k >= 15
        printResults(-3, 1.0);    // помилка: k < 1
        printResults(5, 0.0);     // помилка: z <= 0
        printResults(5, -2.0);    // помилка: z <= 0
    }

    /**
     * Метод, що обчислює суму ряду:
     * sum_{i=1}^{k} ( sqrt(1 / (z * i)) + tg(k / i) ), при k < 15.
     *
     * @param k верхня межа суми (1 <= k < 15)
     * @param z параметр (z > 0)
     * @return значення суми ряду
     * @throws IllegalArgumentException якщо аргументи виходять за допустимі межі
     */
    public static double calculateSum(int k, double z) {
        if (k < 1 || k >= 15) {
            throw new IllegalArgumentException("param k = " + k + " (має бути 1 <= k < 15)");
        }
        if (z <= 0) {
            throw new IllegalArgumentException("param z = " + z + " (має бути z > 0)");
        }

        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            double term = Math.sqrt(1.0 / (z * i)) + Math.tan((double) k / i);
            sum += term;
        }

        return sum;
    }

    /**
     * Допоміжний метод для виведення результатів та перехоплення виключень.
     */
    static void printResults(int k, double z) {
        System.out.print("k:" + k + " z:" + z + " result:");
        try {
            System.out.println(calculateSum(k, z));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
