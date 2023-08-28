package leetcode_questions.dfs;


import java.util.Arrays;

public class _473_Matchsticks_To_Square {
    int sideLength;
    boolean[] visited;
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int stick : matchsticks) sum += stick;
        if (sum % 4 != 0) return false;
        sideLength = sum / 4;
        visited = new boolean[matchsticks.length];
        Arrays.sort(matchsticks);
        return dfs(matchsticks, 0, 0, 0);
    }

    private boolean dfs(int[] matchsticks, int index, int group, int sum) {
        if (group == 4) return true;
        if (sum > sideLength) return false;
        if (sum == sideLength) {
            return dfs(matchsticks, 0, group + 1, 0);
        }

        int last = -1;
        for (int i = index; i < matchsticks.length; i++) {
            if (visited[i]) continue;
            if (last == matchsticks[i]) continue;
            visited[i] = true;
            last = matchsticks[i];
            boolean flag = dfs(matchsticks, i + 1, group, sum + matchsticks[i]);
            if (flag) return true;
            visited[i] = false;
        }
        return false;
    }
}
