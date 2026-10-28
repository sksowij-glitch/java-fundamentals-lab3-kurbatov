package lab03;

/**
 * Лабораторна робота №3
 * Тема: Управління потоком виконання
 * Виконав: студент групи ЦК-41 Курбатов Володимир
 * Варіант: 8
 *
 * У цьому файлі зібрані всі завдання (1, 2, 3) та перевірка коду
 * з контрольних питань для зручності перевірки викладачем.
 *
 * @author Kurbatov
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("Лабораторна робота №3 (Варіант 8)");
        System.out.println("Виконав: студент групи ЦК-41 Курбатов Володимир");
        System.out.println("==================================================\n");

        // -----------------------------------------------------------------
        // ЗАВДАННЯ 1 (пункт 3 з таблиці 2)
        // -----------------------------------------------------------------
        System.out.println("=== Завдання 1: Сума ряду з коренем та тангенсом ===");
        System.out.println("--- Дозволені значення ---");
        testTask1(1, 1.0);
        testTask1(2, 2.0);
        testTask1(5, 0.5);
        testTask1(10, 3.0);
        testTask1(14, 1.0);

        System.out.println("\n--- Помилкові значення (перевірка викидання виключень) ---");
        testTask1(0, 1.0);     // помилка: k має бути від 1 до 14
        testTask1(15, 1.0);    // помилка: k < 15
        testTask1(20, 1.0);    // помилка: k завелике
        testTask1(-3, 1.0);    // помилка: k від'ємне
        testTask1(5, 0.0);     // помилка: z не може бути 0 (ділення на нуль)
        testTask1(5, -2.0);    // помилка: z має бути більше 0 (під коренем)

        // -----------------------------------------------------------------
        // ЗАВДАННЯ 2 (пункт 9 з таблиці 2)
        // -----------------------------------------------------------------
        System.out.println("\n==================================================");
        System.out.println("=== Завдання 2: Функція x(t, l) для парних і непарних l ===");
        System.out.println("--- Дозволені значення ---");
        testTask2(1, 1);   // непарне l: sqrt(t * l)
        testTask2(4, 1);   // непарне l
        testTask2(4, 2);   // парне l: l / sqrt(t)
        testTask2(9, 3);   // непарне l
        testTask2(9, 6);   // парне l
        testTask2(16, 4);  // парне l

        System.out.println("\n--- Помилкові значення (перевірка викидання виключень) ---");
        testTask2(0, 2);    // помилка: t має бути >= 1
        testTask2(-4, 2);   // помилка: t від'ємне
        testTask2(4, 0);    // помилка: l має бути >= 1
        testTask2(4, -3);   // помилка: l від'ємне

        // -----------------------------------------------------------------
        // ЗАВДАННЯ 3 (пункт 15 з таблиці 2)
        // -----------------------------------------------------------------
        System.out.println("\n==================================================");
        System.out.println("=== Завдання 3: Сума нескінченного ряду з точністю eps ===");
        System.out.println("--- Дозволені значення ---");
        testTask3(0.01);
        testTask3(0.001);
        testTask3(0.0001);
        testTask3(0.000001);

        System.out.println("\n--- Помилкові значення (перевірка викидання виключень) ---");
        testTask3(0.0);    // помилка: точність має бути більшою за нуль
        testTask3(-0.01);  // помилка: eps від'ємне
        testTask3(-1.0);   // помилка: eps від'ємне

        // -----------------------------------------------------------------
        // ДЕМОНСТРАЦІЯ КОДУ З КОНТРОЛЬНИХ ПИТАНЬ (№13, №14, №15)
        // -----------------------------------------------------------------
        System.out.println("\n==================================================");
        System.out.println("=== Перевірка фрагментів коду з контрольних питань ===");
        System.out.println("==================================================");

        // Питання 13: присвоєння замість порівняння в if
        System.out.println("\nКод з питання 13 (присвоєння = замість == в if):");
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

        // Питання 14: switch без break
        System.out.println("\nКод з питання 14 (switch без операторів break):");
        int val = 1;
        val++;
        ++val;
        switch (val) {
            case 1: System.out.println("1");
            case 2: System.out.println("2");
            case 3: System.out.println("3");
            case 4: System.out.println("4");
        }

        // Питання 15: цілочисельне ділення
        System.out.println("\nКод з питання 15 (цілочисельне ділення 1 / i):");
        double sum = 0;
        for (int i = 1; i < 10; i++) {
            sum = sum + 1 / i; // тут 1 / i завжди дає 0 для i >= 2
        }
        System.out.println("sum > 1 -> " + (sum > 1));
    }


    // =====================================================================
    // МЕТОДИ ЛОГІКИ ЗАВДАНЬ (чиста бізнес-логіка, без System.out всередині)
    // =====================================================================

    /**
     * Завдання 1 (пункт 3 з таблиці 2)
     * Формула: sum_{i=1}^{k} ( sqrt(1 / (z * i)) + tg(k / i) )
     * Обмеження: 1 <= k < 15, z > 0
     *
     * @param k верхня межа суми (1 <= k < 15)
     * @param z параметр (z > 0)
     * @return значення суми ряду
     */
    public static double task1(int k, double z) {
        // Спочатку перевіряємо параметри, щоб не зламати корінь або ділення на нуль
        if (k < 1 || k >= 15) {
            throw new IllegalArgumentException("Параметр k = " + k + " (має бути від 1 до 14 включно)");
        }
        if (z <= 0) {
            throw new IllegalArgumentException("Параметр z = " + z + " (має бути строго більше нуля)");
        }

        double totalSum = 0.0;
        // Крутимо цикл від 1 до k
        for (int i = 1; i <= k; i++) {
            // Рахуємо частини виразу окремо
            double underRoot = 1.0 / (z * i);
            double sqrtPart = Math.sqrt(underRoot);
            // Важливо: приводимо k до double, щоб ділення (k / i) було дробовим, а не цілим!
            double tanPart = Math.tan((double) k / i);
            
            totalSum += (sqrtPart + tanPart);
        }

        return totalSum;
    }

    /**
     * Завдання 2 (пункт 9 з таблиці 2)
     * Формула: sum_{i=1}^{t} ( sqrt(t * l) якщо l непарне, або l / sqrt(t) якщо l парне )
     * Обмеження: t >= 1, l >= 1
     *
     * @param t верхня межа суми (t >= 1)
     * @param l параметр парності (l >= 1)
     * @return значення функції x(t, l)
     */
    public static double task2(int t, int l) {
        // Перевіряємо вхідні аргументи
        if (t < 1) {
            throw new IllegalArgumentException("Параметр t = " + t + " (має бути ціле число t >= 1)");
        }
        if (l < 1) {
            throw new IllegalArgumentException("Параметр l = " + l + " (має бути натуральне число l >= 1)");
        }

        // Визначаємо доданок залежно від того, чи парне число l
        double term;
        if (l % 2 != 0) {
            // Якщо l непарне (1, 3, 5...)
            term = Math.sqrt((double) t * l);
        } else {
            // Якщо l парне (2, 4, 6...)
            term = (double) l / Math.sqrt(t);
        }

        // Доданок не змінюється від i, тому просто сумуємо його t разів
        double totalSum = 0.0;
        for (int i = 1; i <= t; i++) {
            totalSum += term;
        }

        return totalSum;
    }

    /**
     * Завдання 3 (пункт 15 з таблиці 2)
     * Формула: sum_{i=1}^{inf} ( (-1)^(i + 1) / (i * (i + 1) * (i + 2)) )
     * Обмеження: eps > 0
     *
     * @param eps бажана точність (eps > 0)
     * @return наближена сума ряду
     */
    public static double task3(double eps) {
        // Точність обов'язково має бути більшою за нуль
        if (eps <= 0) {
            throw new IllegalArgumentException("Точність eps = " + eps + " (має бути строго більше 0)");
        }

        double totalSum = 0.0;
        int i = 1;

        // Рахуємо нескінченний ряд, поки доданок за модулем не стане меншим за eps
        while (true) {
            // Знак чергується: для непарних i (+), для парних (-)
            double sign = (i % 2 != 0) ? 1.0 : -1.0;

            // Знаменник: i * (i + 1) * (i + 2)
            double denominator = (double) i * (i + 1) * (i + 2);
            double term = sign / denominator;

            // Якщо модуль поточного доданка менший за точність — зупиняємось
            if (Math.abs(term) < eps) {
                break;
            }

            totalSum += term;
            i++;
        }

        return totalSum;
    }


    // =====================================================================
    // ДОПОМІЖНІ МЕТОДИ ДЛЯ ВИВЕДЕННЯ ТА ТЕСТУВАННЯ
    // =====================================================================

    private static void testTask1(int k, double z) {
        System.out.print("k = " + k + ", z = " + z + " -> Результат: ");
        try {
            System.out.println(task1(k, z));
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }

    private static void testTask2(int t, int l) {
        System.out.print("t = " + t + ", l = " + l + " -> Результат: ");
        try {
            System.out.println(task2(t, l));
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }

    private static void testTask3(double eps) {
        System.out.print("eps = " + eps + " -> Результат: ");
        try {
            System.out.println(task3(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }
}
