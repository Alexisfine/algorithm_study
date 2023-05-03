package binary_search;


public class BinarySearch {
    public static boolean binarySearch(Comparable[] arr, Comparable a) {
        if (arr == null || a == null) return false;
        return binarySearch(arr, a, 0, arr.length - 1);
    }

    private static boolean binarySearch(Comparable[] arr, Comparable a, int first, int last) {
        int mid, result;
        while (first <= last) {
            mid = (first + last) / 2;
            result = compare(arr, a, mid);
            if (result == 0) return true;
            if (result < 0) last = mid - 1;
            if (result > 0) first = mid + 1;
        }
        return false;
    }

    private static int compare(Comparable[] arr, Comparable a, int mid) {
        return a.compareTo(arr[mid]);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,6,7};
        for (int i = 0; i < 10; i++) System.out.println(binarySearch(arr, i));
    }
}
