package leetcode_questions.array.two_pointers;

public class _556_Next_Greater_Element_III {
    public int nextGreaterElement(int n) {
        if (n == Integer.MAX_VALUE || n < 10) return -1;

        char[] chs = String.valueOf(n).toCharArray();
        int firstSmall = -1;
        for (int i = chs.length - 2; i >= 0; i--) {
            if (chs[i] < chs[i + 1]) {
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1) return -1;
        int firstLarge = -1;
        for (int i = chs.length - 1; i > firstSmall; i--) {
            if (chs[i] > chs[firstSmall]) {
                firstLarge = i;
                break;
            }
        }
        swap(chs, firstSmall, firstLarge);
        reverse(chs, firstSmall + 1, chs.length - 1);
        try {
            int res = Integer.parseInt(new String(chs));
            return res;
        } catch (Exception ex) {
            return -1;
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
}
