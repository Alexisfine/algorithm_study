package union_find;

public class QuickFindUF{
    // initialize: O(n)
    // union: O(n)
    // find: O(1)

    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        // set each number's id to itself
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == qid) id[i] = pid;
        }
    }
}
