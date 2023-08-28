package leetcode_questions.dfs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _996_Number_Of_Squareful_Arrays {
    List<List<Integer>> next = new ArrayList<>();
    boolean[] visited;
    int res = 0;
    public int numSquarefulPerms(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            next.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (Math.sqrt(nums[i] + nums[j]) == (int) Math.sqrt(nums[i] + nums[j])) {
                    next.get(i).add(j);
                }
            }
        }
        visited = new boolean[N];

        int last = -1;
        for (int i = 0; i < N; i++) {
            if (nums[i] == last) continue;
            visited[i] = true;
            dfs(nums, i, 1);
            last = nums[i];
            visited[i] = false;
        }
        return res;
    }

    private void dfs(int[] nums, int curPos, int count) {
        if (count == visited.length) res++;
        if (next.get(curPos).isEmpty()) return;
        int last = -1;
        for (int i : next.get(curPos)) {
            if (visited[i]) continue;
            if (nums[i] == last) continue;
            visited[i] = true;
            dfs(nums, i, count + 1);
            visited[i] = false;
            last = nums[i];
        }
    }

    /*
    X X X X X X
    find the two ending elements
     */
}
