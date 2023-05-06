package leetcode_questions.array;

public class _42_Trapping_Rain_Water {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int left = 1;
        int right = height.length - 2;
        int total = 0;
        while (left <= right) {
            if (maxLeft <= maxRight) {
                int extra = Math.max(0, maxLeft - height[left]);
                total += extra;
                maxLeft = Math.max(maxLeft, height[left++]);
            } else {
                int extra = Math.max(0, maxRight - height[right]);
                total += extra;
                maxRight = Math.max(maxRight, height[right--]);
            }
        }
        return total;
    }
}
