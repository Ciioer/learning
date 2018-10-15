package Offer;

public class num03FindIn2Int {
    public static boolean find(int[][] arr, int target) {
        if (arr == null) {
            return false;
        }
        int row = 0;
        int colum = arr[0].length - 1;
        while (row < arr.length && colum >= 0) {
            if (arr[row][colum] == target) {
                return true;
            }
            if (arr[row][colum] > target) {
                colum--;
            } else {
                row++;
            }
        }
        return false;
    }
}
