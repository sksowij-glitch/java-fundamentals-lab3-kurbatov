package lab03;

/**
 * Лабораторна робота №3
 * Тема: Управління потоком виконання
 * Студент: Курбатов Володимир (група ЦК-41)
 * Варіант: 8
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота №3 (Варіант 8) ===");

        // --- Завдання 1 ---
        System.out.println("\n--- Завдання 1: Сума ряду з коренем та тангенсом ---");
        // Дозволені значення:
        printTask1(1, 1.0);
        printTask1(5, 0.5);
        printTask1(14, 1.0);
        // Помилкові значення (для перевірки виключень):
        printTask1(0, 1.0);   // k < 1
        printTask1(15, 1.0);  // k >= 15
        printTask1(5, -1.0);  // z <= 0

        // --- Завдання 2 ---
        System.out.println("\n--- Завдання 2: Функція x(t, l) ---");
        // Дозволені значення:
        printTask2(4, 1);   // l непарне (1)
        printTask2(4, 2);   // l парне (2)
        printTask2(9, 3);   // l непарне (3)
        // Помилкові значення:
        printTask2(0, 2);   // t < 1
        printTask2(4, -1);  // l < 1

        // --- Завдання 3 ---
        System.out.println("\n--- Завдання 3: Нескінченний ряд із точністю eps ---");
        // Дозволені значення:
        printTask3(0.01);
        printTask3(0.0001);
        // Помилкові значення:
        printTask3(0.0);    // eps <= 0
        printTask3(-0.01);  // eps < 0

        // --- Перевірка коду з контрольних питань ---
        System.out.println("\n--- Фрагменти з контрольних питань ---");

        // Питання 13: присвоєння замість порівняння в if
        System.out.println("Питання 13:");
        boolean a = false;
        boolean b = false;
        if (a = false) {
            System.out.println("a is false");
        }
        if (b = true) {
            System.out.println("b is true");
        }
        if (a = b) {
            System.out.println("a = b");
        }

        // Питання 14: switch без break (провалювання)
        System.out.println("Питання 14:");
        int val = 1;
        val++;
        ++val; // val стало 3
        switch (val) {
            case 1: System.out.println("1");
            case 2: System.out.println("2");
            case 3: System.out.println("3");
            case 4: System.out.println("4");
        }

        // Питання 15: цілочисельне ділення
        System.out.println("Питання 15:");
        double sum = 0;
        for (int i = 1; i < 10; i++) {
            sum = sum + 1 / i; // 1 / i дає 0 для всіх i >= 2
        }
        System.out.println("sum > 1 -> " + (sum > 1));
    }


    // =========================================================================
    // ЛОГІКА ЗАВДАНЬ
    // =========================================================================

    /**
     * Завдання 1 (пункт 3 з таблиці 2)
     * Формула: sum_{i=1}^{k} ( sqrt(1 / (z * i)) + tg(k / i) )
     * Обмеження за варіантом: 1 <= k < 15, z > 0
     */
    public static double task1(int k, double z) {
        // Перевіряємо обмеження з умови
        if (k < 1 || k >= 15) {
            throw new IllegalArgumentException("k має бути в межах від 1 до 14 включно (отримано " + k + ")");
        }
        if (z <= 0) {
            throw new IllegalArgumentException("z має бути більше нуля (отримано " + z + ")");
        }

        double sum = 0.0;

        // Рахуємо суму від 1 до k
        for (int i = 1; i <= k; i++) {
            double underRoot = 1.0 / (z * i);
            // Приводимо k до double, щоб ділення було дробовим, а не цілим
            double term = Math.sqrt(underRoot) + Math.tan((double) k / i);
            sum += term;
        }

        return sum;
    }

    /**
     * Завдання 2 (пункт 9 з таблиці 2)
     * Формула: x(t, l) = sum_{i=1}^{t} [ sqrt(t * l) для непарних l, або l / sqrt(t) для парних l ]
     * Обмеження: t >= 1, l >= 1
     */
    public static double task2(int t, int l) {
        // Перевіряємо вхідні числа
        if (t < 1) {
            throw new IllegalArgumentException("t має бути >= 1 (отримано " + t + ")");
        }
        if (l < 1) {
            throw new IllegalArgumentException("l має бути >= 1 (отримано " + l + ")");
        }

        // Обчислюємо доданок залежно від парності l
        double term;
        if (l % 2 != 0) {
            // Непарне l
            term = Math.sqrt((double) t * l);
        } else {
            // Парне l
            term = (double) l / Math.sqrt(t);
        }

        // Оскільки доданок однаковий для кожного кроку, додаємо його t разів
        double sum = 0.0;
        for (int i = 1; i <= t; i++) {
            sum += term;
        }

        return sum;
    }

    /**
     * Завдання 3 (пункт 15 з таблиці 2)
     * Формула: sum_{i=1}^{inf} [ (-1)^(i+1) / (i * (i+1) * (i+2)) ]
     * Обчислення зупиняється, коли черговий доданок за модулем стає меншим за eps.
     */
    public static double task3(double eps) {
        // Точність обов'язково має бути більшою за нуль
        if (eps <= 0) {
            throw new IllegalArgumentException("eps має бути більше 0 (отримано " + eps + ")");
        }

        double sum = 0.0;
        int i = 1;
        double sign = 1.0; // Для i = 1 перший знак додатний (+1)

        while (true) {
            // Знаменник формули: i * (i + 1) * (i + 2)
            double denominator = (double) i * (i + 1) * (i + 2);
            double term = sign / denominator;

            // Якщо модуль доданка менший за точність — зупиняємось
            if (Math.abs(term) < eps) {
                break;
            }

            sum += term;
            sign = -sign; // Знаки чергуються: +1, -1, +1, -1...
            i++;
        }

        return sum;
    }


    // =========================================================================
    // ПРОСТІ ДОПОМІЖНІ МЕТОДИ ДЛЯ ТЕСТУВАННЯ
    // =========================================================================

    private static void printTask1(int k, double z) {
        try {
            System.out.println("task1(k=" + k + ", z=" + z + ") = " + task1(k, z));
        } catch (IllegalArgumentException e) {
            System.out.println("task1(k=" + k + ", z=" + z + ") -> Помилка: " + e.getMessage());
        }
    }

    private static void printTask2(int t, int l) {
        try {
            System.out.println("task2(t=" + t + ", l=" + l + ") = " + task2(t, l));
        } catch (IllegalArgumentException e) {
            System.out.println("task2(t=" + t + ", l=" + l + ") -> Помилка: " + e.getMessage());
        }
    }

    private static void printTask3(double eps) {
        try {
            System.out.println("task3(eps=" + eps + ") = " + task3(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("task3(eps=" + eps + ") -> Помилка: " + e.getMessage());
        }
    }
}
