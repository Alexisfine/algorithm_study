package leetcode_questions.companies.amazon;


import java.util.Stack;

public class _84_Largest_Rectangle_In_Histogram {
    public record Pair(int index, int height) {}
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                Pair pair = stack.pop();
                maxArea = Math.max(maxArea, pair.height * (i - pair.index));
                start = pair.index;
            }
            stack.push(new Pair(start, heights[i]));
        }
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - pair.index) * pair.height);
        }
        return maxArea;
    }
}
