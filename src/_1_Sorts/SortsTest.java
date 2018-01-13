package _1_Sorts;

import java.util.Arrays;

import static _1_Sorts.BubbleSort.bubbleSort;
import static _1_Sorts.InsertionSort.insertionSort;
import static _1_Sorts.InsertionSort.insertionSortOptimized;
import static _1_Sorts.SelectionSort.selectionSort;
import static _1_Sorts.SelectionSort.selectionSortOptimezed;

public class SortsTest {
    public static void main(String args[]) {
        long startTime = System.nanoTime();
        int[] arr = {5, 0, 4, 2, 7, 3, 9, 8, 6, 1};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        selectionSort(arr);
//        selectionSortOptimezed(arr);
//        insertionSort(arr);
        insertionSortOptimized(arr);
        System.out.println(Arrays.toString(arr));
        long timeSpent = System.nanoTime() - startTime;
        System.out.println("Программа выполнялась " + timeSpent / 1_000 + " миллисекунд");
    }
}