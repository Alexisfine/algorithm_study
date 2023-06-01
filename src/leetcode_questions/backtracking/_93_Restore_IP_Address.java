package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _93_Restore_IP_Address {
    String s;
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int ASCII = 48;
    int dots = 0;
    // Time: O(1)
    // Space: O(1)
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        process(0, 0, true);
        return list;
    }

    private void process(int index, int currentTotal, boolean prevDot) {
        if (index == s.length() && dots == 3 && sb.charAt(sb.length() - 1) != '.') {
            list.add(new String(sb));
            return;
        }
        if (index == s.length()) return;

        if (s.charAt(index) < '0' || s.charAt(index) > '9') return;
        currentTotal = currentTotal * 10 + s.charAt(index) - ASCII;
        if (currentTotal > 255) return;


        sb.append(s.charAt(index));

        // add dot
        dots++;
        sb.append('.');
        process(index + 1, 0, true);
        sb.deleteCharAt(sb.length() - 1);
        dots--;

        // not add dot
        if ((!(prevDot && s.charAt(index) == '0')) || index == s.length() - 1) {
            process(index + 1, currentTotal, false);
        }

        sb.deleteCharAt(sb.length() - 1);
    }
}
