package basic_class_01;

public class My_NetherlandsFlag {
    public static int[] sort(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int index = L;
        while (L < more) {
            if (arr[index] < num) {
                swap(arr, ++less, index++);
            } else if (arr[index] > num) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
}
