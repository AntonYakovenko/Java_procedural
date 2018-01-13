package _1_Sorts;

import java.util.Arrays;

class InsertionSort {
    static void insertionSort(int[] arr)
    {
        for(int barrier = 1; barrier < arr.length; barrier++)
        {
            int newElement = arr[barrier];
            int location = barrier - 1;
            while(location >=0 && arr[location] > newElement)
            {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;
        }
    }

    static void insertionSortOptimized(int[] arr)
    {
        for(int barrier = 1; barrier < arr.length; barrier++)
        {
            int newElement = arr[barrier];
            int location = Arrays.binarySearch(arr, 0, barrier, newElement);
            if(location < 0)
            {
                location = - location - 1;
            }
            System.arraycopy(arr, location, arr, location + 1, barrier - location);
            arr[location] = newElement;
        }
    }
}
