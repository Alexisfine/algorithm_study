package leetcode_questions.greedy;

import java.util.HashMap;
import java.util.Map;

public class _2244_Minimum_Rounds_To_Complete_All_Tasks {
    public int minimumRounds(int[] tasks) {
        int rounds = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int times = entry.getValue();
            if (times == 1) return -1;
            rounds += times / 3;
            if (times % 3 != 0) rounds++;
        }
        return rounds;
    }
}
