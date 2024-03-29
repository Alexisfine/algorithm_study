package leetcode_questions.array.two_pointers;

public class _11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, curArea);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
