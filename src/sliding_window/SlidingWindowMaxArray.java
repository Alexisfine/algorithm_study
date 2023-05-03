package sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || arr.length < w || w < 1) return null;
        Deque<Integer> sw = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];

        // add w values
        for (int i = 0; i < w; i++) {
            while (!sw.isEmpty() && sw.getLast() < arr[i]) {
                sw.removeLast();
            }
            sw.addLast(arr[i]);
        }
        int leftPtr = 0;
        int rightPtr = w;
        res[0] = sw.getFirst();
        for (int i = 1; i < res.length; i++) {
            // move left pointer
            if (arr[leftPtr++] == sw.getFirst()) sw.removeFirst();
            // move right pointer
            while (!sw.isEmpty() && sw.getLast() < arr[rightPtr]) {
                sw.removeLast();
            }
            sw.addLast(arr[rightPtr++]);
            res[i] = sw.getFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        getMaxWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
