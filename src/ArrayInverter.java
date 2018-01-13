import java.util.Arrays;

public class ArrayInverter {
    public static void main(String args[])
    {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
        invert(arr);
        System.out.println(Arrays.toString(arr));

    }
    private static void invert(int[] arr)
    {
        for (int i = arr.length / 2; i > 0; i--)
        {
            int temp = arr[arr.length - i];
            arr[arr.length - i] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }
}
