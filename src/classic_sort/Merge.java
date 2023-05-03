package classic_sort;

public class Merge {
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        Comparable[] aux = new Comparable[a.length];

        // Create an aux array
        for (int i = 0; i < aux.length; i++) {
            aux[i] = a[i];
        }
        int leftPt = lo;
        int rightPt = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (leftPt > mid) a[i] = aux[rightPt++];
            else if (rightPt > hi) a[i] = aux[leftPt++];
            else if (less(aux[leftPt], aux[rightPt])) a[i] = aux[leftPt++];
            else a[i] = aux[rightPt++];
        }
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
