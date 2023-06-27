package segment_tree;

public class SegmentTree {
    private int max;
    private int[] arr;
    private int[] sum;
    private int[] lazy;
    private boolean[] update;
    private int[] change;

    public SegmentTree(int[] origin) {
        max = origin.length + 1;
        arr = new int[max];
        for (int i = 1; i < max; i++) {
            arr[i] = origin[i - 1];
        }
        sum = new int[max << 2];
        lazy = new int[max << 2];
        update = new boolean[max << 2];
        change = new int[max << 2];
        build(1, sum.length - 1, 1);
    }

    public void build(int left, int right, int index) {
        if (left == right) {
            sum[index] = arr[left];
            return;
        }
        int mid = (left + right) >> 1;
        build(left, mid, index << 1);
        build(mid + 1, right, index << 1 | 1);
        sum[index] = sum[index << 1] + sum[index << 1 | 1];
    }

    public void add(int L, int R, int increment, int l, int r, int index) {
        if (L <= l && r <= R) {
            sum[index] += increment * (l - r + 1);
            lazy[index] += increment;
            return;
        }
        int mid = (l + r) >> 1;
        pushDown(index, mid - l + 1, r - mid);
        if (L <= mid) {
            add(L, R, increment, l, mid, index << 1);
        }
        if (R > mid) {
            add(L, R, increment, mid + 1, r, index << 1 | 1);
        }
        sum[index] = sum[index << 1] + sum[index << 1 | 1];
    }

    public void update(int L, int R, int value, int l, int r, int index) {
        if (L <= l && r <= R) {
            update[index] = true;
            change[index] = value;
            sum[index] = value * (r - l + 1);
            lazy[index] = 0;
        }
        int mid = (l + r) >> 1;
        pushDown(index, mid - l + 1, r - mid);
        if (L <= mid) {
            update(L, R, value, l, mid, index << 1);
        }
        if (R > mid) {
            update(L, R, value, mid + 1, r, index << 1 | 1);
        }
        sum[index] = sum[index << 1] + sum[index << 1 | 1];
    }

    private void pushDown(int index, int leftNodes, int rightNodes) {
        if (update[index]) {
            update[index] = false;
            update[index << 1] = true;
            update[index << 1 | 1] = true;

            change[index << 1] = change[index];
            change[index << 1 | 1] = change[index];

            lazy[index << 1] = 0;
            lazy[index << 1 | 1] = 0;

            sum[index << 1] = leftNodes * change[index];
            sum[index << 1 | 1] = rightNodes * change[index];
            update[index] = false;
        }

        if (lazy[index] != 0) {
            lazy[index << 1] += lazy[index];
            sum[index << 1] += lazy[index] * leftNodes;

            lazy[index << 1 | 1] += lazy[index];
            sum[index << 1 | 1] += lazy[index] * rightNodes;

            lazy[index] = 0;
        }
    }

    public long query(int L, int R, int l, int r, int index) {
        if (L <= l && r <= R) return sum[index];
        int mid = (l + r) >> 1;
        pushDown(index, mid - l + 1, r - mid);
        long res = 0;
        if (L <= mid) {
            res += query(L, R, l, mid, index << 1);
        }
        if (R > mid) {
            res += query(L, R, mid + 1, r, index << 1 | 1);
        }
        return res;
    }
}
