package leetcode_questions.dfs;

import java.util.ArrayList;
import java.util.List;

public class _282_Expression_Add_Operators {
    List<String> res = new ArrayList<>();
    String num;
    long target;
    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        dfs(0, 0, 0, new StringBuilder());
        return res;
    }

    private void dfs(int curPos, long preVal, long lastVal, StringBuilder preStr) {
        if (curPos == num.length()) {
            if (preVal == target) {
                res.add(new String(preStr));
            }
            return;
        }

        for (int i = curPos + 1; i <= num.length(); i++) {
            String curStr = num.substring(curPos, i);
            if (curStr.length() > 1 && curStr.charAt(0) == '0') continue;
            long longVal = Long.parseLong(curStr);

            if (curPos == 0) {
                preStr.append(curStr);
                dfs(i, longVal, longVal, preStr);
                preStr.delete(preStr.length() - curStr.length(), preStr.length());
                continue;
            }

            // addition
            preStr.append('+');
            preStr.append(curStr);
            dfs(i, preVal + longVal, longVal, preStr);
            preStr.delete(preStr.length() - 1 - curStr.length(), preStr.length());

            // subtraction
            preStr.append('-');
            preStr.append(curStr);
            dfs(i, preVal - longVal, -longVal, preStr);
            preStr.delete(preStr.length() - 1 - curStr.length(), preStr.length());

            // multiplication
            preStr.append('*');
            preStr.append(curStr);
            dfs(i, preVal - lastVal + lastVal * longVal, lastVal * longVal, preStr);
            preStr.delete(preStr.length() - 1 - curStr.length(), preStr.length());
        }
    }
}
