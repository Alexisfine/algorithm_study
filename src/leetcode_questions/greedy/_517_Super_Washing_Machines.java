package leetcode_questions.greedy;

public class _517_Super_Washing_Machines {
    // Time: O(N)
    // Space: O(1)
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length < 1) return 0;
        int sum = 0;
        int size = machines.length;
        for (int i = 0; i < size; i++) sum += machines[i];
        if (sum % size != 0) return -1;
        int avg = sum / size;
        int leftSum = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            int leftRest = leftSum - i * avg;
            int rightRest = (sum - leftSum - machines[i]) - (size - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                max = Math.max(max, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                max = Math.max(max, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += machines[i];
        }
        return max;
    }
}
