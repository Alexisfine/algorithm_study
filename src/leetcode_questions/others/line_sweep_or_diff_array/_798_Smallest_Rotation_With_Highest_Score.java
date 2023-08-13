package leetcode_questions.others.line_sweep_or_diff_array;

public class _798_Smallest_Rotation_With_Highest_Score {
    public int bestRotation(int[] nums) {
        int N = nums.length;
        int[] diff = new int[N];
        for (int i = 0; i < N; i++) {
            if (nums[i] <= i) {
                diff[0]++;
                diff[(i - nums[i] + 1) % N]--;
                diff[(i + 1) % N]++;
            } else {
                diff[0] += 0;
                diff[(i + 1) % N]++;
                diff[(i + 1 + N - nums[i]) % N]--;
            }
        }

        int score = 0;
        int maxScore = 0;
        int index = 0;
        for (int k = 0; k < N; k++) {
            score += diff[k];
            if (score > maxScore) {
                maxScore = score;
                index = k;
            }
        }
        return index;
    }
    /*
    0 1 2 3 4 5 6
    X X X X 2 X X
    k = 0 -> 1
    k = 1 -> 1
    k = 2 -> 1
    k = 3 -> 0
    k = 4 -> 0
    k = 5 -> 1
    k = 6 -> 1

    if A[i] <= i:
        1111... until i - A[i] - 1 0000...

    diff[i] the score difference between k step and k - 1 step
    diff[0] += 1;
    diff[3] -= 1;
    diff[5] += 1;

    if A[i] > i:
    0 1 2 3 4 5 6
    X X 3 X X X X

    00... 0:i
    11... i+1
    00... i+1+N-A[i]
     */
}
