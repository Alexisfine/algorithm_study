package leetcode_questions.segment_tree;

public class _307_Range_Sum_Query_Mutable {
    public class NumArray {
        int max;
        int[] arr;
        int[] sum;
        public NumArray(int[] nums) {
            max = nums.length + 1;
            arr = new int[max];
            for (int i = 1; i < max; i++) arr[i] = nums[i - 1];
            sum = new int[max << 2];
            build(1, max - 1, 1);
        }

        public void update(int index, int val) {
            update(index + 1, val, 1, max - 1, 1);
        }

        private void update(int L, int val, int l, int r, int index) {
            if (L == l && l == r) {
                sum[index] = val;
                return;
            }
            int mid = (l + r) >> 1;
            if (L <= mid) {
                update(L, val, l, mid, index << 1);
            } else {
                update(L, val, mid + 1, r, index << 1 | 1);
            }
            sum[index] = sum[index << 1] + sum[index << 1 | 1];
        }


        public int sumRange(int left, int right) {
            return sumRange(left + 1, right + 1, 1, max - 1, 1);
        }

        private int sumRange(int L, int R, int l, int r, int index) {
            if (L <= l && r <= R) return sum[index];
            int res = 0;
            int mid = (l + r) >> 1;
            if (L <= mid) {
                res += sumRange(L, R, l, mid, index << 1);
            }
            if (R > mid) {
                res += sumRange(L, R, mid + 1, r, index << 1 | 1);
            }
            return res;
        }

        private void build(int l, int r, int index) {
            if (l == r) {
                sum[index] = arr[l];
                return;
            }
            int mid = (l + r) >> 1;
            build(l, mid, index << 1);
            build(mid + 1, r, index << 1 | 1);
            sum[index] = sum[index << 1] + sum[index << 1 | 1];
        }
    }
}
