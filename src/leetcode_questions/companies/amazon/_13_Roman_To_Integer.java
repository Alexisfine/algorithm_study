package leetcode_questions.companies.amazon;

import java.util.Map;

public class _13_Roman_To_Integer {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X',
                10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if (i == s.length() - 1) {
                res += map.get(s.charAt(i));
                i++;
                continue;
            }
            int cur = map.get(s.charAt(i));
            int next = map.get(s.charAt(i + 1));
            if (cur >= next) {
                res += cur;
                i++;
            } else {
                res += next - cur;
                i += 2;
            }
        }
        return res;
    }
}
