package leetcode_questions.others.quickselect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _347_Top_K_Frequent_Element {
    // quick select
    public record Pair(int value, int frequency) {}
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.putIfAbsent(num, 0);
            freqMap.put(num, freqMap.get(num) + 1);
        }
        Pair[] arr = new Pair[freqMap.size()];
        int counter = 0;
        for (var entry : freqMap.entrySet()) {
            arr[counter] = new Pair(entry.getKey(), entry.getValue());
            counter++;
        }

        int freq = quickSelect(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        counter = 0;
        for (var entry : freqMap.entrySet()) {
            if (entry.getValue() >= freq) {
                res[counter++] = entry.getKey();
            }
        }
        return res;

    }

    private int quickSelect(Pair[] arr, int lo, int hi, int k) {
        int pivot = arr[(lo + hi) / 2].frequency;

        int i = lo;
        int t = lo;
        int j = hi;
        while (t <= j) {
            if (arr[t].frequency < pivot) {
                swap(arr, i, t);
                i++;
                t++;
            } else if (arr[t].frequency == pivot) {
                t++;
            } else {
                swap(arr, t, j);
                j--;
            }
        }

        if (hi - j >= k) {
            return quickSelect(arr, j + 1, hi, k);
        } else if (hi - i + 1 >= k) {
            return pivot;
        } else {
            return quickSelect(arr, 0, i - 1, k - (hi - i + 1));
        }
    }

    /*
    S S S S E E L L L L
    a       i t       b

     */

    private void swap(Pair[] arr, int i, int t) {
        Pair temp = arr[i];
        arr[i] = arr[t];
        arr[t] = temp;
    }

    // binary search
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.putIfAbsent(num, 0);
            freqMap.put(num, freqMap.get(num) + 1);
        }

        int lo = 0;
        int hi = Integer.MAX_VALUE / 2;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (countFreq(freqMap, mid) >= k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (var entry : freqMap.entrySet()) {
            if (entry.getValue() >= lo) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int countFreq(Map<Integer, Integer> freqMap, int mid) {
        int res = 0;
        for (var entry : freqMap.entrySet()) {
            if (entry.getValue() >= mid) {
                res++;
            }
        }
        return res;
    }
}
