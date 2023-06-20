package leetcode_questions.array.two_pointers;

import java.util.HashMap;
import java.util.Map;

public class _1570_Dot_Product_Of_Two_Sparse_Vectors {
    class SparseVector {
        Map<Integer, Integer> map;

        SparseVector(int[] nums) {
            this.map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) map.put(i, nums[i]);
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int product = 0;
            for (Map.Entry<Integer, Integer> entry : vec.map.entrySet()) {
                int row = entry.getKey();
                if (map.containsKey(row)) {
                    product += entry.getValue() * map.get(row);
                }
            }
            return product;
        }
    }
}
