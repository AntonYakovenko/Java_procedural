package _1_Sorts;

class SelectionSort {
    static void selectionSort(int[] arr)
    {
        for(int barrier = 0; barrier < arr.length - 1; barrier++)
        {
            for(int index = barrier + 1; index < arr.length; index++)
            {
                if(arr[barrier] > arr[index])
                {
                    int tmp = arr[barrier];
                    arr[barrier] = arr[index];
                    arr[index] = tmp;
                }
            }
        }
    }

    static void selectionSortOptimezed(int[] arr)
    {
        for(int barrier = 0; barrier < arr.length - 1; barrier++)
        {
            int least = barrier;
            for(int index = barrier + 1; index < arr.length; index++)
            {
                if(arr[least] > arr[index])
                {
                    least = index;
                }
            }
            int tmp = arr[barrier];
            arr[barrier] = arr[least];
            arr[least] = tmp;
        }
    }
}
