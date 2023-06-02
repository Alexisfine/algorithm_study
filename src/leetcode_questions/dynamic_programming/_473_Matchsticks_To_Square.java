package leetcode_questions.dynamic_programming;

public class _473_Matchsticks_To_Square {
    int[] matchsticks;
    int sideLength;
    // Time: O(4 ^ N)
    // Space: O(N)
    public boolean makeSquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        int sum = 0;
        this.sideLength = 0;
        int N = matchsticks.length;
        for (int i = 0; i < N; i++) sum += matchsticks[i];
        if (sum % 4 != 0) return false;
        sideLength = sum / 4;

        return process(0, 0, 0, 0, 0);
    }

    private boolean process(int index, int side1, int side2, int side3, int side4) {
        if (index == matchsticks.length) {
            return side1 == sideLength && side2 == sideLength && side3 == sideLength && side4 == sideLength;
        }

        boolean s = false;
        if (side1 + matchsticks[index] <= sideLength) {
            s = process(index + 1, side1 + matchsticks[index], side2, side3, side4);
            if (s) return true;
        }

        if (side2 + matchsticks[index] <= sideLength) {
            s = process(index + 1, side1, side2 + matchsticks[index], side3, side4);
            if (s) return true;
        }

        if (side3 + matchsticks[index] <= sideLength) {
            s = process(index + 1, side1, side2, side3 + matchsticks[index], side4);
            if (s) return true;
        }

        if (side4 + matchsticks[index] <= sideLength) {
            s = process(index + 1, side1, side2, side3, side4 + matchsticks[index]);
            if (s) return true;
        }
        return false;
    }

    public boolean makeSquare2(int[] matchsticks) {
        return false;
    }
}
