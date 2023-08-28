package leetcode_questions.graph.topological_sort;

import java.util.*;

public class _2115_Find_All_Possible_Recipes_From_Given_Supplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int N = recipes.length;
        Set<String> allFood = new HashSet<>();
        for (int i = 0; i < N; i++) allFood.add(recipes[i]);

        Map<String, Integer> inMap = new HashMap<>();
        Map<String, List<String>> outMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            inMap.put(recipes[i], ingredients.get(i).size());
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                outMap.putIfAbsent(ingredients.get(i).get(j), new ArrayList<>());
                outMap.get(ingredients.get(i).get(j)).add(recipes[i]);
            }
        }

        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < supplies.length; i++) {
            queue.offer(supplies[i]);
        }

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (outMap.containsKey(cur)) {
                for (String next : outMap.get(cur)) {
                    inMap.put(next, inMap.get(next) - 1);
                    if (inMap.get(next) == 0) {
                        queue.offer(next);
                        if (allFood.contains(next)) {
                            res.add(next);
                        }
                    }
                }
            }
        }
        return res;
    }
}
