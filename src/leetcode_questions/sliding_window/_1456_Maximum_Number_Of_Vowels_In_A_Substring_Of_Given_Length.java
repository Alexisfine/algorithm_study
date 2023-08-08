package leetcode_questions.sliding_window;

public class _1456_Maximum_Number_Of_Vowels_In_A_Substring_Of_Given_Length {
    public int maxVowels(String s, int k) {
        int vowels = 0;
        int maxVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s, i)) vowels++;
        }
        maxVowels = vowels;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s, i - k)) vowels--;
            if (isVowel(s, i)) vowels++;
            maxVowels = Math.max(maxVowels, vowels);
        }
        return maxVowels;
    }

    private boolean isVowel(String s, int index) {
        char c = s.charAt(index);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
