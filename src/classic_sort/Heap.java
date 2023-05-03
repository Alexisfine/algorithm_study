package classic_sort;

public class Heap {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        // to heap
        for (int i = 0; i < arr.length; i++) insert(arr, i);

        int heapSize = arr.length;
        // swap 0 th and first position
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }
    public static void insert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // index is where will I begin heapify
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; // left child
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] >= arr[left] ? index : largest;
            if (largest == index) break;
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
