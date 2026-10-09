package lab03;

/**
 * Лабораторна робота №3
 * Варіант 8 -> Завдання №2 (пункт 9 з таблиці 2)
 *
 * @author Kurbatov
 */
public class Task9 {

    /**
     * Точка входу. Тестує метод calculateFunction з різними значеннями параметрів.
     */
    public static void main(String[] args) {
        System.out.println("=== Завдання 2 (пункт 9 з таблиці 2) ===");
        System.out.println("--- Дозволені значення ---");
        printResults(1, 1);   // непарне l
        printResults(4, 1);   // непарне l
        printResults(4, 2);   // парне l
        printResults(9, 3);   // непарне l
        printResults(9, 6);   // парне l
        printResults(16, 4);  // парне l

        System.out.println("\n--- Заборонені (помилкові) значення ---");
        printResults(0, 2);    // помилка: t < 1
        printResults(-4, 2);   // помилка: t < 1
        printResults(4, 0);    // помилка: l < 1
        printResults(4, -3);   // помилка: l < 1
    }

    /**
     * Метод для обчислення значення функції x(t, l):
     * sum_{i=1}^{t} (
     *     sqrt(t * l), якщо l = 1, 3, 5, ...
     *     l / sqrt(t), якщо l = 2, 4, 6, ...
     * )
     *
     * @param t верхня межа суми (t >= 1)
     * @param l параметр парності (l >= 1)
     * @return значення функції
     * @throws IllegalArgumentException якщо t < 1 або l < 1
     */
    public static double calculateFunction(int t, int l) {
        if (t < 1) {
            throw new IllegalArgumentException("param t = " + t + " (має бути ціле число t >= 1)");
        }
        if (l < 1) {
            throw new IllegalArgumentException("param l = " + l + " (має бути натуральне число l >= 1)");
        }

        double term;
        if (l % 2 != 0) {
            // Для непарних l (1, 3, 5...)
            term = Math.sqrt((double) t * l);
        } else {
            // Для парних l (2, 4, 6...)
            term = (double) l / Math.sqrt(t);
        }

        double sum = 0.0;
        for (int i = 1; i <= t; i++) {
            sum += term;
        }

        return sum;
    }

    /**
     * Допоміжний метод для виведення результатів та перехоплення виключень.
     */
    static void printResults(int t, int l) {
        System.out.print("t:" + t + " l:" + l + " result:");
        try {
            System.out.println(calculateFunction(t, l));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
