package lab03;

/**
 * Лабораторна робота №3
 * Тема: Управління потоком виконання
 * Виконав: студент групи ЦК-41 Курбатов Володимир
 * Варіант: 8
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Лабораторна робота №3");
        System.out.println("Тема: Управління потоком виконання");
        System.out.println("Виконав: студент групи ЦК-41 Курбатов Володимир");
        System.out.println("Варіант: 8");
        System.out.println("========================================\n");

        // ----------------------------------------------------
        // Завдання 1 (пункт 3 з таблиці 2)
        // ----------------------------------------------------
        Task3.main(args);
        System.out.println();

        // ----------------------------------------------------
        // Завдання 2 (пункт 9 з таблиці 2)
        // ----------------------------------------------------
        Task9.main(args);
        System.out.println();

        // ----------------------------------------------------
        // Завдання 3 (пункт 15 з таблиці 2)
        // ----------------------------------------------------
        Task15.main(args);
        System.out.println();

        // ----------------------------------------------------
        // Демонстрація коду з контрольних питань (№13, №14, №15)
        // ----------------------------------------------------
        System.out.println("========================================");
        System.out.println("Перевірка фрагментів коду з контрольних питань");
        System.out.println("========================================");

        // Питання 13
        System.out.println("\nКод з питання 13 (присвоєння в if):");
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

        // Питання 14
        System.out.println("\nКод з питання 14 (switch без break):");
        int val = 1;
        val++;
        ++val;
        switch (val) {
            case 1: System.out.println("1");
            case 2: System.out.println("2");
            case 3: System.out.println("3");
            case 4: System.out.println("4");
        }

        // Питання 15
        System.out.println("\nКод з питання 15 (цілочисельне ділення 1/i):");
        double sum = 0;
        for (int i = 1; i < 10; i++) {
            sum = sum + 1 / i;
        }
        System.out.println("sum > 1 -> " + (sum > 1));
    }
}
