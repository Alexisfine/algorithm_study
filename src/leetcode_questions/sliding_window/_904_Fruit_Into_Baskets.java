package leetcode_questions.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _904_Fruit_Into_Baskets {
    public static int totalFruit(int[] fruits) {
        int start = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int end = 0; end < fruits.length; end++) {
            map.put(fruits[end], end);
            while (map.size() > 2) {
                int lastOccurPos = map.get(fruits[start]);
                if (lastOccurPos == start) {
                    map.remove(fruits[start]);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }



}
