package leetcode_questions.greedy;

import java.util.Arrays;

public class _881_Boats_To_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int lo = 0;
        int hi = people.length - 1;
        while (lo < hi) {
            int sum = people[lo] + people[hi];
            if (people[hi] == limit || sum > limit) {
                boats++;
                hi--;
            } else {
                boats++;
                lo++;
                hi--;
            }
        }
        if (lo == hi) boats++;
        return boats;
    }
}
