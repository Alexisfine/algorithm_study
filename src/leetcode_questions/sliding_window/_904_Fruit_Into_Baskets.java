package leetcode_questions.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class _904_Fruit_Into_Baskets {
    public static int totalFruit(int[] fruits) {
        if (fruits.length < 2) return 1;
        Integer maxA = null;
        Integer maxB = null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            int tree = map.getOrDefault(fruits[i], 0) + 1;
            map.put(fruits[i], tree);
            if (maxA == null) maxA = i;
            else if (maxB == null) maxB = i;
            else if (tree > map.get(fruits[maxA])) maxA = i;
            else if (tree > map.get(fruits[maxB])) maxB = i;
        }
        return map.get(fruits[maxA]) + map.get(fruits[maxB]);
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));
    }


}
