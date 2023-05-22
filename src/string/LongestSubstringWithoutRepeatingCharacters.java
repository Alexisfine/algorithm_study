package string;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int maxNoRepeat(String string) {
        if (string == null || string.length() == 0) return 0;
        char[] str = string.toCharArray();

        // the position last time a char in ASCII occurs
        int[] map = new int[256];
        Arrays.fill(map, -1);

        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < map.length; i++) {
            pre = Math.max(pre, map[str[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[str[i]] = i;
        }
        return len;
    }
}
