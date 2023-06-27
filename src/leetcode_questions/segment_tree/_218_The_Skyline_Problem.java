package leetcode_questions.segment_tree;

import java.util.*;

public class _218_The_Skyline_Problem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < buildings.length; i++) {
            set.add((long) buildings[i][0] + 1);
            set.add((long) buildings[i][1] + 1);
        }
        int id = 1;
        Map<Long, Integer> posIndexMap = new HashMap<>();
        for (var pos : set) {
            posIndexMap.put(pos, id);
            id++;
        }

        int size = posIndexMap.size();
        SegmentTree segmentTree = new SegmentTree(size);
        for (int i = 0; i < buildings.length; i++) {
            int from = posIndexMap.get((long) buildings[i][0] + 1);
            int to = posIndexMap.get((long) buildings[i][1] + 1) - 1;
            int height = buildings[i][2];
            segmentTree.update(height, from, to);
        }

        List<List<Integer>> res = new ArrayList<>();
        int prevHeight = -1;
        for (var pos : set) {
            int index = posIndexMap.get(pos);
            int curHeight = segmentTree.query(index);
            if (curHeight != prevHeight) {
                prevHeight = curHeight;
                res.add(List.of((int) (pos - 1), curHeight));
            }
        }
        return res;
    }

    public class SegmentTree {
        int size;
        int[] maxArr;
        boolean[] update;
        int[] change;
        public SegmentTree(int s) {
            size = (int) Math.pow(2, Math.ceil(Math.log(s) / Math.log(2))) + 1;
            maxArr = new int[size << 2];
            update = new boolean[size << 2];
            change = new int[size << 2];
        }

        public void update(int val, int L, int R) {
            update(val, L, R, 1, size - 1, 1);
        }

        private void update(int val, int L, int R, int l, int r, int index) {
            if (l != r) pushDown(index);
            if (L <= l && r <= R) {
                if (val > maxArr[index]) {
                    maxArr[index] = val;
                    update[index] = true;
                    change[index] = val;
                } else {
                    int mid = l + (r - l) / 2;
                    update(val, L, R, l, mid, index << 1);
                    update(val, L, R, mid + 1, r, index << 1 | 1);
                }
                return;
            }
            int mid = l + (r - l) / 2;
            if (L <= mid) {
                update(val, L, R, l, mid, index << 1);
            }
            if (mid < R) {
                update(val, L, R, mid + 1, r, index << 1 | 1);
            }
            maxArr[index] = Math.max(maxArr[index << 1], maxArr[index << 1 | 1]);
        }

        public int query(int index) {
            return query(index, 1, size - 1, 1);
        }

        private int query(int index, int l, int r, int curIndex) {
            if (l == r) return maxArr[curIndex];
            pushDown(curIndex);
            int mid = l + (r - l) / 2;
            if (index <= mid) {
                return query(index, l, mid, curIndex << 1);
            }
            return query(index, mid + 1, r, curIndex << 1 | 1);
        }

        private void pushDown(int index) {
            if (update[index]) {
                update[index] = false;
                update[index << 1] = true;
                update[index << 1 | 1] = true;

                change[index << 1] = change[index];
                change[index << 1 | 1] = change[index];

                maxArr[index << 1] = change[index];
                maxArr[index << 1 | 1] = change[index];
            }
        }
    }

    public static void main(String[] args) {
        _218_The_Skyline_Problem s = new _218_The_Skyline_Problem();
        s.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
    }
}
