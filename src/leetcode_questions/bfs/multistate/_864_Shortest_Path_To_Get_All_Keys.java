package leetcode_questions.bfs.multistate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _864_Shortest_Path_To_Get_All_Keys {
    private record Info(int x, int y, int keys, int locks) {}
    public int shortestPathAllKeys(String[] grid) {
        int M = grid.length;
        int N = grid[0].length();
        int startX = 0;
        int startY = 0;
        int keys = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i].charAt(j) == '@') {
                    startX = i;
                    startY = j;
                }
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'z') {
                    keys++;
                }
            }
        }

        int finalState = 0;
        for (int i = 0; i < keys; i++) finalState |= (1 << i);

        int steps = -1;
        Queue<Info> queue = new LinkedList<>();
        Set<Info> visited = new HashSet<>();
        queue.offer(new Info(startX, startY, 0, 0));
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Info cur = queue.poll();
                for (int[] direction : directions) {
                    int nextX = cur.x + direction[0];
                    int nextY = cur.y + direction[1];
                    if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
                    char nextPos = grid[nextX].charAt(nextY);
                    if (nextPos == '#') continue;
                    int nextKeys = cur.keys;
                    int nextLocks = cur.locks;
                    if (nextPos >= 'A' && nextPos <= 'Z') {
                        if ((nextLocks & (1 << (nextPos - 'A'))) == 0) continue;
                    }
                    if (nextPos >= 'a' && nextPos <= 'z') {
                        nextKeys |= (1 << (nextPos - 'a'));
                        nextLocks |= (1 << (nextPos - 'a'));
                    }
                    if (nextKeys == finalState) return steps + 1;
                    Info next = new Info(nextX, nextY, nextKeys, nextLocks);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
