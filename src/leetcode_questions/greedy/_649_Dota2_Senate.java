package leetcode_questions.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class _649_Dota2_Senate {
    public String predictPartyVictory(String senate) {
        Deque<Integer> rDeque = new ArrayDeque<>();
        Deque<Integer> dDeque = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rDeque.addLast(i);
            } else {
                dDeque.addLast(i);
            }
        }
        while (!rDeque.isEmpty() && !dDeque.isEmpty()) {
            int rVal = rDeque.removeFirst();
            int dVal = dDeque.removeFirst();
            if (rVal > dVal) {
                dDeque.addLast(dVal + senate.length());
            } else {
                rDeque.addLast(rVal + senate.length());
            }
        }
        return dDeque.isEmpty() ? "Radiant" : "Dire";
    }
}
