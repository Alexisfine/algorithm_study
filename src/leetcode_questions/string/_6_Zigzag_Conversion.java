package leetcode_questions.string;

public class _6_Zigzag_Conversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int groupSize = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int j = 0;
                while (groupSize * j + i < s.length()) {
                    sb.append(s.charAt(groupSize * j + i));
                    j++;
                }
            } else {
                int j = 0;
                while (groupSize * j + i < s.length()) {
                    sb.append(s.charAt(groupSize * j + i));
                    int complement = groupSize - i;
                    if (groupSize * j + complement < s.length()) {
                        sb.append(s.charAt(groupSize * j + complement));
                    }
                    j++;
                }
            }
        }
        return sb.toString();
    }
}
