package leetcode_questions.backtracking;

public class _44_Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        int indexS = 0;
        int indexP = 0;
        int star = -1;
        int match = 0;
        while (indexS < lenS) {
            if (indexP < lenP
                    && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
                indexS++;
                indexP++;
            } else if (indexP < lenP && p.charAt(indexP) == '*') {
                star = indexP;
                match = indexS;
                indexP++;
            } else if (star != -1) {
                indexP = star + 1;
                match++;
                indexS = match;
            } else {
                return false;
            }
        }
        while (indexP < lenP && p.charAt(indexP) == '*') indexP++;
        return indexP == lenP;
    }
}
