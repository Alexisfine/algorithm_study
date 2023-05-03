package elementary_sort;


public class Pop {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = N - 1; i > 0; i--) {
           for (int j = 0; j < i; j++) {
               if (less(a[j+1], a[j])) exch(a, j, j+1);
           }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,3,7,6,2,5,1,6};
        sort(arr);
        for (int i: arr) System.out.println(i);
    }
}
