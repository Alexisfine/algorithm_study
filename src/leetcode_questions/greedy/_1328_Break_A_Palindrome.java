package leetcode_questions.greedy;

public class _1328_Break_A_Palindrome {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len == 1) return "";

        int endPoint = len / 2 - 1;
        char[] newCharArr = palindrome.toCharArray();
        boolean isPalindrome = true;
        for (int i = 0; i <= endPoint; i++) {
            if (newCharArr[i] != 'a') {
                newCharArr[i] = 'a';
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) newCharArr[len - 1] = 'b';
        return new String(newCharArr);
    }
}
