package org.ayahiro.practice.sort_algorithm;

public class MergeSort {
    public static final int MAX_SIZE = 100;
    public static int[] tempArray = new int[MAX_SIZE];

    public static void main(String[] args) {
        int[] array = {3, 5, 8, 1, 2, 9, 4, 7, 6};
        mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void mergeSort(int[] array, int startIndex, int endIndex) {
        if (endIndex <= startIndex) return;
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        mergeSort(array, startIndex, middleIndex);
        mergeSort(array, middleIndex + 1, endIndex);
        merge(array, startIndex, middleIndex, endIndex);
    }

    public static void merge(int[] array, int startIndex, int middleIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            tempArray[i] = array[i];
        }
        int left = startIndex;
        int right = middleIndex + 1;
        for (int i = startIndex; i <= endIndex; i++) {
            if (left > middleIndex) {
                array[i] = tempArray[right++];
            } else if (right > endIndex) {
                array[i] = tempArray[left++];
            } else if (tempArray[right] < tempArray[left]) {
                array[i] = tempArray[right++];
            } else {
                array[i] = tempArray[left++];
            }
        }
    }
}
