package lab05;

import java.util.Random;

/**
 * Лабораторна робота №5
 * Тема: Алгоритми сортування
 * Студент: Курбатов Володимир (група ЦК-41)
 * Варіант: 8
 *
 * Параметри варіанту 8:
 * - Тип масиву: long[]
 * - Порядок сортування: по спаданню (від більшого до меншого)
 * - Метод 1: Сортування вибором (Selection sort)
 * - Метод 2: Сортування вставкою (Insertion sort)
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("Лабораторна робота №5 (Варіант 8): Алгоритми сортування");
        System.out.println("Виконав: студент групи ЦК-41 Курбатов Володимир");
        System.out.println("==================================================\n");

        // -------------------------------------------------------------
        // 1. Генерація випадкового масиву типу long[]
        // -------------------------------------------------------------
        int size = 10;
        System.out.println("Генерація випадкового масиву розміром " + size + " елементів:");
        long[] originalArray = generateRandomArray(size, 100);

        System.out.print("Початковий масив: ");
        printArray(originalArray);
        System.out.println();

        // -------------------------------------------------------------
        // 2. Метод 1: Сортування вибором (Selection sort) по спаданню
        // -------------------------------------------------------------
        long[] arrayForSelection = copyArray(originalArray);
        System.out.println("1. Сортування вибором (Selection sort) [по спаданню]:");
        selectionSort(arrayForSelection);
        System.out.print("Результат:        ");
        printArray(arrayForSelection);
        System.out.println();

        // -------------------------------------------------------------
        // 3. Метод 2: Сортування вставкою (Insertion sort) по спаданню
        // -------------------------------------------------------------
        long[] arrayForInsertion = copyArray(originalArray);
        System.out.println("2. Сортування вставкою (Insertion sort) [по спаданню]:");
        insertionSort(arrayForInsertion);
        System.out.print("Результат:        ");
        printArray(arrayForInsertion);
        System.out.println();

        // -------------------------------------------------------------
        // 4. Додаткове тестування на спеціальних випадках
        // -------------------------------------------------------------
        System.out.println("==================================================");
        System.out.println("Додаткове тестування на граничних випадках:");
        System.out.println("==================================================");

        // Випадок А: Масив із від'ємними та додатними числами
        long[] customArray = {-15L, 42L, 0L, -3L, 99L, 7L};
        System.out.print("Тестовий масив зі знаками: ");
        printArray(customArray);

        long[] testCopy1 = copyArray(customArray);
        selectionSort(testCopy1);
        System.out.print("Selection sort:            ");
        printArray(testCopy1);

        long[] testCopy2 = copyArray(customArray);
        insertionSort(testCopy2);
        System.out.print("Insertion sort:            ");
        printArray(testCopy2);
        System.out.println();

        // Випадок Б: Масив з 1 елемента
        long[] singleElement = {42L};
        System.out.print("Один елемент:              ");
        selectionSort(singleElement);
        printArray(singleElement);

        // Випадок В: Вже відсортований по спаданню масив
        long[] alreadySorted = {50L, 40L, 30L, 20L, 10L};
        System.out.print("Вже відсортований масив:   ");
        insertionSort(alreadySorted);
        printArray(alreadySorted);
    }

    /**
     * Генерація масиву випадкових чисел типу long в діапазоні від 0 до bound - 1.
     *
     * @param size  розмір масиву
     * @param bound верхня межа (не включно)
     * @return згенерований масив типу long[]
     */
    public static long[] generateRandomArray(int size, int bound) {
        if (size < 0) {
            throw new IllegalArgumentException("Розмір масиву не може бути від'ємним!");
        }
        Random random = new Random();
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    /**
     * Сортування вибором (Selection sort) масиву long[] за спаданням.
     *
     * Принцип роботи:
     * Знаходимо найбільший елемент у невідсортованій частині масиву
     * і міняємо його місцями з поточним першим невідсортованим елементом.
     *
     * @param array масив для сортування
     */
    public static void selectionSort(long[] array) {
        if (array == null) {
            return;
        }

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // Припускаємо, що поточний елемент i є максимальним
            int maxIndex = i;

            // Шукаємо індекс найбільшого елемента серед елементів від i + 1 до кінця
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Якщо знайдено більший елемент — міняємо їх місцями
            if (maxIndex != i) {
                long temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    /**
     * Сортування вставкою (Insertion sort) масиву long[] за спаданням.
     *
     * Принцип роботи:
     * Беремо кожен наступний елемент (key) і вставляємо його у вже
     * відсортовану ліву частину на відповідне місце, зсуваючи менші елементи праворуч.
     *
     * @param array масив для сортування
     */
    public static void insertionSort(long[] array) {
        if (array == null) {
            return;
        }

        int n = array.length;

        for (int i = 1; i < n; i++) {
            long key = array[i]; // запам'ятовуємо значення, яке вставляємо
            int j = i - 1;

            // Зсуваємо всі елементи, які менші за key, на одну позицію вправо
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            // Вставляємо key на звільнену позицію
            array[j + 1] = key;
        }
    }

    /**
     * Допоміжний метод для виведення масиву long[] в один рядок.
     *
     * @param array масив для друку
     */
    public static void printArray(long[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Допоміжний метод для створення копії масиву.
     *
     * @param original оригінальний масив
     * @return новий масив із копією значень
     */
    public static long[] copyArray(long[] original) {
        if (original == null) {
            return null;
        }
        long[] copy = new long[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }
}
