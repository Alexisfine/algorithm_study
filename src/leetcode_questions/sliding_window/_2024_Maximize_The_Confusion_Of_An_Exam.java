package leetcode_questions.sliding_window;

public class _2024_Maximize_The_Confusion_Of_An_Exam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max
                (maxConsecutiveAnswers(answerKey, k, 'T'),
                        maxConsecutiveAnswers(answerKey, k, 'F'));
    }

    private int maxConsecutiveAnswers(String answerKey, int k, char t) {
        int N = answerKey.length();
        int maxConsec = 0;
        int usedK = 0;
        int curMax = 0;
        int start = 0;
        for (int end = 0; end < N; end++) {
            if (answerKey.charAt(end) != t) {
                if (usedK < k) {
                    usedK++;
                    curMax++;
                    maxConsec = Math.max(curMax, maxConsec);
                } else {
                    while (usedK >= k) {
                        if (answerKey.charAt(start) != t) {
                            usedK--;
                        }
                        curMax--;
                        start++;
                    }
                    usedK++;
                    curMax++;
                    maxConsec = Math.max(curMax, maxConsec);
                }
            } else {
                curMax++;
                maxConsec = Math.max(curMax, maxConsec);
            }
        }
        return maxConsec;
    }
}
