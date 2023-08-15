package leetcode_questions.binary_search.by_value;

import java.util.ArrayList;
import java.util.List;

public class _373_Find_K_Pairs_With_Smallest_Sums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int lo = nums1[0] + nums2[0];
        int hi = nums1[nums1.length - 1] + nums2[nums2.length - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long count = countSmallerOrEqual(mid, nums1, nums2); // the number of pairs' sum <= mid
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        List<List<Integer>> res1 = new ArrayList<>();
        List<List<Integer>> res2 = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length && nums1[i] + nums2[j] <= lo; j++) {
                if (nums1[i] + nums2[j] < lo) {
                    res1.add(List.of(nums1[i], nums2[j]));
                } else {
                    res2.add(List.of(nums1[i], nums2[j]));
                }
            }
        }
        int counter = 0;
        while (res1.size() < k && counter < res2.size()) {
            res1.add(res2.get(counter++));
        }
        return res1;
    }

    private long countSmallerOrEqual(int num, int[] nums1, int[] nums2) {
        // nums1[i] + nums2[j] <= num
        long res = 0;
        int j = nums2.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            while (j >= 0 && nums1[i] + nums2[j] > num) j--;
            if (j < 0) break;
            res += (j + 1);
        }
        return res;
    }
}
