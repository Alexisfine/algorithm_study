package leetcode_questions.greedy;

public class _1642_Furthest_Building_You_Can_Reach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights.length == 0) return 0;
        int pos = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                if (bricks >= heights[i] - heights[i - 1]) {
                    bricks -= heights[i] - heights[i - 1];
                } else if (ladders > 0) {
                    ladders--;
                } else {
                    break;
                }
            }
            pos++;
        }
        return pos;
    }
}
