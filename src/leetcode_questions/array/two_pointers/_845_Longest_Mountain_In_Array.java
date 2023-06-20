package leetcode_questions.array.two_pointers;

public class _845_Longest_Mountain_In_Array {
    public int longestMountain(int[] arr) {
        int N = arr.length;
        if (N < 3) return 0;

        int maxMountain = 0;

        for (int i = 1; i <= N - 2;) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int counter = 1;
                int left = i;
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                    counter++;
                }
                while (i < N - 1 && arr[i] > arr[i + 1]) {
                    i++;
                    counter++;
                }
                maxMountain = Math.max(maxMountain, counter);
            } else i++;
        }
        return maxMountain;
    }
}
