package leetcode_questions.array.two_pointers;

public class _161_One_Edit_Distance {
    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (Math.abs(len1 - len2) > 1) return false;

        if (len1 == len2) {
            int p1 = 0;
            int p2 = 0;
            int diff = 0;
            while (p1 < len1) {
                if (s.charAt(p1++) != t.charAt(p2++)) diff++;
            }
            return diff == 1;
        }

        int p1 = 0;
        int p2 = 0;

        if (len1 + 1 == len2) {
            boolean hasInserted = false;
            while (p2 < len2) {
                if (p1 == len1) return !hasInserted;
                if (s.charAt(p1) != t.charAt(p2)) {
                    if (hasInserted) return false;
                    hasInserted = true;
                    p2++;
                } else {
                    p1++;
                    p2++;
                }
            }
            return true;
        } else {
            boolean hasInserted = false;
            while (p1 < len1) {
                if (p2 == len2) return !hasInserted;
                if (s.charAt(p1) != t.charAt(p2)) {
                    if (hasInserted) return false;
                    hasInserted = true;
                    p1++;
                } else {
                    p1++;
                    p2++;
                }
            }
            return true;
        }
    }
}
