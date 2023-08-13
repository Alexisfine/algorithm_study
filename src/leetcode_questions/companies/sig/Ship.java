package leetcode_questions.companies.sig;

import java.util.HashMap;
import java.util.Map;

public class Ship {
    public String[] solve(char[][] grid, int[][] shots) {
        Map<Character, Integer> map = new HashMap<>();
        int N = shots.length;
        String[] res = new String[N];
        for (int i = 0; i < N; i++) {
            int x = shots[i][0];
            int y = shots[i][1];
            if (grid[x][y] == '.') {
                res[i] = "Missed";
                continue;
            } else if (grid[x][y] == '@') {
                res[i] = "Already attacked";
                continue;
            }
            if (!map.containsKey(grid[x][y])) {
                search(grid, x, y, map);
            }
            int curVal = map.get(grid[x][y]) - 1;
            if (curVal == 0) {
                res[i] = "Ship " + grid[x][y] + " sunk";
            } else {
                res[i] = "Attacked ship " + grid[x][y];
                map.put(grid[x][y], map.get(grid[x][y]) - 1);
            }
            grid[x][y] = '@';
        }
        return res;
    }

    private void search(char[][] grid, int x, int y, Map<Character, Integer> map) {
        int M = grid.length;
        int N = grid[0].length;
        char sym = grid[x][y];
    }
}
