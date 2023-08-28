package leetcode_questions.dfs;

import java.util.HashMap;
import java.util.Map;

public class _291_Word_Pattern_II {
    Map<Character, String> charToStrMap = new HashMap<>();
    Map<String, Character> strToCharMap = new HashMap<>();
    public boolean wordPatternMatch(String pattern, String s) {
        return dfs(0, 0, pattern, s);
    }

    private boolean dfs(int i, int j, String pattern, String s) {
        if (i == pattern.length() && j == s.length()) return true;
        if (i == pattern.length() || j == s.length()) return false;

        char curChar = pattern.charAt(i);
        if (charToStrMap.containsKey(curChar)) {
            String str = charToStrMap.get(curChar);
            int len = str.length();
            if (j + len > s.length()) return false;
            if (!str.equals(s.substring(j, j + len))) {
                return false;
            }
            return dfs(i + 1, j + len, pattern, s);
        }

        StringBuilder sb = new StringBuilder();
        for (int index = j; index < s.length(); index++) {
            sb.append(s.charAt(index));
            String str = new String(sb);
            if (strToCharMap.containsKey(str)) continue;
            charToStrMap.put(curChar, str);
            strToCharMap.put(str, curChar);
            boolean flag = dfs(i + 1, index + 1, pattern, s);
            if (flag) return true;
            charToStrMap.remove(curChar);
            strToCharMap.remove(str);
        }
        return false;
    }


}
