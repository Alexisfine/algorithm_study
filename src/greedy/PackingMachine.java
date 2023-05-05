package greedy;

public class PackingMachine {
    public static int MinOps(int[] arr) {
        if (arr == null || arr.length < 1) return 0;
        int size = arr.length;
        int sum = 0;
        for (int i = 0; i < size; i++) sum += arr[i];
        if (sum % size != 0) return -1;
        int avg = sum / size;
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            int leftRest = leftSum - avg * i;
            int rightRest = (sum - leftSum - arr[i]) - (size - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += arr[i];
        }
        return ans;
    }
}
