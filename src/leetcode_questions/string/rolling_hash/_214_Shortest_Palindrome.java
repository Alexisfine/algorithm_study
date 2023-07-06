package leetcode_questions.string.rolling_hash;

public class _214_Shortest_Palindrome {
    // Method: Rolling Hash

    long modulo;
    long base;
    long[] power;
    public String shortestPalindrome(String s) {
        int N = s.length();
        if (N == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < N; i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }

        String newStr = new String(sb);
        N = newStr.length();
        base = 27;
        modulo = (long) 1e9 + 7;

        long[] leftHashMap = new long[N];
        long[] rightHashMap = new long[N];
        long hash = 0;
        for (int i = 0; i < N; i++) {
            long curNum = sb.charAt(i) == '#' ? 26 : sb.charAt(i) - 'a';
            hash = (hash * base + curNum) % modulo;
            leftHashMap[i] = hash;
        }
        hash = 0;
        for (int i = N - 1; i >= 0; i--) {
            long curNum = sb.charAt(i) == '#' ? 26 : sb.charAt(i) - 'a';
            hash = (hash * base + curNum) % modulo;
            rightHashMap[i] = hash;
        }

        power = new long[N];
        long pow = 1;
        for (int i = 0; i < N; i++) {
            pow = pow * base % modulo;
            power[i] = pow;
        }

        int cur = (int) Math.ceil((double) N / 2);
        int count = 0;
        for (int i = cur; i >= 0; i--) {
            if (isOK(newStr, i, leftHashMap, rightHashMap)) {
                for (int j = 0; j < i; j++) {
                    if (newStr.charAt(j) != '#') count--;
                }

                for (int j = i + 1; j < newStr.length(); j++) {
                    if (newStr.charAt(j) != '#') count++;
                }
                break;
            }
        }
        sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(s.charAt(s.length() - i - 1));
        }
        sb.append(s);
        return new String(sb);

    }

    private boolean isOK(String str, int mid, long[] leftHashMap, long[] rightHashMap) {
        int left = mid - 1;
        int right = mid + 1;
        if (left == -1) return true;

        int leftLen = left + 1;
        int rightLen = str.length() - right + 1;
        if (leftLen > rightLen) return false;

        long pow = power[leftLen - 1];

        long leftHash =
                ((rightHashMap[0] - (rightHashMap[left + 1] * pow))
                    % modulo + modulo) % modulo;

        long rightHash = ((leftHashMap[mid + leftLen] - leftHashMap[mid] * pow)
                    % modulo + modulo) % modulo;

        return leftHash == rightHash;
    }

}
