package org.ayahiro.practice.sort_algorithm;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {3, 5, 8, 1, 2, 9, 4, 7, 6};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void heapSort(int[] array) {
        int length = array.length;
        buildHeap(array, length);
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0]; //将堆顶元素与末位元素调换
            array[0] = array[i];
            array[i] = temp;
            length--; //数组长度-1 隐藏堆尾元素
            sink(array, 0, length); //将堆顶元素下沉 目的是将最大的元素浮到堆顶来
        }
    }

    public static void buildHeap(int[] array, int length) {
        for (int i = length / 2; i >= 0; i--) {
            sink(array, i, length);
        }
    }

    public static void sink(int[] array, int index, int length) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int present = index; //要调整的节点下标
        //下沉左边
        if (leftChild < length && array[leftChild] > array[present]) {
            present = leftChild;
        }
        //下沉右边
        if (rightChild < length && array[rightChild] > array[present]) {
            present = rightChild;
        }
        //如果下标不相等 证明调换过了
        if (present != index) {
            int temp = array[present];
            array[present] = array[index];
            array[index] = temp;
            sink(array, present, length); //继续下沉
        }
    }
}
