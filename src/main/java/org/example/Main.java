package org.example;

public class Main {
    public static void main(String[] args) {
        int [] myArray = {4,3,5,2,1,6,9,8,7,0};
        pyramidSorting(myArray);
    }

    public static void pyramidSorting(int [] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            completion(array, array.length, i);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            completion(array, i, 0);
        }
        printArray(array);
    }

    private static void completion(int[] array, int length, int index) {
        int big = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < length && array[leftChild] > array[big]) {
            big = leftChild;
        }
        if (rightChild < length && array[rightChild] > array [big]) {
            big = rightChild;
        }
        if (big != index) {
            int temp = array [index];
            array [index] = array [big];
            array [big] = temp;
            completion(array,length,big);
        }
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i);
            if (i != array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
    }
}