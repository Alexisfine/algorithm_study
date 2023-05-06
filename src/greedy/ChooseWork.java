package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class ChooseWork {
    public static class Job {
        int money;
        int difficulty;
        public Job(int money, int difficulty) {
            this.money = money;
            this.difficulty = difficulty;
        }
    }
    public static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            if (o1.difficulty != o2.difficulty) return o1.difficulty - o2.difficulty;
            else return o2.money = o1.money;
        }
    }

    public static int[] getMoney(Job[] jobs, int[] ability) {
        Arrays.sort(jobs, new JobComparator());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(jobs[0].difficulty, jobs[0].money);
        Job pre = jobs[0];
        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i].difficulty != jobs[i-1].difficulty) {
                pre = jobs[i];
                map.put(jobs[i].difficulty, jobs[i].money);
            }
        }
        int[] ans = new int[ability.length];
        for (int i = 0; i < ans.length; i++) {
            Integer key = map.floorKey(ability[i]);
            ans[i] = key == null ? 0 : map.get(key);
        }
        return ans;
    }
}
