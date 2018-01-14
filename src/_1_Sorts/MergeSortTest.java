package _1_Sorts;
import java.util.Arrays;

public class MergeSortTest {
    public static void main(String args[]){

        // TestMerger

        int[] arr1 = {2, 4, 6, 7, 7, 10, 18, 25, 40, 41};
        int[] arr2 = {1, 1, 12, 13, 14, 15, 16, 17};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int[] mergeArr = MergeSort.merge(arr1, arr2);
        System.out.println(Arrays.toString(mergeArr));

        // TestMergeSort

        int[] arr = {4, 0, 5, 5, 1, 8, 2, 9, 4, 4};
        System.out.println(Arrays.toString(arr));
        int[] mergedArr = MergeSort.sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(mergedArr));
    }
}

