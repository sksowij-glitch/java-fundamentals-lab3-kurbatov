package lab03;

/**
 * Лабораторна робота №3
 * Варіант 8 -> Завдання №3 (пункт 15 з таблиці 2)
 *
 * @author Kurbatov
 */
public class Task15 {

    /**
     * Точка входу. Тестує метод calculateInfiniteSum з різними значеннями точності eps.
     */
    public static void main(String[] args) {
        System.out.println("=== Завдання 3 (пункт 15 з таблиці 2) ===");
        System.out.println("--- Дозволені значення ---");
        printResults(0.01);
        printResults(0.001);
        printResults(0.0001);
        printResults(0.000001);

        System.out.println("\n--- Заборонені (помилкові) значення ---");
        printResults(0.0);    // помилка: eps <= 0
        printResults(-0.01);  // помилка: eps <= 0
        printResults(-1.0);   // помилка: eps <= 0
    }

    /**
     * Метод для обчислення нескінченної суми ряду:
     * sum_{i=1}^{inf} ( (-1)^(i + 1) / (i * (i + 1) * (i + 2)) )
     * із заданою точністю eps > 0.
     *
     * Обчислення припиняється, коли черговий доданок за модулем стає меншим за eps.
     * Цей доданок і наступні не враховуються.
     *
     * @param eps точність обчислення (eps > 0)
     * @return наближене значення суми ряду
     * @throws IllegalArgumentException якщо eps <= 0
     */
    public static double calculateInfiniteSum(double eps) {
        if (eps <= 0) {
            throw new IllegalArgumentException("param eps = " + eps + " (має бути eps > 0)");
        }

        double sum = 0.0;
        int i = 1;

        while (true) {
            // Знак (-1)^(i + 1):
            // для непарного i (1, 3, 5...) буде 1.0
            // для парного i (2, 4, 6...) буде -1.0
            double sign = (i % 2 != 0) ? 1.0 : -1.0;

            // Черговий доданок
            double term = sign / ((double) i * (i + 1) * (i + 2));

            // Якщо модуль доданка виявився меншим за eps, зупиняємось
            if (Math.abs(term) < eps) {
                break;
            }

            sum += term;
            i++;
        }

        return sum;
    }

    /**
     * Допоміжний метод для виведення результатів та перехоплення виключень.
     */
    static void printResults(double eps) {
        System.out.print("eps:" + eps + " result:");
        try {
            System.out.println(calculateInfiniteSum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
