package leetcode_questions.others.count_subarray_by_element;


import java.util.Arrays;
import java.util.Stack;

public class _907_Sum_Of_Subarray_Minimums {
    public int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        long mod = (long) 1e9 + 7;
        int[] prevSmallerElement = new int[N];
        int[] nextSmallerElement = new int[N];
        Arrays.fill(prevSmallerElement, -1);
        Arrays.fill(nextSmallerElement, N);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextSmallerElement[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                prevSmallerElement[stack.pop()] = i;
            }
            stack.push(i);
        }

        long res = 0;
        for (int i = 0; i < N; i++) {
            res += (long) arr[i] * (i - prevSmallerElement[i]) * (nextSmallerElement[i] - i);
        }

        return (int) (res % mod);
    }

    /*
    X X 2 6 4 6 5 1 X
        a   b     c
    score for arr[b]: 4*(b-a)*(c-b)
    find prev smaller element and next smaller element

    next smaller element:
    Maintain a monotonic stack ascending
    1 3 5 7 OK
    1 3 5 7 2 -> next smaller element of 7 is 2, pop 7, add 2
    1 3 5 2

    duplicate elements
    2 [8 5 6 5 7 5] 2
    约定：若干个相同元素 => prev smaller or equal to
     */
}
