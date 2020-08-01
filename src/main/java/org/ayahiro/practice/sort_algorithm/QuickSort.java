package org.ayahiro.practice.sort_algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3, 5, 8, 1, 2, 9, 4, 7, 6};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (endIndex <= startIndex) return;
        int pivotIndex = getPivotIndex(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }
    //单边扫描法
    public static int getPivotIndex(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; ++i) {
            if (pivot > array[i]) {
                mark++;
                int temp = array[i];
                array[i] = array[mark];
                array[mark] = temp;
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }
}
