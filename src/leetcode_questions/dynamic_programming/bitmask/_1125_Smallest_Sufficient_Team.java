package leetcode_questions.dynamic_programming.bitmask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1125_Smallest_Sufficient_Team {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int N = (1 << n);
        int[] dp = new int[N];
        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE / 2;
        }
        List<List<Integer>> saves = new ArrayList<>(N); // saves[skillSet] is the member ids for skillSet
        for (int i = 0; i < N; i++) {
            saves.add(new ArrayList<>());
        }
        Map<String, Integer> skillToIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillToIndexMap.put(req_skills[i], i);
        }
        int[] peopleToSkill = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int skillSet = 0;
            for (String skill : people.get(i)) {
                if (!skillToIndexMap.containsKey(skill)) continue;
                int index = skillToIndexMap.get(skill);
                skillSet += (1 << index);
            }
            peopleToSkill[i] = skillSet;
        }

        for (int i = 0; i < people.size(); i++) {
            var dp2 = dp;
            for (int skillSet = 0; skillSet < N; skillSet++) {
                int newSkillSet = skillSet | peopleToSkill[i];
                if (dp2[newSkillSet] > dp[skillSet] + 1) {
                    dp2[newSkillSet] = dp[skillSet] + 1;
                    saves.set(newSkillSet, new ArrayList<>(saves.get(skillSet)));
                    saves.get(newSkillSet).add(i);
                }
            }
            dp = dp2;
        }
        return saves.get(N - 1).stream().mapToInt(Integer::intValue).toArray();
    }
}
