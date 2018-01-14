package _1_Sorts;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] arr, int fromIndex, int len) {
        if (len == 0) {
            return new int[0];
        } else if (len == 1) {
            return new int[]{arr[fromIndex]};
        } else if (len == 2) {
            if (arr[fromIndex] < arr[fromIndex + 1]) {
                return new int[]{arr[fromIndex], arr[fromIndex + 1]};
            } else {
                return new int[]{arr[fromIndex + 1], arr[fromIndex]};
            }
        } else {
            int[] left = sort(arr, fromIndex, len / 2);
            int[] right = sort(arr, fromIndex + len / 2, len - (len / 2));
            return merge(left, right);
        }
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        //System.out.println(result.length);
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] < b[bIndex])
                result[aIndex + bIndex] = a[aIndex++];
            else result[aIndex + bIndex] = b[bIndex++];
        }
        if (aIndex < bIndex)
            System.arraycopy(a, aIndex, result, aIndex + bIndex, a.length - aIndex);
        else
            System.arraycopy(b, bIndex, result, aIndex + bIndex, b.length - bIndex);
        System.out.print(Arrays.toString(a) + " + " + Arrays.toString(b));
        System.out.println(" -> " + Arrays.toString(result));
        return result;
    }
}

