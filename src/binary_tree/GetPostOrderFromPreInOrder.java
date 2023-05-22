package binary_tree;

import java.util.HashMap;
import java.util.Map;

public class GetPostOrderFromPreInOrder {
    public static int[] getPostArr(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) return null;
        int N = pre.length;
        int[] post = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) map.put(in[i], i);
        set(map, pre, in, post, 0, N - 1, 0, N - 1, 0, N - 1);
        return post;
    }

    private static void set(Map<Integer, Integer> map, int[] pre, int[] in, int[] post, int prei, int prej,
                            int ini, int inj, int posti, int postj) {
        if (prei > prej) return;
        if (prei == prej) {
            post[posti] = post[prei];
            return;
        }
        post[postj] = pre[prei];
        int find = map.get(pre[prei]);
        set(map, pre, in, post, prei + 1, prei + find - ini,
                ini, find - 1, posti, posti + find - ini - 1);
        set(map, pre, in, post, prei + find - ini + 1, prej, find + 1, inj,
                posti + find - ini, postj - 1);

    }
}
