package leetcode_questions.greedy;

public class _670_Maximum_Swap {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int N = arr.length;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            char curMax = '0';
            int curMaxIndex = -1;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] >= curMax) {
                    curMax = arr[j];
                    curMaxIndex = j;
                    flag = true;
                }
            }
            if (flag && arr[i] < curMax) {
                arr[curMaxIndex] = arr[i];
                arr[i] = curMax;
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            res = res * 10 + (arr[i] - '0');
        }
        return res;
    }
}
