package classic_sort;

public class Quick {
    public static void sort(int[] arr) {
        int len = arr.length;
        if (len < 2) return;
        sort(arr, 0, len - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int[] p = partition(arr, lo, hi);
            sort(arr, lo, p[0] - 1);
            sort(arr, p[1] + 1, hi);
        }
    }

    private static int[] partition(int[] arr, int lo, int hi) {
        int leftBound = lo - 1;
        int rightBound = hi;
        int current = lo;
        while (current < rightBound) {
            if (arr[current] < arr[hi]) {
                swap(arr, ++leftBound, current++);
            } else if (arr[current] == arr[hi]) {
                current++;
            } else {
                swap(arr, current, --rightBound);
            }
        }
        swap(arr, rightBound, hi);
        return new int[]{leftBound + 1, rightBound};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        sort(arr);
        for (int i = 0; i < 100; i++) {
            System.out.println(arr[i]);
        }
    }
}
