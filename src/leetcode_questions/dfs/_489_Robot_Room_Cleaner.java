package leetcode_questions.dfs;


import java.util.HashSet;
import java.util.Set;

public class _489_Robot_Room_Cleaner {
    Set<String> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        String code = 0 + "#" + 0;
        visited.add(code);
        dfs(robot, 0, 0, 0);
    }

    // 0: NORTH
    // 1: EAST
    // 2: SOUTH
    // 3: WEST
    private void dfs(Robot robot, int i, int j, int direction) {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        robot.clean();

        for (int k = 1; k <= 4; k++) {
            robot.turnRight();
            int nextDir = (direction + k) % 4;
            int x = i + dir[nextDir][0];
            int y = j + dir[nextDir][1];
            String code = x + "#" + y;
            if (!visited.contains(code) && robot.move()) {
                visited.add(code);
                dfs(robot, x, y, nextDir);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
        }
    }

    /*
    dfs(i, j, k) k: direction

    dfs(i, j, north) => turn right => dfs(i0, j0, east)
     */

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();

        // Clean the current cell.
        public void clean();
    }
}

