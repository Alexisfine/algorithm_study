package array;

public class PrintNumInArray {
    public static void printNumberNoInArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i : arr) modify(i, arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) System.out.println(i + 1);
        }
    }

    private static void modify(int i, int[] arr) {
        while (arr[i - 1] != i) {
            int tmp = arr[i - 1];
            arr[i - 1] = i;
            i = tmp;
        }
    }
}
